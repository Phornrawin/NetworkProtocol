import controller.MainController;
import javafx.application.Application;
import javafx.stage.Stage;

public class StartCilent extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        MainController controller = new MainController();
        controller.StartApplication();

    }
}
