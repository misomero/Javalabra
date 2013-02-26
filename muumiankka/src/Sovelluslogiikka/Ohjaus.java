package Sovelluslogiikka;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Vierailija
 */
//Hoitaa siirtymistä tiloista toisiin, sekä on yhteydessä Graafiseen ohjelmaan, tarjoaa sille tarvittavat metodit
import java.util.*;
import java.awt.image.BufferedImage;

/**
 * 
 * @author Vierailija
 */
public class Ohjaus {
    
    private Tiedostonkasittley tiedostot;
    private Kuvankasittely kuvankasittely;
    private Kohta kohta;
    private ArrayList<Kohta> kohdat;
    private int missa;
    private int uusik;
    private String nimi;
    
    /**
     * Ohajuksen konstruktori luo sisäiset muutujat joista tärkein on kohta, joka kertoo pelissä tarvittavat tekstit ja kohtatunnisteet.
     */
    public Ohjaus () {
        this.tiedostot=new Tiedostonkasittley();
        tiedostot.tekstienLuku();
        this.kuvankasittely= new Kuvankasittely();
        this.uusik=0;
        this.missa=0;
        this.nimi="";
        this.kohta= new Kohta(0,tiedostot);
        this.kohdat= new ArrayList();
        for(int i=0; i<42; i++) {
            kohdat.add(new Kohta(i,tiedostot));
        }
        
    }
    
     
    /**
     * Tämä metodi hoitaa siirtymistä kohdasta toiseen (kohtien sisältö on edelleen pelin teksti). Erilasilla kohdilla on määritelty erilaisia siirtymisiä
     */
    public void siirtyminen() {
      
        if (missa<5) {
            tavallinenSiirtyminen();
        }
        else if(missa>5 &&missa<9) {
            tavallinenSiirtyminen();
        }
        else if(missa==11||missa==12) {
            tavallinenSiirtyminen();
        }
        else if (missa==13||missa==15) {
           siirtyminen1();
        }
        else if(missa==5|| missa==9||missa==10||missa==14||missa==19||missa==27||missa==35||missa==38) {
            umpikujaanSiirtyminen();
        }
        else if (missa>19&&missa<27){ 
            siirtyminen1();
        }
        else if(missa==34 || missa==36 || missa==37 || missa==39) {
            siirtyminen1();
        }
        else if (missa==16||missa==17||missa<=18) {
            siirtyminen2();
        }
        else if (missa==28||missa==29||missa==30) {
            siirtyminen3();
        }
        else if (missa>=31&&missa<=33) {
            loppuunSiirtyminen();
        }
        else if(missa==34||missa==36||missa==37||missa==39) {
            siirtyminen1();
        }
            
    }
    
    private void tavallinenSiirtyminen() {
        this.kohta = kohta.annaSeuraaja(missa, uusik);
        this.missa = 3*missa+uusik;
    }    
    
    private void siirtyminen1() {        
        this.missa = 5*3+uusik;
        this.kohta = kohdat.get(missa);    }    
    
    private void siirtyminen2() {        
        this.missa = 9*3+uusik;        
        this.kohta = kohdat.get(missa);    }    
    
    private void siirtyminen3() {        
        this.missa = 10*3+uusik;        
        this.kohta = kohdat.get(missa);    
    }    
    private void loppuunSiirtyminen() {
        this.missa=40;
        this.kohta=kohdat.get(missa);
    }
    private void umpikujaanSiirtyminen() {
        this.missa=41;
        this.kohta=kohdat.get(missa);
    }
    /**
     * tämä metodi nollaa pelitilanteen ja vie kohdan alkuun
     */
    public void siirtyminenAlkuun() {
        this.uusik=0;
        this.missa=0;
        this.kohta=kohdat.get(0);
    }
    /**
     * 
     * @param nimi tällä pelaajanimellä voi hakea tietyn kohdan muistista
     * @return palautaa tallennetun kohtanumeron ja siirtää kohdan osoittamaan sitä
     */
    public int siirtyminenTiettyynKohtaan(String nimi) { 
        this.missa =tiedostot.haeNimellaKohta(nimi);
        if(missa <42) {
            this.kohta=kohdat.get(missa);
        }
        return missa;
    }
    
    /**
     * metodi tallentaa pelaajanimeä vastaavan pelikohdan
     * @return palautaa 0 jos muistiin tallnetaminen onnisuu, -1 jos ei
     */
    public int tallenna() {
        return this.tiedostot.muistiin(nimi, missa);
    }
    /**
     * asettaa pelaajanimen, jolla voi tallentaa kohdan
     * @param nimi syöteenä pelaajalta saatu nimi
     */
    public void asetaNimi(String nimi) {
        this.nimi=nimi;
    }
    /**
     * metodi palautaa pelaajanimen
     * @return pelaajanimi
     */
    public String annaNimi() {
        return this.nimi;
    }
    /**
     * asettaa numeroarvoisen kohdan, jonka perusteella voidaan tehdä siirtymisiä
     * @param kohta kohta josta halutaan siirtyä
     */
    public void asetaKohta(int kohta) {
        this.missa=kohta;
    }
    /**
     * antaa sen hetikisen kohtanumeron
     * @return
     */
    public int annaKohtaNumero() {
        return this.missa;
    }
    /**
     * antaa viimeisimmän valitun siirron
     * @return
     */
    public int annaSiirto() {
        return this.uusik;
    }
    
    /**
     * asetaaa vimeisimmän valitun siirron
     * @param valinta
     */
    public void asetaSiirto(int valinta) {
        this.uusik=valinta;
    }
    /**
     * palautaa Kohta muotoisen olion, joka on sen hetkinen kohta, sisältää pelin tekstit
     * @return
     */
    public Kohta annaKohta() {
        return kohta;
    }
    /**
     * palautaa peliin kuuluvan kuvan
     * @return muumiankkakuva sisältönä
     */
    public BufferedImage annaKuva() {
        return kuvankasittely.annaLadattuKuva();
    }
    /**
     * tutkii onko nimellä tallennettu
     * @param nimi pelaajanimi jota etsitään
     * @return jos nimellä on tallennettu, palauttaa true, jos ei false
     */
    public boolean onkoNimiKaytetty(String nimi) {
       return this.tiedostot.onkoNimiKaytetty(nimi);
    }
   
   
        
}
