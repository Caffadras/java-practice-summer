package model;

import java.time.LocalDate;
import java.time.Period;

public class Contract implements Nameable, Convertible<Contract>{
    private String name;
    private Long number;
    private LocalDate agreementDate;
    private Client client;
    private Credit credit;
    private Double totalSum;
    private LocalDate repaymentDate;
    private Bank bank;

    public Contract(Long number, LocalDate agreementDate, Client client, Credit credit,
                    Double totalSum, LocalDate repaymentDate, Bank bank) {
        this.number = number;
        this.agreementDate = agreementDate;
        this.client = client;
        this.credit = credit;
        this.totalSum = totalSum;
        this.repaymentDate = repaymentDate;
        this.bank = bank;

        if (bank != null){
            bank.addContract(this);
        }

        generateName();
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public LocalDate getAgreementDate() {
        return agreementDate;
    }

    public void setAgreementDate(LocalDate agreementDate) {
        this.agreementDate = agreementDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    public Double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(Double totalSum) {
        this.totalSum = totalSum;
    }

    public LocalDate getRepaymentDate() {
        return repaymentDate;
    }

    public void setRepaymentDate(LocalDate repaymentDate) {
        this.repaymentDate = repaymentDate;
    }

    public Double calculateCreditIncome(){
        Period period =  Period.between(getAgreementDate(), getRepaymentDate());
        int repaymentsCount = period.getYears() * 12 + period.getMonths();
        return (getTotalSum() / 100.0) * (getCredit().getAnnualPercentage() /12) *
                (repaymentsCount == 0? 1 : repaymentsCount);
    }

    @Override
    public String getName(){
        return name;
    }

    private void generateName(){
        this.name = "Contract Nr. " + getNumber().toString();
    }

    @Override
    public void convert(Contract newObjectFields) {
        if (newObjectFields == null)  throw new RuntimeException("Cannot convert to null object!");

        setNumber(newObjectFields.getNumber());
        setAgreementDate(newObjectFields.getAgreementDate());
        setClient(newObjectFields.getClient());
        setCredit(newObjectFields.getCredit());
        setTotalSum(newObjectFields.getTotalSum());
        setRepaymentDate(newObjectFields.getRepaymentDate());
        setBank(newObjectFields.getBank());

        generateName();
    }
}
