import org.junit.Test;
import static org.junit.Assert.*;
import model.*;

public class testAuto {

    /*  el VIN debe ser 17 caracteres. Los primero 8 deben ser letras mayusculas, y los restantes 9
        deben ser digitos. En ese orden.
    */
    @Test
    public void validarVINTest() {
        String VIN = "ABCDEFGH123456789";
        Auto auto = new Auto(VIN,"","",600,0,0);
        assertEquals(true, auto.validarVIN());
       
        String VIN2 = "ABCDEFGH";
        Auto auto2 = new Auto(VIN2,"","",600,0,0);
        assertEquals(false, auto2.validarVIN());
         
        String VIN3 = "A1111111123456789";
        Auto auto3 = new Auto(VIN3,"","",600,0,0);
        assertEquals(false, auto3.validarVIN());
        
        String VIN4 = "A9C7G8H123456FGH";
        Auto auto4 = new Auto(VIN4,"","",600,0,0);
        assertEquals(false, auto4.validarVIN()); 
    }
    
    //subTotal de cada auto = precioVenta + precio extra (de accesorios) + garantia
    @Test
    public void calcularSubTotalTest() {
        double precioVenta = 1000;
        double gastosExtras = 200;
        double garantia = 150;
        Auto auto = new Auto();
        auto.setPrecioVenta(precioVenta);
        auto.setGastosExtras(gastosExtras);
        auto.setGarantia(garantia);
        double subtotal = auto.calcularSubTotal();
        assertEquals(1350,subtotal,0.001);
    }
}
