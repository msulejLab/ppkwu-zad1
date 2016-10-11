package pl.ppkwu.lab;

import java.io.File;
import java.io.IOException;

public class Application {

    public static final String HELLO_WORLD = "Hello World!";
    public static final String FORMAT = "txt";

    public static void main(String[] args) {
        performFileOperations();
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

    private static void setData(
            String filename, String correctString, String wrongString, FileCallback fileCallback) throws Exception {
        File file = new File(filename + "." + FORMAT);
        boolean savedCorrectly = false;
        try {
            file.createNewFile();
            IOUtils.writeToFile(file, HELLO_WORLD);
            System.out.println(correctString);
            savedCorrectly = true;
        } catch (IOException e) {
            System.out.println(wrongString);
        } finally {
            MainCallback mainCallback = new MainCallback();
            mainCallback.setStringSetup(new StringSetup(correctString, wrongString));
            mainCallback.setSavedCorrectly(savedCorrectly);
            mainCallback.setFileCallback(fileCallback);

            Boolean performAgain = mainCallback.call();

            if (performAgain) {
               performFileOperations();
            }
        }
    }
}
