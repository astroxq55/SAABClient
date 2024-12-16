package com.saabtech.client;
import com.saabtech.model.DataProcessor;
import com.saabtech.gui.AppWindow;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.Timer;


public class ServerListener {
    private final String serverHost = "localhost";
    private final int serverPort = 5463;


    public void listen() throws IOException{
        try {
            AppWindow windowFrame = new AppWindow();
            Timer timer = new Timer(16, e -> windowFrame.mapPanel.repaint()); // Uppdaterar var ~60 fps
            DataProcessor processor = new DataProcessor();
            Socket s = new Socket(serverHost, serverPort);                
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            
            timer.start();
            System.out.println("Connected to the server on " + serverHost + ":" + serverPort);
            String inData;
            while ((inData = in.readLine()) != null) {
                System.out.println("Indata from socket: " + inData);                // prints out a string
                processor.processInputString(inData);                               // processes the string input. updates or adds data to hashmap
                windowFrame.mapPanel.mapObjects = processor.getHashMap();           // hands over latest hashmap to mapPanel
                processor.printAllObjectsInCommand();                               // debug tool, can be commented out
            }
            
            
        } catch (UnknownHostException e) {
            System.err.println("Unknown host: " + serverHost);    
        } catch (IOException e) {
            System.err.println("IO Error: " + e.getMessage());
        } finally {
            System.out.println("Disconnected from the server");
        }
    }

    
}


