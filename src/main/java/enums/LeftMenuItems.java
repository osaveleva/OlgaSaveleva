package enums;


public enum LeftMenuItems {

    SERVICE("Service"),
    CONTACT_FORM("Contact form"),
    HOME("Home"),
    METALS_COLORS("Metals & Colors"),
    ELEMENTS_PACK("Elements packs");

    private String record;

    LeftMenuItems(String record) {
        this.record = record;
    }

    public String getRecord() {
        return record;
    }


}
