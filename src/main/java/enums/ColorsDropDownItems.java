package enums;


public enum ColorsDropDownItems {

    RED("Red"),
    YELLOW("Yellow"),
    BLUE("Blue"),
    GREEN("Green");

    private String record;

    ColorsDropDownItems(String record) {
        this.record = record;
    }

    public String getRecord() {
        return record;
    }


}
