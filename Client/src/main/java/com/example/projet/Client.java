package com.example.projet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main() {
        Scanner sc=new Scanner(System.in);
        System.out.println("client launched");
        try {
            Socket s=new Socket("127.0.0.1",9001);
            System.out.println("i'm the client i'm connected");
            BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));

            Lecture l=new Lecture(br);
            l.start();

            PrintWriter pw=new PrintWriter(s.getOutputStream());
            Ecriture e=new Ecriture(pw);
            e.start();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}