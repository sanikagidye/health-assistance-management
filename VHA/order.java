package VHA;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class order extends JFrame implements ActionListener {
    JScrollPane sp1;
    JTable t1;
    JButton b1;
    JTabbedPane tabs;
    conn c = new conn();
    public order()
    {
        setSize(800,600);

        sp1=new JScrollPane();
        add(sp1);

      b1=new JButton("Order");
      b1.setBounds(350,400,100,50);
      b1.addActionListener(this);
      add(b1);

        t1=new JTable();
        sp1.setViewportView(t1);
        tabs = new JTabbedPane();
        tabs.setBounds(40,50,700,250);

        //adding tabs
        tabs.add("Your Cart", sp1);
        add(tabs);




        try{
            String str = "select med_name, med_type, SUM(cost), sum(quantity) from book_med where pat_id='"+pat_login.pat_check+"' Group by med_name;";
            ResultSet rs = c.s.executeQuery(str);
            t1.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception e){
            System.out.println(e);
        }

        ImageIcon i7= new ImageIcon(ClassLoader.getSystemResource("images/med2.jpg"));
        Image i8  = i7.getImage().getScaledInstance(800,600,Image.SCALE_SMOOTH);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel i0 = new JLabel(i9);
        i0.setBounds(0,0,800,600);
        add(i0);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {

       try{
                String str = "select  SUM(cost) from book_med where pat_id='"+pat_login.pat_check+"';";
                ResultSet rs = c.s.executeQuery(str);
                String co=null;
                while(rs.next())
                {
                    co= rs.getString("sum(cost)");
                    JOptionPane.showMessageDialog(null,"Total cost = "+co);

                }

            }catch (Exception e){
                System.out.println(e);
            }
       new pay_am();
       this.setVisible(false);

        }
    }

    public static void main(String[] args) {
        new order();
    }
}
