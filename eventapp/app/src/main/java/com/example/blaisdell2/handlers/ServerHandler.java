package com.example.blaisdell2.handlers;

import java.net.URISyntaxException;

import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

/**
 * Created by jmiron on 7/30/2015.
 */
public class ServerHandler {

    public static String serverAddress = "localhost:8000";
    public static Socket mSocket;

    public static void connectToServer(){
        try {
            mSocket = IO.socket(serverAddress); // initialize the io.socket websocket
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        mSocket.connect();
    }

    public static void closeConnection()
    {
        try {
            mSocket.close();
            mSocket.disconnect();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static boolean isConnected(){ return mSocket.connected(); }







}

