package ui;

import com.mongodb.client.MongoDatabase;
import db.MongoDBConnector;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Car;
import org.bson.Document;

public class AddCar {
    private Label headingLabel;
    private Label brandName;
    private TextField brandNameTextField;
    private Label modelName;
    private TextField modelNameTextField;
    private Label modelPrice;
    private TextField modelPriceTextField;
    private Label modelYear;
    private DatePicker modelYearDatepicker;
    private Label rangeDriven;
    private TextField rangeDrivenTextField;
    private Label isDamaged;
    private CheckBox damagesCheckbox;
    private Button createButton;
    public AddCar(Stage addCarStage) {
        createScene(addCarStage);
    }

    private void createScene(Stage addCarStage) {
        Scene addCarScene = new Scene(createAddCarsPane(),500, 500);
        addCarStage.setScene(addCarScene);
        addCarStage.show();
    }

    private Parent createAddCarsPane() {
        Pane pane = new Pane();
        addComponentsToPane(pane);
        addLayout(pane);
        return pane;
    }

    private void addComponentsToPane(Pane pane) {
        headingLabel = new Label("Add car");
        brandName = new Label("Brand Name:");
        brandNameTextField = new TextField();
        modelName = new Label("Model Name:");
        modelNameTextField = new TextField();
        modelPrice = new Label("Model Price:");
        modelPriceTextField = new TextField();
        modelYear = new Label("Model year:");
        modelYearDatepicker = new DatePicker();
        rangeDriven = new Label("Range driven:");
        rangeDrivenTextField = new TextField();
        isDamaged = new Label("Damages:");
        damagesCheckbox = new CheckBox();
        createButton = new Button("create");
        styleComponents();
        pane.getChildren().add(headingLabel);
        pane.getChildren().add(brandName);
        pane.getChildren().add(brandNameTextField);
        pane.getChildren().add(modelName);
        pane.getChildren().add(modelNameTextField);
        pane.getChildren().add(modelPrice);
        pane.getChildren().add(modelPriceTextField);
        pane.getChildren().add(modelYear);
        pane.getChildren().add(modelYearDatepicker);
        pane.getChildren().add(rangeDriven);
        pane.getChildren().add(rangeDrivenTextField);
        pane.getChildren().add(isDamaged);
        pane.getChildren().add(damagesCheckbox);
        pane.getChildren().add(createButton);
        listenOnCreateAction(createButton);
    }

    private void styleComponents() {
        headingLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 20; -fx-text-fill: black");
        brandName.setStyle("-fx-font-weight: bold; -fx-font-size: 20; -fx-text-fill: black");
        modelName.setStyle("-fx-font-weight: bold; -fx-font-size: 20; -fx-text-fill: black");
        modelPrice.setStyle("-fx-font-weight: bold; -fx-font-size: 20; -fx-text-fill: black");
        modelYear.setStyle("-fx-font-weight: bold; -fx-font-size: 20; -fx-text-fill: black");
        rangeDriven.setStyle("-fx-font-weight: bold; -fx-font-size: 20; -fx-text-fill: black");
        isDamaged.setStyle("-fx-font-weight: bold; -fx-font-size: 20; -fx-text-fill: black");
        createButton.setStyle("-fx-font-weight: bold; -fx-font-size: 15; -fx-text-fill: black");
    }

    private void listenOnCreateAction(Button button) {
        button.setOnAction(event -> {
            if(isTextfieldsNotEmpty()){
                Car car = new Car();
                car.setBrandName(brandNameTextField.getText());
                car.setModelName(modelNameTextField.getText());
                car.setModelPrice(Double.parseDouble(modelPriceTextField.getText()));
                car.setModelYear(modelYearDatepicker.getValue().toString());
                car.setRangeDriven(Double.parseDouble(rangeDrivenTextField.getText()));
                car.setDamages(Boolean.getBoolean(damagesCheckbox.getText()));

                MongoDatabase database = MongoDBConnector.getDatabase("car_fleet");
                MongoDBConnector.setCollection("car",database);

                Document carDocument = new Document();
                carDocument.append("brand_name", car.getBrandName());
                carDocument.append("model_name", car.getModelName());
                carDocument.append("model_price", car.getModelPrice());
                carDocument.append("model_year", car.getModelYear());
                carDocument.append("range_driven", car.getRangeDriven());
                carDocument.append("damages", car.isDamages());

                MongoDBConnector.getCollection("car").insertOne(carDocument);
                System.out.println("Document inserted successfully");

                clearFields();
            }
        });
    }

    private boolean isTextfieldsNotEmpty() {
        return
                !brandNameTextField.getText().isBlank() &&
                !modelNameTextField.getText().isBlank() &&
                !modelPriceTextField.getText().isBlank() &&
                !modelYearDatepicker.getValue().toString().isBlank() &&
                !rangeDrivenTextField.getText().isBlank() &&
                !damagesCheckbox.isSelected();
    }

    private void clearFields() {
        brandNameTextField.setText("");
        modelNameTextField.setText("");
        modelPriceTextField.setText("");
        rangeDrivenTextField.setText("");
        damagesCheckbox.setText("");
    }

    private void addLayout(Pane pane) {
        pane.getChildren().get(0).setLayoutX(210);
        pane.getChildren().get(0).setLayoutY(50);
        pane.getChildren().get(1).setLayoutX(50);
        pane.getChildren().get(1).setLayoutY(100);
        pane.getChildren().get(2).setLayoutX(180);
        pane.getChildren().get(2).setLayoutY(100);
        pane.getChildren().get(3).setLayoutX(50);
        pane.getChildren().get(3).setLayoutY(150);
        pane.getChildren().get(4).setLayoutX(180);
        pane.getChildren().get(4).setLayoutY(150);
        pane.getChildren().get(5).setLayoutX(50);
        pane.getChildren().get(5).setLayoutY(200);
        pane.getChildren().get(6).setLayoutX(180);
        pane.getChildren().get(6).setLayoutY(200);
        pane.getChildren().get(7).setLayoutX(50);
        pane.getChildren().get(7).setLayoutY(250);
        pane.getChildren().get(8).setLayoutX(180);
        pane.getChildren().get(8).setLayoutY(250);
        pane.getChildren().get(9).setLayoutX(50);
        pane.getChildren().get(9).setLayoutY(300);
        pane.getChildren().get(10).setLayoutX(180);
        pane.getChildren().get(10).setLayoutY(300);
        pane.getChildren().get(11).setLayoutX(50);
        pane.getChildren().get(11).setLayoutY(350);
        pane.getChildren().get(12).setLayoutX(180);
        pane.getChildren().get(12).setLayoutY(355);
        pane.getChildren().get(13).setLayoutX(225);
        pane.getChildren().get(13).setLayoutY(420);
    }
}
