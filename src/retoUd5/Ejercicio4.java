package retoUd5;

import java.io.*;
import java.util.*;

public class Ejercicio4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String ruta_fichero=System.getProperty("user.dir") + File.separator + "persona.dat";
		File fichero1=new File(ruta_fichero);
		
		crearFichero(fichero1);
		
		System.out.println("\n" + "Se han introducido en el fichero 3 objetos de la clase 'Persona'.");
		escribirEnFichero(fichero1);
		
		System.out.println("\n" + "A continuación se muestra el contenido del fichero '" + fichero1.getName() + "'.");
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
	
	private static void escribirEnFichero(File fichero) {
		Persona persona1=new Persona("Rosa", "Luque Aguilar", 1995, 10, 05, "Córdoba", "Española", 999888777);
		Persona persona2=new Persona("Peter", "Teller", 1989, 01, 31, "Connecticut", "Estadounidense", 966555444);
		Persona persona3=new Persona("Laura", "García Baños", 1979, 05, 18, "Roma", "Italiana", 933222111);
		
		try {
			ObjectOutputStream escribir=new ObjectOutputStream(new FileOutputStream(fichero));
			escribir.writeObject(persona1);
			escribir.writeObject(persona2);
			escribir.writeObject(persona3);
			escribir.close();
		} catch (IOException e) {
			System.out.println("Error de E/S.");
		}
	}
	
	private static void leerEnFichero(File fichero) {
		try {
			ObjectInputStream lectura=new ObjectInputStream(new FileInputStream(fichero));
			Persona persona1, persona2, persona3;
			persona1=(Persona)lectura.readObject();
			persona2=(Persona)lectura.readObject();
			persona3=(Persona)lectura.readObject();
			
			System.out.println(persona1.mostrarDatos());
			System.out.println(persona2.mostrarDatos());
			System.out.println(persona3.mostrarDatos());
			lectura.close();
		}
		catch (IOException | ClassNotFoundException e) {
			System.out.println("Error de E/S.");
		}
	}
}	

	class Persona implements Serializable{
		private static final long serialVersionUID = -8691362696208151173L;
		private String nombre;
		private String apellidos;
		private Date fecha_nacimiento;
		private String ciudad_residencia;
		private String nacionalidad;
		private int telefono;

		public Persona(String nombre, String apellidos, int agno, int mes, int dia, String ciudad_residencia, String nacionalidad, int telefono) {
			this.nombre=nombre;
			this.apellidos=apellidos;
			GregorianCalendar calendario=new GregorianCalendar(agno, mes-1, dia);
			this.fecha_nacimiento=calendario.getTime();
			this.ciudad_residencia=ciudad_residencia;
			this.nacionalidad=nacionalidad;
			this.telefono=telefono;
		}

		public String getNombre() {
			return nombre;
		}
		
		public String getApellidos() {
			return apellidos;
		}
		
		public Date getFecha_nacimiento() {
			return fecha_nacimiento;
		}

		public String getCiudad_residencia() {
			return ciudad_residencia;
		}

		public String getNacionalidad() {
			return nacionalidad;
		}

		public int getTelefono() {
			return telefono;
		}
		
		public String mostrarDatos() {
			return "-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.\n" +
					"La persona tiene los siguientes atributos: \n" +
					" Nombre: " + getNombre() + "\n" +
					" Apellidos: " + getApellidos() + "\n" +
					" Fecha de nacimiento: " + getFecha_nacimiento() + "\n" +
					" Ciudad de residencia: " + getCiudad_residencia() + "\n" +
					" Nacionalidad: " + getNacionalidad() + "\n" +
					" Teléfono: " + getTelefono() + "\n";	
		}
}