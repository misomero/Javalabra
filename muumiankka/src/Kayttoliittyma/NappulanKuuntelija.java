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

public class NappulanKuuntelija implements ActionListener {
    
    private GraafinenOhjelma ohjelma;
    
    public NappulanKuuntelija(GraafinenOhjelma ohjelma) {
        this.ohjelma=ohjelma;
    }
    
    @Override
    public void actionPerformed (ActionEvent e) {
        
        JButton nappula = ((JButton)e.getSource());
        
        if(nappula.getText().equals("1")) {
            ohjelma.siirry1();
        }
        if(nappula.getText().equals("2")) {
            ohjelma.siirry2();
        }
        if(nappula.getText().equals("3")) {
            ohjelma.siirry3();
        }
       
    }
    
}
