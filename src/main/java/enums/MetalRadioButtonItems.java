package enums;


public enum MetalRadioButtonItems {

    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");

    private String record;

    MetalRadioButtonItems(String record) {
        this.record = record;
    }

    public String getRecord() {
        return record;
    }


}
