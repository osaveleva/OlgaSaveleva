package enums;


public enum ElementsNumber {

    DROPDOWN_NUMBER("1"),
    ICONS_NUMBER("4");

    private String record;

    ElementsNumber(String record) {
        this.record = record;
    }

    public String getRecord() {
        return record;
    }


}
