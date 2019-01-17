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

public class RepaymentDetails extends javax.swing.JFrame {
    
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    
    User numberOnly = new User();
  
    public RepaymentDetails() {
        super("Repayment Details");
        initComponents();
        setExtendedState(RepaymentDetails.MAXIMIZED_BOTH);
        conn = DBconnect.connect();
        setIcon();
        
        DailyMicroLoanTable();
        WeeklyMicroLoanTable();
        MonthlyMicroLoanTable();
        fixLoanTable();
        
        microLoanDailyTableSetColumnWidth();
        microLoanWeeklyTableSetColumnWidth();
        microLoanMonthlyTableSetColumnWidth();
        fixLoanTableSetColumnWidth();
    }
    
    RepaymentDetailsPop rdp = new RepaymentDetailsPop();
    
    public void DailyMicroLoanTable(){
        
        try{
            String sql = "SELECT microLoanId AS Micro_Loan_ID , amountOfLoan AS Amount_of_Loan,"
                    + "interestRate AS Interest_Rate , numberOfInstallement AS No_of_Installement , loanType AS Loan_Type,"
                    + "installementAmount AS Installement_Amount ,issueDate AS Issue_Date , dueDate AS Due_Date ,"
                    + "customerdetails.id AS Customer_ID,customerdetails.name AS Customer_Name "
                    + "FROM microloan "
                    + "INNER JOIN customerdetails ON (microloan.customerId=customerdetails.id) "
                    + "WHERE microloan.userId=? AND microloan.loanType='Daily' AND microloan.is_deleted=0" ;
            
            pst = conn.prepareStatement(sql);
            pst.setString(1, User.userid);
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
    }
    
    
    public void WeeklyMicroLoanTable(){
        
        try{
            String sql = "SELECT microLoanId AS Micro_Loan_ID , amountOfLoan AS Amount_of_Loan,"
                    + "interestRate AS Interest_Rate , numberOfInstallement AS No_of_Installement , loanType AS Loan_Type,"
                    + "installementAmount AS Installement_Amount ,issueDate AS Issue_Date , dueDate AS Due_Date ,"
                    + "customerdetails.id AS Customer_ID,customerdetails.name AS Customer_Name "
                    + "FROM microloan "
                    + "INNER JOIN customerdetails ON (microloan.customerId=customerdetails.id) "
                    + "WHERE microloan.userId=? AND microloan.loanType='Weekly' AND microloan.is_deleted=0" ;
            
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
    }
    
    
    public void MonthlyMicroLoanTable(){
        
        try{
            String sql = "SELECT microLoanId AS Micro_Loan_ID , amountOfLoan AS Amount_of_Loan,"
                    + "interestRate AS Interest_Rate , numberOfInstallement AS No_of_Installement , loanType AS Loan_Type,"
                    + "installementAmount AS Installement_Amount ,issueDate AS Issue_Date , dueDate AS Due_Date ,"
                    + "customerdetails.id AS Customer_ID,customerdetails.name AS Customer_Name "
                    + "FROM microloan "
                    + "INNER JOIN customerdetails ON (microloan.customerId=customerdetails.id) "
                    + "WHERE microloan.userId=? AND microloan.loanType='Monthly' AND microloan.is_deleted=0" ;
            
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
    }
    
    
    
    //set column width jtable 1 (microLoanDailyTable)
        public void microLoanDailyTableSetColumnWidth(){
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(5);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(30);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(10);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(20);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(5);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(25);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(20);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(20);
        jTable1.getColumnModel().getColumn(8).setPreferredWidth(5);
        jTable1.getColumnModel().getColumn(9).setPreferredWidth(150);
        }
        
        //set column width jtable 3 (microLoanWeeklyTable)
        public void microLoanWeeklyTableSetColumnWidth(){    
        jTable3.getColumnModel().getColumn(0).setPreferredWidth(5);
        jTable3.getColumnModel().getColumn(1).setPreferredWidth(30);
        jTable3.getColumnModel().getColumn(2).setPreferredWidth(10);
        jTable3.getColumnModel().getColumn(3).setPreferredWidth(20);
        jTable3.getColumnModel().getColumn(4).setPreferredWidth(5);
        jTable3.getColumnModel().getColumn(5).setPreferredWidth(25);
        jTable3.getColumnModel().getColumn(6).setPreferredWidth(20);
        jTable3.getColumnModel().getColumn(7).setPreferredWidth(20);
        jTable3.getColumnModel().getColumn(8).setPreferredWidth(5);
        jTable3.getColumnModel().getColumn(9).setPreferredWidth(150);
        }
        
        //set column width jtable 4 (microLoanMonthlyTable)
        public void microLoanMonthlyTableSetColumnWidth(){       
        jTable4.getColumnModel().getColumn(0).setPreferredWidth(5);
        jTable4.getColumnModel().getColumn(1).setPreferredWidth(30);
        jTable4.getColumnModel().getColumn(2).setPreferredWidth(10);
        jTable4.getColumnModel().getColumn(3).setPreferredWidth(20);
        jTable4.getColumnModel().getColumn(4).setPreferredWidth(5);
        jTable4.getColumnModel().getColumn(5).setPreferredWidth(25);
        jTable4.getColumnModel().getColumn(6).setPreferredWidth(20);
        jTable4.getColumnModel().getColumn(7).setPreferredWidth(20);
        jTable4.getColumnModel().getColumn(8).setPreferredWidth(5);
        jTable4.getColumnModel().getColumn(9).setPreferredWidth(150);
        }
        
        //set column width jtable 2 (microLoanMonthlyTable)
        public void fixLoanTableSetColumnWidth(){       
        jTable2.getColumnModel().getColumn(0).setPreferredWidth(5);
        jTable2.getColumnModel().getColumn(1).setPreferredWidth(30);
        jTable2.getColumnModel().getColumn(2).setPreferredWidth(10);
        jTable2.getColumnModel().getColumn(3).setPreferredWidth(25);
        jTable2.getColumnModel().getColumn(4).setPreferredWidth(20);
        jTable2.getColumnModel().getColumn(5).setPreferredWidth(5);
        jTable2.getColumnModel().getColumn(6).setPreferredWidth(150);
        
        }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jTextField5 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jTextField7 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();

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
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("Search Name");

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

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Search Loan ID : ");

        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField3KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 261, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Daily Micro-Loan Repayment Details", jPanel1);

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

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField5KeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("Search Name");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 261, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(jLabel6)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Weekly Micro-Loan Repayment Details", jPanel3);

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
        jScrollPane4.setViewportView(jTable4);

        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField7KeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setText("Search Name");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 261, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4)
                    .addComponent(jLabel8)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Monthly Micro-Loan Repayment Details", jPanel4);

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
        jScrollPane2.setViewportView(jTable2);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Search Name");

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setText("Refresh");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Search loan ID :");

        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField4KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField4KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 273, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jLabel4)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Fix-Loan Repayment Details", jPanel2);

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

        setSize(new java.awt.Dimension(1320, 707));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        
        jTextField3.setText("");
        
        String sql = "SELECT microLoanId AS Micro_Loan_ID , amountOfLoan AS Amount_of_Loan,"
                    + "interestRate AS Interest_Rate , numberOfInstallement AS No_of_Installement , loanType AS Loan_Type,"
                    + "installementAmount AS Installement_Amount ,issueDate AS Issue_Date , dueDate AS Due_Date ,"
                    + "customerdetails.id AS Customer_ID,customerdetails.name AS Customer_Name "
                    + "FROM microloan "
                    + "INNER JOIN customerdetails ON (microloan.customerId=customerdetails.id) "
                    + "WHERE name=? AND microloan.userId=? AND microloan.loanType='Daily' AND microloan.is_deleted=0 ";
                    
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1 , jTextField1.getText());
            pst.setString(2 , User.userid);
            rs = pst.executeQuery();
            
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            microLoanDailyTableSetColumnWidth();
            
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
        
