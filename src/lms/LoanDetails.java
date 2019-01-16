package lms;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import net.proteanit.sql.DbUtils;

public class LoanDetails extends javax.swing.JFrame {
    
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    
    User numberOnly = new User();

    public LoanDetails() {
        super("Loan Details");
        initComponents();
        conn = DBconnect.connect();
        setIcon();
        
        microLoanDailyTable();
        microLoanWeeklyTable();
        microLoanMonthlyTable();
        fixLoanTable();
        customerDetailsTable();
        
        microLoanDailyTableSetColumnWidth();
        microLoanWeeklyTableSetColumnWidth();
        microLoanMonthlyTableSetColumnWidth();
        
        
        
        
        //set column width jtable 5 (microLoanDailyTable)
        jTable5.getColumnModel().getColumn(0).setPreferredWidth(5);
        jTable5.getColumnModel().getColumn(1).setPreferredWidth(30);
        jTable5.getColumnModel().getColumn(2).setPreferredWidth(10);
        jTable5.getColumnModel().getColumn(3).setPreferredWidth(20);
        jTable5.getColumnModel().getColumn(4).setPreferredWidth(5);
        jTable5.getColumnModel().getColumn(5).setPreferredWidth(25);
        jTable5.getColumnModel().getColumn(6).setPreferredWidth(20);
        jTable5.getColumnModel().getColumn(7).setPreferredWidth(20);
        jTable5.getColumnModel().getColumn(8).setPreferredWidth(5);
        jTable5.getColumnModel().getColumn(9).setPreferredWidth(100);
                
    }

