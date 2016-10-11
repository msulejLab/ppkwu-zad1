package pl.ppkwu.lab;

public class FileData {

    private String correctString;
    private String wrongString;
    private Boolean savedCorrectly;

    public FileData(String correctString, String wrongString, Boolean savedCorrectly) {
        this.correctString = correctString;
        this.wrongString = wrongString;
        this.savedCorrectly = savedCorrectly;
    }

    public String getCorrectString() {
        return correctString;
    }

    public String getWrongString() {
        return wrongString;
    }

    public Boolean getSavedCorrectly() {
        return savedCorrectly;
    }
}
