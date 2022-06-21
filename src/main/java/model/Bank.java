package model;

import java.util.ArrayList;
import java.util.List;

public class Bank implements Convertible<Bank>, Nameable{
    private String name;
    private String address;
    private String phoneNumber;
    private List<Contract> contracts;

    public Bank() {
    }

    public Bank(String name, String address, String phoneNumber, List<Contract> contracts) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.contracts = contracts;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public void addContract(Contract credit){
        if(contracts == null){
            setContracts(new ArrayList<>());
        }
        getContracts().add(credit);
    }

    public Double calculateTotalIncome(){
        if (getContracts() != null){
            return getContracts().stream()
                    .mapToDouble(Contract::calculateCreditIncome)
                    .sum();
        }
        return 0.0D;
    }

    @Override
    public void convert(Bank bank){
        if (bank == null) throw new RuntimeException("Cannot convert to null object!");
        setName(bank.getName());
        setAddress(bank.getAddress());
        setPhoneNumber(bank.getPhoneNumber());
        setContracts(bank.getContracts());
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", contracts=" + contracts +
                '}';
    }
}
