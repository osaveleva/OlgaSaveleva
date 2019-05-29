package enums;

public enum LogRecordsRadioButton {

    TEMPALTE("metal: value changed to %s");

    private String record;

    LogRecordsRadioButton(String record) {
        this.record = record;
    }

    public String getRecord(String element) {
        return String.format(record, element);
    }


}
