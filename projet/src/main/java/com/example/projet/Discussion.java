package com.example.projet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class Discussion extends  Thread{

    Socket s;
    Discussion(Socket s){

        this.s=s;

    }
    public void run(){
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(s.getOutputStream());


            Ecriture e=new Ecriture(pw);
            e.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String id=br.readLine();
            serveur.listAccount.add(new Account(id,s,new Date()));
            Lecture l=new Lecture(br);

            l.start();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
