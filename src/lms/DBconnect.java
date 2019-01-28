package lms;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class DBconnect {
    public static Connection connect(){
        Connection conn=null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
//            conn = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/loanmsystem","kalana","kalana@1234");
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lmdb","root","");
//            conn = DriverManager.getConnection("jdbc:mysql://dbloanmanagement.cvys8pawj1ux.us-east-2.rds.amazonaws.com:3306/lmdb","LM_user","kalana123");
              conn = DriverManager.getConnection("jdbc:mysql://13.233.245.5:3306/admin_lmdb","admin_chathumal","chathumal123");
//            conn = DriverManager.getConnection("jdbc:mysql://13.127.66.11:3306/admin_lmdb","admin_kalana","kalana123");
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "check your internet connection and try agin!");
        }
        return conn;
    } 
    
}
