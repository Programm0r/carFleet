package ui;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class StartScreen {

    private Label label;
    private Button button;
    public StartScreen(Stage startScreenStage) {
        createScene(startScreenStage);
    }

    private void createScene(Stage startScreenStage) {
        Scene startScreenScene = new Scene(createStartPane(),640, 300);
        startScreenStage.setScene(startScreenScene);
        startScreenStage.show();
    }

    private Parent createStartPane() {
        Pane pane = new Pane();
        addComponentsToPane(pane);
        addLayout(pane);
        return pane;
    }

    private void addComponentsToPane(Pane pane) {
        label = new Label("Carfleet Manager");
        button = new Button("Manage Cars");
        styleComponents();
        pane.getChildren().add(label);
        pane.getChildren().add(button);
        listenOnActions();
    }

    private void styleComponents() {
        label.setStyle("-fx-font-weight: bold; -fx-font-size: 20; -fx-text-fill: black");
        button.setStyle("-fx-font-weight: bold; -fx-font-size: 15; -fx-text-fill: black");
    }

    private void listenOnActions() {
        button.setOnAction(event -> {
            Stage manageCarsStage = new Stage();
            new MangeCars(manageCarsStage);
        });
    }

    private void addLayout(Pane pane) {
        pane.getChildren().get(0).setLayoutX(250);
        pane.getChildren().get(0).setLayoutY(50);
        pane.getChildren().get(1).setLayoutX(270);
        pane.getChildren().get(1).setLayoutY(170);
    }
}
