package retoUd5;

import java.io.*;
import java.util.*;

public class Ejercicio1 {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		
		Scanner entrada=new Scanner(System.in);
		String nom_fichero="", nom_fichero1="", nom_fichero2="", nom_directorio="", ruta_fichero="", ruta_fichero1="", ruta_fichero2="", ruta_directorio="";
		File fichero1=null, fichero2=null, comp_fichero=null, directorio1=null;
					
		System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.\n" + 
							"Crearemos dos ficheros con los que vamos a realizar operaciones.\n" + 
							"Introduce a continuación sus nombres:\n");
		
		do {
			do {
				System.out.println("Nombre del 1er fichero:");
				nom_fichero1=entrada.nextLine();
				if(nom_fichero1.length()<3) {
					System.out.println("El nombre del fichero tiene que contener mínimo 3 caracteres");
				}
			}while(nom_fichero1.length()<3);
			
			nom_fichero1+=".txt";
			ruta_fichero1=System.getProperty("user.dir") + File.separator + nom_fichero1;
			fichero1 = new File(ruta_fichero1);
			
			if(comprobarExiste(fichero1)) {
				System.out.println("El fichero ya existe, introduce otro nombre.\n");
			}
		}while(comprobarExiste(fichero1));
		
		if(comprobarExiste(fichero1)==false) {
			try{
				fichero1.createNewFile();
				System.out.println("El fichero se ha creado correctamente.\n");
			}
			catch (IOException Ex) {
				System.out.println("Error E/S");
			}
		}
		
		do {
			do {
				System.out.println("Nombre del 2º fichero:");
				nom_fichero2=entrada.nextLine();
				if(nom_fichero2.length()<3) {
					System.out.println("El nombre del fichero tiene que contener mínimo 3 caracteres");
				}
			}while(nom_fichero2.length()<3);
			
			nom_fichero2+=".txt";
			ruta_fichero2=System.getProperty("user.dir") + File.separator + nom_fichero2;
			fichero2 = new File(ruta_fichero2);
			
			if(comprobarExiste(fichero2)) {
				System.out.println("El fichero ya existe, introduce otro nombre.\n");
			}
		}while(comprobarExiste(fichero2));
		
		if(comprobarExiste(fichero2)==false) {
			try{
				fichero2.createNewFile();
				System.out.println("El fichero se ha creado correctamente.\n");
			}
			catch (IOException Ex) {
				System.out.println("Error E/S");
			}
		}
		
		if (comprobarExiste(fichero1)) {
			escribirEnFichero(fichero1);
			System.out.println("Se ha escrito el contenido en el fichero: " + nom_fichero1 + ".");
		}
		
		if (comprobarExiste(fichero1)) {
			leerDeFichero(fichero1);
			System.out.println("\n" + "Se ha leído el contenido en el fichero: " + nom_fichero1 + ".\n");
		}
		
		do {
			System.out.println("Introduce el nombre de un fichero para saber sus características: ");
			nom_fichero=entrada.nextLine()+".txt";
			ruta_fichero=(System.getProperty("user.dir") + File.separator + nom_fichero);
			comp_fichero=new File(ruta_fichero);
		
			if (comprobarExiste(comp_fichero)) {
				System.out.println("\n" + "Nombre del archivo: " + comp_fichero.getName());
				System.out.println("Ruta absoluta: " + comp_fichero.getAbsolutePath());
				System.out.println("Ruta del directorio padre: " + comp_fichero.getParent());
				System.out.println("Tamaño del fichero: " + comp_fichero.length() + " bytes.");
				System.out.print("Permiso de lectura: ");
					if(comp_fichero.canRead()) {
						System.out.print("sí" + "\n");
					}
					else {
						System.out.print("no" + "\n");
					}
				System.out.print("Permiso de escritura: ");
					if(comp_fichero.canWrite()) {
						System.out.print("sí" + "\n");
					}
					else {
						System.out.print("no" + "\n");
					}
				System.out.print("Permiso de ejecución: ");
					if(comp_fichero.canExecute()) {
						System.out.print("sí" + "\n");
					}
					else {
						System.out.print("no" + "\n");
					}
				if(comp_fichero.isDirectory()){
					System.out.println("Es un directorio.");
				}
				else if(comp_fichero.isFile()){
					System.out.println("Es un archivo.");
				}
				if(comp_fichero.isHidden()){
					System.out.println("Está oculto.");
				}
				else{
					System.out.println("No está oculto.");
				}
			}
			else{
				System.out.println("El archivo introducido no existe.\n");
			}
		}while(comprobarExiste(new File(ruta_fichero))==false);
	
		entrada.close();
		
		System.out.println("\n" + "Ahora vamos a copiar el contenido del fichero1(" + nom_fichero1 + ") en el fichero2(" + nom_fichero2 + ")" );
		duplicarFicheros(fichero1, fichero2);

		System.out.println("\n" + "Una vez realizada la copia, borramos el fichero1(" + nom_fichero1 + ")");
		borrarDeFichero(fichero1);
		
		System.out.println("\n" + "Lectura del fichero2(" + nom_fichero2 + "):");
		leerDeFichero(fichero2);
		
		System.out.println("\n" + "Se crea el directorio 'dirEjer1':");
		nom_directorio="dirEjer1";
		ruta_directorio=(System.getProperty("user.dir") + File.separator + nom_directorio);
		directorio1=new File(ruta_directorio);
		
		if(comprobarExiste(directorio1)==false) {
			directorio1.mkdir();
			System.out.println("El directorio se ha creado correctamente.");
		}
		else {
			System.out.println("El directorio ya existe.");
		}
	}
	
	public static boolean comprobarExiste(File fichero) {
		return fichero.exists();
	}
	
	public static boolean leerDeFichero(File fichero) {
		FileReader leer=null;
		int c;
		
		try {
			leer = new FileReader(fichero);
			
			while((c=leer.read())!=-1) {
				System.out.print((char)c);
			}
			leer.close();
			return true;
		}
		catch (IOException ex) {
			System.out.println("Error E/S");
			return false;
		}
	}
	
	public static boolean escribirEnFichero(File fichero){
		String[] numeros= {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
		
		try {
			FileWriter escribir=new FileWriter(fichero);
			
			for(int i=0; i<numeros.length; i++) {
				if(i<=(numeros.length-1)) {
				escribir.write(numeros[i]+"\n");
				}
				else if(i==numeros.length){
					escribir.write(numeros[i]);
				}
			}
			escribir.close();
			return true;
		}
		catch(IOException ex) {
			System.out.println("Error E/S");
			return false;
		}
	}
	
	public static boolean borrarDeFichero(File fichero) {
		return fichero.delete();
	}
	
	public static void duplicarFicheros(File fichero_origen, File fichero_destino) {
		int c;
		
		try {
			FileReader leer=new FileReader(fichero_origen);
			FileWriter escribir=new FileWriter(fichero_destino);
			
			while((c=leer.read())!=-1) {
				escribir.write(c);
			}
			leer.close();
			escribir.close();
		}
		catch (IOException ex) {
			System.out.println("Error E/S");
		}
	}
}