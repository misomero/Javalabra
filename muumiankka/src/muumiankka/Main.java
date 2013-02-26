package muumiankka;


import Kayttoliittyma.GraafinenOhjelma;
import javax.swing.SwingUtilities;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vierailija
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       GraafinenOhjelma ohjelma = new GraafinenOhjelma();
       SwingUtilities.invokeLater(ohjelma);
        
    }


    
}
