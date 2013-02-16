/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muumiankka;

/**
 *
 * @author Vierailija
 */
public class Muumiankka {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      Pelaaja nimi = new Pelaaja("Maija",0);  
      nimi.tallennaKohta();
      Kohta testi = new Kohta(0);
      System.out.println(testi.annaTeksti(2));
    }
}
