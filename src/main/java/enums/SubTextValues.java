package enums;


public enum SubTextValues {

    PRACTICE("To include good practices\nand ideas from successful\nEPAM project"),
    FLEXIBLE("To be flexible and\ncustomizable"),
    MULTIPLATFORM("To be multiplatform"),
    BASE("Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

    private String record;

    SubTextValues(String record) {
        this.record = record;
    }

    public String getRecord() {
        return record;
    }


}
