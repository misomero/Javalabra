/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka;

/**
 * Tämä luokka hoitaa kuvan latauksen
 * @author Vierailija
 */

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;


/**
 * 
 * @author Vierailija
 */
public class Kuvankasittely {
    
    BufferedImage img;
    
    /**
     * konstruktori asetaa kuvan tyhjäksi arvoksi
     */
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
    /**
     * palautaa kuvan
     * @return kuva
     */
    public BufferedImage annaKuva() {
        return img;
    }
    /**
     * käytää sisäistä metodia lataaKuva() joka lataa halutun kuvan parametiin img
     * @return palautaa muumiankakuvan img muutujassa.
     */
    public BufferedImage annaLadattuKuva() {
        lataaKuva();
        return img;
    }
}
