package enums;

public enum SubMenuItems {

    SUPPORT ("Support"),
    DATES ("Dates"),
    COMPLEXTABLE ("Complex Table"),
    SIMPLETABLE("Simple Table"),
    PAGESTABLE("Table with pages"),
    DIFFELEMENTS("Different elements");

    private String record;

    SubMenuItems(String record) {
        this.record = record;
    }

    public String getRecord() {
        return record;
    }


}
