package flink;

import alerts.Alerts;
import alerts.BaseAlert;
import alerts.RedAlert;
import alerts.YellowAlert;
import customer.Customer;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.cep.CEP;
import org.apache.flink.cep.PatternSelectFunction;
import org.apache.flink.cep.PatternStream;
import org.apache.flink.cep.pattern.Pattern;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import util.Utils;

import java.util.ArrayList;
import java.util.Map;

public class FlinkExecutor {
    public static void executeChurnPrediction() {
        ArrayList<String> inputData = Utils.importData();

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        DataStream<Customer> dataStream = env.fromCollection(inputData).flatMap(new Tokenizer());


        // CEP STARTS HERE
        Pattern<Customer, ?> alarmPattern = Pattern.<Customer>begin("BASE")
                .subtype(Customer.class)
                .where(evt -> evt.getPrediction().getChurnProbability() >= 	0.4 &&
                        evt.getPrediction().getChurnProbability() < 0.6)
                .followedBy("YELLOW")
                .subtype(Customer.class)
                .where(evt -> evt.getPrediction().getChurnProbability() >= 0.6 &&
                    evt.getPrediction().getChurnProbability() < 0.8)
                .followedBy("RED")
                .subtype(Customer.class)
                .where(evt -> evt.getPrediction().getChurnProbability() >= 0.8);

        // Create a pattern stream from alarmPattern
        PatternStream<Customer> patternStream = CEP.pattern(dataStream, alarmPattern);


        DataStream<BaseAlert> baseAlerts = patternStream.select(new PatternSelectFunction<Customer, BaseAlert>() {
            @Override
            public BaseAlert select(Map<String, Customer> pattern) throws Exception {
                Customer base = (Customer) pattern.get("BASE");
                return new BaseAlert(base.getCustomerID(), base.isChurn(), Alerts.BASE, base.getPrediction().getChurnProbability());
            }
        });

        DataStream<YellowAlert> yellowAlerts = patternStream.select(new PatternSelectFunction<Customer, YellowAlert>() {
            @Override
            public YellowAlert select(Map<String, Customer> pattern) throws Exception {
                Customer yellow = (Customer) pattern.get("YELLOW");
                return new YellowAlert(yellow.getCustomerID(), yellow.isChurn(), Alerts.YELLOW, yellow.getPrediction().getChurnProbability());
            }
        });

        DataStream<RedAlert> redAlerts = patternStream.select(new PatternSelectFunction<Customer, RedAlert>() {
            @Override
            public RedAlert select(Map<String, Customer> pattern) throws Exception {
                Customer red = (Customer) pattern.get("RED");
                return new RedAlert(red.getCustomerID(), red.isChurn(), Alerts.RED, red.getPrediction().getChurnProbability());
            }
        });

        baseAlerts.map(v -> v.toString()).print();
        yellowAlerts.map(x -> x.toString()).print();
        redAlerts.map(y -> y.toString()).print();

        try {
            env.execute("Customer Churn Prediction");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.print("FinishedX");
    }
}
