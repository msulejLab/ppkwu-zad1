package pl.ppkwu.lab;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.Future;

public class Application {
  private static final String HELLO_WORLD = "Hello World!";
  public static final String PLIK_ZOSTAL_UTWORZONY = "Plik zostal utworzony";
  public static final String FORMAT = "txt";

  private static Scanner scanner;
  private static FileCallback fileCallback = new FileCallback();
  private static Boolean fileResult;


  public static void main(String[] args) {
    System.out.println("Start..");

    scanner = new Scanner(System.in);

    String fileName = getInput("Nazwa pliku");
    String correctString = getInput("Poprawny string");
    String wrongString = getInput("Niepoprawny string");

    System.out.println("Wczytano: " + fileName + ", " + correctString + ", " + wrongString);
    try {
      setData(fileName, correctString, wrongString, fileCallback);
    } catch (Exception e) {
      e.getStackTrace();
    }
  }

  private static String getInput(String name) {
    System.out.print("(" + name + "):: ");
    return scanner.nextLine();
  }

  private static void setData(String filename, String correctString, String wrongString, FileCallback callback) throws Exception {
    File file = new File(filename + "." + FORMAT);
    file.createNewFile();
    try {
      System.out.println(correctString);
      writeToFile(file, HELLO_WORLD);
      System.out.println(PLIK_ZOSTAL_UTWORZONY);
      callback.setFile(file);
      callback.setResult(file.exists());
      fileResult = callback.call();
    } catch (IOException IOe) {
      System.out.println(wrongString);
    }


  }

  public static void writeToFile(File file, String message) throws IOException {
    FileWriter fileWriter = new FileWriter(file.getAbsolutePath());
    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
    bufferedWriter.write(HELLO_WORLD);
    bufferedWriter.close();
  }

  ;
}
