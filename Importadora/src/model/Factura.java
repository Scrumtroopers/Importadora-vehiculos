/*
package importadora.autos;
import java.util.ArrayList;

public class Factura {

    //private Cliente cliente;
    private double pagoTotal;
    private double iva;
    private ArrayList<Pedido> pedidos;
    
    public Factura() {
        //cliente = new Cliente();
        pedidos = new ArrayList<>();
        pagoTotal = 0;
        iva = 0;
    }
    
    public void addPedido(Pedido pedido) { pedidos.add(pedido); }
    public ArrayList<Pedido> getPedidos() { return pedidos; }
    public double getIVA() { return iva; }
    public void setIVA(double iva) { this.iva = iva; };

    public double getTotalSinIVA() {
        double monto = 0;
        for (int i=0; i < pedidos.size(); i++) {
            monto = pedidos.get(i).calcularSubTotalAutos();
            pagoTotal = pagoTotal + monto;
        }
        return pagoTotal;
    }
    
    //calcular iva para el total de todos los pedidos, en una sola factura
     public double calcularTotalConIVA() {
        double monto = getTotalSinIVA();
        
        pagoTotal = monto + (monto * (iva/100));
        return pagoTotal;
    }
    
     
}
*/
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

    public double getTotalSinIVA() {
        double monto = pedido.calcularSubTotalAutos();
        pagoTotal = pagoTotal + monto;
        return pagoTotal;
    }
    
    //calcular IVA para el total de todos los pedidos, en una sola factura
     public double calcularTotalConIVA() {
        double monto = getTotalSinIVA();
        
        pagoTotal = monto + (monto * (iva/100));
        return pagoTotal;
    }
    
     
}




