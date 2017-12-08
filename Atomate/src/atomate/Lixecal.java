package atomate;
//import java.util.Scanner;
import java.io.*;
//import java.util.stream.*;

public class Lixecal {
	
	//private static Scanner s;

	public static void main(String[] args) {
	
		
		String init="";
		String fichier="f1.txt";
		
		//lecture d'un fichier(f1.txt)
		
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
				System.out.println(ligne);
				init+=ligne+"\n";
			}
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
		
		String[] exp=new String[] {""};
		String[] id=new String[100];
		int num[]=new int[100];
		int posE=0;
		int posid=0;
		int nbr=0;
		int etat=0;
		int j=0;
		
		
		
		
		exp=init.split("\\s+|;|,|\\=|\\[|\\]");
		
	//atomate	 
	while(  j != exp.length ) {
		
	switch(etat) {
	case 0:
		if(exp[j].matches("^[0-9]")) {
			
			etat=2;
			
		}
		
		else if(exp[j].matches("^[a-zA-Z]")) {
			etat=1;
		}
		
		
	case 1:
		if(exp[j].matches("[a-zA-Z]([a-zA-Z]|[0-9]*|[_])*")) {
			
			id[posid]=exp[j];
			posid++;
			
			etat=1;
		}
		
	case 2:
		if(exp[j].matches("[0-9][0-9]*")) {
			
			char[]c=new char[] {};
			c=exp[j].toCharArray();
			for(int i=0;i<c.length;i++) {
				
			//Convertire le caractere chiffre en entier ex '4' en 4	
			 nbr= 10*nbr+(int)c[i]-48;
			 
			 }
			
			num[posE]=nbr;
			posE++;
			nbr=0;
			break;
		}
		
		}
		
	j++;
	etat=0;
	}
	
	//fin atomate
	
	//affichage
	
	System.out.println("------les identificeteur------");
	for(int m=0;m<100;m++) {
		if(id[m]!=null) {
		  if(id[m]=="int" || id[m]=="float" || id[m]=="double" || id[m]=="char" || id[m]=="bool") {
			
		System.out.println(id[m]+": keyid");
		System.out.println(": keyid");
		
			
		}
		  else
			  System.out.println(id[m]+": id");
		
	}
		}
	
	
	System.out.println("-------Les  entier entier-------------");
	
	for(int n=0;n<100;n++) {
		if(num[n]!=0) {
	System.out.println(num[n]+": integer");
	}
		}
	
		
	
	
	
	}
	}

