package com.compro.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        int port = 8000;
        String[] Words = {
                "airport", "balloon", "capture", "caution", "diamond", "dynamic", "edition",
                "feature", "federal", "gallery", "gateway", "habitat", "harbor", "healthy",
                "husband", "include", "justice", "kingdom", "laundry", "liberty", "machine",
                "maximum", "message", "million", "mineral", "mission", "musical", "mystery",
                "network", "opinion", "partner", "pattern", "penguin", "picture", "plastic",
                "quality", "quarter", "rainbow", "receipt", "silence", "storage", "subject",
                "teacher", "traffic", "unknown", "variety", "version", "victory", "volcano",
                "weekend"
        };

        int randomIndex = (int) (Math.random() * Words.length);
        try (ServerSocket server = new ServerSocket(port);
                Scanner sc = new Scanner(System.in);) {
            System.out.println("Waiting for client to be connected...");
            Socket client = server.accept(); // wait for client to connect
            // create in/out streams from this server to
            // the client by using the same socket object that represents the
            // accepted/connected client
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

            System.out.println("Client is connected...");

            while (true) {
                // listen for client message
                System.out.println("Waiting for clients guess");

                // read client's message
                String Guess = in.readLine();

                // determine if server's quitting
                if (Guess == null || Guess.equalsIgnoreCase("/quit")) {
                    System.out.println("Server disconnected...");
                    break;
                }

                // display client's message
                System.out.println("Client: " + Guess);

                // reply to client
                // type your message
                System.out.println("Your turn (Server): ");

                String reply = sc.nextLine();

                // send your message
                out.println(reply);

            }

            out.close();
            in.close();
            client.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}