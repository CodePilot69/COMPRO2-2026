package com.weather.app;

import com.weather.app.models.WeatherResponse;
import com.weather.app.services.WeatherService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        WeatherService service = new WeatherService();

        System.out.print("Enter Latitude: ");
        double lat = sc.nextDouble();
        System.out.print("Enter Longitude: ");
        double lon = sc.nextDouble();

        WeatherResponse data = service.getForecast(lat, lon);

        if (data != null && data.forecasts != null) {
            for (int i = 0; i < 3 && i < data.forecasts.size(); i++) {
                var f = data.forecasts.get(i);
                System.out.println("At hour " + f.timepoint + ": " + 
                                   f.temperature + "°C with " + 
                                   f.wind.speed + " speed winds from the " + 
                                   f.wind.direction + ".");
            }
        } else {
            System.out.println("Couldnot retrieve weather data.");
        }
        
        sc.close();
    }
}