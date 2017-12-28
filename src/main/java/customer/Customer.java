package customer;

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
    private boolean hasPaperlessBilling;
    private String paymentMethod;
    private double monthlyCharges;
    private double totalCharges;
    private boolean churn;


    public Customer(String customerID, String gender, int ceniorCitizen,
                    boolean isPartner, boolean hasDependents, int tenures,
                    boolean hasphoneService, String hasMultipleLines, String internetService,
                    String hasOnlineSecurity, String hasOnlineBackup, String hasDeviceProtection,
                    String hasTechSupport, String hasStreamingTV, String hasStreamingMovies,
                    String contractType, boolean hasPaperlessBilling, String paymentMethod,
                    double monthlyCharges, double totalCharges, boolean churn) {

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

    public boolean isHasPaperlessBilling() {
        return hasPaperlessBilling;
    }

    public void setHasPaperlessBilling(boolean hasPaperlessBilling) {
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

    public boolean isChurn() {
        return churn;
    }

    public void setChurn(boolean churn) {
        this.churn = churn;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Customer) {
            Customer other = (Customer) obj;

            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return 41 * super.hashCode() + Double.hashCode(45);
    }
}
