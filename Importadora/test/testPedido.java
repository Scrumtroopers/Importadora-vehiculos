import org.junit.Test;
import static org.junit.Assert.*;
import model.*;

public class testPedido {

    // Si al agregar el auto el VIN no es valido, no se agrega al pedido
    @Test 
        public void agregarAutoTest() {
        double precioVenta = 1000;
        double gastosAccesorios = 200;
        double garantia = 200;
        String VIN = "ABCDEFGH123456789";
        Auto car = new Auto();
        Pedido pedido = new Pedido();

        car.setPrecioVenta(precioVenta);
        car.setGastosExtras(gastosAccesorios);
        car.setGarantia(garantia);
        car.setVIN(VIN);
        pedido.agregarAuto(car);
        
        Auto car2 = new Auto("AABBCDEF123456677","","",500,500,500);
        pedido.agregarAuto(car2);
        
        Auto car3 = new Auto("AABB123456688CDEF","","",500,500,500); // no es VIN valido, entonces no se considera
        pedido.agregarAuto(car3);
        
        assertEquals(2,pedido.getAutos().size());
    }
    
    // Recibir un auto segun su VIN
    @Test 
    public void obtenerAutoTest() {
        double precioVenta = 1000;
        double gastosAccesorios = 200;
        double garantia = 200;
        String VIN = "ABCDEFGH123456789";
        Auto car = new Auto();
        Pedido pedido = new Pedido();

        car.setPrecioVenta(precioVenta);
        car.setGastosExtras(gastosAccesorios);
        car.setGarantia(garantia);
        car.setVIN(VIN);
        pedido.agregarAuto(car);
        
        Auto car2 = new Auto("AABBCDEF123456677","","",500,500,500);
        pedido.agregarAuto(car2);
       
        assertEquals(car2,pedido.obtenerAuto("AABBCDEF123456677"));
        assertNotSame(car2,pedido.obtenerAuto(VIN));
    }
    
    // Calcular el subtotal de todos los autos, para mandar ese dato a la factura, donde se calculara el IVA y precio total  
    @Test 
    public void calcularSubTotalAutosTest() {

        Pedido pedido = new Pedido();
        
        Auto car = new Auto("ABCDEFGH123456789","","",1000,200,200);
        Auto car2 = new Auto("AABBCDEF123456677","","",200,150,200);
        
        pedido.agregarAuto(car);
        pedido.agregarAuto(car2);
        //actualiza el subtotal de todo el pedido
        double subtotalAutos = pedido.calcularSubTotalAutos();
        
        assertEquals(1950,subtotalAutos,0.001);
    }
    
}

