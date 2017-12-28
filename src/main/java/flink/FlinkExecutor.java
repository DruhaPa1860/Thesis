package flink;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import util.Utils;

import java.util.ArrayList;

public class FlinkExecutor {
    public static void executeChurnPrediction(){
        ArrayList<String> inputData = Utils.importData();

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        DataStream<String> dataStream = env.fromCollection(inputData);

        DataStream<Customer> counts =
                dataStream.flatMap(new Tokenizer())
                // group by the field word and sum up the frequency
                //.keyBy("word").sum("frequency")
                ;

        counts.print();

        try {
            env.execute("Customer Churn Prediction");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.print("Finished");
    }
}
