package com.example.projet;

import java.io.BufferedReader;
import java.io.IOException;

public class Lecture extends Thread{
    BufferedReader br;
    Lecture(BufferedReader br){
        this.br=br;

    }
    public  void run(){

        while (true){
            try {
                System.out.println(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
