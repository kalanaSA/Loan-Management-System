package lms;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

public class FinishedLoans extends javax.swing.JFrame {
    
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    
    User numberOnly = new User();
    
  
    public FinishedLoans() {
        super("Finished Loans");
        initComponents();
        conn = DBconnect.connect();
        setIcon();
        
        finishedDailyMicroLoanTable();
        finishedWeeklyMicroLoanTable();
        finishedMonthlyMicroLoanTable();
        finishedFixLoanTable();
        
    }
    

    public void finishedDailyMicroLoanTable(){
        
        String sql ="SELECT microLoanId,amountOfLoan,interestRate,numberOfInstallement,loanType,installementAmount,"
                + "issueDate,dueDate,customerId,customerdetails.name "
                + "FROM microloan "
                + "INNER JOIN customerdetails ON (microloan.customerId=customerdetails.id) "
                + "WHERE microloan.loanType='Daily' AND microloan.is_deleted=1 ";
        
        try{
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    public void finishedWeeklyMicroLoanTable(){
        
        String sql ="SELECT microLoanId,amountOfLoan,interestRate,numberOfInstallement,loanType,installementAmount,"
                + "issueDate,dueDate,customerId,customerdetails.name "
                + "FROM microloan "
                + "INNER JOIN customerdetails ON (microloan.customerId=customerdetails.id) "
                + "WHERE microloan.loanType='Weekly' AND microloan.is_deleted=1 ";
        
        try{
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            jTable3.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    public void finishedMonthlyMicroLoanTable(){
        
        String sql ="SELECT microLoanId,amountOfLoan,interestRate,numberOfInstallement,loanType,installementAmount,"
                + "issueDate,dueDate,customerId,customerdetails.name "
                + "FROM microloan "
                + "INNER JOIN customerdetails ON (microloan.customerId=customerdetails.id) "
                + "WHERE microloan.loanType='Monthly' AND microloan.is_deleted=1 ";
        
        try{
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            jTable4.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    public void finishedFixLoanTable(){
        
        String sql ="SELECT fixLoanId,amountOfLoan,interestRate,installementAmount,"
                + "issueDate,customerId,customerdetails.name "
                + "FROM fixloan "
                + "INNER JOIN customerdetails ON (fixloan.customerId=customerdetails.id) "
                + "WHERE fixloan.is_deleted=1 ";
        
        try{
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            jTable2.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    //object for FinishedLoansPop
    FinishedLoansPop flp = new FinishedLoansPop();
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable1MouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Search Name : ");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Search Loan ID : ");

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1314, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Finished Daily Micro-Loans", jPanel1);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable3);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Search Name : ");

        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField5KeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Search Loan ID : ");

        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField6KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField6KeyTyped(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton3.setText("Refresh");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1314, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Finished Weekly Micro-Loans", jPanel3);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTable4);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Search Name : ");

        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField7KeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Search Loan ID : ");

        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField8KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField8KeyTyped(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton4.setText("Refresh");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1314, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Finished Monthly Micro-Loans", jPanel4);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Search Name : ");

        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Search Loan ID : ");

        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField4KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField4KeyTyped(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setText("Refresh");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1314, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Finished Fix-Loans", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        setSize(new java.awt.Dimension(1335, 693));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
        int r = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        
        String loanid = model.getValueAt(r, 0).toString();
        String amountOfLoan = model.getValueAt(r, 1).toString();
        String interestRate = model.getValueAt(r, 2).toString();
        String noOfInstallement = model.getValueAt(r, 3).toString();
        String loanType = model.getValueAt(r, 4).toString();
//      String installementAmount = model.getValueAt(r, 5).toString();
//      String issueDate = model.getValueAt(r, 6).toString();
//      String dueDate = model.getValueAt(r, 7).toString();
        String customerId = model.getValueAt(r, 8).toString();
        String customerName = model.getValueAt(r, 9).toString();
        
        flp.setVisible(true);
        flp.pack();
        flp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        try{
            String sql = "SELECT installementNo AS Installement_Number , remainingInstallement AS Remaining_Installements, "
                + "microloan.installementAmount AS Installement_Amount , payedAmount AS Payed_Amount,"
                + "payDate AS Pay_Date , remainingAmountOfLoan AS Remaining_Amount "
                + "FROM microloanrepayment "
                + "INNER JOIN customerdetails ON (microloanrepayment.customerId=customerdetails.id) "
                + "INNER JOIN microloan ON (microloanrepayment.microLoanId=microloan.microLoanId)"
                + "WHERE microloan.microLoanId=? AND microloan.loanType='Daily' AND microloanrepayment.userId=? "
                + "AND microloanrepayment.is_deleted=1 ";
 
            pst=conn.prepareStatement(sql);
            pst.setString(1, loanid);
            pst.setString(2, User.userid);
            rs=pst.executeQuery();
            
            flp.FinishedLoansPopjTable.setModel(DbUtils.resultSetToTableModel(rs));
            flp.jLabel1.setText("Micro Loan ID :");
            flp.jLabel8.setText(loanid);
            flp.jLabel9.setText(amountOfLoan);
            flp.jLabel10.setText(interestRate);
            flp.jLabel11.setText(noOfInstallement);
            flp.jLabel12.setText(loanType);
            flp.jLabel13.setText(customerId);
            flp.jLabel14.setText(customerName);

            
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }finally{
            try{
                rs.close();
                pst.close();
            }catch(Exception e){
                
            }
        }  
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        
        int r = jTable2.getSelectedRow();
        TableModel model = jTable2.getModel();
        
        String loanid = model.getValueAt(r, 0).toString();
        String amountOfLoan = model.getValueAt(r, 1).toString();
        String interestRate = model.getValueAt(r, 2).toString();
//        String noOfInstallement = model.getValueAt(r, 3).toString();
//        String loanType = model.getValueAt(r, 4).toString();
//        String installementAmount = model.getValueAt(r, 3).toString();
//      String issueDate = model.getValueAt(r, 6).toString();
//      String dueDate = model.getValueAt(r, 7).toString();
        String customerId = model.getValueAt(r, 5).toString();
        String customerName = model.getValueAt(r, 6).toString();
        
        flp.setVisible(true);
        flp.pack();
        flp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        try{
            String sql = "SELECT installementNo AS Installement_Number, fixloan.installementAmount AS Installement_Amount , "
                + "payedAmount AS Payed_Amount , payDate "
                + "FROM fixloanrepayment "
                + "INNER JOIN customerdetails ON (fixloanrepayment.customerId=customerdetails.id) "
                + "INNER JOIN fixloan ON (fixloanrepayment.fixLoanId=fixloan.fixLoanId)"
                + "WHERE fixloan.fixLoanId=? AND fixloanrepayment.userId=? AND fixloanrepayment.is_deleted=1 ";
 
            pst=conn.prepareStatement(sql);
            pst.setString(1, loanid);
            pst.setString(2, User.userid);
            rs=pst.executeQuery();
            
            flp.FinishedLoansPopjTable.setModel(DbUtils.resultSetToTableModel(rs));
            flp.jLabel8.setText(loanid);
            flp.jLabel9.setText(amountOfLoan);
            flp.jLabel10.setText(interestRate);
            flp.jLabel11.setVisible(false);
            flp.jLabel12.setVisible(false);
            flp.jLabel4.setVisible(false);
            flp.jLabel5.setVisible(false);
            flp.jLabel1.setText("Fix Loan ID :");
            flp.jLabel13.setText(customerId);
            flp.jLabel14.setText(customerName);

            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }finally{
            try{
                rs.close();
                pst.close();
            }catch(Exception e){
                
            }
        }
        
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        
        jTextField2.setText("");
        
        String sql = "SELECT microLoanId AS Micro_Loan_ID , amountOfLoan AS Amount_of_Loan,"
                    + "interestRate AS Interest_Rate , numberOfInstallement AS No_of_Installement , loanType AS Loan_Type,"
                    + "installementAmount AS Installement_Amount ,issueDate AS Issue_Date , dueDate AS Due_Date ,"
                    + "customerdetails.id AS Customer_ID,customerdetails.name AS Customer_Name "
                    + "FROM microloan "
                    + "INNER JOIN customerdetails ON (microloan.customerId=customerdetails.id) "
                    + "WHERE name=? AND microloan.loanType= 'Daily' AND microloan.userId=? AND microloan.is_deleted=1 ";
                    
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1 , jTextField1.getText());
            pst.setString(2 , User.userid);
            rs = pst.executeQuery();
            
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }finally{
            try{
                rs.close();
                pst.close();
            }catch(Exception e){
                
            }
        }
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased

        jTextField1.setText("");
        
        String sql = "SELECT microLoanId AS Micro_Loan_ID , amountOfLoan AS Amount_of_Loan,"
                    + "interestRate AS Interest_Rate , numberOfInstallement AS No_of_Installement , loanType AS Loan_Type,"
                    + "installementAmount AS Installement_Amount ,issueDate AS Issue_Date , dueDate AS Due_Date ,"
                    + "customerdetails.id AS Customer_ID,customerdetails.name AS Customer_Name "
                    + "FROM microloan "
                    + "INNER JOIN customerdetails ON (microloan.customerId=customerdetails.id) "
                    + "WHERE microLoanId=? AND microloan.loanType='Daily' AND microloan.userId=? AND microloan.is_deleted=1 ";
                    
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1 , jTextField2.getText());
            pst.setString(2 , User.userid);
            rs = pst.executeQuery();
            
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }finally{
            try{
                rs.close();
                pst.close();
            }catch(Exception e){
                
            }
        }
        
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased

        jTextField4.setText("");
        
        String sql = "SELECT fixLoanId AS Fix_Loan_ID , amountOfLoan AS Amount_of_Loan , interestRate AS Interest_Rate,"
        + "installementAmount AS Installement_Amount , issueDate AS Issue_Date,"
        + "customerdetails.id AS Customer_ID , customerdetails.name AS Customer_Name "
        + "FROM fixloan "
        + "INNER JOIN customerdetails ON (fixloan.customerId=customerdetails.id) "
        + "WHERE name=? and fixloan.userId=? AND fixloan.is_deleted=1 ";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1 , jTextField3.getText());
            pst.setString(2 , User.userid);
            rs = pst.executeQuery();

            jTable2.setModel(DbUtils.resultSetToTableModel(rs));

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }finally{
            try{
                rs.close();
                pst.close();
            }catch(Exception e){

            }
        }
    }//GEN-LAST:event_jTextField3KeyReleased

