package ui;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MangeCars {
    public MangeCars(Stage manageCarsStage){
        createScene(manageCarsStage);
    }

    private void createScene(Stage manageCarsStage) {
        Scene manageCarsScene = new Scene(createManageCarsPane(),640, 300);
        manageCarsStage.setScene(manageCarsScene);
        manageCarsStage.show();
    }

    private Parent createManageCarsPane() {
        Pane pane = new Pane();
        addComponentsToPane(pane);
        addLayout(pane);
        return pane;
    }

    private void addComponentsToPane(Pane pane) {
        Label headingLabel = new Label("Car Management");
        Button addButton = new Button("Add car");
        Button deletebutton = new Button("Delete car");
        styleComponents(headingLabel,addButton,deletebutton);
        pane.getChildren().add(headingLabel);
        pane.getChildren().add(addButton);
        pane.getChildren().add(deletebutton);
        listenOnAddAction(addButton);
    }

    private void styleComponents(Label label, Button addButton, Button deletebutton) {
        label.setStyle("-fx-font-weight: bold; -fx-font-size: 20; -fx-text-fill: black");
        addButton.setStyle("-fx-font-weight: bold; -fx-font-size: 15; -fx-text-fill: black");
        deletebutton.setStyle("-fx-font-weight: bold; -fx-font-size: 15; -fx-text-fill: black");
    }

    private void listenOnAddAction(Button button) {
        button.setOnAction(event -> {
            Stage addCarStage = new Stage();
            new AddCar(addCarStage);
        });
    }

    private void addLayout(Pane pane) {
        pane.getChildren().get(0).setLayoutX(250);
        pane.getChildren().get(0).setLayoutY(50);
        pane.getChildren().get(1).setLayoutX(230);
        pane.getChildren().get(1).setLayoutY(170);
        pane.getChildren().get(2).setLayoutX(350);
        pane.getChildren().get(2).setLayoutY(170);
    }
}
