package com.kinse.model;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
public class Weatherfetcher {
    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);    
    
        System.out.println("---Weather Fetcher---");
        System.out.println("Enter Latitude");
        String Lat = sc.nextLine();

        System.out.println("Enter Longitude");
        String Long = sc.nextLine();
    
        String urlString = "https://api.open-meteo.com/v1/forecast?latitude=" + Lat + "&longitude=" + Long + "&current_weather=true";
        
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlString))
                    .GET()
                    .build();

            System.out.println("\nFetching data from APi");
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
         
            int statusCode = response.statusCode();

            if (statusCode == 200) {
                System.out.println(" Status Code: " + statusCode);
                System.out.println("Raw JSON Data:");
                System.out.println(response.body());
               
            } else {
                System.out.println("Received status code " + statusCode);
            }  

        } catch (IOException | InterruptedException e) {
         
            System.err.println("Error occurdd");
            System.err.println(e.getMessage());
        } finally {
            sc.close();
        }
       
    
    }
    
}