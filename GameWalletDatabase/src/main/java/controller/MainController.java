package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MainController {
    private static int port = 5185;

    public void startServer(){
        try {
            ServerSocket server = new ServerSocket(port);
            Socket socket;
            while (true){
                socket = server.accept();
                System.out.println("Accept" + socket.getInetAddress().getHostName());
                PrintStream output = new PrintStream(socket.getOutputStream());
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String line = input.readLine();
                System.out.println(line);
                output.print("Hi, I'm fine.\n");
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
