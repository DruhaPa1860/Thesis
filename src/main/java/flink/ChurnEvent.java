package flink;

import customer.Customer;

public class ChurnEvent extends Customer {
    public ChurnEvent(String customerID, String gender, int ceniorCitizen,
                      boolean isPartner, boolean hasDependents, int tenures,
                      boolean hasphoneService, String hasMultipleLines, String internetService,
                      String hasOnlineSecurity, String hasOnlineBackup, String hasDeviceProtection,
                      String hasTechSupport, String hasStreamingTV, String hasStreamingMovies,
                      String contractType, String hasPaperlessBilling, String paymentMethod,
                      double monthlyCharges, double totalCharges, String churn) {

        super(customerID, gender, ceniorCitizen, isPartner, hasDependents,
                tenures, hasphoneService, hasMultipleLines, internetService,
                hasOnlineSecurity, hasOnlineBackup, hasDeviceProtection,
                hasTechSupport, hasStreamingTV, hasStreamingMovies, contractType,
                hasPaperlessBilling, paymentMethod, monthlyCharges, totalCharges, churn);
    }
    public double getPredictionValue(){
        return 0.5;
    }
}
