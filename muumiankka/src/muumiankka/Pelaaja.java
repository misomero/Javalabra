/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muumiankka;

/**
 *
 * @author Vierailija
 */
public class Pelaaja {
    
    private int kohta;
    private String nimi;
    private Muisti muisti;
    private Tiedostonkasittley tiedostot;
    
    public Pelaaja(String nimi, int kohta) {
        this.kohta=kohta;
        this.nimi=nimi;
        this.muisti= new Muisti();
        this.tiedostot= new Tiedostonkasittley();
    }
    public int annakohta() {
        return kohta;
    }
    public void asetaKohta(int n) {
        kohta = n;
    }
    public String annaNimi() {
        return nimi;
    }
    public void asetaNimi(String nimi) {
        this.nimi=nimi;
        tiedostot.asetaNimi(nimi);
        tiedostot.tallennaNimet();
        tiedostot.lueNimet();
    }
    public void tallennaKohta() {
        muisti.tallennaMuistiin(nimi, kohta);
    }
    public int haeKohta(String nimi) {
        return muisti.haeNimellaKohta(nimi);
    }
}
