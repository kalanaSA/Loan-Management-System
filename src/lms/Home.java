package lms;

import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.jtattoo.plaf.acryl.AcrylLookAndFeel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import net.proteanit.sql.DbUtils;

public class Home extends javax.swing.JFrame {
    
    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;

 
    public Home() {
        super("Welcome Loan Management System");
        initComponents();
        conn = DBconnect.connect();
        setIcon();
        
        
        jLabel5.setText(String.valueOf(User.username));
        
    }
    
    //object for FineshedLoans
    //FinishedLoans fl = new FinishedLoans();


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem18 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(null);

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/img/Allowance.png"))); // NOI18N
        jButton3.setText("Micro Loan Service");
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(610, 330, 200, 60);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/img/Add_Employee.png"))); // NOI18N
        jButton1.setText("Add Customer");
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(610, 260, 200, 60);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/img/Search_1.png"))); // NOI18N
        jButton2.setText("Search Customer");
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(820, 260, 210, 60);

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/img/Allowance.png"))); // NOI18N
        jButton4.setText("Fix Loan Service");
        jButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(820, 330, 210, 60);

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/img/Update.png"))); // NOI18N
        jButton5.setText("Repayments");
        jButton5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(820, 400, 210, 60);

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/img/Payment.png"))); // NOI18N
        jButton6.setText("Loan Details");
        jButton6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(610, 400, 200, 60);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/img/logout.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2);
        jLabel2.setBounds(980, 30, 20, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("LOG OUT");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3);
        jLabel3.setBounds(970, 60, 60, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Logged In As :");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 540, 81, 15);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("user");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(110, 540, 110, 15);

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/img/Search_1.png"))); // NOI18N
        jButton7.setText("Profit Share");
        jButton7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7);
        jButton7.setBounds(820, 470, 210, 60);

        jButton8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/img/Payment.png"))); // NOI18N
        jButton8.setText("Repayments Details");
        jButton8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8);
        jButton8.setBounds(610, 470, 200, 60);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/img/loan.jpeg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1050, 590);

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("add customer");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem8.setText("search customer");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem8);

        jMenuItem9.setText("add micro loan");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem9);

        jMenuItem10.setText("add fix loan");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem10);

        jMenuItem11.setText("show loan details");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem11);

        jMenuItem13.setText("add repayment");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem13);

        jMenuItem12.setText("repayment details");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem12);

        jMenuItem15.setText("log out");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem15);

        jMenuItem14.setText("Exit");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem14);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Reports");

        jMenuItem2.setText("customer report");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenu6.setText("loan reports");

        jMenu7.setText("micro loan reports");

        jMenuItem19.setText("daily micro loan report");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem19);

        jMenuItem20.setText("weekly micro loan report");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem20);

        jMenuItem21.setText("monthly micro loan report");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem21);

        jMenu6.add(jMenu7);

        jMenuItem3.setText("fix loan report");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem3);

        jMenu2.add(jMenu6);

        jMenu5.setText("repayment reports");

        jMenu8.setText("micro loan repayment reports");

        jMenuItem4.setText("daily micro loan repayment report");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem4);

        jMenuItem16.setText("weekly micro loan repayment report");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem16);

        jMenuItem17.setText("monthly micro loan repayment report");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem17);

        jMenu5.add(jMenu8);

        jMenuItem6.setText("fix loan repayments report");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem6);

        jMenu2.add(jMenu5);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Audit");

        jMenuItem7.setText("audit trail");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenuBar1.add(jMenu3);

        jMenu9.setText("show");

        jMenuItem5.setText("Fineshed Loans");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem5);

        jMenuBar1.add(jMenu9);

        jMenu4.setText("About");

        jMenuItem18.setText("about developer");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem18);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1043, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1059, 620));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        AddCustomer ac = new AddCustomer();
        ac.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        SearchCustomer sc = new SearchCustomer();
        sc.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        Login l = new Login();
        l.setVisible(true);
        this.dispose();
        
        //for the audit logout date & time
        try{
             Date currentDate = GregorianCalendar.getInstance().getTime();
                    DateFormat df = DateFormat.getDateInstance();
                    String dateString = df.format(currentDate);
                    
                    Date d = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                    String timeString = sdf.format(d);
                    
                    String value1 = timeString;
                    String value2 = dateString;
                    
                    String value3 = User.userid;
                    String value4 = User.username;
                    
                    String reg ="INSERT INTO audit(userId,username,date,status) VALUES('"+value3+"','"+value4+"',"
                            + "'"+value1+" / "+value2+"','Logged out')";
                    
                    pst=conn.prepareStatement(reg);
                    pst.execute();
                    this.dispose();

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            
        }finally{
            try{
                rs.close();
                pst.close();
            
            }catch(Exception e){
            }
        
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        Login l = new Login();
        l.setVisible(true);
        this.dispose();
        
        //for the audit logout date & time
        try{
             Date currentDate = GregorianCalendar.getInstance().getTime();
                    DateFormat df = DateFormat.getDateInstance();
                    String dateString = df.format(currentDate);
                    
                    Date d = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                    String timeString = sdf.format(d);
                    
                    String value1 = timeString;
                    String value2 = dateString;
                    
                    String value3 = User.userid;
                    String value4 = User.username;
                    
                    String reg ="INSERT INTO audit(userId,username,date,status) VALUES('"+value3+"','"+value4+"',"
                            + "'"+value1+" / "+value2+"','Logged out')";
                    
                    pst=conn.prepareStatement(reg);
                    pst.execute();
                    this.dispose();

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            
        }finally{
            try{
                rs.close();
                pst.close();
            
            }catch(Exception e){
            }
        
        }
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        AddMicroLoan aml = new AddMicroLoan();
        aml.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        Repayment r = new Repayment();
        r.setVisible(true);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        LoanDetails ls = new LoanDetails();
        ls.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        AddFixLoan afl = new AddFixLoan();
        afl.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        
        JFileChooser dialog = new JFileChooser();
            dialog.setSelectedFile(new File("customers-report.pdf"));
            int dialogResult = dialog.showSaveDialog(null);
            if (dialogResult==JFileChooser.APPROVE_OPTION){
            String filePath = dialog.getSelectedFile().getPath();
           
        try {

            String sql ="select * from customerdetails";
 
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();

            
           Document myDocument = new Document();
           PdfWriter myWriter = PdfWriter.getInstance(myDocument, new FileOutputStream(filePath ));
           PdfPTable table = new PdfPTable(7);
           myDocument.open();
           
           
           float[] columnWidths = new float[] {5,9,9,18,18,9,5};
           table.setWidths(columnWidths);

           table.setWidthPercentage(100); //set table width to 100%
           
          
          myDocument.add(new Paragraph("Customers List",FontFactory.getFont(FontFactory.TIMES_BOLD,20,Font.BOLD )));
          myDocument.add(new Paragraph(new Date().toString()));
          myDocument.add(new Paragraph("-------------------------------------------------------------------------------------------"));
          table.addCell(new PdfPCell(new Paragraph("id",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
          table.addCell(new PdfPCell(new Paragraph("name",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
          table.addCell(new PdfPCell(new Paragraph("nic",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
          table.addCell(new PdfPCell(new Paragraph("address",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
          table.addCell(new PdfPCell(new Paragraph("resistnce",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
          table.addCell(new PdfPCell(new Paragraph("contactNo",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
          table.addCell(new PdfPCell(new Paragraph("gender",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));       

          while(rs.next()){
              
           table.addCell(new PdfPCell(new Paragraph(rs.getString(1),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(2),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(3),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(4),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(5),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(6),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(7),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           
            }
           
           myDocument.add(table);
           myDocument.add(new Paragraph("--------------------------------------------------------------------------------------------"));
           myDocument.close();  
           JOptionPane.showMessageDialog(null,"Report was successfully generated");
            
     }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
         
         
     }
     finally {
            
            try{
                rs.close();
                pst.close();
                
            }
            catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
         
            }
     }
   }
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        SearchCustomer sc = new SearchCustomer();
        sc.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        AddMicroLoan aml = new AddMicroLoan();
        aml.setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        AddFixLoan afl = new AddFixLoan();
        afl.setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
       LoanDetails ld = new LoanDetails();
       ld.setVisible(true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        RepaymentDetails rd = new RepaymentDetails();
        rd.setVisible(true);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        RepaymentDetails rd = new RepaymentDetails();
        rd.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Repayment r = new Repayment();
        r.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        ProfitShare p = new ProfitShare();
        p.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        
            JFileChooser dialog = new JFileChooser();
            dialog.setSelectedFile(new File("fix-loan-repayment-report.pdf"));
            int dialogResult = dialog.showSaveDialog(null);
            if (dialogResult==JFileChooser.APPROVE_OPTION){
            String filePath = dialog.getSelectedFile().getPath();
           
        try {

            String sql = "SELECT fixloan.fixLoanId,"
                + "installementNo , payedAmount,payDate , customerdetails.id,customerdetails.name "
                + "FROM fixloanrepayment "
                + "INNER JOIN customerdetails ON (fixloanrepayment.customerId=customerdetails.id) "
                + "INNER JOIN fixloan ON (fixloanrepayment.fixLoanId=fixloan.fixLoanId)"
                + "WHERE fixloanrepayment.userId=?";
 
            pst=conn.prepareStatement(sql);
            pst.setString(1, User.userid);
            rs=pst.executeQuery();

            
           Document myDocument = new Document();
           PdfWriter myWriter = PdfWriter.getInstance(myDocument, new FileOutputStream(filePath ));
           PdfPTable table = new PdfPTable(6);
           myDocument.open();
           
           
           float[] columnWidths = new float[] {12,10,8,5,18,18};
           table.setWidths(columnWidths);

           table.setWidthPercentage(100); //set table width to 100%
           
          
          myDocument.add(new Paragraph("Fix Loan Repayment Report ",FontFactory.getFont(FontFactory.TIMES_BOLD,20,Font.BOLD )));
          myDocument.add(new Paragraph(new Date().toString()));
          myDocument.add(new Paragraph("-------------------------------------------------------------------------------------------"));
          table.addCell(new PdfPCell(new Paragraph("Fix Loan ID",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));       
          table.addCell(new PdfPCell(new Paragraph("Installement Number",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));       
          table.addCell(new PdfPCell(new Paragraph("Pay Amount",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));       
          table.addCell(new PdfPCell(new Paragraph("Pay Date",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
          table.addCell(new PdfPCell(new Paragraph("Customer ID",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
          table.addCell(new PdfPCell(new Paragraph("Customer Name",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
         
          
          while(rs.next()){
              
           table.addCell(new PdfPCell(new Paragraph(rs.getString(1),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(2),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(3),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(4),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(5),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(6),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
                 
            }
           
           myDocument.add(table);
           myDocument.add(new Paragraph("--------------------------------------------------------------------------------------------"));
           myDocument.close();  
           JOptionPane.showMessageDialog(null,"Report was successfully generated");
            
     }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);  
         
     }
     finally {
            
            try{
                rs.close();
                pst.close();
                
            }
            catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
         
            }
     }
    }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        AddCustomer ac = new AddCustomer();
        ac.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        Login l =  new Login();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        Audit a = new Audit();
        a.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        
            //fix loan report
            JFileChooser dialog = new JFileChooser();
            dialog.setSelectedFile(new File("fix-loan-report.pdf"));
            int dialogResult = dialog.showSaveDialog(null);
            if (dialogResult==JFileChooser.APPROVE_OPTION){
            String filePath = dialog.getSelectedFile().getPath();
           
        try {

            String sql = "SELECT fixLoanId,amountOfLoan,interestRate,installementAmount,issueDate"
                    + ",customerdetails.id,customerdetails.name "
                    + "FROM fixloan "
                    + "INNER JOIN customerdetails ON fixloan.customerId=customerdetails.id ";
 
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();

            
           Document myDocument = new Document();
           PdfWriter myWriter = PdfWriter.getInstance(myDocument, new FileOutputStream(filePath ));
           PdfPTable table = new PdfPTable(7);
           myDocument.open();
           
           
           float[] columnWidths = new float[] {8,12,8,11,9,8,15};
           table.setWidths(columnWidths);

           table.setWidthPercentage(100); //set table width to 100%
           
          
          myDocument.add(new Paragraph("Fix Loan Report",FontFactory.getFont(FontFactory.TIMES_BOLD,20,Font.BOLD )));
          myDocument.add(new Paragraph(new Date().toString()));
          myDocument.add(new Paragraph("-------------------------------------------------------------------------------------------"));
          table.addCell(new PdfPCell(new Paragraph("Fix Loan ID",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));      
          table.addCell(new PdfPCell(new Paragraph("Amount of Loan",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));       
          table.addCell(new PdfPCell(new Paragraph("Interest Rate",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));       
          table.addCell(new PdfPCell(new Paragraph("Installement Amount",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));       
          table.addCell(new PdfPCell(new Paragraph("Issue Date",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
          table.addCell(new PdfPCell(new Paragraph("Customer ID",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
          table.addCell(new PdfPCell(new Paragraph("Customer Name",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
          
          
          
          while(rs.next()){
              
           table.addCell(new PdfPCell(new Paragraph(rs.getString(1),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(2),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(3),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(4),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(5),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(6),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(7),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
                    
            }
           
           myDocument.add(table);
           myDocument.add(new Paragraph("--------------------------------------------------------------------------------------------"));
           myDocument.close();  
           JOptionPane.showMessageDialog(null,"Report was successfully generated");
            
     }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);  
         
     }
     finally {
            
            try{
                rs.close();
                pst.close();
                
            }
            catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
         
            }
     }
   }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        
            //daily micro loan repayment report
            JFileChooser dialog = new JFileChooser();
            dialog.setSelectedFile(new File("daily-micro-loan-repayment-report.pdf"));
            int dialogResult = dialog.showSaveDialog(null);
            if (dialogResult==JFileChooser.APPROVE_OPTION){
            String filePath = dialog.getSelectedFile().getPath();
           
        try {
            

            String sql = "SELECT microloan.microLoanId , microloan.numberOfInstallement,"
                + "installementNo , payedAmount , payDate, "
                + "customerdetails.id , customerdetails.name "
                + "FROM microloanrepayment "
                + "INNER JOIN customerdetails ON (microloanrepayment.customerId=customerdetails.id) "
                + "INNER JOIN microloan ON (microloanrepayment.microLoanId=microloan.microLoanId)"
                + "WHERE microloan.loanType = 'Daily' AND microloanrepayment.userId=?";
 
            pst=conn.prepareStatement(sql);
            pst.setString(1, User.userid);
            rs=pst.executeQuery();

            
           Document myDocument = new Document();
           PdfWriter myWriter = PdfWriter.getInstance(myDocument, new FileOutputStream(filePath ));
           PdfPTable table = new PdfPTable(7);
           myDocument.open();
           
           
           float[] columnWidths = new float[] {8,8,8,12,10,8,15};
           table.setWidths(columnWidths);

           table.setWidthPercentage(100); //set table width to 100%
           
          
          myDocument.add(new Paragraph("Daily Micro Loan Repayment Report ",FontFactory.getFont(FontFactory.TIMES_BOLD,20,Font.BOLD )));
          myDocument.add(new Paragraph(new Date().toString()));
          myDocument.add(new Paragraph("-------------------------------------------------------------------------------------------"));
          table.addCell(new PdfPCell(new Paragraph("Micro Loan ID",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));      
          table.addCell(new PdfPCell(new Paragraph("Number of Installement",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));       
          table.addCell(new PdfPCell(new Paragraph("Installement Number",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));       
          table.addCell(new PdfPCell(new Paragraph("Pay Amount",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));       
          table.addCell(new PdfPCell(new Paragraph("Pay Date",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
          table.addCell(new PdfPCell(new Paragraph("Customer ID",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
          table.addCell(new PdfPCell(new Paragraph("Customer Name",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
          
          
          
          while(rs.next()){
              
           table.addCell(new PdfPCell(new Paragraph(rs.getString(1),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(2),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(3),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(4),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(5),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(6),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(7),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
                  
            }
           
           myDocument.add(table);
           myDocument.add(new Paragraph("--------------------------------------------------------------------------------------------"));
           myDocument.close();  
           JOptionPane.showMessageDialog(null,"Report was successfully generated");
            
     }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);  
         
     }
     finally {
            
            try{
                rs.close();
                pst.close();
                
            }
            catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
         
            }
     }
    }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        
            //weekly micro loan repayment report
            JFileChooser dialog = new JFileChooser();
            dialog.setSelectedFile(new File("weekly-micro-loan-repayment-report.pdf"));
            int dialogResult = dialog.showSaveDialog(null);
            if (dialogResult==JFileChooser.APPROVE_OPTION){
            String filePath = dialog.getSelectedFile().getPath();
           
        try {
            

            String sql = "SELECT microloan.microLoanId , microloan.numberOfInstallement,"
                + "installementNo , payedAmount , payDate , customerdetails.id,customerdetails.name "
                + "FROM microloanrepayment "
                + "INNER JOIN customerdetails ON (microloanrepayment.customerId=customerdetails.id) "
                + "INNER JOIN microloan ON (microloanrepayment.microLoanId=microloan.microLoanId)"
                + "WHERE microloan.loanType = 'Weekly' AND microloanrepayment.userId=?";
 
            pst=conn.prepareStatement(sql);
            pst.setString(1, User.userid);
            rs=pst.executeQuery();

            
           Document myDocument = new Document();
           PdfWriter myWriter = PdfWriter.getInstance(myDocument, new FileOutputStream(filePath ));
           PdfPTable table = new PdfPTable(7);
           myDocument.open();
           
           
           float[] columnWidths = new float[] {8,8,8,12,10,8,15};
           table.setWidths(columnWidths);

           table.setWidthPercentage(100); //set table width to 100%
           
          
          myDocument.add(new Paragraph("Weekly Micro Loan Repayment Report ",FontFactory.getFont(FontFactory.TIMES_BOLD,20,Font.BOLD )));
          myDocument.add(new Paragraph(new Date().toString()));
          myDocument.add(new Paragraph("-------------------------------------------------------------------------------------------"));
          table.addCell(new PdfPCell(new Paragraph("Micro Loan ID",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));      
          table.addCell(new PdfPCell(new Paragraph("Number of Installement",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));       
          table.addCell(new PdfPCell(new Paragraph("Installement Number",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));       
          table.addCell(new PdfPCell(new Paragraph("Pay Amount",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));       
          table.addCell(new PdfPCell(new Paragraph("Pay Date",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
          table.addCell(new PdfPCell(new Paragraph("Customer ID",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
          table.addCell(new PdfPCell(new Paragraph("Customer Name",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
          
          
          
          while(rs.next()){
              
           table.addCell(new PdfPCell(new Paragraph(rs.getString(1),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(2),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(3),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(4),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(5),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(6),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(7),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
                  
            }
           
           myDocument.add(table);
           myDocument.add(new Paragraph("--------------------------------------------------------------------------------------------"));
           myDocument.close();  
           JOptionPane.showMessageDialog(null,"Report was successfully generated");
            
     }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);  
         
     }
     finally {
            
            try{
                rs.close();
                pst.close();
                
            }
            catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
         
            }
     }
    }
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        
            //monthly micro loan repayment report
            JFileChooser dialog = new JFileChooser();
            dialog.setSelectedFile(new File("monthly-micro-loan-repayment-report.pdf"));
            int dialogResult = dialog.showSaveDialog(null);
            if (dialogResult==JFileChooser.APPROVE_OPTION){
            String filePath = dialog.getSelectedFile().getPath();
           
        try {
            

            String sql = "SELECT microloan.microLoanId,microloan.numberOfInstallement,"
                + "installementNo,payedAmount,payDate ,customerdetails.id , customerdetails.name "
                + "FROM microloanrepayment "
                + "INNER JOIN customerdetails ON (microloanrepayment.customerId=customerdetails.id) "
                + "INNER JOIN microloan ON (microloanrepayment.microLoanId=microloan.microLoanId)"
                + "WHERE microloan.loanType = 'Monthly' AND microloanrepayment.userId=?";
 
            pst=conn.prepareStatement(sql);
            pst.setString(1, User.userid);
            rs=pst.executeQuery();

            
           Document myDocument = new Document();
           PdfWriter myWriter = PdfWriter.getInstance(myDocument, new FileOutputStream(filePath ));
           PdfPTable table = new PdfPTable(7);
           myDocument.open();
           
           
           float[] columnWidths = new float[] {8,8,8,12,10,8,15};
           table.setWidths(columnWidths);

           table.setWidthPercentage(100); //set table width to 100%
           
          
          myDocument.add(new Paragraph("Monthly Micro Loan Repayment Report ",FontFactory.getFont(FontFactory.TIMES_BOLD,20,Font.BOLD )));
          myDocument.add(new Paragraph(new Date().toString()));
          myDocument.add(new Paragraph("-------------------------------------------------------------------------------------------"));
          table.addCell(new PdfPCell(new Paragraph("Micro Loan ID",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));      
          table.addCell(new PdfPCell(new Paragraph("Number of Installement",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));       
          table.addCell(new PdfPCell(new Paragraph("Installement Number",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));       
          table.addCell(new PdfPCell(new Paragraph("Pay Amount",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));       
          table.addCell(new PdfPCell(new Paragraph("Pay Date",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
          table.addCell(new PdfPCell(new Paragraph("Customer ID",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
          table.addCell(new PdfPCell(new Paragraph("Customer Name",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
          
          
          
          while(rs.next()){
              
           table.addCell(new PdfPCell(new Paragraph(rs.getString(1),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(2),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(3),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(4),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(5),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(6),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(7),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
                  
            }
           
           myDocument.add(table);
           myDocument.add(new Paragraph("--------------------------------------------------------------------------------------------"));
           myDocument.close();  
           JOptionPane.showMessageDialog(null,"Report was successfully generated");
            
     }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);  
         
     }
     finally {
            
            try{
                rs.close();
                pst.close();
                
            }
            catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
         
            }
     }
    }
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        
            //daily micro loan report
            JFileChooser dialog = new JFileChooser();
            dialog.setSelectedFile(new File("daily-micro-loan-report.pdf"));
            int dialogResult = dialog.showSaveDialog(null);
            if (dialogResult==JFileChooser.APPROVE_OPTION){
            String filePath = dialog.getSelectedFile().getPath();
           
        try {

            String sql = "SELECT microLoanId,amountOfLoan,interestRate,numberOfInstallement,loanType,"
                    + "installementAmount,issueDate,dueDate,customerdetails.id,customerdetails.name "
                    + "FROM microloan "
                    + "INNER JOIN customerdetails ON (microloan.customerId=customerdetails.id) "
                    + "WHERE loanType='Daily' and microloan.userId=?";
 
            pst=conn.prepareStatement(sql);
            pst.setString(1, User.userid);
            rs=pst.executeQuery();

            
           Document myDocument = new Document();
           PdfWriter myWriter = PdfWriter.getInstance(myDocument, new FileOutputStream(filePath ));
           PdfPTable table = new PdfPTable(10);
           myDocument.open();
           
           
           float[] columnWidths = new float[] {8,12,8,10,8,11,9,9,8,15};
           table.setWidths(columnWidths);

           table.setWidthPercentage(100); //set table width to 100%
           
          
          myDocument.add(new Paragraph("Daily Micro Loan Report",FontFactory.getFont(FontFactory.TIMES_BOLD,20,Font.BOLD )));
          myDocument.add(new Paragraph(new Date().toString()));
          myDocument.add(new Paragraph("-------------------------------------------------------------------------------------------"));
          table.addCell(new PdfPCell(new Paragraph("Micro Loan ID",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));      
          table.addCell(new PdfPCell(new Paragraph("Amount of Loan",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));       
          table.addCell(new PdfPCell(new Paragraph("Interest Rate",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));       
          table.addCell(new PdfPCell(new Paragraph("Number of Installement",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));       
          table.addCell(new PdfPCell(new Paragraph("Loan Type",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));       
          table.addCell(new PdfPCell(new Paragraph("Installement Amount",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));       
          table.addCell(new PdfPCell(new Paragraph("Issue Date",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
          table.addCell(new PdfPCell(new Paragraph("Due Date",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
          table.addCell(new PdfPCell(new Paragraph("Customer ID",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
          table.addCell(new PdfPCell(new Paragraph("Customer Name",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
          
          
          
          while(rs.next()){
              
           table.addCell(new PdfPCell(new Paragraph(rs.getString(1),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(2),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(3),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(4),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(5),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(6),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(7),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(8),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(9),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(10),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
                    
            }
           
           myDocument.add(table);
           myDocument.add(new Paragraph("--------------------------------------------------------------------------------------------"));
           myDocument.close();  
           JOptionPane.showMessageDialog(null,"Report was successfully generated");
            
     }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);  
         
     }
     finally {
            
            try{
                rs.close();
                pst.close();
                
            }
            catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
         
            }
     }
    }
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
        
            //weekly micro loan report
            JFileChooser dialog = new JFileChooser();
            dialog.setSelectedFile(new File("weekly-micro-loan-report.pdf"));
            int dialogResult = dialog.showSaveDialog(null);
            if (dialogResult==JFileChooser.APPROVE_OPTION){
            String filePath = dialog.getSelectedFile().getPath();
           
        try {

            String sql = "SELECT microLoanId,amountOfLoan,interestRate,numberOfInstallement,loanType,"
                    + "installementAmount,issueDate,dueDate,customerdetails.id,customerdetails.name "
                    + "FROM microloan "
                    + "INNER JOIN customerdetails ON (microloan.customerId=customerdetails.id) "
                    + "WHERE loanType='Weekly' and microloan.userId=?";
 
            pst=conn.prepareStatement(sql);
            pst.setString(1, User.userid);
            rs=pst.executeQuery();

            
           Document myDocument = new Document();
           PdfWriter myWriter = PdfWriter.getInstance(myDocument, new FileOutputStream(filePath ));
           PdfPTable table = new PdfPTable(10);
           myDocument.open();
           
           
           float[] columnWidths = new float[] {8,12,8,10,8,11,9,9,8,15};
           table.setWidths(columnWidths);

           table.setWidthPercentage(100); //set table width to 100%
           
          
          myDocument.add(new Paragraph("Weekly Micro Loan Report",FontFactory.getFont(FontFactory.TIMES_BOLD,20,Font.BOLD )));
          myDocument.add(new Paragraph(new Date().toString()));
          myDocument.add(new Paragraph("-------------------------------------------------------------------------------------------"));
          table.addCell(new PdfPCell(new Paragraph("Micro Loan ID",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));      
          table.addCell(new PdfPCell(new Paragraph("Amount of Loan",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));       
          table.addCell(new PdfPCell(new Paragraph("Interest Rate",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));       
          table.addCell(new PdfPCell(new Paragraph("Number of Installement",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));       
          table.addCell(new PdfPCell(new Paragraph("Loan Type",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));       
          table.addCell(new PdfPCell(new Paragraph("Installement Amount",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));       
          table.addCell(new PdfPCell(new Paragraph("Issue Date",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
          table.addCell(new PdfPCell(new Paragraph("Due Date",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
          table.addCell(new PdfPCell(new Paragraph("Customer Id",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
          table.addCell(new PdfPCell(new Paragraph("Customer Name",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
          
          
          while(rs.next()){
              
           table.addCell(new PdfPCell(new Paragraph(rs.getString(1),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(2),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(3),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(4),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(5),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(6),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(7),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(8),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(9),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(10),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
                    
            }
           
           myDocument.add(table);
           myDocument.add(new Paragraph("--------------------------------------------------------------------------------------------"));
           myDocument.close();  
           JOptionPane.showMessageDialog(null,"Report was successfully generated");
            
     }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);  
         
     }
     finally {
            
            try{
                rs.close();
                pst.close();
                
            }
            catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
         
            }
     }
    }
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
        
            //monthly micro loan report
            JFileChooser dialog = new JFileChooser();
            dialog.setSelectedFile(new File("monthly-micro-loan-report.pdf"));
            int dialogResult = dialog.showSaveDialog(null);
            if (dialogResult==JFileChooser.APPROVE_OPTION){
            String filePath = dialog.getSelectedFile().getPath();
           
        try {

            String sql = "SELECT microLoanId,amountOfLoan,interestRate,numberOfInstallement,loanType,"
                    + "installementAmount,issueDate,dueDate,customerdetails.id,customerdetails.name,"
                    + "customerdetails.nic,customerdetails.address,customerdetails.resistance,"
                    + "customerdetails.contactNo,customerdetails.gender FROM microloan "
                    + "INNER JOIN customerdetails ON (microloan.customerId=customerdetails.id) "
                    + "WHERE loanType='Monthly' and microloan.userId=? ";
 
            pst=conn.prepareStatement(sql);
            pst.setString(1 , User.userid);
            rs=pst.executeQuery();

            
           Document myDocument = new Document();
           PdfWriter myWriter = PdfWriter.getInstance(myDocument, new FileOutputStream(filePath ));
           PdfPTable table = new PdfPTable(10);
           myDocument.open();
           
           
           float[] columnWidths = new float[] {8,12,8,10,8,11,9,9,8,15};
           table.setWidths(columnWidths);

           table.setWidthPercentage(100); //set table width to 100%
           
          
          myDocument.add(new Paragraph("Monthly Micro Loan Report",FontFactory.getFont(FontFactory.TIMES_BOLD,20,Font.BOLD )));
          myDocument.add(new Paragraph(new Date().toString()));
          myDocument.add(new Paragraph("-------------------------------------------------------------------------------------------"));
          table.addCell(new PdfPCell(new Paragraph("Micro Loan ID",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));      
          table.addCell(new PdfPCell(new Paragraph("Amount of Loan",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));       
          table.addCell(new PdfPCell(new Paragraph("Interest Rate",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));       
          table.addCell(new PdfPCell(new Paragraph("Number of Installement",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));       
          table.addCell(new PdfPCell(new Paragraph("Loan Type",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));       
          table.addCell(new PdfPCell(new Paragraph("Installement Amount",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));       
          table.addCell(new PdfPCell(new Paragraph("Issue Date",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
          table.addCell(new PdfPCell(new Paragraph("Due Date",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
          table.addCell(new PdfPCell(new Paragraph("Customer Id",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));          
          table.addCell(new PdfPCell(new Paragraph("Customer Name",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));          
          
          while(rs.next()){
              
           table.addCell(new PdfPCell(new Paragraph(rs.getString(1),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(2),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(3),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(4),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(5),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(6),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(7),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(8),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(9),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
           table.addCell(new PdfPCell(new Paragraph(rs.getString(10),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));

                    
            }
           
           myDocument.add(table);
           myDocument.add(new Paragraph("--------------------------------------------------------------------------------------------"));
           myDocument.close();  
           JOptionPane.showMessageDialog(null,"Report was successfully generated");
            
     }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);  
         
     }
     finally {
            
            try{
                rs.close();
                pst.close();
                
            }
            catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
         
            }
     }
    }
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        
        FinishedLoans fl = new FinishedLoans();
        fl.setVisible(true);
    
/*        fl.setVisible(true);
        fl.pack();
        fl.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        String sql ="SELECT microLoanId,amountOfLoan,interestRate,numberOfInstallement,loanType,installementAmount,"
                + "issueDate,dueDate "
                + "FROM microloan "
                + "WHERE is_deleted = 1 ";
        
        try{
            
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            fl.jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
       }
        
        */
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        About a = new About();
        a.setVisible(true);
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                /*if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }*/
                
                Properties props = new Properties();
                props.put("logoString", "");
                AcrylLookAndFeel.setCurrentTheme(props);
                
                UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");

            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/loan.png")));
    }
}
