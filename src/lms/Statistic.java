package lms;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import net.proteanit.sql.DbUtils;

public class Statistic extends javax.swing.JFrame {
    
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;

    public Statistic() {
        initComponents();
        conn = DBconnect.connect();
        setIcon();
        
        microLoanDailyTable();
        microLoanMonthlyTable();
        microLoanAnnuallyTable();
        fixLoanTable();
                
    }

    public void microLoanDailyTable(){
        
        try{
            String sql = "SELECT microLoanId,amountOfLoan,interestRate,numberOfInstallement,loanType,"
                    + "installementAmount,issueDate,dueDate,customerdetails.id,customerdetails.name,"
                    + "customerdetails.nic,customerdetails.address,customerdetails.resistance,"
                    + "customerdetails.contactNo,customerdetails.gender FROM microloan "
                    + "INNER JOIN customerdetails ON microloan.customerId=customerdetails.id WHERE loanType='Daily' ";
            
            pst = conn.prepareStatement(sql);
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
  
    }
    
    public void microLoanMonthlyTable(){
        
        try{
            String sql = "SELECT microLoanId,amountOfLoan,interestRate,numberOfInstallement,loanType,"
                    + "installementAmount,issueDate,dueDate,customerdetails.id,customerdetails.name,"
                    + "customerdetails.nic,customerdetails.address,customerdetails.resistance,"
                    + "customerdetails.contactNo,customerdetails.gender FROM microloan "
                    + "INNER JOIN customerdetails ON microloan.customerId=customerdetails.id WHERE loanType='Monthly' ";
            
            pst = conn.prepareStatement(sql);
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
  
    }
       
    public void microLoanAnnuallyTable(){
        
        try{
            String sql = "SELECT microLoanId,amountOfLoan,interestRate,numberOfInstallement,loanType,"
                    + "installementAmount,issueDate,dueDate,customerdetails.id,customerdetails.name,"
                    + "customerdetails.nic,customerdetails.address,customerdetails.resistance,"
                    + "customerdetails.contactNo,customerdetails.gender FROM microloan "
                    + "INNER JOIN customerdetails ON microloan.customerId=customerdetails.id WHERE loanType='Annually' ";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            jTable5.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }finally{
            try{
                rs.close();
                pst.close();
            }catch(Exception e){
                
            }
        }
  
    }
    
        public void fixLoanTable(){
        
        try{
            String sql = "SELECT fixLoanId,amountOfLoan,interestRate,installementAmount,issueDate"
                    + ",customerdetails.id,customerdetails.name,"
                    + "customerdetails.nic,customerdetails.address,customerdetails.resistance,"
                    + "customerdetails.contactNo,customerdetails.gender FROM fixloan "
                    + "INNER JOIN customerdetails ON fixloan.customerId=customerdetails.id ";
            
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            jTable6.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }finally{
            try{
                rs.close();
                pst.close();
            }catch(Exception e){
                
            }
        }
  
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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
        jScrollPane3.setViewportView(jTable3);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Search Name : ");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jButton1.setText("Update Record");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Delete Record");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1298, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Daily Micro-Loan Service", jPanel3);

        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

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
        jScrollPane4.setViewportView(jTable4);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Search Name : ");

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });

