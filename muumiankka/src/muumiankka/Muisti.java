/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muumiankka;

/**
 *
 * @author Vierailija
 */
// tämä luokka toimii ohjaus-luokan ja tiedostojen tallentamisen välillä muistiin
//laitettavien ja sieltä heattavien asioden kohdalla.

import java.util.*;

public class Muisti {
   
    public static Scanner input = new Scanner(System.in);
    
    private Tiedostonkasittley tied;
    
    public Muisti () {
        this.tied=new Tiedostonkasittley();
    }
    
    public void asetaNimi(String nimi) {
        tied.asetaNimi(nimi);
        tied.tallennaNimet();
        tied.lueNimet();
    }
    
    public void tallennaMuistiin (String nimi, int kohta) {
            tied.muistiin(nimi,kohta);
    }
    public int haeNimellaKohta (String pelaaja) {
        
        String kohta1 = "";
        if (tied.onkoNimiKaytetty(pelaaja)==true) {
            kohta1 = tied.haeMuistista(pelaaja);
        } else {
            System.out.println("Nimelläsi ei ole tallennettu!");
        }
        int kohta=0;
        int kerroin=1;
        if(kohta1.length()>1) {
            for(int i=kohta1.length()-1; i>=0; i--) {
                kohta =kohta+((int)kohta1.charAt(i)-48)*kerroin;
                kerroin=kerroin*10;   
            }
        } else if(kohta1.length()==1 && kohta1.charAt(0)=='1'){
            kohta=1;
        }
        else if (kohta1.length()==1 && kohta1.charAt(0)=='2') {
            kohta=2;
        }
        else if (kohta1.length()==1 && kohta1.charAt(0)=='3') {
            kohta=3;
        } else  {
            kohta=0;
        }
        return kohta;
    }
    
}
