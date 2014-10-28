package com.example.client;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class NetworkClientCallable implements Callable<RequestResponse> {

    private RequestResponse lookup;

        public NetworkClientCallable(RequestResponse lookup) {
        this.lookup = lookup;
    }

    @Override
    public RequestResponse call() throws IOException {
        try (Socket sock = new Socket(lookup.host, lookup.port);
                Scanner scanner = new Scanner(sock.getInputStream())) {
            lookup.response = scanner.next();
            return lookup;
        }
    }
}