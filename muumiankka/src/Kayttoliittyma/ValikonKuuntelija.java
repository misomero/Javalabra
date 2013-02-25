/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

/**
 *
 * @author Vierailija
 */

import java.awt.event.*;
import javax.swing.*;
public class ValikonKuuntelija implements ActionListener {
    GraafinenOhjelma ohjelma;
    
    ValikonKuuntelija(GraafinenOhjelma ohjelma) {
        this.ohjelma= ohjelma;
    }
    @Override
    public void actionPerformed(ActionEvent tapahtuma) {
        String valinta = ((JMenuItem)tapahtuma.getSource()).getText();
        if(valinta.equals("Uusi peli")) {
            ohjelma.uusi();
        }
        if(valinta.equals("Tallenna")) {
            ohjelma.tallenna();
        }
        if(valinta.equals("Lataa tallennettu peli")) {
            ohjelma.lataa();
        }
        if(valinta.equals("Poista tallennettu peli")) {
            ohjelma.poistaNimi();
        }
        if(valinta.equals("Sulje")) {
            ohjelma.sulje();
        }
        if(valinta.equals("Tietoa pelistä")) {
            ohjelma.tietoa();
        }
        if(valinta.equals("Peliohje")) {
            ohjelma.ohje();
        }
    }
}
