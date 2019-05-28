package enums;


public enum RadioButtonItems {

    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");

    private String record;

    RadioButtonItems(String record) {
        this.record = record;
    }

    public String getRecord() {
        return record;
    }


}
