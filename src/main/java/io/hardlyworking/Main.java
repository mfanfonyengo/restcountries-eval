package io.hardlyworking;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    static String baseUrl = "https://restcountries.com/v3.1";
    static Scanner keyboard = new Scanner(System.in);
    static String repeat, keyInCountryName, KeyInCountryCode;

    public static void main(String[] args) throws IOException, InterruptedException {
        if (args.length == 0) {
            //Prompt user to search until they exit program
            do {
                promptUser();
                System.out.println("Try Again? (Yes or No)");
                repeat = keyboard.next();
            } while (repeat.equalsIgnoreCase("yes") || repeat.equalsIgnoreCase("y"));

        } else if (args.length == 1) {
            // TODO Parse args(code|name|file) Perform search without prompt
        } else {
            System.out.println("Max argument limit exceeded!");
        }

    }

    public static void promptUser() throws IOException, InterruptedException {
        String answer;

        System.out.println("Get information about a country.");
        System.out.println("Search by name? (Yes or No): ");
        answer = keyboard.next();
        if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
            System.out.println("Enter country name: ");
            keyInCountryName = keyboard.next();
            System.out.println("----> " + keyInCountryName);
            getRequestName(keyInCountryName);
        } else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
            System.out.println("Search by country code: ");
            KeyInCountryCode = keyboard.next();
            System.out.println("----> " + KeyInCountryCode);
            getRequestCode(KeyInCountryCode);
        }

    }

    public static void getRequestName(String name) throws IOException, InterruptedException {
        baseUrl += ("/name/" + name);
        getRequest(baseUrl);
    }

    public static void getRequestCode(String code) throws IOException, InterruptedException {
        baseUrl += ("/alpha/" + code);
        getRequest(baseUrl);
    }

    public static void getRequest(String url) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET().header("accept", "application/json")
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());
        System.out.println(response.body());
        baseUrl = "https://restcountries.com/v3.1";
    }


}
