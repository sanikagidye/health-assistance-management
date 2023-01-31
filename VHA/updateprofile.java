package VHA;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class updateprofile  extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4;
    JTextField doc_id,data;
    JButton display,submit;
    JComboBox fields;
    JTable t1;
    JScrollPane sp1;
    JButton back,home;

    String[] list={"name","specialization","contact","hospital"};
    updateprofile(){
        setSize(1000,600);

        l1= new JLabel("Doctor ID:");
        l1.setBounds(80,40,150,50);
        add(l1);

        doc_id=new JTextField();
        doc_id.setBounds(250,40,150,40);
        add(doc_id);

        display=new JButton("Display");
        display.setBounds(450,40,100,40);
        display.addActionListener(this);
        add(display);

        sp1=new JScrollPane();
        sp1.setBounds(50,100,700,60);
        add(sp1);

        t1=new JTable();
        sp1.setViewportView(t1);

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

        ImageIcon i7= new ImageIcon(ClassLoader.getSystemResource("images/adm1.jpg"));
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
        if(ae.getSource()==display){
            String doc_id=this.doc_id.getText();
            conn c=new conn();
            try{
                String str="select doc_name,specialization,contact,gender from doc_info where doc_id='"+doc_id+"';";
                ResultSet rs=c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch (Exception e){
                System.out.println(e);
            }

        }
        if(ae.getSource()==submit){
            String doc_id=this.doc_id.getText();
            String value=this.data.getText();
            String choice= fields.getSelectedItem().toString();
            conn c=new conn();
            try{
                String str= "update doc_info set "+choice+"= '"+value+"'where doc_id='"+doc_id+"';";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Data Updated Successfully");
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource()==back)
        {
            new edit_doc();
            this.setVisible(false);
        }
        else if(ae.getSource()==home)
        {
            new admin_home();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new updateprofile();
    }
}
