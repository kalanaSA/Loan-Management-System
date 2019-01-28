package lms;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.sql.Connection;
import java.sql.SQLException;

public class ProfitShare extends javax.swing.JFrame {
    
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    
    User numberOnly = new User();

    public ProfitShare() {
        
        super("Profit Share");
        initComponents();
        conn = DBconnect.connect();
        jLabel24.setText(String.valueOf(User.username));
        jLabel25.setText(String.valueOf(User.username));
        jLabel31.setText(String.valueOf(User.username));
        setIcon();
        
        jDateChooser2.setDate(new Date());
        jDateChooser4.setDate(new Date());
        jDateChooser6.setDate(new Date());
        
        //for display percentage of each shares
        calPercentageOfShares();
    }
    
     public void calPercentageOfShares(){
        
        //for profile 1
        String sql1 = "SELECT * FROM profitshare WHERE id=1 AND userId=?";
        try{
            pst = conn.prepareStatement(sql1);
            pst.setString(1, User.userid);
            rs = pst.executeQuery();
            
            if(rs.next()){  
                String add1 = rs.getString("totalAmountOfInvested");
                jTextField1.setText(add1);
                String add2 = rs.getString("name");
                jTextField21.setText(add2);
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Can't fetch data from database, check internet connection & try again!");
        }finally{
            try{
                rs.close();
                pst.close();
            }catch(Exception e){

            }
        }
        
        
        //for profile 2
        String sql2 = "SELECT * FROM profitshare WHERE id=2 AND userId=?";
        try{
            pst = conn.prepareStatement(sql2);
            pst.setString(1, User.userid);
            rs = pst.executeQuery();
            
            if(rs.next()){
                String add1 = rs.getString("totalAmountOfInvested");
                jTextField2.setText(add1);
                String add2 = rs.getString("name");
                jTextField22.setText(add2);
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Can't fetch data from database, check internet connection & try again!");
        }finally{
            try{
                rs.close();
                pst.close();
            }catch(Exception e){

            }
        }
        
        
        //for profile 3
        String sql3 = "SELECT * FROM profitshare WHERE id=3 AND userId=?";
        try{
            pst = conn.prepareStatement(sql3);
            pst.setString(1, User.userid);
            rs = pst.executeQuery();
            
            if(rs.next()){
                String add1 = rs.getString("totalAmountOfInvested");
                jTextField16.setText(add1);
                String add2 = rs.getString("name");
                jTextField24.setText(add2);
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Can't fetch data from database, check internet connection & try again!");
        }finally{
            try{
                rs.close();
                pst.close();
            }catch(Exception e){

            }
        }
               
       
        
        double totalAmountOfInvested1 = Double.parseDouble(jTextField1.getText());
        double totalAmountOfInvested2 = Double.parseDouble(jTextField2.getText());
        double totalAmountOfInvested3 = Double.parseDouble(jTextField16.getText());
        double total = totalAmountOfInvested1+totalAmountOfInvested2+totalAmountOfInvested3;
        
        double percentageOfShare1 = (totalAmountOfInvested1/total)*100;
        double roundedPercentageOfShare1 = Math.round(percentageOfShare1*100.0)/100.0;
        String p1 = String.valueOf(roundedPercentageOfShare1);
        jTextField3.setText(p1);
                
        double percentageOfShare2 = (totalAmountOfInvested2/total)*100;
        double roundedPercentageOfShare2 = Math.round(percentageOfShare2*100.0)/100.0;
        String p2 = String.valueOf(roundedPercentageOfShare2);
        jTextField4.setText(p2);
        
        double percentageOfShare3 = (totalAmountOfInvested3/total)*100;
        double roundedPercentageOfShare3 = Math.round(percentageOfShare3*100.0)/100.0;
        String p3 = String.valueOf(roundedPercentageOfShare3);
        jTextField14.setText(p3);
 
 
     }  
     
     
     public void clearAll(){
        jTextField6.setText("");
        jTextField5.setText("");
        jTextField19.setText("");
        jTextField20.setText("");
        jTextField8.setText("");
        jTextField9.setText("");
        
        jTextField7.setText("");
        jTextField12.setText("");
        jTextField26.setText("");
        jTextField23.setText("");
        jTextField11.setText("");
        jTextField10.setText("");
        
        jTextField13.setText("");
        jTextField18.setText("");
        jTextField30.setText("");
        jTextField17.setText("");
        jTextField15.setText("");
        
        jDateChooser2.setDate(new Date());
        jDateChooser1.setCalendar(null);
        jDateChooser4.setDate(new Date());
        jDateChooser3.setCalendar(null);
        jDateChooser6.setDate(new Date());
        jDateChooser5.setCalendar(null);
                
     }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel40 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel44 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jTextField21 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField23 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jLabel48 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel49 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel50 = new javax.swing.JLabel();
        jTextField26 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jTextField22 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jTextField27 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        jDateChooser5 = new com.toedter.calendar.JDateChooser();
        jDateChooser6 = new com.toedter.calendar.JDateChooser();
        jLabel54 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jLabel55 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jTextField30 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jTextField24 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Share for profile : 1");

        jTextField6.setEditable(false);
        jTextField6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jTextField3.setEditable(false);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/img/IMG_chathumal.jpg"))); // NOI18N
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Total Profit");

        jTextField9.setEditable(false);

        jLabel17.setText("Logged In As :");

        jLabel24.setText("username");

        jButton1.setText("Show");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Exit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("From");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Total profit from micro loans");

        jTextField5.setEditable(false);

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel40.setText("-");

        jTextField19.setEditable(false);

        jLabel16.setText("%");

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel41.setText("=");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Total Amount of Invested :");

        jTextField20.setEditable(false);

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jButton3.setText("Change");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Perecentage of share");

        jLabel44.setText("total payed amount");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("To");

        jLabel45.setText("total amount of loan");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Total profit from fix loan ");

        jTextField8.setEditable(false);
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel1.setText("Chathumal Buddhika");

        jLabel58.setText("total payed amount");

        jLabel42.setText("Name :");

        jTextField21.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel24)
                        .addGap(300, 300, 300)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(80, 80, 80)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15))
                                .addGap(23, 23, 23)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel44)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel45)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jLabel58)
                                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(63, 63, 63)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel16))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jTextField21, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
                                        .addGap(10, 10, 10)
                                        .addComponent(jButton3))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(jLabel1)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(45, 45, 45)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel44)
                            .addComponent(jLabel45))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jDateChooser2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel40)
                                    .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel41)
                                    .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel58)
                                .addGap(1, 1, 1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(92, 92, 92)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jLabel24))
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jTabbedPane1.addTab("profile 1", jPanel1);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Share for profile : 2");

        jTextField7.setEditable(false);
        jTextField7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jTextField4.setEditable(false);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/img/IMG_arjun.jpg"))); // NOI18N
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setText("Total Profit");

        jTextField10.setEditable(false);

        jLabel19.setText("Logged In As :");

        jLabel25.setText("username");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Total Amount of Invested :");

        jTextField23.setEditable(false);

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        jButton4.setText("Change");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Perecentage of share");

        jLabel48.setText("total payed amount");

        jButton5.setText("Show");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setText("To");

        jButton6.setText("Exit");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel49.setText("total amount of loan");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setText("From");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel22.setText("Total profit from fix loan ");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setText("Total profit from micro loans");

        jTextField11.setEditable(false);
        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });

        jTextField12.setEditable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setText("Arjuna Mahesh");

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel50.setText("-");

        jTextField26.setEditable(false);

        jLabel26.setText("%");

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel51.setText("=");

        jLabel59.setText("total payed amount");

        jLabel43.setText("Name :");

        jTextField22.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel25)
                        .addGap(300, 300, 300)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 1219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(80, 80, 80)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel18))
                                .addGap(23, 23, 23)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel48)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(jTextField11, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jTextField12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel49)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jLabel59)
                                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(62, 62, 62)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel26))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jTextField22, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
                                        .addGap(10, 10, 10)
                                        .addComponent(jButton4))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addComponent(jLabel2)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(45, 45, 45)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel48)
                            .addComponent(jLabel49))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jDateChooser4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel50)
                                    .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel51)
                                    .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel59)
                                .addGap(1, 1, 1)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18)
                                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(92, 92, 92)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(jLabel25))
                        .addContainerGap())))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jTabbedPane1.addTab("profile 2", jPanel2);

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel27.setText("Share for profile : 3");

        jTextField13.setEditable(false);
        jTextField13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jTextField14.setEditable(false);

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/img/images.png"))); // NOI18N
        jLabel28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel29.setText("Total Profit");

        jTextField15.setEditable(false);

        jLabel30.setText("Logged In As :");

        jLabel31.setText("username");

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel32.setText("Total Amount of Invested :");

        jTextField27.setEditable(false);

        jTextField16.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField16KeyTyped(evt);
            }
        });

        jButton7.setText("Change");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel33.setText("Perecentage of share");

        jLabel54.setText("total payed amount");

        jButton8.setText("Show");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel34.setText("To");

        jButton9.setText("Exit");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel55.setText("total amount of loan");

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel35.setText("From");

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel36.setText("Total profit from fix loan ");

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel37.setText("Total profit from micro loans");

        jTextField17.setEditable(false);
        jTextField17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField17ActionPerformed(evt);
            }
        });

        jTextField18.setEditable(false);

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel38.setText("Ashan");

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel56.setText("-");

        jTextField30.setEditable(false);

        jLabel39.setText("%");

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel57.setText("=");

        jLabel60.setText("total payed amount");

        jLabel46.setText("Name :");

        jTextField24.setEditable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel31)
                        .addGap(300, 300, 300)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jDateChooser5, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jDateChooser6, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(80, 80, 80)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel37)
                                    .addComponent(jLabel36)
                                    .addComponent(jLabel29))
                                .addGap(23, 23, 23)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel54)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(jTextField17, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jTextField18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel55)))
                                    .addComponent(jLabel60)
                                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel28)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(77, 77, 77)
                                        .addComponent(jLabel38)))
                                .addGap(63, 63, 63)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel32)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel39))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jTextField24, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(10, 10, 10)
                                        .addComponent(jButton7))))))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1202, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel28))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel46))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel39))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(45, 45, 45)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel54)
                            .addComponent(jLabel55))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jDateChooser5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jDateChooser6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel56)
                                    .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel57)
                                    .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel60)
                                .addGap(1, 1, 1)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel29)
                                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(jLabel31))))
                .addGap(15, 15, 15))
        );

        jTabbedPane1.addTab("profile 3", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1282, 742));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        String mspa = null;
        String fspa = null;
