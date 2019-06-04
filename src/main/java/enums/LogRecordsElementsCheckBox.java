package enums;

public enum LogRecordsCheckBox {

    TEMPLATE("%s: condition changed to %s");
    private String record;

    LogRecordsCheckBox(String record) {
        this.record = record;
    }

    public static String getRecord(String element, String status) {
        return String.format(TEMPLATE.record, element, status);
    }


}
