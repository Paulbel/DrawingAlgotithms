package drawing;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DrawingApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../resources/main.fxml"));
        primaryStage.setTitle("ГИИС");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }
}
