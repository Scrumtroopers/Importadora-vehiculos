/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Conexion.FuncionesBaseDeDatos;
import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author ariel
 */
public class FuncionesInventario extends FuncionesBaseDeDatos {
    
    public FuncionesInventario(Connection conexion, Statement statement){
        super(conexion, statement);
    }
    
    
}
