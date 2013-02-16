/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muumiankka;

/**
 *
 * @author Vierailija
 */
//Hoitaa siirtymistä tiloista toisiin, näillä
import java.util.*;

public class Ohjaus {
    
    private Pelaaja pelaaja;
    private Kohta kohta;
    private ArrayList<Kohta> kohdat;
    private int missa;
    private int uusik;
    private String nimi;
    
    public Ohjaus () {
        this.uusik=0;
        this.missa=0;
        this.pelaaja=new Pelaaja(nimi,missa);
        this.kohdat= new ArrayList();
        for (int i=0; i <42; i++) {
            kohdat.add(new Kohta(i));
        }
        this.kohta = new Kohta(0);
        
    }
    
     
    public void siirtyminen() {
        
        if (missa<=12) {
            tavallinenSiirtyminen();
        }
        else if (missa > 12&& missa<14||missa==15) {
           satunnainenSiirtyminen1();
        }
        else if (missa>19&&missa<27){ 
            satunnainenSiirtyminen1();
        }
        else if(missa==34 || missa==36 || missa==37 || missa==39) {
            satunnainenSiirtyminen1();
        }
        else if (missa>=16&&missa<=18) {
            satunnainenSiirtyminen2();
        }
        else if (missa>=28&&missa<=30) {
            satunnainenSiirtyminen3();
        }
        else if (missa>=31&&missa<=33) {
            tavallinenSiirtyminen();
        }
        
    }
    private void tavallinenSiirtyminen() {
        kohta = kohdat.get(missa);
    }
    private void satunnainenSiirtyminen1() {
        int satunnainen1 = satunnaisluku(16,18); 
        kohta = kohdat.get(satunnainen1);
    }
    private void satunnainenSiirtyminen2() {
        int satunnainen2 = satunnaisluku(28,30);
        kohta = kohdat.get(satunnainen2);
    }
    private void satunnainenSiirtyminen3() {
        int satunnainen3 = satunnaisluku(31,33);
        kohta = kohdat.get(satunnainen3);
    }
    private int satunnaisluku(int ylaraja, int alaraja) {
      return alaraja + (int)(Math.random() * (ylaraja - alaraja + 1));
    }
    public void siirtyminenTiettyynKohtaan(int kohta) {
       this.kohta=kohdat.get(pelaaja.haeKohta(nimi));
    }
   
    public void tallenna() {
        pelaaja.asetaNimi(nimi);
        pelaaja.asetaKohta(missa);
        pelaaja.tallennaKohta();
        
    }
    public void asetaNimi(String nimi) {
        pelaaja.asetaNimi(nimi);
    }
    public String annaNimi() {
        return this.nimi;
    }
    public void asetaKohta(int valinta) {
        uusik=valinta;
        missa = missa*3 + uusik;
    }
    public int annaKohtaNumero() {
        return this.missa;
    }
    public int annaSiirto() {
        return this.uusik;
    }
    public Kohta annaKohta(int i) {
        return kohdat.get(i);
    }
}
