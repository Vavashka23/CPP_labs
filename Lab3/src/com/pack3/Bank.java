package com.pack3;
import com.pack1.Money;

public class Bank {
    private String name;

    public Bank(String _name) {
        this.name = _name;
    }

    public boolean takeRequestForMoney() {
        return true;
    }

    public String giveMoneyFromBank(Boolean flag) {
        if(flag)
        return new String("-Запрос одобрен банком: "+name+"\n");
        else return new String("-Запрос отклонён.\n");
    }
}
