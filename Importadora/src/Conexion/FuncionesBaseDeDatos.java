/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bernardo
 */
public class FuncionesBaseDeDatos {
    
    private Connection conection = null;
    private Statement getStatement = null;
    
    private PreparedStatement statement = null;
    private ResultSet result = null;
    
    public FuncionesBaseDeDatos(Connection conection, Statement statement){
        this.conection = conection;
        this.getStatement = statement;
    }
    
    protected <T> T obtenerPrimerValorFuncion(String nombreFuncion, Object[] parametros){
        try{
            return (T)obtenerDeFuncion(nombreFuncion, parametros).get(0)[0];
        }
        catch(NullPointerException | IndexOutOfBoundsException e){
            return null;
        }
    }
    
    protected ArrayList<Object[]> obtenerDeFuncion(String nombreFuncion, Object[] parametros) {
        ArrayList<Object[]> resultado = null;
        try {
            int cantidad = parametros == null?0:parametros.length;
            StringBuilder paramStr = new StringBuilder();
            while(cantidad > 0){
                paramStr.append("?");
                cantidad--;
                if(cantidad>0)
                    paramStr.append(",");
            }
            statement = conection.prepareStatement("SELECT "+nombreFuncion+"("+paramStr.toString()+")");
            if(parametros != null){
                for(int i=0;i<parametros.length;i++)
                    statement.setObject(i+1, parametros[i]);
            }
            result = statement.executeQuery();
            resultado = new ArrayList<Object[]>();
            while(result.next()) {
                ArrayList<Object> valores = new ArrayList<Object>();
                int index = 0;
                boolean detener = false;
                while(!detener){
                    try{
                        valores.add(result.getObject(index+1));
                        index++;
                    }
                    catch(SQLException ex)
                    {
                        detener = true;
                    }
                }
                resultado.add(valores.toArray());
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(FuncionesBaseDeDatos.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return resultado;
    }
    
    protected <T> T obtenerPrimerValorTabla(String tabla, String[] variables, String condicion){
        try{
            return (T)obtenerDeTabla(tabla, variables, condicion).get(0)[0];
        }
        catch(NullPointerException | IndexOutOfBoundsException e){
            return null;
        }
    }
    
    protected ArrayList<Object[]> obtenerDeTabla(String tabla, String[] variables, String condicion) {
        ArrayList<Object[]> resultado = null;
        try {
            result = getStatement.executeQuery("SELECT * from "+tabla+" "+condicion);
            resultado = new ArrayList<Object[]>();
            while(result.next()) {
                ArrayList<Object> valores = new ArrayList<Object>();
                for(String variable : variables)
                    valores.add(result.getObject(variable));
                resultado.add(valores.toArray());
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(FuncionesBaseDeDatos.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return resultado;
    }
    
    protected boolean insertarEnTabla(String tabla, String[] variables, Object[] valores) {
        boolean insertado = false;
        try {
            StringBuilder sbVariables = new StringBuilder();
            StringBuilder sbValores = new StringBuilder();
            for(String variable : variables){
                sbVariables.append(variable);
                sbValores.append("?");
                if(!variable.equals(variables[variables.length - 1])){
                    sbVariables.append(", ");
                    sbValores.append(",");
                }
            }
            statement = conection.prepareStatement("INSERT INTO "+tabla+" ("+sbVariables.toString()+") VALUES ("+sbValores.toString()+")");
            for(int i=0;i<valores.length;i++){
                statement.setObject(i+1, valores[i]);
            }
            statement.executeUpdate();
            insertado = true;
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(FuncionesBaseDeDatos.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return insertado;
    }
    
    protected void actualizarTabla(String tabla, String[] variables, Object[] valores, String condicion) {   
        try {
            StringBuilder sbVals = new StringBuilder();
            for(String variable : variables){
                sbVals.append(variable+"=?");
                if(!variable.equals(variables[variables.length - 1])){
                    sbVals.append(", ");
                }
            }
            statement = conection.prepareStatement("UPDATE "+tabla+" SET "+sbVals.toString()+" "+condicion);
            for(int i=0;i<valores.length;i++){
                statement.setObject(i+1, valores[i]);
            }
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(FuncionesBaseDeDatos.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}
