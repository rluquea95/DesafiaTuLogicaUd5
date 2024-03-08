package retoUd5;

import java.io.*;

public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String ruta_directorio=System.getProperty("user.dir") + File.separator + "dirEjer2";
		String ruta_fichero1=ruta_directorio + File.separator + "uno.txt";
		String ruta_fichero2=ruta_directorio + File.separator + "dos.txt";
		
		File directorio1=new File(ruta_directorio);
		File fichero1=new File(ruta_fichero1);
		File fichero2=new File(ruta_fichero2);
		
				
		System.out.println("El directorio actual es: " + System.getProperty("user.dir"));
		System.out.println("\n" + "A continuación se crea el directorio 'dirEjer2'.");		
		crearDirectorio(directorio1);
		
		System.out.println("\n" + "Dentro del directorio '" + directorio1.getName()+ "' se crean dos ficheros:");
		crearFichero(fichero1);
		crearFichero(fichero2);
		
		System.out.println("\n" + "Dentro del fichero '" + fichero2.getName() + "' introduciremos datos para almacenarlos.");
		escribirEnConsola(fichero2);
		
		System.out.println("\n" + "Lectura del contenido del fichero '" + fichero2.getName() + "':");
		mostrarEnConsola(fichero2);
		
	}
	
	public static void crearDirectorio (File directorio) {
		if(directorio.exists()==false) {
			directorio.mkdir();
			System.out.println("Se ha creado el directorio '" + directorio.getName() + "'.");
		}
		else {
			System.out.println("El directorio ya existe.");
		}
	}
	
	public static void crearFichero(File fichero) {
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
	
	public static void escribirEnConsola(File fichero) {	
		try {
			BufferedWriter escritura = new BufferedWriter(new FileWriter(fichero));
			BufferedReader lectura=new BufferedReader(new InputStreamReader(System.in));
			String nombre;
			
			System.out.println("Introduce un nombre y pulse 'Enter' para continuar introduciendo más. Cuando no quieras introducir más pulsa '-'.");
			do {
				nombre=lectura.readLine();
				if(nombre.equals("-")==false) {
					escritura.write(nombre + "\n");
				}
			}while(nombre.equals("-")==false);
			escritura.close();
			lectura.close();
		}
		catch(IOException e) {
			System.out.println("Error E/S");
		}		
	}
	
	public static void mostrarEnConsola(File fichero) {
		try {
			BufferedReader leer=new BufferedReader(new FileReader(fichero));
			String c;
			
			while((c=leer.readLine())!=null) {
				System.out.println(c);	
			}
			leer.close();
		}
		catch(IOException e) {
			System.out.println("Error E/S");
		}
	}
}