import com.sun.org.apache.xerces.internal.xs.StringList;
import util.Utils;

import java.util.*;

public class HistoricalPredictions {

    HashMap<String, ArrayList<String>> hmap = new HashMap<String, ArrayList<String>>();

    public void getHistoricalPredictions() {

        ArrayList<String> inputData = Utils.importData();

        for (String temp : inputData) {
            String customerID = temp.substring(0, temp.indexOf(","));

            hmap.put(customerID, Utils.importData());
        }
    }
}
