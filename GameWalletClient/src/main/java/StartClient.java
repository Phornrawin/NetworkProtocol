import controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import view.MainViewController;
import view.StageController;

import java.io.IOException;

public class StartClient extends Application {
    private Stage primaryStage;
    private MainViewController mainView;
    private Pane mainLayout;
    private StageController stageController;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Game Wallet");
        MainController controller = new MainController();
        this.stageController = new StageController();
        stageController.setPrimaryStage(primaryStage);
        stageController.setController(controller);
        stageController.showMainView();

    }

}
