
package com.exam.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 6767;
        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Waiting for clients");

            Socket player1 = server.accept();

            PrintWriter out1 = new PrintWriter(player1.getOutputStream(), true);
            BufferedReader in1 = new BufferedReader(new InputStreamReader(player1.getInputStream()));

            System.out.println("Player1 is connected");
            out1.println("Player1");

            Socket player2 = server.accept();
            PrintWriter out2 = new PrintWriter(player2.getOutputStream(), true);
            BufferedReader in2 = new BufferedReader(new InputStreamReader(player2.getInputStream()));

            System.out.println("Player 2 connected.");
            out2.println("Player2");

            out1.println("Choose your Weapon P1");
            out1.println("""
                    [ 1 ] - Rock
                    [ 2 ] - Paper
                    [ 3 ] - Scissor
                    """);

            out2.println("Choose your Weapon P2");
            out2.println("""
                    [ 1 ] - Rock
                    [ 2 ] - Paper
                    [ 3 ] - Scissor
                    """);

            out1.close();
            out2.close();
            in1.close();
            in2.close();
            player1.close();
            player2.close();
        } catch (IOException e) {     


            System.out.println("Game Ended!!");
        }
    }
}
