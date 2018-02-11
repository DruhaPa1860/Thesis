package alerts;

public class RedAlert {

    public String customerID;
    public String churn;
    public Alerts alert;
    public double churnProbability;



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
        return "Red Alert{" +
                "customerID= '" + customerID + '\'' +
                ", Did churn for real: = '" + churn + '\'' +
                ", Calculated Churn Probability: = " + churnProbability +
                ", Alert Type:= " + alert +
                '}';
    }
}
