package pl.ppkwu.lab;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.File;
import java.io.IOException;

public class Application {

    public static final String HELLO_WORLD = "Hello World!";
    public static final String FORMAT = "txt";

    public static void main(String[] args) {
        performFileOperations();

        System.out.println("Zakonczono dzialanie programu");
    }

    private static void performFileOperations() {
        String fileName = IOUtils.getInput("Nazwa pliku");
        String correctString = IOUtils.getInput("Poprawny string");
        String wrongString = IOUtils.getInput("Niepoprawny string");

        try {
            setData(fileName, correctString, wrongString, new FileCallback());
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    private static void setData(String filename, String correctString, String wrongString, FileCallback callback) throws Exception {
        File file = new File(filename + "." + FORMAT);
        file.createNewFile();

        try {
            IOUtils.writeToFile(file, HELLO_WORLD);
            System.out.println(correctString);

            callback.setResult(true);
        } catch (IOException e) {
            callback.setResult(false);
            System.out.println(wrongString);
        } finally {
            boolean performAgain = callback.call();

            if (performAgain) {
               performFileOperations();
            }
        }
    }
}
