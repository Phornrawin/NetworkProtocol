package controller;

import protocol.PasingMessage;
import protocol.Protocol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MainController {
    private PasingMessage parser;
    public void StartApplication(){
        parser = new PasingMessage();
        try {
            Socket socket = new Socket("localhost", 5185);
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            writer.print(parser.parseToStringWallet("5810405185", socket.getLocalAddress().toString()));
            writer.flush();

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String s = null;
            while((s = reader.readLine()) != null){
                System.out.println(s);
            }
            socket.close();
        } catch (IOException e) {
            System.err.println(e.toString());
        }
    }
}
