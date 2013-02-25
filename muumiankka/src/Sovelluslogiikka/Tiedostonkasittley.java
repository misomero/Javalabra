/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka;

/**
 *
 * @author Vierailija
 */

import java.util.*;
import java.io.*;

public class Tiedostonkasittley {
    
    private ArrayList<String> tekstit;
    
    
    public Tiedostonkasittley() {
        this.tekstit= new ArrayList();
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
    
    
    public int muistiin (String pelaaja, int kohta) {
        
        int n = 0;
        String tiedosto = pelaaja+".txt";
        try {
            try (PrintWriter kirjoittaja = new PrintWriter (new File(tiedosto))) {
                kirjoittaja.println(kohta);
            }
        } catch (Exception e) {
            n=-1;
        }
        return n;
        
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
            tilanne= "42";
        }
        
        return tilanne;
    }
    
    public boolean onkoNimiKaytetty(String nimi) {
        boolean palautus = false;
        String tiedosto =nimi + ".txt";
        String tilanne="";
        try {
            Scanner lukija = new Scanner(new File(tiedosto),"UTF-8");
            while (lukija.hasNextLine()) {
                tilanne = lukija.nextLine();
            }
        } catch (Exception e) {
            tilanne= "";
        }
        if(!tilanne.equals("")) {
            palautus = true;
        }
        return palautus;
    }
    public String annaTeksti(int kohta) {
        return tekstit.get(kohta);    
    }
    public void poistaTekstit() {
        tekstit.clear();
    }
    public void poistaNimi(String nimi) {
        String nimi2 = nimi + ".txt";
        File tiedosto = new File(nimi2);
        tiedosto.delete();
    }
}
