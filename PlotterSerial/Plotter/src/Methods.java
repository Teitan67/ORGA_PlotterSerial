/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author juanp
 */
public class Methods{
    ArrayList<String> Cx = new ArrayList<String>();
    ArrayList<String> Cy = new ArrayList<String>();
    int pos=0;
    int tam;
    private final pPort lpt;
   
    public Methods(){
        lpt = new pPort();
        lpt.setAllDataBits((short)0);        
    }
            
            
    
    public void getOnes(int[][] matrizL) throws InterruptedException{
        String ones="";
        for (int i = 0; i < 8; i++) {
            ones=ones+matrizL[i][0];
            TimeUnit.SECONDS.sleep((long) 3);
            JOptionPane.showMessageDialog(null,matrizL[i][0]);
        }
        
        
    }
    
    
    
    
    
    public void getCoordenadas(int[][] matrizL){
        //Obtiene todas las coordenadas (x,y)
        for (int j = 0; j < 16; j++) {
            for (int i = 0; i < 8; i++) {
                if(matrizL[i][j]==1){
                    
                    Cx.add(Integer.toString(i));
                    Cy.add(Integer.toString(j));
                }
            }
        }
        this.tam=Cx.size();
        
    }
    
    public void pushBit() throws InterruptedException {
        //PRIMERO SE PASA Y YA QUE VA EN LAS ULTIMAS POSICIONES        
        for (int i = 0; i <= 2; i++) {
            
                System.out.println("Y:");
                BitbyBit(convertTobinaryy(Cy.get(pos)));
                System.out.println("X:");
                BitbyBit(convertTobinaryx(Cx.get(pos)));
                System.out.println("--------------------Fin Linea--------------------");
                pos=pos+1;
                if (pos>(tam-1)) {
                    return;
                }
            
        }
        
        
    }
    
    public String convertTobinaryx(String numero){
        switch (numero){
            case "0":
                return "000";
            case "1":
                return "001";
            case "2":
                return "010";
            case "3":
                return "011";
            case "4":
                return "100";
            case "5":
                return "101";
            case "6":
                return "110";
            case "7":
                return "111";
        
        }
        return null;
    }
    
    public String convertTobinaryy(String numero){
        switch (numero){
        case"0":
            return "0000";
        case"1":
            return "0001";
        case"2":
            return "0010";
        case"3":
            return "0011";
        case"4":
            return "0100";
        case"5":
            return "0101";
        case"6":
            return "0110";
        case"7":
            return "0111";
        case"8":
            return "1000";
        case"9":
            return "1001";
        case"10":
            return "1010";
        case"11":
            return "1011";
        case"12":
            return "1100";
        case"13":
            return "1101";
        case"14":
            return "1110";
        case"15":
            return "1111";
            
        
        }
        return null;
    }
    
    public void BitbyBit(String coordenada) throws InterruptedException{
        //SE PASAN AL REVES
        for (int i = coordenada.length()-1 ; i >= 0; i--) {
            TimeUnit.SECONDS.sleep((long) 1);
            //JOptionPane.showMessageDialog(null,coordenada.charAt(i));
            int num=coordenada.charAt(i);
            //System.out.println(num);
            System.out.println(coordenada.charAt(i));
            if (num==49) {
                lpt.setPin((short)2, (short)1);
            }else{
                lpt.setPin((short)2, (short)0);
            }
                    
                
        }
    }
    
    
    public void Pintados() throws InterruptedException{
        for (int i = 0 ; i <= Cx.size(); i++) {
            TimeUnit.SECONDS.sleep((long) 1);
            JOptionPane.showMessageDialog(null,"X: "+Cx.get(i)+" Y: "+Cy.get(i));
        }
    
    }
    
    
    
    
    public void Leer(String ruta,Board tablero){
        try {
            Scanner input = new Scanner(new File(ruta));
            int n=0;
            
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] arreglo = line.split(" ");
                
                try{
                    int x = Integer.parseInt(arreglo[3]);
                    int y = Integer.parseInt(arreglo[6]);
                    tablero.matrizL[x][y]=1;
                    
                }catch(Exception ex){
                
                }
                    
                    
                //System.out.println(line);
                //n+=1;
            }
            tablero.repintar();
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void prueba(Board tablero){
        JFileChooser jf = new JFileChooser();
        jf.showOpenDialog(jf);
        File archivo = jf.getSelectedFile();
        if (archivo !=null){
            Leer(archivo.getAbsolutePath(),tablero);
        }
        
        
        
    }
    
    
    
}
