package com.example.projet;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ecriture extends Thread {
    Scanner sc=new Scanner(System.in);
    PrintWriter pw;
    Ecriture(PrintWriter pw){
        this.pw=pw;
    }
    FileWriter myObj;

    static Boolean write=false;
    static String msgchat;
    {
        try {
            myObj = new FileWriter("C:\\Users\\ASUS\\Desktop\\projet\\projet\\src\\main\\java\\com\\example\\projet\\chat.txt",true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

           BufferedWriter bw = new BufferedWriter(myObj);


           try {
               bw.write("admin : " + msgchat);
               bw.newLine();
               bw.flush();
               write=false;
           } catch (IOException e) {
               e.printStackTrace();
           }
       }

   }

    }
}
