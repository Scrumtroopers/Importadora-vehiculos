/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bernardo
 */
public class AdministradorVentanas {
    
    private Stack<String> ventanasAnteriores;
    private Map<String, VentanaModelo> instancias;
    private String ventanaActual;
    
    public AdministradorVentanas(){
        ventanasAnteriores = new Stack<String>();
        instancias = new HashMap<String, VentanaModelo>() {};
        ventanaActual = "";
    }
    
    public <T extends VentanaModelo> void abrirVentana(Class<T> clase){
        try {
            VentanaModelo ventana;
            if(!ventanaActual.equals(clase.getName()))
            {
                ventanasAnteriores.push(ventanaActual);
                ventanaActual = clase.getName();
                if(instancias.containsKey(ventanaActual)){
                    ventana = instancias.get(ventanaActual);
                }
                else{
                    ventana = clase.newInstance();
                    instancias.put(ventanaActual, ventana);
                }
                ventana.mostrarVentana();
            }
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(AdministradorVentanas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
