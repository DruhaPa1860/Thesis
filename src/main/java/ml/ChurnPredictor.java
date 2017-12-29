package ml;

import customer.Customer;
import customer.CustomerMLFormat;
import hex.genmodel.MojoModel;
import hex.genmodel.easy.EasyPredictModelWrapper;
import hex.genmodel.easy.RowData;
import hex.genmodel.easy.exception.PredictException;
import hex.genmodel.easy.prediction.BinomialModelPrediction;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

public class ChurnPredictor {

    public Prediction predictCustomerChurn(Customer customer) {

        EasyPredictModelWrapper model = null;

        try {
            model = new EasyPredictModelWrapper(MojoModel.load("src" + File.separator + "main" +
                    File.separator + "ressources" + File.separator + "drf_5e1882dd_1db5_4b44_beea_68cd60205fb5.zip"));
        } catch (IOException e) {
            System.out.println(e.toString());
        }

        List<String> featureList = new CustomerMLFormat(customer).getFeatureList();

        RowData row = new RowData();
        row.put("C1", featureList.get(0));
        row.put("C2", featureList.get(1));
        row.put("C3", featureList.get(2));
        row.put("C4", featureList.get(3));
        row.put("C5", featureList.get(4));
        row.put("C6", featureList.get(5));
        row.put("C7", featureList.get(6));
        row.put("C8", featureList.get(7));
        row.put("C9", featureList.get(8));
        row.put("C10", featureList.get(9));
        row.put("C11", featureList.get(10));
        row.put("C12", featureList.get(11));
        row.put("C13", featureList.get(12));
        row.put("C14", featureList.get(13));
        row.put("C15", featureList.get(14));
        row.put("C16", featureList.get(15));
        row.put("C17", featureList.get(16));
        row.put("C18", featureList.get(17));
        row.put("C19", featureList.get(18));
        row.put("C20", featureList.get(19));
        row.put("C21", featureList.get(20));
        row.put("C22", featureList.get(21));
        row.put("C23", featureList.get(22));
        row.put("C24", featureList.get(23));
        row.put("C25", featureList.get(23));
        row.put("C26", featureList.get(25));
        row.put("C27", featureList.get(26));
        row.put("C28", featureList.get(27));
        row.put("C29", featureList.get(28));
        row.put("C30", featureList.get(29));
        row.put("C31", featureList.get(30));
        row.put("C32", featureList.get(31));
        row.put("C33", featureList.get(32));

        BinomialModelPrediction p = null;

        try {
            p = model.predictBinomial(row);
        } catch (PredictException e) {
            System.out.println(e.toString());
        }

        Prediction prediction = new Prediction();
        prediction.setCustomerID(customer.getCustomerID());
        prediction.setWillChurn(p.label);
        prediction.setChurnProbability(p.classProbabilities[1]);

        return prediction;
    }
}
