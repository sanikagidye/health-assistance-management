package VHA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class add_doc extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    JTextField name,doc_id,specialization,contact,hospital;
    JButton submit;
    JRadioButton male,female;
    ButtonGroup b1;
    JPasswordField p1,p2;
    //size variable
    int labX=60;
    int labH=100;
    int labw=50;
    int tX=200;
    int tH=40;
    int tw=150;
    JButton home;
    add_doc()
    {
        setSize(600,750);

        l1=new JLabel("Name");
        l1.setBounds(labX,100,labH,labw);
        add(l1);

        l2=new JLabel("Doctor ID");
        l2.setBounds(labX,160,labH,labw);
        add(l2);

        l3=new JLabel("Specialization");
        l3.setBounds(labX,280,labH,labw);
        add(l3);


        l4=new JLabel("Contact");
        l4.setBounds(labX,340,labH,labw);
        add(l4);

        l5 =new JLabel("Gender");
        l5.setBounds(labX,220,labH,labw);
        add(l5);

       l6 =new JLabel(" Create Password");
        l6.setBounds(labX,460,labH,labw);
        add(l6);

        l7 =new JLabel(" Confirm Password");
        l7.setBounds(labX,510,120,labw);
        add(l7);

        l8 =new JLabel("Add Doctor");
        l8.setBounds(230,40,150,labw);
        l8.setFont(new Font("Times New Roman",Font.BOLD,25));
        add(l8);

        l9 =new JLabel("Hospital Name");
        l9.setBounds(labX,400,labH,labw);
        add(l9);

        //TextFields
        name=new JTextField();
        name.setBounds(tX,100,tw,tH);
        add(name);

        doc_id=new JTextField();
        doc_id.setBounds(tX,160,tw,tH);
        add(doc_id);

        b1=new ButtonGroup();

        male=new JRadioButton("Male");
        male.setBounds(tX,220,65,tH);
        b1.add(male);
        add(male);

        female=new JRadioButton("Female");
        female.setBounds(300,220,80,tH);
        b1.add(female);
        add(female);

        specialization=new JTextField();
        specialization.setBounds(tX,280,tw,tH);
        add(specialization);

        contact=new JTextField();
        contact.setBounds(tX,340,tw,tH);
        add(contact);

        hospital=new JTextField();
        hospital.setBounds(tX,400,tw,tH);
        add(hospital);

        //buttons
        submit =new JButton("Submit");
        submit.setBounds(200,580,180,40);
        submit.addActionListener(this);
        add(submit);

        p1=new JPasswordField();
        p1.setBounds(tX,460,tw,tH);
        add(p1);

       p2=new JPasswordField();
        p2.setBounds(tX,510,tw,tH);
        add(p2);

        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("images/home.png"));
        Image i5= i4.getImage().getScaledInstance(50,40,Image.SCALE_SMOOTH);
        ImageIcon i6=new ImageIcon(i5);
        home=new JButton(i6);
        home.setBounds(535,0,50,40);
        home.addActionListener(this);
        add(home);

        ImageIcon i7= new ImageIcon(ClassLoader.getSystemResource("images/adm1.jpg"));
        Image i8  = i7.getImage().getScaledInstance(600,750,Image.SCALE_SMOOTH);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel i0 = new JLabel(i9);
        i0.setBounds(0,0,600,750);
        add(i0);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String name = this.name.getText();
            String specialization = this.specialization.getText();
            String doc_id = this.doc_id.getText();
            String contact = this.contact.getText();
            if (contact.length() != 10) {
                JOptionPane.showMessageDialog(null, "Check Your Contact Number");
            }
            String p1 = String.valueOf(this.p1.getPassword());
            String p2 = String.valueOf(this.p2.getPassword());
            if (!p1.equals(p2)) {
                JOptionPane.showMessageDialog(null, "Check Your Password");
            }
            String hos=this.hospital.getText();

            String gender = null;
            if (this.male.isSelected()) {
                gender = "Male";
            } else if (this.female.isSelected()) {
                gender = "Female";
            } else {
            }

            conn c = new conn();
            String str = "insert into doc_info (doc_name,doc_id,specialization,gender,contact,hospital,password) values('" + name + "','" + doc_id + "','" + specialization + "','" + gender + "','" + contact + "','"+hos+"','" + p1 + "'); ";

            try {
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Data Added Successfully");
                this.name.setText(null);
                this.contact.setText(null);
                this.doc_id.setText(null);
                this.hospital.setText(null);
                this.specialization.setText(null);
                this.p1.setText(null);
                this.p2.setText(null);
                this.male.setSelected(false);
                this.female.setSelected(false);

            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(ae.getSource()==home)
        {
            new admin_home();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new add_doc();
    }

}
