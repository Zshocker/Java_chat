package com.zshocker.ObjectsinSockets;

import java.io.*;
import java.net.Socket;

public class Servise extends  Thread{
    Socket client ;
    public Servise (Socket c)
    {
        client=c;
    }

    @Override
    public void run() {
        try
        {
            BufferedReader in =new BufferedReader(new InputStreamReader(client.getInputStream()));
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(client.getOutputStream());
            String clientIP=client.getInetAddress().toString();
            System.out.println("new Connection with "+clientIP);
            String message=in.readLine();
            Etudiant etud= Server.etudiants.stream().filter(etudiant -> etudiant.getNom().equalsIgnoreCase(message)).findFirst().get();
            objectOutputStream.writeObject(etud);
            objectOutputStream.flush();
            in.close();
            objectOutputStream.close();
            client.close();
            System.out.println("closed the Connection with "+clientIP);
        }catch (IOException ioException){
            System.err.println(ioException);
        }
    }
}