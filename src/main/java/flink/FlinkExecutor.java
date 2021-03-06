package flink;

import alerts.Alerts;
import alerts.BaseAlert;
import alerts.RedAlert;
import alerts.YellowAlert;
import com.sun.org.apache.regexp.internal.RE;
import customer.Customer;
import org.apache.flink.api.common.functions.RichFlatMapFunction;
import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.cep.CEP;
import org.apache.flink.cep.PatternSelectFunction;
import org.apache.flink.cep.PatternStream;
import org.apache.flink.cep.pattern.Pattern;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.core.fs.FileSystem;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.IngestionTimeExtractor;
import org.apache.flink.streaming.api.windowing.assigners.TumblingEventTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.util.Collector;
import util.Utils;

import java.util.ArrayList;
import java.util.Map;

public class FlinkExecutor {
    public static void executeChurnPrediction() {
        ArrayList<Customer> inputData2 = Utils.importDataSynthetic();
        //ArrayList<String> inputData = Utils.importData();


        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setStreamTimeCharacteristic(TimeCharacteristic.ProcessingTime);

        DataStream<Customer> upStream = env.fromCollection(inputData2)
                .flatMap(new Tokenizer());



        // CEP STARTS HERE
        Pattern<Customer, ?> alarmPattern = Pattern.<Customer>begin("BASE")
                .subtype(Customer.class)
                .where(evt -> evt.getPrediction().getChurnProbability() >= 0.4 &&
                        evt.getPrediction().getChurnProbability() < 0.6)
                .followedBy("YELLOW")
                .subtype(Customer.class)
                .where(evt -> evt.getPrediction().getChurnProbability() >= 0.6 &&
                        evt.getPrediction().getChurnProbability() < 0.8)
                .followedBy("RED")
                .subtype(Customer.class)
                .where(evt -> evt.getPrediction().getChurnProbability() >= 0.8)
                .within(Time.milliseconds(10000000))
                ;


        // Create a pattern stream from alarmPattern
        PatternStream<Customer> patternStream = CEP.pattern(upStream, alarmPattern);


        DataStream<BaseAlert> baseAlerts = patternStream.select(new PatternSelectFunction<Customer, BaseAlert>() {
            @Override
            public BaseAlert select(Map<String, Customer> pattern) throws Exception {
                Customer base = pattern.get("BASE");
                BaseAlert baseAlert = new BaseAlert();
                baseAlert.alert = Alerts.BASE;
                baseAlert.customerID = base.customerID;
                baseAlert.churnProbability = base.getPrediction().getChurnProbability();
                baseAlert.churn = base.churn;
                return baseAlert;
            }
        });

        DataStream<YellowAlert> yellowAlerts = patternStream.select(new PatternSelectFunction<Customer, YellowAlert>() {
            @Override
            public YellowAlert select(Map<String, Customer> pattern) throws Exception {
                Customer yellow = pattern.get("YELLOW");
                YellowAlert yellowAlert = new YellowAlert();
                yellowAlert.alert = Alerts.YELLOW;
                yellowAlert.customerID = yellow.customerID;
                yellowAlert.churnProbability = yellow.getPrediction().getChurnProbability();
                yellowAlert.churn = yellow.churn;
                return yellowAlert;
            }
        });

        DataStream<RedAlert> redAlerts = patternStream.select(new PatternSelectFunction<Customer, RedAlert>() {
            @Override
            public RedAlert select(Map<String, Customer> pattern) throws Exception {
                Customer red = pattern.get("RED");
                RedAlert redAlert = new RedAlert();
                redAlert.alert = Alerts.RED;
                redAlert.customerID = red.customerID;
                redAlert.churnProbability = red.getPrediction().getChurnProbability();
                redAlert.churn = red.churn;
                return redAlert;
            }
        });

        baseAlerts.keyBy("customerID").flatMap(new DuplicateFilterBase()).print();
        yellowAlerts.keyBy("customerID").flatMap(new DuplicateFilterYellow()).print();
        redAlerts.keyBy("customerID").flatMap(new DuplicateFilterRed()).print();




        try {
            env.execute("Customer Churn Prediction");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.print("FinishedX");
    }

    public static class DuplicateFilterRed extends RichFlatMapFunction<RedAlert, RedAlert> {

        static final ValueStateDescriptor<Boolean> descriptor = new ValueStateDescriptor<>("seen", Boolean.class, false);
        private ValueState<Boolean> operatorState;

        @Override
        public void open(Configuration configuration) {
            operatorState = this.getRuntimeContext().getState(descriptor);
        }

        @Override
        public void flatMap(RedAlert value, Collector out) throws Exception {
            if (!operatorState.value()) {
                // we haven't seen the element yet
                out.collect(value);
                // set operator state to true so that we don't emit elements with this key again
                operatorState.update(true);
            }
        }
    }

    public static class DuplicateFilterYellow extends RichFlatMapFunction<YellowAlert, YellowAlert> {

        static final ValueStateDescriptor<Boolean> descriptor = new ValueStateDescriptor<>("seen", Boolean.class, false);
        private ValueState<Boolean> operatorState;

        @Override
        public void open(Configuration configuration) {
            operatorState = this.getRuntimeContext().getState(descriptor);
        }

        @Override
        public void flatMap(YellowAlert value, Collector out) throws Exception {
            if (!operatorState.value()) {
                // we haven't seen the element yet
                out.collect(value);
                // set operator state to true so that we don't emit elements with this key again
                operatorState.update(true);
            }
        }
    }
    public static class DuplicateFilterBase extends RichFlatMapFunction<BaseAlert, BaseAlert> {

        static final ValueStateDescriptor<Boolean> descriptor = new ValueStateDescriptor<>("seen", Boolean.class, false);
        private ValueState<Boolean> operatorState;

        @Override
        public void open(Configuration configuration) {
            operatorState = this.getRuntimeContext().getState(descriptor);
        }

        @Override
        public void flatMap(BaseAlert value, Collector out) throws Exception {
            if (!operatorState.value()) {
                // we haven't seen the element yet
                out.collect(value);
                // set operator state to true so that we don't emit elements with this key again
                operatorState.update(true);
            }
        }
    }
}
