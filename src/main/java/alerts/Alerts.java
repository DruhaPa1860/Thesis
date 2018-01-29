package alerts;

public enum Alerts {
    BASE("BASE"),
    YELLOW("YELLOW"),
    RED("RED");


    private final String alert;

    Alerts(String alert) {
        this.alert = alert;
    }

    public String getAlert() {
        return this.alert;
    }
}
