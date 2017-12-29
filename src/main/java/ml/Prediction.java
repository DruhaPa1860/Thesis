package ml;

public class Prediction {

    private String customerID;
    private double churnProbability;
    private String willChurn;


    public double getChurnProbability() {
        return churnProbability;
    }

    public void setChurnProbability(double churnProbability) {
        this.churnProbability = churnProbability;
    }

    public String getWillChurn() {
        return willChurn;
    }

    public void setWillChurn(String willChurn) {
        this.willChurn = willChurn;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String toString() {
        return "Customer: " + this.customerID + " will churn: " + this.willChurn + " with a probability of: " +
        (this.churnProbability * 100) + "%";
    }
}
