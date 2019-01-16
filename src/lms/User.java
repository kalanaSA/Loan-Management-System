package lms;


import java.awt.event.KeyEvent;


public class User {
    
    public static String username;
    public static String userid;

    
    
    public void NumbersOnly(java.awt.event.KeyEvent evt){
        
        char iNumber = evt.getKeyChar();
        if(!(Character.isDigit(iNumber))
                ||(iNumber == KeyEvent.VK_BACK_SPACE)
                ||(iNumber == KeyEvent.VK_DELETE)){
            
            evt.consume();
        }
    }
    
    
    
}
