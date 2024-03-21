import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

class balanceenquiry extends JFrame implements ActionListener
{
    JButton b1;
    JLabel l1;
    String pin,card;
    balanceenquiry(String card,String pin)
    {
        this.pin = pin;
        this.card=card;

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(770,870, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 700, 750);
        add(l3);

        setLayout(null);
        setSize(700, 750);
        setResizable(false);
        setLocation(425, 40);

        l1 = new JLabel();
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setText("Your Current Account Balance is");
        l1.setBounds(120, 280, 700, 35);
        l3.add(l1);

        JLabel l2=new JLabel();
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System", Font.BOLD, 16));
        l2.setBounds(120, 310, 700, 35);
        l3.add(l2);

        b1 = new JButton("BACK");
        b1.setBounds(170, 390, 150, 25);
        l3.add(b1);

        setLayout(null);

        int balance = 0;
        try{
            con c1 = new con();
            ResultSet rs = c1.s.executeQuery("select * from bank where (pin = '"+pin+"') and (CardNumber ='"+card+"')");
            while (rs.next())
            {
                if (rs.getString("transaction_type").equals("Deposit"))
                    balance+=Integer.parseInt(rs.getString("amount"));
                else
                    balance -= Integer.parseInt(rs.getString("amount"));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }

        l2.setText("Rs. "+balance);

        b1.addActionListener(this);

        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
        new transaction(card,pin).setVisible(true);
    }
    public static void main(String[] args)
    {
        new balanceenquiry("","").setVisible(true);
    }
}