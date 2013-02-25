package Sovelluslogiikka;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Vierailija
 */
//Hoitaa siirtymistä tiloista toisiin, näillä
import Sovelluslogiikka.Kohta;
import java.util.*;
import java.awt.image.BufferedImage;

public class Ohjaus {
    
    private Muisti muisti;
    private Tiedostonkasittley tiedostot;
    private Kuvankasittely kuvankasittely;
    private Kohta kohta;
    private ArrayList<Kohta> kohdat;
    private int missa;
    private int uusik;
    private String nimi;
    
    public Ohjaus () {
        this.tiedostot=new Tiedostonkasittley();
        tiedostot.tekstienLuku();
        this.kuvankasittely= new Kuvankasittely();
        kuvankasittely.lataaKuva();
        this.muisti=new Muisti();
        this.uusik=0;
        this.missa=0;
        this.nimi="";
        this.kohta= new Kohta(0,tiedostot);
        this.kohdat= new ArrayList();
        for(int i=0; i<42; i++) {
            kohdat.add(new Kohta(i,tiedostot));
        }
        
    }
    
     
    public void siirtyminen() {
      
        if (missa<=12) {
            tavallinenSiirtyminen();
        }
        else if (missa==13||missa==15) {
           satunnainenSiirtyminen1();
        }
        else if (missa>=19&&missa<=27){ 
            satunnainenSiirtyminen1();
        }
        else if(missa==34 || missa==36 || missa==37 || missa==39) {
            satunnainenSiirtyminen1();
        }
        else if (missa==16||missa==17||missa<=18) {
            satunnainenSiirtyminen2();
        }
        else if (missa==28||missa==29||missa==30) {
            satunnainenSiirtyminen3();
        }
        else if (missa>=31&&missa<=33) {
            tavallinenSiirtyminen();
        }
            
    }
    
    private void tavallinenSiirtyminen() {
        this.kohta = kohta.annaSeuraaja(missa, uusik);
        this.missa = 3*missa+uusik;
    }    
    
    private void satunnainenSiirtyminen1() {        
        int satunnainen1 = satunnaisluku(16,18);         
        this.kohta = kohdat.get(satunnainen1);    }    
    
    private void satunnainenSiirtyminen2() {        
        int satunnainen2 = satunnaisluku(28,30);        
        this.kohta = kohdat.get(satunnainen2);    }    
    
    private void satunnainenSiirtyminen3() {        
        int satunnainen3 = satunnaisluku(31,33);        
        this.kohta = kohdat.get(satunnainen3);    }    
    
    private int satunnaisluku(int ylaraja, int alaraja) {      
        return alaraja + (int)(Math.random() * (ylaraja - alaraja + 1));    }    
    
    public int siirtyminenTiettyynKohtaan(String nimi) { 
        this.missa =muisti.haeNimellaKohta(nimi);
        if(missa <42) {
            this.kohta=kohdat.get(missa);
        }
        return missa;
    }
    
    public int tallenna() {
        return muisti.tallennaMuistiin(nimi, missa);
    }
    public void asetaNimi(String nimi) {
        this.nimi=nimi;
        this.muisti.asetaNimi(nimi);
    }
    public String annaNimi() {
        return this.nimi;
    }
    public void tyhjennaNimet() {
        this.tiedostot.poistaNimet();
    }
    public void lueNimet() {
        muisti.lueNimet();
    }
    public void asetaKohta(int kohta) {
        this.missa=kohta;
    }
    public int annaKohtaNumero() {
        return this.missa;
    }
    public int annaSiirto() {
        return this.uusik;
    }
    
    public void asetaSiirto(int valinta) {
        this.uusik=valinta;
    }
    public Kohta annaKohta() {
        return kohta;
    }
    public BufferedImage annaKuva() {
        return kuvankasittely.annaKuva();
    }
   
        
}
