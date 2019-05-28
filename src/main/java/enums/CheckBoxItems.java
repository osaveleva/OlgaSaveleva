package enums;


public enum CheckBoxItems {

    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire");

    private String record;

    CheckBoxItems(String record) {
        this.record = record;
    }

    public String getRecord() {
        return record;
    }


}
