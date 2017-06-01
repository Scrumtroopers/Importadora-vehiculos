/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.FuncionesUsuario;

/**
 *
 * @author Bernardo
 */
public class BaseDeDatos {
    
    public static BaseDeDatos instancia = new BaseDeDatos();
    
    private FuncionesUsuario usuarios;
    private Connection conection = null;
    private Statement getStatement = null;
    private String url = "jdbc:postgresql://localhost:5432/importadora";
    private String user = "postgres";
    private String password = "";

    public BaseDeDatos(){
        //conection = DriverManager.getConnection(url, user, password);
        try {
            conection = DriverManager.getConnection(url, user, password);
            getStatement = conection.createStatement();
            System.out.println("Se conecto");
        } catch (SQLException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("no se conecto");
        }
        usuarios = new FuncionesUsuario(conection, getStatement);
    }
    
    public FuncionesUsuario getUsuarios(){
        return usuarios;
    }
}
