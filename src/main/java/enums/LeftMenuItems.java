package enums;


public enum LeftMenuItems {

    SERVICE("Service"),
    CONTACT_FORM("Contact form"),
    HOME("Home"),
    METALS_COLORS("Metals & Colors"),
    ELEMENTS_PACK("Elements packs"),
    DIFFERENT_ELEMENTS("Different elements"),
    DATES("Dates");

    private String record;

    LeftMenuItems(String record) {
        this.record = record;
    }

    public String getRecord() {
        return record;
    }

}
