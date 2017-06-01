package importadora.autos;
import java.util.ArrayList;

public class Factura {

    //private Cliente cliente;
    private double pagoTotal;
    private double iva;
    private Pedido pedido;
    
    public Factura() {
        //cliente = new Cliente();
        pedido = new Pedido();
        pagoTotal = 0;
        iva = 0;
    }
    
    public void addPedido(Pedido pedido) { this.pedido = pedido; }
    public Pedido getPedido() { return pedido; }
    public double getIVA() { return iva; }
    public void setIVA(double iva) { this.iva = iva; };

    // Get el total del pedido que se debe pagar, sin aplicar el IVA
    public double getTotalSinIVA() {
        double monto = pedido.calcularSubTotalAutos();
        pagoTotal = pagoTotal + monto;
        return pagoTotal;
    }
    
    // Calcular IVA para el total del pedido, en una sola factura -> el valor que retornar es el $ final 
     public double calcularTotalConIVA() {
        double monto = getTotalSinIVA();
        
        pagoTotal = monto + (monto * (iva/100));
        return pagoTotal;
    }
    
     
}




