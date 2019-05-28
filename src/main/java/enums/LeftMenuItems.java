package enums;


public enum LeftMenuItems {

    SERVICE("Service"),
    CONTACTFORM("Contact form"),
    HOME("Home"),
    METALSCOLORS("Metals & Colors"),
    ELEMENTSPACK("Elements packs");

    private String record;

    LeftMenuItems(String record) {
        this.record = record;
    }

    public String getRecord() {
        return record;
    }


}
