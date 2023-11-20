package ejercicio5a;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class AccesoAleatorio {

	public static void main(String[] args) {
		
		// Creamos la variable en la que vamos a guardar lo leido
		String leido;
		
		// Creamos el archivo que vamos a leer
		File archivo = new File("C:\\github\\segundo\\acceso a datos\\acceso a ficheros\\src\\ejercicio5\\letra.txt");
		
		// Creamos el archivo en el que vamos a escribir
		File archivo2 = new File("C:\\github\\segundo\\acceso a datos\\acceso a ficheros\\src\\ejercicio5\\escrito.txt");
		try {
			// Generamos el RandomAccessFile con el archivo que vamos a leer
			RandomAccessFile file = new RandomAccessFile(archivo, "r");
			
			// Generamos el RandomAccessFile con el archivo que vamos a escribir
			RandomAccessFile file2 = new RandomAccessFile(archivo2, "rw");
			
			// Lugar donde vamos a posicionarnos
			int posicion = 0;
			
			// Nos colocamos en la posicion
			file.seek(0);
			
			file2.seek(0);
			
			// Leemos
			leido = file.readLine();
			
			// Lo hacemos 5 veces
			for(int i = 0; i < 5; i++) {
				
				file2.writeBytes(leido);
			}
			
			// Control de excepciones
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		
	}

}
