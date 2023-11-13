package ejercicioFicheroAleatorio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LecturaYEscritura {

	public static void main(String[] args) {
		
		// Variable que va a almacenar la palabra leida
		String palabra;
		
		// ArrayList que va a almacenar todas las palabras del archivo leido
		List<String> palabras = new ArrayList<String>();
		
		try {
			// Abrimos el bufferedReader con el fichero a leer
			BufferedReader br = new BufferedReader(new FileReader("C:\\github\\segundo\\acceso a datos\\acceso a ficheros\\src\\ejercicioFicheroAleatorio\\palabrasEspaciadas"));
			
			// Leemos la linea
			palabra = br.readLine();
			
			// Mientras haya lineas
			while(palabra != null) {
				
				// Añadimos la palabra leida al ArrayList
				palabras.add(palabra);
				
				// Leemos la siguiente linea
				palabra = br.readLine();
			}
			
			// Ordenamos el ArrayList de manera inversa
			Collections.sort(palabras);
			
			// Creamos el fichero en el que vamos a escribir las palabras ordenadas
			File ficheroOrdenado = new File("C:\\github\\segundo\\acceso a datos\\acceso a ficheros\\src\\ejercicioFicheroAleatorio", "palabrasOrdenadas.txt");
			
			// Abrimos el BufferedWriter con el fichero creado
			BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroOrdenado));
			
			// Recorremos el ArrayList
			for(String pal:palabras) {
				
				// Escribimos la palabra
				bw.write(pal);
				
				// Saltamos a la siguiente linea
				bw.newLine();
			}
			
			// Cerramos el reader
			br.close();
			
			// Cerramos el writer
			bw.close();
			
		// Control de excepciones
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
			System.err.println("ERROR: Fallo al leer el fichero");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
