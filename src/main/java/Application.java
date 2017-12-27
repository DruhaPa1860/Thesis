import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import util.Utils;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args){

        final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        ArrayList<String> x = Utils.importData();

        DataSet<String> text = env.fromCollection(x);

        System.out.print("Finished");
    }
}
