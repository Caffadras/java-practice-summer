package model;

public class Credit implements Convertible<Credit>, Nameable{
    private String name;
    private String creditType;
    private Currency currency;
    private Double annualPercentage;

    public Credit() {
    }

    public Credit(String name, String creditType, Currency currency, Double annualPercentage) {
        this.name = name;
        this.creditType = creditType;
        this.currency = currency;
        this.annualPercentage = annualPercentage;
    }

    public String getCreditType() {
        return creditType;
    }

    public void setCreditType(String creditType) {
        this.creditType = creditType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Double getAnnualPercentage() {
        return annualPercentage;
    }

    public void setAnnualPercentage(Double annualPercentage) {
        this.annualPercentage = annualPercentage;
    }

    @Override
    public void convert(Credit credit){
        setName(credit.getName());
        setCreditType(credit.getCreditType());
        setCurrency(credit.getCurrency());
        setAnnualPercentage(credit.getAnnualPercentage());
    }

    @Override
    public String getName() {
        return name;
    }

}
