package ejemplosTemario;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ud5EjemploCopiaFichero{
	public static void main(String[] args) throws IOException {
		//declaración de objetos de tipo FileReader
		FileInputStream in = null;
		FileOutputStream out = null;
		String respuesta;
		String ficheroOrigen = "ficheroOrigen.txt";
		String ficheroDestino = "ficheroDestino.txt";
		//probando usos de getProperty...
		/*Establecemos la ruta usando getProperty, para que nos cree
		el fichero en la ruta en la que estamos ahora*/
		String rutaFicheroALeer = System.getProperty("user.dir") +
		"\\" + ficheroOrigen;
		String rutaFicheroAEscribir = System.getProperty("user.dir") +
		"\\" + ficheroDestino;
		String sistemaOperativo = System.getProperty("os.name");
		System.out.println("Sistema operativo " + sistemaOperativo);
		System.out.println("La ruta de trabajo es " +
		rutaFicheroALeer);
		try {
		/*se crean los flujos de entrada y salida,
		para ello se instancian los objetos de las clases*/
		in = new FileInputStream(rutaFicheroALeer);
		out = new FileOutputStream(rutaFicheroAEscribir);
		int c;
		//cada byte se guarda en una variable de tipo int
		//Se repite el bucle mientras no sea fin de fichero
		while((c=in.read())!=-1) {
		out.write(c);
		}
		}catch(IOException ex) {
		respuesta="El fichero de lectura origen " +
		ficheroOrigen +
		" no existe, debes crearlo antes ";;
		System.out.println(respuesta);
		}finally {
		if(in!=null)
		in.close();
		if(out!=null)
		out.close();
		}
	}
}
