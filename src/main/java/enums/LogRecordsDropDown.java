package enums;

public enum LogRecordsDropDown {

    TEMPLATE("Colors: value changed to %s");

    private String record;

    LogRecordsDropDown(String record) {
        this.record = record;
    }

    public String getRecord(String element) {
        return String.format(record, element);
    }


}
