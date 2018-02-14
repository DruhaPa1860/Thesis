package flink;

import customer.Customer;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;

public final class Tokenizer implements FlatMapFunction<Customer, Customer> {
    private static final long serialVersionUID = 1L;

    @Override
    public void flatMap(Customer event, Collector<Customer> out) {
        event.calculateChurnProbability();
        out.collect(event);
    }
}
