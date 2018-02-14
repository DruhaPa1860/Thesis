package util;

import customer.Customer;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

public class Utils {

    public static ArrayList<String> importData() {
        ArrayList<String> data = new ArrayList<>();
        String CurrentLine = "";

        try (BufferedReader br = new BufferedReader(new FileReader("src" + File.separator + "main" + File.separator + "ressources" + File.separator + "data"))) {

            while ((CurrentLine = br.readLine()) != null) {
                data.add(CurrentLine);
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }

        return data;
    }

    public static ArrayList<Customer> importDataSynthetic() {
        ArrayList<Customer> data = new ArrayList<>();
        String CurrentLine = "";

        try (BufferedReader br = new BufferedReader(new FileReader("src" + File.separator + "main" + File.separator + "ressources" + File.separator + "dataTest"))) {

            while ((CurrentLine = br.readLine()) != null) {
                Customer temp = getCustomerAsPojo(CurrentLine);
                data.add(temp);
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }

        return data;
    }

    public static Customer getCustomerAsPojo(String currentCsvLine) {
        String remainder;
        Customer currentCustomer = new Customer();

        // emit the pairs
        for (String token : currentCsvLine.split("\\R")) {
            if (token.length() > 0) {
                //get cust id from token

                try {
                    currentCustomer.setCustomerID(token.substring(0, token.indexOf(",")));
                    remainder = token.substring(token.indexOf(",") + 1, token.length());
                    currentCustomer.setGender(remainder.substring(0, remainder.indexOf(",")));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    currentCustomer.setCeniorCitizen(Integer.parseInt(remainder.substring(0, remainder.indexOf(","))));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    currentCustomer.setPartner(Boolean.parseBoolean(remainder.substring(0, remainder.indexOf(","))));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    currentCustomer.setHasDependents(Boolean.parseBoolean(remainder.substring(0, remainder.indexOf(","))));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    currentCustomer.setTenures(Integer.parseInt(remainder.substring(0, remainder.indexOf(","))));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    currentCustomer.setHasphoneService(Boolean.parseBoolean(remainder.substring(0, remainder.indexOf(","))));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    currentCustomer.setHasMultipleLines(remainder.substring(0, remainder.indexOf(",")));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    currentCustomer.setInternetService(remainder.substring(0, remainder.indexOf(",")));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    currentCustomer.setHasOnlineSecurity(remainder.substring(0, remainder.indexOf(",")));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    currentCustomer.setHasOnlineBackup(remainder.substring(0, remainder.indexOf(",")));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    currentCustomer.setHasDeviceProtection(remainder.substring(0, remainder.indexOf(",")));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    currentCustomer.setHasTechSupport(remainder.substring(0, remainder.indexOf(",")));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    currentCustomer.setHasStreamingTV(remainder.substring(0, remainder.indexOf(",")));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    currentCustomer.setHasStreamingMovies(remainder.substring(0, remainder.indexOf(",")));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    currentCustomer.setContractType(remainder.substring(0, remainder.indexOf(",")));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    currentCustomer.setHasPaperlessBilling(remainder.substring(0, remainder.indexOf(",")));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    currentCustomer.setPaymentMethod(remainder.substring(0, remainder.indexOf(",")));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    currentCustomer.setMonthlyCharges(Double.parseDouble(remainder.substring(0, remainder.indexOf(","))));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    currentCustomer.setTotalCharges(Double.parseDouble(remainder.substring(0, remainder.indexOf(","))));
                    remainder = remainder.substring(remainder.indexOf(",") + 1, remainder.length());
                    currentCustomer.setChurn(remainder);
                } catch (NumberFormatException exception) {
                    throw new NumberFormatException("Tokenizing failed");
                }
            }
        }
        return currentCustomer;
    }
}

