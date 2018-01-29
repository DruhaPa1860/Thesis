package flink;

import customer.Customer;
import ml.ChurnPredictor;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;

public final class Tokenizer implements FlatMapFunction<String, Customer> {
    private static final long serialVersionUID = 1L;

    @Override
    public void flatMap(String value, Collector<Customer> out) {
        // normalize and split the line
        String[] tokens = value.split("\\R");
        String remainder;
        Customer currentCustomer = new Customer();

        // emit the pairs
        for (String token : tokens) {
            if (token.length() > 0) {
                //get cust id from token

                try {
                    currentCustomer.setCustomerID(token.substring(0, token.indexOf(",")));
                    remainder = token.substring(token.indexOf(",") + 1, token.length());
                    currentCustomer.setGender(remainder.substring(0, remainder.indexOf(",")));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    currentCustomer.setCeniorCitizen(Integer.parseInt(remainder.substring(0, remainder.indexOf(","))));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    currentCustomer.setPartner(Boolean.parseBoolean(remainder.substring(0, remainder.indexOf(","))));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    currentCustomer.setHasDependents(Boolean.parseBoolean(remainder.substring(0, remainder.indexOf(","))));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    currentCustomer.setTenures(Integer.parseInt(remainder.substring(0, remainder.indexOf(","))));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    currentCustomer.setHasphoneService(Boolean.parseBoolean(remainder.substring(0, remainder.indexOf(","))));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    currentCustomer.setHasMultipleLines(remainder.substring(0, remainder.indexOf(",")));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    currentCustomer.setInternetService(remainder.substring(0, remainder.indexOf(",")));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    currentCustomer.setHasOnlineSecurity(remainder.substring(0, remainder.indexOf(",")));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    currentCustomer.setHasOnlineBackup(remainder.substring(0, remainder.indexOf(",")));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    currentCustomer.setHasDeviceProtection(remainder.substring(0, remainder.indexOf(",")));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    currentCustomer.setHasTechSupport(remainder.substring(0, remainder.indexOf(",")));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    currentCustomer.setHasStreamingTV(remainder.substring(0, remainder.indexOf(",")));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    currentCustomer.setHasStreamingMovies(remainder.substring(0, remainder.indexOf(",")));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    currentCustomer.setContractType(remainder.substring(0, remainder.indexOf(",")));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    currentCustomer.setHasPaperlessBilling(remainder.substring(0, remainder.indexOf(",")));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    currentCustomer.setPaymentMethod(remainder.substring(0, remainder.indexOf(",")));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    currentCustomer.setMonthlyCharges(Double.parseDouble(remainder.substring(0, remainder.indexOf(","))));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    currentCustomer.setTotalCharges(Double.parseDouble(remainder.substring(0, remainder.indexOf(","))));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    currentCustomer.setChurn(remainder);
                } catch (NumberFormatException exception) {
                    throw new NumberFormatException("Tokenizing failed");
                }

                //Attach ML Prediction
                currentCustomer.calculateChurnProbability();

                out.collect(currentCustomer);
            }
        }
    }
}