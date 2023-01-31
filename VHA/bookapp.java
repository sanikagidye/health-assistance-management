package VHA;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Random;

public class bookapp extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6;
    JDateChooser appd;
    JTextField time;
    JButton b1,b2;
    JComboBox c1,c2,c3;
    public static String h,spec,app_id,na,ti,app_d,d_id,n,idpay;
    JButton back,home;
    conn c = new conn();
    public bookapp() {
        setSize( 800,800);

        l1 = new JLabel("Appoinment");
        l1.setBounds(230, 50, 300, 90);
        l1.setFont(new Font("Times New Roman", Font.BOLD, 25));
        add(l1);

        l2 = new JLabel("Select Date");
        l2.setBounds(80, 140, 300, 50);
        l2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        add(l2);

        l3 = new JLabel("Select Time");
        l3.setBounds(80, 240, 300, 50);
        l3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        add(l3);

        l4 = new JLabel("Select Hospital Name");
        l4.setBounds(80, 340, 300, 50);
        l4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        add(l4);

        l5 = new JLabel("Select Specialization");
        l5.setBounds(80, 440, 300, 50);
        l5.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        add(l5);

        l6 = new JLabel("Select Doctor Name");
        l6.setBounds(80, 540, 300, 50);
        l6.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        add(l6);

        appd = new JDateChooser();
        appd.setBounds(240, 140, 250, 50);
        add(appd);

        time = new JTextField();
        time.setBounds(240, 240, 250, 50);
        add(time);

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
        home.setBounds(735,0,50,40);
        home.addActionListener(this);
        add(home);


//        combo2
        c2= new JComboBox();

        try
        {
            String str= "select Distinct hospital from doc_info;";
            ResultSet rs= c.s.executeQuery(str);

            while(rs.next())
            {
                String hos=rs.getString("hospital");
                c2.addItem(hos);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        c2.setBounds(240,340,250,50);
        add(c2);


//        combo3
        c3= new JComboBox();

        try
        {
            String str= "select Distinct specialization from doc_info;";
            ResultSet rs= c.s.executeQuery(str);

            while(rs.next())
            {
                String spe=rs.getString("specialization");
                c3.addItem(spe);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        c3.setBounds(240,440,250,50);
        add(c3);


        b1 = new JButton("Book Appoinment");
        b1.setBounds(230, 640, 150, 70);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Show");
        b2.setBounds(520, 540, 110, 50);
        b2.addActionListener(this);
        add(b2);

        c1= new JComboBox();
        add(c1);

        ImageIcon i7= new ImageIcon(ClassLoader.getSystemResource("images/dpcapp2.jpg"));
        Image i8  = i7.getImage().getScaledInstance(800,800,Image.SCALE_SMOOTH);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel i0 = new JLabel(i9);
        i0.setBounds(0,0,800,800);
        add(i0);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == b2)
        {
            h=null;
            h =c2.getSelectedItem().toString();
            spec=null;
            spec =c3.getSelectedItem().toString();

            try
            {
                String str= "select doc_name from doc_info where hospital='"+h+"' AND specialization='"+spec+"';";
                ResultSet rs= c.s.executeQuery(str);


                while(rs.next())
                {
                    String name=rs.getString("doc_name");
                    c1.addItem(name);
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }

            c1.setBounds(240,540,250,50);
            c1.setVisible(true);
        }
        else if(ae.getSource()==b1) {
             n = null;
            n = (String) c1.getSelectedItem();

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
           app_d= dateFormat.format(this.appd.getDate());

             ti = this.time.getText();


            Random r = new Random();
            app_id = String.valueOf(r.nextInt(1000, 10000));

           Random r1 = new Random();
            idpay = String.valueOf(r1.nextInt(10000, 100000));

            conn c = new conn();

            d_id = null;
            try {
                String str = "select doc_id from doc_info where hospital='" + h + "' AND specialization='" + spec + "' AND doc_name='" + n + "';";
                ResultSet rs = c.s.executeQuery(str);
                while (rs.next()) {
                    d_id = rs.getString("doc_id");
                }
            } catch (Exception e) {
                System.out.println(e);
            }

            na = null;
            try {
                String str1 = "Select pat_name from pat_info where pat_id='" + pat_login.pat_check + "'; ";
                ResultSet rs = c.s.executeQuery(str1);
                na = null;
                while (rs.next()) {
                    na = rs.getString("pat_name");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            JOptionPane.showMessageDialog(null,"Pay RS 400 To Book Appointment");



            new pay_am();
            this.time.setText(null);
            this.setVisible(false);

        }
           else if(ae.getSource()==back)
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
        new bookapp();
    }
}
