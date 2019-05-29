package enums;


public enum ColorsDropDowns {

    RED("Red"),
    YELLOW("Yellow"),
    BLUE("Blue"),
    GREEN("Green");

    private String record;

    ColorsDropDowns(String record) {
        this.record = record;
    }

    public String getRecord() {
        return record;
    }


}
