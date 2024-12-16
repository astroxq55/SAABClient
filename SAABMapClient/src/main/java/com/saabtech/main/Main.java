package com.saabtech.main;
import com.saabtech.client.ServerListener;

public class Main {
    
    public static void main(String[] args) throws Exception {
        ServerListener listener = new ServerListener();
        listener.listen();
    }
}
