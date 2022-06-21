package model;

import java.util.HashSet;
import java.util.Set;

public class Currency {
    private String code;

    private final static Set<String> validCurrencyCodes = new HashSet<>();
    static {
        validCurrencyCodes.add("MDL");
        validCurrencyCodes.add("USD");
        validCurrencyCodes.add("EUR");
    }

    private Currency() {
    }

    private Currency(String code) {
        this.code = code;
    }

    public static Currency currencyOf(String currencyCode){
        if (validCurrencyCodes.contains(currencyCode)){
            return new Currency(currencyCode);
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}

