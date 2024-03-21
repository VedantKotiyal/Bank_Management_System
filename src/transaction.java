import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class transaction extends JFrame implements ActionListener{

    JLabel l1;
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin,card;
    transaction(String card,String pin) {
        this.card=card;
        this.pin=pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(770,870, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 700, 750);
        add(l2);

        setLayout(null);
        setSize(700, 750);
        setResizable(false);
        setLocation(425, 40);
        setUndecorated(true);

        l1 = new JLabel("Please Select Your Transaction");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(140, 240, 700, 35);
        l2.add(l1);

        b1 = new JButton("DEPOSIT");
        b1.setBounds(103, 300, 139, 25);
        l2.add(b1);

        b2 = new JButton("CASH WITHDRAW");
        b2.setBounds(103, 340, 139,25);
        l2.add(b2);

        b3 = new JButton("FAST CASH");
        b3.setBounds(103,380,139,25);
        l2.add(b3);

        b4 = new JButton("MINI STATEMENT");
        b4.setBounds(252, 300, 148, 25);
        l2.add(b4);

        b5 = new JButton("PIN CHANGE");
        b5.setBounds(252, 380,148,25);
        l2.add(b5);

        b6 = new JButton("BALANCE ENQUIRY");
        b6.setBounds(252, 340, 148,25);
        l2.add(b6);

        b7 = new JButton("EXIT");
        b7.setBounds(170, 420, 150, 25);
        l2.add(b7);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);

        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            setVisible(false);
            new deposit(card,pin).setVisible(true);
        }
        else if(ae.getSource()==b2)
        {
            setVisible(false);
            new withdrawl(card,pin).setVisible(true);
        }
        else if(ae.getSource()==b3)
        {
            setVisible(false);
            new fastcash(card,pin).setVisible(true);
        }
        else if(ae.getSource()==b4)
            new statement(card,pin).setVisible(true);
        else if(ae.getSource()==b5)
        {
            setVisible(false);
            new Pin(card,pin).setVisible(true);
        }
        else if(ae.getSource()==b6)
        {
            this.setVisible(false);
            new balanceenquiry(card,pin).setVisible(true);
        }
        else if(ae.getSource()==b7)
            System.exit(0);
    }

    public static void main(String[] args){
        new transaction("","").setVisible(true);
    }
}