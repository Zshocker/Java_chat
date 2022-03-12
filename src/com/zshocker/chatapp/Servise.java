package com.zshocker.chatapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Servise extends Thread
{
    Socket client;
    public Servise(Socket client){
        this.client=client;
    }
    @Override
    public void run()
    {
        try
        {
            BufferedReader in =new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter printWriter=new PrintWriter(client.getOutputStream(),true);
            BufferedReader ecrire =new BufferedReader(new InputStreamReader(System.in));
            boolean fini=false;
            String clientIP=client.getInetAddress().toString();
            System.out.println("new Connection with "+clientIP);
            while (true)
            {
                String message=in.readLine();
                System.out.println(clientIP+" says : "+message);
                System.out.print("You to "+clientIP+" :");
                printWriter.println(ecrire.readLine());
                if(message.contains("bye")){
                    client.close();
                    System.out.println("Connection with "+clientIP+" closed");
                    break;
                }
            }

        }catch (IOException ioException){
            System.err.println(ioException);
        }
    }
}
