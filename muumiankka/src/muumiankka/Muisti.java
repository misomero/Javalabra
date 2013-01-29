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

public class Muisti {
   
    public static Scanner input = new Scanner(System.in);
    
    public Tiedostonkasittley tied = new Tiedostonkasittley();
    public Kuvankasittely kuva = new Kuvankasittely();
    public String pelaaja;
    
    public Muisti () {
        this.tied=tied;
        pelaaja="";
    }
    
    public void asetaNimi(String nimi) {
        pelaaja=nimi;
        tied.nimet.add(nimi);
    }
    public boolean onkoNimiKaytetty(String nimi) {
       
        tied.lueNimet();
        boolean palautus= false;
        if (tied.nimet.contains(nimi)) {
            palautus = true;
        }
        return palautus;
    }
    
    public void tallennaMuistiin (String nimi, int kohta) {
            tied.muistiin(nimi,kohta);
    }
    public int haeNimellaKohta (String pelaaja) {
        
        int kohta = 0;
        if (onkoNimiKaytetty(pelaaja)==true) {
            kohta = tied.haeMuistista(pelaaja);
        }
        return kohta;
    }
    
}
