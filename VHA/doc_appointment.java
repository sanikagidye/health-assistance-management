package VHA;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class doc_appointment extends JFrame implements MouseListener, ActionListener {
   JTable t1,t2;
   JScrollPane sp1,sp2;
   JTabbedPane tabs;
   JButton home;

   public static String pat_n,spe,hosp,time,doc_n,doc_id,pat_id,app_id,date;
   int row;
   public doc_appointment()
   {
      setSize(800,800);

      t1=new JTable();
      sp1 = new JScrollPane();
      sp1.setViewportView(t1);

//      fetching data for t1

      conn c= new conn();
      try
      {
      String str1="Select app_id, pat_n,doc_n, hospital, Time,date,spec,doc_aid, pat_aid from accept_acc where doc_aid='"+doc_login.doc_check+"';";
      ResultSet rs1 = c.s.executeQuery(str1);
      t1.setModel(DbUtils.resultSetToTableModel(rs1));
      }
      catch (Exception e) {
         System.out.println(e);
      }
      t1.addMouseListener(this);

//table 2

      t2 = new JTable();
      sp2=new JScrollPane();
      sp2.setViewportView(t2);

      try
      {
      String str2="Select Time,date, hospital, spec, pat_n,app_id from accept_acc where doc_aid='"+doc_login.doc_check+"';";
      ResultSet rs2 = c.s.executeQuery(str2);
      t2.setModel(DbUtils.resultSetToTableModel(rs2));
      }
      catch (Exception e) {
         System.out.println(e);
      }


      tabs = new JTabbedPane();
      tabs.setBounds(50,90,600,500);

      //adding tabs
      tabs.add("Accept/cancel", sp1);
      tabs.add("Appointments", sp2);
      add(tabs);

      ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("images/home.png"));
      Image i5= i4.getImage().getScaledInstance(50,40,Image.SCALE_SMOOTH);
      ImageIcon i6=new ImageIcon(i5);
      home=new JButton(i6);
      home.setBounds(735,0,50,40);
      home.addActionListener(this);
      add(home);

      ImageIcon i7= new ImageIcon(ClassLoader.getSystemResource("images/dpcapp2.jpg"));
      Image i8  = i7.getImage().getScaledInstance(800,800,Image.SCALE_SMOOTH);
      ImageIcon i9 = new ImageIcon(i8);
      JLabel i0 = new JLabel(i9);
      i0.setBounds(0,0,800,800);
      add(i0);

      setLayout(null);
      setLocationRelativeTo(null);
      setVisible(true);

   }

   public void actionPerformed(ActionEvent ae)
   {
       if(ae.getSource()==home)
      {
         new doc_home();
         this.setVisible(false);
      }
   }
   @Override
   public void mouseClicked(MouseEvent me) {
      row = t1.getSelectedRow();
      app_id = t1.getModel().getValueAt(row, 0).toString();
      pat_n = t1.getModel().getValueAt(row, 1).toString();
      doc_n = t1.getModel().getValueAt(row, 2).toString();
      hosp = t1.getModel().getValueAt(row, 3).toString();
      time = t1.getModel().getValueAt(row, 4).toString();
      date = t1.getModel().getValueAt(row, 5).toString();
      spe = t1.getModel().getValueAt(row, 6).toString();
      doc_id = t1.getModel().getValueAt(row, 7).toString();
      pat_id = t1.getModel().getValueAt(row, 8).toString();

      new confirmcanceldoc();
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
      new doc_appointment();
   }

}
