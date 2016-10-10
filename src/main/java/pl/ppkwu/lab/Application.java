package pl.ppkwu.lab;

import java.io.File;
import java.io.IOException;

public class Application {

    public static final String HELLO_WORLD = "Hello World";
    public static final String FORMAT = "txt";

    private static FileCallback fileCallback = new FileCallback();
    private static Boolean fileResult;

    public static void main(String[] args) {
        System.out.println("Start..");

        String fileName = IOUtils.getInput("Nazwa pliku");
        String correctString = IOUtils.getInput("Poprawny string");
        String wrongString = IOUtils.getInput("Niepoprawny string");
        System.out.println("Wczytano: " + fileName + ", " + correctString + ", " + wrongString);

        try {
            setData(fileName, correctString, wrongString, fileCallback);
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

            callback.setFile(file);
            callback.setResult(file.exists());

            fileResult = callback.call();
        } catch (IOException e) {
            System.out.println(wrongString);
        }
    }
}
