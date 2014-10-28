package com.example.client;

import java.io.IOException;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class NetworkClientMain {

    public static void main(String[] args) {
        String host = "localhost";
        for (int port = 10000; port < 10010; port++) {
            RequestResponse lookup = new RequestResponse(host, port);
            try (Socket sock = new Socket(lookup.host, lookup.port);
                    Scanner scanner = new Scanner(sock.getInputStream());) {
                lookup.response = scanner.next();
                System.out.println(lookup.host + ":" + lookup.port + " " + lookup.response);
            } catch (NoSuchElementException | IOException ex) {
                System.out.println("Error talking to " + host + ":" + port);
            }
        }
    }
}