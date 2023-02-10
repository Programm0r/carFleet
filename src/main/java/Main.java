import db.MongoDBConnector;
import javafx.application.Application;
import javafx.stage.Stage;
import ui.StartScreen;

public class Main extends Application {

    @Override
    public void start(Stage stage){
        new StartScreen(stage);
        MongoDBConnector.connectToDatabase();
    }

    public static void main(String[] args){
        launch();
    }
}
