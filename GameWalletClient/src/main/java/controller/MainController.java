package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import protocol.PasingMessage;
import protocol.Protocol;
import view.MainViewController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;

public class MainController {
    private PasingMessage parser;
    private String customerId;

    public Map<String, String> requestLogin(String id, String pw){
        parser = new PasingMessage();
        try {
            Socket socket = new Socket("localhost", 5185);
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            writer.print(parser.parseToStringLogin(socket.getLocalAddress().toString(), id, pw));
            customerId = id;
            writer.flush();

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Map<String, String> mapReply = parser.parseRequestToMap(reader);
            System.out.println(mapReply.toString());
            socket.close();
            return mapReply;
        } catch (IOException e) {
            System.err.println(e.toString());
        }
        return null;
    }

    public Map<String, String> requestWalletList(String id){
        parser = new PasingMessage();
        try {
            Socket socket = new Socket("localhost", 5185);
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            writer.print(parser.parseToStringWallet(id, socket.getLocalAddress().toString()));
            writer.flush();

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Map<String, String> mapReply = parser.parseRequestToMap(reader);
            System.out.println(mapReply.toString());
            socket.close();
            return mapReply;
        } catch (IOException e) {
            System.err.println(e.toString());
        }
        return null;
    }

    public void requestPayment(String gameName, String gameID, String pkage, String net, String walletID){
        parser = new PasingMessage();
        try {
            Socket socket = new Socket("localhost", 5185);
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            writer.print(parser.parseToStringCredits(gameName, socket.getLocalAddress().toString(), gameID, pkage, net,walletID));
            writer.flush();

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Map<String, String> mapReply = parser.parseRequestToMap(reader);
            System.out.println(mapReply.toString());
            socket.close();
        } catch (IOException e) {
            System.err.println(e.toString());
        }
    }

    public String getCustomerId() {
        return customerId;
    }
}
