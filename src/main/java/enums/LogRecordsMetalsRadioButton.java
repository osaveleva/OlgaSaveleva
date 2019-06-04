package enums;

public enum LogRecordsRadioButton {

    TEMPALTE("metal: value changed to %s");

    private String record;

    LogRecordsRadioButton(String record) {
        this.record = record;
    }

    public static String getRecord(String element) {
        return String.format(TEMPALTE.record, element);
    }


}
