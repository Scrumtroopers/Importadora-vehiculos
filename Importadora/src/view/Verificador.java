/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;
import javax.swing.JFrame; 

/**
 *
 * @author Cristhian
 */
public class Verificador extends JFrame{
    
    private static Verificador verificador;
    
    private Verificador(){
    }
    
    public static Verificador getVerificador(){
        if(verificador==null){
            verificador = new Verificador();
        }
        return verificador;
    }



//admite solo numeros decimales
    protected void SDec(JTextField a){
	        a.addKeyListener(new KeyAdapter(){
                    @Override
	            public void keyTyped(KeyEvent e){
	                  char c=e.getKeyChar();
	                  if(!Character.isDigit(c)&&c!='.'){
	                      getToolkit().beep();
	                      e.consume();
	                  }
	            }
	        });
    }
    
    //admite solo numeros enteros
    protected void SInt(JTextField a){
	        a.addKeyListener(new KeyAdapter(){
                    @Override
	            public void keyTyped(KeyEvent e){
	                  char c=e.getKeyChar();
	                  if(!Character.isDigit(c)){
	                      getToolkit().beep();
	                      e.consume();
	                  }
	            }
	        });
    }
    
    
    //admite solo letras
    protected void SLetra(JTextField a){
	        a.addKeyListener(new KeyAdapter(){
                    @Override
	            public void keyTyped(KeyEvent e){
	                  char c=e.getKeyChar();
	                  if(!Character.isLetter(c)){
	                      getToolkit().beep();
	                      e.consume();
	                  }
	            }
	        });
    }
    
    
    //admite solo numeros enteros
    protected void SMin(JTextField a){
	        a.addKeyListener(new KeyAdapter(){
                    @Override
	            public void keyTyped(KeyEvent e){
	                  char c=e.getKeyChar();
	                  if(!Character.isLowerCase(c)){
	                      getToolkit().beep();
	                      e.consume();
	                  }
	            }
	        });
    }
    
    //admite solo numeros enteros
    protected void SMayus(JTextField a){
	        a.addKeyListener(new KeyAdapter(){
                    @Override
	            public void keyTyped(KeyEvent e){
	                  char c=e.getKeyChar();
	                  if(!Character.isUpperCase(c)){
	                      getToolkit().beep();
	                      e.consume();
	                  }
	            }
	        });
    }
    
    
    protected double getDouble(JTextField tf){
            double numero=0.0;
            String num = tf.getText();

         try {numero = Double.parseDouble(num);

         } catch( Exception e){
             System.out.println("numero incorrecto");
         }
         return numero;

    }
    
    protected int getInt(JTextField tf){
            int numero=0;
            String num = tf.getText();

         try {numero = Integer.parseInt(num);

         } catch( Exception e){
             System.out.println("numero incorrecto");
         }
         return numero;

    }
}
