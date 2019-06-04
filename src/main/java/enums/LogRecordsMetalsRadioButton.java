package enums;

public enum LogRecordsMetalsRadioButton {

    TEMPALTE("metal: value changed to %s");

    private String record;

    LogRecordsMetalsRadioButton(String record) {
        this.record = record;
    }

    public static String getRecord(String element) {
        return String.format(TEMPALTE.record, element);
    }


}
