package enums;

public enum LogRecordsVipCheckBox {

    TEMPLATE("Vip: condition changed to %s");

    private String record;

    LogRecordsVipCheckBox(String record) {
        this.record = record;
    }

    public static String getRecord(String element) {
        return String.format(TEMPLATE.record, element);
    }


}
