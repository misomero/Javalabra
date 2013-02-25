/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import Sovelluslogiikka.Tiedostonkasittley;
import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;
/**
 *
 * @author Vierailija
 */
public class TiedostojenLukuTest {
    
    Tiedostonkasittley eka;
    public String teksti;
    public String nimi;
    public File aad;
    
    
    public TiedostojenLukuTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        eka= new Tiedostonkasittley();
        }
    
    @After
    public void tearDown() {
        eka.tyhjaennaNimet();
        eka.poistaTekstit();
        File tiedosto= new File("Maija.txt");
        tiedosto.delete();
        File tiedosto2 = new File("Pekka.txt");
        tiedosto2.delete();
        File tiedosto3 = new File("Matti.txt");
        tiedosto3.delete();
        File tiedosto4 = new File("Aapo.txt");
        tiedosto4.delete();
        File tiedosto5 =new File("Kalle.txt");
        tiedosto5.delete();
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
//    @Test
//    public void tiedostonLukuOikein1() {
//        eka.tekstienLuku();
//        
//        assertEquals("\nALKU:\nSateisena ja koleana marraskuun\niltana saapui Rautatieasemalle\njuna. Siita nousi pieni ja pyyleva\nhahmo: Muumiankka.\nSilla oli kadessaan pilkullinen\nsateenvarjo. Pilkullinen koska\nse piti pilkullisita asioista.\nNuoruusvuosinaan se oli toivonut\nolevansa Leopardi. Voimakas ja\nnopea, seka ehdottomasti vaarallinen.\nMutta siita tulikin vain\ntavallinen ancusmuumicus.",eka.tekstit.get(0));
//    }
//    
    
    
    
    @Test
    public void tekstinLukuJaTalletusOikein() {
        eka.tekstienLuku();
        boolean arvo = eka.annaTeksti(3).equals("");
        assertEquals(arvo,false);
    }
    @Test
    public void tilanteenTallettaminenJaHaku1 () {
        String tilanne;
        eka.muistiin("Maija",6);
        eka.muistiin("Pekka",25);
        tilanne = eka.haeMuistista("Maija");
        assertEquals(tilanne, "6");
    }
    @Test
    public void tilanteenTallettaminenJaHaku2 () {
        String tilanne;
        eka.muistiin("Matti", 3);
        eka.muistiin("Aapo",17);
        tilanne = eka.haeMuistista("Aapo");
        assertEquals(tilanne, "17");
    }
    @Test
    public void tilanteenTallettaminenJaHaku3 () {
        String tilanne;
        eka.muistiin("Kalle", 10);
        eka.muistiin("Kalle", 32);
        tilanne = eka.haeMuistista("Kalle");
        assertEquals(tilanne, "32");
    }
    @Test
    public void nimienLukuJaTallennus() {
        eka.asetaNimi("Pekka");
        eka.asetaNimi("Antti");
        eka.tallennaNimet();
        eka.poistaNimet();
        eka.lueNimet();
        String nimi = eka.annaNimi(0);
        assertEquals(nimi,"Pekka");
        
    }
   
}