    public void microLoanDailyTable(){
        
        try{
            String sql = "SELECT microLoanId AS Micro_Loan_ID , amountOfLoan AS Amount_of_Loan,"
                    + "interestRate AS Interest_Rate , numberOfInstallement AS No_of_Installement , loanType AS Loan_Type,"
                    + "installementAmount AS Installement_Amount ,issueDate AS Issue_Date , dueDate AS Due_Date ,"
                    + "customerdetails.id AS Customer_ID,customerdetails.name AS Customer_Name "
                    + "FROM microloan "
                    + "INNER JOIN customerdetails ON (microloan.customerId=customerdetails.id) "
                    + "WHERE loanType='Daily' AND microloan.userId=? AND microloan.is_deleted=0 ";
            
            pst = conn.prepareStatement(sql);
            pst.setString(1, User.userid);
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
        
        //set column width jtable 3
        microLoanDailyTableSetColumnWidth();
        
  
    }
    
    public void microLoanWeeklyTable(){
        
        try{
            String sql = "SELECT microLoanId AS Micro_Loan_ID , amountOfLoan AS Amount_of_Loan,"
                    + "interestRate AS Interest_Rate , numberOfInstallement AS No_of_Installement , loanType AS Loan_Type,"
                    + "installementAmount AS Installement_Amount ,issueDate AS Issue_Date , dueDate AS Due_Date ,"
                    + "customerdetails.id AS Customer_ID,customerdetails.name AS Customer_Name "
                    + "FROM microloan "
                    + "INNER JOIN customerdetails ON (microloan.customerId=customerdetails.id) "
                    + "WHERE loanType='Weekly' AND microloan.userId=? AND microloan.is_deleted=0";
            
            pst = conn.prepareStatement(sql);
            pst.setString(1, User.userid);
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
        
        //set column width jtable 4
        microLoanWeeklyTableSetColumnWidth();
  
    }
       
    public void microLoanMonthlyTable(){
        
        try{
            String sql = "SELECT microLoanId AS Micro_Loan_ID , amountOfLoan AS Amount_of_Loan,"
                    + "interestRate AS Interest_Rate , numberOfInstallement AS No_of_Installement , loanType AS Loan_Type,"
                    + "installementAmount AS Installement_Amount ,issueDate AS Issue_Date , dueDate AS Due_Date ,"
                    + "customerdetails.id AS Customer_ID,customerdetails.name AS Customer_Name "
                    + "FROM microloan "
                    + "INNER JOIN customerdetails ON (microloan.customerId=customerdetails.id) "
                    + "WHERE loanType='Monthly' AND microloan.userId=? AND microloan.is_deleted=0";
            
            pst = conn.prepareStatement(sql);
            pst.setString(1 , User.userid);
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
        
        //set column width jtable 5
        microLoanMonthlyTableSetColumnWidth();
        
    }
    
        public void fixLoanTable(){
        
        try{
            String sql = "SELECT fixLoanId AS Fix_Loan_ID , amountOfLoan AS Amount_of_Loan , interestRate AS Interest_Rate,"
                + "installementAmount AS Installement_Amount , issueDate AS Issue_Date,"
                + "customerdetails.id AS Customer_ID , customerdetails.name AS Customer_Name "
                + "FROM fixloan "
                + "INNER JOIN customerdetails ON (fixloan.customerId=customerdetails.id) "
                + "WHERE fixloan.userId=? AND fixloan.is_deleted=0 ";
            
            
            pst = conn.prepareStatement(sql);
            pst.setString(1 ,User.userid);
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
        
        public void customerDetailsTable(){
        
            String sql = "SELECT id AS Customer_ID,name AS Customer_Name ,nic AS NIC_Number,address AS Address,"
                    + "resistance AS Resistance ,contactNo AS Contact_NO ,gender AS Gender "
                    + "FROM customerdetails "
                    + "WHERE userId=? AND is_deleted=0 ";
            
            try{
                pst = conn.prepareStatement(sql);
                pst.setString(1, User.userid);
                rs = pst.executeQuery();
                
                jTable7.setModel(DbUtils.resultSetToTableModel(rs));
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        
        }
        
        
        
        //set column width jtable 3 (microLoanDailyTable)
        public void microLoanDailyTableSetColumnWidth(){
        jTable3.getColumnModel().getColumn(0).setPreferredWidth(5);
        jTable3.getColumnModel().getColumn(1).setPreferredWidth(30);
        jTable3.getColumnModel().getColumn(2).setPreferredWidth(10);
        jTable3.getColumnModel().getColumn(3).setPreferredWidth(20);
        jTable3.getColumnModel().getColumn(4).setPreferredWidth(5);
        jTable3.getColumnModel().getColumn(5).setPreferredWidth(25);
        jTable3.getColumnModel().getColumn(6).setPreferredWidth(20);
        jTable3.getColumnModel().getColumn(7).setPreferredWidth(20);
        jTable3.getColumnModel().getColumn(8).setPreferredWidth(5);
        jTable3.getColumnModel().getColumn(9).setPreferredWidth(100);
        }
        
        //set column width jtable 4 (microLoanWeeklyTable)
        public void microLoanWeeklyTableSetColumnWidth(){    
        jTable4.getColumnModel().getColumn(0).setPreferredWidth(5);
        jTable4.getColumnModel().getColumn(1).setPreferredWidth(30);
        jTable4.getColumnModel().getColumn(2).setPreferredWidth(10);
        jTable4.getColumnModel().getColumn(3).setPreferredWidth(20);
        jTable4.getColumnModel().getColumn(4).setPreferredWidth(5);
        jTable4.getColumnModel().getColumn(5).setPreferredWidth(25);
        jTable4.getColumnModel().getColumn(6).setPreferredWidth(20);
        jTable4.getColumnModel().getColumn(7).setPreferredWidth(20);
        jTable4.getColumnModel().getColumn(8).setPreferredWidth(5);
        jTable4.getColumnModel().getColumn(9).setPreferredWidth(100);
        }
        
        //set column width jtable 5 (microLoanMonthlyTable)
        public void microLoanMonthlyTableSetColumnWidth(){       
        jTable5.getColumnModel().getColumn(0).setPreferredWidth(5);
        jTable5.getColumnModel().getColumn(1).setPreferredWidth(30);
        jTable5.getColumnModel().getColumn(2).setPreferredWidth(10);
        jTable5.getColumnModel().getColumn(3).setPreferredWidth(20);
        jTable5.getColumnModel().getColumn(4).setPreferredWidth(5);
        jTable5.getColumnModel().getColumn(5).setPreferredWidth(25);
        jTable5.getColumnModel().getColumn(6).setPreferredWidth(20);
        jTable5.getColumnModel().getColumn(7).setPreferredWidth(20);
        jTable5.getColumnModel().getColumn(8).setPreferredWidth(5);
        jTable5.getColumnModel().getColumn(9).setPreferredWidth(100);
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
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jButton9 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();

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

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setText("Delete Record");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Search Loan ID : ");

        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField5KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField5KeyTyped(evt);
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
                        .addGap(97, 97, 97)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jLabel5)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE))
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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton4.setText("Delete Record");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton3.setText("Refresh");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Search Loan ID : ");

        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField7KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField7KeyTyped(evt);
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
                        .addGap(97, 97, 97)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                    .addComponent(jButton4)
                    .addComponent(jButton3)
                    .addComponent(jLabel7)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Weekly  Micro-Loan Service", jPanel4);

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

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton6.setText("Delete Record");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton5.setText("Refresh");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton6)
                        .addComponent(jButton5)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Monthly Micro-Loan Service", jPanel5);

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

        jButton8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton8.setText("Delete Record");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton7.setText("Refresh");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Search Loan ID : ");

        jTextField9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField9KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField9KeyTyped(evt);
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
                        .addGap(97, 97, 97)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8)
                            .addComponent(jButton7)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Fix-Loan Service", jPanel6);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Search Name : ");

        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField6KeyReleased(evt);
            }
        });

        jTable7.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(jTable7);

        jButton9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton9.setText("Refresh");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Search customer ID : ");

        jTextField10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField10KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField10KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 212, Short.MAX_VALUE)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9)
                    .addComponent(jLabel10)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Customer Details", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        setSize(new java.awt.Dimension(1339, 706));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        
        jTextField5.setText("");
        
        String sql = "SELECT microLoanId AS Micro_Loan_ID , amountOfLoan AS Amount_of_Loan,"
                    + "interestRate AS Interest_Rate , numberOfInstallement AS No_of_Installement , loanType AS Loan_Type,"
                    + "installementAmount AS Installement_Amount ,issueDate AS Issue_Date , dueDate AS Due_Date ,"
                    + "customerdetails.id AS Customer_ID,customerdetails.name AS Customer_Name "
                    + "FROM microloan "
                    + "INNER JOIN customerdetails ON (microloan.customerId=customerdetails.id) "
                    + "WHERE name=? AND loanType='Daily' AND microloan.userId=? AND microloan.is_deleted=0 ";
                    
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1 , jTextField1.getText());
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
        
        //set column width jtable 3
        microLoanDailyTableSetColumnWidth();

    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        
        jTextField7.setText("");
        
        String sql = "SELECT microLoanId AS Micro_Loan_ID , amountOfLoan AS Amount_of_Loan,"
                    + "interestRate AS Interest_Rate , numberOfInstallement AS No_of_Installement , loanType AS Loan_Type,"
                    + "installementAmount AS Installement_Amount ,issueDate AS Issue_Date , dueDate AS Due_Date ,"
                    + "customerdetails.id AS Customer_ID,customerdetails.name AS Customer_Name "
                    + "FROM microloan "
                    + "INNER JOIN customerdetails ON (microloan.customerId=customerdetails.id) "
                    + "WHERE name=? AND loanType='Weekly' AND microloan.userId=? AND microloan.is_deleted=0 ";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1 , jTextField2.getText());
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
        
        //set column width jtable 4
        microLoanWeeklyTableSetColumnWidth();
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        
        jTextField8.setText("");
        
        String sql = "SELECT microLoanId AS Micro_Loan_ID , amountOfLoan AS Amount_of_Loan,"
                    + "interestRate AS Interest_Rate , numberOfInstallement AS No_of_Installement , loanType AS Loan_Type,"
                    + "installementAmount AS Installement_Amount ,issueDate AS Issue_Date , dueDate AS Due_Date ,"
                    + "customerdetails.id AS Customer_ID,customerdetails.name AS Customer_Name "
                    + "FROM microloan "
                    + "INNER JOIN customerdetails ON (microloan.customerId=customerdetails.id) "
                    + "WHERE name=? AND loanType='Monthly' AND microloan.userId=? AND microloan.is_deleted=0 ";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1 , jTextField3.getText());
            pst.setString(2 , User.userid);
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
        
        //set column width jtable 5
        microLoanMonthlyTableSetColumnWidth();
        
    }//GEN-LAST:event_jTextField3KeyReleased

    private void jTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyReleased
        
        jTextField9.setText("");
        
        String sql = "SELECT fixLoanId AS Fix_Loan_ID , amountOfLoan AS Amount_of_Loan , interestRate AS Interest_Rate,"
                + "installementAmount AS Installement_Amount , issueDate AS Issue_Date,"
                + "customerdetails.id AS Customer_ID , customerdetails.name AS Customer_Name "
                + "FROM fixloan "
                + "INNER JOIN customerdetails ON (fixloan.customerId=customerdetails.id) "
                + "WHERE name=? and fixloan.userId=? AND fixloan.is_deleted=0 ";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1 , jTextField4.getText());
            pst.setString(2 , User.userid);
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
        //before delete the record of microloan table delete microloanrepayment table records to belong to this id
        String sq = "DELETE FROM microloanrepayment WHERE microLoanId=? AND customerId=? AND userId=?";
        
        try{
            pst = conn.prepareStatement(sq);
            pst.setString(1, jTable3.getValueAt(r , 0).toString());
            pst.setString(2, jTable3.getValueAt(r , 8).toString());
            pst.setString(3, User.userid);
            pst.execute();
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
                    
        }    
        
        
        String sql = "DELETE FROM microloan WHERE microLoanId=? AND customerId=? AND userId=?";
        
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1, jTable3.getValueAt(r , 0).toString());
            pst.setString(2, jTable3.getValueAt(r , 8).toString());
            pst.setString(3, User.userid);
            pst.execute();
            
            microLoanDailyTable();
            jTextField1.setText("");
            jTextField5.setText("");
           
            JOptionPane.showMessageDialog(null, "Record Deleted Successfully!");
            
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, e);
            
        }
        
        
        }         
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        int x = JOptionPane.showConfirmDialog(null, "Are you sure you want delete this record?");
        if(x==0){
        int r = jTable4.getSelectedRow();
        
        //before delete the record of microloan table delete microloanrepayment table records to belong to this id
        String sq = "DELETE FROM microloanrepayment WHERE microLoanId=? AND customerId=? AND userId=?";
        
        try{
            pst = conn.prepareStatement(sq);
            pst.setString(1, jTable4.getValueAt(r , 0).toString());
            pst.setString(2, jTable4.getValueAt(r , 8).toString());
            pst.setString(3, User.userid);
            pst.execute();
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
                    
        } 
        
        String sql = "DELETE FROM microloan WHERE microLoanId=? AND customerId=? AND userId=? ";
        
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1, jTable4.getValueAt(r , 0).toString());
            pst.setString(2, jTable4.getValueAt(r , 8).toString());
            pst.setString(3, User.userid);
            pst.execute();
            
            microLoanWeeklyTable();
            jTextField2.setText("");
            jTextField7.setText("");
        
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
        
        //before delete the record of microloan table delete microloanrepayment table records to belong to this id
        String sq = "DELETE FROM microloanrepayment WHERE microLoanId=? AND customerId=? AND userId=?";
        
        try{
            pst = conn.prepareStatement(sq);
            pst.setString(1, jTable5.getValueAt(r , 0).toString());
            pst.setString(2, jTable5.getValueAt(r , 8).toString());
            pst.setString(3, User.userid);
            pst.execute();
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
                    
        } 
        
        String sql = "DELETE FROM microloan WHERE microLoanId=? AND customerId=? AND userId=?";
        
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1, jTable5.getValueAt(r , 0).toString());
            pst.setString(2, jTable5.getValueAt(r , 8).toString());
            pst.setString(3, User.userid);
            pst.execute();
            
            microLoanMonthlyTable();
            jTextField3.setText("");
            jTextField8.setText("");
        
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
        
        //before delete the record of fixloan table delete fixloanrepayment table records to belong to this id
        String sq = "DELETE FROM fixloanrepayment WHERE fixLoanId=? AND customerId=? AND userId=?";
        
        try{
            pst = conn.prepareStatement(sq);
            pst.setString(1, jTable6.getValueAt(r , 0).toString());
            pst.setString(2, jTable6.getValueAt(r , 5).toString());
            pst.setString(3, User.userid);
            pst.execute();
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
                    
        } 
        
        String sql = "DELETE FROM fixloan WHERE fixLoanId=? AND customerId=? And userId=? ";
        
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1, jTable6.getValueAt(r , 0).toString());
            pst.setString(2, jTable6.getValueAt(r , 5).toString());
            pst.setString(3, User.userid);
            pst.execute();
            
            fixLoanTable();
            jTextField4.setText("");
            jTextField9.setText("");
        
            JOptionPane.showMessageDialog(null, "Record Deleted Successfully!");
            
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, e);
            
        }
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyReleased
        
        jTextField10.setText("");
        
        String sql = "SELECT id AS Customer_ID,name AS Customer_Name,nic AS NIC_Number,address AS Address,"
                + "resistance AS Resistance,contactNo AS Contact_NO,gender AS Gender "
                + "FROM customerdetails "
                + "WHERE name=? and userId=? AND is_deleted=0 ";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1, jTextField6.getText());
            pst.setString(2, User.userid);
            rs = pst.executeQuery();
            
            jTable7.setModel(DbUtils.resultSetToTableModel(rs));
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jTextField6KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        microLoanDailyTable();
        jTextField1.setText("");
        jTextField5.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        microLoanWeeklyTable();
        jTextField2.setText("");
        jTextField7.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
        microLoanMonthlyTable();
        jTextField3.setText("");
        jTextField8.setText("");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        
        fixLoanTable();
        jTextField4.setText("");
        jTextField9.setText("");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        jTextField6.setText("");
        jTextField10.setText("");
        customerDetailsTable();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jTextField5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyTyped
        
        try{
            numberOnly.NumbersOnly(evt);
        
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "loan System Error");
        }
       
    }//GEN-LAST:event_jTextField5KeyTyped

    private void jTextField5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyReleased
        
                jTextField1.setText("");
        
                String sql = "SELECT microLoanId AS Micro_Loan_ID , amountOfLoan AS Amount_of_Loan,"
                    + "interestRate AS Interest_Rate , numberOfInstallement AS No_of_Installement , loanType AS Loan_Type,"
                    + "installementAmount AS Installement_Amount ,issueDate AS Issue_Date , dueDate AS Due_Date ,"
                    + "customerdetails.id AS Customer_ID,customerdetails.name AS Customer_Name "
                    + "FROM microloan "
                    + "INNER JOIN customerdetails ON (microloan.customerId=customerdetails.id) "
                    + "WHERE microLoanId=? AND loanType='Daily' AND microloan.userId=? AND microloan.is_deleted=0 ";
                    
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
        
        //set column width jtable 3
        microLoanDailyTableSetColumnWidth();
    }//GEN-LAST:event_jTextField5KeyReleased

    private void jTextField7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyReleased
        
        jTextField2.setText("");
        
        String sql = "SELECT microLoanId AS Micro_Loan_ID , amountOfLoan AS Amount_of_Loan,"
                    + "interestRate AS Interest_Rate , numberOfInstallement AS No_of_Installement , loanType AS Loan_Type,"
                    + "installementAmount AS Installement_Amount ,issueDate AS Issue_Date , dueDate AS Due_Date ,"
                    + "customerdetails.id AS Customer_ID,customerdetails.name AS Customer_Name "
                    + "FROM microloan "
                    + "INNER JOIN customerdetails ON (microloan.customerId=customerdetails.id) "
                    + "WHERE microLoanId=? AND loanType='Weekly' AND microloan.userId=? AND microloan.is_deleted=0 ";
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
        
        //set column width jtable 4
        microLoanWeeklyTableSetColumnWidth();
    }//GEN-LAST:event_jTextField7KeyReleased

    private void jTextField8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyReleased
        
        jTextField3.setText("");
        
        String sql = "SELECT microLoanId AS Micro_Loan_ID , amountOfLoan AS Amount_of_Loan,"
                    + "interestRate AS Interest_Rate , numberOfInstallement AS No_of_Installement , loanType AS Loan_Type,"
                    + "installementAmount AS Installement_Amount ,issueDate AS Issue_Date , dueDate AS Due_Date ,"
                    + "customerdetails.id AS Customer_ID,customerdetails.name AS Customer_Name "
                    + "FROM microloan "
                    + "INNER JOIN customerdetails ON (microloan.customerId=customerdetails.id) "
                    + "WHERE microLoanId=? AND loanType='Monthly' AND microloan.userId=? AND microloan.is_deleted=0 ";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1 , jTextField8.getText());
            pst.setString(2 , User.userid);
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
        
        //set column width jtable 5
        microLoanMonthlyTableSetColumnWidth();
    }//GEN-LAST:event_jTextField8KeyReleased

    private void jTextField9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyReleased
        
        jTextField4.setText("");
        
        String sql = "SELECT fixLoanId AS Fix_Loan_ID , amountOfLoan AS Amount_of_Loan , interestRate AS Interest_Rate,"
                + "installementAmount AS Installement_Amount , issueDate AS Issue_Date,"
                + "customerdetails.id AS Customer_ID , customerdetails.name AS Customer_Name "
                + "FROM fixloan "
                + "INNER JOIN customerdetails ON (fixloan.customerId=customerdetails.id) "
                + "WHERE fixLoanId=? and fixloan.userId=? AND fixloan.is_deleted=0 ";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1 , jTextField9.getText());
            pst.setString(2 , User.userid);
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
    }//GEN-LAST:event_jTextField9KeyReleased

    private void jTextField10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyReleased
        
        jTextField6.setText("");
        
        String sql = "SELECT id AS Customer_ID,name AS Customer_Name,nic AS NIC_Number,address AS Address,"
                + "resistance AS Resistance,contactNo AS Contact_NO,gender AS Gender "
                + "FROM customerdetails "
                + "WHERE id=? and userId=? AND is_deleted=0 ";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1, jTextField10.getText());
            pst.setString(2, User.userid);
            rs = pst.executeQuery();
            
            jTable7.setModel(DbUtils.resultSetToTableModel(rs));
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
      
    }//GEN-LAST:event_jTextField10KeyReleased

    private void jTextField7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyTyped
        
        try{
            numberOnly.NumbersOnly(evt);
        
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "loan System Error");
        }
    }//GEN-LAST:event_jTextField7KeyTyped

    private void jTextField8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyTyped
        
        try{
            numberOnly.NumbersOnly(evt);
        
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "loan System Error");
        }
    }//GEN-LAST:event_jTextField8KeyTyped

    private void jTextField9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyTyped
        
        try{
            numberOnly.NumbersOnly(evt);
        
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "loan System Error");
        }
    }//GEN-LAST:event_jTextField9KeyTyped

    private void jTextField10KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyTyped
        
        try{
            numberOnly.NumbersOnly(evt);
        
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "loan System Error");
        }
    }//GEN-LAST:event_jTextField10KeyTyped

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
            java.util.logging.Logger.getLogger(LoanDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoanDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoanDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoanDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoanDetails().setVisible(true);
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
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/loan.png")));
    }
}
