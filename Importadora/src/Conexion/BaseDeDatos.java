/*
 * En esta clase se realiza la conexion con la Base de datos
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.FuncionesInventario;
import model.FuncionesUsuario;

/**
 *
 * @author Bernardo
 */
public class BaseDeDatos {
    
    //Instancuia estatica de la Base de datos para que sea accesible desde cualquier parte
    public static BaseDeDatos instancia = new BaseDeDatos();
    
    private FuncionesUsuario usuarios;
    private FuncionesInventario inventario;
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
        inventario = new FuncionesInventario(conection, getStatement);
        
    }
    
    public FuncionesUsuario getUsuarios(){
        return usuarios;
    }

    public FuncionesInventario getInventario() {
        return inventario;
    }
}
