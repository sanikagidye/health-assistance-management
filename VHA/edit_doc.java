package VHA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class edit_doc extends JFrame implements ActionListener {
    JLabel l1;
    JRadioButton update,delete;
    ButtonGroup b1;
    JButton home;
    edit_doc()
    {
        setSize(600,400);

        l1=new JLabel("Select the operation");
        l1.setBounds(200,50,300,90);
        l1.setFont(new Font("Times New Roman",Font.BOLD,25));
        add(l1);

        b1=new ButtonGroup();

        update=new JRadioButton("Update");
        update.setBounds(130,150,150,70);
        update.setFont(new Font("Times New Roman",Font.PLAIN,20));
        b1.add(update);
        update.addActionListener(this);
        add(update);

        delete=new JRadioButton("Delete");
        delete.setBounds(330,150,150,70);
        delete.setFont(new Font("Times New Roman",Font.PLAIN,20));
        b1.add(delete);
        delete.addActionListener(this);
        add(delete);

        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("images/home.png"));
        Image i5= i4.getImage().getScaledInstance(50,40,Image.SCALE_SMOOTH);
        ImageIcon i6=new ImageIcon(i5);
        home=new JButton(i6);
        home.setBounds(535,0,50,40);
        home.addActionListener(this);
        add(home);

        ImageIcon i7= new ImageIcon(ClassLoader.getSystemResource("images/adm1.jpg"));
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
        if (ae.getSource() == update)
        {
            new updateprofile();
            this.setVisible(false);
        }
        if (ae.getSource() == delete)
        {
            new delete();
            this.setVisible(false);
        }
        else if(ae.getSource()==home)
        {
            new admin_home();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new edit_doc();
    }
}
