package pl.ppkwu.lab;

import java.io.File;
import java.util.concurrent.Callable;

public class FileCallback implements Callable<Boolean> {

    private MainCallback mainCallback;

    public Boolean call() throws Exception {
//        if (result) {
        String input = IOUtils.getInput("Sprobowac jeszcze raz? [y/n]");
        return input.equalsIgnoreCase("y");
//        }

//        return false;
    }

    public void setMainCallback(MainCallback mainCallback) {
        this.mainCallback = mainCallback;
    }
}
