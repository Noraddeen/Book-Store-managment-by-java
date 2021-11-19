package com.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSideSocket {


    public void connection() throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(4444);
            serverSocket.setSoTimeout(3600_000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 4444.");
            System.exit(1);
        }
        Socket clientSocket = null;
        while(!serverSocket.isClosed()) {
            try {
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
            }
            try {
              PrintWriter  out = new PrintWriter(clientSocket.getOutputStream(), true);
               BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

               Thread thread = new ServingClinet(clientSocket, out, in);
               thread.start();
            } catch (IOException e) {
                System.out.println("stream not build ");
            }
        }
    } // fun
}







