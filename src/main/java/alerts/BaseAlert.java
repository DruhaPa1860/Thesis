package alerts;

public class BaseAlert {

    public String customerID;
    public String churn;
    public Alerts alert;
    public double churnProbability;

    public BaseAlert(String customerID, String churn, Alerts alert, double churnProbability) {
        this.customerID = customerID;
        this.churn = churn;
        this.alert = alert;
        this.churnProbability = churnProbability;


    }

    public double getChurnProbability() {
        return churnProbability;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getChurn() {
        return churn;
    }

    public Alerts getAlert() {
        return alert;
    }

    @Override
    public String toString() {
        return "Base Alert{" +
                "customerID='" + customerID + '\'' +
                ", Did churn for real: ='" + churn + '\'' +
                ", Calculated Churn Probability: = " + churnProbability +
                ", Alert Type:= " + alert +
                '}';
    }
}
