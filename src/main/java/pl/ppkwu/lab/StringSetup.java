package pl.ppkwu.lab;

public class StringSetup {

    private String correctString;
    private String wrongString;

    public StringSetup(String correctString, String wrongString) {
        this.correctString = correctString;
        this.wrongString = wrongString;
    }

    public String getCorrectString() {
        return correctString;
    }

    public String getWrongString() {
        return wrongString;
    }

    @Override
    public String toString() {
        return String.format("Poprawny String: %s\nZly String: %s\n", correctString, wrongString);
    }
}
