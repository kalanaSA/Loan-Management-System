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
        super("Finished Loans Details");
        initComponents();
        setExtendedState(FinishedLoans.MAXIMIZED_BOTH);
        conn = DBconnect.connect();
        setIcon();
        
        finishedDailyMicroLoanTable();
        finishedWeeklyMicroLoanTable();
        finishedMonthlyMicroLoanTable();
        finishedFixLoanTable();
        
        microLoanDailyTableSetColumnWidth();
        microLoanWeeklyTableSetColumnWidth();
        microLoanMonthlyTableSetColumnWidth();
        fixLoanTableSetColumnWidth();
        
        customerdetailsFetch();
        
    }
    

    public void finishedDailyMicroLoanTable(){
        
        String sql ="SELECT microLoanId AS Micro_Loan_ID,amountOfLoan AS Capital,interestRate AS Interest_Rate,"
                + "numberOfInstallement AS NO_of_Installement,loanType AS Loan_Type,"
                + "installementAmount AS Installement_Amount,"
                + "issueDate AS Issue_Date,dueDate AS Due_Date,customerId AS Customer_ID,"
                + "customerdetails.name AS Customer_Name "
                + "FROM microloan "
                + "INNER JOIN customerdetails ON (microloan.customerId=customerdetails.id) "
                + "WHERE microloan.loanType='Daily' AND microloan.is_deleted=1 ";
        
        try{
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Can't fetch data from database, check internet connection & try again!");
        }finally{
            try{
                rs.close();
                pst.close();
            }catch(Exception e){

            }
        }
        
    }
    
    public void finishedWeeklyMicroLoanTable(){
        
        String sql ="SELECT microLoanId AS Micro_Loan_ID,amountOfLoan AS Capital,interestRate AS Interest_Rate,"
                + "numberOfInstallement AS NO_of_Installement,loanType AS Loan_Type,"
                + "installementAmount AS Installement_Amount,"
                + "issueDate AS Issue_Date,dueDate AS Due_Date,customerId AS Customer_ID,"
                + "customerdetails.name AS Customer_Name "
                + "FROM microloan "
                + "INNER JOIN customerdetails ON (microloan.customerId=customerdetails.id) "
                + "WHERE microloan.loanType='Weekly' AND microloan.is_deleted=1 ";
        
        try{
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            jTable3.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Can't fetch data from database, check internet connection & try again!");
        }finally{
            try{
                rs.close();
                pst.close();
            }catch(Exception e){

            }
        }
        
    }
    
    public void finishedMonthlyMicroLoanTable(){
        
        String sql ="SELECT microLoanId AS Micro_Loan_ID,amountOfLoan AS Capital,interestRate AS Interest_Rate,"
                + "numberOfInstallement AS NO_of_Installement,loanType AS Loan_Type,"
                + "installementAmount AS Installement_Amount,"
                + "issueDate AS Issue_Date,dueDate AS Due_Date,customerId AS Customer_ID,"
                + "customerdetails.name AS Customer_Name "
                + "FROM microloan "
                + "INNER JOIN customerdetails ON (microloan.customerId=customerdetails.id) "
                + "WHERE microloan.loanType='Monthly' AND microloan.is_deleted=1 ";
        
        try{
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            jTable4.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Can't fetch data from database, check internet connection & try again!");
        }finally{
            try{
                rs.close();
                pst.close();
            }catch(Exception e){

            }
        }
        
    }
    
    public void finishedFixLoanTable(){
        
        String sql ="SELECT fixLoanId AS Fix_Loan_ID,amountOfLoan AS Capital,interestRate AS Interest_Rate,"
                + "installementAmount AS Installement_Amount,"
                + "issueDate AS Issue_Date,customerId AS Customer_ID,customerdetails.name AS Customer_Name "
                + "FROM fixloan "
                + "INNER JOIN customerdetails ON (fixloan.customerId=customerdetails.id) "
                + "WHERE fixloan.is_deleted=1 ";
        
        try{
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            jTable2.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Can't fetch data from database, check internet connection & try again!");
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
        
        public void customerdetailsFetch(){
        
        String sql = "SELECT id,name,nic From customerdetails WHERE userId=? AND is_deleted=0" ;
        
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1 , User.userid);
            rs = pst.executeQuery();
            
            while(rs.next()){
//                String id = rs.getString("id");
                String name = rs.getString("name");
//                String nic = rs.getString("nic");
//                String sentence = name;
                

                jComboBox4.addItem(name);
                jComboBox3.addItem(name);
                jComboBox2.addItem(name);
                jComboBox1.addItem(name);
            }
  
        }catch(Exception e){
            
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
        jButton1 = new javax.swing.JButton();
        jComboBox4 = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

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
        jLabel1.setText("Search Name/ID/Loan ID :");

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

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select the name" }));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
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
                .addGap(58, 58, 58)
                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jButton1)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        jLabel5.setText("Search Name/ID/Loan ID :");

        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField5KeyReleased(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton3.setText("Refresh");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select the name" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
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
                .addGap(58, 58, 58)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
        jLabel7.setText("Search Name/ID/Loan ID :");

        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField7KeyReleased(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton4.setText("Refresh");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select the name" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
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
                .addGap(58, 58, 58)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jButton4)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        jLabel3.setText("Search Name/ID/Loan ID :");

        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setText("Refresh");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select the name" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
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
                .addGap(58, 58, 58)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2))
                    .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE))
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
            .addComponent(jTabbedPane1)
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
            //change******************
            String sql = "SELECT installementNo AS Installement_Number ,installementAge AS Installement_Age , "
                + "remainingInstallement AS Remaining_Installements, "
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
                + "payedAmount AS Payed_Amount "
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
        
        
        String sql = "SELECT microLoanId AS Micro_Loan_ID , amountOfLoan AS Capital,"
        + "interestRate AS Interest_Rate , numberOfInstallement AS NO_of_Installement , loanType AS Loan_Type,"
        + "installementAmount AS Installement_Amount ,issueDate AS Issue_Date , dueDate AS Due_Date ,"
        + "customerdetails.id AS Customer_ID,customerdetails.name AS Customer_Name "
        + "FROM microloan "
        + "INNER JOIN customerdetails ON (microloan.customerId=customerdetails.id) "
        + "WHERE name=? AND microloan.userId='"+User.userid+"' AND loanType='Daily' AND microloan.is_deleted=1 "
                + "OR id=? AND microloan.userId='"+User.userid+"' AND loanType='Daily' AND microloan.is_deleted=1 "
                + "OR microLoanId=? AND microloan.userId='"+User.userid+"' AND loanType='Daily' AND microloan.is_deleted=1 ";
                    
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1 , jTextField1.getText());
            pst.setString(2 , jTextField1.getText());
            pst.setString(3 , jTextField1.getText());
            rs = pst.executeQuery();
            
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            microLoanDailyTableSetColumnWidth();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Can't fetch data from database, check internet connection & try again!");
        }finally{
            try{
                rs.close();
                pst.close();
            }catch(Exception e){
                
            }
        }
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased

        
        String sql = "SELECT fixLoanId AS Fix_Loan_ID , amountOfLoan AS Capital , interestRate AS Interest_Rate,"
        + "installementAmount AS Installement_Amount , issueDate AS Issue_Date,"
        + "customerdetails.id AS Customer_ID , customerdetails.name AS Customer_Name "
        + "FROM fixloan "
        + "INNER JOIN customerdetails ON (fixloan.customerId=customerdetails.id) "
        + "WHERE name=? AND fixloan.userId='"+User.userid+"' AND fixloan.is_deleted=1 "
                + "OR id=? AND fixloan.userId='"+User.userid+"' AND fixloan.is_deleted=1 "
                + "OR fixLoanId=? AND fixloan.userId='"+User.userid+"' AND fixloan.is_deleted=1 ";
        
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1 , jTextField3.getText());
            pst.setString(2 , jTextField3.getText());
            pst.setString(3 , jTextField3.getText());
            rs = pst.executeQuery();

            jTable2.setModel(DbUtils.resultSetToTableModel(rs));
            fixLoanTableSetColumnWidth();

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Can't fetch data from database, check internet connection & try again!");
        }finally{
            try{
                rs.close();
                pst.close();
            }catch(Exception e){

            }
        }
    }//GEN-LAST:event_jTextField3KeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        jTextField3.setText("");
        finishedFixLoanTable();
        fixLoanTableSetColumnWidth();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        jTextField1.setText("");
        finishedDailyMicroLoanTable();
        microLoanDailyTableSetColumnWidth();
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
            String sql = "SELECT installementNo AS Installement_Number ,installementAge AS Installement_Age ,"
                + " remainingInstallement AS Remaining_Installements, "
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
        
        
        String sql = "SELECT microLoanId AS Micro_Loan_ID , amountOfLoan AS Capital,"
                    + "interestRate AS Interest_Rate , numberOfInstallement AS NO_of_Installement , loanType AS Loan_Type,"
                    + "installementAmount AS Installement_Amount ,issueDate AS Issue_Date , dueDate AS Due_Date ,"
                    + "customerdetails.id AS Customer_ID,customerdetails.name AS Customer_Name "
                    + "FROM microloan "
                    + "INNER JOIN customerdetails ON (microloan.customerId=customerdetails.id) "
                    + "WHERE name=? AND microloan.userId='"+User.userid+"' AND loanType='Weekly' AND microloan.is_deleted=1 "
                            + "OR id=? AND microloan.userId='"+User.userid+"' AND loanType='Weekly' AND microloan.is_deleted=1 "
                            + "OR microLoanId=? AND microloan.userId='"+User.userid+"' AND loanType='Weekly' AND microloan.is_deleted=1 ";
                    
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1 , jTextField5.getText());
            pst.setString(2 , jTextField5.getText());
            pst.setString(3 , jTextField5.getText());
            rs = pst.executeQuery();
            
            jTable3.setModel(DbUtils.resultSetToTableModel(rs));
            microLoanWeeklyTableSetColumnWidth();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Can't fetch data from database, check internet connection & try again!");
        }finally{
            try{
                rs.close();
                pst.close();
            }catch(Exception e){
                
            }
        }
    }//GEN-LAST:event_jTextField5KeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        jTextField5.setText("");
        finishedWeeklyMicroLoanTable();
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
        
        flp.setVisible(true);
        flp.pack();
        flp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        try{
            String sql = "SELECT installementNo AS Installement_Number ,installementAge AS Installement_Age , "
                + "remainingInstallement AS Remaining_Installements, "
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
        
        
        String sql = "SELECT microLoanId AS Micro_Loan_ID , amountOfLoan AS Capital,"
        + "interestRate AS Interest_Rate , numberOfInstallement AS NO_of_Installement , loanType AS Loan_Type,"
        + "installementAmount AS Installement_Amount ,issueDate AS Issue_Date , dueDate AS Due_Date ,"
        + "customerdetails.id AS Customer_ID,customerdetails.name AS Customer_Name "
        + "FROM microloan "
        + "INNER JOIN customerdetails ON (microloan.customerId=customerdetails.id) "
        + "WHERE name=? AND microloan.userId='"+User.userid+"' AND loanType='Monthly' AND microloan.is_deleted=1 "
                            + "OR id=? AND microloan.userId='"+User.userid+"' AND loanType='Monthly' AND microloan.is_deleted=1 "
                            + "OR microLoanId=? AND microloan.userId='"+User.userid+"' AND loanType='Monthly' AND microloan.is_deleted=1 ";
                    
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1 , jTextField7.getText());
            pst.setString(2 , jTextField7.getText());
            pst.setString(3 , jTextField7.getText());
            rs = pst.executeQuery();
            
            jTable4.setModel(DbUtils.resultSetToTableModel(rs));
            microLoanMonthlyTableSetColumnWidth();

            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Can't fetch data from database, check internet connection & try again!");
        }finally{
            try{
                rs.close();
                pst.close();
            }catch(Exception e){
                
            }
        }
    }//GEN-LAST:event_jTextField7KeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        jTextField7.setText("");
        finishedMonthlyMicroLoanTable();
        microLoanMonthlyTableSetColumnWidth();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseEntered

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        
        finishedDailyMicroLoanTable();
        finishedWeeklyMicroLoanTable();
        finishedMonthlyMicroLoanTable();
        finishedFixLoanTable();
        
        jTextField1.setText("");
        jTextField5.setText("");
        jTextField7.setText("");
        jTextField3.setText("");
        
        microLoanDailyTableSetColumnWidth();
        microLoanWeeklyTableSetColumnWidth();
        microLoanMonthlyTableSetColumnWidth();
        fixLoanTableSetColumnWidth();
        
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        
        jTextField1.setText("");
        
        String sql = "SELECT microLoanId AS Micro_Loan_ID , amountOfLoan AS Capital,"
        + "interestRate AS Interest_Rate , numberOfInstallement AS NO_of_Installement , loanType AS Loan_Type,"
        + "installementAmount AS Installement_Amount ,issueDate AS Issue_Date , dueDate AS Due_Date ,"
        + "customerdetails.id AS Customer_ID,customerdetails.name AS Customer_Name "
        + "FROM microloan "
        + "INNER JOIN customerdetails ON (microloan.customerId=customerdetails.id) "
        + "WHERE name=? AND microloan.userId='"+User.userid+"' AND loanType='Daily' AND microloan.is_deleted=1 ";
                    
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1 , jComboBox4.getSelectedItem().toString());
            rs = pst.executeQuery();
            
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            microLoanDailyTableSetColumnWidth();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Can't fetch data from database, check internet connection & try again!");
        }finally{
            try{
                rs.close();
                pst.close();
            }catch(Exception e){
                
            }
        }
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        
        jTextField5.setText("");
        
        String sql = "SELECT microLoanId AS Micro_Loan_ID , amountOfLoan AS Capital,"
                    + "interestRate AS Interest_Rate , numberOfInstallement AS NO_of_Installement , loanType AS Loan_Type,"
                    + "installementAmount AS Installement_Amount ,issueDate AS Issue_Date , dueDate AS Due_Date ,"
                    + "customerdetails.id AS Customer_ID,customerdetails.name AS Customer_Name "
                    + "FROM microloan "
                    + "INNER JOIN customerdetails ON (microloan.customerId=customerdetails.id) "
                    + "WHERE name=? AND microloan.userId='"+User.userid+"' AND loanType='Weekly' AND microloan.is_deleted=1 ";
                    
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1 , jComboBox3.getSelectedItem().toString());
            rs = pst.executeQuery();
            
            jTable3.setModel(DbUtils.resultSetToTableModel(rs));
            microLoanWeeklyTableSetColumnWidth();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Can't fetch data from database, check internet connection & try again!");
        }finally{
            try{
                rs.close();
                pst.close();
            }catch(Exception e){
                
            }
        }
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        
        jTextField7.setText("");
        
        String sql = "SELECT microLoanId AS Micro_Loan_ID , amountOfLoan AS Capital,"
        + "interestRate AS Interest_Rate , numberOfInstallement AS NO_of_Installement , loanType AS Loan_Type,"
        + "installementAmount AS Installement_Amount ,issueDate AS Issue_Date , dueDate AS Due_Date ,"
        + "customerdetails.id AS Customer_ID,customerdetails.name AS Customer_Name "
        + "FROM microloan "
        + "INNER JOIN customerdetails ON (microloan.customerId=customerdetails.id) "
        + "WHERE name=? AND microloan.userId='"+User.userid+"' AND loanType='Monthly' AND microloan.is_deleted=1 ";
                    
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1 , jComboBox2.getSelectedItem().toString());
            rs = pst.executeQuery();
            
            jTable4.setModel(DbUtils.resultSetToTableModel(rs));
            microLoanMonthlyTableSetColumnWidth();

            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Can't fetch data from database, check internet connection & try again!");
        }finally{
            try{
                rs.close();
                pst.close();
            }catch(Exception e){
                
            }
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        
        jTextField3.setText("");
        
        String sql = "SELECT fixLoanId AS Fix_Loan_ID , amountOfLoan AS Capital , interestRate AS Interest_Rate,"
        + "installementAmount AS Installement_Amount , issueDate AS Issue_Date,"
        + "customerdetails.id AS Customer_ID , customerdetails.name AS Customer_Name "
        + "FROM fixloan "
        + "INNER JOIN customerdetails ON (fixloan.customerId=customerdetails.id) "
        + "WHERE name=? AND fixloan.userId='"+User.userid+"' AND fixloan.is_deleted=1 ";
        
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1 , jComboBox1.getSelectedItem().toString());
            rs = pst.executeQuery();

            jTable2.setModel(DbUtils.resultSetToTableModel(rs));
            fixLoanTableSetColumnWidth();

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Can't fetch data from database, check internet connection & try again!");
        }finally{
            try{
                rs.close();
                pst.close();
            }catch(Exception e){

            }
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
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
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
    
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/loan.png")));
    }

}
