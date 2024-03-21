import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class signup extends JFrame implements ActionListener{
    JButton next;
    JTextField nf,fnf,phf,pc;
    JTextArea ad;
    JRadioButton m,f;
    JDateChooser dateChooser;
    Random ran=new Random();
    long first4=(ran.nextLong()%9000L)+1000L;
    String form=""+Math.abs(first4);
    signup()
    {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setTitle("Bank Management System");

        setSize(500,600);
        setResizable(false);
        setLocation(475,150);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(80,15,95,70);
        add(label);

        JLabel sign=new JLabel("Sign Up Page");
        sign.setBounds(170,30,300,40);
        sign.setFont(new Font("Osward",Font.BOLD,28));
        add(sign);

        JLabel app=new JLabel("Application Form No. "+form);
        app.setBounds(130,50,300,100);
        app.setFont(new Font("Osward",Font.BOLD,20));
        add(app);

        JLabel name=new JLabel("Name");
        name.setBounds(100,140,50,25);
        name.setFont(new Font("Raleway",Font.PLAIN,13));
        add(name);

        nf=new JTextField();
        nf.setBounds(230,140,180,20);
        add(nf);

        JLabel fnm=new JLabel("Father's Name");
        fnm.setBounds(100,170,100,25);
        fnm.setFont(new Font("Raleway",Font.PLAIN,13));
        add(fnm);

        fnf=new JTextField();
        fnf.setBounds(230,170,180,20);
        add(fnf);

        JLabel dob=new JLabel("Date of birth");
        dob.setBounds(100,200,100,25);
        dob.setFont(new Font("Raleway",Font.PLAIN,13));
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(230, 200, 180, 20);
        add(dateChooser);

        JLabel phn=new JLabel("Phone Number");
        phn.setBounds(100,230,100,25);
        phn.setFont(new Font("Raleway",Font.PLAIN,13));
        add(phn);

        phf=new JTextField();
        phf.setBounds(230,230,180,20);
        add(phf);

        JLabel gnr=new JLabel("Gender");
        gnr.setBounds(100,260,100,25);
        gnr.setFont(new Font("Raleway",Font.PLAIN,13));
        add(gnr);

        m=new JRadioButton("Male");
        m.setBounds(230,263,60,20);
        m.setBackground(Color.white);
        add(m);

        f=new JRadioButton("Female");
        f.setBounds(300,263,80,20);
        f.setBackground(Color.white);
        add(f);

        ButtonGroup g=new ButtonGroup();
        g.add(m);
        g.add((f));

        JLabel adr=new JLabel("Address");
        adr.setBounds(100,290,100,25);
        adr.setFont(new Font("Raleway",Font.PLAIN,13));
        add(adr);

        ad=new JTextArea();
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        ad.setBorder(border);
        ad.setLineWrap(true);
        ad.setWrapStyleWord(true);
        ad.setBounds(230,293,180,75);
        add(ad);

        JLabel pin=new JLabel("Pin Code");
        pin.setBounds(100,380,100,25);
        pin.setFont(new Font("Raleway",Font.PLAIN,13));
        add(pin);

        pc=new JTextField();
        pc.setBounds(230,383,180,20);
        add(pc);

        next=new JButton("Next");
        next.setBounds(140,450,200,25);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.addActionListener(this);
        add(next);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        String gn="";
        String nm=nf.getText();
        String fnm=fnf.getText();
        String phn=phf.getText();
        String adr=ad.getText();
        String pin=pc.getText();
        if(m.isSelected())
            gn="Male";
        else if(f.isSelected())
            gn="Female";
        String d=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        try
        {
            if(nm.isEmpty())
                JOptionPane.showMessageDialog(null,"Name not entered");
            else if(fnm.isEmpty())
                JOptionPane.showMessageDialog(null,"Father's Name not entered");
            else if(phn.isEmpty())
                JOptionPane.showMessageDialog(null,"Phone Number not entered");
            else if(d.isEmpty())
                JOptionPane.showMessageDialog(null,"Enter Date of Birth");
            else if(gn.isEmpty())
                JOptionPane.showMessageDialog(null,"Select Gender");
            else if(adr.isEmpty())
                JOptionPane.showMessageDialog(null,"Address not entered");
            else if(pin.isEmpty())
                JOptionPane.showMessageDialog(null,"Pin Code not entered");
            else
            {
                con c=new con();
                c.s.executeUpdate("insert into signup1 values('"+Integer.parseInt(form)+"','"+nm+"','"+fnm+"','"+d+"','"+phn+"','"+gn+"','"+adr+"','"+pin+"')");
                new signup2(form).setVisible(true);
                setVisible(false);
            }
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null,ex);
        }
    }
    public static void main(String []args)
    {
        new signup();
    }
}