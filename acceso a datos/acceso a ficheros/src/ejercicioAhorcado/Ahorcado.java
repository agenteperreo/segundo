package ejercicioAhorcado;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ahorcado {

	public static void main(String[] args) {

		// Variable que leera la unica linea del fichero
		String linea;

		// Variable que almacenara la palabra en su creación y ya creada
		String palabra = "";

		// Sourroudn con try y catch
		try {
			// Abrimos el buffered reader con la ruta del fichero a leer
			BufferedReader br = new BufferedReader(new FileReader(
					"C:\\github\\segundo\\acceso a datos\\acceso a ficheros\\src\\ejercicioAhorcado\\palabras.txt"));

			// Creamos un archivo
			File fichero = new File(
					"C:\\github\\segundo\\acceso a datos\\acceso a ficheros\\src\\ejercicioAhorcado",
					"palabrasEspaciadas");

			fichero.createNewFile();

			// Abrimos el writer con el archivo que se ha creado
			BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));

			// Leemos la linea del archivo
			linea = br.readLine();

			// Dividimos la linea leida en un array de char
			char[] letras = linea.toCharArray();
			
			// Generamos una variable que nos ayudará en el bucle
			int aux=0;

			// Bucle para recorrer el array de char
			for (int i = 0; i < letras.length; i++) {

				// Montamos la palabra por cada iteración
				palabra += letras[i];
				
				// Aumentamos en 1 el valor de la auxiliar
				aux++;

				// Si la palabra tiene 5 letras
				if (aux == 5) {

					// Escribimos la palabra
					bw.write(palabra);
					
					// Generamos una nueva linea
					bw.newLine();
					
					// Reiniciamos a 0 la variable de la palabra
					palabra="";
					
					// Reiniciamos a 0 tambien la variable auxiliar
					aux = 0;
				}
			}
			
			// Limpiamos la caché del writer
			bw.flush();
			
			// Cerramos el buffered reader
			br.close();
			
			// Cerramos el buffered writer
			bw.close();
		
		// Control de excepciones	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
