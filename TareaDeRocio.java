/*
 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap; 

public class TareaDeRocio {

	public class Estado{
		char valor;
		boolean inicio, fin;
		HashMap<String, Estado> transiciones = new HashMap<String, Estado>();

	}

	public static void main(String[] args){

		BufferedReader br = null;

		try {
			String sCurrentLine;

			br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\input.txt"));
			/*if(sCurrentLine = br.readLine()) != null){


			}*/
			//EMPIEZA INVENTO DE CARLA
			//lee primera línea, es el abecedario (Sigma)
			//lee segunda línea, la clave que se busca (A)
			int s = 4 //NUMERO INVENTADO!!! length de Sigma
			char[s] Sigma;
			int m = 6 //NÚMERO INVENTADO!!! length de A
			String[m] Abc;
			int[m][s] computeTransitionFun(/*A, Sigma*/){
				for(int q = 0; q++; q < m){
					for(int x = 0; x++; x < s){
						do{

						}while(true//voy omg)
					}
				}
			}

			//TERMINA INVENTO DE CARLA
			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}


		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}


	
}