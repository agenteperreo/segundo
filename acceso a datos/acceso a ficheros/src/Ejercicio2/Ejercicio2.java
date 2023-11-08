package Ejercicio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio2 {
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
					
					//Creamos el index
					creaHTML(directorioSup, datos[0]);

					// Sobre escribimos la variable auxiliar
					directorioSup = directorio;

					// Si el array mide 3de longitud
				} else if (datos.length == 3) {

					// Generamos la nueva direccion del directorio
					directorioSup = directorio + "/" + datos[0] + "/" + datos[1];

					// Creamos el nuevo directorio
					new File(directorioSup, dato).mkdir();
					
					creaHTML(directorioSup, datos[1]);
					
					creaHTML(directorioSup+"/"+datos[2], datos[2]);

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

	public static void creaHTML(String path, String nomCarpeta) {

		// Variables
		File fichero = new File(path, "index.html");
		String autor = "Isaac García";

		try {

			// Creamos el archivo html.
			if (fichero.createNewFile()) {

				// BufferedWriter: escribe en el fichero que nos hemos creado.
				BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));

				// Escribimos lo que sea

				bw.write("<html>");
				bw.newLine();

				bw.write("<head>");
				bw.newLine();

				bw.write("<title>" + nomCarpeta + "</title>");
				bw.newLine();

				bw.write("</head>");
				bw.newLine();

				bw.write("<body>");
				bw.newLine();

				bw.write("<h1>Ruta: " + path + "</h1");
				bw.newLine();
				
				bw.write("<h1>nombre de la carpeta: "+nomCarpeta+"</h1>");
				bw.newLine();

				bw.write("<h3>Autor: " + autor + "</h3>");
				bw.newLine();

				bw.write("</body>");
				bw.newLine();

				bw.write("</html>");
				bw.newLine();

				// Guardamos
				bw.flush();

			}

		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}
