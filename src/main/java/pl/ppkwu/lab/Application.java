package pl.ppkwu.lab;

import java.util.Scanner;

public class Application {

    private static Scanner scanner;

    public static void main(String[] args) {
        System.out.println("Start..");

        scanner = new Scanner(System.in);

        String fileName = getInput("Nazwa pliku");
        String correctString = getInput("Poprawny string");
        String wrongString = getInput("Niepoprawny string");

        System.out.println("Wczytano: " + fileName + ", " + correctString + ", " + wrongString);
    }

    private static String getInput(String name) {
        System.out.print("(" + name + "):: ");
        return scanner.nextLine();
    }
}
