package flink;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;

public final class Tokenizer implements FlatMapFunction<String, Customer> {
    private static final long serialVersionUID = 1L;
    private String customerID;
    private String customerData;

    @Override
    public void flatMap(String value, Collector<Customer> out) {
        // normalize and split the line
        String[] tokens = value.toLowerCase().split("\\R");

        // emit the pairs
        for (String token : tokens) {
            if (token.length() > 0) {
                //get cust id from token
                customerID = token.substring( 0, token.indexOf(","));
                customerData = token.substring(token.indexOf(",")+1, token.length());
                out.collect(new Customer(customerID, customerData));
            }
        }
    }
}