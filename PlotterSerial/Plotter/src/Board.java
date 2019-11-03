/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author juanp
 */
public class Board {
    public JPanel fondo = null;
    public JLabel [][] matrizG;
    public int [][] matrizL;
    int tamy,tamx;
    int color=0;
    
    public Board(JPanel panel){
        this.fondo=panel;
        tamy=30;
        tamx=50;
        //llenar();        
    }
    
    
    public void llenar(){
        
        matrizL = new int [tamx][tamy];
        matrizG = new JLabel [tamx][tamy];
        Random rm = new Random();       
        for (int i =0;i<8;i++){
            for(int j=0;j<16;j++){
                matrizL[i][j]=0;
            }         
        }
        repintar(); 
    }
    
    public void repintar (){
        JLabel casilla=null;
        
        for (int i=0;i<8;i++){
            for (int j=0;j<16;j++){
                if (matrizL[i][j]==0){
                    casilla = new JLabel();
                    casilla.setIcon(null);
                    fondo.repaint();
                    casilla.repaint();
                }else{
                    casilla=new JLabel();
                    casilla.setBackground(Color.BLACK);
                    casilla.setOpaque(true);
                    
                }
                
                fondo.repaint();
                casilla.repaint();
                casilla.setBorder(BorderFactory.createLineBorder(Color.BLUE));
                casilla.setBounds(i*tamx,j*tamy,tamx,tamy);
                matrizG [i][j]=casilla;
                fondo.add(matrizG[i][j],BorderLayout.CENTER);
                final JLabel aux=casilla;
                final int posi = i;
                final int posj = j;
                casilla.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                   pintarCasilla(aux,posi,posj,color);
                }
                
            });
                
                fondo.repaint();
                    
                    
            }
        }
    
    }
    
    
    
    
    public void pintarCasilla(JLabel label,int i, int j,int color){
        
        label.setText(i+" "+j);
        
        
        if (color==0) {
            if (/*label.getBackground()==Color.BLACK*/matrizL[i][j]==1) {//Esta activo
                label.setBackground(Color.LIGHT_GRAY);
                
                matrizL[i][j]=0;
            }else{//No esta activo
                label.setBackground(Color.BLACK);
                
                matrizL[i][j]=1;
            }
        }else if(color==1){
            if (label.getBackground()==Color.GREEN) {//Esta activo
                label.setBackground(Color.LIGHT_GRAY);
                matrizL[i][j]=0;
            }else{//No esta activo
                label.setBackground(Color.GREEN);
                matrizL[i][j]=1;
            }                      
        
        }else if(color==2){
            if (label.getBackground()==Color.BLUE) {//Esta activo
                label.setBackground(Color.LIGHT_GRAY);
                matrizL[i][j]=0;
            }else{//No esta activo
                label.setBackground(Color.BLUE);
                matrizL[i][j]=1;
            }
        }
        
        
        
        label.setOpaque(true);
        
    }
    
}
