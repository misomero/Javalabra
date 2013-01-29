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
    
    public ArrayList<String> tekstit = new ArrayList();
    public ArrayList<String> nimet = new ArrayList();
    
    
    public Tiedostonkasittley() {
        this.tekstit=tekstit;
    }
    
    public void tekstienLuku() {
        
        for (int i = 0; i < 3; i++) {            //i käy läpi kaikki tekstitiedostot, tiedostot nimetään esim. tiedosto35.txt, tiedostoja tulee jatkossa lisää...
                String tiedosto = "tiedosto"+i+".txt";
            try {
                Scanner lukija = new Scanner(new File (tiedosto), "UTF-8");
                String tilanne = "";
                while (lukija.hasNextLine()) {
                    String rivi = lukija.nextLine();
                    tilanne += "\n"+rivi;
                }
                tekstit.add(tilanne);
            } catch (Exception e) {
                System.out.println("Virhe tiedoston luvussa! Käynnistä ohjelma uudestaan");
            }
        }
    }
    
    public void muistiin (String pelaaja, int kohta) {
        
        String tiedosto = pelaaja+".txt";
        try {
            PrintWriter kirjoittaja = new PrintWriter (new File(tiedosto));
            kirjoittaja.println(kohta);
            kirjoittaja.close();
        } catch (Exception e) {
            System.out.println("Virhe tallentamisessa, yritä uudelleen!");
        }
    }
    public int haeMuistista (String pelaaja) {
        
        String tiedosto = pelaaja+".txt";
        String tilanne ="";
        try {
            Scanner lukija = new Scanner(new File(tiedosto));
            while (lukija.hasNextLine()) {
                tilanne = lukija.nextLine();
            }
        } catch (Exception e) {
            System.out.println("Nimelläsi ei ole vielä tallennettu mitään tai tiedoston luvussa oli virhe!");
        }
        int kohta=0;
        return kohta;
    }
    public void lueNimet() {
        
        String nimia = "";
        try {
            Scanner lukija = new Scanner(new File("nimet.txt"), "UTF-8");
            while (lukija.hasNextLine()) {
                nimia = lukija.nextLine();
                nimet.add(nimia);
            }
        } catch (Exception e) {
            System.out.println("Tiedoston luvussa oli virhe!");
        }
    }
    public void tallennaNimet() {
        
        try {
            PrintWriter kirjoittaja = new PrintWriter(new File("nimet.txt","UTF-8"));
            int i = 0;
            while(!nimet.isEmpty()) {
                kirjoittaja.println(nimet.get(i));
                nimet.remove(i);
                i+=1;
            }
            kirjoittaja.close();
        } catch (Exception e) {
            System.out.print("Virhe tiedostoon kirjoittamisessa");
        }
    }

}
