package model;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Auto {
    private String VIN;
    private String modelo;
    private String marca;
    private double precioVenta;
    
    private double garantia;
    private double gastosExtras;
    private double subTotal;
       
    public Auto() {
    }
    
    public Auto(String VIN, String modelo, String marca, double precioVenta, double garantia, double gastosExtras) {
        this.VIN = VIN;
        this.precioVenta = precioVenta;
        this.modelo = modelo;
        this.marca = marca;
        this.gastosExtras = gastosExtras;
        this.garantia = garantia;
        subTotal = 0;
    }
    
    public String getVIN() { return VIN; };
    public void setVIN(String VIN) { this.VIN = VIN; };
    public double getGastosExtras() { return gastosExtras; };
    public double getPrecioVenta() { return precioVenta; };
    public double getSubTotal() { return subTotal; };
    public String getModelo() { return modelo; };
    public String getMarca() { return marca; };
    public void setGastosExtras(double gastosExtras) { this.gastosExtras = gastosExtras; };
    public void setPrecioVenta(double precioVenta) { this.precioVenta = precioVenta; };
    public void setGarantia(double garantia) { this.garantia = garantia; };
    public void setModelo(String modelo) { this.modelo = modelo; };
    public void setMarca(String marca) { this.marca = marca; };
    
    public double calcularSubTotal() {
        subTotal = precioVenta + gastosExtras + garantia;
        return subTotal;
    }
        
    public boolean validarVIN() {
        boolean resp = false;
        
        List<String> output = new ArrayList<String>();
        Matcher match = Pattern.compile("[A-Z]+|[0-9]+").matcher(VIN);
        while (match.find()) {
            output.add(match.group());
        }
        if (output.size() != 2)
            return resp;
        
        String getChar = output.get(0);
        String getInt = output.get(1);
            
        if (getChar.length()==8 && getInt.length()==9) {
            for (int i=0; i<getChar.length(); i++) {
                if (getChar.charAt(i) >= 65 && getChar.charAt(i) <=90)
                    resp = true;
                else break;
            }
        }
        return resp;
    }

/*
modelo de vehículo, estado, combustible, tipo de caja, número VIN, color, fabricante, descripción, costo, observaciones.
*/
   
}
