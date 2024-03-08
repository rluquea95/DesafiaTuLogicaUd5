package retoUd5;

import java.io.*;
import java.util.*;

public class Ejercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String ruta_fichero=System.getProperty("user.dir") + File.separator + "tres.dat";
		
		File fichero1=new File (ruta_fichero);
		crearFichero(fichero1);
		
		System.out.println("\n" + "Introduce números positivos para almacenarlos en el fichero creado.");
		escribirEnConsola(fichero1);
		
		System.out.println("\n" + "Lectura del contenido del archivo '" + fichero1.getName() + "'.");
		leerEnFichero(fichero1);
	}

	private static void crearFichero(File fichero) {
		try {
			if(fichero.exists()==false) {
				fichero.createNewFile();
				System.out.println("Se ha creado el fichero '" + fichero.getName() + "'.");
			}
			else {
				System.out.println("El fichero ya existe.");
			}
		}
		catch (IOException e) { 
			System.out.println("Error de E/S.");
		}
	}
	
	private static void escribirEnConsola(File fichero) {
		try {
			Scanner entrada=new Scanner(System.in);
			ObjectOutputStream escribir=new ObjectOutputStream(new FileOutputStream(fichero));
			int numero;
			
			System.out.println("\n" + "Introduce un número y pulsa 'Enter' para continuar introduciendo más. Cuando no quieras introducir más inserta un número negativo.");
			do{
				numero=entrada.nextInt();
				if(numero>=0) {
					escribir.write(numero);
				}
			}while(numero>=0);
			entrada.close();
			escribir.close();
		} 
		catch (IOException e) {
			System.out.println("Error de E/S.");
		}
		catch (InputMismatchException ex) {
			System.out.println("Sólo pueden introducirse valores numéricos.");
			escribirEnConsola(fichero);
		}
	}
	
	private static void leerEnFichero(File fichero) {
		try{
			ObjectInputStream leer= new ObjectInputStream(new FileInputStream(fichero));
			int numero;
			
			while((numero=leer.read()) != -1) {
				System.out.println(numero);
			}
			leer.close();
		}
		catch (IOException e) {
			System.out.println("Error de E/S.");
		}
	}
}