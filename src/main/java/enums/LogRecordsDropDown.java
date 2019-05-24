package enums;

public enum LogRecordsDropDown {

    YELLOW("Colors: value changed to Yellow");

    private String record;

    LogRecordsDropDown(String record) {
        this.record = record;
    }

    public String getRecord() {
        return record;
    }


}
