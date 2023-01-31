package VHA;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class show_app_pat extends JFrame implements ActionListener {
    JScrollPane sp1;
    JTable t1;
    JButton back,home;
    JTabbedPane tabs;

    public show_app_pat()
    {
        setSize(1000,500);

        sp1=new JScrollPane();
        add(sp1);
        t1=new JTable();
        sp1.setViewportView(t1);
        tabs = new JTabbedPane();
        tabs.setBounds(100,60,800,200);

        //adding tabs
        tabs.add("Your Appointments", sp1);
        add(tabs);

        conn c = new conn();
        try{
            String str = "select app_id,Time, hospital,date, spec,doc_n from accept_acc where pat_aid = '"+pat_login.pat_check+"';";
            ResultSet rs = c.s.executeQuery(str);
            t1.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception e){
            System.out.println(e);
        }

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
        home.setBounds(935,0,50,40);
        home.addActionListener(this);
        add(home);

        ImageIcon i7= new ImageIcon(ClassLoader.getSystemResource("images/dpcapp2.jpg"));
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
        if(ae.getSource()==back)
        {
            new pat_appSelect();
            this.setVisible(false);
        }
        else if(ae.getSource()==home)
        {
            new pat_home();
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new show_app_pat();
    }
}
