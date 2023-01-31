package VHA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class doc_login extends JFrame implements ActionListener {
    JLabel l1,l2,l3;
    JTextField username;
    JPasswordField password;
    JButton login;
    JButton back,home;

    public static String doc_check,pass_doc;
    public doc_login()
    {
        setSize(400,500);

        l1 = new JLabel("Doctor ID");
        l1.setBounds(50,100,80,50);
        l1.setFont(new Font("Times new roman",Font.PLAIN,16));
        add(l1);

        l2 = new JLabel("Password");
        l2.setBounds(50,200,80,50);
        l2.setFont(new Font("Times new roman",Font.PLAIN,16));
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
        home.setBounds(335,0,50,40);
        home.addActionListener(this);
        add(home);

        ImageIcon i7= new ImageIcon(ClassLoader.getSystemResource("images/doci3.jpg"));
        Image i8  = i7.getImage().getScaledInstance(800,500,Image.SCALE_SMOOTH);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel i0 = new JLabel(i9);
        i0.setBounds(0,0,400,500);
        add(i0);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource()==login)
        {
            doc_check=this.username.getText();
            pass_doc=String.valueOf(this.password.getPassword());
            conn c= new conn();
            try{
                String str1="Select * from doc_info where doc_id='"+doc_check+"' AND password ='"+pass_doc+"'; ";
                ResultSet rs=c.s.executeQuery(str1);
                if(rs.next())
                {
                    JOptionPane.showMessageDialog(null,"Login Successfull");
                    new doc_home();
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
        else if(ae.getSource()==back)
        {
            new login_signup_doc();
            this.setVisible(false);
        }
        else if(ae.getSource()==home)
        {
            new Main();
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new doc_login();
    }


}
