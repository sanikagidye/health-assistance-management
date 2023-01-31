package VHA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import static java.lang.Integer.parseInt;

public class add_am extends JFrame implements ActionListener {
    JLabel l1,l2;
    JTextField t1;
    JButton b1;
    JButton back,home;


    public add_am()
    {
        setSize(600,400);

        l1=new JLabel("Enter Amount");
        l1.setBounds(100,130,100,70);
        add(l1);

        l2=new JLabel("Add To Wallet");
        l2.setBounds(250,30,150,70);
        l2.setFont(new Font("Times New Roman",Font.BOLD,15));
        add(l2);

        t1=new JTextField();
        t1.setBounds(250,130,100,50);
        add(t1);

        b1=new JButton("ADD");
        b1.setBounds(250,250,100,50);
        b1.addActionListener(this);
        add(b1);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/back.png"));
        Image i2= i1.getImage().getScaledInstance(50,40,Image.SCALE_SMOOTH);
        ImageIcon i3=new ImageIcon(i2);
        back=new JButton(i3);
        back.setBounds(0,0,50,40);
        back.addActionListener(this);
        add(back);

        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("images/home.png"));
        Image i5= i4.getImage().getScaledInstance(50,40,Image.SCALE_SMOOTH);
        ImageIcon i6=new ImageIcon(i5);
        home=new JButton(i6);
        home.setBounds(535,0,50,40);
        home.addActionListener(this);
        add(home);

        ImageIcon i7= new ImageIcon(ClassLoader.getSystemResource("images/patg5.jpeg"));
        Image i8  = i7.getImage().getScaledInstance(600,400,Image.SCALE_SMOOTH);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel i0 = new JLabel(i9);
        i0.setBounds(0,0,600,400);
        add(i0);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1) {
            String t1 = this.t1.getText();


            conn c=new conn();

            String str = "Update pat_info set wallet= wallet +'" +t1+ "' where pat_id='" + pat_login.pat_check + "';";
            try {
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Amount Added Successfully");
            } catch (Exception e) {
                System.out.println(e);
            }

            this.t1.setText(null);
        }
        else if(ae.getSource()==back)
        {
            new pay();
            this.setVisible(false);
        }
        else if(ae.getSource()==home)
        {
            new pat_home();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new add_am();
    }
}
