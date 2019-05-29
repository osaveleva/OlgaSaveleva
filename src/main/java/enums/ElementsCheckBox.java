package enums;


public enum ElementsCheckBox {

    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire");

    private String record;

    ElementsCheckBox(String record) {
        this.record = record;
    }

    public String getRecord() {
        return record;
    }


}
