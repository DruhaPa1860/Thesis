package customer;

import ml.ChurnPredictor;
import ml.Prediction;

public class Customer {

    private String customerID;
    private String gender;
    private int ceniorCitizen;
    private boolean isPartner;
    private boolean hasDependents;
    private int tenures;
    private boolean hasphoneService;
    private String hasMultipleLines;
    private String internetService;
    private String hasOnlineSecurity;
    private String hasOnlineBackup;
    private String hasDeviceProtection;
    private String hasTechSupport;
    private String hasStreamingTV;
    private String hasStreamingMovies;
    private String contractType;
    private String hasPaperlessBilling;
    private String paymentMethod;
    private double monthlyCharges;
    private double totalCharges;
    private String churn;
    private Prediction prediction;


    public Customer(String customerID, String gender, int ceniorCitizen,
                    boolean isPartner, boolean hasDependents, int tenures,
                    boolean hasphoneService, String hasMultipleLines, String internetService,
                    String hasOnlineSecurity, String hasOnlineBackup, String hasDeviceProtection,
                    String hasTechSupport, String hasStreamingTV, String hasStreamingMovies,
                    String contractType, String hasPaperlessBilling, String paymentMethod,
                    double monthlyCharges, double totalCharges, String churn, Prediction prediction) {

        this.customerID = customerID;
        this.gender = gender;
        this.ceniorCitizen = ceniorCitizen;
        this.isPartner = isPartner;
        this.hasDependents = hasDependents;
        this.tenures = tenures;
        this.hasphoneService = hasphoneService;
        this.hasMultipleLines = hasMultipleLines;
        this.internetService = internetService;
        this.hasOnlineSecurity = hasOnlineSecurity;
        this.hasOnlineBackup = hasOnlineBackup;
        this.hasDeviceProtection = hasDeviceProtection;
        this.hasTechSupport = hasTechSupport;
        this.hasStreamingTV = hasStreamingTV;
        this.hasStreamingMovies = hasStreamingMovies;
        this.contractType = contractType;
        this.hasPaperlessBilling = hasPaperlessBilling;
        this.paymentMethod = paymentMethod;
        this.monthlyCharges = monthlyCharges;
        this.totalCharges = totalCharges;
        this.churn = churn;
    }

    public Customer() {

    }

    public Prediction getPrediction() {
        return prediction;
    }

    public Prediction getPrediction1() {
        this.calculateChurnProbability();
        return prediction;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getCeniorCitizen() {
        return ceniorCitizen;
    }

    public void setCeniorCitizen(int ceniorCitizen) {
        this.ceniorCitizen = ceniorCitizen;
    }

    public boolean isPartner() {
        return isPartner;
    }

    public void setPartner(boolean partner) {
        isPartner = partner;
    }

    public boolean isHasDependents() {
        return hasDependents;
    }

    public void setHasDependents(boolean hasDependents) {
        this.hasDependents = hasDependents;
    }

    public int getTenures() {
        return tenures;
    }

    public void setTenures(int tenures) {
        this.tenures = tenures;
    }

    public boolean isHasphoneService() {
        return hasphoneService;
    }

    public void setHasphoneService(boolean hasphoneService) {
        this.hasphoneService = hasphoneService;
    }

    public String isHasMultipleLines() {
        return hasMultipleLines;
    }

    public void setHasMultipleLines(String hasMultipleLines) {
        this.hasMultipleLines = hasMultipleLines;
    }

    public String getInternetService() {
        return internetService;
    }

    public void setInternetService(String internetService) {
        this.internetService = internetService;
    }

    public String isHasOnlineSecurity() {
        return hasOnlineSecurity;
    }

    public void setHasOnlineSecurity(String hasOnlineSecurity) {
        this.hasOnlineSecurity = hasOnlineSecurity;
    }

    public String isHasOnlineBackup() {
        return hasOnlineBackup;
    }

    public void setHasOnlineBackup(String hasOnlineBackup) {
        this.hasOnlineBackup = hasOnlineBackup;
    }

    public String isHasDeviceProtection() {
        return hasDeviceProtection;
    }

    public void setHasDeviceProtection(String hasDeviceProtection) {
        this.hasDeviceProtection = hasDeviceProtection;
    }

    public String isHasTechSupport() {
        return hasTechSupport;
    }

    public void setHasTechSupport(String hasTechSupport) {
        this.hasTechSupport = hasTechSupport;
    }

    public String isHasStreamingTV() {
        return hasStreamingTV;
    }

    public void setHasStreamingTV(String hasStreamingTV) {
        this.hasStreamingTV = hasStreamingTV;
    }

    public String isHasStreamingMovies() {
        return hasStreamingMovies;
    }

    public void setHasStreamingMovies(String hasStreamingMovies) {
        this.hasStreamingMovies = hasStreamingMovies;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public String isHasPaperlessBilling() {
        return hasPaperlessBilling;
    }

    public void setHasPaperlessBilling(String hasPaperlessBilling) {
        this.hasPaperlessBilling = hasPaperlessBilling;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getMonthlyCharges() {
        return monthlyCharges;
    }

    public void setMonthlyCharges(double monthlyCharges) {
        this.monthlyCharges = monthlyCharges;
    }

    public double getTotalCharges() {
        return totalCharges;
    }

    public void setTotalCharges(double totalCharges) {
        this.totalCharges = totalCharges;
    }

    public String isChurn() {
        return churn;
    }

    public void setChurn(String churn) {
        this.churn = churn;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public Prediction calculateChurnProbability() {
        this.prediction = ChurnPredictor.predictCustomerChurn(this);
        return prediction;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID='" + customerID + '\'' +
                ", gender='" + gender + '\'' +
                ", ceniorCitizen=" + ceniorCitizen +
                ", isPartner=" + isPartner +
                ", hasDependents=" + hasDependents +
                ", tenures=" + tenures +
                ", hasphoneService=" + hasphoneService +
                ", hasMultipleLines='" + hasMultipleLines + '\'' +
                ", internetService='" + internetService + '\'' +
                ", hasOnlineSecurity='" + hasOnlineSecurity + '\'' +
                ", hasOnlineBackup='" + hasOnlineBackup + '\'' +
                ", hasDeviceProtection='" + hasDeviceProtection + '\'' +
                ", hasTechSupport='" + hasTechSupport + '\'' +
                ", hasStreamingTV='" + hasStreamingTV + '\'' +
                ", hasStreamingMovies='" + hasStreamingMovies + '\'' +
                ", contractType='" + contractType + '\'' +
                ", hasPaperlessBilling='" + hasPaperlessBilling + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", monthlyCharges=" + monthlyCharges +
                ", totalCharges=" + totalCharges +
                ", churn='" + churn + '\'' +
                '}';
    }
}
