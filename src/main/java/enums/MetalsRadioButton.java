package enums;


public enum MetalsRadioButton {

    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");

    private String record;

    MetalsRadioButton(String record) {
        this.record = record;
    }

    public String getRecord() {
        return record;
    }


}
