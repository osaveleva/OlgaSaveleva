package enums;


public enum ElementsCheckBoxItems {

    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire");

    private String record;

    ElementsCheckBoxItems(String record) {
        this.record = record;
    }

    public String getRecord() {
        return record;
    }


}
