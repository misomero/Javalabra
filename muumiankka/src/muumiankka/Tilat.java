/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muumiankka;

/**
 *
 * @author Vierailija
 */
public class Tilat {
    
    Tiedostonkasittley tama = new Tiedostonkasittley();
    
    public Tilat (){
        this.tama=tama;
    }
    
    public void etsiTila(char kohta) {
        
        tama.tekstit.get((int)kohta+1);
    }
}
