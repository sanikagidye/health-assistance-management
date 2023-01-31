package VHA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class admin_login extends JFrame implements ActionListener {
    JLabel l1,l2,l3;
    JTextField username;
    JPasswordField password;
    JButton login;

    public static String adm_check,pass_adm;
    public admin_login()
    {
        setSize(400,500);

        l1 = new JLabel("Admin ID");
        l1.setBounds(50,100,80,50);
        l1.setFont(new Font("Times new roman",Font.PLAIN,16));
        l1.setForeground(Color.white);
        add(l1);

        l2 = new JLabel("Password");
        l2.setBounds(50,200,80,50);
        l2.setFont(new Font("Times new roman",Font.PLAIN,16));
        l2.setForeground(Color.white);
        add(l2);

        l3 = new JLabel("Login");
        l3.setBounds(150,30,80,50);
        l3.setFont(new Font("Times new roman",Font.BOLD,25));
        add(l3);

        username = new JTextField();
        username.setBounds(150,100,100,50);
        add(username);

        password = new JPasswordField();
        password.setBounds(150,200,100,50);
        add(password);

        login= new JButton("Login");
        login.setBounds(150,300,80,50);
        login.addActionListener(this);
        add(login);

        ImageIcon i7= new ImageIcon(ClassLoader.getSystemResource("images/doc2.jpg"));
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
        if (ae.getSource()==login)
        {
            adm_check=this.username.getText();
            pass_adm=String.valueOf(this.password.getPassword());
            conn c= new conn();
            try{
                String str1="Select * from admin where ID='"+adm_check+"' AND password ='"+pass_adm+"'; ";
                ResultSet rs=c.s.executeQuery(str1);
                if(rs.next())
                {
                    JOptionPane.showMessageDialog(null,"Login Successfull");
                    new admin_home();
                    this.setVisible(false);
                }
                else {
                    JOptionPane.showMessageDialog(null,"Invalid Login Credentials");
                }
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
    }
    public static void main(String[] args) {
        new admin_login();
    }


}
