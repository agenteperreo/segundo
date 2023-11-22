package ejercicio5c;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class AccesoAleatorio {

	public static void main(String[] args) {
		
		try {
			// Creamos el File con el archivo de lectura
			File lectura = new File("C:\\github\\segundo\\acceso a datos\\acceso a ficheros\\src\\ejercicio5b\\lectura.txt");
				
			// Creamos el acceso aleatorio con el archivo y solo modo lectura
			RandomAccessFile raf1 = new RandomAccessFile(lectura, "r");
			
			// Seteamos la posicion a 0
			raf1.seek(0);
			
			// Creamos las variables para la linea y para el global de las lineas
			String linea="", aux="";
			
			// Creamos el File con el archivo de escritura
			File escritura = new File("C:\\github\\segundo\\acceso a datos\\acceso a ficheros\\src\\ejercicio5b\\escritura.txt");
			
			// Creamos el acceso aleatorio con el archivo de escrtura en modo rw
			RandomAccessFile raf2 = new RandomAccessFile(escritura, "rw");
			
			// Seteamos la posicion al final
			raf2.seek(raf2.length());
			
			// Leemos la linea
			linea=raf1.readLine();
			
			// Mientras la linea no esté vacia
			while(linea != null) {
				
				// Añadimos la linea a la variable auxiliar
				aux += linea;
				
				// Leemos la siguiente linea
				linea=raf1.readLine();
			}
			
			// Cerramos el acceso aleatorio de la lectura
			raf1.close();
			
			// Llamamos a la funcion que escribe al revés
			ficheroReversa(aux, raf2);
			
		//Control de excepciones
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private static void ficheroReversa(String aux, RandomAccessFile raf2) {
		
		//Escribimos en el fichero.
        try {

        	// Variable que almacenará el caracter de la posicion de i en el bucle
            String reverse;
            
            char k;
            
            // Lo que se va a escribir
            String invertido="";
            
            //Recorremos el aux del reves.
            for (int i=aux.length()-1; i>=0; i--){

            		// Buscamos el caracter en la posicion i
                    k= aux.charAt(i-1);
                    
                    reverse += ;

                    //Casteamos a string.
                    invertido=""+reverse;
              
                    //Escribimos el reverse en el fichero.
                    raf2.writeBytes(invertido+"\n");

            }
            
        // Control de excepciones
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

}
