package pl.ppkwu.lab;

import java.util.concurrent.Callable;

public class MainCallback implements Callable<Boolean> {

    private FileCallback fileCallback;

    private Boolean savedCorrectly;
    private StringSetup stringSetup;

    public Boolean call() throws Exception {
        fileCallback.setStringSetup(stringSetup);
        return fileCallback.call();
    }

    public void setFileCallback(FileCallback fileCallback) {
        this.fileCallback = fileCallback;
    }

    public void setSavedCorrectly(Boolean savedCorrectly) {
        this.savedCorrectly = savedCorrectly;
    }

    public void setStringSetup(StringSetup stringSetup) {
        this.stringSetup = stringSetup;
    }

    public Boolean getSavedCorrectly() {
        return savedCorrectly;
    }
}
