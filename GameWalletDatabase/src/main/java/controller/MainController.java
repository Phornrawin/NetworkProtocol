package controller;

import Model.Customer;
import Model.Report;
import Model.Wallet;
import protocol.PasingMessage;
import protocol.Protocol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Map;

public class MainController {
    DatabaseController dbController;
    private PasingMessage parser = new PasingMessage();
    private static int port = 5185;


    public void startServer(){
        dbController = DatabaseController.getInstance();
        try {
            ServerSocket server = new ServerSocket(port);
            Socket socket;
            System.out.println("Start Server.");
            while (true){
                System.out.println("wait...");

                socket = server.accept();
                PrintStream output = new PrintStream(socket.getOutputStream());
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                Map<String, String> map = parser.parseRequestToMap(input);

                if(Protocol.Method.LOGIN.equals(map.get(Protocol.Header.METHOD))){
                    System.out.println("Signing in...");
                    Customer customer = dbController.checkIDFromLogin(map.get(Protocol.Header.CUSTOMERID), map.get(Protocol.Header.CUSTOMERPW));
                    output.print(parser.parseToReplyLogin(customer));

                }else if(Protocol.Method.CREDITS.equals(map.get(Protocol.Header.METHOD))){
                    boolean isAvailable = dbController.checkAndPayFromGameDredit(Double.parseDouble(map.get(Protocol.Header.NET)), map.get(Protocol.Header.WALLETID));
                    output.print(parser.parseToReplyAvailable(isAvailable));

                }else if(Protocol.Method.REPORT.equals(map.get(Protocol.Header.METHOD))){
                    ArrayList<String> reports = dbController.loadReportFromCustomerID(map.get(Protocol.Header.CUSTOMERID));
                    String reportlist = String.join(",", reports);
                    output.print(parser.parseToReplyList(Protocol.Type.REPORTLIST, reportlist));

                }else if(Protocol.Method.WALLET.equals(map.get(Protocol.Header.METHOD))){
                    ArrayList<String> wallets = dbController.loadWalletFromLogin(map.get(Protocol.Header.CUSTOMERID));
                    String walletlist = String.join(",", wallets);
                    output.print(parser.parseToReplyList(Protocol.Type.WALLETLIST, walletlist));
                }

                output.flush();
                System.out.println("responseessfully.");
                output.close();
                socket.close();
            }
        } catch (IOException e) {
            System.err.println(e.toString());
        }
    }
}
