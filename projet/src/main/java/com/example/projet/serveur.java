package com.example.projet;

import javafx.scene.control.Label;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class serveur {

    public  static ArrayList<Account> listAccount=new ArrayList<>();
    public  void main() {

        System.out.println("serveur launched");
        int nbclient=0;

        try {



            ServerSocket server=new ServerSocket(9001);

            System.out.println("listening");


                Socket s = server.accept();

                System.out.println("client connected");
                Discussion d=new Discussion(s);

                d.start();
                nbclient++;


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  static void diffusion(String ch){
        for (int i=0;i<listAccount.size();i++){


            try {
                PrintWriter pw=new PrintWriter(listAccount.get(i).socket.getOutputStream());
                pw.println(ch);

                pw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
