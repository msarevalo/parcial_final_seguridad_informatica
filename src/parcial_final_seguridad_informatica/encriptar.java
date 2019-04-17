package parcial_final_seguridad_informatica;

import java.lang.Math;
import java.security.spec.ECField;
import java.util.ArrayList;
import java.util.Scanner;

public class encriptar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Character> abc = new ArrayList<>();
		
		abc.add('a'); abc.add('b');
		abc.add('c'); abc.add('d');
		abc.add('e'); abc.add('f');
		abc.add('g'); abc.add('h');
		abc.add('i'); abc.add('j');
		abc.add('k'); abc.add('l');
		abc.add('m'); abc.add('n');
		abc.add('ñ'); abc.add('o');
		abc.add('p'); abc.add('q');
		abc.add('r'); abc.add('s');
		abc.add('t'); abc.add('u');
		abc.add('v'); abc.add('w');
		abc.add('x'); abc.add('y');
		abc.add('z'); abc.add('_');
		
		String cadena = "anti";
		cadena = cadena.replace(" ", "_");
		cadena = cadena.toLowerCase();
		double acumulado = 0;
		double valor = 0;
		double base = Math.pow(28, 4);
		double a = 0;
		double b = 0;
		double ae = 0;
		double be = 0;
		int primero = 0;
		int segundo = 0;
		Scanner usera = new Scanner(System.in);
		Scanner userb = new Scanner(System.in);
		
		while(primero == 0) {
			System.out.println("Ingresar la primera clave: ");
			ae = usera.nextDouble();
			if(ae>=307329) {
				if(ae<=base) {
					if(MCD_Euclides(ae, base)==1) {
						a = ae;
						primero++;
					}else {
						System.out.println("La clave ingresada no tiene primo relativo, por favor ingresala nuevamente");
					}
				}else {
					System.out.println("La clave ingresada debe ser menor o igual a 614656, por favor ingresala nuevamente");
				}
			}else {
				System.out.println("La clave ingresada debe ser mayor o igual a 307329, por favor ingresala nuevamente");
			}
		}
	    
		while(segundo == 0) {
			System.out.println("Ingresar la segunda clave: ");
			be = userb.nextDouble();
			if(be>=307329) {
				if(be<=base) {
					b = ae;
					segundo++;
				}else {
					System.out.println("La clave ingresada debe ser menor o igual a 614656, por favor ingresala nuevamente");
				}
			}else {
				System.out.println("La clave ingresada debe ser mayor o igual a 307329");
			}
		}

		//System.out.println(MCD_Euclides(a, base));
		//System.out.println(abc.indexOf('z'));
		
		for (int i=0; i<cadena.length(); i++) {
			//System.out.println(cadena.charAt(i));
			if (i==0) {
				valor = abc.indexOf(cadena.charAt(i)) * Math.pow(28,3);
			}
			if (i==1) {
				valor = abc.indexOf(cadena.charAt(i)) * Math.pow(28,2);
			}
			if (i==2) {
				valor = abc.indexOf(cadena.charAt(i)) * Math.pow(28,1);
			}
			if (i==3) {
				valor = abc.indexOf(cadena.charAt(i)) * Math.pow(28,0);
			}
			acumulado = acumulado + valor;
		}
		
		//System.out.println(acumulado);
		
		double e = ((a*acumulado)+b)%base;

		int letra1 = (int)(e / Math.pow(28, 3));
		int letra2 = (int)((e % Math.pow(28, 3)) / Math.pow(28, 2));
		int letra3 = (int)(((e % Math.pow(28, 3)) % Math.pow(28, 2)) / Math.pow(28, 1));
		int letra4 = (int)(e % 28);
		
		String encriptado;
		encriptado = abc.get(letra1) + "" + abc.get(letra2) + "" + abc.get(letra3) + "" + abc.get(letra4);
		
		System.out.println(encriptado);
		//System.out.println(abc.get(letra1) + " " + abc.get(letra2) + " " + abc.get(letra3) + " " + abc.get(letra4));

	}
	
	private static double MCD_Euclides(double a, double b){
	    while(b != 0){
	         double t = b;
	         b = a % b;
	         a = t;
	    }
	    return a;
	}

}
