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
public class Kohta {
    
    public int kohta;
    public Kohta seuraaja1;
    public Kohta seuraaja2;
    public Kohta seuraaja3;
    public String tkstsisalto;
    public Tiedostonkasittley tiedos;
    public Kuvankasittely kuvak;
    public BufferedImage kuva;
    
    public Kohta(int kohta) {
        
        this.kohta=kohta;
        if(kohta<=12) {
        this.seuraaja1= new Kohta(kohta+1);
        this.seuraaja2= new Kohta(kohta+2);
        this.seuraaja3= new Kohta(kohta+3);
        this.kuvak=new Kuvankasittely();
        } else {
            this.seuraaja1=this.seuraaja2=this.seuraaja3= new Kohta(40);
        }
        this.tiedos=tiedos;
        this.tkstsisalto=tiedos.tekstit.get(kohta);
        this.kuva=kuvak.kuvat.get(kohta);
    }
    
}
