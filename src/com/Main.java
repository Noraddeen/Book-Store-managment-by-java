package com;

import com.controller.ServerSideSocket;

public class Main {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
       
      ServerSideSocket server = new ServerSideSocket();
        server.connection();

    }
}
