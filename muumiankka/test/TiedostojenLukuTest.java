/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import muumiankka.Tiedostonkasittley;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Vierailija
 */
public class TiedostojenLukuTest {
    
    Tiedostonkasittley eka;
    public String teksti;
    public String nimi;
    
    
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
        teksti = "";
        eka= new Tiedostonkasittley();
        nimi="Maija";
    }
    
    @After
    public void tearDown() {
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
        teksti = eka.tekstit.get(2);
        assertEquals("\nHOTELLIHUONE\nKirjauduttuaan hotelliin Muumiankka", teksti);
    }
    
    @Test
    public void tekstinLukuJaTalletusOikein2() {
       eka.tekstienLuku();
       teksti = eka.tekstit.get(1);
       assertEquals("\nKAHVILA\nPaikka oli tunnelmallinen ja",teksti);
    }    
    
    @Test
    public void tekstinLukuJaTalletusoikein3() {
        eka.tekstienLuku();
        teksti = eka.tekstit.get(0);
        assertEquals("\nALKU:\nSateisena ja koleana marraskuun\niltana saapui Rautatieasemalle\njuna. Siita nousi pieni ja pyyleva\nhahmo: Muumiankka.\nSilla oli kadessaan pilkullinen\nsateenvarjo. Pilkullinen koska\nse piti pilkullisita asioista.\nNuoruusvuosinaan se oli toivonut\nolevansa Leopardi. Voimakas ja\nnopea, seka ehdottomasti vaarallinen.\nMutta siita tulikin vain\ntavallinen ancusmuumicus.",teksti);
    }
    @Test
    public void muistinToiminta1 () {
        int tilanne;
        eka.muistiin("Maija",35);
        eka.muistiin("Pekka",6);
        tilanne = eka.haeMuistista("Maija");
        assertEquals(tilanne, 35);
    }
    @Test
    public void muististinToiminta2 () {
        int tilanne;
        eka.muistiin("Matti", 3);
        eka.muistiin("Aapo",17);
        tilanne = eka.haeMuistista("Aapo");
        assertEquals(tilanne, 17);
    }
    @Test
    public void muistinToiminta3 () {
        int tilanne;
        eka.muistiin("Kalle", 10);
        eka.muistiin("Kalle", 32);
        tilanne = eka.haeMuistista("Kalle");
        assertEquals(tilanne, 32);
    }
}
