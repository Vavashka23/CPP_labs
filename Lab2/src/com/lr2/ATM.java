package com.lr2;

import java.util.Random;
/**
 * Класс <b>Банкомат</b>
 * @author Vavashka23
 * @version 1.0
 */
public class ATM {
    /**Поле банк*/
    private String Bank;
    /**Поле деньги*/
    private Money money;
    /**Поле клиент*/
    private Client client;
    /**
     * Конструктор для создания экземпляра класс <b>Банкомат</b>
     * @param _bank
     */
    public ATM(String _bank){
        this.Bank = _bank;
    }

    /**
     * Функция создания пароля
     * @return новый пароль
     */
    public String checkPassword() {
        String _password = new String();
        Random random = new Random(System.currentTimeMillis());
        for(int i=0; i<8;i++) {
            int number = random.nextInt(10);
            _password+= number;
        }
        return _password;
    }

    /**
     * Функция отдачи денег клиенту
     * @param client
     */
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

    /**
     * Функция сеттер
     * @param money
     */
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