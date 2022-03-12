package com.zshocker.chatapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client
{
    public static void main(String[] args) {
        try {
            Socket socket=new Socket("DESKTOP-BRUU1KF",8999);
            BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
            BufferedReader ec=new BufferedReader(new InputStreamReader(System.in));
            while (true){
                String message,response;
                System.out.print("You :");
                message=ec.readLine();
                out.println(message);
                response=in.readLine();
                System.out.println("Other: "+response);
                if(message.contains("bye")) break;
            }
            in.close();
            out.close();
            socket.close();
        }catch (IOException e){
            System.err.println(e);
        }
    }
}
