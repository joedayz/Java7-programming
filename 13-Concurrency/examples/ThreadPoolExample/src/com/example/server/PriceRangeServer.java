package com.example.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class PriceRangeServer implements Runnable {

    private String price;
    private ServerSocket ss;

    //low inclusive
    //high exclusive
    public PriceRangeServer(int port, int low, int high) throws IOException {
        ss = new ServerSocket(port);
        ss.setSoTimeout(250);
        double d = Math.random() * (high - low) + low;
        price = String.format("%.2f", d);
    }

    public void accept() throws IOException {
        System.out.println("Accepting connections on port " + ss.getLocalPort());
        while (!Thread.interrupted()) {
            try (Socket sock = ss.accept();
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()))) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    return;
                }
                bw.write(price);
            } catch (SocketTimeoutException ste) {
                //timeout every .25 seconds to see if interrupted
            }
        }
        System.out.println("Done accepting");
    }

    @Override
    public void run() {
        try {
            accept();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}