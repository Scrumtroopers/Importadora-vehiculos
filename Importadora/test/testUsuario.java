/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cristhian
 */
public class TestUsuario {
    
    public TestUsuario() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    /*
    @Test
    public void testRegistrarUsuario(){
        String nombre = "Alberto";
        String password = "123456";
        Usuario usuario = new Usuario(nombre,password);
        //nombre
        assertEquals(nombre,usuario.getNombre());
        //password
        assertEquals(password,usuario.getPassword());
    }*/
    
    /*
    @Test
    public void testPasswordCarEsp(){
        String nombre = "Alberto";
        String password = "@/*?¿";
        Usuario usuario = new Usuario(nombre,password);
        //nombre
        assertEquals(nombre,usuario.getNombre());
        //password
        assertEquals(password,usuario.getPassword());
    }*/
    
     /*
    @Test
    public void testPasswordLargo(){
        String nombre = "Alberto";
        int num = 40;
        String password = "";    
        for(int i=0;i<num;i++){
            password += '1';
        }
        Usuario usuario = new Usuario(nombre,password);
        //nombre
        assertEquals(nombre,usuario.getNombre());
        //password
        assertEquals(password,usuario.getPassword());
    }
    */
    
    /*
    @Test
    public void testNombreNumeros(){
        String nombre = "Alberto4654";
        String password = "123456";
        Usuario usuario = new Usuario(nombre,password);
        //nombre
        assertEquals(nombre,usuario.getNombre());
        //password
        assertEquals(password,usuario.getPassword());
    }
    */
    
    /*
    @Test
    public void testNombreLargo(){
        int num = 40;
        String nombre = "";    
        for(int i=0;i<num;i++){
            nombre += 'a';
        }       
        String password = "123456";
        Usuario usuario = new Usuario(nombre,password);
        //nombre
        assertEquals(nombre,usuario.getNombre());
        //password
        assertEquals(password,usuario.getPassword());
    }
    */
    
}
