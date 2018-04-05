package com.lr2;
/**
 * Класс <b>Деньги</b>, необходимый для хранения данных
 * @author Vavashka23
 * @version 1.0
 */
public class Money {
    /**Поле количество денег*/
    private double moneyAmount;
    /**Поле обладатель*/
    private String owner;
    /** Конструктор для создания экземпляра класс <b>Деньги</b>
     * @param _owner - имя обладателя
     * @param _amount - количество денег
     */
    public Money(String _owner, double _amount) {
        this.moneyAmount = _amount;
        this.owner = _owner;
    }
    public void setMoneyAmount(double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    /**
     * Функция геттер
     * @return количество денег
     */
    public double getMoneyAmount() {
        return moneyAmount;
    }

    /**
     * Функция геттер
     * @return обладатель
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Функция сеттер
     * @param owner
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }
}