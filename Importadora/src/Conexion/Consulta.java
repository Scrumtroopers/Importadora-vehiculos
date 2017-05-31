package Conexion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.Usuario;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ariel
 */
public class Consulta {

    Connection conection = null;
    Statement getStatement = null;
    PreparedStatement statement = null;
    ResultSet result = null;
    ResultSet userID = null;

    String url = "jdbc:postgresql://localhost:5432/importadora";
    String user = "postgres";
    String password = " ";
    int id;

    public Consulta() throws SQLException {
        //conection = DriverManager.getConnection(url, user, password);
        try {
            conection = DriverManager.getConnection(url, user, password);
            getStatement = conection.createStatement();
            System.out.println("Se conecto");
        } catch (SQLException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("no se conecto");
        }
    }

    public int getPid(String name, String pass) {

        try {
            result = getStatement.executeQuery(String.format("SELECT pid('%s','%s')", name, pass));

            if (result.next()) {
                return Integer.parseInt(result.getString(1));
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Consulta.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return 0;
    }

    public int getIdUser(int pid) {
        try {
            result = getStatement.executeQuery(String
                    .format("SELECT user_2_iduser FROM sesion WHERE pid = %d", pid));

            if (result.next()) {
                return Integer.parseInt(result.getString(1));
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Consulta.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return 0;
    }

    public Usuario recuperarUsuario(String nombre, String password_2) {
        Usuario usuario = null;
        try {
            result = getStatement.executeQuery(String.format("SELECT * FROM user_2 WHERE nombre = '%s' AND password_2 = '%s'", nombre, password_2));
            if (result.next()) {
                usuario = new Usuario(nombre, password_2);
                return usuario;
            }
            return usuario;

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Consulta.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            return null;
        }
    }

    public boolean cerrarSesion() {
        try {
            result = getStatement.executeQuery("SELECT cerrar_sesion();");
            return true;

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Consulta.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            return false;
        }

    }
    
     public void crearUsuario(Usuario usuario) {   
        try {
            statement = conection.prepareStatement("INSERT INTO user_2 (nombre, password_2) VALUES (?,?)");
            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getPassword());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Consulta.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
    
}
