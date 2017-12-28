import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.util.Collector;
import util.Utils;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {

        ArrayList<String> inputData = Utils.importData();

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        DataStream<Tuple2<String, Integer>> dataStream = env.fromCollection(inputData).flatMap(new Splitter());

        dataStream.print();

        try {
            env.execute("Window WordCount");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.print("Finished");
    }

    public static class Splitter implements FlatMapFunction<String, Tuple2<String, Integer>> {
        @Override
        public void flatMap(String sentence, Collector<Tuple2<String, Integer>> out) throws Exception {
            for (String word : sentence.split("\\R")) {
                out.collect(new Tuple2<String, Integer>(word, 1));
            }
        }
    }
}

