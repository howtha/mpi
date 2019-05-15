package automate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Automate 
{
	//Attributs
	String nom_fichier; //Nom du fichier
	String A[]; //Alphabet
	String Q[]; //Etats
	String I; //Etats initiaux
	String T[]; //Etats terminaux

	//Lecture d'un automate
	public static void lire_automate_sur_fichier(String nom_fichier) throws IOException
	{
		//Lecture d'un automate
		List<String> AF = Files.readAllLines(Paths.get(nom_fichier));
		//AF.substring(int);
		
		//Affichage d'un automate
		System.out.println(AF);
	}

	public static void main(String[] args) throws IOException
	{
		lire_automate_sur_fichier("src/test.txt");
	}
} 