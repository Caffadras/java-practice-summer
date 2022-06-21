package model;

public interface Exchanger {
    Double exchange(Currency from, Currency to, Double amount);
}
