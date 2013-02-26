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

    

    @Test
    public void onkoNimiKaytetty() {
        boolean arvo = eka.onkoNimiKaytetty("Ilmari");
        assertFalse(arvo);
    }
    @Test 
    public void onkoNimiKaytetty2() {
        eka.muistiin("Iina", 7);
        boolean arvo = eka.onkoNimiKaytetty("Iina");
        assertTrue(arvo);
    }
    @Test
    public void tekstinLukuJaTalletusOikein() {
        eka.tekstienLuku();
        boolean arvo = eka.annaTeksti(3).equals("");
        assertEquals(arvo,false);
    }
    @Test
    public void tilanteenTallettaminenJaHaku1 () {
        int tilanne;
        eka.muistiin("Maija",6);
        eka.muistiin("Pekka",25);
        tilanne = eka.haeNimellaKohta("Maija");
        assertEquals(tilanne, "6");
    }
    @Test
    public void tilanteenTallettaminenJaHaku2 () {
        int tilanne;
        eka.muistiin("Matti", 3);
        eka.muistiin("Aapo",17);
        tilanne = eka.haeNimellaKohta("Aapo");
        assertEquals(tilanne, 17);
    }
    @Test
    public void tilanteenTallettaminenJaHaku3 () {
        int tilanne;
        eka.muistiin("Kalle", 10);
        eka.muistiin("Kalle", 32);
        tilanne = eka.haeNimellaKohta("Kalle");
        assertEquals(tilanne, 32);
    }
    
   
}
