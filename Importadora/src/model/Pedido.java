package model;
import java.util.HashMap;

public class Pedido {

    private double subtotalAutos;
    private HashMap<String,Auto> autos;
    
    public Pedido() {
        subtotalAutos = 0;
        autos = new HashMap<>();
    }
              
    public double getSubtotalAutos() { return subtotalAutos; };
    
    public void agregarAuto(Auto auto) {
        if (!autos.containsKey(auto.getVIN()) && auto.validarVIN())
            autos.put(auto.getVIN(), auto);
    }
     
    public HashMap<String,Auto> getAutos() { return autos; }

    public Auto obtenerAuto(String VIN) {
        for (String key : autos.keySet()) {
            if(key.equalsIgnoreCase(VIN))
                return autos.get(key);
        }
        return null;
    }

     public double calcularSubTotalAutos() {
        double monto = 0;
         for (String key : autos.keySet()) {
            autos.get(key).calcularSubTotal();
            monto = autos.get(key).getSubTotal();
            subtotalAutos = subtotalAutos + monto;
           }
        return subtotalAutos;
    }

     
   

    
    
}
