package VHA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main extends JFrame implements ActionListener
{
    JLabel l1;
    JButton b1 ;
    Main()
    {
        setSize(600,400);

        ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("images/main.jpg"));
        JLabel i8= new JLabel(i7);
        i8.setBounds(0,0,600,400);
        add(i8);

        b1=new JButton("Health Assistant");
        b1.setBounds(150,100,300,70);
        b1.setFont(new Font("Times New Roman",Font.BOLD,25));

        b1.addActionListener(this);
        add(b1);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource()==b1) {
            new select();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
