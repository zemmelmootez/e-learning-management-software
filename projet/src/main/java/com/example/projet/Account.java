package com.example.projet;

import java.net.Socket;
import java.util.Date;

public  class Account {
    String id_src;
    Socket socket;
    Date time_connection;


    public Account(String id_src, Socket socket, Date time_connection) {
        this.id_src = id_src;
        this.socket = socket;
        this.time_connection = time_connection;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id_src='" + id_src + '\'' +
                ", socket=" + socket +
                ", time_connection=" + time_connection +
                '}';
    }
}
