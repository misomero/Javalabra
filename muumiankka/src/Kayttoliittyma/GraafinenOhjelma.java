/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

/**
 *
 * @author Vierailija
 */

import java.awt.*;
import javax.swing.*;

import Sovelluslogiikka.*;

public class GraafinenOhjelma implements Runnable{
    
    private JFrame ikkuna;
    private Container nappulat;
    private JTextArea tekstikentta;
    private Ohjaus ohjaus = new Ohjaus();
    private int kohta;
    
    public void run() {
        ikkuna = new JFrame("Muumiankan seikkailu");
        ikkuna.setPreferredSize(new Dimension (600,400));
        ikkuna.setIconImage(ohjaus.annaKuva());
   
        luovalikot();
        luoKomponentit();
        this.kohta=0;
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
        
        
        ikkuna.setJMenuBar(valikko);
    }
    private void luoKomponentit() {
        Container pohja = ikkuna.getContentPane();
        
        pohja.setLayout(new BoxLayout(pohja, BoxLayout.Y_AXIS));
        pohja.setBackground(Color.LIGHT_GRAY);
        pohja.setForeground(Color.WHITE);
        
        tekstikentta= new JTextArea();
        tekstikentta.setBackground(Color.darkGray);
        tekstikentta.setForeground(Color.WHITE);
        tekstikentta.setFont(new Font("Serif", Font.ROMAN_BASELINE, 18));
        tekstikentta.setAlignmentX(Component.CENTER_ALIGNMENT);
        tekstikentta.setAlignmentY(Component.CENTER_ALIGNMENT);
        pohja.add(tekstikentta);
        
        nappulat = new Container();
        nappulat.setLayout(new FlowLayout());
        
        JButton nappula1 = new JButton("1");
        nappula1.setBackground(Color.BLUE);
        nappula1.setAlignmentX(Component.CENTER_ALIGNMENT);
        nappula1.addActionListener(new NappulanKuuntelija(this));
        nappulat.add(nappula1);
        
        JButton nappula2 = new JButton("2");
        nappula2.setBackground(Color.orange);
        nappula2.setAlignmentX(Component.CENTER_ALIGNMENT);
        nappula2.addActionListener(new NappulanKuuntelija(this));
        nappulat.add(nappula2);
        
        JButton nappula3 = new JButton("3");
        nappula3.setBackground(Color.GREEN);
        nappula3.setAlignmentX(Component.CENTER_ALIGNMENT);
        nappula3.addActionListener(new NappulanKuuntelija(this));
        nappulat.add(nappula3);
        pohja.add(nappulat);
    }
        
    public void uusi() {
        String nimi = JOptionPane.showInputDialog("Anna nimesi! ");
        JOptionPane.showMessageDialog(ikkuna, "Tervetuloa pelaamaan, " +nimi);
        ohjaus.asetaNimi(nimi);
        ohjaus.asetaKohta(0);
        aloita();
    }
    public void tallenna() {
       if(ohjaus.tallenna()==0) {
           JOptionPane.showMessageDialog(ikkuna, "Pelitilanteesi on tallennettu, voit ladata sen valikosta pelaajanimelläsi!");
       } 
       else if (ohjaus.tallenna()==-1) {
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
        }
    }
    public void sulje() {
        ohjaus.tallenna();
        ohjaus.asetaKohta(0);
        ohjaus.asetaNimi("");
        ohjaus.tyhjennaNimet();
        ikkuna.dispose();
    }
    
    public void tietoa() {
        JOptionPane.showMessageDialog(ikkuna, "Tämä on tekstuaalinen seikkalupeli,\njossa voit valita aina kolmesta\ntekemisvaihtoehdosta, jotka kaikki\njohtavat eri lopputulemiin.\nAloita klikkaamalla Uusi peli\nja antamalla oma nimesi.\nSeuraavaan vaiheeseen seikkailua\npääset klikkaamalla nappuloita\nvalintasi mukaan.\nKatso pääsetkö perille,\nvai juututko matkan varrelle!");
    }
    
    public void siirry1() {
        if(kohta<41) {
        ohjaus.asetaSiirto(1);
        ohjaus.siirtyminen();
        tekstikentta.setText(ohjaus.annaKohta().annaTeksti());
        kohta = ohjaus.annaKohtaNumero();
        }
        if(kohta==41||kohta==42) {
            tekstikentta.setFont(new Font("Serif", Font.BOLD, 24));
            tekstikentta.setText("LOPPU");
        }
    }
    public void siirry2(){
        if(kohta<41) {
        ohjaus.asetaSiirto(2);
        ohjaus.siirtyminen();
        tekstikentta.setText(ohjaus.annaKohta().annaTeksti());
        kohta=ohjaus.annaKohtaNumero();
        }
        if(kohta==41||kohta==42) {
            tekstikentta.setFont(new Font("Serif", Font.BOLD, 24));
            tekstikentta.setText("LOPPU");
        }
    }
    public void siirry3() {
        if(kohta<41) {
        ohjaus.asetaSiirto(3);
        ohjaus.siirtyminen();
        tekstikentta.setText(ohjaus.annaKohta().annaTeksti());
        kohta=ohjaus.annaKohtaNumero();
        }
        if(kohta==41||kohta==42) {
            tekstikentta.setFont(new Font("Serif", Font.BOLD, 24));
            tekstikentta.setText("LOPPU");
        }
    }
    
    public void aloita() {
        if(ohjaus.annaKohta().annaTeksti()==null){
            JOptionPane.showMessageDialog(ikkuna, "Ethän poistanut tekstitiedostoja pelistä!");
        } else {
            tekstikentta.setText(ohjaus.annaKohta().annaTeksti());
        }
        
    }
}
