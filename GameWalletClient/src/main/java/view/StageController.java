package view;

import controller.MainController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import protocol.Protocol;

import java.io.IOException;
import java.util.Map;

public class StageController {
    private Stage primaryStage;
    private MainController controller;

    public void showMainView(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/MainView.fxml"));
            Pane mainLayout = loader.load();
            MainViewController mainView = loader.getController();
            mainView.setController(controller);
            mainView.setStageController(this);

            Scene scene = new Scene(mainLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showSelectView(){
        System.out.println("show select view...");
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainViewController.class.getResource("/SelectServiceView.fxml"));
            Pane layout = loader.load();
            SelectServiceViewController selectView = loader.getController();
            selectView.setController(controller);
            selectView.setStageController(this);


            Scene scene = new Scene(layout);
            primaryStage.setScene(scene);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showSelectGameView(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(SelectServiceViewController.class.getResource("/SelectGameView.fxml"));
            Pane layout = loader.load();
            SelectGameViewController gameView = loader.getController();
            gameView.setController(controller);
            gameView.setStageController(this);

            Scene scene = new Scene(layout);
            primaryStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void showPaymentView(String gamename, String amount, String gamePackage){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(SelectServiceViewController.class.getResource("/PaymentView.fxml"));
            Pane layout = loader.load();
            PaymentViewController paymentView = loader.getController();
            paymentView.setController(controller);
            paymentView.setStageController(this);
            paymentView.getLbGamename().setText(gamename);
            paymentView.getLbTotal().setText(amount);
            paymentView.getLbAmount().setText(amount);
            paymentView.setGamePackage(gamePackage);


            Scene scene = new Scene(layout);
            primaryStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void setController(MainController controller) {
        this.controller = controller;
    }
}
