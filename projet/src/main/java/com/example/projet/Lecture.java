package com.example.projet;

import javafx.scene.control.Label;

import java.io.*;

public class Lecture extends  Thread{


    FileWriter  myObj;

    {
        try {
            myObj = new FileWriter("C:\\Users\\ASUS\\Desktop\\projet\\projet\\src\\main\\java\\com\\example\\projet\\chat.txt",true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    BufferedReader br;
    Lecture(BufferedReader br){
        this.br=br;

    }
    public  void run(){

        while (true){
            try {

                String ch=br.readLine();

                BufferedWriter bw = new BufferedWriter(myObj);

                System.out.println(ch);

                    bw.write("client: "+ch);
                    bw.newLine();
                    bw.flush();



                serveur.diffusion(ch);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
