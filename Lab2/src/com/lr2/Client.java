package com.lr2;

public class Client {
    private String name;
    private ATM atm;
    Money money;

    public Client(String _name) {
        this.name = _name;
    }

    public void setAtm(ATM atm) {
        this.atm = atm;
    }

    public String getMoney() {
        return atm.checkPassword();
    }

    public void takeMoney(Money _money) {
        this.money = _money;
    }

    public String getName() {
        return name;
    }

    public ATM getAtm() {
        return atm;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public void setName(String name) {
        this.name = name;
    }
}