//        String final1 = null;
//        String final2 = null;
        
        //get total payedAmount from microloanrepayment*******************************
        String query1 = "SELECT SUM(payedAmount) "
        + "FROM microloanrepayment "
        + "WHERE microloanrepayment.time_stamp >= CAST(? AS DATE) AND microloanrepayment.time_stamp <= CAST(? AS DATE) "
        + "AND microloanrepayment.userId=? AND microloanrepayment.is_deleted=1";

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        String date1 = sdf1.format(jDateChooser1.getDate());
        String date2 = sdf1.format(jDateChooser2.getDate());

        try{
            pst = conn.prepareStatement(query1);

            pst.setString(1 , date1);
            pst.setString(2 , date2);
            pst.setString(3 , User.userid);
            rs = pst.executeQuery();

            if(rs.next()){
                mspa = rs.getString("SUM(payedAmount)");
//                double mSumOfPayedAmount = Double.parseDouble(mspa);
//                double mRoundedSumOfPayedAmount = Math.round(mSumOfPayedAmount*100.0)/100.0;
//                final1 = String.valueOf(mRoundedSumOfPayedAmount);
                
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
       
                
        //get total payedAmount from fixloanrepayment*****************************
        //SUM(payedAmount)=totalProfit
        String query3 = "SELECT SUM(payedAmount) "
        + "FROM fixloanrepayment "
        + "WHERE time_stamp >= CAST(? AS DATE) AND time_stamp <= CAST(? AS DATE) "
        + "AND fixloanrepayment.userId=? AND fixloanrepayment.is_deleted=1 ";

        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
        String date5 = sdf3.format(jDateChooser1.getDate());
        String date6 = sdf3.format(jDateChooser2.getDate());

        try{
            pst = conn.prepareStatement(query3);

            pst.setString(1 , date5);
            pst.setString(2 , date6);
            pst.setString(3 , User.userid);
            rs = pst.executeQuery();

            if(rs.next()){

                fspa = rs.getString("SUM(payedAmount)");
//                double fSumOfPayedAmount = Double.parseDouble(fspa);
//                double fRoundedsumOfPayedAmount = Math.round(fSumOfPayedAmount*100.0)/100.0;
//                final2 = String.valueOf(fRoundedsumOfPayedAmount);

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
                
    

        
        if(mspa != null && fspa != null){   //****************************************************************************
            
        jTextField5.setText(mspa);
        jTextField8.setText(fspa);
        
        
        //get total amountOfLoan from microloan*********************************
        String query2 = "SELECT SUM(amountOfLoan) "
        + "FROM microloan "
        + "WHERE microloan.time_stamp >= CAST(? AS DATE) AND microloan.time_stamp <= CAST(? AS DATE) "
        + "AND microloan.userId=? AND microloan.is_deleted=1 ";

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String date3 = sdf2.format(jDateChooser1.getDate());
        String date4 = sdf2.format(jDateChooser2.getDate());

        try{
            pst=conn.prepareStatement(query2);
            pst.setString(1 , date3);
            pst.setString(2 , date4);
            pst.setString(3 , User.userid);
            rs=pst.executeQuery();

            if(rs.next()){
                String sal = rs.getString("SUM(amountOfLoan)");
                double sumAmountOfLoan = Double.parseDouble(sal);
                double roundedSumAmountOfLoan = Math.round(sumAmountOfLoan*100.0)/100.0;
                String f = String.valueOf(roundedSumAmountOfLoan);
                jTextField19.setText(f);
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
        
        //total profit from microloans*********************************************
        double mtotalPayedAmount = Double.parseDouble(jTextField5.getText());
        double mtotalAmountOfLoan = Double.parseDouble(jTextField19.getText());
        double totalProfitMicroLoan = mtotalPayedAmount - mtotalAmountOfLoan;
        double roundedTotalProfitMicroLoan = Math.round(totalProfitMicroLoan*100.0)/100.0;
        String tpm = String.valueOf(roundedTotalProfitMicroLoan);
        jTextField20.setText(tpm);

        //total profit from fixloans***********************************************
        double ftotalPayedAmount = Double.parseDouble(jTextField8.getText());
        double roundedTotalProfitFixLoan = Math.round(ftotalPayedAmount*100.0)/100.0;

        
        //total profit***************************************************************
        double totalProfit  = roundedTotalProfitMicroLoan + roundedTotalProfitFixLoan ;
        String fp = String.valueOf(totalProfit);
        jTextField9.setText(fp);

  

        //set profit share for profile 1*******************************************
        double percentageForProf1 = Double.parseDouble(jTextField3.getText());
        double shareForProf1 = totalProfit*(percentageForProf1/100);
        double roundedShareForProf1 = Math.round(shareForProf1 * 100.0)/100.0;
        String s1 = String.valueOf(roundedShareForProf1);
        jTextField6.setText(s1);
        
        
        }else if(mspa != null && fspa == null){ //************************************************************************
           
        jTextField5.setText(mspa);
            System.out.println(mspa);
        jTextField8.setText("0.00");
        
            
        //get total amountOfLoan from microloan*********************************
        String query2 = "SELECT SUM(amountOfLoan) "
        + "FROM microloan "
        + "WHERE microloan.time_stamp >= CAST(? AS DATE) AND microloan.time_stamp <= CAST(? AS DATE) "
        + "AND microloan.userId=? AND microloan.is_deleted=1 ";

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String date3 = sdf2.format(jDateChooser1.getDate());
        String date4 = sdf2.format(jDateChooser2.getDate());

        try{
            pst=conn.prepareStatement(query2);
            pst.setString(1 , date3);
            pst.setString(2 , date4);
            pst.setString(3 , User.userid);
            rs=pst.executeQuery();

            if(rs.next()){
                String sal = rs.getString("SUM(amountOfLoan)");
                double sumAmountOfLoan = Double.parseDouble(sal);
                double roundedSumAmountOfLoan = Math.round(sumAmountOfLoan*100.0)/100.0;
                String f = String.valueOf(roundedSumAmountOfLoan);
                jTextField19.setText(f);
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
        
        
        //total profit from microloans******************************************
        double mtotalPayedAmount = Double.parseDouble(jTextField5.getText());
        double mtotalAmountOfLoan = Double.parseDouble(jTextField19.getText());
        double totalProfitMicroLoan = mtotalPayedAmount - mtotalAmountOfLoan;
        double roundedTotalProfitMicroLoan = Math.round(totalProfitMicroLoan*100.0)/100.0;
        String tpm = String.valueOf(roundedTotalProfitMicroLoan);
        jTextField20.setText(tpm);
        
        //total profit**********************************************************
        double totalProfit  = roundedTotalProfitMicroLoan ;
        String fp = String.valueOf(totalProfit);
        jTextField9.setText(fp);

  

        //set profit share for profile 1****************************************
        double percentageForProf1 = Double.parseDouble(jTextField3.getText());
        double shareForProf1 = totalProfit*(percentageForProf1/100);
        double roundedShareForProf1 = Math.round(shareForProf1 * 100.0)/100.0;
        String s1 = String.valueOf(roundedShareForProf1);
        jTextField6.setText(s1);
            
        
        }else if(mspa == null && fspa != null){ //**************************************************************************
        
         jTextField8.setText(fspa);
         jTextField5.setText("0.00");
         jTextField19.setText("0.00");
         jTextField20.setText("0.00");

         
            
        //total profit from fixloans****************************************
        double ftotalPayedAmount = Double.parseDouble(jTextField8.getText());
        double roundedTotalProfitFixLoan = Math.round(ftotalPayedAmount*100.0)/100.0;
        
        
        //total profit**********************************************************
        double totalProfit  =  roundedTotalProfitFixLoan ;
        String fp = String.valueOf(totalProfit);
        jTextField9.setText(fp);

  

        //set profit share for profile 1****************************************
        double percentageForProf1 = Double.parseDouble(jTextField3.getText());
        double shareForProf1 = totalProfit*(percentageForProf1/100);
        double roundedShareForProf1 = Math.round(shareForProf1 * 100.0)/100.0;
        String s1 = String.valueOf(roundedShareForProf1);
        jTextField6.setText(s1);
        
            
        }else if(mspa == null && fspa == null){ //************************************************************************
            JOptionPane.showMessageDialog(null, "There has no finished loans yet!");
        }
        

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        String sql = "UPDATE profitshare SET totalAmountOfInvested=? WHERE id=1 AND userId=?";

        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1, jTextField1.getText());
            pst.setString(2, User.userid);
            pst.execute();

            JOptionPane.showMessageDialog(null, "Successfully Updated!");
            calPercentageOfShares();
            clearAll();

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Enter value for Total Amount Of Invetsed!");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        String sql = "UPDATE profitshare SET totalAmountOfInvested=? WHERE id=2 AND userId=?";

        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1, jTextField2.getText());
            pst.setString(2, User.userid);
            pst.execute();

            JOptionPane.showMessageDialog(null, "Successfully Updated!");
            calPercentageOfShares();
            clearAll();

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Enter value for Total Amount Of Invetsed!");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
        String mspa = null;
        String fspa = null;
//        String final1 = null;
//        String final2 = null;
        
        //get total payedAmount from microloanrepayment*******************************
        String query1 = "SELECT SUM(payedAmount) "
        + "FROM microloanrepayment "
        + "WHERE microloanrepayment.time_stamp >= CAST(? AS DATE) AND microloanrepayment.time_stamp <= CAST(? AS DATE) "
        + "AND microloanrepayment.userId=? AND microloanrepayment.is_deleted=1";

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        String date1 = sdf1.format(jDateChooser3.getDate());
        String date2 = sdf1.format(jDateChooser4.getDate());

        try{
            pst = conn.prepareStatement(query1);

            pst.setString(1 , date1);
            pst.setString(2 , date2);
            pst.setString(3 , User.userid);
            rs = pst.executeQuery();

            if(rs.next()){
                mspa = rs.getString("SUM(payedAmount)");
//                double mSumOfPayedAmount = Double.parseDouble(mspa);
//                double mRoundedSumOfPayedAmount = Math.round(mSumOfPayedAmount*100.0)/100.0;
//                final1 = String.valueOf(mRoundedSumOfPayedAmount);
                
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
       
                
        //get total payedAmount from fixloanrepayment*****************************
        //SUM(payedAmount)=totalProfit
        String query3 = "SELECT SUM(payedAmount) "
        + "FROM fixloanrepayment "
        + "WHERE time_stamp >= CAST(? AS DATE) AND time_stamp <= CAST(? AS DATE) "
        + "AND fixloanrepayment.userId=? AND fixloanrepayment.is_deleted=1 ";

        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
        String date5 = sdf3.format(jDateChooser3.getDate());
        String date6 = sdf3.format(jDateChooser4.getDate());

        try{
            pst = conn.prepareStatement(query3);

            pst.setString(1 , date5);
            pst.setString(2 , date6);
            pst.setString(3 , User.userid);
            rs = pst.executeQuery();

            if(rs.next()){

                fspa = rs.getString("SUM(payedAmount)");
//                double fSumOfPayedAmount = Double.parseDouble(fspa);
//                double fRoundedsumOfPayedAmount = Math.round(fSumOfPayedAmount*100.0)/100.0;
//                final2 = String.valueOf(fRoundedsumOfPayedAmount);

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
                
    

        
        if(mspa != null && fspa != null){   //****************************************************************************
            
        jTextField12.setText(mspa);
        jTextField11.setText(fspa);
        
        
        //get total amountOfLoan from microloan*********************************
        String query2 = "SELECT SUM(amountOfLoan) "
        + "FROM microloan "
        + "WHERE microloan.time_stamp >= CAST(? AS DATE) AND microloan.time_stamp <= CAST(? AS DATE) "
        + "AND microloan.userId=? AND microloan.is_deleted=1 ";

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String date3 = sdf2.format(jDateChooser3.getDate());
        String date4 = sdf2.format(jDateChooser4.getDate());

        try{
            pst=conn.prepareStatement(query2);
            pst.setString(1 , date3);
            pst.setString(2 , date4);
            pst.setString(3 , User.userid);
            rs=pst.executeQuery();

            if(rs.next()){
                String sal = rs.getString("SUM(amountOfLoan)");
                double sumAmountOfLoan = Double.parseDouble(sal);
                double roundedSumAmountOfLoan = Math.round(sumAmountOfLoan*100.0)/100.0;
                String f = String.valueOf(roundedSumAmountOfLoan);
                jTextField26.setText(f);
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
        
        //total profit from microloans*********************************************
        double mtotalPayedAmount = Double.parseDouble(jTextField12.getText());
        double mtotalAmountOfLoan = Double.parseDouble(jTextField26.getText());
        double totalProfitMicroLoan = mtotalPayedAmount - mtotalAmountOfLoan;
        double roundedTotalProfitMicroLoan = Math.round(totalProfitMicroLoan*100.0)/100.0;
        String tpm = String.valueOf(roundedTotalProfitMicroLoan);
        jTextField23.setText(tpm);

        //total profit from fixloans***********************************************
        double ftotalPayedAmount = Double.parseDouble(jTextField11.getText());
        double roundedTotalProfitFixLoan = Math.round(ftotalPayedAmount*100.0)/100.0;

        
        //total profit***************************************************************
        double totalProfit  = roundedTotalProfitMicroLoan + roundedTotalProfitFixLoan ;
        String fp = String.valueOf(totalProfit);
        jTextField10.setText(fp);

  

        //set profit share for profile 1*******************************************
        double percentageForProf1 = Double.parseDouble(jTextField4.getText());
        double shareForProf1 = totalProfit*(percentageForProf1/100);
        double roundedShareForProf1 = Math.round(shareForProf1 * 100.0)/100.0;
        String s1 = String.valueOf(roundedShareForProf1);
        jTextField7.setText(s1);
        
        
        }else if(mspa != null && fspa == null){ //************************************************************************
           
        jTextField12.setText(mspa);
        jTextField11.setText("0.00");
        
            
        //get total amountOfLoan from microloan*********************************
        String query2 = "SELECT SUM(amountOfLoan) "
        + "FROM microloan "
        + "WHERE microloan.time_stamp >= CAST(? AS DATE) AND microloan.time_stamp <= CAST(? AS DATE) "
        + "AND microloan.userId=? AND microloan.is_deleted=1 ";

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String date3 = sdf2.format(jDateChooser3.getDate());
        String date4 = sdf2.format(jDateChooser4.getDate());

        try{
            pst=conn.prepareStatement(query2);
            pst.setString(1 , date3);
            pst.setString(2 , date4);
            pst.setString(3 , User.userid);
            rs=pst.executeQuery();

            if(rs.next()){
                String sal = rs.getString("SUM(amountOfLoan)");
                double sumAmountOfLoan = Double.parseDouble(sal);
                double roundedSumAmountOfLoan = Math.round(sumAmountOfLoan*100.0)/100.0;
                String f = String.valueOf(roundedSumAmountOfLoan);
                jTextField26.setText(f);
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
        
        //total profit from microloans*********************************************
        double mtotalPayedAmount = Double.parseDouble(jTextField12.getText());
        double mtotalAmountOfLoan = Double.parseDouble(jTextField26.getText());
        double totalProfitMicroLoan = mtotalPayedAmount - mtotalAmountOfLoan;
        double roundedTotalProfitMicroLoan = Math.round(totalProfitMicroLoan*100.0)/100.0;
        String tpm = String.valueOf(roundedTotalProfitMicroLoan);
        jTextField23.setText(tpm);
        
        //total profit**********************************************************
        double totalProfit  = roundedTotalProfitMicroLoan ;
        String fp = String.valueOf(totalProfit);
        jTextField10.setText(fp);

  

        //set profit share for profile 1****************************************
        double percentageForProf1 = Double.parseDouble(jTextField4.getText());
        double shareForProf1 = totalProfit*(percentageForProf1/100);
        double roundedShareForProf1 = Math.round(shareForProf1 * 100.0)/100.0;
        String s1 = String.valueOf(roundedShareForProf1);
        jTextField7.setText(s1);
            
        
        }else if(mspa == null && fspa != null){ //**************************************************************************
        
         jTextField11.setText(fspa);
         jTextField12.setText("0.00");
         jTextField26.setText("0.00");
         jTextField23.setText("0.00");

         
            
        //total profit from fixloans***********************************************
        double ftotalPayedAmount = Double.parseDouble(jTextField11.getText());
        double roundedTotalProfitFixLoan = Math.round(ftotalPayedAmount*100.0)/100.0;
        
        
        //total profit**********************************************************
        double totalProfit  =  roundedTotalProfitFixLoan ;
        String fp = String.valueOf(totalProfit);
        jTextField10.setText(fp);

  

        //set profit share for profile 1****************************************
        double percentageForProf1 = Double.parseDouble(jTextField4.getText());
        double shareForProf1 = totalProfit*(percentageForProf1/100);
        double roundedShareForProf1 = Math.round(shareForProf1 * 100.0)/100.0;
        String s1 = String.valueOf(roundedShareForProf1);
        jTextField7.setText(s1);
        
            
        }else if(mspa == null && fspa == null){ //************************************************************************
            JOptionPane.showMessageDialog(null, "There has no finished loans yet!");
        }
           
        
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        
        String sql = "UPDATE profitshare SET totalAmountOfInvested=? WHERE id=3 AND userId=?";

        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1, jTextField16.getText());
            pst.setString(2, User.userid);
            pst.execute();

            JOptionPane.showMessageDialog(null, "Successfully Updated!");
            calPercentageOfShares();
            clearAll();

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Enter value for Total Amount Of Invetsed!");
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        
         String mspa = null;
         String fspa = null;
//        String final1 = null;
//        String final2 = null;
        
        //get total payedAmount from microloanrepayment*******************************
        String query1 = "SELECT SUM(payedAmount) "
        + "FROM microloanrepayment "
        + "WHERE microloanrepayment.time_stamp >= CAST(? AS DATE) AND microloanrepayment.time_stamp <= CAST(? AS DATE) "
        + "AND microloanrepayment.userId=? AND microloanrepayment.is_deleted=1";

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        String date1 = sdf1.format(jDateChooser5.getDate());
        String date2 = sdf1.format(jDateChooser6.getDate());

        try{
            pst = conn.prepareStatement(query1);

            pst.setString(1 , date1);
            pst.setString(2 , date2);
            pst.setString(3 , User.userid);
            rs = pst.executeQuery();

            if(rs.next()){
                mspa = rs.getString("SUM(payedAmount)");
//                double mSumOfPayedAmount = Double.parseDouble(mspa);
//                double mRoundedSumOfPayedAmount = Math.round(mSumOfPayedAmount*100.0)/100.0;
//                final1 = String.valueOf(mRoundedSumOfPayedAmount);
                
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
       
                
        //get total payedAmount from fixloanrepayment*****************************
        //SUM(payedAmount)=totalProfit
        String query3 = "SELECT SUM(payedAmount) "
        + "FROM fixloanrepayment "
        + "WHERE time_stamp >= CAST(? AS DATE) AND time_stamp <= CAST(? AS DATE) "
        + "AND fixloanrepayment.userId=? AND fixloanrepayment.is_deleted=1 ";

        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
        String date5 = sdf3.format(jDateChooser5.getDate());
        String date6 = sdf3.format(jDateChooser6.getDate());

        try{
            pst = conn.prepareStatement(query3);

            pst.setString(1 , date5);
            pst.setString(2 , date6);
            pst.setString(3 , User.userid);
            rs = pst.executeQuery();

            if(rs.next()){

                fspa = rs.getString("SUM(payedAmount)");
//                double fSumOfPayedAmount = Double.parseDouble(fspa);
//                double fRoundedsumOfPayedAmount = Math.round(fSumOfPayedAmount*100.0)/100.0;
//                final2 = String.valueOf(fRoundedsumOfPayedAmount);

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
                
    

        
        if(mspa != null && fspa != null){   //****************************************************************************
            
        jTextField18.setText(mspa);
        jTextField17.setText(fspa);
        
        
        //get total amountOfLoan from microloan*********************************
        String query2 = "SELECT SUM(amountOfLoan) "
        + "FROM microloan "
        + "WHERE microloan.time_stamp >= CAST(? AS DATE) AND microloan.time_stamp <= CAST(? AS DATE) "
        + "AND microloan.userId=? AND microloan.is_deleted=1 ";

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String date3 = sdf2.format(jDateChooser5.getDate());
        String date4 = sdf2.format(jDateChooser6.getDate());

        try{
            pst=conn.prepareStatement(query2);
            pst.setString(1 , date3);
            pst.setString(2 , date4);
            pst.setString(3 , User.userid);
            rs=pst.executeQuery();

            if(rs.next()){
                String sal = rs.getString("SUM(amountOfLoan)");
                double sumAmountOfLoan = Double.parseDouble(sal);
                double roundedSumAmountOfLoan = Math.round(sumAmountOfLoan*100.0)/100.0;
                String f = String.valueOf(roundedSumAmountOfLoan);
                jTextField30.setText(f);
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
        
        //total profit from microloans*********************************************
        double mtotalPayedAmount = Double.parseDouble(jTextField18.getText());
        double mtotalAmountOfLoan = Double.parseDouble(jTextField30.getText());
        double totalProfitMicroLoan = mtotalPayedAmount - mtotalAmountOfLoan;
        double roundedTotalProfitMicroLoan = Math.round(totalProfitMicroLoan*100.0)/100.0;
        String tpm = String.valueOf(roundedTotalProfitMicroLoan);
        jTextField27.setText(tpm);

        //total profit from fixloans***********************************************
        double ftotalPayedAmount = Double.parseDouble(jTextField8.getText());
        double roundedTotalProfitFixLoan = Math.round(ftotalPayedAmount*100.0)/100.0;

        
        //total profit***************************************************************
        double totalProfit  = roundedTotalProfitMicroLoan + roundedTotalProfitFixLoan ;
        String fp = String.valueOf(totalProfit);
        jTextField17.setText(fp);

  

        //set profit share for profile 1*******************************************
        double percentageForProf1 = Double.parseDouble(jTextField14.getText());
        double shareForProf1 = totalProfit*(percentageForProf1/100);
        double roundedShareForProf1 = Math.round(shareForProf1 * 100.0)/100.0;
        String s1 = String.valueOf(roundedShareForProf1);
        jTextField13.setText(s1);
        
        
        }else if(mspa != null && fspa == null){ //************************************************************************
           
        jTextField18.setText(mspa);
        jTextField17.setText("0.00");
        
            
        //get total amountOfLoan from microloan*********************************
        String query2 = "SELECT SUM(amountOfLoan) "
        + "FROM microloan "
        + "WHERE microloan.time_stamp >= CAST(? AS DATE) AND microloan.time_stamp <= CAST(? AS DATE) "
        + "AND microloan.userId=? AND microloan.is_deleted=1 ";

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String date3 = sdf2.format(jDateChooser5.getDate());
        String date4 = sdf2.format(jDateChooser6.getDate());

        try{
            pst=conn.prepareStatement(query2);
            pst.setString(1 , date3);
            pst.setString(2 , date4);
            pst.setString(3 , User.userid);
            rs=pst.executeQuery();

            if(rs.next()){
                String sal = rs.getString("SUM(amountOfLoan)");
                double sumAmountOfLoan = Double.parseDouble(sal);
                double roundedSumAmountOfLoan = Math.round(sumAmountOfLoan*100.0)/100.0;
                String f = String.valueOf(roundedSumAmountOfLoan);
                jTextField30.setText(f);
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
        
        //total profit from microloans*********************************************
        double mtotalPayedAmount = Double.parseDouble(jTextField18.getText());
        double mtotalAmountOfLoan = Double.parseDouble(jTextField30.getText());
        double totalProfitMicroLoan = mtotalPayedAmount - mtotalAmountOfLoan;
        double roundedTotalProfitMicroLoan = Math.round(totalProfitMicroLoan*100.0)/100.0;
        String tpm = String.valueOf(roundedTotalProfitMicroLoan);
        jTextField27.setText(tpm);

        
        //total profit**********************************************************
        double totalProfit  = roundedTotalProfitMicroLoan ;
        String fp = String.valueOf(totalProfit);
        jTextField15.setText(fp);

  

        //set profit share for profile 1****************************************
        double percentageForProf1 = Double.parseDouble(jTextField14.getText());
        double shareForProf1 = totalProfit*(percentageForProf1/100);
        double roundedShareForProf1 = Math.round(shareForProf1 * 100.0)/100.0;
        String s1 = String.valueOf(roundedShareForProf1);
        jTextField13.setText(s1);
            
        
        }else if(mspa == null && fspa != null){ //**************************************************************************
        
         jTextField17.setText(fspa);
         jTextField18.setText("0.00");
         jTextField30.setText("0.00");
         jTextField27.setText("0.00");

         
            
        //total profit from fixloans****************************************
        double ftotalPayedAmount = Double.parseDouble(jTextField17.getText());
        double roundedTotalProfitFixLoan = Math.round(ftotalPayedAmount*100.0)/100.0;
        
        
        //total profit**********************************************************
        double totalProfit  =  roundedTotalProfitFixLoan ;
        String fp = String.valueOf(totalProfit);
        jTextField15.setText(fp);

  

        //set profit share for profile 1****************************************
        double percentageForProf1 = Double.parseDouble(jTextField14.getText());
        double shareForProf1 = totalProfit*(percentageForProf1/100);
        double roundedShareForProf1 = Math.round(shareForProf1 * 100.0)/100.0;
        String s1 = String.valueOf(roundedShareForProf1);
        jTextField13.setText(s1);
        
            
        }else if(mspa == null && fspa == null){ //************************************************************************
            JOptionPane.showMessageDialog(null, "There has no finished loans yet!");
        }
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jTextField17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField17ActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        
        try{
            numberOnly.NumbersOnly(evt);
        
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Billing System Error");
        }
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        
        try{
            numberOnly.NumbersOnly(evt);
        
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Billing System Error");
        }
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jTextField16KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField16KeyTyped
        
        try{
            numberOnly.NumbersOnly(evt);
        
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Billing System Error");
        }
    }//GEN-LAST:event_jTextField16KeyTyped

 
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
            java.util.logging.Logger.getLogger(ProfitShare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProfitShare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProfitShare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProfitShare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProfitShare().setVisible(true);
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
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private com.toedter.calendar.JDateChooser jDateChooser5;
    private com.toedter.calendar.JDateChooser jDateChooser6;
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
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane1;
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
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField30;
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
