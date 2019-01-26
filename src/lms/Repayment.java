package lms;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import net.proteanit.sql.DbUtils;

public class Repayment extends javax.swing.JFrame {
    
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    
    User numberOnly = new User();
 

    public Repayment() {
        super("Repayment");
        initComponents();
        setExtendedState(Repayment.MAXIMIZED_BOTH);
        conn = DBconnect.connect();
        jLabel24.setText(String.valueOf(User.username));
        jLabel32.setText(String.valueOf(User.username));
        jLabel43.setText(String.valueOf(User.username));
        jLabel26.setText(String.valueOf(User.username));
        
        dailyMicroLoanTable();
        weeklyMicroLoanTable();
        monthlyMicroLoanTable();
        fixLoanTable();
        
        setIcon();
        jDateChooser1.setDate(new Date());
        jDateChooser3.setDate(new Date());
        jDateChooser4.setDate(new Date());
        jDateChooser2.setDate(new Date());
            
        microLoanDailyTableSetColumnWidth();
        microLoanWeeklyTableSetColumnWidth();
        microLoanMonthlyTableSetColumnWidth();
        fixLoanTableSetColumnWidth();
        
        customerdetailsFetch();

    }
    
    
        public void dailyMicroLoanTable(){
        
        try{
            String sql = "SELECT microLoanId AS Micro_Loan_ID , amountOfLoan AS Capital,"
                    + "interestRate AS Interest_Rate , numberOfInstallement AS No_of_Installement , loanType AS Loan_Type,"
                    + "installementAmount AS Installement_Amount ,issueDate AS Issue_Date , dueDate AS Due_Date ,"
                    + "customerdetails.id AS Customer_ID,customerdetails.name AS Customer_Name "
                    + "FROM microloan "
                    + "INNER JOIN customerdetails ON (microloan.customerId=customerdetails.id) "
                    + "WHERE microloan.userId=? AND loanType='Daily' AND microloan.is_deleted=0 ";
            
            pst = conn.prepareStatement(sql);
            pst.setString(1, User.userid);
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
        public void weeklyMicroLoanTable(){
        
        try{
            String sql = "SELECT microLoanId AS Micro_Loan_ID , amountOfLoan AS Capital,"
                    + "interestRate AS Interest_Rate , numberOfInstallement AS No_of_Installement , loanType AS Loan_Type,"
                    + "installementAmount AS Installement_Amount ,issueDate AS Issue_Date , dueDate AS Due_Date ,"
                    + "customerdetails.id AS Customer_ID,customerdetails.name AS Customer_Name "
                    + "FROM microloan "
                    + "INNER JOIN customerdetails ON (microloan.customerId=customerdetails.id) "
                    + "WHERE microloan.userId=? AND loanType='Weekly' AND microloan.is_deleted=0 ";
            
            pst = conn.prepareStatement(sql);
            pst.setString(1, User.userid);
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
        public void monthlyMicroLoanTable(){
        
        try{
            String sql = "SELECT microLoanId AS Micro_Loan_ID , amountOfLoan AS Capital,"
                    + "interestRate AS Interest_Rate , numberOfInstallement AS No_of_Installement , loanType AS Loan_Type,"
                    + "installementAmount AS Installement_Amount ,issueDate AS Issue_Date , dueDate AS Due_Date ,"
                    + "customerdetails.id AS Customer_ID,customerdetails.name AS Customer_Name "
                    + "FROM microloan "
                    + "INNER JOIN customerdetails ON (microloan.customerId=customerdetails.id) "
                    + "WHERE microloan.userId=? AND loanType='Monthly' AND microloan.is_deleted=0 ";
            
            pst = conn.prepareStatement(sql);
            pst.setString(1, User.userid);
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
        
    public void fixLoanTable(){
        
        try{
            
        String sql = "SELECT fixLoanId AS Fix_Loan_ID , amountOfLoan AS Capital , interestRate AS Interest_Rate,"
                + "installementAmount AS Installement_Amount , issueDate AS Issue_Date,"
                + "customerdetails.id AS Customer_ID , customerdetails.name AS Customer_Name "
                + "FROM fixloan "
                + "INNER JOIN customerdetails ON (fixloan.customerId=customerdetails.id) "
                + "WHERE fixloan.userId=? AND fixloan.is_deleted=0 ";
        
        pst = conn.prepareStatement(sql);
        pst.setString(1, User.userid);
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
    
    public void dailyMicroLoanClearAll(){
        txt_search.setText("");
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField7.setText("");
        jTextField8.setText("");
        jTextField23.setText("");
        txt_minstallementNo.setText("");
        jDateChooser1.setDate(new Date());
    }
    public void weeklyMicroLoanClearAll(){
        txt_search1.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField15.setText("");
        jTextField16.setText("");
        jTextField11.setText("");
        jTextField12.setText("");
        jTextField24.setText("");
        txt_minstallementNo1.setText("");
        jDateChooser3.setDate(new Date());
    }
    public void monthlyMicroLoanClearAll(){
        txt_search3.setText("");
        jTextField19.setText("");
        jTextField20.setText("");
        jTextField21.setText("");
        jTextField22.setText("");
        jTextField17.setText("");
        jTextField18.setText("");
        jTextField25.setText("");
        txt_minstallementNo2.setText("");
        jDateChooser4.setDate(new Date());
    }
    
    public void fixLoanClearAll(){
        txt_search2.setText("");
        jTextField9.setText("");
        jTextField10.setText("");
        jTextField13.setText("");
        jTextField14.setText("");
        txt_finstallementNo.setText("");
        jDateChooser2.setDate(new Date());
    }
    
    
    //set column width jtable 3 (microLoanDailyTable)
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
        
        //set column width jtable 4 (microLoanWeeklyTable)
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
        
        //set column width jtable 5 (microLoanMonthlyTable)
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
        

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_search = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txt_minstallementNo = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        jTextField23 = new javax.swing.JTextField();
        jComboBox4 = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txt_minstallementNo1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txt_search1 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel45 = new javax.swing.JLabel();
        jTextField24 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        txt_minstallementNo2 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jButton17 = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jTextField21 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        txt_search3 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel46 = new javax.swing.JLabel();
        jTextField25 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txt_finstallementNo = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        txt_search2 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jButton10 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Search Customer Name/ID/Loan ID : ");

        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchKeyReleased(evt);
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
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Customer ID");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Name");

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.setEditable(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Loan ID");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Loan Type");

        jTextField5.setEditable(false);
        jTextField5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jTextField6.setEditable(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Number of Installemnt");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 51, 51));
        jButton1.setText("PAY");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton3.setText("Cancel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Installement Amount");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Pay Date");

        jTextField7.setEditable(false);

        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField8KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField8KeyTyped(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setText("Installement No : ");

        txt_minstallementNo.setEditable(false);

        jLabel25.setText("Logged In As :");

        jLabel26.setText("username");

        jButton11.setText("Refresh");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton22.setText("change");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel44.setText("Installement Age");

        jTextField23.setEditable(false);

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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel26)
                        .addGap(250, 250, 250)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_minstallementNo, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel44))
                        .addGap(81, 81, 81)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(162, 162, 162)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField6)
                    .addComponent(jTextField5)
                    .addComponent(jTextField7)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton22)
                .addContainerGap(161, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField6)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(txt_minstallementNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel44)
                                        .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton22)))
                                .addGap(18, 18, 18)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3))
                        .addGap(22, 22, 22))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 177, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26))
                        .addContainerGap())))
        );

        jTabbedPane1.addTab("Daily Micro Loan Repayments", jPanel1);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Installement Amount");

        jTextField11.setEditable(false);

        jTextField12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField12KeyTyped(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel27.setText("Installement No : ");

        txt_minstallementNo1.setEditable(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Customer ID");

        jButton12.setText("Refresh");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Name");

        jTextField3.setEditable(false);
        jTextField3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jTextField4.setEditable(false);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Loan ID");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("Loan Type");

        jTextField15.setEditable(false);
        jTextField15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jTextField16.setEditable(false);

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setText("Search Customer Name/ID/Loan ID : ");

        txt_search1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_search1KeyReleased(evt);
            }
        });

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

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel29.setText("Number of Installemnt");

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel30.setText("Pay Date");

        jLabel31.setText("Logged In As :");

        jLabel32.setText("username");

        jButton13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 51, 51));
        jButton13.setText("PAY");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton14.setText("Clear");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton15.setText("Cancel");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton23.setText("change");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select the name" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel45.setText("Installement Age");

        jTextField24.setEditable(false);
        jTextField24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField24ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel32)
                        .addGap(250, 250, 250)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_search1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)))))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_minstallementNo1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel45)
                                .addGap(81, 81, 81))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(77, 77, 77)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(162, 162, 162)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel12)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField16)
                    .addComponent(jTextField15)
                    .addComponent(jTextField11)
                    .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton23)
                .addContainerGap(161, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(txt_search1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField15))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextField16)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(txt_minstallementNo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton23)
                                    .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel45))
                                .addGap(18, 18, 18)
                                .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton13)
                            .addComponent(jButton14)
                            .addComponent(jButton15))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(jLabel32))
                        .addContainerGap())))
        );

        jTabbedPane1.addTab("Weekly Micro Loan Repayment", jPanel2);

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel33.setText("Installement Amount");

        jTextField17.setEditable(false);

        jTextField18.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField18KeyTyped(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel34.setText("Installement No : ");

        txt_minstallementNo2.setEditable(false);

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel35.setText("Customer ID");

        jButton17.setText("Refresh");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel36.setText("Name");

        jTextField19.setEditable(false);
        jTextField19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField19ActionPerformed(evt);
            }
        });

        jTextField20.setEditable(false);

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel37.setText("Loan ID");

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel38.setText("Loan Type");

        jTextField21.setEditable(false);
        jTextField21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jTextField22.setEditable(false);

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel39.setText("Search Customer Name/ID/Loan ID : ");

        txt_search3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_search3KeyReleased(evt);
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
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable4);

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel40.setText("Number of Installemnt");

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel41.setText("Pay Date");

        jLabel42.setText("Logged In As :");

        jLabel43.setText("username");

        jButton18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton18.setForeground(new java.awt.Color(255, 51, 51));
        jButton18.setText("PAY");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton19.setText("Clear");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton20.setText("Cancel");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton24.setText("change");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select the name" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel46.setText("Installement Age");

        jTextField25.setEditable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel43)
                        .addGap(250, 250, 250)
                        .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel39)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_search3, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)))))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                        .addComponent(txt_minstallementNo2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35)
                            .addComponent(jLabel36)
                            .addComponent(jLabel46))
                        .addGap(81, 81, 81)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                            .addComponent(jTextField20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                            .addComponent(jTextField25, javax.swing.GroupLayout.Alignment.LEADING))))
                .addGap(162, 162, 162)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38)
                    .addComponent(jLabel37)
                    .addComponent(jLabel40)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField22)
                    .addComponent(jTextField21)
                    .addComponent(jTextField17)
                    .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton24)
                .addContainerGap(161, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(txt_search3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField21))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jTextField22)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(txt_minstallementNo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton24)
                                    .addComponent(jLabel46)
                                    .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel41, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton18)
                            .addComponent(jButton19)
                            .addComponent(jButton20))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel42)
                            .addComponent(jLabel43))
                        .addContainerGap())))
        );

        jTabbedPane1.addTab("Monthly MicroLoan Repayment", jPanel3);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setText("Installement Amount");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setText("Installement No : ");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setText("Pay Date");

        txt_finstallementNo.setEditable(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Search Customer Name/ID/Loan ID : ");

        jTextField13.setEditable(false);

        txt_search2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_search2KeyReleased(evt);
            }
        });

        jTextField14.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField14KeyTyped(evt);
            }
        });

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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable2MouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jButton10.setText("Refresh");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Customer ID");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Name");

        jTextField9.setEditable(false);

        jTextField10.setEditable(false);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("If customer not payed last time installement click here!");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setText("Loan ID");

        jButton9.setText("NOT PAYED");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel17.setText("Logged In As :");

        jLabel24.setText("username");

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 51, 51));
        jButton4.setText("PAY");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton5.setText("Clear");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton6.setText("Cancel");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 0, 0));
        jButton7.setText("PAY & CLOSE");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select the name" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel15))
                                        .addGap(46, 46, 46)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel23)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_finstallementNo, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel19))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField13)
                                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(74, 74, 74)
                                        .addComponent(jLabel22))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(195, 195, 195)
                                        .addComponent(jButton9))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(233, 233, 233)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel24)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_search2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txt_search2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton10))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel18)
                                .addComponent(jLabel23)
                                .addComponent(txt_finstallementNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel22)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton9)
                                .addComponent(jLabel19))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jTextField10, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                                        .addGap(1, 1, 1))))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel24))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Fix Loan Repayment", jPanel4);

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

        setSize(new java.awt.Dimension(1329, 712));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        int x = JOptionPane.showConfirmDialog(null, "Are you sure you want finished this record?");
        if(x==0){

            //firstly add this last repayment into fixloanrepayment
            String s = "INSERT INTO fixloanrepayment(installementNo,payDate,payedAmount,"
            + "customerId,fixLoanId,userId,is_deleted) "
            + "VALUES(?,?,?,?,?,?,0)";

            try{
                pst = conn.prepareStatement(s);
                pst.setString(1, txt_finstallementNo.getText());
                pst.setString(2, ((JTextField)jDateChooser2.getDateEditor().getUiComponent()).getText());
                pst.setString(3, jTextField14.getText());
                pst.setString(4, jTextField9.getText());
                pst.setString(5, jTextField13.getText());
                pst.setString(6, User.userid);
                pst.execute();

                JOptionPane.showMessageDialog(null, "Repayment record added successfully!");
                jDateChooser2.setDate(new Date());

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);

            }
            
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            //delete from fixloanrepayment
            String sq = "UPDATE fixloanrepayment SET is_deleted = 1 , time_stamp = '"+timestamp+"' "
            + "WHERE fixLoanId=? AND customerId=? AND userId=?";

            try{
                pst = conn.prepareStatement(sq);
                pst.setString(1, jTextField13.getText());
                pst.setString(2, jTextField9.getText());
                pst.setString(3, User.userid);
                pst.execute();

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }

            //also delete fixloan details
            String sql = "UPDATE fixloan SET is_deleted = 1 , time_stamp = '"+timestamp+"' "
            + "WHERE fixLoanId=? AND customerId=? AND userId=? ";

            try{
                pst = conn.prepareStatement(sql);
                pst.setString(1, jTextField13.getText());
                pst.setString(2, jTextField9.getText());
                pst.setString(3, User.userid);
                pst.execute();

                fixLoanTable();
                fixLoanClearAll();
                JOptionPane.showMessageDialog(null, "This customer payed all installement successfully!");

            }catch(Exception e){

                JOptionPane.showMessageDialog(null, e);

            }
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        fixLoanClearAll();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        String sql = "INSERT INTO fixloanrepayment(installementNo,payDate,payedAmount,is_deleted,"
        + "customerId,fixLoanId,userId) "
        + "VALUES(?,?,?,0,?,?,?)";

        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_finstallementNo.getText());
            pst.setString(2, ((JTextField)jDateChooser2.getDateEditor().getUiComponent()).getText());
            pst.setString(3, jTextField14.getText());
            pst.setString(4, jTextField9.getText());
            pst.setString(5, jTextField13.getText());
            pst.setString(6, User.userid);
            pst.execute();

            JOptionPane.showMessageDialog(null, "Repayment record added successfully!");
            fixLoanTable();
            fixLoanClearAll();
            fixLoanTableSetColumnWidth();
            jDateChooser2.setDate(new Date());

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);

        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        try{
            String sql = "SELECT * FROM fixloan WHERE fixLoanId=? AND customerId=? AND userId=? ";

            pst = conn.prepareStatement(sql);
            pst.setString(1, jTextField13.getText());
            pst.setString(2, jTextField9.getText());
            pst.setString(3, User.userid);
            rs = pst.executeQuery();

            if(rs.next()){
                String aol = rs.getString("amountOfLoan");
                double amountofloan = Double.parseDouble(aol);
                String ir = rs.getString("interestRate");
                double interestrate = Double.parseDouble(ir);
                String im = jTextField14.getText();
                double installementamount = Double.parseDouble(im);

                double newAmountofloan = amountofloan+installementamount;
                double roundedNewAmountofloan = Math.round(newAmountofloan * 100.0)/100.0;
                double newInstallementAmount =  roundedNewAmountofloan * interestrate/100;
                double roundedNewInstallementamount = Math.round(newInstallementAmount * 100.0)/100.0;
                String n = String.valueOf(roundedNewInstallementamount);

                String sq = "UPDATE fixloan "
                + "SET installementAmount='"+roundedNewInstallementamount+"' , amountOfLoan = '"+roundedNewAmountofloan+"' "
                + "WHERE fixLoanId='"+jTextField13.getText()+"' AND customerId='"+jTextField9.getText()+"' "
                + "AND userId='"+User.userid+"' " ;

                pst = conn.prepareStatement(sq);
                pst.execute();

                JOptionPane.showMessageDialog(null, "Noticed & update installement amount and amount of loan!");
                fixLoanTable();
                fixLoanTableSetColumnWidth();
                fixLoanClearAll();

            }

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }finally{
            try{
                rs.close();
                pst.close();
            }catch(Exception e){

            }

        }

    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed

        fixLoanClearAll();
        fixLoanTable();
        fixLoanTableSetColumnWidth();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jTable2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2MouseEntered

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked

        int r = jTable2.getSelectedRow();

        String customerid = jTable2.getValueAt(r, 5).toString();
        String name = jTable2.getValueAt(r, 6).toString();
        String loanid = jTable2.getValueAt(r, 0).toString();
        String installementamount = jTable2.getValueAt(r, 3).toString();

        jTextField9.setText(customerid);
        jTextField10.setText(name);
        jTextField13.setText(loanid);
        jTextField14.setText(installementamount);
       
        
        
        String sql = "SELECT COUNT(installementNo) "
                    + "FROM fixloanrepayment "
                    + "WHERE fixLoanId = ? AND customerId=? AND userId=? ";
            
            try{
                
                pst = conn.prepareStatement(sql);
                pst.setString(1 , jTextField13.getText());
                pst.setString(2 , jTextField9.getText());
                pst.setString(3 , User.userid);
                rs = pst.executeQuery();
                
                if(rs.next()){
                
                    String inc = rs.getString("COUNT(installementNo)");
                    int installementNoCount = Integer.parseInt(inc);
                    int installementNo = installementNoCount+1;
                    String f = String.valueOf(installementNo);
                    txt_finstallementNo.setText(f);
                    
                }
                
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

    private void txt_search2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_search2KeyReleased

        
        String sql = "SELECT fixLoanId AS Fix_Loan_ID , amountOfLoan AS Capital , interestRate AS Interest_Rate,"
        + "installementAmount AS Installement_Amount , issueDate AS Issue_Date,"
        + "customerdetails.id AS Customer_ID , customerdetails.name AS Customer_Name "
        + "FROM fixloan "
        + "INNER JOIN customerdetails ON (fixloan.customerId=customerdetails.id) "
        + "WHERE name=? AND fixloan.userId='"+User.userid+"' AND fixloan.is_deleted=0 "
                + "OR id=? AND fixloan.userId='"+User.userid+"' AND fixloan.is_deleted=0 "
                + "OR fixLoanId=? AND fixloan.userId='"+User.userid+"' AND fixloan.is_deleted=0 ";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1 , txt_search2.getText());
            pst.setString(2 , txt_search2.getText());
            pst.setString(3 , txt_search2.getText());
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

    }//GEN-LAST:event_txt_search2KeyReleased

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        
        dailyMicroLoanClearAll();
        dailyMicroLoanTable();
        microLoanDailyTableSetColumnWidth();
        
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dailyMicroLoanClearAll();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         
        String spa = null;
        double roundedRemainingAmountOfLoan = 0;
           
        //for calculate remainingAmountOfLoan ****************************************************************************
        String query1 = "SELECT SUM(payedAmount) "
            + "FROM microloanrepayment "
            + "WHERE customerId = ? AND microloanrepayment.userId=? AND microloanrepayment.is_deleted=0 ";
        
        try{
            pst = conn.prepareStatement(query1);
            pst.setString(1, jTextField1.getText());
            pst.setString(2, User.userid);
            rs = pst.executeQuery();
            
            if(rs.next()){
                   spa = rs.getString("SUM(payedAmount)"); 
                }
         
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }finally{
            try{
                rs.close();
                pst.close();
            }catch(Exception e){

            }
        }
                
               
        
        //when not first time pay *****************************************************************************************************************
                if(spa != null){
                
                double sumOfPayedAmount = Double.parseDouble(spa);
                
                int r = jTable1.getSelectedRow();
                String aol = jTable1.getValueAt(r, 1).toString();
                double amountOfLoan = Double.parseDouble(aol);
                String ir = jTable1.getValueAt(r, 2).toString();
                double interestRate = Double.parseDouble(ir);
                double finalAmount = (amountOfLoan*(interestRate/100)) + amountOfLoan;
                      
                double currentPayAmount = Double.parseDouble(jTextField8.getText());
                
                double remainingAmountOfLoan = finalAmount - sumOfPayedAmount - currentPayAmount ;
                       roundedRemainingAmountOfLoan = Math.round(remainingAmountOfLoan*100.0)/100.0;
                String rraol = String.valueOf(roundedRemainingAmountOfLoan);
                
                
                //for calculate remaining installements
                double noOfInstallement = Double.parseDouble(jTextField7.getText());
                double installemenetAge = Double.parseDouble(jTextField23.getText());
                double remainingInstallement = noOfInstallement - installemenetAge ;
                double roundedRemainingInstallement = Math.round(remainingInstallement*100.0)/100.0;
                String rri = String.valueOf(roundedRemainingInstallement);
                
                
                //for add repayment
                String query2 = "INSERT INTO microloanrepayment(installementNo,installementAge,remainingInstallement,payDate,payedAmount,"
                        + "remainingAmountOfLoan,is_deleted,customerId,microLoanId,userId) "
                        + "VALUES(?,?,?,?,?,?,0,?,?,?)";

                try{
                    pst =conn.prepareStatement(query2);
                    pst.setString(1, txt_minstallementNo.getText());
                    pst.setString(2, jTextField23.getText());
                    pst.setString(3, rri);
                    pst.setString(4, ((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText());
                    pst.setString(5, jTextField8.getText());
                    pst.setString(6, rraol);
                    pst.setString(7, jTextField1.getText());
                    pst.setString(8, jTextField5.getText());
                    pst.setString(9, User.userid);
                    pst.execute();

                    JOptionPane.showMessageDialog(null, "pay record added successfully!");
                    jDateChooser1.setDate(new Date());

                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }
                    System.out.println(rraol);
                
                //delete from microloanrepayment********************************
                if(roundedRemainingAmountOfLoan <= 1){ 
                    
                    Timestamp timestamp = null;
                    timestamp = new Timestamp(System.currentTimeMillis());
                   
                    String query4 = "UPDATE microloanrepayment SET is_deleted = 1 , time_stamp = '"+timestamp+"' "
                    + "WHERE microLoanId=? AND customerId=? AND userId=?";

                    try{
                        pst = conn.prepareStatement(query4);
                        pst.setString(1, jTextField5.getText());
                        pst.setString(2, jTextField1.getText());
                        pst.setString(3, User.userid);
                        pst.execute();

                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, e);
                    }
                    

                    //also delete microloan ************************************
                    String query5 = "UPDATE microloan SET is_deleted = 1 , time_stamp = '"+timestamp+"' "
                    + "WHERE microLoanId=? AND customerId=? AND userId=? ";

                    try{
                        pst = conn.prepareStatement(query5);
                        pst.setString(1, jTextField5.getText());
                        pst.setString(2, jTextField1.getText());
                        pst.setString(3, User.userid);
                        pst.execute();

                        dailyMicroLoanTable();
                        dailyMicroLoanClearAll();
                        JOptionPane.showMessageDialog(null, "This customer payed all installement successfully!");

                    }catch(Exception e){

                        JOptionPane.showMessageDialog(null, e);

                    }
                               
                
                }
                
                
            }else{
                    
                //when pay first time there has no sum(payedAmount) --->prevent null pointer exception *********************************************    
                int r = jTable1.getSelectedRow();
                String aol = jTable1.getValueAt(r, 1).toString();
                double amountOfLoan = Double.parseDouble(aol);
                String ir = jTable1.getValueAt(r, 2).toString();
                double interestRate = Double.parseDouble(ir);
                double finalAmount = (amountOfLoan*(interestRate/100)) + amountOfLoan;

                double currentPayAmount = Double.parseDouble(jTextField8.getText());
                
                double remainingAmountOfLoan = finalAmount - currentPayAmount ;
                roundedRemainingAmountOfLoan = Math.round(remainingAmountOfLoan*100.0)/100.0;
                String rraol = String.valueOf(roundedRemainingAmountOfLoan);

                
                //for calculate remaining installements
                double noOfInstallement = Double.parseDouble(jTextField7.getText());
                double installementAge = Double.parseDouble(jTextField23.getText());
                double remainingInstallement = noOfInstallement - installementAge ;
                double roundedRemainingInstallement = Math.round(remainingInstallement*100.0)/100.0;
                String rri = String.valueOf(roundedRemainingInstallement);
                
//                //for average calculate
//                String cpa = jTextField8.getText();
//                double currentPayedAmount = Double.parseDouble(cpa);
//                String in = txt_minstallementNo.getText();
//                double InstallementNo = Double.parseDouble(in);
//                String ia = jTable1.getValueAt(r, 5).toString();
//                double InstallementAmount = Double.parseDouble(ia);
//                double average = currentPayAmount/InstallementNo*InstallementAmount;
//                double roundedAverage = Math.round(average*100.0)/100.0;
//                String a = String.valueOf(roundedAverage);
//                    System.out.println(roundedAverage);
                
                //for add repayment
                String query6 = "INSERT INTO microloanrepayment(installementNo,installementAge,remainingInstallement,"
                        + "payDate,payedAmount,remainingAmountOfLoan,is_deleted,customerId,microLoanId,userId) "
                        + "VALUES(?,?,?,?,?,?,0,?,?,?)";

                try{
                    pst =conn.prepareStatement(query6);
                    pst.setString(1, txt_minstallementNo.getText());
                    pst.setString(2, jTextField23.getText());
                    pst.setString(3, rri);
                    pst.setString(4, ((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText());
                    pst.setString(5, jTextField8.getText());
                    pst.setString(6, rraol);
                    pst.setString(7, jTextField1.getText());
                    pst.setString(8, jTextField5.getText());
                    pst.setString(9, User.userid);
                    pst.execute();

                    JOptionPane.showMessageDialog(null, "pay record added successfully!");
                    jDateChooser1.setDate(new Date());

                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }
                
            }      
            
        //for show how many installements do customer have?
        if(roundedRemainingAmountOfLoan >= 1){
        String noi = jTextField7.getText();
        double numberOfInstallement = Double.parseDouble(noi);
        double currentInstallementNo = Double.parseDouble(txt_minstallementNo.getText());

        double howmany = numberOfInstallement- currentInstallementNo;
        double roundedhowmany = Math.round(howmany*100.0)/100.0;

        String h = String.valueOf(roundedhowmany);

        JOptionPane.showMessageDialog(null, "This customer have to pay only "+h+" installement/s after this.");
        dailyMicroLoanClearAll(); 
        
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        int r = jTable1.getSelectedRow();

        String loanid = jTable1.getValueAt(r, 0).toString();
        String numberofinstallement = jTable1.getValueAt(r, 3).toString();
        String loantype = jTable1.getValueAt(r, 4).toString();     
        String installementamount = jTable1.getValueAt(r, 5).toString();
        String customerid = jTable1.getValueAt(r, 8).toString();
        String name = jTable1.getValueAt(r, 9).toString();

        jTextField1.setText(customerid);
        jTextField2.setText(name);
        jTextField5.setText(loanid);
        jTextField6.setText(loantype);
        jTextField7.setText(numberofinstallement);
        jTextField8.setText(installementamount);
        
        
        //for auto calculate installement number
        String sql = "SELECT COUNT(installementNo) "
                    + "FROM microloanrepayment "
                    + "WHERE microLoanId = ? AND customerId=? AND userId=? AND is_deleted=0 ";
            
            try{
                
                pst = conn.prepareStatement(sql);
                pst.setString(1 , jTextField5.getText());
                pst.setString(2 , jTextField1.getText());
                pst.setString(3 , User.userid);
                rs = pst.executeQuery();
                
                if(rs.next()){
                    
                //installement no
                    String inc = rs.getString("COUNT(installementNo)");
                    double installementNoCount = Double.parseDouble(inc);
                    double installementNo = installementNoCount+1;
                    String f1 = String.valueOf(installementNo);
                    txt_minstallementNo.setText(f1);
                    System.out.println(f1);
                    
                    
                }
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }finally{
            try{
                rs.close();
                pst.close();
            }catch(Exception e){

            }
        }
            
            //auto calculate installement Age
  
            String lia=null;
  
            String query = "SELECT installementAge "
                    + "FROM microloanrepayment "
                    + "WHERE microLoanId = ? AND customerId=? AND userId=? AND is_deleted=0 "
                    + "ORDER BY installementAge DESC LIMIT 1";
            try{
                
                pst = conn.prepareStatement(query);
                pst.setString(1 , jTextField5.getText());
                pst.setString(2 , jTextField1.getText());
                pst.setString(3 , User.userid);
                rs = pst.executeQuery();
                
                if(rs.next()){
                    
                //installement age
                lia =rs.getString("installementAge");
     
                }
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }finally{   
            try{
                rs.close();
                pst.close();
            }catch(Exception e){

            }
            }
                if(lia !=null){
                    double lastInstallementAge = Double.parseDouble(lia);
                    double newInstallementAge = lastInstallementAge+1;
                    double  roundedNewInstallements = Math.round(newInstallementAge*100.0)/100.0;
                    String setNewInstallementAge = String.valueOf(roundedNewInstallements);                   
                    jTextField23.setText(setNewInstallementAge); 
                    
                }else if(lia == null){
                    jTextField23.setText("1.0");
                }    
    }//GEN-LAST:event_jTable1MouseClicked

    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyReleased

        
        String sql = "SELECT microLoanId AS Micro_Loan_ID , amountOfLoan AS Capital,"
        + "interestRate AS Interest_Rate , numberOfInstallement AS No_of_Installement , loanType AS Loan_Type,"
        + "installementAmount AS Installement_Amount ,issueDate AS Issue_Date , dueDate AS Due_Date ,"
        + "customerdetails.id AS Customer_ID,customerdetails.name AS Customer_Name "
        + "FROM microloan "
        + "INNER JOIN customerdetails ON (microloan.customerId=customerdetails.id) "
        + "WHERE name=? AND microloan.userId='"+User.userid+"' AND loanType='Daily' AND microloan.is_deleted=0 "
                + "OR id=? AND microloan.userId='"+User.userid+"' AND loanType='Daily' AND microloan.is_deleted=0 "
                + "OR microLoanId=? AND microloan.userId='"+User.userid+"' AND loanType='Daily' AND microloan.is_deleted=0 ";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1 , txt_search.getText());
            pst.setString(2 , txt_search.getText());
            pst.setString(3 , txt_search.getText());
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
        
    }//GEN-LAST:event_txt_searchKeyReleased

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        
        weeklyMicroLoanClearAll();
        weeklyMicroLoanTable();
        microLoanWeeklyTableSetColumnWidth();
        
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void txt_search1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_search1KeyReleased

        
        String sql = "SELECT microLoanId AS Micro_Loan_ID , amountOfLoan AS Capital,"
                    + "interestRate AS Interest_Rate , numberOfInstallement AS No_of_Installement , loanType AS Loan_Type,"
                    + "installementAmount AS Installement_Amount ,issueDate AS Issue_Date , dueDate AS Due_Date ,"
                    + "customerdetails.id AS Customer_ID,customerdetails.name AS Customer_Name "
                    + "FROM microloan "
                    + "INNER JOIN customerdetails ON (microloan.customerId=customerdetails.id) "
                    + "WHERE name=? AND microloan.userId='"+User.userid+"' AND loanType='Weekly' AND microloan.is_deleted=0 "
                            + "OR id=? AND microloan.userId='"+User.userid+"' AND loanType='Weekly' AND microloan.is_deleted=0 "
                            + "OR microLoanId=? AND microloan.userId='"+User.userid+"' AND loanType='Weekly' AND microloan.is_deleted=0 ";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1 , txt_search1.getText());
            pst.setString(2 , txt_search1.getText());
            pst.setString(3 , txt_search1.getText());
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
    }//GEN-LAST:event_txt_search1KeyReleased

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
       
        int r = jTable3.getSelectedRow();

        String customerid = jTable3.getValueAt(r, 8).toString();
        String name = jTable3.getValueAt(r, 9).toString();
        String loanid = jTable3.getValueAt(r, 0).toString();
        String loantype = jTable3.getValueAt(r, 4).toString();
        String numberofinstallement = jTable3.getValueAt(r, 3).toString();
        String installementamount = jTable3.getValueAt(r, 5).toString();

        jTextField3.setText(customerid);
        jTextField4.setText(name);
        jTextField15.setText(loanid);
        jTextField16.setText(loantype);
        jTextField11.setText(numberofinstallement);
        jTextField12.setText(installementamount);
        
        
        String sql = "SELECT COUNT(installementNo) "
                    + "FROM microloanrepayment "
                    + "WHERE microLoanId = ? AND customerId=? AND userId=? AND is_deleted=0 ";
            
            try{
                
                pst = conn.prepareStatement(sql);
                pst.setString(1 , jTextField15.getText());
                pst.setString(2 , jTextField3.getText());
                pst.setString(3 , User.userid);
                rs = pst.executeQuery();
                
                if(rs.next()){
                
                    String inc = rs.getString("COUNT(installementNo)");
                    int installementNoCount = Integer.parseInt(inc);
                    int installementNo = installementNoCount+1;
                    String f = String.valueOf(installementNo);
                    txt_minstallementNo1.setText(f);
                    
                }
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }finally{
            try{
                rs.close();
                pst.close();
            }catch(Exception e){

            }
            }
            
            //auto calculate installement Age
  
            String lia=null;
  
            String query = "SELECT installementAge "
                    + "FROM microloanrepayment "
                    + "WHERE microLoanId = ? AND customerId=? AND userId=? AND is_deleted=0 "
                    + "ORDER BY installementAge DESC LIMIT 1";
            try{
                
                pst = conn.prepareStatement(query);
                pst.setString(1 , jTextField15.getText());
                pst.setString(2 , jTextField3.getText());
                pst.setString(3 , User.userid);
                rs = pst.executeQuery();
                
                if(rs.next()){
                    
                //installement age
                lia =rs.getString("installementAge");
     
                }
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }finally{   
            try{
                rs.close();
                pst.close();
            }catch(Exception e){

            }
            }
                if(lia !=null){
                    
                    double lastInstallementAge = Double.parseDouble(lia);
                    double newInstallementAge = lastInstallementAge+1;
                    double  roundedNewInstallements = Math.round(newInstallementAge*100.0)/100.0;
                    String setNewInstallementAge = String.valueOf(roundedNewInstallements);
                    jTextField24.setText(setNewInstallementAge); 
                    
                }else if(lia == null){
                    jTextField24.setText("1.0");
                } 
     
    }//GEN-LAST:event_jTable3MouseClicked

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        
        String spa = null;
        double roundedRemainingAmountOfLoan = 0;
        
        //for calculate remainingAmountOfLoan *******************************************************************************************************
        String query1 = "SELECT SUM(payedAmount) "
            + "FROM microloanrepayment "
            + "WHERE customerId = ? AND microloanrepayment.userId=? AND microloanrepayment.is_deleted=0 ";
        
        try{
            pst = conn.prepareStatement(query1);
            pst.setString(1, jTextField3.getText());
            pst.setString(2, User.userid);
            rs = pst.executeQuery();
            
            if(rs.next()){
                
                   spa = rs.getString("SUM(payedAmount)");    
            }
 
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }finally{
            try{
                rs.close();
                pst.close();
            }catch(Exception e){

            }
        }
                
                
                //when not first time pay ******************************************************************************
                if(spa != null){
                
                double sumOfPayedAmount = Double.parseDouble(spa);
                
                int r = jTable3.getSelectedRow();
                String aol = jTable3.getValueAt(r, 1).toString();
                double amountOfLoan = Double.parseDouble(aol);
                String ir = jTable3.getValueAt(r, 2).toString();
                double interestRate = Double.parseDouble(ir);
                double finalAmount = (amountOfLoan*(interestRate/100)) + amountOfLoan;
                      
                double currentPayAmount = Double.parseDouble(jTextField12.getText());
                
                double remainingAmountOfLoan = finalAmount - sumOfPayedAmount - currentPayAmount ;
                       roundedRemainingAmountOfLoan = Math.round(remainingAmountOfLoan*100.0)/100.0;
                String rraol = String.valueOf(roundedRemainingAmountOfLoan);
                
                //for calculate remaining installements
                double noOfInstallement = Double.parseDouble(jTextField11.getText());
                double installementAge = Double.parseDouble(jTextField24.getText());
                double remainingInstallement = noOfInstallement - installementAge ;
                double roundedRemainingInstallement = Math.round(remainingInstallement*100.0)/100.0;
                String rri = String.valueOf(roundedRemainingInstallement);
                
                
                //for add repayment
                String query2 = "INSERT INTO microloanrepayment(installementNo,installementAge,remainingInstallement,payDate,payedAmount,"
                        + "remainingAmountOfLoan,is_deleted,customerId,microLoanId,userId) "
                        + "VALUES(?,?,?,?,?,?,0,?,?,?)";

                try{
                    pst =conn.prepareStatement(query2);
                    pst.setString(1, txt_minstallementNo1.getText());
                    pst.setString(2, jTextField24.getText());
                    pst.setString(3, rri);
                    pst.setString(4, ((JTextField)jDateChooser3.getDateEditor().getUiComponent()).getText());
                    pst.setString(5, jTextField12.getText());
                    pst.setString(6, rraol);
                    pst.setString(7, jTextField3.getText());
                    pst.setString(8, jTextField15.getText());
                    pst.setString(9, User.userid);
                    pst.execute();

                    JOptionPane.showMessageDialog(null, "pay record added successfully!");
                    jDateChooser3.setDate(new Date());

                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }
                
                
                
                if(roundedRemainingAmountOfLoan <= 1){
                    
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());

                    //delete from microloanrepayment
                    String query4 = "UPDATE microloanrepayment SET is_deleted = 1 , time_stamp = '"+timestamp+"' "
                    + "WHERE microLoanId=? AND customerId=? AND userId=?";

                    try{
                        pst = conn.prepareStatement(query4);
                        pst.setString(1, jTextField15.getText());
                        pst.setString(2, jTextField3.getText());
                        pst.setString(3, User.userid);
                        pst.execute();

                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, e);
                    }

                    //also delete microloan details
                    String query5 = "UPDATE microloan SET is_deleted = 1 , time_stamp = '"+timestamp+"' "
                    + "WHERE microLoanId=? AND customerId=? AND userId=? ";

                    try{
                        pst = conn.prepareStatement(query5);
                        pst.setString(1, jTextField15.getText());
                        pst.setString(2, jTextField3.getText());
                        pst.setString(3, User.userid);
                        pst.execute();

                        weeklyMicroLoanTable();
                        weeklyMicroLoanClearAll();
                        JOptionPane.showMessageDialog(null, "This customer payed all installement successfully!");

                    }catch(Exception e){

                        JOptionPane.showMessageDialog(null, e);

                    }
                               
                
                }
                
                
            }else{
                    
                //when pay first time there has no sum(payedAmount) --->prevent null pointer exception ******************    
                int r = jTable3.getSelectedRow();
                String aol = jTable3.getValueAt(r, 1).toString();
                double amountOfLoan = Double.parseDouble(aol);
                String ir = jTable3.getValueAt(r, 2).toString();
                double interestRate = Double.parseDouble(ir);
                double finalAmount = (amountOfLoan*(interestRate/100)) + amountOfLoan;
                
                double currentPayAmount = Double.parseDouble(jTextField12.getText());
                
                double remainingAmountOfLoan = finalAmount - currentPayAmount ;
                       roundedRemainingAmountOfLoan = Math.round(remainingAmountOfLoan*100.0)/100.0;
                String rraol = String.valueOf(roundedRemainingAmountOfLoan);
                
                //for calculate remaining installements
                double noOfInstallement = Double.parseDouble(jTextField11.getText());
                double installementAge = Double.parseDouble(jTextField24.getText());
                double remainingInstallement = noOfInstallement - installementAge ;
                double roundedRemainingInstallement = Math.round(remainingInstallement*100.0)/100.0;
                String rri = String.valueOf(roundedRemainingInstallement);
                
                
                //for add repayment
                String query6 = "INSERT INTO microloanrepayment(installementNo,installementAge,remainingInstallement,payDate,payedAmount,"
                        + "remainingAmountOfLoan,is_deleted,customerId,microLoanId,userId) "
                        + "VALUES(?,?,?,?,?,?,0,?,?,?)";

                try{
                    pst =conn.prepareStatement(query6);
                    pst.setString(1, txt_minstallementNo1.getText());
                    pst.setString(2, jTextField24.getText());
                    pst.setString(3, rri);
                    pst.setString(4, ((JTextField)jDateChooser3.getDateEditor().getUiComponent()).getText());
                    pst.setString(5, jTextField12.getText());
                    pst.setString(6, rraol);
                    pst.setString(7, jTextField3.getText());
                    pst.setString(8, jTextField15.getText());
                    pst.setString(9, User.userid);
                    pst.execute();

                    JOptionPane.showMessageDialog(null, "pay record added successfully!");
                    jDateChooser3.setDate(new Date());

                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }
                
            }      
            
  
        //for show how many installements do customer have?
        if(roundedRemainingAmountOfLoan >= 1){
        String noi = jTextField11.getText();
        double numberOfInstallement = Double.parseDouble(noi);
        double installementAge = Double.parseDouble(jTextField24.getText());

        double howmany = numberOfInstallement- installementAge;
        double roundedhowmany = Math.round(howmany*100.0)/100.0;

        String h = String.valueOf(roundedhowmany);

        JOptionPane.showMessageDialog(null, "This customer have to pay only "+h+" installement/s after this.");
        weeklyMicroLoanClearAll(); 
        
        }
          
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        weeklyMicroLoanClearAll();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        monthlyMicroLoanClearAll();
        monthlyMicroLoanTable();
        microLoanMonthlyTableSetColumnWidth();
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jTextField19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField19ActionPerformed

    private void txt_search3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_search3KeyReleased

        
        String sql = "SELECT microLoanId AS Micro_Loan_ID , amountOfLoan AS Capital,"
        + "interestRate AS Interest_Rate , numberOfInstallement AS No_of_Installement , loanType AS Loan_Type,"
        + "installementAmount AS Installement_Amount ,issueDate AS Issue_Date , dueDate AS Due_Date ,"
        + "customerdetails.id AS Customer_ID,customerdetails.name AS Customer_Name "
        + "FROM microloan "
        + "INNER JOIN customerdetails ON (microloan.customerId=customerdetails.id) "
        + "WHERE name=? AND microloan.userId='"+User.userid+"' AND loanType='Monthly' AND microloan.is_deleted=0 "
                            + "OR id=? AND microloan.userId='"+User.userid+"' AND loanType='Monthly' AND microloan.is_deleted=0 "
                            + "OR microLoanId=? AND microloan.userId='"+User.userid+"' AND loanType='Monthly' AND microloan.is_deleted=0 ";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1 , txt_search3.getText());
            pst.setString(2 , txt_search3.getText());
            pst.setString(3 , txt_search3.getText());
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
        
    }//GEN-LAST:event_txt_search3KeyReleased

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        
        int r = jTable4.getSelectedRow();

        String customerid = jTable4.getValueAt(r, 8).toString();
        String name = jTable4.getValueAt(r, 9).toString();
        String loanid = jTable4.getValueAt(r, 0).toString();
        String loantype = jTable4.getValueAt(r, 4).toString();
        String numberofinstallement = jTable4.getValueAt(r, 3).toString();
        String installementamount = jTable4.getValueAt(r, 5).toString();

        jTextField19.setText(customerid);
        jTextField20.setText(name);
        jTextField21.setText(loanid);
        jTextField22.setText(loantype);
        jTextField17.setText(numberofinstallement);
        jTextField18.setText(installementamount);
    
        
        String sql = "SELECT COUNT(installementNo) "
                    + "FROM microloanrepayment "
                    + "WHERE microLoanId = ? AND customerId=? AND userId=? AND is_deleted=0 ";
            
            try{
                
                pst = conn.prepareStatement(sql);
                pst.setString(1 , jTextField21.getText());
                pst.setString(2 , jTextField19.getText());
                pst.setString(3 , User.userid);
                rs = pst.executeQuery();
                
                if(rs.next()){
                
                    String inc = rs.getString("COUNT(installementNo)");
                    int installementNoCount = Integer.parseInt(inc);
                    int installementNo = installementNoCount+1;
                    String f = String.valueOf(installementNo);
                    txt_minstallementNo2.setText(f);
                    
                }
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }finally{
            try{
                rs.close();
                pst.close();
            }catch(Exception e){

            }
            }
            
            
            //auto calculate installement Age
  
            String lia=null;
  
            String query = "SELECT installementAge "
                    + "FROM microloanrepayment "
                    + "WHERE microLoanId = ? AND customerId=? AND userId=? AND is_deleted=0 "
                    + "ORDER BY installementAge DESC LIMIT 1";
            try{
                
                pst = conn.prepareStatement(query);
                pst.setString(1 , jTextField21.getText());
                pst.setString(2 , jTextField19.getText());
                pst.setString(3 , User.userid);
                rs = pst.executeQuery();
                
                if(rs.next()){
                    
                //installement age
                lia =rs.getString("installementAge");
     
                }
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }finally{   
            try{
                rs.close();
                pst.close();
            }catch(Exception e){

            }
            }
                if(lia !=null){
                    
                    double lastInstallementAge = Double.parseDouble(lia);
                    double newInstallementAge = lastInstallementAge+1;
                    double  roundedNewInstallements = Math.round(newInstallementAge*100.0)/100.0;
                    String setNewInstallementAge = String.valueOf(roundedNewInstallements);
                    jTextField25.setText(setNewInstallementAge); 
                    
                }else if(lia == null){
                    jTextField25.setText("1.0");
                } 
                
    }//GEN-LAST:event_jTable4MouseClicked

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        
        String spa = null;
        double roundedRemainingAmountOfLoan = 0;
        
        //for calculate remainingAmountOfLoan *******************************************************************************************************
        String query1 = "SELECT SUM(payedAmount) "
            + "FROM microloanrepayment "
            + "WHERE customerId = ? AND microloanrepayment.userId=? AND microloanrepayment.is_deleted=0 ";
        
        try{
            pst = conn.prepareStatement(query1);
            pst.setString(1, jTextField19.getText());
            pst.setString(2, User.userid);
            rs = pst.executeQuery();
            
            if(rs.next()){
                   
                spa = rs.getString("SUM(payedAmount)");        
            }
  
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }finally{
            try{
                rs.close();
                pst.close();
            }catch(Exception e){

            }
        }
                
               
                //when not first time pay ******************************************************************************
                if(spa != null){
                
                double sumOfPayedAmount = Double.parseDouble(spa);
                
                int r = jTable4.getSelectedRow();
                String aol = jTable4.getValueAt(r, 1).toString();
                double amountOfLoan = Double.parseDouble(aol);
                String ir = jTable4.getValueAt(r, 2).toString();
                double interestRate = Double.parseDouble(ir);
                double finalAmount = (amountOfLoan*(interestRate/100)) + amountOfLoan;
                      
                double currentPayAmount = Double.parseDouble(jTextField18.getText());
                
                double remainingAmountOfLoan = finalAmount - sumOfPayedAmount - currentPayAmount ;
                       roundedRemainingAmountOfLoan = Math.round(remainingAmountOfLoan*100.0)/100.0;
                String rraol = String.valueOf(roundedRemainingAmountOfLoan);
                
                //for calculate remaining installements
                double noOfInstallement = Double.parseDouble(jTextField17.getText());
                double installementAge = Double.parseDouble(jTextField25.getText());
                double remainingInstallement = noOfInstallement - installementAge ;
                double roundedRemainingInstallement = Math.round(remainingInstallement*100.0)/100.0;
                String rri = String.valueOf(roundedRemainingInstallement);
                
                
                //for add repayment
                String query2 = "INSERT INTO microloanrepayment(installementNo,installementAge,remainingInstallement, "
                        + "payDate,payedAmount,remainingAmountOfLoan,is_deleted,customerId,microLoanId,userId) "
                        + "VALUES(?,?,?,?,?,?,0,?,?,?)";

                try{
                    pst =conn.prepareStatement(query2);
                    pst.setString(1, txt_minstallementNo2.getText());
                    pst.setString(2, jTextField25.getText());
                    pst.setString(3, rri);
                    pst.setString(4, ((JTextField)jDateChooser4.getDateEditor().getUiComponent()).getText());
                    pst.setString(5, jTextField18.getText());
                    pst.setString(6, rraol);
                    pst.setString(7, jTextField19.getText());
                    pst.setString(8, jTextField21.getText());
                    pst.setString(9, User.userid);
                    pst.execute();

                    JOptionPane.showMessageDialog(null, "pay record added successfully!");
                    jDateChooser4.setDate(new Date());

                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }
                
                
                
                if(roundedRemainingAmountOfLoan <= 1){

                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                    
                    //delete from microloanrepayment
                    String query4 = "UPDATE microloanrepayment SET is_deleted = 1 , time_stamp = '"+timestamp+"' "
                    + "WHERE microLoanId=? AND customerId=? AND userId=?";

                    try{
                        pst = conn.prepareStatement(query4);
                        pst.setString(1, jTextField21.getText());
                        pst.setString(2, jTextField19.getText());
                        pst.setString(3, User.userid);
                        pst.execute();

                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, e);
                    }

                    //also delete microloan details
                    String query5 = "UPDATE microloan SET is_deleted = 1 , time_stamp = '"+timestamp+"' "
                    + "WHERE microLoanId=? AND customerId=? AND userId=? ";

                    try{
                        pst = conn.prepareStatement(query5);
                        pst.setString(1, jTextField21.getText());
                        pst.setString(2, jTextField19.getText());
                        pst.setString(3, User.userid);
                        pst.execute();

                        monthlyMicroLoanTable();
                        monthlyMicroLoanClearAll();
                        JOptionPane.showMessageDialog(null, "This customer payed all installement successfully!");

                    }catch(Exception e){

                        JOptionPane.showMessageDialog(null, e);

                    }
                               
                
                }
                
                
            }else{
                    
                //when pay first time there has no sum(payedAmount) --->prevent null pointer exception ******************    
                int r = jTable4.getSelectedRow();
                String aol = jTable4.getValueAt(r, 1).toString();
                double amountOfLoan = Double.parseDouble(aol);
                String ir = jTable4.getValueAt(r, 2).toString();
                double interestRate = Double.parseDouble(ir);
                double finalAmount = (amountOfLoan*(interestRate/100)) + amountOfLoan;
                
                double currentPayAmount = Double.parseDouble(jTextField18.getText());
                
                double remainingAmountOfLoan = finalAmount - currentPayAmount ;
                       roundedRemainingAmountOfLoan = Math.round(remainingAmountOfLoan*100.0)/100.0;
                String rraol = String.valueOf(roundedRemainingAmountOfLoan);
                
                //for calculate remaining installements
                double noOfInstallement = Double.parseDouble(jTextField17.getText());
                double installementAge = Double.parseDouble(jTextField25.getText());
                double remainingInstallement = noOfInstallement - installementAge ;
                double roundedRemainingInstallement = Math.round(remainingInstallement*100.0)/100.0;
                String rri = String.valueOf(roundedRemainingInstallement);
                
                
                //for add repayment
                String query6 = "INSERT INTO microloanrepayment(installementNo,installementAge,remainingInstallement,payDate,payedAmount,"
                        + "remainingAmountOfLoan,is_deleted,customerId,microLoanId,userId) "
                        + "VALUES(?,?,?,?,?,?,0,?,?,?)";

                try{
                    pst =conn.prepareStatement(query6);
                    pst.setString(1, txt_minstallementNo2.getText());
                    pst.setString(2, jTextField25.getText());
                    pst.setString(3, rri);
                    pst.setString(4, ((JTextField)jDateChooser4.getDateEditor().getUiComponent()).getText());
                    pst.setString(5, jTextField18.getText());
                    pst.setString(6, rraol);
                    pst.setString(7, jTextField19.getText());
                    pst.setString(8, jTextField21.getText());
                    pst.setString(9, User.userid);
                    pst.execute();

                    JOptionPane.showMessageDialog(null, "pay record added successfully!");
                    jDateChooser4.setDate(new Date());

                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }
                
            }      
            
 

        //for show how many installements do customer have?
        if(roundedRemainingAmountOfLoan >= 1){
        String noi = jTextField17.getText();
        double numberOfInstallement = Double.parseDouble(noi);
        double currentInstallementNo = Double.parseDouble(txt_minstallementNo2.getText());

        double howmany = numberOfInstallement- currentInstallementNo;
        double roundedhowmany = Math.round(howmany*100.0)/100.0;

        String h = String.valueOf(roundedhowmany);

        JOptionPane.showMessageDialog(null, "This customer have to pay only "+h+" installement/s after this.");
        monthlyMicroLoanClearAll(); 
        
        }
        
        
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        monthlyMicroLoanClearAll();
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jTextField8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyReleased
        
    }//GEN-LAST:event_jTextField8KeyReleased

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        
        int r = jTable1.getSelectedRow();
        String installementAmount = jTable1.getValueAt(r, 5).toString(); //dueinstallementAmount
  
        String eia = jTextField8.getText();
        double dueInstallemenetAmount = Double.parseDouble(installementAmount);
        double enteredInstallementAmount = Double.parseDouble(eia);
        
                
        if(dueInstallemenetAmount < enteredInstallementAmount ){
           
            double installementAge = Double.parseDouble(jTextField23.getText());

            double newInstallementAge = (installementAge + (enteredInstallementAmount/dueInstallemenetAmount))-1;
            double  roundedNewInstallements = Math.round(newInstallementAge*100.0)/100.0;
            String f = String.valueOf(roundedNewInstallements);
            jTextField23.setText(f); 
  
            
        }else if(dueInstallemenetAmount > enteredInstallementAmount){
            double installementAge = Double.parseDouble(jTextField23.getText());

            double newInstallementAge = (installementAge + (enteredInstallementAmount/dueInstallemenetAmount))-1;
            double  roundedNewInstallements = Math.round(newInstallementAge*100.0)/100.0;
            String f = String.valueOf(roundedNewInstallements);
            jTextField23.setText(f); 
        }else{
            JOptionPane.showMessageDialog(null, "Installement Amount doesn't change!");
        }
       
   
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        
        int r = jTable3.getSelectedRow();
        String installementAmount = jTable3.getValueAt(r, 5).toString(); //dueinstallementAmount
  
        String eia = jTextField12.getText();
        double dueInstallemenetAmount = Double.parseDouble(installementAmount);
        double enteredInstallementAmount = Double.parseDouble(eia);
        
                
        if(dueInstallemenetAmount < enteredInstallementAmount ){
           
            double installementAge = Double.parseDouble(jTextField24.getText());

            double newInstallementAge = installementAge + (enteredInstallementAmount/dueInstallemenetAmount)-1;
            double  roundedNewInstallements = Math.round(newInstallementAge*100.0)/100.0;
            String f = String.valueOf(roundedNewInstallements);
            jTextField24.setText(f); 
  
            
        }else if(dueInstallemenetAmount > enteredInstallementAmount){
            double installementAge = Double.parseDouble(jTextField24.getText());

            double newInstallementAge = (installementAge + (enteredInstallementAmount/dueInstallemenetAmount))-1;
            double  roundedNewInstallements = Math.round(newInstallementAge*100.0)/100.0;
            String f = String.valueOf(roundedNewInstallements);
            jTextField24.setText(f); 
        }else{
            JOptionPane.showMessageDialog(null, "Installement Amount doesn't change!");
        }
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        
        int r = jTable4.getSelectedRow();
        String installementAmount = jTable4.getValueAt(r, 5).toString(); //dueinstallementAmount
  
        String eia = jTextField18.getText();
        double dueInstallemenetAmount = Double.parseDouble(installementAmount);
        double enteredInstallementAmount = Double.parseDouble(eia);
        
                
        if(dueInstallemenetAmount < enteredInstallementAmount ){
           
            double installementAge = Double.parseDouble(jTextField25.getText());

            double newInstallementAge = installementAge + (enteredInstallementAmount/dueInstallemenetAmount)-1;
            double  roundedNewInstallements = Math.round(newInstallementAge*100.0)/100.0;
            String f = String.valueOf(roundedNewInstallements);
            jTextField25.setText(f); 
  
            
        }else if(dueInstallemenetAmount > enteredInstallementAmount){
            double installementAge = Double.parseDouble(jTextField25.getText());

            double newInstallementAge = (installementAge + (enteredInstallementAmount/dueInstallemenetAmount))-1;
            double  roundedNewInstallements = Math.round(newInstallementAge*100.0)/100.0;
            String f = String.valueOf(roundedNewInstallements);
            jTextField25.setText(f); 
        }else{
            JOptionPane.showMessageDialog(null, "Installement Amount doesn't change!");
        }
       
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jTextField8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyTyped
        
        try{
            numberOnly.NumbersOnly(evt);
        
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Billing System Error");
        }
    }//GEN-LAST:event_jTextField8KeyTyped

    private void jTextField12KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField12KeyTyped
        
        try{
            numberOnly.NumbersOnly(evt);
        
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Billing System Error");
        }
    }//GEN-LAST:event_jTextField12KeyTyped

    private void jTextField18KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField18KeyTyped
        
        try{
            numberOnly.NumbersOnly(evt);
        
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Billing System Error");
        }
    }//GEN-LAST:event_jTextField18KeyTyped

    private void jTextField14KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField14KeyTyped
        
        try{
            numberOnly.NumbersOnly(evt);
        
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Billing System Error");
        }
    }//GEN-LAST:event_jTextField14KeyTyped

    private void jTable1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseEntered

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        
        dailyMicroLoanTable();
        weeklyMicroLoanTable();
        monthlyMicroLoanTable();
        fixLoanTable();
        
        txt_search.setText("");
        txt_search1.setText("");
        txt_search2.setText("");
        txt_search3.setText("");
        
        microLoanDailyTableSetColumnWidth();
        microLoanWeeklyTableSetColumnWidth();
        microLoanMonthlyTableSetColumnWidth();
        fixLoanTableSetColumnWidth();
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        
        txt_search.setText("");
        
        String sql = "SELECT microLoanId AS Micro_Loan_ID , amountOfLoan AS Capital,"
        + "interestRate AS Interest_Rate , numberOfInstallement AS No_of_Installement , loanType AS Loan_Type,"
        + "installementAmount AS Installement_Amount ,issueDate AS Issue_Date , dueDate AS Due_Date ,"
        + "customerdetails.id AS Customer_ID,customerdetails.name AS Customer_Name "
        + "FROM microloan "
        + "INNER JOIN customerdetails ON (microloan.customerId=customerdetails.id) "
        + "WHERE name=? AND microloan.userId='"+User.userid+"' AND loanType='Daily' AND microloan.is_deleted=0 ";
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
        
        txt_search1.setText("");
        
        String sql = "SELECT microLoanId AS Micro_Loan_ID , amountOfLoan AS Capital,"
                    + "interestRate AS Interest_Rate , numberOfInstallement AS No_of_Installement , loanType AS Loan_Type,"
                    + "installementAmount AS Installement_Amount ,issueDate AS Issue_Date , dueDate AS Due_Date ,"
                    + "customerdetails.id AS Customer_ID,customerdetails.name AS Customer_Name "
                    + "FROM microloan "
                    + "INNER JOIN customerdetails ON (microloan.customerId=customerdetails.id) "
                    + "WHERE name=? AND microloan.userId='"+User.userid+"' AND loanType='Weekly' AND microloan.is_deleted=0 ";
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
        
        txt_search3.setText("");
        
        String sql = "SELECT microLoanId AS Micro_Loan_ID , amountOfLoan AS Capital,"
        + "interestRate AS Interest_Rate , numberOfInstallement AS No_of_Installement , loanType AS Loan_Type,"
        + "installementAmount AS Installement_Amount ,issueDate AS Issue_Date , dueDate AS Due_Date ,"
        + "customerdetails.id AS Customer_ID,customerdetails.name AS Customer_Name "
        + "FROM microloan "
        + "INNER JOIN customerdetails ON (microloan.customerId=customerdetails.id) "
        + "WHERE name=? AND microloan.userId='"+User.userid+"' AND loanType='Monthly' AND microloan.is_deleted=0 ";
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
        
        txt_search2.setText("");
        
        String sql = "SELECT fixLoanId AS Fix_Loan_ID , amountOfLoan AS Capital , interestRate AS Interest_Rate,"
        + "installementAmount AS Installement_Amount , issueDate AS Issue_Date,"
        + "customerdetails.id AS Customer_ID , customerdetails.name AS Customer_Name "
        + "FROM fixloan "
        + "INNER JOIN customerdetails ON (fixloan.customerId=customerdetails.id) "
        + "WHERE name=? AND fixloan.userId='"+User.userid+"' AND fixloan.is_deleted=0 ";
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

    private void jTextField24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField24ActionPerformed

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
            java.util.logging.Logger.getLogger(Repayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Repayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Repayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Repayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Repayment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField txt_finstallementNo;
    private javax.swing.JTextField txt_minstallementNo;
    private javax.swing.JTextField txt_minstallementNo1;
    private javax.swing.JTextField txt_minstallementNo2;
    private javax.swing.JTextField txt_search;
    private javax.swing.JTextField txt_search1;
    private javax.swing.JTextField txt_search2;
    private javax.swing.JTextField txt_search3;
    // End of variables declaration//GEN-END:variables
    
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/loan.png")));
    }


}
