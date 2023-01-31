package VHA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;

import static VHA.bookapp.*;
import static java.lang.Integer.parseInt;

public class pay_am extends JFrame implements ActionListener {
    JLabel l1,l2;
    JTextField t1;
    JButton b1,b2;
    JButton home;

    public pay_am()
    {
        setSize(600,400);

        l1=new JLabel("Enter Amount");
        l1.setBounds(100,130,100,70);
        add(l1);

        l2=new JLabel("Pay");
        l2.setBounds(250,30,70,70);
        l2.setFont(new Font("Times New Roman",Font.BOLD,25));
        add(l2);

        t1=new JTextField();
        t1.setBounds(250,130,100,50);
        add(t1);

        b1=new JButton("Pay to book appointment");
        b1.setBounds(50,250,200,50);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Pay to order medicine");
        b2.setBounds(300,250,200,50);
        b2.addActionListener(this);
        add(b2);

        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("images/home.png"));
        Image i5= i4.getImage().getScaledInstance(50,40,Image.SCALE_SMOOTH);
        ImageIcon i6=new ImageIcon(i5);
        home=new JButton(i6);
        home.setBounds(535,0,50,40);
        home.addActionListener(this);
        add(home);

        ImageIcon i7= new ImageIcon(ClassLoader.getSystemResource("images/patg5.jpeg"));
        Image i8  = i7.getImage().getScaledInstance(600,400,Image.SCALE_SMOOTH);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel i0 = new JLabel(i9);
        i0.setBounds(0,0,600,400);
        add(i0);


        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            String t1 = this.t1.getText();

            conn c = new conn();

            String w = null;
            try {
                String str = "Select wallet from pat_info where pat_id='" + pat_login.pat_check + "'; ";
                ResultSet rs = c.s.executeQuery(str);
                while (rs.next()) {
                    w = rs.getString("wallet");

                }
            } catch (Exception a) {
                System.out.println(a);
            }
            if (w.equals("0") || parseInt(w) < parseInt(t1)) {
                JOptionPane.showMessageDialog(null, "No enough money in your wallet");
            } else {
                String str1 = "Update pat_info set wallet= wallet -'" + t1 + "' where pat_id='" + pat_login.pat_check + "';";
                try {
                    c.s.executeUpdate(str1);
                    JOptionPane.showMessageDialog(null, "Payment Successfull");
                } catch (Exception e) {
                    System.out.println(e);
                }
                String str5 = "Update admin set payment= payment +'" + t1 + "' where ID='98215';";
                try {
                    c.s.executeUpdate(str5);
                } catch (Exception e) {
                    System.out.println(e);
                }


                String str = "insert into accept_acc (app_id, pat_n, hospital, Time, date, doc_aid, pat_aid, doc_n, spec) values('" + bookapp.app_id + "','" + bookapp.na + "','" + bookapp.h + "','" + bookapp.ti + "','" + bookapp.app_d + "','" + bookapp.d_id + "','" + pat_login.pat_check + "','" + bookapp.n + "','" + bookapp.spec + "');";
                try {
                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Appointment Booked Successfully");
                } catch (Exception e) {
                    System.out.println(e);
                }
                try {
                    String str4 = "insert into payment(idpayment, paid_to, pat_n, amount) values ('"+bookapp.idpay+"','"+bookapp.n+"','"+bookapp.na+"','400');";
                    c.s.executeUpdate(str4);
                } catch (Exception e) {
                    System.out.println(e);
                }
                this.t1.setText(null);
                new pat_appSelect();
                this.setVisible(false);
            }

        }


        else if (ae.getSource() == home) {
            new pat_home();
            this.setVisible(false);
        }


        else if (ae.getSource() == b2) {
            String t1 = this.t1.getText();

            conn c = new conn();

            String w = null;String na = null;
            try {
                String str = "Select wallet,pat_name from pat_info where pat_id='" + pat_login.pat_check + "'; ";
                ResultSet rs = c.s.executeQuery(str);
                while (rs.next()) {
                    w = rs.getString("wallet");
                    na = rs.getString("pat_name");

                }
            } catch (Exception a) {
                System.out.println(a);
            }
            if (w.equals("0") || parseInt(w) < parseInt(t1)) {
                JOptionPane.showMessageDialog(null, "No enough money in your wallet");
            }

            else {
                String str1 = "Update pat_info set wallet= wallet -'" + t1 + "' where pat_id='" + pat_login.pat_check + "';";
                try {
                    c.s.executeUpdate(str1);
                    JOptionPane.showMessageDialog(null, "Payment Successfull");
                    this.t1.setText(null);
                } catch (Exception e) {
                    System.out.println(e);
                }
                String str5 = "Update admin set payment= payment +'" + t1 + "' where ID='98215';";
                try {
                    c.s.executeUpdate(str5);
                } catch (Exception e) {
                    System.out.println(e);
                }


                Random r1 = new Random();
                String idpay = String.valueOf(r1.nextInt(10000, 100000));

                try {
                    String str4 = "insert into payment(idpayment, paid_to, pat_n, amount) values ('" + idpay + "','Admin','" + na + "','" + t1 + "');";
                    c.s.executeUpdate(str4);
                } catch (Exception ea) {
                    System.out.println(ea);
                }
                JOptionPane.showMessageDialog(null,"Medicine Ordered Successfully");
            }

            String str3 = "truncate table book_med;";
            try {
                c.s.executeUpdate(str3);
            } catch (Exception e) {
                System.out.println(e);
            }

            String str1 = "Update medicine set quantity='0';";
            try {
                c.s.executeUpdate(str1);
            } catch (Exception e) {
                System.out.println(e);
            }
            new pat_home();
            this.setVisible(false);


        }

    }



    public static void main(String[] args) {
        new pay_am();
    }
}



