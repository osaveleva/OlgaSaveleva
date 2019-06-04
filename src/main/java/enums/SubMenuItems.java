package enums;

public enum SubMenuItems {

    SUPPORT("Support"),
    DATES("Dates"),
    COMPLEX_TABLE("Complex Table"),
    SIMPLE_TABLE("Simple Table"),
    PAGES_TABLE("Table with pages"),
    DIFFERENT_ELEMENTS("Different elements"),
    USER_TABLE("User Table");

    private String record;

    SubMenuItems(String record) {
        this.record = record;
    }

    public String getRecord() {
        return record;
    }


}
