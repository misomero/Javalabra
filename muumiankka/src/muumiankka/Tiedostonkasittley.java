/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muumiankka;

/**
 *
 * @author Vierailija
 */

import java.util.*;

import java.io.*;

public class Tiedostonkasittley {
    
    ArrayList<String> tekstit = new ArrayList();
    
    public Tiedostonkasittley() {
        this.tekstit=tekstit;
    }
    
    public void tekstienLuku() {
        
        for (int i = 34; i <=123; i++) {            //i käy läpi kaikki tekstitiedostot, tiedostot nimetään esim. tiedosto13.txt valintapolun mukaan
                String tiedosto = "tiedosto"+i+".txt";
            try {
                Scanner lukija = new Scanner(new File (tiedosto));
                String tilanne = "";
                while (lukija.hasNextLine()) {
                    String rivi = lukija.nextLine();
                    tilanne += rivi;
                }
                tekstit.add(tilanne);
            } catch (Exception e) {
                System.out.println("Virhe tiedoston luvussa!");
            }
        }
    }
    public void muistiin (String pelaaja, char kohta) {
        
        String nimi = pelaaja+".txt";
        try {
            PrintWriter kirjoittaja = new PrintWriter(new File(nimi));
            kirjoittaja.println(kohta);
            kirjoittaja.close();
        } catch (Exception e){
            System.out.println("Virhe tiedostoon kirjoittamisessa");
        }
    }
    public char haeMuistista (String pelaaja) {
        
        String tiedosto = pelaaja+".txt";
        String tilanne = "";
        try {
            Scanner lukija = new Scanner(new File(tiedosto));
            while (lukija.hasNextLine()) {
                tilanne = lukija.nextLine();
            }
        } catch (Exception e) {
            System.out.println("Virhe tiedoston lukemisessa");
        }
        char kohta = tilanne.charAt(0);
        return kohta;
        
    }

}
