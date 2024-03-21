import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import java.sql.*;

public class withdrawl extends JFrame implements ActionListener{

    JTextField t1;
    JButton b1,b2;
    JLabel l1,l2;
    String pin,card;
    withdrawl(String card,String pin)
    {
        this.pin=pin;
        this.card=card;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(770,870, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l3=new JLabel(i3);
        l3.setBounds(0, 0, 700,750);
        add(l3);

        setLayout(null);
        setSize(700,750);
        setResizable(false);
        setLocation(425,40);

        l1 = new JLabel("MAXIMUM WITHDRAWAL IS RS.10,000");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(105,230,400,20);
        l3.add(l1);

        l2 = new JLabel("Enter Amount");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System", Font.PLAIN, 16));
        l2.setBounds(110,300,100,20);
        l3.add(l2);

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.PLAIN, 16));
        t1.setBounds(240,300,150,25);
        l3.add(t1);

        b1 = new JButton("WITHDRAW");
        b1.setBounds(180,380,150,25);
        l3.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(180,420,150,25);
        l3.add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        try{
            String amount=t1.getText();
            Date date=new Date();
            if(ae.getSource()==b1)
            {
                if(t1.getText().isEmpty())
                    JOptionPane.showMessageDialog(null,"Please enter the Amount to you want to Withdraw");
                else if(Integer.parseInt(amount)>10000)
                    JOptionPane.showMessageDialog(null,"Withdrawl limit is Rs.10,000");
                else
                {
                    con c1=new con();

                    ResultSet rs = c1.s.executeQuery("select * from bank where pin = '"+Integer.parseInt(pin)+"' and CardNumber ='"+Long.parseLong(card)+"'");
                    int balance=0;
                    while(rs.next())
                    {
                        if(rs.getString("transaction_type").equals("Deposit"))
                            balance+=rs.getInt("amount");
                        else
                            balance-=rs.getInt("amount");
                    }
                    if(balance<Integer.parseInt(amount))
                    {
                        JOptionPane.showMessageDialog(null,"Insuffient Balance");
                        return;
                    }
                    c1.s.executeUpdate("insert into bank values('"+Long.parseLong(card)+"','"+Integer.parseInt(pin)+"', '"+date+"', 'Withdrawl', '"+Integer.parseInt(amount)+"')");
                    JOptionPane.showMessageDialog(null,"Rs. "+amount+" Debited Successfully");

                    setVisible(false);
                    new transaction(card,pin).setVisible(true);
                }
            }
            else if(ae.getSource()==b2)
            {
                setVisible(false);
                new transaction(card,pin).setVisible(true);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    public static void main(String[] args){
        new withdrawl("","").setVisible(true);
    }
}