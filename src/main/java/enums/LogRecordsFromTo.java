package enums;

public enum LogRecordsFromTo {

    FROM("Range 2(From):"),
    TO("Range 2(To):"),
    LINK(" link clicked");

    private String record;

    LogRecordsFromTo(String record) {
        this.record = record;
    }

    public String getRecord() {
        return record;
    }

}
