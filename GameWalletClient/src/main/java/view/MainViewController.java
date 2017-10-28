package view;

import controller.MainController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import protocol.Protocol;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;


public class MainViewController implements Initializable{
    @FXML private TextField tfUsername;
    @FXML private PasswordField tfPassword;
    @FXML private Button btnLogin;
    @FXML private Label lbError;
    private MainController controller;
    private StageController stageController;


    @FXML
    public void onClickLogin(){
        String id = tfUsername.getText().toString();
        String pw = tfPassword.getText().toString();
        Map<String, String> reply = controller.requestLogin(id, pw);
        System.out.println(reply.toString());
        if(reply.get(Protocol.Header.RESULT).equals(Protocol.Result.IDORPW_NOTFOUND)){
            lbError.setText("Username or password invalid.");
        }else{
            stageController.showSelectView();
            lbError.setText("");
        }
    }

    public void setController(MainController controller) {
        this.controller = controller;
        btnLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                onClickLogin();
            }
        });
    }

    public void setStageController(StageController stageController) {
        this.stageController = stageController;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
