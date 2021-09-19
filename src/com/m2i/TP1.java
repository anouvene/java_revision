package com.m2i;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TP1 {
    public static String[] adresses;
    public static Map<String, Integer> fournisseurList = new HashMap<>();

    private static int[] randGenerator(int numbersToGenerate) {
        int[] randomNumbers = new int[numbersToGenerate];
        for(int i=0; i < numbersToGenerate; i++) {
            randomNumbers[i] = (int)(Math.random() * 1000);
        }
        return randomNumbers;
    }

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


    public static void main(String... args) { //String[] args
        //=============================================================================================================
        // Exercice1 : Part de marché
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
        // Exercice2 : Générer 3 nombres aléatoires pair, pair, impair et compter le nombre d'essais
        //=============================================================================================================
        int totalNbAleatoires = 3;
        int nbEssais = 0;
        Boolean fin = false;

        int[] randomTab = null;

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

    }

}
