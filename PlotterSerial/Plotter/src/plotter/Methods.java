/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plotter;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author juanp
 */
public class Methods {
    
    public void getOnes(int[][] matrizL) throws InterruptedException{
        String ones="";
        for (int i = 0; i < 8; i++) {
            ones=ones+matrizL[i][0];
            TimeUnit.SECONDS.sleep((long) 3);
            JOptionPane.showMessageDialog(null,matrizL[i][0]);
        }
        
    }
    
    public void getCoordenadas(String line){
    
    
    
    }
    
    
    public void Leer(String ruta){
        try {
            Scanner input = new Scanner(new File(ruta));
            while (input.hasNextLine()) {
                String line = input.nextLine();
                System.out.println(line);
            }
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void prueba(){
        JFileChooser jf = new JFileChooser();
        jf.showOpenDialog(jf);
        File archivo = jf.getSelectedFile();
        if (archivo !=null){
            Leer(archivo.getAbsolutePath());
        }
        
        
        
    }
    
    
    
}
