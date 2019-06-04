package enums;

public enum LogRecordsElementsCheckBox {

    TEMPLATE("%s: condition changed to %s");
    private String record;

    LogRecordsElementsCheckBox(String record) {
        this.record = record;
    }

    public static String getRecord(String element, String status) {
        return String.format(TEMPLATE.record, element, status);
    }


}
