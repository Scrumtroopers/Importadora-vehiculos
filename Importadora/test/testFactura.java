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
    
    @Test
    public void codigoControlTest() {
        CodControl cc = new CodControl();
        String[] factura = {"7904006306693","876814","1665979","2008/05/19","35958,60","zZ7Z]xssKqkEf_6K9uH(EcV+%x+u[Cca9T%+_$kiLjT8(zr3T9b5Fx2xG-D+_EBS","27773"},
                factura2 = {"8004005263848","673173","1666188","2008/08/10","51330,00","PNRU4cgz7if)[tr#J69j=yCS57i=uVZ$n@nv6wxaRFP+AUf*L7Adiq3TT[Hw-@wt","69999"},
                factura3 = {"7904006098968","165657","1666615","2008/06/30","96459,00","m3dcSc)Dg#SN}prtK=9xn[m+pgAxL%N67G}QfwNZM+)IzCnvP$T*qjEKhmJnaDHm","62652"},
                factura4 = {"7904004313753","826384","1666982","2008/06/22","61102,70","Ebs[$c2d2NCg5FYj@6nU5y##a5d]eDVz%]xW6bzcd}Kd)\\w\\=c+)dZHneF#bqVL@"},
                factura5 = {"1904008691195","978256","0","2008/02/01","26006,00","pPgiFS%)v}@N4W3aQqqXCEHVS2[aDw_n%3)pFyU%bEB9)YXt%xNBub4@PZ4S9)ct"};
        
        cc.setNroAut(factura[0]);
        cc.setNroFact(factura[1]);
        cc.setNit(factura[2]);
        cc.setFecha(factura[3]);
        cc.setMonto(factura[4]);
        cc.setLlave(factura[5]);
        assertEquals(factura[6], cc.getVerhoeff());
        
        cc.setNroAut(factura2[0]);
        cc.setNroFact(factura2[1]);
        cc.setNit(factura2[2]);
        cc.setFecha(factura2[3]);
        cc.setMonto(factura2[4]);
        cc.setLlave(factura2[5]);
        assertEquals(factura2[6], cc.getVerhoeff());
        
        cc.setNroAut(factura3[0]);
        cc.setNroFact(factura3[1]);
        cc.setNit(factura3[2]);
        cc.setFecha(factura3[3]);
        cc.setMonto(factura3[4]);
        cc.setLlave(factura3[5]);
        assertEquals(factura3[6], cc.getVerhoeff());
        
        cc.setNroAut(factura4[0]);
        cc.setNroFact(factura4[1]);
        cc.setNit(factura4[2]);
        cc.setFecha(factura4[3]);
        cc.setMonto(factura4[4]);
        cc.setLlave(factura4[5]);
        assertEquals(factura4[6], cc.getVerhoeff());
        
        cc.setNroAut(factura5[0]);
        cc.setNroFact(factura5[1]);
        cc.setNit(factura5[2]);
        cc.setFecha(factura5[3]);
        cc.setMonto(factura5[4]);
        cc.setLlave(factura5[5]);
        assertEquals(factura5[6], cc.getVerhoeff());
        
    }

}

