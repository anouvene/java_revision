package com.m2i;

import java.util.*;

public class TP1 {
    // Exercice 1 : Part de marché
    private static String[] adresses;
    private static Map<String, Integer> fournisseurList = new HashMap<>();

    // Exercice 2 : Générer 3 nombres aléatoires pair, pair, impair et compter le nombre d'essais
    private static int nbEssais = 0;
    private static int totalNbAleatoires = 3;
    private static Boolean fin = false;
    private static int[] randomTab = null;

    // Exercice 3 : Deviner le bon nombre aleatoire au clavier
    private static int nombreMagique;
    private static Boolean finJeu = false;
    private static int nombreSaisi;
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Random number generator
     * @param numbersToGenerate
     * @return int[] Number array between 0 and 1000
     */
    private static int[] randGenerator(int numbersToGenerate) {
        int[] randomNumbers = new int[numbersToGenerate];
        for(int i=0; i < numbersToGenerate; i++) {
            randomNumbers[i] = (int)(Math.random() * 1000);
        }
        return randomNumbers;
    }

    /**
     * Update Part Of Market for each internet provider
     * @param e
     * @param compteur
     */
    private static void UpdatePartOfMarket(Map.Entry<String, Integer> e, int compteur) {
        for(int i=0; i<adresses.length; i++) {
            String fournisseurCourant = adresses[i].substring(adresses[i].indexOf('@'));
            // Update part
            if (fournisseurCourant.equals(e.getKey())) {
                compteur++;
                fournisseurList.replace(fournisseurCourant, e.getValue(), compteur);
            }
        }
    }

    /**
     * To continu the game or not ?
     * @param finJeu
     * @return Boolean To confirm of poursuit game or not
     */
    private static Boolean scanNextLine(Boolean finJeu) {
        // Important ici:
        // Si on utiliser un seul et même scanner pour tout le programme, penser à le réinitialiser après un nextInt() ou autre ...
        // Sinon, dans tous les cas, on en crée un nouveau (déconseillé)
        scanner = new Scanner(System.in);
        System.out.println("Voulez-vous continuer y/n?");
        String line = scanner.nextLine().toLowerCase();

        if(line.equals("n")) {
            finJeu = true;
            System.exit(0);
            scanner.close();

        } else {
            System.out.println("On continue :-)");
            finJeu = false;
        }

        return finJeu;
    }

    public static void main(String... args) { //String[] args
        //=============================================================================================================
        // Exercice 1 : Part de marché
        //=============================================================================================================

        adresses = new String[10];
        adresses[0] = "jpp@sfr.fr";
        adresses[1] = "tom@gmail.com";
        adresses[2] = "fred@sfr.fr";
        adresses[3] = "victor@sfr.fr";
        adresses[4] = "chris@sfr.fr";
        adresses[5] = "robert@orange.fr";
        adresses[6] = "paul@sfr.fr";
        adresses[7] = "lise@gmail.com";
        adresses[8] = "thierry@eni.fr";
        adresses[9] = "marie@eni.fr";

        // Stocker les fournisseurs dans un map(nom du fournisseur, parts de marché)
        for(int i=0; i<adresses.length; i++) {
            String fournisseurName = adresses[i].substring(adresses[i].indexOf('@'));
            fournisseurList.put(fournisseurName, 0);
        }

        // Mise à jour les parts de marché de chaque fournisseur
        for(Map.Entry<String, Integer> fournisseur: fournisseurList.entrySet()) {
            UpdatePartOfMarket(fournisseur, fournisseur.getValue());
        }

        // Affichage Fournisseurs / Parts
        for(Map.Entry<String, Integer> e: fournisseurList.entrySet()) {
            System.out.println(String.format("Fourniseur: %s - Part de marché: %d%s", e.getKey(), e.getValue(), "%"));
        }

        //=============================================================================================================
        // Exercice 2 : Générer 3 nombres aléatoires pair, pair, impair et compter le nombre d'essais
        //=============================================================================================================

        while(!fin) {
            randomTab  = randGenerator(totalNbAleatoires);
            nbEssais++;
            if(randomTab[0] % 2 == 0
                    && randomTab[1] % 2 == 0
                    && randomTab[2] % 2 > 0) {
                fin = true;
            }
        }

        System.out.println(Arrays.toString(randomTab));
        System.out.println(String.format("Total essais: %d", nbEssais));

        //=============================================================================================================
        // Exercice 3 : Trouver le bon nombre aleatoire au clavier
        //=============================================================================================================

        System.out.println("===================================");
        System.out.println("DEVINER LE NOMBRE MAGIGUE");
        System.out.println("===================================\n");

        do { // Début jeu
            Boolean trouve = false;
            nbEssais = 0;

            nombreMagique = randGenerator(1)[0];
            // Pour le test ... c'est de la triche :-)
            System.out.println(String.format("Nombre magique à trouver est : %d", nombreMagique));

            System.out.println("Saisir un nombre pour commencer et valider sur la touche ENTER\n");

            do {
                try {
                    nombreSaisi = scanner.nextInt();
                    nbEssais++;

                    if(nombreSaisi < nombreMagique) {
                        System.out.println("Plus grand ...");

                    } else if(nombreSaisi > nombreMagique) {
                        System.out.println("Plus petit ...");

                    } else {
                        trouve = true;
                        System.out.println("Bravo !!!");
                        System.out.println("Nombre d'essais: " + nbEssais);

                        // Continue the game or not ?
                        if (!scanNextLine(finJeu)) break;
                    }

                } catch (InputMismatchException e) {
                    //e.printStackTrace();
                    System.out.println("Vous n'avez pas saisi un nombre");

                    // Continue the game or not ?
                    if (!scanNextLine(finJeu)) break;
                }

            } while(!trouve);

        } while (!finJeu);
    }
}
