package model;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Locale;

public class CodControl {
	String nroFact, nroAut, nit, fecha, monto, llave, ver5, cadena;
	int st;
	int[] sp;
	
	public CodControl(){}
	
	public void setNroFact(String s){
		nroFact = s;
	}
	
	public void setNroAut(String s){
		nroAut = s;
	}
	
	public void setNit(String s){
		nit = s;
	}
	
	public void setFecha(String s){
		String[] sp = s.split("/");
		fecha = "";
		for(String c:sp)
			fecha += c;
	}
	
	public void setMonto(String s){
		s = s.replace(',', '.');
		Locale.setDefault(Locale.US);
		int valor = (int)(Double.parseDouble(s) + 0.5);
		monto = "" + valor;
	}
	
	public void setLlave(String s){
		llave = s;
	}
	
	public String getVerhoeff(){
		nroFact = getVerhoeff(getVerhoeff(nroFact));
		//System.out.println(nFactVer);
		nit = getVerhoeff(getVerhoeff(nit));
		//System.out.println(nitVer);
		fecha = getVerhoeff(getVerhoeff(fecha));
		//System.out.println(fechaVer);
		monto = getVerhoeff(getVerhoeff(monto));
		//System.out.println(montoVer);
		
		BigInteger sum = new BigInteger(nroFact);
		sum = sum.add(new BigInteger(nit));
		sum = sum.add(new BigInteger(fecha));
		sum = sum.add(new BigInteger(monto));
		
		ver5 = getVerhoeff(getVerhoeff(getVerhoeff(getVerhoeff(getVerhoeff(sum.toString())))));
		//System.out.println(ver5);
		
		return ver5 = ver5.substring(ver5.length() - 5);
	}
	
	private String getVerhoeff(String cifra){
		int[][] mul = {{0,1,2,3,4,5,6,7,8,9}, {1,2,3,4,0,6,7,8,9,5}, {2,3,4,0,1,7,8,9,5,6}, {3,4,0,1,2,8,9,5,6,7}, 

{4,0,1,2,3,9,5,6,7,8}, {5,9,8,7,6,0,4,3,2,1}, {6,5,9,8,7,1,0,4,3,2}, {7,6,5,9,8,2,1,0,4,3}, {8,7,6,5,9,3,2,1,0,4}, 

{9,8,7,6,5,4,3,2,1,0}};
		int[][] per = {{0,1,2,3,4,5,6,7,8,9}, {1,5,7,6,2,8,3,0,9,4}, {5,8,0,3,7,9,6,1,4,2}, {8,9,1,6,0,4,3,5,2,7}, 

{9,4,5,3,1,2,6,8,7,0}, {4,2,8,6,5,7,3,9,0,1}, {2,7,9,3,8,0,6,4,1,5}, {7,0,4,6,9,1,3,2,5,8}};
		int[] inv = {0,4,3,2,1,5,6,7,8,9};
		int check = 0;
		
		String numeroInvertido = "";
		
		for(int i = cifra.length() - 1; i >= 0; i--)
			numeroInvertido += cifra.charAt(i);
		
		for(int i = 0; i < numeroInvertido.length(); i++)
			check = mul[check][per[(i + 1) % 8][numeroInvertido.charAt(i) - '0']];
		
		return cifra + (char) (inv[check] + '0');
	}
	
	public String getCadena(){
		
		int ini = 0;
		
		String[] subs = new String[5];
		
		for(int i = 0; i < 5; i++){
			subs[i] = llave.substring(ini, ini + ver5.charAt(i) - '0' + 1);
			ini += ver5.charAt(i) - '0' + 1;
		}
		
		//System.out.println(Arrays.toString(subs));

		StringBuilder cadena = new StringBuilder();
		
		cadena.append(nroAut);
		cadena.append(subs[0]);
		cadena.append(nroFact);
		cadena.append(subs[1]);
		cadena.append(nit);
		cadena.append(subs[2]);
		cadena.append(fecha);
		cadena.append(subs[3]);
		cadena.append(monto);
		cadena.append(subs[4]);
		
		return this.cadena = cadena.toString();
	}
	
	public String getSumatoriaProductos(){
		st = 0;
		sp = new int[5];
		
		String alleged = getAllegedRC4();
		
		for(char c : alleged.toCharArray())
			st += c;
		
		for(int i = 0; i < 5; i++)
			for(int j = i; j < alleged.length(); j += 5)
				sp[i] += alleged.charAt(j);
		
		//System.out.println(Arrays.toString(sp));
		
		return "" + st;
	}
	
	private String getAllegedRC4(){
		String key = llave + ver5, alleged = "";
		
		int[] state = new int[256];
		
		for(int i = 0; i < 256; i++)
			state[i] = i;
		
		int x = 0, y = 0, index1 = 0, index2 = 0, nmen;
		
		for(int i = 0; i < 256; i++){
			index2 = (key.charAt(index1) + state[i] + index2) % 256;
			int aux = state[i];
			state[i] = state[index2];
			state[index2] = aux;
			index1 = (index1 + 1) % key.length();
		}
		
		for(int i = 0; i < cadena.length(); i++){
			x = (x + 1) % 256;
			y = (state[x] + y) % 256;
			int aux = state[x];
			state[x] = state[y];
			state[y] = aux;
			nmen = (int)(cadena.charAt(i)) ^ (state[(state[x] + state[y]) % 256]);
			alleged += hexadecimal(nmen);
		}
		
		//System.out.println(alleged);
		 
		return alleged;
	} 
	
	static String hexadecimal(int n){
		int auxn = n;
		int d0 = n % 16;
		String hex = "";
		if(d0 < 10)
			hex += d0;
		else
			hex += (char)(d0 - 10 + 'A');
		n /= 16;
		if(n == 0)
			hex = "0" + hex;
		else{
			d0 = n % 16;
			if(d0 < 10)
				hex = d0 + hex;
			else
				hex = (char)(d0 - 10 + 'A') + hex;
		}
		return hex;
	}
	
	public String getBase64(){
		return "";
	}
	
	public static void main(String arg[]){
		CodControl cod = new CodControl();
		
		cod.setNroAut("29040011007");
		cod.setNroFact("1503");
		cod.setNit("4189179011");
		cod.setFecha("20070702");
		cod.setMonto("2500");
		cod.setLlave("9rCB7Sv4X29d)5k7N%3ab89p-3(5[A");
		
		/*
		cod.setNroAut("7904006306693");
		cod.setNroFact("876814");
		cod.setNit("1665979");
		cod.setFecha("2008/05/19");
		cod.setMonto("35958,6");
		cod.setLlave("zZ7Z]xssKqkEf_6K9uH(EcV+%x+u[Cca9T%+_$kiLjT8(zr3T9b5Fx2xG-D+_EBS");
		*/
		
		System.out.println(cod.getVerhoeff());
		
		System.out.println(cod.getCadena());
		
		System.out.println(cod.getSumatoriaProductos());
	}
}
