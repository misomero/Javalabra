/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muumiankka;


/**
 *
 * @author Vierailija
 */
import Kayttoliittyma.GraafinenOhjelma;
import javax.swing.*;
public class Muumiankka {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       GraafinenOhjelma ohjelma = new GraafinenOhjelma();
       SwingUtilities.invokeLater(ohjelma);
        
    }
}
