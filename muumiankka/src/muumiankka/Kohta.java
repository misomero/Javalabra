/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muumiankka;

import java.awt.image.BufferedImage;

/**
 *
 * @author Vierailija
 */
import java.util.*;
public class Kohta {
    
    public ArrayList<Kohta> seuraajat = new ArrayList();
    public String tkstsisalto;
    public Tiedostonkasittley tiedos;
    public Kuvankasittely kuvak;
    public BufferedImage kuva;
    
    public Kohta(int kohta) {
        this.kuvak=new Kuvankasittely();
        this.tiedos=new Tiedostonkasittley();
        this.tkstsisalto=tiedos.tekstit.get(kohta);
        this.kuva=kuvak.kuvat.get(kohta);
        if(kohta<=12) {
        this.seuraajat.add(new Kohta(kohta+1));
        this.seuraajat.add(new Kohta(kohta+2));
        this.seuraajat.add(new Kohta(kohta+3));
        } else {
            this.seuraajat.add(new Kohta(40));
        }
        
    }
    
}
