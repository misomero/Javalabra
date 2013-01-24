/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muumiankka;

/**
 *
 * @author Vierailija
 */
public class Muisti {
   
    private Tiedostonkasittley eka = new Tiedostonkasittley();
    
    public Muisti () {
        this.eka=eka;
    }
    
    public void tallennaMuistiin (String nimi, char kohta) {
        eka.muistiin(nimi,kohta);
    }
}
