package VHA;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Edit_pat  extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4;
    JTextField pat_id,data;
    JButton submit;
    JComboBox fields;
    JTable t1;
    JScrollPane sp1;
    JButton back,home;

    String[] list={"address","email","contact","gender"};
    Edit_pat(){
        setSize(1000,600);

        l1= new JLabel("Patient ID:");
        l1.setBounds(80,40,150,50);
        add(l1);

        pat_id=new JTextField(""+pat_login.pat_check);
        pat_id.setBounds(250,40,150,40);
        add(pat_id);

        sp1=new JScrollPane();
        sp1.setBounds(50,100,700,60);
        add(sp1);

        t1=new JTable();
        sp1.setViewportView(t1);

        conn c=new conn();
        try{
            String str="select pat_name, age, gender, dob, blood_group, email, contact, address from pat_info where pat_id='"+pat_login.pat_check+"';";
            ResultSet rs=c.s.executeQuery(str);
            t1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (Exception e){
            System.out.println(e);
        }

        l2=new JLabel("Choose Field");
        l2.setBounds(80,300,150,50);
        add(l2);

        fields=new JComboBox(list);
        fields.setBounds(300,300,150,40);
        add(fields);

        data=new JTextField();
        data.setBounds(300,380,150,40);
        add(data);

        submit=new JButton("Updated Data");
        submit.setBounds(400,450,180,50);
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
        home.setBounds(935,0,50,40);
        home.addActionListener(this);
        add(home);

        ImageIcon i7= new ImageIcon(ClassLoader.getSystemResource("images/patg5.jpeg"));
        Image i8  = i7.getImage().getScaledInstance(1000,600,Image.SCALE_SMOOTH);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel i0 = new JLabel(i9);
        i0.setBounds(0,0,1000,600);
        add(i0);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String pat_id=this.pat_id.getText();
            String value=this.data.getText();
            String choice= fields.getSelectedItem().toString();
            conn c=new conn();
            try{
                String str= "update pat_info set "+choice+"= '"+value+"'where pat_id='"+pat_id+"';";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Data Updated Successfully");
                new Edit_pat();
                this.setVisible(false);
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        if(ae.getSource()==back)
        {
            new pat_home();
            this.setVisible(false);
        }
        else if(ae.getSource()==home)
        {
            new pat_home();
            this.setVisible(false);
        }
        this.pat_id.setText(null);
        this.data.setText(null);
    }


    public static void main(String[] args) {
        new Edit_pat();
    }
}
