package VHA;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class delete extends JFrame implements MouseListener, ActionListener {
    JScrollPane sp1;
    JTabbedPane tabs;
    JTable details;
    JButton delete,cancel;
    JButton back,home;

    public static String name;
    public static String doc_id;
    public static String specialization;
    public static String contact;
    int row;

    delete(){
        setSize(1000,500);

        sp1=new JScrollPane();


        details= new JTable();
        sp1.setViewportView(details);
        tabs=new JTabbedPane();
        tabs.setBounds(400,80,520,350);

        tabs.add("DETAILS",sp1);
        add(tabs);

        conn c=new conn();
        try{
            String str1 ="select doc_name,doc_id,specialization,contact from doc_info; ";
            ResultSet rs= c.s.executeQuery(str1);
            details.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            System.out.println(e);
        }
        details.addMouseListener(this);


        delete=new JButton("DELETE");
        delete.setBounds(100,180,150,50);
        delete.addActionListener(this);
        add(delete);

        cancel=new JButton("CANCEL");
        cancel.setBounds(100,250,150,50);
        cancel.addActionListener(this);
        add(cancel);

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
        Image i8  = i7.getImage().getScaledInstance(1000,500,Image.SCALE_SMOOTH);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel i0 = new JLabel(i9);
        i0.setBounds(0,0,1000,500);
        add(i0);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        row = details.getSelectedRow();
        name = details.getModel().getValueAt(row, 0).toString();
        doc_id = details.getModel().getValueAt(row,1).toString();
        specialization = details.getModel().getValueAt(row , 2).toString();
        contact = details.getModel().getValueAt(row , 3).toString();

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource()==delete)
        {
            conn c=new conn();
            try{
                String str = "delete from doc_info where doc_id='"+doc_id+"';";
                 c.s.executeUpdate(str);

            }catch (Exception e){
                System.out.println(e);
            }
         try{
                String str2 = "delete from accept_acc where doc_aid='"+doc_id+"';";
                 c.s.executeUpdate(str2);

            }catch (Exception e){
                System.out.println(e);
            }
        }
        else if (ae.getSource()==cancel)
        {
            new delete();
            this.setVisible(false);
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
        new delete();
    }

}
