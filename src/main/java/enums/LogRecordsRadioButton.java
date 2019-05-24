package enums;

public enum LogRecordsRadioButton {

    SELEN("metal: value changed to Selen");

    private String record;

    LogRecordsRadioButton(String record) {
        this.record = record;
    }

    public String getRecord() {
        return record;
    }


}
