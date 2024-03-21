import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class statement extends JFrame implements ActionListener
{
    JButton b1;
    JLabel l1;
    statement(String card,String pin){
        super("Mini Statement");
        getContentPane().setBackground(Color.WHITE);
        setSize(400,600);
        setResizable(false);
        setLocation(20,20);

        l1=new JLabel();
        add(l1);

        JLabel l2 = new JLabel("Indian Bank");
        l2.setBounds(150, 20, 100, 20);
        add(l2);

        JLabel l3 = new JLabel();
        l3.setBounds(20, 80, 300, 20);
        add(l3);

        JLabel l4 = new JLabel();
        l4.setBounds(20, 400, 300, 20);
        add(l4);

        try{
            con c = new con();
            ResultSet rs = c.s.executeQuery("select * from login where (pin = '"+pin+"') and (CardNumber ='"+card+"')");
            while(rs.next())
                l3.setText("Card Number:    "+rs.getString("CardNumber").substring(0, 4)+"XXXXXXXX"+rs.getString("CardNumber").substring(12));
        }
        catch(Exception e){}

        try{
            int balance = 0;
            con c1=new con();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM bank where pin = '"+pin+"' and CardNumber ='"+card+"'");
            while(rs.next())
            {
                l1.setText(l1.getText()+"<html>"+
                        rs.getString("transaction_date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
                        rs.getString("transaction_type")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
                        rs.getString("amount")+
                        "<br><br><html>");

                if(rs.getString("transaction_type").equals("Deposit"))
                    balance += Integer.parseInt(rs.getString("amount"));
                else
                    balance -= Integer.parseInt(rs.getString("amount"));
            }
            l4.setText("Your total Balance is Rs "+balance);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        setLayout(null);
        b1=new JButton("Exit");
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.black);
        add(b1);

        b1.addActionListener(this);

        l1.setBounds(20, 140, 400, 200);
        b1.setBounds(20, 500, 100, 25);
    }
    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
    }

    public static void main(String[] args){
        new statement("","").setVisible(true);
    }

}