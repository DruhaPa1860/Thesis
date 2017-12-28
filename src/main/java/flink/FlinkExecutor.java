package flink;

import customer.Customer;
import org.apache.flink.cep.CEP;
import org.apache.flink.cep.PatternStream;
import org.apache.flink.cep.pattern.Pattern;
import org.apache.flink.cep.pattern.conditions.IterativeCondition;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import util.Utils;

import java.util.ArrayList;

public class FlinkExecutor {
    public static void executeChurnPrediction() {
        ArrayList<String> inputData = Utils.importData();

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        DataStream<Customer> dataStream = env.fromCollection(inputData).flatMap(new Tokenizer());

        Pattern<Customer, ?> warningPattern = Pattern.<Customer>begin("first")
                .subtype(ChurnEvent.class)
                .where(new IterativeCondition<ChurnEvent>() {
                    private static final long serialVersionUID = -6301755149429716724L;

                    @Override
                    public boolean filter(ChurnEvent value, Context<ChurnEvent> ctx) throws Exception {
                        return value.getPredictionValue() >= 0.5;
                    }
                });

        /*PatternStream<Customer> tempPatternStream = CEP.pattern(
                dataStream.keyBy(0),
                warningPattern);*/

        //dataStream.print();

        try {
            env.execute("Customer Churn Prediction");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.print("Finished");
    }
}
