package VHA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class select extends JFrame implements ActionListener {
    JLabel l1;
    JRadioButton doctor,patient;
    ButtonGroup b1;
    JButton home;



    select()
    {
        setSize(600,400);

        l1=new JLabel("Who are you?");
        l1.setBounds(200,50,300,90);
        l1.setFont(new Font("Times New Roman",Font.BOLD,25));
        l1.setForeground(Color.black);
        add(l1);

        b1=new ButtonGroup();

        doctor=new JRadioButton("Doctor");
        doctor.setBounds(130,150,90,40);
        doctor.setFont(new Font("Times New Roman",Font.PLAIN,20));
        b1.add(doctor);
        doctor.addActionListener(this);
        add(doctor);

         patient=new JRadioButton("Patient");
        patient.setBounds(330,150,90,40);
        patient.setFont(new Font("Times New Roman",Font.PLAIN,20));
        b1.add(patient);
        patient.addActionListener(this);
        add(patient);


        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("images/home.png"));
        Image i5= i4.getImage().getScaledInstance(50,40,Image.SCALE_SMOOTH);
        ImageIcon i6=new ImageIcon(i5);
        home=new JButton(i6);
        home.setBounds(535,0,50,40);
        home.addActionListener(this);
        add(home);

        ImageIcon i7= new ImageIcon(ClassLoader.getSystemResource("images/pat1.jpg"));
        Image i8  = i7.getImage().getScaledInstance(600,400,Image.SCALE_SMOOTH);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel i0 = new JLabel(i9);
        i0.setBounds(0,0,600,400);
        add(i0);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == doctor)
        {
         new login_signup_doc();
         this.setVisible(false);
        }

        else if (ae.getSource() == patient)
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

    public static void main(String[] args) {
        new select();
    }

}
