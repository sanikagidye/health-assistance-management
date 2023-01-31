package VHA;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class admin_home extends JFrame implements ActionListener {
    JMenuBar mb,mb1;
    JButton pay,add_doc,edit_doc,logout,show_doc,show_pat,med;
    JTable t1;
    JScrollPane sp1;

    admin_home() {
        setSize(1000, 650);
        mb=new JMenuBar();
        mb.setBounds(0,0,150,600);
        mb.setBackground(Color.BLUE);
        mb.setBackground(Color.getColor("gray",40));
        mb.setLayout(new GridLayout(4,1));

        mb1=new JMenuBar();
        mb1.setBounds(830,0,150,600);
        mb1.setBackground(Color.BLUE);
        mb1.setBackground(Color.getColor("gray",40));
        mb1.setLayout(new GridLayout(3,1));

        pay=new JButton("PAYMENT");
        pay.addActionListener(this);
        mb.add(pay);


        add_doc=new JButton("ADD DOCTOR");
        add_doc.addActionListener(this);
        mb.add(add_doc);


        edit_doc=new JButton("EDIT DOCTOR ");
        edit_doc.addActionListener(this);
        mb.add(edit_doc);

        show_doc=new JButton("SHOW DOCTORS");
        show_doc.addActionListener(this);
        mb1.add(show_doc);

        show_pat=new JButton("SHOW PATIENTS");
        show_pat.addActionListener(this);
        mb1.add(show_pat);

        med=new JButton("Medicine Ordered");
        med.addActionListener(this);
        mb1.add(med);

        logout=new JButton("LOGOUT");
        logout.addActionListener(this);
        mb.add(logout);

        add(mb);
        add(mb1);

        ImageIcon i7= new ImageIcon(ClassLoader.getSystemResource("images/doc3.jpg"));
        Image i8  = i7.getImage().getScaledInstance(1000,650,Image.SCALE_SMOOTH);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel i0 = new JLabel(i9);
        i0.setBounds(0,0,1000,650);
        add(i0);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==add_doc){
            new add_doc().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==pay){
            new ad_pay().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==edit_doc){
            new edit_doc().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==logout){
            JOptionPane.showMessageDialog(null,"Logged out Successfully");
            this.setVisible(false);
        }
        else if(ae.getSource()==show_doc){
            new show_doc().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==show_pat){
            new show_pat().setVisible(true);
            this.setVisible(false);
        }

    else if(ae.getSource()==med){
            new ad_med().setVisible(true);
            this.setVisible(false);
        }

    }

    public static void main(String[] args) {
        new admin_home();
    }
}




