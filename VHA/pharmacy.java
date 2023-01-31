package VHA;

import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.util.Random;

import static VHA.pat_login.pat_check;

public class pharmacy extends JFrame implements MouseListener ,ActionListener{
    JLabel l1;
    JTable t1;
    JScrollPane sp1;
    JButton cart,cancel;
    JButton home;

    int row;
    public static String id,name,type,cost,q;
    int a=0;
    pharmacy() {
        setSize(1000, 800);

        l1=new JLabel("Medicines");
        l1.setBounds(450,50,300,90);
        l1.setFont(new Font("Times New Roman",Font.BOLD,25));
        add(l1);

        sp1 = new JScrollPane();
        sp1.setBounds(100,200,800,200);
        add(sp1);

        t1 = new JTable();
        sp1.setViewportView(t1);
        t1.addMouseListener(this);

        cart =new JButton("Order");
        cart.setBounds(200,500,180,50);
        cart.addActionListener(this);
        add(cart);

        cancel =new JButton("Cancel");
        cancel.setBounds(600,500,180,50);
        cancel.addActionListener(this);
        add(cancel);


        conn c = new conn();
        try{
            String str3 = "select * from medicine order by med_name;";
            ResultSet rs = c.s.executeQuery(str3);
            t1.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception e){
            System.out.println(e);
        }

        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("images/home.png"));
        Image i5= i4.getImage().getScaledInstance(50,40,Image.SCALE_SMOOTH);
        ImageIcon i6=new ImageIcon(i5);
        home=new JButton(i6);
        home.setBounds(935,0,50,40);
        home.addActionListener(this);
        add(home);

        ImageIcon i7= new ImageIcon(ClassLoader.getSystemResource("images/med2.jpg"));
        Image i8  = i7.getImage().getScaledInstance(1000,800,Image.SCALE_SMOOTH);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel i0 = new JLabel(i9);
        i0.setBounds(0,0,1000,800);
        add(i0);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        row=t1.getSelectedRow();
        id=t1.getModel().getValueAt(row,0).toString();
        name=t1.getModel().getValueAt(row,1).toString();
        type=t1.getModel().getValueAt(row,2).toString();
        cost=t1.getModel().getValueAt(row,3).toString();
        q=t1.getModel().getValueAt(row,4).toString();


        conn c= new conn();
        String str2 = "Update medicine set quantity= quantity +'"+1+"' where med_id ='"+id+"';";

        try {
            c.s.executeUpdate(str2);
        } catch (Exception ea) {
            System.out.println(ea);
        }

       String o_id;
        Random r=new Random();
        o_id= String.valueOf(r.nextInt(1000,10000));

        String str3 = "insert into book_med(o_id, med_name, med_type, cost, quantity, pat_id) values ('" + o_id + "','" + name + "','" + type + "','" + cost + "','" +1+ "','"+pat_login.pat_check+"') ;";
        try {
            c.s.executeUpdate(str3);
        } catch (Exception ea) {
            System.out.println(ea);
        }

        String str4 = "insert into o_det(O_id, med_name, med_type, cost, quantity, pat_id) values ('" + o_id + "','" + name + "','" + type + "','" + cost + "','" + 1+ "','"+pat_login.pat_check+"') ;";
        try {
            c.s.executeUpdate(str4);
        } catch (Exception ea) {
            System.out.println(ea);
        }

        new pharmacy();
        this.setVisible(false);
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
        if(ae.getSource()==cart)
        {
            new order();
            this.setVisible(false);
        }
        if(ae.getSource()==cancel)
        {
            conn c= new conn();
            String str5 = "truncate table book_med;";
            try {
                c.s.executeUpdate(str5);
            } catch (Exception e) {
                System.out.println(e);
            }

            String str6 = "Update medicine set quantity='0';";
            try {
                c.s.executeUpdate(str6);
            } catch (Exception e) {
                System.out.println(e);
            }
            new pat_home();
            this.setVisible(false);
        }
        else if(ae.getSource()==home)
        {
            new pat_home();
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new pharmacy();
    }


}