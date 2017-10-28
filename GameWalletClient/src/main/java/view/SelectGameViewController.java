package view;

import Model.Package;
import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import controller.MainController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SelectGameViewController implements Initializable{
    @FXML private ChoiceBox cbGame;
    @FXML private ChoiceBox cbPackage;
    @FXML private TextField tfID;
    @FXML private Label lbTotal;
    @FXML private Button btnNext;
    @FXML private Label lbCurrency;
    private MainController controller;
    private StageController stageController;



    public void setChoicboxPackage(){
        cbGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String game = (String) cbGame.getValue();
                cbPackage.getItems().clear();
                System.out.println(cbPackage.toString());
                if("League of Legends".equals(game)){
                    cbPackage.getItems().addAll(Package.LoLPackage.rpList);
                    lbCurrency.setText("RP");
                    System.out.println(Package.LoLPackage.currency);
                }else if("Heroes of Newerth".equals(game)){
                    cbPackage.getItems().addAll(Package.HonPackage.gcList);
                    lbCurrency.setText(Package.HonPackage.currency);
                }else if("Blade & Soul".equals(game)){
                    cbPackage.getItems().addAll(Package.BnsPackage.dmList);
                    lbCurrency.setText(Package.BnsPackage.currency);
                }else if("Vindictus".equals(game)){
                    cbPackage.getItems().addAll(Package.VinPackage.nxList);
                    lbCurrency.setText(Package.VinPackage.currency);
                }else if("Point Blank".equals(game)){
                    cbPackage.getItems().addAll(Package.PBPackage.pbList);
                    lbCurrency.setText(Package.PBPackage.currency);
                }else if("FIFA Online 3".equals(game)){
                    cbPackage.getItems().addAll(Package.FIFAPackage.foList);
                    lbCurrency.setText(Package.FIFAPackage.curerncy);
                }
                cbPackage.getSelectionModel().selectFirst();
            }
        });

    }

    public void setOnClickPackage(){
        cbPackage.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String game = (String) cbGame.getValue();
                int total = 0;
                if("League of Legends".equals(game)){
                    total = ((int) cbPackage.getValue())/2;
                }else if("Heroes of Newerth".equals(game)){
                    total = ((int) cbPackage.getValue())/3;
                }else if("Blade & Soul".equals(game)){
                    total = ((int) cbPackage.getValue())/100;
                }else if("Vindictus".equals(game)){
                    total = (int) (((int) cbPackage.getValue())/1.5);
                }else if("Point Blank".equals(game)){
                    total = ((int) cbPackage.getValue())/100;
                }else if("FIFA Online 3".equals(game)){
                    total = ((int) cbPackage.getValue())/100;
                }
                lbTotal.setText(total + "");
            }
        });
    }

    public void setListenerButtonNext(){
        btnNext.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stageController.showPaymentView((String) cbGame.getValue(), lbTotal.getText(), (String) cbGame.getValue());

            }
        });
    }
    public void setController(MainController controller) {
        this.controller = controller;
        Package.addGame();
        cbGame.getItems().addAll(Package.games);
        cbGame.getSelectionModel().selectFirst();
        cbPackage.getItems().addAll(Package.LoLPackage.rpList);
        cbPackage.getSelectionModel().selectFirst();
        lbCurrency.setText("RP");
        setChoicboxPackage();
        setOnClickPackage();
        setListenerButtonNext();

    }

    public void setStageController(StageController stageController) {
        this.stageController = stageController;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
