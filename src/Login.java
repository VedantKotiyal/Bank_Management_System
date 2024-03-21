import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener
{
    JButton clear,submit,sin;
    JTextField tf1;
    JPasswordField tf2;
    Login()
    {
        setVisible(true);
        JFrame f=new JFrame();
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setTitle("Bank Management System");

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(80,20,95,70);
        add(label);

        JLabel wel=new JLabel("Welcome To Bank");
        wel.setFont(new Font("Osward",Font.BOLD,38));
        wel.setBounds(200,20,600,70);
        add(wel);

        JLabel card=new JLabel("Card No:");
        card.setFont(new Font("Raleway",Font.PLAIN,17));
        card.setBounds(140,115,600,70);
        add(card);

        tf1=new JTextField();
        tf1.setFont(new Font("Aerial",Font.PLAIN,12));
        tf1.setBounds(270, 140,200,20);
        add(tf1);

        JLabel pin=new JLabel("Pin:");
        pin.setFont(new Font("Raleway",Font.PLAIN,17));
        pin.setBounds(140,170,600,70);
        add(pin);

        tf2=new JPasswordField();
        tf2.setFont(new Font("Aerial",Font.PLAIN,12));
        tf2.setBounds(270, 195,200,20);
        add(tf2);

        sin=new JButton("CREATE NEW");
        sin.setBounds(270,260,113,25);
        sin.setBackground(Color.BLACK);
        sin.setForeground(Color.white);
        sin.addActionListener(this);
        add(sin);

        clear=new JButton("CLEAR");
        clear.setBounds(393,260,80,25);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        submit=new JButton("SUBMIT");
        submit.setBounds(270,295,203,25);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);

        setSize(650,450);
        setResizable(false);
        setLocation(475,150);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==sin)
        {
            setVisible(false);
            new signup();
        }
        else if(e.getSource()==clear)
        {
            tf1.setText("");
            tf2.setText("");
        }
        else if(e.getSource()==submit)
        {
            try {
                if (tf1.getText().isEmpty() || String.valueOf(tf2.getPassword()).isEmpty())
                    JOptionPane.showMessageDialog(null, "Fill all details");
                else if(!check(tf1.getText(), String.valueOf(tf2.getPassword())))
                    JOptionPane.showMessageDialog(null,"Account not available, please check details");
                else
                {
                    new transaction(tf1.getText(),String.valueOf(tf2.getPassword()));
                    setVisible(false);
                }
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
    boolean check(String s1,String s2)
    {
        try {
            con c = new con();
            ResultSet r=c.s.executeQuery("select * from login where pin = '"+Integer.parseInt(s2)+"' and CardNumber ='"+Long.parseLong(s1)+"'");
            if(r.next())
                return true;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return false;
    }
    public static void main(String []args)
    {
        new Login();
    }
}