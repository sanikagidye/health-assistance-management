package VHA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login_signup_doc extends JFrame implements ActionListener {
    JButton b1;
    JLabel l1;
    JButton back,home;

    public login_signup_doc()
    {
        setSize(330,350);
        l1=new JLabel("Doctor");
        l1.setBounds(100,50,100,50);
        l1.setFont(new Font("Times New Roman", Font.BOLD,25));
        add(l1);

        b1=new JButton("Login");
        b1.setBounds(100,150,100,70);
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
        home.setBounds(265,0,50,40);
        home.addActionListener(this);
        add(home);

        ImageIcon i7= new ImageIcon(ClassLoader.getSystemResource("images/docg1.jpg"));
        Image i8  = i7.getImage().getScaledInstance(330,350,Image.SCALE_SMOOTH);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel i0 = new JLabel(i9);
        i0.setBounds(0,0,330,350);
        add(i0);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
      if (ae.getSource()==b1)
      {
          new doc_login();
          this.setVisible(false);
      }
        else if(ae.getSource()==back)
        {
            new select();
            this.setVisible(false);
        }
        else if(ae.getSource()==home)
        {
            new Main();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new login_signup_doc();
    }
}
