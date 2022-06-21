package model;

import java.util.HashMap;

public final class ExchangerImpl extends ExchangeRater implements Exchanger{

    {
        exchangeRates = new HashMap<>();
        exchangeRates.put("MDL to EUR", 0.049D);
        exchangeRates.put("MDL to USD", 0.053D);
        exchangeRates.put("EUR to MDL", 20.49D);
        exchangeRates.put("EUR to USD", 1.08D);
        exchangeRates.put("USD to MDL", 19.03D);
        exchangeRates.put("USD to EUR", 0.93D);
    }


    @Override
    public Double exchange(Currency from, Currency to, Double amount) {
        String exchangeKey = from.getCode() + " to " + to.getCode();
        Double exchangeRate = exchangeRates.get(exchangeKey);
        return  amount * exchangeRate;
    }


}
