import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class fastcash extends JFrame implements ActionListener
{
    JLabel l1;
    JButton b1, b2, b3, b4, b5, b6, b7;
    String pin,card;
    fastcash(String card,String pin) {
        this.pin = pin;
        this.card=card;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(770,870, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 700, 750);
        add(l3);

        setLayout(null);
        setSize(700, 750);
        setLocation(425, 40);

        l1=new JLabel("SELECT WITHDRAWL AMOUNT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(115, 240, 700, 25);
        l3.add(l1);

        b1=new JButton("Rs 100");
        b1.setBounds(120, 290, 120, 25);
        l3.add(b1);

        b2=new JButton("Rs 500");
        b2.setBounds(260, 290, 120, 25);
        l3.add(b2);

        b3=new JButton("Rs 1000");
        b3.setBounds(120, 330, 120, 25);
        l3.add(b3);

        b4 = new JButton("Rs 2000");
        b4.setBounds(260, 330, 120, 25);
        l3.add(b4);

        b5 = new JButton("Rs 5000");
        b5.setBounds(120, 370, 120, 25);
        l3.add(b5);

        b6 = new JButton("Rs 10000");
        b6.setBounds(260, 370,120, 25);
        l3.add(b6);

        b7 = new JButton("BACK");
        b7.setBounds(170, 430, 150, 25);
        l3.add(b7);

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
    public void actionPerformed(ActionEvent ae) {
        try {
            if(ae.getSource()==b7)
            {
                this.setVisible(false);
                new transaction(card,pin).setVisible(true);
            }
            String amount=((JButton)ae.getSource()).getText().substring(3);
            con c=new con();
            ResultSet rs=c.s.executeQuery("select * from bank where pin = '"+Integer.parseInt(pin)+"' and CardNumber ='"+Long.parseLong(card)+"'");
            int balance=0;
            while(rs.next())
            {
                if(rs.getString("transaction_type").equals("Deposit"))
                    balance+=rs.getInt("amount");
                else
                    balance-=rs.getInt("amount");
            }
            if (ae.getSource()!=b7 && balance<Integer.parseInt(amount))
            {
                JOptionPane.showMessageDialog(null,"Insuffient Balance");
                return;
            }
            if(ae.getSource()!=b7)
            {
                Date date=new Date();
                c.s.executeUpdate("insert into bank values('"+Long.parseLong(card)+"','"+Integer.parseInt(pin)+"', '"+date+"', 'Withdrawl', '"+Integer.parseInt(amount)+"')");
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");

                setVisible(false);
                new transaction(card,pin).setVisible(true);
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    public static void main(String[] args) {
        new fastcash("","").setVisible(true);
    }
}