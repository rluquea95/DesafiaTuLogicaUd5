package ejemplosTemario;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PruebaFactura {
static String archDatos = "Factura.txt";
static final double[] precios = {18.00, 160.00, 25.00, 14.00, 2.50};
static final int[] cants = {4,2,1,4,50};
static final String[] items = {"Marcador Azul", "Papel A4 500 hojas", "Borrador", "DVD", "Sobres A4"};
public static void main(String[] args) throws IOException {
/*se crea un objeto DataOutputStream para escribir datos en el
archivo de texto*/
DataOutputStream out = null;
try {
out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(archDatos)));
for(int i =0; i< precios.length;i++) {
out.writeDouble(precios[i]);
out.writeInt(cants[i]);
out.writeUTF(items[i]);
}
}catch(IOException ex) {
System.out.println("Error E/S");
}finally {
//cerramos flujo y liberamos recursos.
out.close();
}
}
}
