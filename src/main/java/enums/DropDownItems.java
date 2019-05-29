package enums;


public enum DropDownItems {

    RED("Red"),
    YELLOW("Yellow"),
    BLUE("Blue"),
    GREEN("Green");

    private String record;

    DropDownItems(String record) {
        this.record = record;
    }

    public String getRecord() {
        return record;
    }


}