    private void jTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyReleased

        jTextField3.setText("");
        
        String sql = "SELECT fixLoanId AS Fix_Loan_ID , amountOfLoan AS Amount_of_Loan , interestRate AS Interest_Rate,"
        + "installementAmount AS Installement_Amount , issueDate AS Issue_Date,"
        + "customerdetails.id AS Customer_ID , customerdetails.name AS Customer_Name "
        + "FROM fixloan "
        + "INNER JOIN customerdetails ON (fixloan.customerId=customerdetails.id) "
        + "WHERE fixLoanId=? and fixloan.userId=? AND fixloan.is_deleted=1 ";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1 , jTextField4.getText());
            pst.setString(2 , User.userid);
            rs = pst.executeQuery();

            jTable2.setModel(DbUtils.resultSetToTableModel(rs));

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }finally{
            try{
                rs.close();
                pst.close();
            }catch(Exception e){

            }
        }
    }//GEN-LAST:event_jTextField4KeyReleased

    private void jTextField4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyTyped
        
        try{
            numberOnly.NumbersOnly(evt);
        
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "loan System Error");
        }
    }//GEN-LAST:event_jTextField4KeyTyped

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        
        try{
            numberOnly.NumbersOnly(evt);
        
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "loan System Error");
        }
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        jTextField3.setText("");
        jTextField4.setText("");
        finishedFixLoanTable();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        jTextField1.setText("");
        jTextField2.setText("");
        finishedDailyMicroLoanTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        
        int r = jTable3.getSelectedRow();
        TableModel model = jTable3.getModel();
        
        String loanid = model.getValueAt(r, 0).toString();
        String amountOfLoan = model.getValueAt(r, 1).toString();
        String interestRate = model.getValueAt(r, 2).toString();
        String noOfInstallement = model.getValueAt(r, 3).toString();
        String loanType = model.getValueAt(r, 4).toString();
