package VHA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;

public class confirmcanceldoc extends JFrame implements ActionListener {
    JButton Y,N;
    JLabel l1;
    public confirmcanceldoc(){
        setSize(500,300);

        l1=new JLabel("Are You Sure You Want To Cancel Appointment?");
        l1.setBounds(30, 50, 500, 50);
        l1.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(l1);

        Y=new JButton("Yes");
        Y.setBounds(100,150,80,50);
        Y.addActionListener(this);
        add(Y);

        N=new JButton("No");
        N.setBounds(300,150,80,50);
        N.addActionListener(this);
        add(N);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource()==Y)
        {
            conn c = new conn();

            String str2 = "select pat_aid from accept_acc where app_id='" + doc_appointment.app_id + "';";
            String pi = null;
            try {
                ResultSet rs = c.s.executeQuery(str2);
                pi = null;
                while (rs.next()) {
                    pi = rs.getString("pat_aid");
                }
            } catch (Exception e) {
                System.out.println(e);
            }

            String str = "Update pat_info set wallet= wallet +'400' where pat_id= '" + pi + "';";
            try {
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Appointment Cancelled Successfully");
            } catch (Exception e) {
                System.out.println(e);
            }
            String str5 = "Update admin set payment= payment -'400' where ID='98215';";
            try {
                c.s.executeUpdate(str5);
            } catch (Exception e) {
                System.out.println(e);
            }



            String str1 = "delete from accept_acc where app_id='" + doc_appointment.app_id + "';";
            try {
                c.s.executeUpdate(str1);
            } catch (Exception a) {
                System.out.println(a);
            }


            Random r1 = new Random();
            String idpay = String.valueOf(r1.nextInt(10000, 100000));

            try {
                String str3 = "insert into payment(idpayment, paid_to, pat_n, amount) values ('"+idpay+"','"+doc_appointment.doc_n+"','"+doc_appointment.pat_n+"','-400');";
                c.s.executeUpdate(str3);
            }
            catch (Exception ea) {
                System.out.println(ea);
            }
            new doc_appointment();
            this.setVisible(false);

        }
        else if (ae.getSource()==N)
        {
            new doc_appointment();
           this.setVisible(false);

        }
    }

    public static void main(String[] args) {
        new confirmcanceldoc();
    }
}
