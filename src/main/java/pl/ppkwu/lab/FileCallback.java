package pl.ppkwu.lab;

import java.io.File;
import java.util.concurrent.Callable;

/**
 * Created by Pawełek on 10.10.2016.
 */
public class FileCallback implements Callable<Boolean> {

    private Boolean result = false;

    public Boolean call() throws Exception {
        if (result) {
            String input = IOUtils.getInput("Sprobowac jeszcze raz? [y/n]");
            return input.equalsIgnoreCase("y");
        }

        return false;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
