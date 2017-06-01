package model;

import java.math.BigInteger;

public class CodControl {
	String nroFact, nroAut, nit, fecha, monto, llave, ver5;
	
	public CodControl(){
		
	}
	
	void setNroFact(String s){
		nroFact = s;
	}
	
	void setNroAut(String s){
		nroAut = s;
	}
	
	void setNit(String s){
		nit = s;
	}
	
	void setFecha(String s){
		fecha = s;
	}
	
	void setMonto(String s){
		monto = s;
	}
	
	void setLlave(String s){
		llave = s;
	}
	
	String getVerhoeff(){
		String nFactVer = getVerhoeff(getVerhoeff(nroFact));
		//System.out.println(nFactVer);
		String nitVer = getVerhoeff(getVerhoeff(nit));
		//System.out.println(nitVer);
		String fechaVer = getVerhoeff(getVerhoeff(fecha));
		//System.out.println(fechaVer);
		String montoVer = getVerhoeff(getVerhoeff(monto));
		//System.out.println(montoVer);
		
		BigInteger sum = new BigInteger(nFactVer);
		sum = sum.add(new BigInteger(nitVer));
		sum = sum.add(new BigInteger(fechaVer));
		sum = sum.add(new BigInteger(montoVer));
		
		ver5 = getVerhoeff(getVerhoeff(getVerhoeff(getVerhoeff(getVerhoeff(sum.toString())))));
		//System.out.println(ver5);
		
		ver5 = ver5.substring(ver5.length() - 5);
		
		return ver5;
	}
	
	private String getVerhoeff(String cifra){
		int[][] mul = {{0,1,2,3,4,5,6,7,8,9}, {1,2,3,4,0,6,7,8,9,5}, {2,3,4,0,1,7,8,9,5,6}, {3,4,0,1,2,8,9,5,6,7}, {4,0,1,2,3,9,5,6,7,8}, {5,9,8,7,6,0,4,3,2,1}, {6,5,9,8,7,1,0,4,3,2}, {7,6,5,9,8,2,1,0,4,3}, {8,7,6,5,9,3,2,1,0,4}, {9,8,7,6,5,4,3,2,1,0}};
		int[][] per = {{0,1,2,3,4,5,6,7,8,9}, {1,5,7,6,2,8,3,0,9,4}, {5,8,0,3,7,9,6,1,4,2}, {8,9,1,6,0,4,3,5,2,7}, {9,4,5,3,1,2,6,8,7,0}, {4,2,8,6,5,7,3,9,0,1}, {2,7,9,3,8,0,6,4,1,5}, {7,0,4,6,9,1,3,2,5,8}};
		int[] inv = {0,4,3,2,1,5,6,7,8,9};
		int check = 0;
		
		String numeroInvertido = "";
		
		for(int i = cifra.length() - 1; i >= 0; i--)
			numeroInvertido += cifra.charAt(i);
		
		for(int i = 0; i < numeroInvertido.length(); i++)
			check = mul[check][per[(i + 1) % 8][numeroInvertido.charAt(i) - '0']];
		
		return cifra + (char) (inv[check] + '0');
	}
	
	public static void main(String arg[]){
		CodControl cod = new CodControl();
		cod.setNroAut("29040011007");
		cod.setNroFact("1503");
		cod.setNit("4189179011");
		cod.setFecha("20070702");
		cod.setMonto("2500");
		cod.setLlave("9rCB7Sv4X29d)5k7N%3ab89p-3(5[A");
		
		System.out.println(cod.getVerhoeff());
	}
}
