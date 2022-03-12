package com.zshocker.ObjectsinSockets;

import java.io.*;
import java.net.Socket;

public class Client
{
    public static void main(String[] args) {
        try {
            Socket socket=new Socket("DESKTOP-BRUU1KF",9000);
            ObjectInputStream in=new ObjectInputStream(socket.getInputStream());
            PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
            BufferedReader ec=new BufferedReader(new InputStreamReader(System.in));
            String message;
            Etudiant etudiant;
            System.out.print("Name :");
            message=ec.readLine();
            out.println(message);
            etudiant= (Etudiant) in.readObject();
            System.out.println("Other: "+etudiant);
            in.close();
            out.close();
            socket.close();
        }catch (IOException e){
            System.err.println(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
