import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class signup2 extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
    JButton b;
    JRadioButton r1,r2,r3,r4;
    JTextField t1,t2;
    JComboBox c1,c2,c3,c4,c5;
    String formno;
    signup2(String formno)
    {
        this.formno=formno;
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(500,600);
        setResizable(false);
        setLocation(475,150);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(100,15,95,70);
        add(label);

        JLabel sign=new JLabel("Sign Up Page");
        sign.setBounds(180,30,300,40);
        sign.setFont(new Font("Osward",Font.PLAIN,28));
        add(sign);

        l1 = new JLabel("Page 2: Additional Details");
        l1.setFont(new Font("Raleway", Font.PLAIN, 22));
        l1.setBounds(105,70,300,40);
        add(l1);

        l2 = new JLabel("Religion:");
        l2.setFont(new Font("Raleway", Font.PLAIN, 13));
        l2.setBounds(90,120,100,30);
        add(l2);

        String religion[] = {"Other","Hindu","Muslim","Sikh","Christian"};
        c1 = new JComboBox(religion);
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.PLAIN, 14));
        c1.setBounds(230,125,180,20);
        add(c1);

        l3 = new JLabel("Category:");
        l3.setFont(new Font("Raleway", Font.PLAIN, 13));
        l3.setBounds(90,150,100,30);
        add(l3);

        String category[] = {"Other","General","OBC","SC/ST"};
        c2 = new JComboBox(category);
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.PLAIN, 14));
        c2.setBounds(230,155,180,20);
        add(c2);

        l5 = new JLabel("Educational");
        l5.setFont(new Font("Raleway", Font.PLAIN, 13));
        l5.setBounds(90,180,150,30);
        add(l5);
        String []education = {"Others","Non-Graduate","Graduate","Post-Graduate","Doctrate"};
        c3=new JComboBox(education);
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.PLAIN, 14));
        c3.setBounds(230,185,180,20);
        add(c3);

        l5 = new JLabel("Occupation:");
        l5.setFont(new Font("Raleway", Font.PLAIN, 13));
        l5.setBounds(90,210,100,30);
        add(l5);

        String occupation[] = {"Others","Salaried","Self-Employmed","Business","Student","Retired"};
        c4=new JComboBox(occupation);
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.PLAIN, 14));
        c4.setBounds(230,215,180,20);
        add(c4);

        l6 = new JLabel("Income:");
        l6.setFont(new Font("Raleway", Font.PLAIN, 13));
        l6.setBounds(90,240,150,30);
        add(l6);
        String []income = {"Null","< Rs.1,50,000","< Rs.2,50,000","< Rs.5,00,000","Upto Rs.10,00,000","Above Rs.10,00,000"};
        c5 = new JComboBox(income);
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.PLAIN, 14));
        c5.setBounds(230,245,180,20);
        add(c5);

        l7=new JLabel("PAN Number:");
        l7.setFont(new Font("Raleway", Font.PLAIN, 13));
        l7.setBounds(90,270,150,30);
        add(l7);

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.PLAIN, 14));
        t1.setBounds(230,275,180,20);
        add(t1);

        l8 = new JLabel("Aadhar Number:");
        l8.setFont(new Font("Raleway", Font.PLAIN, 13));
        l8.setBounds(90,300,180,30);
        add(l8);

        t2 = new JTextField();
        t2.setFont(new Font("Raleway", Font.PLAIN, 14));
        t2.setBounds(230,305,180,20);
        add(t2);

        l9 = new JLabel("Senior Citizen:");
        l9.setFont(new Font("Raleway", Font.PLAIN, 13));
        l9.setBounds(90,330,150,30);
        add(l9);

        r1 = new JRadioButton("Yes");
        r1.setFont(new Font("Raleway", Font.PLAIN, 14));
        r1.setBackground(Color.WHITE);
        r1.setBounds(230,335,100,20);
        add(r1);

        r2 = new JRadioButton("No");
        r2.setFont(new Font("Raleway", Font.PLAIN, 14));
        r2.setBackground(Color.WHITE);
        r2.setBounds(330,335,100,20);
        add(r2);

        ButtonGroup r=new ButtonGroup();
        r.add(r1);
        r.add(r2);

        l10 = new JLabel("Existing Account:");
        l10.setFont(new Font("Raleway", Font.PLAIN, 13));
        l10.setBounds(90,360,180,30);
        add(l10);

        r3 = new JRadioButton("Yes");
        r3.setFont(new Font("Raleway", Font.PLAIN, 14));
        r3.setBackground(Color.WHITE);
        r3.setBounds(230,365,100,20);
        add(r3);

        r4 = new JRadioButton("No");
        r4.setFont(new Font("Raleway", Font.PLAIN, 14));
        r4.setBackground(Color.WHITE);
        r4.setBounds(330,365,100,20);
        add(r4);

        ButtonGroup x=new ButtonGroup();
        x.add(r3);
        x.add(r4);

        l12 = new JLabel("Form No:");
        l12.setFont(new Font("Raleway", Font.PLAIN, 13));
        l12.setBounds(90,390,60,30);
        add(l12);

        l13 = new JLabel(formno);
        l13.setFont(new Font("Raleway", Font.PLAIN, 13));
        l13.setBounds(230,395,60,30);
        add(l13);

        b = new JButton("Next");
        b.setFont(new Font("Raleway", Font.PLAIN, 14));
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setBounds(140,460,200,25);
        b.addActionListener(this);
        add(b);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String religion = (String)c1.getSelectedItem();
        String category = (String)c2.getSelectedItem();
        String income = (String)c3.getSelectedItem();
        String education = (String)c4.getSelectedItem();
        String occupation = (String)c5.getSelectedItem();

        String pan = t1.getText();
        String aadhar = t2.getText();

        String scitizen = "";
        if(r1.isSelected())
            scitizen = "Yes";
        else if(r2.isSelected())
            scitizen = "No";
        String eaccount = "";
        if(r3.isSelected())
            eaccount = "Yes";
        else if(r4.isSelected())
            eaccount = "No";
        try{
            if(t2.getText().isEmpty())
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            else
            {
                con c1 = new con();
                String q1 = "insert into signup2 values('"+Integer.valueOf(formno)+"','"+religion+"','"+category+"','"+occupation+"','"+income+"','"+education+"','"+pan+"','"+aadhar+"','"+scitizen+"','"+eaccount+"')";
                c1.s.executeUpdate(q1);

                new signup3(formno).setVisible(true);
                setVisible(false);
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,ex);        }
    }
    public static void main(String[] args){
        new signup2("").setVisible(true);
    }
}