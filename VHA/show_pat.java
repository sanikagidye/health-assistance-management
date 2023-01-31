package VHA;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class show_pat extends JFrame implements ActionListener {
    JTable t1;
    JScrollPane sp1;
    JTabbedPane tabs;
    JButton home;

    show_pat (){
        setSize(900,600);
        sp1=new JScrollPane();
        sp1.setBounds(50,100,700,60);
        add(sp1);

        t1=new JTable();
        sp1.setViewportView(t1);
        tabs=new JTabbedPane();
        tabs.setBounds(100,80,620,350);

        tabs.add("Patients",sp1);
        add(tabs);
        conn c=new conn();
        try{
            String str1 ="select pat_name, age, gender, dob, blood_group, email, contact, address, pat_id from pat_info";
            ResultSet rs= c.s.executeQuery(str1);
            t1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            System.out.println(e);
        }


        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("images/home.png"));
        Image i5= i4.getImage().getScaledInstance(50,40,Image.SCALE_SMOOTH);
        ImageIcon i6=new ImageIcon(i5);
        home=new JButton(i6);
        home.setBounds(835,0,50,40);
        home.addActionListener(this);
        add(home);

        ImageIcon i7= new ImageIcon(ClassLoader.getSystemResource("images/adm1.jpg"));
        Image i8  = i7.getImage().getScaledInstance(900,600,Image.SCALE_SMOOTH);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel i0 = new JLabel(i9);
        i0.setBounds(0,0,900,600);
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
        new show_pat();
    }
}
