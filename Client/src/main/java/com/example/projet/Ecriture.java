package com.example.projet;

import java.io.PrintWriter;
import java.util.Scanner;

public class Ecriture extends  Thread{
    Scanner sc=new Scanner(System.in);
    PrintWriter pw;
    Ecriture(PrintWriter pw){
        this.pw=pw;
    }

    static String msgchat=null;
    static Boolean write=false;

    public static void Test(String ch){

        msgchat=ch;
        write=true;
    }
    public void run(){

       while (true) {
           System.out.println(msgchat);
           //  String msg = sc.nextLine();
           if(write&&!msgchat.isEmpty()) {

               pw.println(msgchat);
               pw.flush();
               write=false;
           }

       }

    }
}
