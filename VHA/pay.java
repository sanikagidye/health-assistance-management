package VHA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pay extends JFrame implements ActionListener {
    JLabel l1;

    JRadioButton pay,add;
    ButtonGroup b1;
    JButton back,home;

    public pay()
    {
        setSize(600,300);

        b1=new ButtonGroup();


        pay=new JRadioButton("View Wallet");
        pay.setBounds(100,110,220,50);
        pay.setFont(new Font("Times New Roman",Font.PLAIN,20));
        b1.add(pay);
        pay.addActionListener(this);
        add(pay);

        add=new JRadioButton("Add to wallet");
        add.setBounds(360,110,200,50);
        add.setFont(new Font("Times New Roman",Font.PLAIN,20));
        b1.add(add);
        add.addActionListener(this);
        add(add);

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
        Image i8  = i7.getImage().getScaledInstance(600,300,Image.SCALE_SMOOTH);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel i0 = new JLabel(i9);
        i0.setBounds(0,0,600,300);
        add(i0);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==pay)
        {
            new pay_view();
            this.setVisible(false);
        }

        if(ae.getSource()==add)
        {
            new add_am();
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
        new pay();
    }
}
