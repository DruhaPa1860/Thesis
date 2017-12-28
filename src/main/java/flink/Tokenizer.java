package flink;

import customer.Customer;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;

public final class Tokenizer implements FlatMapFunction<String, Customer> {
    private static final long serialVersionUID = 1L;
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

    @Override
    public void flatMap(String value, Collector<Customer> out) {
        // normalize and split the line
        String[] tokens = value.toLowerCase().split("\\R");
        String remainder;

        // emit the pairs
        for (String token : tokens) {
            if (token.length() > 0) {
                //get cust id from token

                try {
                    customerID = token.substring(0, token.indexOf(","));
                    remainder = token.substring(token.indexOf(",") + 1, token.length());
                    gender = remainder.substring(0, remainder.indexOf(","));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    ceniorCitizen = Integer.parseInt(remainder.substring(0, remainder.indexOf(",")));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    isPartner = Boolean.parseBoolean(remainder.substring(0, remainder.indexOf(",")));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    hasDependents = Boolean.parseBoolean(remainder.substring(0, remainder.indexOf(",")));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    tenures = Integer.parseInt(remainder.substring(0, remainder.indexOf(",")));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    hasphoneService = Boolean.parseBoolean(remainder.substring(0, remainder.indexOf(",")));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    hasMultipleLines = remainder.substring(0, remainder.indexOf(","));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    internetService = remainder.substring(0, remainder.indexOf(","));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    hasOnlineSecurity = remainder.substring(0, remainder.indexOf(","));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    hasOnlineBackup = remainder.substring(0, remainder.indexOf(","));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    hasDeviceProtection = remainder.substring(0, remainder.indexOf(","));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    hasTechSupport = remainder.substring(0, remainder.indexOf(","));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    hasStreamingTV = remainder.substring(0, remainder.indexOf(","));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    hasStreamingMovies = remainder.substring(0, remainder.indexOf(","));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    contractType = remainder.substring(0, remainder.indexOf(","));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    hasPaperlessBilling = Boolean.parseBoolean(remainder.substring(0, remainder.indexOf(",")));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    paymentMethod = remainder.substring(0, remainder.indexOf(","));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    monthlyCharges = Double.parseDouble(remainder.substring(0, remainder.indexOf(",")));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    totalCharges = Double.parseDouble(remainder.substring(0, remainder.indexOf(",")));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    churn = Boolean.parseBoolean(remainder);
                } catch (NumberFormatException exception) {
                    throw new NumberFormatException("Tokenizing failed");
                }

                out.collect(new Customer(customerID, gender, ceniorCitizen, isPartner,
                        hasDependents, tenures, hasphoneService, hasMultipleLines,
                        internetService, hasOnlineSecurity, hasOnlineBackup, hasDeviceProtection,
                        hasTechSupport, hasStreamingTV, hasStreamingMovies, contractType,
                        hasPaperlessBilling, paymentMethod, monthlyCharges, totalCharges, churn));
            }
        }
    }
}