package VHA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pat_appSelect extends JFrame implements ActionListener
{
    JButton b1,b2,b3;
    JButton back,home;

    public pat_appSelect()
    {
        setSize(600,400);

        b1=new JButton("Book Appoinment");
        b1.setBounds(80,90,150,70);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Cancel Appoinment");
        b2.setBounds(350,90,150,70);
        b2.addActionListener(this);
        add(b2);

         b3=new JButton("Show Appoinment");
        b3.setBounds(215,240,150,70);
        b3.addActionListener(this);
        add(b3);

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
        if(ae.getSource()==b1)
        {
            new bookapp();
            this.setVisible(false);
        }
        else if(ae.getSource()==b3)
        {
            new show_app_pat();
            this.setVisible(false);
        }
     else if(ae.getSource()==b2)
        {
            new cancel_app_pat();
            this.setVisible(false);
        }
        else if(ae.getSource()==back)
        {
            new pat_home();
            this.setVisible(false);
        }
        else if(ae.getSource()==home)
        {
            new pat_home();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new pat_appSelect();
    }
}
