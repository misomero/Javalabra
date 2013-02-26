/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka;


/**
 *Tämä luokka tietää kohtaan kuuluvan tekstisisällön ja seuraajat, eli mahdolliset seuraavat kohdat
 * @author Vierailija
 */
import java.util.ArrayList;
/**
 * 
 * @author Vierailija
 */
public class Kohta {
    
    private ArrayList<Kohta> seuraajat;
    private String tkstsisalto;
    private Tiedostonkasittley tiedos;
    private int kohta;
    
    /**
     * Konstruktori luo kohdan, antaen sille parametrit
     * @param kohta numero, joka kertoo missä verkon jäsenessä mennään
     * @param kasittely toinen luokka, jota tavitaan kohdan luomiseen
     */
    public Kohta(int kohta, Tiedostonkasittley kasittely) {
        this.kohta=kohta;
        this.tiedos = kasittely;
        this.seuraajat=new ArrayList();
        this.tkstsisalto=tiedos.annaTeksti(kohta);

        if(kohta<=12&&kohta != 5 &&kohta!=10) {
            Kohta seuraaja1 = new Kohta((kohta*3)+1,kasittely);
            Kohta seuraaja2 = new Kohta((kohta*3)+2,kasittely);
            Kohta seuraaja3 = new Kohta((kohta*3)+3,kasittely);
            this.seuraajat.add(seuraaja1);
            this.seuraajat.add(seuraaja2);
            this.seuraajat.add(seuraaja3);
        } 
        else if (kohta==31 || kohta==32 || kohta==33){
            Kohta viimeinen = new Kohta(40,kasittely);
            this.seuraajat.add(viimeinen);
        }
        else if (kohta==38 || kohta ==5 || kohta==10 || kohta==14 || kohta==19 || kohta==27 || kohta==35) {
            Kohta umpikuja = new Kohta(41,kasittely);
            this.seuraajat.add(umpikuja);
        }
        
    }
    /**
     * palautaa sen hetkisen kohdan tekstisisällön
     * @return String muotoinen pelin sisältöteksti
     */
    public String annaTeksti() {
        Kohta tassa = new Kohta(kohta,tiedos);
        return tassa.tkstsisalto;
    }
    /**
     * antaa kohdan mahdolliset seuraajat
     * @param lahtokohta parametri lähtökohta kertoo mistä Kohdan numeroarvosta lähdetään
     * @param valinta parametri kertoo minkä pelaajan valinan mukaan seuraava kohta haetaan
     * @return palautaa logiikan antaman Kohta-olion
     */
    public Kohta annaSeuraaja (int lahtokohta, int valinta) {
        Kohta edeltaja = new Kohta(lahtokohta, tiedos);
        return edeltaja.seuraajat.get(valinta-1);
    }
    /**
     * kertoo sen hetikisen Kohdan numeroarvoi
     * @return palautaa kyseisen numeroarvon
     */
    public int annaKohtaNro () {
        return this.kohta;
    }

    /**
     * override vastaavuudelle, määrittää sen vain numeroparametrin mukaan (joka määritellään konstruktorissa)
     * @param obj objekti Kohat
     * @return palautaa false jos kohdat eivät ole samat, true jos ovat
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Kohta other = (Kohta) obj;
        if (this.kohta != other.kohta) {
            return false;
        }
        return true;
    } 
}
