package VHA;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Random;

public class pat_reg extends JFrame  implements ActionListener
 {
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
    JTextField name,age,email,contact,address;
    JButton submit;
    JRadioButton male,female;
    ButtonGroup b1;
    JPasswordField p1,p2;
    JDateChooser dob;
    JComboBox c1;
     JButton back,home;

     //size variable
    int labX=60;
    int labH=100;
    int labw=50;
    int tX=200;
    int tH=40;
    int tw=150;

    pat_reg()
    {
        setSize(600,850);

        //Labels
        l1 =new JLabel("Register");
        l1.setBounds(250,40,120,labw);
        l1.setFont(new Font("Times New Roman",Font.BOLD,25));
        add(l1);

        l2=new JLabel("Name");
        l2.setBounds(labX,100,labH,labw);
        add(l2);

        l3=new JLabel("Age");
        l3.setBounds(labX,160,labH,labw);
        add(l3);

        l4 =new JLabel("Gender");
        l4.setBounds(labX,220,labH,labw);
        add(l4);

        l5=new JLabel("Email");
        l5.setBounds(labX,400,labH,labw);
        add(l5);

        l6=new JLabel("Contact");
        l6.setBounds(labX,460,labH,labw);
        add(l6);

        l7 =new JLabel("Address");
        l7.setBounds(labX,520,labH,labw);
        add(l7);

        l8 =new JLabel(" Create Password");
        l8.setBounds(labX,580,labH,labw);
        add(l8);

        l9 =new JLabel(" Confirm Password");
        l9.setBounds(labX,640,120,labw);
        add(l9);

       l10= new JLabel("Blood Group");
        l10.setBounds(labX,340,120,labw);
        add(l10);

       l11 =new JLabel("DOB");
        l11.setBounds(labX,280,120,labw);
        add(l11);

        //TextFields
        name=new JTextField();
        name.setBounds(tX,100,tw,tH);
        add(name);

        age=new JTextField();
        age.setBounds(tX,160,tw,tH);
        add(age);

        email=new JTextField();
        email.setBounds(tX,400,tw,tH);
        add(email);

        contact=new JTextField();
        contact.setBounds(tX,460,tw,tH);
        add(contact);

        address=new JTextField();
        address.setBounds(tX,520,tw,tH);
        add(address);

        //RadioButtons
        b1=new ButtonGroup();

        male=new JRadioButton("Male");
        male.setBounds(tX,220,65,tH);
        b1.add(male);
        add(male);

        female=new JRadioButton("Female");
        female.setBounds(300,220,80,tH);
        b1.add(female);
        add(female);

        //Password

        p1=new JPasswordField();
        p1.setBounds(tX,580,tw,tH);
        add(p1);

        p2=new JPasswordField();
        p2.setBounds(tX,640,tw,tH);
        add(p2);

        //Combo
        String[] bg = {"O +ve","O -ve","A +ve","A -ve","B +ve","B -ve","AB +ve","AB -ve"};
        c1= new JComboBox(bg);
        c1.setBounds(tX,340,tw,tH);
        add(c1);

        dob=new JDateChooser();
        dob.setBounds(tX,280,tw,tH);
        add(dob);

        submit =new JButton("Submit");
        submit.setBounds(200,700,180,40);
        submit.addActionListener(this);
        add(submit);

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
        home.setBounds(535,0,50,40);
        home.addActionListener(this);
        add(home);

        ImageIcon i7= new ImageIcon(ClassLoader.getSystemResource("images/patg5.jpeg"));
        Image i8  = i7.getImage().getScaledInstance(600,850,Image.SCALE_SMOOTH);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel i0 = new JLabel(i9);
        i0.setBounds(0,0,600,850);
        add(i0);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
   public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit)
        {
            String name=this.name.getText();
            String age=this.age.getText();
            String address=this.address.getText();
            String email=this.email.getText();
            if(email.contains("@"))
            {
            }
            else {
                JOptionPane.showMessageDialog(null,"Check Your Email");
            }
            String contact=this.contact.getText();
            if(contact.length()!=10){
                JOptionPane.showMessageDialog(null,"Check Your Contact Number");
            }
            String p1=String.valueOf(this.p1.getPassword());
            String p2=String.valueOf(this.p2.getPassword());
            if(!p1.equals(p2)){
                JOptionPane.showMessageDialog(null,"Check Your Password");
            }

            SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MM/YYYY");
            String dob= dateFormat.format(this.dob.getDate());

            String gender= null ;
            if(this.male.isSelected())
            {
                gender="Male";
            }
            else if (this.female.isSelected())
            {
                gender ="Female";
            }
            else{
            }

            String bg=null;
                bg= (String) c1.getSelectedItem();

            String pat_id;
            Random r=new Random();
            pat_id= String.valueOf(r.nextInt(1000,10000));

            String w="0";

            conn c= new conn();
            String str = "insert into pat_info (pat_name,age,gender,dob,blood_group,email,contact,address,password,pat_id,wallet) values('"+name+"','"+age+"','"+gender+"','"+dob+"','"+bg+"','"+email+"','"+contact+"','"+address+"','"+p1+"','"+pat_id+"','"+w+"'); ";
            try {
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Data Added Successfully");
            }
            catch(Exception e)
            {
                System.out.println(e);
            }

            JOptionPane.showMessageDialog(null,"REMEMBER THE ID TO LOGIN \n Your ID is : "+pat_id );

            this.name.setText(null);
            this.contact.setText(null);
            this.age.setText(null);
            this.email.setText(null);
            this.address.setText(null);
            this.p1.setText(null);
            this.p2.setText(null);
            this.male.setSelected(false);
            this.female.setSelected(false);

            new pat_login();
            this.setVisible(false);

        }
       else if(ae.getSource()==back)
       {
           new login_signup_pat();
           this.setVisible(false);
       }
       else if(ae.getSource()==home)
       {
           new Main();
           this.setVisible(false);
       }
   }
       public static void main (String[]args){
           new pat_reg();
       }

}
