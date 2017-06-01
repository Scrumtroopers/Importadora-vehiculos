/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;

/**
 *
 * @author Bernardo
 */
public class VentanaModelo extends JFrame{
    
    protected final String tipoFuente = "Calibri";
    protected final Font fuenteBotones = new Font("Calibri", 1, 18);
    protected final Font fuenteTextField = new Font("Calibri", 0, 19);
    protected final int tamTitulos = 24;
    protected final int tamSubTitulos = 20;
    protected final int tamRegular = 18;
    protected final Color colorFondo = new Color(243, 243, 243);
    
    public VentanaModelo(){
        
    }
    
    public void ocultarVentana(){
        this.setVisible(false);
    }
    
    public void mostrarVentana(){
        this.setVisible(true);
    }
}