        jButton3.setText("Update Record");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Delete Record");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1298, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Monthly Micro-Loan Service", jPanel4);

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(jTable5);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Search Name : ");

        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
        });

        jButton5.setText("Update Record");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Delete Record");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1298, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Annually Micro-Loan Service", jPanel5);

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(jTable6);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Search Name : ");

        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField4KeyReleased(evt);
            }
        });

        jButton7.setText("Update Record");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Delete Record");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1298, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7)
                    .addComponent(jButton8))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Fix-Loan Service", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        setSize(new java.awt.Dimension(1339, 603));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        
        String sql = "SELECT microLoanId,amountOfLoan,interestRate,numberOfInstallement,loanType,"
                    + "installementAmount,issueDate,dueDate,customerdetails.id,customerdetails.name,"
                    + "customerdetails.nic,customerdetails.address,customerdetails.resistance,"
                    + "customerdetails.contactNo,customerdetails.gender FROM microloan "
                    + "INNER JOIN customerdetails ON microloan.customerId=customerdetails.id "
                    + "WHERE name=? and loanType='Daily' ";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1 , jTextField1.getText());
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

    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        
        String sql = "SELECT microLoanId,amountOfLoan,interestRate,numberOfInstallement,loanType,"
                    + "installementAmount,issueDate,dueDate,customerdetails.id,customerdetails.name,"
                    + "customerdetails.nic,customerdetails.address,customerdetails.resistance,"
                    + "customerdetails.contactNo,customerdetails.gender FROM microloan "
                    + "INNER JOIN customerdetails ON microloan.customerId=customerdetails.id "
                    + "WHERE name=? and loanType='Monthly' ";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1 , jTextField2.getText());
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
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
              
        String sql = "SELECT microLoanId,amountOfLoan,interestRate,numberOfInstallement,loanType,"
                    + "installementAmount,issueDate,dueDate,customerdetails.id,customerdetails.name,"
                    + "customerdetails.nic,customerdetails.address,customerdetails.resistance,"
                    + "customerdetails.contactNo,customerdetails.gender FROM microloan "
                    + "INNER JOIN customerdetails ON microloan.customerId=customerdetails.id "
                    + "WHERE name=? and loanType='Annually' ";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1 , jTextField3.getText());
            rs = pst.executeQuery();
            
            jTable5.setModel(DbUtils.resultSetToTableModel(rs));
            
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
        
        String sql = "SELECT fixLoanId,amountOfLoan,interestRate,installementAmount,issueDate"
                + ",customerdetails.id,customerdetails.name,"
                + "customerdetails.nic,customerdetails.address,customerdetails.resistance,"
                + "customerdetails.contactNo,customerdetails.gender FROM fixloan "
                + "INNER JOIN customerdetails ON fixloan.customerId=customerdetails.id WHERE name=? ";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1 , jTextField4.getText());
            rs = pst.executeQuery();
            
            jTable6.setModel(DbUtils.resultSetToTableModel(rs));
            
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

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
        int x=JOptionPane.showConfirmDialog(null, "Are you sure you want update this record?");
        if(x==0){
            
        int r = jTable5.getSelectedRow();
        
        //customer details update 
        String sq = "UPDATE customerdetails SET name=?,nic=?,address=?,resistance=?,"
        + "contactNo=?,gender=?  WHERE id=?";
        
        try{
            
            pst = conn.prepareStatement(sq);
            pst.setString(1, jTable5.getValueAt(r, 1).toString());
            pst.setString(2, jTable5.getValueAt(r, 2).toString());
            pst.setString(3, jTable5.getValueAt(r, 3).toString());
            pst.setString(4, jTable5.getValueAt(r, 4).toString());
            pst.setString(5, jTable5.getValueAt(r, 5).toString());
            pst.setString(6, jTable5.getValueAt(r, 6).toString());
            pst.setString(7, jTable5.getValueAt(r, 0).toString());
            pst.execute();
            
            microLoanAnnuallyTable();
  
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        } 
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        
        int r = jTable3.getSelectedRow();
        
        String loanId = jTable3.getValueAt(r, 0).toString();
        String customerId = jTable3.getValueAt(r, 0).toString();
        String name = jTable3.getValueAt(r, 0).toString();
        String nic = jTable3.getValueAt(r, 0).toString();
        String address = jTable3.getValueAt(r, 0).toString();
        String contactNo = jTable3.getValueAt(r, 0).toString();
        String gender = jTable3.getValueAt(r, 0).toString();
        String amountOfLoan = jTable3.getValueAt(r, 0).toString();
        String interestRate = jTable3.getValueAt(r, 0).toString();
        String numberOfInstallement = jTable3.getValueAt(r, 0).toString();
        //String loanType = jTable3.getValueAt(r, 0).toString();
        String installementAmount = jTable3.getValueAt(r, 0).toString();
        String issueDate = jTable3.getValueAt(r, 0).toString();
        String DueDate = jTable3.getValueAt(r, 0).toString();
 
    }//GEN-LAST:event_jTable3MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        int x = JOptionPane.showConfirmDialog(null, "Are you sure you want delete this record?");
        if(x==0){
        int r = jTable3.getSelectedRow();
        
        String sql = "DELETE FROM microloandaily WHERE loanId=?";
        
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1, jTable3.getValueAt(r , 0).toString());
            pst.execute();
            
            microLoanDailyTable();
            JOptionPane.showMessageDialog(null, "Record Deleted Successfully!");
            
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, e);
            
        }
        }
                 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        int x=JOptionPane.showConfirmDialog(null, "Are you sure you want update this record?");
        if(x==0){
            
        int r = jTable3.getSelectedRow();
        
        //customer details update 
        String sq = "UPDATE customerdetails SET name=?,nic=?,address=?,resistance=?,"
        + "contactNo=?,gender=?  WHERE id=?";
        
        try{
            
            pst = conn.prepareStatement(sq);
            pst.setString(1, jTable3.getValueAt(r, 1).toString());
            pst.setString(2, jTable3.getValueAt(r, 2).toString());
            pst.setString(3, jTable3.getValueAt(r, 3).toString());
            pst.setString(4, jTable3.getValueAt(r, 4).toString());
            pst.setString(5, jTable3.getValueAt(r, 5).toString());
            pst.setString(6, jTable3.getValueAt(r, 6).toString());
            pst.setString(7, jTable3.getValueAt(r, 0).toString());
            pst.execute();
            
            JOptionPane.showMessageDialog(null,"Record updated successfully!");
            microLoanDailyTable();
  
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        }    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        int x = JOptionPane.showConfirmDialog(null, "Are you sure you want delete this record?");
        if(x==0){
        int r = jTable4.getSelectedRow();
        
        String sql = "DELETE FROM microloanmonthly WHERE loanId=?";
        
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1, jTable4.getValueAt(r , 0).toString());
            pst.execute();
            
            microLoanMonthlyTable();
            JOptionPane.showMessageDialog(null, "Record Deleted Successfully!");
            
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, e);
            
        }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        
        int x = JOptionPane.showConfirmDialog(null, "Are you sure you want delete this record?");
        if(x==0){
        int r = jTable5.getSelectedRow();
        
        String sql = "DELETE FROM microloanAnnually WHERE loanId=?";
        
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1, jTable5.getValueAt(r , 0).toString());
            pst.execute();
            
            microLoanAnnuallyTable();
            JOptionPane.showMessageDialog(null, "Record Deleted Successfully!");
            
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, e);
            
        }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        
        int x = JOptionPane.showConfirmDialog(null, "Are you sure you want delete this record?");
        if(x==0){
        int r = jTable6.getSelectedRow();
        
        String sql = "DELETE FROM fixloan WHERE fixLoanId=?";
        
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1, jTable6.getValueAt(r , 0).toString());
            pst.execute();
            
            fixLoanTable();
            JOptionPane.showMessageDialog(null, "Record Deleted Successfully!");
            
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, e);
            
        }
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        int x=JOptionPane.showConfirmDialog(null, "Are you sure you want update this record?");
        if(x==0){
            
        int r = jTable4.getSelectedRow();
        
        //customer details update 
        String sq = "UPDATE customerdetails SET name=?,nic=?,address=?,resistance=?,"
        + "contactNo=?,gender=?  WHERE id=?";
        
        try{
            
            pst = conn.prepareStatement(sq);
            pst.setString(1, jTable4.getValueAt(r, 1).toString());
            pst.setString(2, jTable4.getValueAt(r, 2).toString());
            pst.setString(3, jTable4.getValueAt(r, 3).toString());
            pst.setString(4, jTable4.getValueAt(r, 4).toString());
            pst.setString(5, jTable4.getValueAt(r, 5).toString());
            pst.setString(6, jTable4.getValueAt(r, 6).toString());
            pst.setString(7, jTable4.getValueAt(r, 0).toString());
            pst.execute();
            
            microLoanMonthlyTable();
  
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        } 
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        
        int x=JOptionPane.showConfirmDialog(null, "Are you sure you want update this record?");
        if(x==0){
            
        int r = jTable6.getSelectedRow();
        
        //customer details update 
        String sq = "UPDATE customerdetails SET name=?,nic=?,address=?,resistance=?,"
        + "contactNo=?,gender=?  WHERE id=?";
        
        try{
            
            pst = conn.prepareStatement(sq);
            pst.setString(1, jTable6.getValueAt(r, 1).toString());
            pst.setString(2, jTable6.getValueAt(r, 2).toString());
            pst.setString(3, jTable6.getValueAt(r, 3).toString());
            pst.setString(4, jTable6.getValueAt(r, 4).toString());
            pst.setString(5, jTable6.getValueAt(r, 5).toString());
            pst.setString(6, jTable6.getValueAt(r, 6).toString());
            pst.setString(7, jTable6.getValueAt(r, 0).toString());
            pst.execute();
            
            microLoanDailyTable();
  
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        } 
    }//GEN-LAST:event_jButton7ActionPerformed

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
            java.util.logging.Logger.getLogger(Statistic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Statistic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Statistic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Statistic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Statistic().setVisible(true);
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/loan.png")));
    }
}
