package VHA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class doc_home extends JFrame implements ActionListener {
    JLabel l1,l2,l3;
    JButton b1, b2, b3, b4, b5;
    int ty = 140;
    int tw = 150;
    int th = 70;

    doc_home() {
        setSize(1000, 500);

        conn c= new conn();
        try {
            String str1 = "Select doc_name ,doc_id from doc_info where doc_id='" + doc_login.doc_check + "'; ";
            ResultSet rs = c.s.executeQuery(str1);
            String n = null;
            String id = null;
            while (rs.next()) {
                n = rs.getString("doc_name");
                id= rs.getString("doc_id");

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

       l1 = new JLabel("Doctor");
        l1.setBounds(450, 40, 200, 50);
        l1.setFont(new Font("Times new Roman", Font.BOLD, 30));
        add(l1);

        b1 = new JButton("My Appointment");
        b1.setBounds(100, ty, tw, th);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Add Prescription");
        b2.addActionListener(this);
        b2.setBounds(300, ty, tw, th);
        add(b2);

        b3 = new JButton("Edit Details");
        b3.setBounds(700, ty, tw, th);
        b3.addActionListener(this);
        add(b3);

        b4= new JButton("View Prescription");
        b4.setBounds(500,ty,tw,th);
        b4.addActionListener(this);
        add(b4);

        b5 = new JButton("Logout");
        b5.setBounds(400, 340, 200, 70);
        b5.addActionListener(this);
        add(b5);

        ImageIcon i7= new ImageIcon(ClassLoader.getSystemResource("images/doci4.jpg"));
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
        if(ae.getSource()==b5)
        {
            doc_login.doc_check=null;
            JOptionPane.showMessageDialog(null,"Logged Out Successfully");
            new Main();
            this.setVisible(false);
        }
        else if(ae.getSource()==b3)
        {
            new doc_edit();
            this.setVisible(false);
        }
    else if(ae.getSource()==b1)
        {
            new doc_appointment();
            this.setVisible(false);
        }
    else if(ae.getSource()==b4)
        {
            new show_pres_d();
            this.setVisible(false);
        }
     else if(ae.getSource()==b2)
        {
            new add_pres();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new doc_home();
    }
}
