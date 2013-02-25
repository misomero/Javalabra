/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka;

/**
 *
 * @author Vierailija
 */
// tämä luokka toimii ohjaus-luokan ja tiedostojen tallentamisen välillä muistiin
//laitettavien ja sieltä heattavien asioden kohdalla.

import java.util.*;

public class Muisti {
   
    
    private Tiedostonkasittley tied;
    
    public Muisti () {
        this.tied=new Tiedostonkasittley();
    }
    
    public void asetaNimi(String nimi) {
        tied.asetaNimi(nimi);
        tied.tallennaNimet();
    }
    public void lueNimet() {
        tied.lueNimet();
    }
    
    public int tallennaMuistiin (String nimi, int kohta) {
        return tied.muistiin(nimi,kohta);
    }
    public int haeNimellaKohta (String pelaaja) {
        
        String kohta1;
        int kohta;
        if (tied.onkoNimiKaytetty(pelaaja)==true) {
            kohta1 = tied.haeMuistista(pelaaja);
            kohta = Integer.parseInt(kohta1);
        } 
        else {
            kohta=43;
        }
        return kohta;
    }
    
}
