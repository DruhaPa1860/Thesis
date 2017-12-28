package flink;

public class Customer {

    private String customerID;
    private String data;
    private String gender;
    private int ceniorCitizen;
    private boolean isPartner;
    private boolean hasDependents;
    private int tenures;
    private boolean hasphoneService;
    private boolean hasMultipleLines;
    private String InternetService;


    Customer(String customerID, String customerData){
        this.customerID = customerID;
        this.data = customerData;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