//      String installementAmount = model.getValueAt(r, 5).toString();
//      String issueDate = model.getValueAt(r, 6).toString();
//      String dueDate = model.getValueAt(r, 7).toString();
        String customerId = model.getValueAt(r, 8).toString();
        String customerName = model.getValueAt(r, 9).toString();
        
        flp.setVisible(true);
        flp.pack();
        flp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        try{
            String sql = "SELECT installementNo AS Installement_Number , remainingInstallement AS Remaining_Installements, "
                + "microloan.installementAmount AS Installement_Amount , payedAmount AS Payed_Amount,"
                + "payDate AS Pay_Date , remainingAmountOfLoan AS Remaining_Amount "
                + "FROM microloanrepayment "
                + "INNER JOIN customerdetails ON (microloanrepayment.customerId=customerdetails.id) "
                + "INNER JOIN microloan ON (microloanrepayment.microLoanId=microloan.microLoanId)"
                + "WHERE microloan.microLoanId=? AND microloan.loanType='Weekly' AND microloanrepayment.userId=? "
                + "AND microloanrepayment.is_deleted=1 ";
 
            pst=conn.prepareStatement(sql);
            pst.setString(1, loanid);
            pst.setString(2, User.userid);
            rs=pst.executeQuery();
            
            flp.FinishedLoansPopjTable.setModel(DbUtils.resultSetToTableModel(rs));
            flp.jLabel1.setText("Micro Loan ID :");
            flp.jLabel8.setText(loanid);
            flp.jLabel9.setText(amountOfLoan);
            flp.jLabel10.setText(interestRate);
            flp.jLabel11.setText(noOfInstallement);
            flp.jLabel12.setText(loanType);
            flp.jLabel13.setText(customerId);
            flp.jLabel14.setText(customerName);

            
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }finally{
            try{
                rs.close();
                pst.close();
            }catch(Exception e){
                
            }
        }  
    }//GEN-LAST:event_jTable3MouseClicked

    private void jTextField5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyReleased
        
        jTextField6.setText("");
        
        String sql = "SELECT microLoanId AS Micro_Loan_ID , amountOfLoan AS Amount_of_Loan,"
                    + "interestRate AS Interest_Rate , numberOfInstallement AS No_of_Installement , loanType AS Loan_Type,"
                    + "installementAmount AS Installement_Amount ,issueDate AS Issue_Date , dueDate AS Due_Date ,"
                    + "customerdetails.id AS Customer_ID,customerdetails.name AS Customer_Name "
                    + "FROM microloan "
                    + "INNER JOIN customerdetails ON (microloan.customerId=customerdetails.id) "
                    + "WHERE name=? AND microloan.loanType= 'Weekly' AND microloan.userId=? AND microloan.is_deleted=1 ";
                    
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1 , jTextField5.getText());
            pst.setString(2 , User.userid);
            rs = pst.executeQuery();
            
            jTable3.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }finally{
            try{
                rs.close();
                pst.close();
            }catch(Exception e){
                
            }
        }
    }//GEN-LAST:event_jTextField5KeyReleased

    private void jTextField6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyReleased
        
        jTextField5.setText("");
        
        String sql = "SELECT microLoanId AS Micro_Loan_ID , amountOfLoan AS Amount_of_Loan,"
                    + "interestRate AS Interest_Rate , numberOfInstallement AS No_of_Installement , loanType AS Loan_Type,"
                    + "installementAmount AS Installement_Amount ,issueDate AS Issue_Date , dueDate AS Due_Date ,"
                    + "customerdetails.id AS Customer_ID,customerdetails.name AS Customer_Name "
                    + "FROM microloan "
                    + "INNER JOIN customerdetails ON (microloan.customerId=customerdetails.id) "
                    + "WHERE microLoanId=? AND microloan.loanType='Weekly' AND microloan.userId=? AND microloan.is_deleted=1 ";
                    
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1 , jTextField6.getText());
            pst.setString(2 , User.userid);
            rs = pst.executeQuery();
            
            jTable3.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }finally{
            try{
                rs.close();
                pst.close();
            }catch(Exception e){
                
            }
        }
    }//GEN-LAST:event_jTextField6KeyReleased

    private void jTextField6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6KeyTyped

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        jTextField5.setText("");
        jTextField6.setText("");
        finishedWeeklyMicroLoanTable();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
       
        int r = jTable4.getSelectedRow();
        TableModel model = jTable4.getModel();
        
        String loanid = model.getValueAt(r, 0).toString();
        String amountOfLoan = model.getValueAt(r, 1).toString();
        String interestRate = model.getValueAt(r, 2).toString();
        String noOfInstallement = model.getValueAt(r, 3).toString();
        String loanType = model.getValueAt(r, 4).toString();
