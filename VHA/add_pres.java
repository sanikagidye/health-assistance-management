package VHA;

import com.toedter.calendar.JDateChooser;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Random;

public class add_pres extends JFrame implements ActionListener {
    JLabel l1,l5,l6,l7,l8,l9;
    JTextField med1,d1,f1,t1;
    JButton b1,display;
    JComboBox c1,c2;
    JButton home;

    JDateChooser dop;
    public add_pres()
    {
        setSize(800,600);


        l9=new JLabel("Prescription");
        l9.setBounds(320,40,180,50);
        l9.setFont(new Font("Times New Roman",Font.BOLD,25));
        add(l9);


        l1=new JLabel("Medicine1");
        l1.setBounds(50,300,80,50);
        add(l1);

         l5=new JLabel("No of Days");
        l5.setBounds(310,240,80,50);
        add(l5);

        l6=new JLabel("Frequency");
        l6.setBounds(460,240,80,50);
        add(l6);

        l7=new JLabel("Patient ID");
        l7.setBounds(40,150,80,50);
        add(l7);

        l8=new JLabel("Date");
        l8.setBounds(400,150,80,50);
        add(l8);
//        comboBox

        conn c=new conn();
         c1=new JComboBox();
        try
        {
            String str2= "select pat_id from pat_info;";
            ResultSet rs= c.s.executeQuery(str2);

            while(rs.next())
            {
                String pi=rs.getString("pat_id");
                c1.addItem(pi);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        c1.setBounds(100,150,80,40);
        add(c1);

//        date
        dop=new JDateChooser();
        dop.setBounds(480,150,150,50);
        add(dop);

//medn
//        med1=new JTextField();
//        med1.setBounds(160,300,100,50);
//        add(med1);

        c2= new JComboBox();

        try
        {
            String str6= "select Distinct med_name from medicine order by med_name;";
            ResultSet rs= c.s.executeQuery(str6);

            while(rs.next())
            {
                String hos=rs.getString("med_name");
                c2.addItem(hos);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        c2.setBounds(160,300,100,50);
        add(c2);


//        Daystxt

        d1=new JTextField();
        d1.setBounds(310,300,80,50);
        add(d1);


        //        freq
         f1=new JTextField();
        f1.setBounds(460,300,70,50);
        add(f1);


        t1=new JTextField();
        t1.setBounds(160,80,150,50);
        add(t1);

//        button

        b1=new JButton("ADD");
        b1.setBounds(360,450,80,50);
        b1.addActionListener(this);
        add(b1);

        display=new JButton("Display");
        display.setBounds(200,150,90,40);
        display.addActionListener(this);
        add(display);

        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("images/home.png"));
        Image i5= i4.getImage().getScaledInstance(50,40,Image.SCALE_SMOOTH);
        ImageIcon i6=new ImageIcon(i5);
        home=new JButton(i6);
        home.setBounds(735,0,50,40);
        home.addActionListener(this);
        add(home);

        ImageIcon i7= new ImageIcon(ClassLoader.getSystemResource("images/med1.jpg"));
        Image i8  = i7.getImage().getScaledInstance(800,600,Image.SCALE_SMOOTH);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel i0 = new JLabel(i9);
        i0.setBounds(0,0,800,600);
        add(i0);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            String pid = null;
            pid = (String) c1.getSelectedItem();

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
            String d = dateFormat.format(this.dop.getDate());

            String pres_id;
            Random r = new Random();
            pres_id = String.valueOf(r.nextInt(1000, 10000));

            //   String med1,med2,med3,med4;
            String medi1 = c2.getSelectedItem().toString();
            String d1 = this.d1.getText();
            String f1 = this.f1.getText();

            conn c = new conn();

            String n = null;
            try {
                String str1 = "Select doc_name ,doc_id from doc_info where doc_id='" + doc_login.doc_check + "'; ";
                ResultSet rs = c.s.executeQuery(str1);
                n = null;
                while (rs.next()) {
                    n = rs.getString("doc_name");
                }
            } catch (Exception ea) {
                System.out.println(ea);
            }
            String str1 = "insert into prescription (Medicine, No_of_Days, Frequency, Date, doc_n, pat_id, doc_id, pres_id) values('" + medi1 + "','" + d1 + "','" + f1 + "','" + d + "','" + n + "','" + pid + "','" + doc_login.doc_check + "','" + pres_id + "'); ";

            try {
                c.s.executeUpdate(str1);
                this.d1.setText(null);
                this.f1.setText(null);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else if (ae.getSource() == display) {
            String id=null;
            id= (String) c1.getSelectedItem();
            conn c = new conn();
            try {
                String str = "select pat_name from pat_info where pat_id='" + id + "';";
                ResultSet rs = c.s.executeQuery(str);
                String name = null;
                while (rs.next()) {
                    name = rs.getString("pat_name");
                    t1.setText(name);
                }
                } catch (Exception e) {
                System.out.println(e);
            }
        }
        else if (ae.getSource() == home) {
                new doc_home();
                this.setVisible(false);
            }
        }

    public static void main(String[] args) {
        new add_pres();
    }

}
