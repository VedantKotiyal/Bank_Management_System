import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Pin extends JFrame implements ActionListener
{
    JPasswordField t1,t2;
    JButton b1,b2;
    JLabel l1,l2,l3;
    String pin,card;
    Pin(String card,String pin)
    {
        this.card=card;
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(770,870, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l4 = new JLabel(i3);
        l4.setBounds(0, 0, 700, 750);
        add(l4);

        setLayout(null);
        setSize(700, 750);
        setResizable(false);
        setLocation(425, 40);

        l1 = new JLabel("CHANGE YOUR PIN");
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setForeground(Color.WHITE);
        l1.setBounds(190,220,800,35);
        l4.add(l1);

        l2 = new JLabel("New PIN:");
        l2.setFont(new Font("System", Font.PLAIN, 16));
        l2.setForeground(Color.WHITE);
        l2.setBounds(110,290,150,25);
        l4.add(l2);

        l3 = new JLabel("Re-Enter New PIN:");
        l3.setFont(new Font("System", Font.PLAIN, 16));
        l3.setForeground(Color.WHITE);
        l3.setBounds(110,320,200,25);
        l4.add(l3);

        t1=new JPasswordField();
        t1.setFont(new Font("Raleway", Font.PLAIN, 16));
        t1.setBounds(260,290,130,20);
        l4.add(t1);

        t2 = new JPasswordField();
        t2.setFont(new Font("Raleway", Font.PLAIN, 16));
        t2.setBounds(260,320,130,20);
        l4.add(t2);

        b1 = new JButton("CHANGE");
        b1.setBounds(155,380,200,25);
        l4.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(155,415,200,25);
        l4.add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        try{
            String npin=t1.getText();
            String rpin=t2.getText();

            if(!npin.equals(rpin))
            {
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }
            if(ae.getSource()==b1)
            {
                if (t1.getText().isEmpty())
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                if (t2.getText().isEmpty())
                    JOptionPane.showMessageDialog(null, "Re-Enter new PIN");

                con c1 = new con();

                c1.s.executeUpdate("update bank set pin = '"+rpin+"' where (pin = '"+pin+"') and (CardNumber ='"+card+"')");
                c1.s.executeUpdate("update login set pin = '"+rpin+"' where (pin = '"+pin+"') and (CardNumber ='"+card+"')");
                c1.s.executeUpdate("update signup3 set pin = '"+rpin+"' where (pin = '"+pin+"') and (CardNumber ='"+card+"')");

                JOptionPane.showMessageDialog(null,"PIN changed successfully");
                setVisible(false);
                new transaction(card,rpin).setVisible(true);
            }
            else if(ae.getSource()==b2)
            {
                new transaction(card,pin).setVisible(true);
                setVisible(false);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    public static void main(String[] args){
        new Pin("","").setVisible(true);
    }
}