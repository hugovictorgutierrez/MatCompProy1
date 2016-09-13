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
    static int Longitudabc=0;//Numero de letras en el abc-
    static int ISLength;//Longitud de InputString
    static int EdoFinal;//Edo final del automata
    static int Ocurrencias=0;//Numero de ocurrencias del Patron en InputString 
    static char[][] ADF;//Automata
    
    public static void LeerArchivo(String file){//Funcion de lectura del archivo
        String filename = file;
        String line = null;
        String[] values= new String[2];
        int valuesPos = 0;
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                //System.out.println(line);
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
    
//    public static int Longitudabc(String s) {
//	boolean[] registrobool = new boolean[256];
//	char[] abcdario = s.toCharArray();
//        int inicio = 0;
// 
//	for (int i = 0; i < abcdario.length; i++) {
//		char posicion = abcdario[i];
//		if (registrobool[posicion]) {
//			Longitudabc = Math.max(Longitudabc, i - inicio);
//			for (int k = inicio; k < i; k++) {
//				if (abcdario[k] == posicion) {
//					inicio = k + 1; 
//					break;
//				}
//				registrobool[abcdario[k]] = false;
//			}
//		} else {
//			registrobool[posicion] = true;
//		}
//	}
//	return Longitudabc = Math.max(abcdario.length - inicio, Longitudabc);
//	//System.out.println("Cantidad de chars en abc-dario:"+Longitudabc);
//    }
    
    
    public static void ADFbuilder(String P, int Plength){//Constructor del ADF que recibe el Patron y el tamanio del patron
//        Longitudabc(InputString);
        int abcnum=Longitudabc;
        EdoFinal=Plength;
        ADF = new char[Plength+1][abcnum];
        
        
        
        
    }
    
    public static void ADFexecute(){

        String fileResults = "output.txt";
        
        try {
            //Se crea archivo para guardar los resultados
            FileWriter fileWriter = new FileWriter(fileResults);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("Con el patron "+Patron);
            bufferedWriter.newLine();
            bufferedWriter.write("Para el String "+InputString);
            bufferedWriter.newLine();
            ////////////////////////////////////////////////////////
            char[] StringPrueba= InputString.toCharArray();
            System.out.println("String;"+InputString+", longitud:"+StringPrueba.length+"...");
            int q = 0;
            for (int i=0; i<StringPrueba.length; i++){
                
                //q = funcion(q,StringPrueba[i]);//Recibe edo. presente y prueba el char recibido del InputString
                
                if(q==EdoFinal){//Si el edo presente es el edo. final
                    Ocurrencias++;
                    System.out.println("Pattern occurs");
                }
            }
            System.out.println("Num. total de ocurrancias:"+Ocurrencias);
            bufferedWriter.write("Num. total de ocurrancias:"+Ocurrencias);
            bufferedWriter.close();
        
        }catch(IOException ex) {
            System.out.println("ERROR: Problemas en la escritura del archivo '"+fileResults+"'");
        }
    }
    
    
    public static void main(String[] args) {
        
        Scanner sc1 = new Scanner(System.in);//Utilizado para la seleccion en el "menu"
        Scanner sc2 = new Scanner(System.in);//Utilizado para el input de String(s)
        int UserSelect;//Seleccion del usuario
        String filename;//Nombre del archivo externo
        
        //Menu
        System.out.print("\nMatematicas Computacionales\nProyecto #1: String Matching\n"
                + "\nElija modo de lectura de patron y string:\n1.-Desde archivo externo.\n"
                + "2.-Input por usuario.\n>>");
        UserSelect = sc1.nextInt();
        switch(UserSelect){
            case 1://En caso de que se elija leer desde un archivo externo
                System.out.println("ADVERTENCIA: El archivo externo debe detener exclusivamente"
                               + "\nEn la primera linea el Patron y en la segunda linea el"
                               + "\nString a analizar, y sin espacios o lineas vacias. De"
                               + "\nlo contrario, el programa no va a funcionar correctamente.");
                System.out.print("\nEscriba nombre del archivo:");
                filename = sc2.nextLine();
                LeerArchivo(filename);
                Readingtest();//Prueba si los inputs del usuario son correctos
                //ADF
                ////Longitudabc(InputString);
                //ADFbuilder(Patron,PatronLength);
                //ADFexecute();
                break;
                
            case 2://En caso de que el usuario quiera introducir el Patron y el String
                System.out.print("\nEscriba patron del ADF:");
                Patron = sc2.nextLine();
                PatronLength = Patron.length();
                //////////////////////////////////////////////////////
                System.out.print("Escriba String a analizar:");
                InputString = sc2.nextLine();
                ISLength = InputString.length();
                Readingtest();//Prueba si los inputs del usuario son correctos
                //ADF
                ////Longitudabc(InputString);
                //ADFbuilder(Patron,PatronLength);
                //ADFexecute();
                break;
                
            default:
                System.out.println("Seleccion invalida.");
                break;
        }
        
        System.out.println("Ejecucion terminada!!!\n.");
    }
    
}
