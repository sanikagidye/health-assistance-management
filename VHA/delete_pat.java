package VHA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class delete_pat extends JFrame implements ActionListener {
    JLabel l1;
    JButton b1,b2 ;
    delete_pat()
    {
        setSize(600,300);

        l1=new JLabel("Are you Sure You Want To Delete Your Account?");
        l1.setBounds(80,50,450,50);
        l1.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(l1);

        b1=new JButton("Yes");
        b1.setBounds(170,150,70,50);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("No");
        b2.setBounds(320,150,70,50);
        b2.addActionListener(this);
        add(b2);

        ImageIcon i7= new ImageIcon(ClassLoader.getSystemResource("images/pat10.jpg"));
        Image i8  = i7.getImage().getScaledInstance(600,300,Image.SCALE_SMOOTH);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel i0 = new JLabel(i9);
        i0.setBounds(0,0,600,300);
        add(i0);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource()==b1) {
            conn c=new conn();
            try{
                String str = "delete from pat_info where pat_id='"+pat_login.pat_check+"';";
                c.s.executeUpdate(str);
            }catch (Exception e){
                System.out.println(e);
            }

      try{
                String str = "delete from prescription where pat_id='"+pat_login.pat_check+"';";
                c.s.executeUpdate(str);
            }catch (Exception e){
                System.out.println(e);
            }

      try{
                String str2 = "delete from accept_acc where pat_aid='"+pat_login.pat_check+"';";
                c.s.executeUpdate(str2);
                JOptionPane.showMessageDialog(null,"Account Deleted Successfully");
                new Main();
                this.setVisible(false);

            }catch (Exception e){
                System.out.println(e);
            }

        }
    else if (ae.getSource()==b2) {
            new pat_home();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new delete_pat();
    }
}

