/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
/**
 *
 * @author juanp
 */
public class Listen extends Thread{
    
    JTextField text;
    Methods metodos;
    public Listen(JTextField h,Methods metodos){
        this.text=h;
        this.metodos=metodos;
    }
    
    
    public void Write() {
        //try{
                
            int texto=Integer.parseInt(text.getText());
            try {
                if (texto==1) {
                    try{
                    metodos.pushBit();
                    }catch(Exception ex){}
                }else{
                    
                }
                
                
                Thread.sleep(1000);
                Write();
            } catch (InterruptedException ex) {
                //Logger.getLogger(Listen.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
    
    public void run(){
        Write();
    }
    
    
}
