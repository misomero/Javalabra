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
    
    public Muisti muisti;
    public Kohta kohta;
    public int missa;
    public int uusik;
    public String pelaaja;
    
    public Ohjaus () {
       
        this.muisti=new Muisti();
        this.missa=0;
        this.kohta= new Kohta(missa);
        
    }
    
     
    public void siirtyminen() {
        missa+=uusik;
    }
    
   
    public void tallenna() {
        muisti.tallennaMuistiin(pelaaja,missa);
    }
    public void asetaNimi(String nimi) {
        muisti.pelaaja=nimi;
    }
}
