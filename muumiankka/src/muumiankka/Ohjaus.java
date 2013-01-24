/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muumiankka;

/**
 *
 * @author Vierailija
 */
public class Ohjaus {
    
    public String pelaaja;
    public char valintakohta;
    private Tilat eka = new Tilat();
    private Muisti toka = new Muisti();
    
    public Ohjaus () {
        this.eka=eka;
        this.toka=toka;
        this.pelaaja=pelaaja;
    }
    
    public void siirry () {
        eka.etsiTila(valintakohta);
    }
    
    public void tallenna() {
        toka.tallennaMuistiin(pelaaja,valintakohta);
    }
    public String annaNimi() {
        return pelaaja;
    }
    public void haeKohta() {
        
    }
}
