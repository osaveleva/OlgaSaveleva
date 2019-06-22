package enums;

public enum LogRecordsFromTo {

    TEMPLATE("Range 2(%s):%s link clicked");

    private String record;

    LogRecordsFromTo(String record) {
        this.record = record;
    }

    public String getRecord(String ToFrom, String value) {
        return String.format(record, ToFrom, value);
    }

    // TODO
    public static String getRecord1(String ToFrom, String value) {
        return String.format(TEMPLATE.record, ToFrom, value);
    }
}
