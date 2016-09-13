/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stringmatching;

import java.util.Scanner;
import java.io.*;

/**
 *
 * @author Shadow
 */
public class StringMatching {

    /**
     * @param args the command line arguments
     */
    
    static String Patron, InputString;//"Patron" es el patron para construir el ADF y "InputString" es el string a analizar
    static int PatronLength;//Longitud de Patron
    static int ISLength;//Longitud de InputString
    static int Ocurrencias;//Numero de ocurrencias del Patron en InputString 
    
    
    public static void FileReader(String file){//Funcion de lectura del archivo
        String filename = file;
        String line = null;
        String[] values= new String[2];
        int valuesPos = 0;
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                values[valuesPos] = line;
                valuesPos++;
            }
            bufferedReader.close();
            Patron = values[0];
            PatronLength = Patron.length();
            InputString = values[1];
            ISLength = InputString.length();
            
        }catch(FileNotFoundException ex) {
            System.out.println("ERROR: El archivo '"+filename+"' no se encuentra en el folder.");                
        }catch(IOException ex) {
            System.out.println("ERROR: Falla de lectura del archivo '"+filename+"'.");
        }
    }
    
    public static void Readingtest(){//Prueba si los inputs del usuario son correctos
        //test
        System.out.println("Patron:"+Patron+" con longitud de "+PatronLength
                          +"\nString:"+InputString+" con longitud de "+ISLength+"\n");
        //test
    }
    
    public static void main(String[] args) {
        
        Scanner sc1 = new Scanner(System.in);//Utilizado para la seleccion en el "menu"
        Scanner sc2 = new Scanner(System.in);//Utilizado para el input de String(s)
        int UserSelect;//Seleccion del usuario
            
        String filename;//Nombre del archivo externo
        //Menu
        System.out.print("\nMatematicas Computacionales\nProyecto #1: String Matching\n"
                + "\nElija modo de lectura de patron y string:\n1.-Desde archivo externo.\n"
                + "2.- Input por usuario.\n>>");
        UserSelect = sc1.nextInt();
        switch(UserSelect){
            case 1://En caso de que se elija leer desde un archivo externo
                System.out.println("ADVERTENCIA: El archivo externo debe detener exclusivamente"
                               + "\nEn la primera linea el Patron y en la segunda linea el"
                               + "\nString a analizar, y sin espacios o lineas vacias. De"
                               + "\nlo contrario, el programa no va a funcionar correctamente.");
                System.out.print("\nEscriba nombre del archivo:");
                filename = sc2.nextLine();
                FileReader(filename);
                Readingtest();//Prueba si los inputs del usuario son correctos
                break;
                
            case 2://En caso de que el usuario quiera introducir el Patron y el String
                System.out.print("\nEscriba patron del ADF:");
                Patron = sc2.nextLine();
                PatronLength = Patron.length();
                //////////////////////////////////////////////////////
                System.out.print("\nEscriba String a analizar:");
                InputString = sc2.nextLine();
                ISLength = InputString.length();
                Readingtest();//Prueba si los inputs del usuario son correctos
                break;
                
            default:
                System.out.println("Seleccion invalida.");
                break;
        }
        System.out.println("Ejecucion terminada!!!\n.");
    }
    
}
