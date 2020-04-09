package model.enums;

public enum Color {
    BLACK("#000000"),
    WHITE("#FFFFFF"),
    RED("#FF0000"),
    GREEN("#008000"),
    BLUE("#0000FF"),
    YELLOW("#FFFF00");

    private String hexNumber;

    private Color(String hexNumber) {
        this.hexNumber = hexNumber;
    }

    public String getHexNumber() {
        return hexNumber;
    }
}
