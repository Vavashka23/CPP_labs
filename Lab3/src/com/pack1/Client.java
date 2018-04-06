package com.pack1;
/**
 * Класс <b>Клиент</b>
 * @author Vavashka23
 * @version 1.0
 */
public class Client {
    /**Поле имя*/
    protected String name;
    /**Поле-экземпляр банкомат*/
    private ATM atm;
    Money money;

    /**
     * Конструктор для создания экземпляра класс <b>Клиент</b>
     * @param _name
     */
    public Client(String _name) {
        this.name = _name;
    }

    public void setAtm(ATM atm) {
        this.atm = atm;
    }

    public String getMoney() {
        return atm.checkPassword();
    }

    /**
     * Фенкция передачи денег клиенту
     * @param _money
     */
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