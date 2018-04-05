package com.lr2;

public class Money {
    private double moneyAmount;
    private String owner;
    public Money(String _owner, double _amount) {
        this.moneyAmount = _amount;
        this.owner = _owner;
    }

    public void setMoneyAmount(double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public double getMoneyAmount() {
        return moneyAmount;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}