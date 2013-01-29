/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muumiankka;

/**
 *
 * @author Vierailija
 */

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import java.util.*;

public class Kuvankasittely {
    
    BufferedImage img;
    
    public ArrayList<BufferedImage> kuvat = new ArrayList();
    
    public Kuvankasittely() {
        this.img=null;
    } 
    
    public void lataaKuvat() {
        for(int i=0; i<=40; i++){
            String tiedosto = "kuva"+i+".jpeg";
            try {
                img=ImageIO.read(new File(tiedosto));
            } catch (Exception e) {
                System.out.println("Virhe tiedoston luvussa!");
            }
            kuvat.add(img);
        }
    }
}
