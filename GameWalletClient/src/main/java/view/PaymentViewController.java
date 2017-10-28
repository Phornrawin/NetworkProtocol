package view;

import controller.MainController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import protocol.Protocol;

import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;

public class PaymentViewController implements Initializable{
    @FXML private Label lbGamename, lbAmount, lbTotal;
    @FXML private ChoiceBox cbWallet;
    @FXML private Button btnPay;
    private String gamePackage;
    private String gameId;
    private MainController controller;
    private StageController stageController;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setOnClickBtnPay(){
        btnPay.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String[] s = cbWallet.getValue().toString().split("-");
                System.out.println(s[1]);
                controller.requestPayment(lbGamename.getText(), gameId, gamePackage, lbAmount.getText(), s[1]);
            }
        });
    }

    public void setController(MainController controller) {
        this.controller = controller;
        Map<String, String> reply = controller.requestWalletList(controller.getCustomerId());
        ArrayList<String> walletList = addList(reply.get(Protocol.Header.LIST).split(","));
        cbWallet.getItems().addAll(walletList);
        setOnClickBtnPay();

    }

    public ArrayList<String> addList(String[] str){
        ArrayList<String> s = new ArrayList<>();
        for(String i : str){
            s.add(i);
        }
        return s;
    }

    public void setStageController(StageController stageController) {
        this.stageController = stageController;
    }

    public Label getLbGamename() {
        return lbGamename;
    }

    public Label getLbAmount() {
        return lbAmount;
    }

    public Label getLbTotal() {
        return lbTotal;
    }

    public ChoiceBox getCbWallet() {
        return cbWallet;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getGamePackage() {
        return gamePackage;
    }

    public void setGamePackage(String gamePackage) {
        this.gamePackage = gamePackage;
    }
}
