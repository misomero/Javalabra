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
    
    private ArrayList<Kohta> seuraajat;
    private String tkstsisalto;
    private Tiedostonkasittley tiedos;
//    public Kuvankasittely kuvak= new Kuvankasittely();
//    public BufferedImage kuva;
    private int kohta;
    
    public Kohta(int kohta) {
        this.kohta=kohta;
//        this.kuvak=kuvak;;
        this.tiedos=new Tiedostonkasittley();
        tiedos.tekstienLuku();
//        this.kuva=kuvak.kuvat.get(kohta);
        this.seuraajat=new ArrayList();
        this.tkstsisalto=tiedos.annaTeksti(kohta);

        if(kohta<=12&&kohta != 5 &&kohta!=10) {
            Kohta seuraaja1 = new Kohta((kohta*3)+1);
            Kohta seuraaja2 = new Kohta((kohta*3)+2);
            Kohta seuraaja3 = new Kohta((kohta*3)+3);
            this.seuraajat.add(seuraaja1);
            this.seuraajat.add(seuraaja2);
            this.seuraajat.add(seuraaja3);
        } 
        else if (kohta==31 || kohta==32 || kohta==33){
            Kohta viimeinen = new Kohta(40);
            this.seuraajat.add(viimeinen);
        }
        else if (kohta==38 || kohta ==5 || kohta==10 || kohta==14 || kohta==19 || kohta==27 || kohta==35) {
            Kohta umpikuja = new Kohta(41);
            this.seuraajat.add(umpikuja);
        }
        
    }
    public String annaTeksti(int kohta) {
        Kohta tassa = new Kohta(kohta);
        return tassa.tkstsisalto;
    }
    public Kohta annaSeuraaja (int lahtokohta, int valinta) {
        Kohta edeltaja = new Kohta(lahtokohta);
        return edeltaja.seuraajat.get(valinta-1);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Kohta other = (Kohta) obj;
        if (this.kohta != other.kohta) {
            return false;
        }
        return true;
    }

   
   
   
    
}
