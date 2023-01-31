package VHA;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.sql.ResultSet;
import java.util.Random;

public class cancel_app_pat extends JFrame implements MouseListener , ActionListener {
  JScrollPane sp1;

  JTable t1;
  JTabbedPane tabs;
  public static String doc_id,pat_id,app_id,n_doc,n_pat;
  int row;
  JButton back,home;
  public  cancel_app_pat()
    {
      setSize(800,500);

        sp1=new JScrollPane();
        add(sp1);

        t1=new JTable();
        sp1.setViewportView(t1);

      conn c= new conn();
      try
      {
        String str1="Select pat_n,doc_n, hospital, Time,date,spec,doc_aid, pat_aid,app_id from accept_acc where pat_aid ='"+pat_login.pat_check+"';";
        ResultSet rs1 = c.s.executeQuery(str1);
        t1.setModel(DbUtils.resultSetToTableModel(rs1));
      }
      catch (Exception e) {
        System.out.println(e);
      }
      t1.addMouseListener(this);
      tabs = new JTabbedPane();
      tabs.setBounds(100,60,600,300);

      //adding tabs
      tabs.add("Click on the appointment to cancel", sp1);
      add(tabs);

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
      home.setBounds(735,0,50,40);
      home.addActionListener(this);
      add(home);

      ImageIcon i7= new ImageIcon(ClassLoader.getSystemResource("images/dpcapp2.jpg"));
      Image i8  = i7.getImage().getScaledInstance(800,500,Image.SCALE_SMOOTH);
      ImageIcon i9 = new ImageIcon(i8);
      JLabel i0 = new JLabel(i9);
      i0.setBounds(0,0,800,500);
      add(i0);

      setLayout(null);
      setLocationRelativeTo(null);
      setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
      if(ae.getSource()==back)
      {
        new pat_appSelect();
        this.setVisible(false);
      }
   else if(ae.getSource()==home)
      {
        new pat_home();
        this.setVisible(false);
      }
    }

  @Override
  public void mouseClicked(MouseEvent e) {

    row=t1.getSelectedRow();
    app_id=t1.getModel().getValueAt(row,8).toString();
    n_pat=t1.getModel().getValueAt(row,0).toString();
    n_doc=t1.getModel().getValueAt(row,1).toString();

    new confirmcancelpat();
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


  public static void main(String[] args) {
    new cancel_app_pat();
  }
}
