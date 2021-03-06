/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

/**
 *
 * @author Vierailija
 */

import Sovelluslogiikka.Ohjaus;
import java.awt.*;
import javax.swing.*;

public class GraafinenOhjelma implements Runnable{
    
    private JFrame ikkuna;
    private Container nappulat;
    private JLabel kentta;
    private JTextArea tekstikentta;
    private ImageIcon kuva;
    private Ohjaus ohjaus = new Ohjaus();
    private int kohta;
    
    @Override
    public void run() {
        ikkuna = new JFrame("Muumiankan seikkailu");
        ikkuna.setPreferredSize(new Dimension (800,600));
//        ikkuna.setIconImage(ohjaus.annaKuva());
   
        luovalikot();
        luoKomponentit();
        this.kohta=-1;
        ikkuna.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ikkuna.pack();
        ikkuna.setVisible(true);
        
        
    }
    private void luovalikot() {
        
        JMenuBar valikko = new JMenuBar();
        
        JMenu valikkoPeli = new JMenu("Peli");
        valikko.add(valikkoPeli);
        JMenu valikkoOhje = new JMenu("Ohje");
        valikko.add(valikkoOhje);
        
        JMenuItem valikkoUusi = new JMenuItem("Uusi peli");
        valikkoUusi.addActionListener(new ValikonKuuntelija(this));
        valikkoPeli.add(valikkoUusi);
        
        JMenuItem valikkoTallenna = new JMenuItem("Tallenna");
        valikkoTallenna.addActionListener(new ValikonKuuntelija(this));
        valikkoPeli.add(valikkoTallenna);
        
        JMenuItem valikkoLataa = new JMenuItem("Lataa tallennettu peli");
        valikkoLataa.addActionListener(new ValikonKuuntelija(this));
        valikkoPeli.add(valikkoLataa);
        
        JMenuItem valikkoSulje = new JMenuItem("Sulje");
        valikkoSulje.addActionListener(new ValikonKuuntelija(this));
        valikkoPeli.add(valikkoSulje);
        
        JMenuItem valikkoTietoa = new JMenuItem("Tietoa pelistä");
        valikkoTietoa.addActionListener(new ValikonKuuntelija(this));
        valikkoOhje.add(valikkoTietoa);
        
        JMenuItem valikkoOhjeita = new JMenuItem("Peliohje");
        valikkoOhjeita.addActionListener(new ValikonKuuntelija(this));
        valikkoOhje.add(valikkoOhjeita);
        
        
        ikkuna.setJMenuBar(valikko);
    }
    private void luoKomponentit() {
        Container pohja = ikkuna.getContentPane();
        
        pohja.setLayout(new BoxLayout(pohja, BoxLayout.Y_AXIS));
        pohja.setBackground(Color.BLACK);
        pohja.setForeground(Color.WHITE);
        
        tekstikentta= new JTextArea();
        tekstikentta.setBackground(Color.darkGray);
        tekstikentta.setForeground(Color.WHITE);
        tekstikentta.setFont(new Font("Serif", Font.ROMAN_BASELINE, 12));
        tekstikentta.setAlignmentX(Component.CENTER_ALIGNMENT);
        tekstikentta.setAlignmentY(Component.CENTER_ALIGNMENT);
        tekstikentta.setEditable(false);
        tekstikentta.setLineWrap(true);
        tekstikentta.setWrapStyleWord(true);
        pohja.add(tekstikentta);
        
        kentta = new JLabel();
        kuva = new ImageIcon(ohjaus.annaKuva());
        kentta.setIcon(kuva);
        kentta.setAlignmentX(Component.LEFT_ALIGNMENT);
        pohja.add(kentta);
        
        nappulat = new Container();
        nappulat.setLayout(new FlowLayout());
        
        JButton nappula1 = new JButton("1");
        nappula1.setBackground(Color.WHITE);
        nappula1.setAlignmentX(Component.CENTER_ALIGNMENT);
        nappula1.addActionListener(new NappulanKuuntelija(this));
        nappulat.add(nappula1);
        
        JButton nappula2 = new JButton("2");
        nappula2.setBackground(Color.WHITE);
        nappula2.setAlignmentX(Component.CENTER_ALIGNMENT);
        nappula2.addActionListener(new NappulanKuuntelija(this));
        nappulat.add(nappula2);
        
        JButton nappula3 = new JButton("3");
        nappula3.setBackground(Color.WHITE);
        nappula3.setAlignmentX(Component.CENTER_ALIGNMENT);
        nappula3.addActionListener(new NappulanKuuntelija(this));
        nappulat.add(nappula3);
        pohja.add(nappulat);
    }
        
