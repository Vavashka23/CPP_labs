package com.lr2;

import java.util.Random;

public class ATM {
    private String Bank;
    private Money money;
    private Client client;

    public ATM(String _bank){
        this.Bank = _bank;
    }

    public String checkPassword() {
        String _password = new String();
        Random random = new Random(System.currentTimeMillis());
        for(int i=0; i<8;i++) {
            int number = random.nextInt(10);
            _password+= number;
        }
        return _password;
    }

    public void giveMoney(Client client) {
        money.setOwner(client.getName());
        client.takeMoney(money);
        money = null;
    }

    public Client getClient() {
        return client;
    }

    public Money getMoney() {
        return money;
    }

    public String getBank() {
        return Bank;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public void setBank(String bank) {
        Bank = bank;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}