//      String installementAmount = model.getValueAt(r, 5).toString();
//      String issueDate = model.getValueAt(r, 6).toString();
//      String dueDate = model.getValueAt(r, 7).toString();
        String customerId = model.getValueAt(r, 8).toString();
        String customerName = model.getValueAt(r, 9).toString();
        
        flp.setVisible(true);
        flp.pack();
        flp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        try{
            String sql = "SELECT installementNo AS Installement_Number , remainingInstallement AS Remaining_Installements, "
                + "microloan.installementAmount AS Installement_Amount , payedAmount AS Payed_Amount,"
                + "payDate AS Pay_Date , remainingAmountOfLoan AS Remaining_Amount "
                + "FROM microloanrepayment "
                + "INNER JOIN customerdetails ON (microloanrepayment.customerId=customerdetails.id) "
                + "INNER JOIN microloan ON (microloanrepayment.microLoanId=microloan.microLoanId)"
                + "WHERE microloan.microLoanId=? AND microloan.loanType='Monthly' AND microloanrepayment.userId=? "
                + "AND microloanrepayment.is_deleted=1 ";
 
            pst=conn.prepareStatement(sql);
            pst.setString(1, loanid);
            pst.setString(2, User.userid);
            rs=pst.executeQuery();
            
            flp.FinishedLoansPopjTable.setModel(DbUtils.resultSetToTableModel(rs));
            flp.jLabel1.setText("Micro Loan ID :");
            flp.jLabel8.setText(loanid);
            flp.jLabel9.setText(amountOfLoan);
            flp.jLabel10.setText(interestRate);
            flp.jLabel11.setText(noOfInstallement);
            flp.jLabel12.setText(loanType);
            flp.jLabel13.setText(customerId);
            flp.jLabel14.setText(customerName);

            
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }finally{
            try{
                rs.close();
                pst.close();
            }catch(Exception e){
                
            }
        }  
    }//GEN-LAST:event_jTable4MouseClicked

    private void jTextField7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyReleased
        
        jTextField8.setText("");
        
        String sql = "SELECT microLoanId AS Micro_Loan_ID , amountOfLoan AS Amount_of_Loan,"
                    + "interestRate AS Interest_Rate , numberOfInstallement AS No_of_Installement , loanType AS Loan_Type,"
                    + "installementAmount AS Installement_Amount ,issueDate AS Issue_Date , dueDate AS Due_Date ,"
                    + "customerdetails.id AS Customer_ID,customerdetails.name AS Customer_Name "
                    + "FROM microloan "
                    + "INNER JOIN customerdetails ON (microloan.customerId=customerdetails.id) "
                    + "WHERE name=? AND microloan.loanType= 'Monthly' AND microloan.userId=? AND microloan.is_deleted=1 ";
                    
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1 , jTextField7.getText());
            pst.setString(2 , User.userid);
            rs = pst.executeQuery();
            
            jTable4.setModel(DbUtils.resultSetToTableModel(rs));

            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }finally{
            try{
                rs.close();
                pst.close();
            }catch(Exception e){
                
            }
        }
    }//GEN-LAST:event_jTextField7KeyReleased

    private void jTextField8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyReleased
        
        jTextField7.setText("");
        
        String sql = "SELECT microLoanId AS Micro_Loan_ID , amountOfLoan AS Amount_of_Loan,"
                    + "interestRate AS Interest_Rate , numberOfInstallement AS No_of_Installement , loanType AS Loan_Type,"
                    + "installementAmount AS Installement_Amount ,issueDate AS Issue_Date , dueDate AS Due_Date ,"
                    + "customerdetails.id AS Customer_ID,customerdetails.name AS Customer_Name "
                    + "FROM microloan "
                    + "INNER JOIN customerdetails ON (microloan.customerId=customerdetails.id) "
                    + "WHERE microLoanId=? AND microloan.loanType='Monthly' AND microloan.userId=? AND microloan.is_deleted=1 ";
                    
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1 , jTextField8.getText());
            pst.setString(2 , User.userid);
            rs = pst.executeQuery();
            
            jTable4.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }finally{
            try{
                rs.close();
                pst.close();
            }catch(Exception e){
                
            }
        }
    }//GEN-LAST:event_jTextField8KeyReleased

    private void jTextField8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8KeyTyped

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        jTextField7.setText("");
        jTextField8.setText("");
        finishedMonthlyMicroLoanTable();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseEntered

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
                UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FinishedLoans.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FinishedLoans.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FinishedLoans.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FinishedLoans.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FinishedLoans().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
    
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/loan.png")));
    }

}
