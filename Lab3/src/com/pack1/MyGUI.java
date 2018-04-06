package com.pack1;
import com.pack3.Bank;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Класс <b>My GUI</b>, необходимый для создания графического интерфейса пользователя
 * @author Vavashka23
 * @version 1.0
 */
public class MyGUI extends JFrame {
    private JLabel moneyGetMess = new JLabel("Get your money!!!");
    private JButton withdrawMoney = new JButton("Withdraw money from the account");
    private JLabel inputMess = new JLabel("Enter the password: ");
    private JTextField textField = new JTextField("", 10);
    private JLabel name = new JLabel("Active user: Student"); //need fix
    private Student client = new Student("Vova");  //maybe public
    private Money money = new Money("ATM", 1000);
    private ATM atm = new ATM("Vavashka's BANK");
    private JTextArea textArea = new JTextArea("",6,20);
    private JButton okButton = new JButton("Check");
    private String password = new String();
    private boolean flag = true;
    private Bank bank = new Bank("Vavashka's BANK");

    /**
     * Конструктор для создания экземпляра класс <b>My GUI</b>
     * @param _name
     */
    public MyGUI(String _name) {
        super(_name);
        atm.setMoney(money);
        setBounds(200, 200, 500,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        client.setAtm(atm);
        password += client.getMoney();
        withdrawMoney.addActionListener(new getMoneyAction());
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(gbl);
        moneyGetMess.setVisible(false);
        inputMess.setVisible(false);
        textField.setVisible(false);
        okButton.setVisible(false);
        textArea.setBackground(Color.LIGHT_GRAY);
        textArea.setDisabledTextColor(Color.BLACK);
        textArea.setEnabled(false);

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        gbl.setConstraints(name, c);
        add(name);

        c.gridx = 2;
        c.gridy = 0;
        c.gridheight = 4;
        c.gridwidth = 1;
        c.insets = new Insets(0,10,0,0);
        gbl.setConstraints(textArea, c);
        add(textArea);

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.gridheight = 1;
        gbl.setConstraints(withdrawMoney, c);
        add(withdrawMoney);

        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        c.gridheight = 1;
        gbl.setConstraints(inputMess, c);
        add(inputMess);

        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 1;
        c.gridheight = 1;
        gbl.setConstraints(textField, c);
        add(textField);

        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 2;
        c.gridheight = 1;
        gbl.setConstraints(okButton, c);
        add(okButton);

        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 2;
        c.gridheight = 1;
        gbl.setConstraints(moneyGetMess, c);
        add(moneyGetMess);
    }

    public class getMoneyAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            textArea.setText("-Запрос на снятие денег со счёта\n-Генерация рандомного пароля\n");
            name.setText("New password: " + password);
            withdrawMoney.setVisible(false);
            inputMess.setVisible(true);
            textField.setVisible(true);
            okButton.setVisible(true);
            okButton.addActionListener(new checkAction());
        }
    }

    public class checkAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(password.equals(textField.getText()))
            {
                textArea.setText(textArea.getText()+atm.requestForMoney(bank));
                atm.giveMoney(client);
                name.setText("New money owner: " + money.getOwner());
                okButton.setVisible(false);
                inputMess.setText("Money count: " + money.getMoneyAmount());
                textField.setVisible(false);
                moneyGetMess.setVisible(true);
                textArea.setText(textArea.getText()+ "-Смена владельца\n-Снятие денег со счёта");
            }
            else {
                name.setText("New password: " + password);
                inputMess.setText("Try again: ");
                textField.setText("");
                if(flag) {
                    textArea.setText(textArea.getText()+"-Неверный ввод пароля\n");
                    flag = false;
                }
            }
        }
    }
}