    public void uusi() {
        kohta=0;
        String nimi = JOptionPane.showInputDialog("Anna nimesi! ");
        if(ohjaus.onkoNimiKaytetty(nimi)==true) {
            JOptionPane.showMessageDialog(ikkuna, "Nimelläsi on pelattu, voit ladata aijemman\npelitilanteen valikosta 'Lataa tallennettu peli'.\nJos haluat aloittaa uuden pelin, jatka tästä.\nJos tallennat tällä nimellä, "
                    + "\nhävität aijemman pelitilanteen!");
        }
        if(nimi==null) {
            kohta=-1;
        }
        else {
        JOptionPane.showMessageDialog(ikkuna, "Tervetuloa pelaamaan, " +nimi);
        ohjaus.asetaNimi(nimi);
        ohjaus.asetaKohta(0);
        aloita();
        }
    }
    public void tallenna() {
       int arvo= ohjaus.tallenna();
       
       if(arvo==0) {
           JOptionPane.showMessageDialog(ikkuna, "Pelitilanteesi on tallennettu, voit ladata sen valikosta pelaajanimelläsi!");
       } 
       else if (arvo==-1) {
           JOptionPane.showMessageDialog(ikkuna, "Virhe talentamisessa, yritä uudelleen!");
       }
    }
    public void lataa() {
        String nimi = JOptionPane.showInputDialog("Anna pelaajanimesi: ");
        JOptionPane.showMessageDialog(ikkuna, "Peliäsi ladataan!");
        if(ohjaus.siirtyminenTiettyynKohtaan(nimi)==43) {
            JOptionPane.showMessageDialog(ikkuna,"Nimelläsi ei ole tallennettu");
        } else if (ohjaus.siirtyminenTiettyynKohtaan(nimi)==42) {
            JOptionPane.showMessageDialog(ikkuna,"Virhe latauksessa!");
        } else if(ohjaus.siirtyminenTiettyynKohtaan(nimi)<42){
            ohjaus.siirtyminenTiettyynKohtaan(nimi);
            this.kohta=ohjaus.annaKohtaNumero();
            tekstikentta.setText(ohjaus.annaKohta().annaTeksti());
        }
    }
    
    public void sulje() {
        ohjaus.asetaKohta(0);
        ohjaus.asetaNimi("");
        ikkuna.dispose();
    }
    
    public void tietoa() {
        JOptionPane.showMessageDialog(ikkuna, "Mikä tämä on? \nOlet käynnistänyt tekstuaalisen seikkalupelin,\njossa voit valita aina kolmesta\ntekemisvaihtoehdosta.\nSeuraavaan vaiheeseen seikkailua\npääset klikkaamalla nappuloita\nvalintasi mukaan.\nKatso pääsetkö perille,\nvai juututko matkan varrelle!");
    }
    public void ohje() {
        JOptionPane.showMessageDialog(ikkuna, "Uuden pelin saat valikosta \nvalitsemalla 'Uusi peli'. \nVoit tallentaa sen hetkisen \npelitilanteesi valitsemalla 'Tallenna'.\nTallennetun pelin voit ladata \n'Lataa tallennettu peli'\nkohdasta pelaajanimelläsi.");
    }
    
    public void siirry1() {
        if(kohta>=0) {
        if(kohta<=41) {
        ohjaus.asetaSiirto(1);
        ohjaus.siirtyminen();
        tekstikentta.setText(ohjaus.annaKohta().annaTeksti());
            if(ohjaus.annaKohtaNumero()<40) {
                kohta = ohjaus.annaKohtaNumero();
            } else {
                kohta = ohjaus.annaKohtaNumero()+2;
            }
        }
        else {
            JOptionPane.showMessageDialog(ikkuna,"Peli loppui,\nvoit pelata uuden\nja katsoa onko se erilainen!");
        }
        }
    }
    public void siirry2(){
        if(kohta>=0) {
        if(kohta<=41) {
        ohjaus.asetaSiirto(2);
        ohjaus.siirtyminen();
        tekstikentta.setText(ohjaus.annaKohta().annaTeksti());
            if(ohjaus.annaKohtaNumero()<40) {
                kohta = ohjaus.annaKohtaNumero();
            } else {
                kohta = ohjaus.annaKohtaNumero()+2;
            }
        }
        else {
            JOptionPane.showMessageDialog(ikkuna, "Peli loppui,\nvoit pelata uuden\nja katsoa onko se erilainen!");
        }
        }
        
    }
    public void siirry3() {
        if(kohta>=0) {
        if(kohta<=41) {
        ohjaus.asetaSiirto(3);
        ohjaus.siirtyminen();
        tekstikentta.setText(ohjaus.annaKohta().annaTeksti());
            if(ohjaus.annaKohtaNumero()<40) {
                kohta = ohjaus.annaKohtaNumero();
            } else {
                kohta = ohjaus.annaKohtaNumero()+2;
            }
        }
        else {
            JOptionPane.showMessageDialog(ikkuna, "Peli loppui,\nvoit pelata uuden\nja katsoa onko se erilainen!");
        }
        }
    }
    
    public void aloita() {
        kohta=0;
        if(ohjaus.annaKohta().annaTeksti()==null){
            JOptionPane.showMessageDialog(ikkuna, "Ethän poistanut tekstitiedostoja pelikansiosta!");
            tekstikentta.setText("Virhetilanne!!");
        } else {
            ohjaus.siirtyminenAlkuun();
            tekstikentta.setText(ohjaus.annaKohta().annaTeksti());
        }
        
    }
}
