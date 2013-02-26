/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka;

/**
 *
 * @author Vierailija
 */

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;


public class Kuvankasittely {
    
    BufferedImage img;
    
    public Kuvankasittely() {
        this.img=null;
    } 
    
    private void lataaKuva() {
            String tiedosto = "muumiankka.jpg";
            try {
                img=ImageIO.read(new File(tiedosto));
            } catch (Exception e) {
                System.out.println("Virhe tiedoston luvussa!");
            }
    }
    public BufferedImage annaKuva() {
        return img;
    }
    public BufferedImage annaLadattuKuva() {
        lataaKuva();
        return img;
    }
}