       jTextField4.setText("");
        
       String sql = "SELECT fixLoanId AS Fix_Loan_ID , amountOfLoan AS Amount_of_Loan , interestRate AS Interest_Rate,"
                + "installementAmount AS Installement_Amount , issueDate AS Issue_Date,"
                + "customerdetails.id AS Customer_ID , customerdetails.name AS Customer_Name "
                + "FROM fixloan "
                + "INNER JOIN customerdetails ON (fixloan.customerId=customerdetails.id) "
                + "WHERE name=? and fixloan.userId=? AND fixloan.is_deleted=0 ";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1 , jTextField2.getText());
            pst.setString(2 , User.userid);
            rs = pst.executeQuery();
            
            jTable2.setModel(DbUtils.resultSetToTableModel(rs));
            fixLoanTableSetColumnWidth();
            
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        DailyMicroLoanTable();   
        jTextField1.setText("");
        jTextField3.setText("");
        microLoanDailyTableSetColumnWidth();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        fixLoanTable();
        jTextField2.setText("");
        jTextField4.setText("");
        fixLoanTableSetColumnWidth();
    }//GEN-LAST:event_jButton2ActionPerformed

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
        
        rdp.setVisible(true);
        rdp.pack();
        rdp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        try{
            String sql = "SELECT installementNo AS Installement_Number , remainingInstallement AS Remaining_Installements, "
                + "microloan.installementAmount AS Installement_Amount , payedAmount AS Payed_Amount,"
                + "payDate AS Pay_Date , remainingAmountOfLoan AS Remaining_Amount "
                + "FROM microloanrepayment "
                + "INNER JOIN customerdetails ON (microloanrepayment.customerId=customerdetails.id) "
                + "INNER JOIN microloan ON (microloanrepayment.microLoanId=microloan.microLoanId)"
                + "WHERE microloan.microLoanId=? AND microloan.loanType='Daily' AND microloanrepayment.userId=? "
                + "AND microloanrepayment.is_deleted=0 ";
 
            pst=conn.prepareStatement(sql);
            pst.setString(1, loanid);
            pst.setString(2, User.userid);
            rs=pst.executeQuery();

                
            rdp.RepaymentDetailsPopjTable.setModel(DbUtils.resultSetToTableModel(rs));
            rdp.jLabel1.setText("Micro Loan ID :");
            rdp.jLabel8.setText(loanid);
            rdp.jLabel9.setText(amountOfLoan);
            rdp.jLabel10.setText(interestRate);
            rdp.jLabel11.setText(noOfInstallement);
            rdp.jLabel12.setText(loanType);
            rdp.jLabel13.setText(customerId);
            rdp.jLabel14.setText(customerName);
            
            
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
        
        rdp.setVisible(true);
        rdp.pack();
        rdp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        try{
            String sql = "SELECT installementNo AS Installement_Number, fixloan.installementAmount AS Installement_Amount , "
                + "payedAmount AS Payed_Amount , payDate AS Pay_Date "
                + "FROM fixloanrepayment "
                + "INNER JOIN customerdetails ON (fixloanrepayment.customerId=customerdetails.id) "
                + "INNER JOIN fixloan ON (fixloanrepayment.fixLoanId=fixloan.fixLoanId)"
                + "WHERE fixloan.fixLoanId=? AND fixloanrepayment.userId=? AND fixloanrepayment.is_deleted=0 ";
 
            pst=conn.prepareStatement(sql);
            pst.setString(1, loanid);
            pst.setString(2, User.userid);
            rs=pst.executeQuery();
            
            rdp.RepaymentDetailsPopjTable.setModel(DbUtils.resultSetToTableModel(rs));
            rdp.jLabel8.setText(loanid);
            rdp.jLabel9.setText(amountOfLoan);
            rdp.jLabel10.setText(interestRate);
            rdp.jLabel11.setVisible(false);
            rdp.jLabel12.setVisible(false);
            rdp.jLabel4.setVisible(false);
            rdp.jLabel5.setVisible(false);
            rdp.jLabel1.setText("Fix Loan ID :");
            rdp.jLabel13.setText(customerId);
            rdp.jLabel14.setText(customerName);

            
            
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

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        
        jTextField1.setText("");
        
         String sql = "SELECT microLoanId AS Micro_Loan_ID , amountOfLoan AS Amount_of_Loan,"
                    + "interestRate AS Interest_Rate , numberOfInstallement AS No_of_Installement , loanType AS Loan_Type,"
                    + "installementAmount AS Installement_Amount ,issueDate AS Issue_Date , dueDate AS Due_Date ,"
                    + "customerdetails.id AS Customer_ID,customerdetails.name AS Customer_Name "
                    + "FROM microloan "
                    + "INNER JOIN customerdetails ON (microloan.customerId=customerdetails.id) "
                    + "WHERE microLoanId=? AND microloan.userId=? AND microloan.loanType = 'Daily' AND microloan.is_deleted=0 ";
                    
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1 , jTextField3.getText());
            pst.setString(2 , User.userid);
            rs = pst.executeQuery();
            
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            microLoanDailyTableSetColumnWidth();
            
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
        
        jTextField2.setText("");
        
        String sql = "SELECT fixLoanId AS Fix_Loan_ID , amountOfLoan AS Amount_of_Loan , interestRate AS Interest_Rate,"
                + "installementAmount AS Installement_Amount , issueDate AS Issue_Date,"
                + "customerdetails.id AS Customer_ID , customerdetails.name AS Customer_Name "
                + "FROM fixloan "
                + "INNER JOIN customerdetails ON (fixloan.customerId=customerdetails.id) "
                + "WHERE microLoanId=? and fixloan.userId=? AND fixloan.is_deleted=0 ";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1 , jTextField4.getText());
            pst.setString(2 , User.userid);
            rs = pst.executeQuery();
            
            jTable2.setModel(DbUtils.resultSetToTableModel(rs));
            fixLoanTableSetColumnWidth();
            
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

    private void jTextField3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyTyped
        
        try{
            numberOnly.NumbersOnly(evt);
        
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "loan System Error");
        }
    }//GEN-LAST:event_jTextField3KeyTyped

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
        
        rdp.setVisible(true);
        rdp.pack();
        rdp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        try{
            String sql = "SELECT installementNo AS Installement_Number , remainingInstallement AS Remaining_Installements, "
                + "microloan.installementAmount AS Installement_Amount , payedAmount AS Payed_Amount,"
                + "payDate AS Pay_Date , remainingAmountOfLoan AS Remaining_Amount "
                + "FROM microloanrepayment "
                + "INNER JOIN customerdetails ON (microloanrepayment.customerId=customerdetails.id) "
                + "INNER JOIN microloan ON (microloanrepayment.microLoanId=microloan.microLoanId)"
                + "WHERE microloan.microLoanId=? AND microloan.loanType='Weekly' AND microloanrepayment.userId=? "
                + "AND microloanrepayment.is_deleted=0 ";
 
            pst=conn.prepareStatement(sql);
            pst.setString(1, loanid);
            pst.setString(2, User.userid);
            rs=pst.executeQuery();
            
            rdp.RepaymentDetailsPopjTable.setModel(DbUtils.resultSetToTableModel(rs));
            rdp.jLabel1.setText("Micro Loan ID :");
            rdp.jLabel8.setText(loanid);
            rdp.jLabel9.setText(amountOfLoan);
            rdp.jLabel10.setText(interestRate);
            rdp.jLabel11.setText(noOfInstallement);
            rdp.jLabel12.setText(loanType);
            rdp.jLabel13.setText(customerId);
            rdp.jLabel14.setText(customerName);


            
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

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyReleased

        jTextField6.setText("");
        
        String sql = "SELECT microLoanId AS Micro_Loan_ID , amountOfLoan AS Amount_of_Loan,"
                    + "interestRate AS Interest_Rate , numberOfInstallement AS No_of_Installement , loanType AS Loan_Type,"
                    + "installementAmount AS Installement_Amount ,issueDate AS Issue_Date , dueDate AS Due_Date ,"
                    + "customerdetails.id AS Customer_ID,customerdetails.name AS Customer_Name "
                    + "FROM microloan "
                    + "INNER JOIN customerdetails ON (microloan.customerId=customerdetails.id) "
                    + "WHERE name=? AND microloan.userId=? AND microloan.loanType='Weekly' AND microloan.is_deleted=0 ";
                    
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1 , jTextField5.getText());
            pst.setString(2 , User.userid);
            rs = pst.executeQuery();
            
            jTable3.setModel(DbUtils.resultSetToTableModel(rs));
            microLoanWeeklyTableSetColumnWidth();
            
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
                    + "WHERE microLoanId=? AND microloan.userId=? AND microloan.loanType = 'Weekly' AND microloan.is_deleted=0 ";
                    
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1 , jTextField6.getText());
            pst.setString(2 , User.userid);
            rs = pst.executeQuery();
            
            jTable3.setModel(DbUtils.resultSetToTableModel(rs));
            microLoanWeeklyTableSetColumnWidth();
            
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
        
        try{
            numberOnly.NumbersOnly(evt);
        
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "loan System Error");
        }
    }//GEN-LAST:event_jTextField6KeyTyped

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        jTextField5.setText("");
        jTextField6.setText("");
        WeeklyMicroLoanTable();
        microLoanWeeklyTableSetColumnWidth();
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
        
        rdp.setVisible(true);
        rdp.pack();
        rdp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        try{
            String sql = "SELECT installementNo AS Installement_Number , remainingInstallement AS Remaining_Installements, "
                + "microloan.installementAmount AS Installement_Amount , payedAmount AS Payed_Amount,"
                + "payDate AS Pay_Date , remainingAmountOfLoan AS Remaining_Amount "
                + "FROM microloanrepayment "
                + "INNER JOIN customerdetails ON (microloanrepayment.customerId=customerdetails.id) "
                + "INNER JOIN microloan ON (microloanrepayment.microLoanId=microloan.microLoanId)"
                + "WHERE microloan.microLoanId=? AND microloan.loanType='Monthly' AND microloanrepayment.userId=? "
                + "AND microloanrepayment.is_deleted=0 ";
 
            pst=conn.prepareStatement(sql);
            pst.setString(1, loanid);
            pst.setString(2, User.userid);
            rs=pst.executeQuery();
            
            rdp.RepaymentDetailsPopjTable.setModel(DbUtils.resultSetToTableModel(rs));
            rdp.jLabel1.setText("Micro Loan ID :");
            rdp.jLabel8.setText(loanid);
            rdp.jLabel9.setText(amountOfLoan);
            rdp.jLabel10.setText(interestRate);
            rdp.jLabel11.setText(noOfInstallement);
            rdp.jLabel12.setText(loanType);
            rdp.jLabel13.setText(customerId);
            rdp.jLabel14.setText(customerName);


            
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

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyReleased
        
        jTextField8.setText("");
        
        String sql = "SELECT microLoanId AS Micro_Loan_ID , amountOfLoan AS Amount_of_Loan,"
                    + "interestRate AS Interest_Rate , numberOfInstallement AS No_of_Installement , loanType AS Loan_Type,"
                    + "installementAmount AS Installement_Amount ,issueDate AS Issue_Date , dueDate AS Due_Date ,"
                    + "customerdetails.id AS Customer_ID,customerdetails.name AS Customer_Name "
                    + "FROM microloan "
                    + "INNER JOIN customerdetails ON (microloan.customerId=customerdetails.id) "
                    + "WHERE name=? AND microloan.userId=? AND microloan.loanType='Monthly' AND microloan.is_deleted=0 ";
                    
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1 , jTextField7.getText());
            pst.setString(2 , User.userid);
            rs = pst.executeQuery();
            
            jTable4.setModel(DbUtils.resultSetToTableModel(rs));
            microLoanMonthlyTableSetColumnWidth();
            
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
                    + "WHERE microLoanId=? AND microloan.userId=? AND microloan.loanType = 'Monthly' AND microloan.is_deleted=0 ";
                    
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1 , jTextField8.getText());
            pst.setString(2 , User.userid);
            rs = pst.executeQuery();
            
            jTable4.setModel(DbUtils.resultSetToTableModel(rs));
            microLoanMonthlyTableSetColumnWidth();
            
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
        
        try{
            numberOnly.NumbersOnly(evt);
        
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "loan System Error");
        }
    }//GEN-LAST:event_jTextField8KeyTyped

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        jTextField7.setText("");
        jTextField8.setText("");
        MonthlyMicroLoanTable();
        microLoanMonthlyTableSetColumnWidth();
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(RepaymentDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RepaymentDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RepaymentDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RepaymentDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RepaymentDetails().setVisible(true);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
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
