package com.zshocker.ObjectsinSockets;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Server {
    public static Set<Etudiant> etudiants=new HashSet<Etudiant>();
    public static void main(String[] args) {
        etudiants.add(new Etudiant("Sentel","Hicham"));
        etudiants.add(new Etudiant("Hica","sad"));
        etudiants.add(new Etudiant("Rndo","Rons"));
        etudiants.add(new Etudiant("Rsa","rsd"));
        etudiants.add(new Etudiant("qesa","das"));
        try {
            ServerSocket serverSocket=new ServerSocket(9000);
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
