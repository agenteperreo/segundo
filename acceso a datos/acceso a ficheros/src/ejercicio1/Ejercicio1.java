package ejercicio1;


import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;


public class Ejercicio1 {

	public static void main(String[] args) {

		try {

			// Declaración de variables
			String directorio = "C:\\Users/igarcia";
			String directorioSup;

			// Creamos un buffered reades y le pasamos un FileReader
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\igarcia\\Downloads\\carpetas.txt"));
			
			// Variable donde guardaremos la linea leida
			String linea;

			// Lee la primera línea
			linea = br.readLine();

			// Creamos el nuevo directorio
			new File(directorio, linea).mkdir();

			// Mientas se siga leyendo algo en la linea
			while (linea != null) {

				// Guardamos la linea separada en una variable array.
				String[] datos = linea.split("/");

				// Guardamos el valor de la última posición.
				String dato = datos[datos.length - 1];

				// Si el array mide 2
				if (datos.length == 2) {

					// Generamos la nueva direccion del directorio
					directorioSup = directorio + "/" + datos[0];
					
					// Creamos el nuevo directorio
					new File(directorioSup, dato).mkdir();
					
					// Sobre escribimos la variable auxiliar
					directorioSup = directorio;

				// Si el array mide 3de longitud
				} else if (datos.length == 3) {

					// Generamos la nueva direccion del directorio
					directorioSup = directorio + "/" + datos[0] + "/" + datos[1];
					
					// Creamos el nuevo directorio
					new File(directorioSup, dato).mkdir();

				}

				// Pasamos a la siguiente línea.
				linea = br.readLine();
			}
			
			br.close();
		// Control de excepciones
		} catch (Exception e) {

			System.err.println("Error: " + e.getMessage());

		}

	}
}
