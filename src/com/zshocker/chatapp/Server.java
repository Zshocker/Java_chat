package com.zshocker.chatapp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket=new ServerSocket(8999);
            System.out.println("The Server is on");
            Socket clientSock;
            while (true)
            {
                clientSock=serverSocket.accept();
                if(clientSock!=null)new Servise(clientSock).start();
            }
        }catch (IOException e){
            System.err.println(e);
        }
    }
}
