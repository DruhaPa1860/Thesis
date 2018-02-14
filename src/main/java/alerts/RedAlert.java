package alerts;

public class RedAlert {

    public String customerID;
    public String churn;
    public Alerts alert;
    public double churnProbability;

    @Override
    public String toString() {
        return "Red Alert{" +
                "customerID= '" + customerID + '\'' +
                ", Did churn for real: = '" + churn + '\'' +
                ", Calculated Churn Probability: = " + churnProbability +
                ", Alert Type:= " + alert +
                '}';
    }
}
