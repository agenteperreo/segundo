package ejercicio5c;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class AccesoAleatorio {

	public static void main(String[] args) {
		
		try {
			// Creamos el File con el archivo de lectura
			File lectura = new File("C:\\github\\segundo\\acceso a datos\\acceso a ficheros\\src\\ejercicio5c\\lectura.txt");
				
			// Creamos el acceso aleatorio con el archivo y solo modo lectura
			RandomAccessFile raf1 = new RandomAccessFile(lectura, "r");
			
			// Seteamos la posicion a 0
			raf1.seek(0);
			
			// Creamos las variables para la linea y para el global de las lineas
			String linea="", aux="";
			
			// Creamos el File con el archivo de escritura
			File escritura = new File("C:\\github\\segundo\\acceso a datos\\acceso a ficheros\\src\\ejercicio5c\\escritura.txt");
			
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
            
            char k;
            
            // Lo que se va a escribir
            String invertido="";
            
            //Recorremos el aux del reves.
            for (int i=aux.length()-1; i>=0; i--){
            	
            	// Si i es impar y no es 0
            	if(i%2 != 0 && i != 0) {
            		// Buscamos el caracter en la posicion i-1
                    k= aux.charAt(i-1);
                } else {
                	// Buscamos el caracter en la posicion i+1
                	k=aux.charAt(i+1);
                } 
            	
            	// Concatenamos k con la variable invertido
            	invertido += k; 
              
            	// Si i es par
                if(i%2 == 0) {
                	
                	// Escribimos la variable invertido con un salto de linea
                	raf2.writeBytes(invertido+"\n");
                	
                	// Reiniciamos la variable
                	invertido="";
                }

            }
            
        // Control de excepciones
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

}
