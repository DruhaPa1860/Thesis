package alerts;

public class BaseAlert {

    public String customerID;
    public String churn;
    public Alerts alert;
    public double churnProbability;

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
