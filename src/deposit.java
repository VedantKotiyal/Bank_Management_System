import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class deposit extends JFrame implements ActionListener
{
    JTextField t1;
    JButton b1,b2;
    JLabel l1;
    String pin,card;
    deposit(String card,String pin)
    {
        this.card=card;
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(770,870, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 700,750);
        add(l3);

        setLayout(null);
        setSize(700, 750);
        setLocation(425, 40);
        setUndecorated(true);

        l1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 14));
        l1.setBounds(105, 240, 700, 35);
        l3.add(l1);

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.PLAIN, 15));
        t1.setBounds(120,310,250,25);
        l3.add(t1);

        b1 = new JButton("DEPOSIT");
        b1.setBounds(170,380,150,25);
        l3.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(170,420,150,25);
        l3.add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        try{
            String amount = t1.getText();
            Date date = new Date();

            if(ae.getSource()==b1)
            {
                if(t1.getText().isEmpty())
                    JOptionPane.showMessageDialog(null,"Please enter the Amount to you want to Deposit");
                else
                {
                    con c1 = new con();
                    c1.s.executeUpdate("insert into bank values('"+Long.parseLong(card)+"','"+Integer.valueOf(pin)+"', '"+date+"', 'Deposit', '"+Integer.parseInt(amount)+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Deposited Successfully");
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
        new deposit("","").setVisible(true);
    }
}