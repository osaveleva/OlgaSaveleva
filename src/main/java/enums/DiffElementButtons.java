package enums;


public enum DiffElementButtons {

    BUTTONDEFAULT("DEFAULT BUTTON"),
    BUTTON("BUTTON");

    private String record;

    DiffElementButtons(String record) {
        this.record = record;
    }

    public String getRecord() {
        return record;
    }


}
