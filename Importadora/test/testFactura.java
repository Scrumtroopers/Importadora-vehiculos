import org.junit.Test;
import static org.junit.Assert.*;
import model.*;

public class testFactura {
    
    @Test 
    public void agregarPedidoTest() {
        Pedido pedido = new Pedido();
        
        Auto car = new Auto("ABCDEFGH123456789","","",1000,200,200);
        Auto car2 = new Auto("AABBCDEF123456677","","",200,150,200);
        
        pedido.agregarAuto(car);
        pedido.agregarAuto(car2);
        
        Factura factura = new Factura();
        factura.addPedido(pedido);

        assertEquals(2,factura.getPedido().getAutos().size());
    }
   
    @Test 
    public void calcularTotalSinIVATest() {
        Pedido pedido = new Pedido();    
        Auto car = new Auto("ABCDEFGH123456789","","",1000,100,100); //1200
        Auto car2 = new Auto("AABBCDEF123456677","","",200,200,200); //600
        pedido.agregarAuto(car);
        pedido.agregarAuto(car2);
        
        Factura factura = new Factura();
        factura.addPedido(pedido);
        assertEquals(1800,factura.getTotalSinIVA(),0.001);
        
        Pedido pedido2 = new Pedido();    
        Auto car3 = new Auto("ZXASQWER004455667","","",3000,50,50); //3100
        pedido2.agregarAuto(car3);
        
        Factura factura2 = new Factura();
        factura2.addPedido(pedido2);
        assertEquals(3100,factura2.getTotalSinIVA(),0.001);
    }
    
    @Test 
    public void calcularIVATest() {
        Pedido pedido = new Pedido();    
        Auto car = new Auto("ABCDEFGH123456789","","",1000,100,100); //1200
        Auto car2 = new Auto("AABBCDEF123456677","","",200,200,200); //600
        pedido.agregarAuto(car);
        pedido.agregarAuto(car2);
      
        Factura factura = new Factura();
        double iva = 20;
        factura.addPedido(pedido);
        factura.setIVA(iva);

        assertEquals(2160,factura.calcularTotalConIVA(),0.001); //aplicar iva = 20% al total = 4900
    }

}

