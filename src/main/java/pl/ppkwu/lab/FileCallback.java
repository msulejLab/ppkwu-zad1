package pl.ppkwu.lab;

import java.util.concurrent.Callable;

public class FileCallback implements Callable<Boolean> {

    private MainCallback mainCallback;

    private StringSetup stringSetup;

    public Boolean call() throws Exception {
        if (mainCallback.getSavedCorrectly()) {
            String input = IOUtils.getInput("Sprobowac jeszcze raz? [y/n]");
            boolean performAgain = input.equalsIgnoreCase("y");

            if (performAgain) {
                System.out.println("Poprzednie ustawienia: \n" + stringSetup);
            }
        }

        return false;
    }

    public void setMainCallback(MainCallback mainCallback) {
        this.mainCallback = mainCallback;
    }

    public void setStringSetup(StringSetup stringSetup) {
        this.stringSetup = stringSetup;
    }
}
