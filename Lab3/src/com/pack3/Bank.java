package com.pack3;
import com.pack1.Money;
/**
 * Класс <b>Банк</b>, необходимый для одобрения перевода денег
 * @author Vavashka23
 * @version 1.0
 */
public class Bank {
    /**Поле имя*/
    private String name;
    /**Поле деньги*/
    private Money money;
    /**Поле банкомат*/
    private ATM atm;
    /**
     * Конструктор для создания экземпляра класса <b>Банк</b>
     * @param _name
     */
    public Bank(String _name) {
        this.name = _name;
    }

    /**
     * Функция получения запроса на деньги
     * @return true
     */
    public boolean takeRequestForMoney() {
        return true;
    }

    /**
     * Функция выдачи денег
     * @param flag
     * @return сообщения о состоянии перевода
     */
    public String giveMoneyFromBank(Boolean flag) {
        if(flag)
        return new String("-Запрос одобрен банком: "+name+"\n");
        else return new String("-Запрос отклонён.\n");
    }
}
