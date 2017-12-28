package customer;

public class CustomerMLFormat {
    private String gender;
    private String ceniorCitizen;
    private String isPartner;
    private String hasDependents;
    private String tenures;
    private String hasphoneService;
    private String hasMultipleLines;
    private String internetService;
    private String hasOnlineSecurity;
    private String hasOnlineBackup;
    private String hasDeviceProtection;
    private String hasTechSupport;
    private String hasStreamingTV;
    private String hasStreamingMovies;
    private String contractType;
    private String hasPaperlessBilling;
    private String paymentMethod;
    private String monthlyCharges;
    private String totalCharges;

    public CustomerMLFormat(Customer customer) {
        this.gender = customer.getGender();
        this.ceniorCitizen = String.valueOf(customer.getCeniorCitizen());
        this.isPartner = formatBoolean(customer.isPartner());
        this.hasDependents = formatBoolean(customer.isHasDependents());
        this.tenures = String.valueOf(customer.getTenures());
        this.hasphoneService = formatBoolean(customer.isHasphoneService());
        this.hasMultipleLines = formatHasMultipleLines(customer.isHasMultipleLines());
        this.internetService = formatInternetService(customer.getInternetService());
        this.hasOnlineSecurity = formatBooleanWithInternetServices(customer.isHasOnlineSecurity());
        this.hasOnlineBackup = formatBooleanWithInternetServices(customer.isHasOnlineBackup());
        this.hasDeviceProtection = formatBooleanWithInternetServices(customer.isHasDeviceProtection());
        this.hasTechSupport = formatBooleanWithInternetServices(customer.isHasTechSupport());
        this.hasStreamingTV = formatBooleanWithInternetServices(customer.isHasStreamingTV());
        this.hasStreamingMovies = formatBooleanWithInternetServices(customer.isHasStreamingMovies());
        this.contractType = formatContractType(customer.getContractType());
        this.hasPaperlessBilling = formatBoolean(customer.isHasPaperlessBilling());
        this.paymentMethod = formatPaymentMethod(customer.getPaymentMethod());
        this.monthlyCharges = String.valueOf(customer.getMonthlyCharges());
        this.totalCharges = String.valueOf(customer.getTotalCharges());
    }

    private String formatPaymentMethod(String paymentMethod) {
        if(paymentMethod.toLowerCase().equals("electronic check")){
            return "1,0,0,0";
        } else if(paymentMethod.toLowerCase().equals("mailed check")){
            return  "0,1,0,0";
        } else if (paymentMethod.toLowerCase().equals("Bank transfer (automatic)")){
            return  "0,0,1,0";
        }  else if (paymentMethod.toLowerCase().equals("Credit card (automatic)")){
            return  "0,0,0,1";
        }else {
            throw new IllegalArgumentException("Error Parsing paymentMethod: " + paymentMethod);
        }
    }

    private String formatContractType(String contractType) {
        if(contractType.toLowerCase().equals("month-to-month")){
            return "1,0,0";
        } else if(contractType.toLowerCase().equals("one year")){
            return  "0,1,0";
        } else if (contractType.toLowerCase().equals("two year")){
            return  "0,0,1";
        } else {
            throw new IllegalArgumentException("Error Parsing contractType: " + contractType);
        }
    }

    private String formatHasMultipleLines(String hasMultipleLines) {
        if(hasMultipleLines.toLowerCase().equals("yes")){
            return "1,0";
        } else if(hasMultipleLines.toLowerCase().equals("no")){
            return  "0,0";
        } else if (hasMultipleLines.toLowerCase().equals("no phone service")){
            return  "0,1";
        } else {
            throw new IllegalArgumentException("Error Parsing hasMultipleLines: " + hasMultipleLines);
        }
    }

    private String formatBooleanWithInternetServices(String value) {
        if(value.toLowerCase().equals("yes")){
        return "1,0";
    } else if(value.toLowerCase().equals("no")){
        return  "0,0";
    } else if (value.toLowerCase().equals("no internet service")){
        return  "0,1";
    } else {
        throw new IllegalArgumentException("Error Parsing formatBooleanWithInternetServices: " + value);
    }
}


    private String formatInternetService(String internetService) {
        if(internetService.toLowerCase().equals("dsl")){
            return "1,0,0";
        } else if(internetService.toLowerCase().equals("fiber optic")){
            return  "0,1,0";
        } else if (internetService.toLowerCase().equals("no")){
            return  "0,0,1";
        } else {
            throw new IllegalArgumentException("Error Parsing internetService: " + internetService);
        }
    }

    private String formatBoolean(boolean value) {
        if (value) {
            return "1";
        } else {
            return "0";
        }
    }

    public String toString() {
        return gender + "," + ceniorCitizen + "," + isPartner + "," + hasDependents + "," +
                tenures + "," + hasphoneService + "," + hasMultipleLines + "," +
                internetService + "," + hasOnlineSecurity + "," + hasOnlineBackup + "," +
                hasDeviceProtection + "," + hasTechSupport + "," + hasStreamingTV + "," +
                hasStreamingMovies + "," + contractType + "," + hasPaperlessBilling + "," +
                paymentMethod + "," + monthlyCharges + "," + totalCharges;
    }
}
