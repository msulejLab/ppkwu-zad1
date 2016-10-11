package pl.ppkwu.lab;

import java.util.concurrent.Callable;

public class MainCallback implements Callable<Boolean> {

    private FileData fileData;

    public Boolean call() throws Exception {
        return null;
    }

    public void setFileData(FileData fileData) {
        this.fileData = fileData;
    }
}
