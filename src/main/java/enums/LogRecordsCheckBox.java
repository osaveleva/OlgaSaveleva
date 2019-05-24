package enums;

public enum LogRecordsCheckBox {

    WATERSELECTED ("Water: condition changed to true"),
    WINDSELECTED ("Wind: condition changed to true");

    private String record;

    LogRecordsCheckBox(String record) {
        this.record = record;
    }

    public String getRecord() {
        return record;
    }


}
