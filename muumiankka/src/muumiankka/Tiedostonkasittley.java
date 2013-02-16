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
    
    private ArrayList<String> tekstit;
    private ArrayList<String> nimet;
    
    
    public Tiedostonkasittley() {
        this.tekstit= new ArrayList();
        this.nimet=new ArrayList();
    }
    
    public void tekstienLuku() {
        
        for (int i = 0; i < 42; i++) {            //i käy läpi kaikki tekstitiedostot, tiedostot nimetään esim. tiedosto35.txt, tiedostoja tulee jatkossa lisää...
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
    public String haeMuistista (String pelaaja) {
        
        String tiedosto = pelaaja+".txt";
        String tilanne ="";
        try {
            Scanner lukija = new Scanner(new File(tiedosto),"UTF-8");
            while (lukija.hasNextLine()) {
                tilanne = lukija.nextLine();
            }
        } catch (Exception e) {
            System.out.println("Tiedoston luvussa oli virhe!");
        }
        
        return tilanne;
    }
    public void lueNimet() {
        
        String nimia;
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
        int i = 0;
        try {
            PrintWriter kirjoittaja = new PrintWriter(new File("nimet.txt"));
            while (!nimet.isEmpty()) {
            kirjoittaja.println(nimet.get(i));
            nimet.remove(i);
            i+=1;
            }
            kirjoittaja.close();
        } catch (Exception e) {
            System.out.println("Virhe tiedostoon kirjoittamisessa!");
        }
    }
    public boolean onkoNimiKaytetty(String nimi) {
        boolean palautus = false;
        tallennaNimet();
        lueNimet();
        if(nimet.contains(nimi)) {
            palautus = true;
        }
        return palautus;
    }
    public String annaTeksti(int kohta) {
        return tekstit.get(kohta);    
    }
    public void asetaNimi(String nimi) {
        nimet.add(nimi);
    }
    public void poistaNimi(int n) {
        nimet.remove(n);
    }
    public String annaNimi(int n) {
        return nimet.get(n);
    }
    public void tyhjaennaNimet() {
        nimet.clear();
    }
}
