package enums;


public enum NatureElementsCheckBox {

    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire");

    private String record;

    NatureElementsCheckBox(String record) {
        this.record = record;
    }

    public String getRecord() {
        return record;
    }


}
