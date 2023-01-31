package VHA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import static VHA.pat_login.pat_check;

public class pat_home extends JFrame implements ActionListener
{
    JLabel l1,l2,l3;
    JButton b1,b2,b3,b4,b5,b6,b7,b8;
    int ty=140;
    int tw=150;
    int th=70;
    public pat_home()
    {
        setSize(1000,500);

        conn c= new conn();
        try {
            String str1 = "Select pat_name ,pat_id from pat_info where pat_id='" + pat_check + "'; ";
            ResultSet rs = c.s.executeQuery(str1);
            String n = null;
            String id = null;
            while (rs.next()) {
                n = rs.getString("pat_name");
                id= rs.getString("pat_id");

            }
            l2 = new JLabel("Name : " + n);
            l2.setBounds(750, 20, 300, 70);
            l2.setFont(new Font("Times new Roman", Font.BOLD, 15));
            l2.setForeground(Color.white);
            add(l2);

            l3 = new JLabel("ID : " + id);
            l3.setBounds(750, 40, 300, 70);
            l3.setFont(new Font("Times new Roman", Font.BOLD, 15));
            l3.setForeground(Color.white);
            add(l3);


        }
        catch (Exception e)
        {
            System.out.println(e);
        }


        l1=new JLabel("Patient");
        l1.setBounds(450,40,200,50);
        l1.setFont(new Font("Times new Roman",Font.BOLD,30));
        add(l1);

        b1= new JButton("Appoinment");
        b1.setBounds(50,ty,110,th);
        b1.addActionListener(this);
        add(b1);

        b2= new JButton("Payment");
        b2.setBounds(200,ty,110,th);
        b2.addActionListener(this);
        add(b2);

        b3= new JButton("Edit Details");
        b3.setBounds(350,ty,110,th);
        b3.addActionListener(this);
        add(b3);

        b4= new JButton("Prescription");
        b4.setBounds(500,ty,110,th);
        b4.addActionListener(this);
        add(b4);

        b5= new JButton("Logout");
        b5.setBounds(200,340,200,70);
        b5.addActionListener(this);
        add(b5);

        b6= new JButton("Delete Account");
        b6.setBounds(600,340,200,70);
        b6.addActionListener(this);
        add(b6);

        b7= new JButton("Medicine");
        b7.setBounds(650,ty,110,70);
        b7.addActionListener(this);
        add(b7);

        b8= new JButton("Show order");
        b8.setBounds(800,ty,110,70);
        b8.addActionListener(this);
        add(b8);


        ImageIcon i7= new ImageIcon(ClassLoader.getSystemResource("images/patg7.jpg"));
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
        if(ae.getSource()==b1)
        {
            new pat_appSelect();
            this.setVisible(false);
        }
        else if(ae.getSource()==b5)
        {
            JOptionPane.showMessageDialog(null,"Logged out Successfully ");
            new Main();
            this.setVisible(false);
            pat_login.pat_check=null;
        }
    else if(ae.getSource()==b3)
        {
            new Edit_pat();
            this.setVisible(false);
        }
    else if(ae.getSource()==b4)
        {
            new show_pres();
            this.setVisible(false);
        }
     else if(ae.getSource()==b2)
        {
            new pay();
            this.setVisible(false);
        }
     else if(ae.getSource()==b6)
        {
            new delete_pat();
            this.setVisible(false);
        }
    else if(ae.getSource()==b7)
        {
            new pharmacy();
            this.setVisible(false);
        }
    else if(ae.getSource()==b8)
        {
            new view_order();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new pat_home();
    }
}
