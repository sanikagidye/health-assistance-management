package VHA;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class pay_view extends JFrame implements ActionListener {
    JScrollPane sp1;
    JTable t1;
    JButton back,home;

    public pay_view()
    {
        setSize(300,300);

        sp1=new JScrollPane();
        sp1.setBounds(10,80,250,130);
        add(sp1);

        t1=new JTable();
        sp1.setViewportView(t1);

        conn c = new conn();


        try{
            String str = "select wallet from pat_info where pat_id='"+pat_login.pat_check+"';";
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
        home.setBounds(235,0,50,40);
        home.addActionListener(this);
        add(home);

        ImageIcon i7= new ImageIcon(ClassLoader.getSystemResource("images/patg5.jpeg"));
        Image i8  = i7.getImage().getScaledInstance(300,300,Image.SCALE_SMOOTH);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel i0 = new JLabel(i9);
        i0.setBounds(0,0,300,300);
        add(i0);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==back)
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
        new pay_view();
    }
}
