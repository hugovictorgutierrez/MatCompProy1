/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stringmatching;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
    
    static ArrayList<Character> abcd = new ArrayList<Character>();
    static int Longitudabc=0;//Numero de letras en el abc-
    
    static int EdoFinal;//Edo final del automata
    static int Ocurrencias=0;//Numero de ocurrencias del Patron en InputString 
    static int[][] ADF;//Automata transition table
    
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
            InputString = values[1];//String a probar
            ISLength = InputString.length();// Longitud del string a probar
            
        }catch(FileNotFoundException ex) {
            System.out.println("ERROR: El archivo '"+filename+"' no se encuentra en el folder.");
            System.exit(0);                
        }catch(IOException ex) {
            System.out.println("ERROR: Falla de lectura del archivo '"+filename+"'.");
            System.exit(0);
        }
    }
    
    public static void Readingtest(){//Prueba si los inputs del usuario son correctos
        //test
        System.out.println("Patron:"+Patron+" con longitud de "+PatronLength
                          +"\nString:"+InputString+" con longitud de "+ISLength+"\n");
        //test
    }
    
    
    
    public static boolean isThere(char letter){// Verifica si la letra ya esta en el alfabeto
        boolean isHere=false;
        for(int i = 0; i<abcd.size(); i++){
            if(abcd.contains(letter)){//verifica si la letra ya esta en el alfabeto
                isHere=true;
            }
        }
        System.out.println("an:"+isHere);
        return isHere;
    }
    
    public static void addLetters(String word){//Agrega letras al alfabeto y define el tamanio del alfabeto
        for (int i = 0;i < word.length(); i++){
            //System.out.println(word.charAt(i));
            if(isThere(word.charAt(i))==false){//si la letra no esta en el alfabeto, se agrega al alfabeto
                abcd.add(word.charAt(i));
            }
        }
        Longitudabc=abcd.size();//Define el tamanio del alfabeto
    }
    
    public static void createabcd(String word){//Crea el alfabeto
        addLetters(word);
        //printabcd();
    }
    
    public static void printabcd(){//Imprime el contenido del alfabeto
//        int numLetters=abcd.size();
        for (int i=0; i<abcd.size(); i++){
            System.out.print(abcd.get(i)+", ");
        }
//        Longitudabc=numLetters;
    }
    public static boolean esSufijo(String a, char x, int k, int q){
        String aqx = a + x;
        q++;
        for(int i = 0; i < k; i++){
            if(aqx[q - i] != a[k-i])
                return false;
        }
        return true;
    }
    public static void ADFbuilder(String a, ArrayList<Character> sigma, int m, int s){//Constructor del ADF que recibe el Patron y el tamanio del patron
        StringMatching.ADF = new int[m][s];
        int k;
        for(int q = 0; q < m; q++){
            for(int x = 0; x < s; x++){
                if(m + 1 <= q + 2)
                    k = m + 1;
                else
                    k = q + 2;
                do{
                    k--;
                }while(!esSufijo) //esSufijo
                ADF[q][x] = k;
            }
        }


//        Longitudabc(InputString);
//        boolean transTerm = false;
//        createabcd(P);
//        //printabcd();
//        int abcnum=Longitudabc;
//        EdoFinal=Plength;
//        ADF = new String[Plength+1][abcnum];
        
//        while(transTerm!=true){
//            
//        
//        }
//        System.out.println("SIZES:::num.edos:"+ADF.length+"num.entradas:"+ADF[0].length+"");
    }
    public static void printAFD(int m, int s){
        for(int i = 0; i < m; i++){
            for(int j = 0; j < s; j++){
                System.out.print(StringMatching.ADF[i][j] + " ");
                System.out.print("\n");
            }
        }
    }
    
    
    public static void ADFexecute(){//Ejecuta el ADF con el InputString y guarda los resultados en un archivo externo

        String fileResults = "output.txt";
        
        try {
            ////////////////////////////////////////////////////////
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
                System.out.println("ADVERTENCIA: El archivo externo debe tener exclusivamente:"
                               + "\nEn la primera linea el Patron y en la segunda linea el"
                               + "\nString a analizar, y sin espacios o lineas vacias. De"
                               + "\nlo contrario, el programa no va a funcionar correctamente.");
                System.out.print("\nEscriba nombre del archivo:");
                filename = sc2.nextLine();
                LeerArchivo(filename);
                Readingtest();//Prueba si los inputs del usuario son correctos
                

                //ADF
                createabcd(Patron);//crea el alfabeto
                EdoFinal = PatronLength;//numero del edo final
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
                createabcd(Patron);//crea el alfabeto
                EdoFinal = PatronLength;//numero del edo final
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
