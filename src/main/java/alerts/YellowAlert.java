package alerts;

public class YellowAlert {

    public String customerID;
    public String churn;
    public Alerts alert;
    public double churnProbability;

    @Override
    public String toString() {
        return "Yellow Alert{" +
                "customerID= '" + customerID + '\'' +
                ", Did churn for real: = '" + churn + '\'' +
                ", Calculated Churn Probability: = " + churnProbability +
                ", Alert Type:= " + alert +
                '}';
    }
}
