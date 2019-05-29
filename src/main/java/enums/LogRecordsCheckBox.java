package enums;

public enum LogRecordsCheckBox {

    TEMPALTE("%s: condition changed to %s");
    private String record;

    LogRecordsCheckBox(String record) {
        this.record = record;
    }

    public String getRecord(String element, String status) {
        return String.format(record, element, status);
    }


}
