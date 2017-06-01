/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import view.Verificador;

/**
 *
 * @author Bernardo
 */
public class VentanaModelo extends JFrame{
    
    protected final String tipoFuente = "Calibri";
    protected final Font fuenteBotones = new Font("Calibri", 1, 18);
    protected final Font fuenteTextField = new Font("Calibri", 0, 19);
    
    protected final Font fuenteRegular = new Font("Calibri", 1, 18);
    protected final Font fuenteSubTitulo = new Font("Calibri", 1, 20);
    protected final Font fuenteTitulo = new Font("Calibri", 1, 24);
    
    protected final int tamTitulos = 24;
    protected final int tamSubTitulos = 20;
    protected final int tamRegular = 18;
    
    protected final Color colorFondo = new Color(243, 243, 243);
    protected final Verificador verificador = Verificador.getVerificador();
    
    public VentanaModelo(String titulo){
        super(titulo);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        try {		
             for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {		
                 if ("Nimbus".equals(info.getName())) {		
                     javax.swing.UIManager.setLookAndFeel(info.getClassName());		
                     break;		
                 }		
             }		
         } catch (ClassNotFoundException ex) {		
             java.util.logging.Logger.getLogger(VentanaModelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);		
         } catch (InstantiationException ex) {		
             java.util.logging.Logger.getLogger(VentanaModelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);		
         } catch (IllegalAccessException ex) {		
             java.util.logging.Logger.getLogger(VentanaModelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);		
         } catch (javax.swing.UnsupportedLookAndFeelException ex) {		
             java.util.logging.Logger.getLogger(VentanaModelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);		
         }
    }
    
    public void ocultarVentana(){
        this.setVisible(false);
    }
    
    public void mostrarVentana(){
        this.setVisible(true);
    }
    
    protected TextField nuevoTextField(int x, int y){
		TextField campo = new TextField();
		campo.setBackground(new Color(245, 245, 245));
		campo.setFont(fuenteTextField);
		campo.setBounds(x, y, 150, 30);
		return campo;
	}
	
	
	protected JButton nuevoBoton(int x, int y, String txt){
		JButton boton = new JButton(txt);
		boton.setBackground(new Color(245, 245, 245));
		boton.setFont(fuenteBotones);
		boton.setBounds(x, y, 150, 30);
		return boton;
	}
}
