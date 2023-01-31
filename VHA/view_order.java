package VHA;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class view_order extends JFrame implements ActionListener {
    JScrollPane sp1;
    JTable t1;
    JButton home;
    JTabbedPane tabs;

    public view_order()
    {
        setSize(800,500);

        sp1=new JScrollPane();
        add(sp1);

        t1=new JTable();
        sp1.setViewportView(t1);
        tabs = new JTabbedPane();
        tabs.setBounds(40,50,700,350);

        //adding tabs
        tabs.add("Your Orders", sp1);
        add(tabs);
        conn c = new conn();


        try{
            String str = "select O_id, med_name, med_type, cost, quantity from o_det where pat_id='"+pat_login.pat_check+"';";
            ResultSet rs = c.s.executeQuery(str);
            t1.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            System.out.println(e);
        }

        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("images/home.png"));
        Image i5= i4.getImage().getScaledInstance(50,40,Image.SCALE_SMOOTH);
        ImageIcon i6=new ImageIcon(i5);
        home=new JButton(i6);
        home.setBounds(735,0,50,40);
        home.addActionListener(this);
        add(home);

        ImageIcon i7= new ImageIcon(ClassLoader.getSystemResource("images/med2.jpg"));
        Image i8  = i7.getImage().getScaledInstance(800,500,Image.SCALE_SMOOTH);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel i0 = new JLabel(i9);
        i0.setBounds(0,0,800,500);
        add(i0);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==home)
        {
            new pat_home();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new view_order();
    }

}
