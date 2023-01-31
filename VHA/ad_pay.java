package VHA;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ad_pay extends JFrame implements ActionListener {
    JScrollPane sp1;
    JTabbedPane tabs;
    JTable payment;
    JButton home;

    ad_pay(){
        setSize(1000,500);

        sp1=new JScrollPane();

        payment= new JTable();
        sp1.setViewportView(payment);
        tabs=new JTabbedPane();
        tabs.setBounds(100,80,620,350);

        tabs.add("PAYMENTS",sp1);
        add(tabs);

        conn c=new conn();
        try{
            String str1 ="select pat_n,paid_to,amount from payment ;";
            ResultSet rs= c.s.executeQuery(str1);
            payment.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            System.out.println(e);
        }

        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("images/home.png"));
        Image i5= i4.getImage().getScaledInstance(50,40,Image.SCALE_SMOOTH);
        ImageIcon i6=new ImageIcon(i5);
        home=new JButton(i6);
        home.setBounds(935,0,50,40);
        home.addActionListener(this);
        add(home);

        ImageIcon i7= new ImageIcon(ClassLoader.getSystemResource("images/adm1.jpg"));
        Image i8  = i7.getImage().getScaledInstance(1000,500,Image.SCALE_SMOOTH);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel i0 = new JLabel(i9);
        i0.setBounds(0,0,1000,500);
        add(i0);



        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==home)
        {
            new admin_home();
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new ad_pay();
    }
}