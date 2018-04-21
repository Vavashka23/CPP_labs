package com.GUI;
/**
 * Класс <b>Мейн</b>, необходимый для создания окошка
 * @author Vavashka23
 * @version 1.0
 */
public class Main {
    /**
     * Функция входа в программу
     * @param args
     */
    public static void main(String[] args) {
        MyGUI myGUI = new MyGUI("ATM");
        myGUI.setVisible(true);
    }
}