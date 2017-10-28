package view;

import controller.MainController;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;


public class SelectServiceViewController implements Initializable{
    @FXML private Label lbLogout;
    @FXML private ImageView imvCredits;
    @FXML private ImageView imvTransaction;
    private MainController controller;
    private StageController stageController;

    public void onClickLogout(){
        stageController.showMainView();
    }

    public void onClickCredits(){
        stageController.showSelectGameView();
    }

    public void onClickTransaction(){

    }
    public void setStageController(StageController stageController) {
        this.stageController = stageController;
    }

    public void setController(MainController controller) {
        this.controller = controller;
        lbLogout.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                onClickLogout();
            }
        });

        imvCredits.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                onClickCredits();
            }
        });

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
