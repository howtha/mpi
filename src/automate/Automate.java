package automate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Automate {

    //Attributs
    String nom_fichier; //Nom du fichier
    String A[]; //Alphabet
    String Q[]; //Etats
    String I; //Etats initiaux
    String T[]; //Etats terminaux

    //Lecture d'un automate
    public static void lire_automate_sur_fichier(String nom_fichier) throws IOException {
        //Lecture d'un automate
        List<String> AF = Files.readAllLines(Paths.get(nom_fichier));
		//AF.substring(int);

        //Affichage d'un automate
        System.out.println(AF);
    }

    public static void AfficherAlphabet(String nom_fichier) throws IOException {
        List<String> AF = Files.readAllLines(Paths.get(nom_fichier));
        System.out.println(AF.get(0) + " symbole(s) dans l'alphabet");
        System.out.print("A = {");
        int AlphabetTotal = 97 + Integer.parseInt(AF.get(0).trim());

        for (int i = 97; i < AlphabetTotal; i++) {
            if (i == AlphabetTotal - 1) {

                System.out.print((char) i);

            } else {
                System.out.print((char) i + ",");
            }

        }
        System.out.println("}");

    }

    public static void AfficherEtats(String nom_fichier) throws IOException {
        List<String> AF = Files.readAllLines(Paths.get(nom_fichier));
        System.out.println(AF.get(1) + " états");
        System.out.print("Q = {");
        int etat = Integer.parseInt(AF.get(1).trim());

        for (int i = 0; i < etat; i++) {
            if (i == etat - 1) {

                System.out.print(i);

            } else {
                System.out.print(i + ",");
            }

        }
        System.out.println("}");

    }

    public static void AfficherEtatsInitiaux(String nom_fichier) throws IOException {
        List<String> AF = Files.readAllLines(Paths.get(nom_fichier));
        String[] words = AF.get(2).split("\\s");

        System.out.println(words[0] + " états initiaux");
        System.out.print("I = {");
        for (int i = 1; i < words.length; i++) {
            if (i == words.length - 1) {

                System.out.print(words[i]);

            } else {

                System.out.print(words[i] + ",");
            }
        }

        System.out.println("}");

    }

    public static void AfficherEtatsTerm(String nom_fichier) throws IOException {
        List<String> AF = Files.readAllLines(Paths.get(nom_fichier));
        String[] words = AF.get(3).split("\\s");

        System.out.println(words[0] + " états finaux");
        System.out.print("T = {");
        for (int i = 1; i < words.length; i++) {
            if (i == words.length - 1) {

                System.out.print(words[i]);

            } else {

                System.out.print(words[i] + ",");
            }
        }

        System.out.println("}");

    }

    public static void AfficherTransition(String nom_fichier) throws IOException {
        List<String> AF = Files.readAllLines(Paths.get(nom_fichier));
        
        int cpt = 0;
        int nbTransitions = Integer.parseInt(AF.get(4).trim());

        for (int i = 5; i < AF.size(); i++) {
            System.out.println(AF.get(i));
           cpt = AF.get(i).charAt(1) == 42 ? cpt+1  : cpt; 
        }
        
       System.out.println(AF.get(4) + " transitions dont "+ cpt +" transition(s) epsilon");

    }

    public static void main(String[] args) throws IOException {

        /*
         scanf(variable);
         */
        String text = "src/test.txt";
        lire_automate_sur_fichier("src/test.txt");

        AfficherAlphabet("src/test.txt");
        AfficherEtats(text);
        AfficherEtatsInitiaux(text);
        AfficherEtatsTerm(text);
        AfficherTransition(text);
    }
}
