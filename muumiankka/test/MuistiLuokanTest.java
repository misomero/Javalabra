/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import Sovelluslogiikka.Muisti;
import Sovelluslogiikka.Tiedostonkasittley;
import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;

/**
 *
 * @author Vierailija
 */
public class MuistiLuokanTest {
    
    Muisti eka;
    Tiedostonkasittley tied;
    public MuistiLuokanTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        eka = new Muisti();
        tied = new Tiedostonkasittley();
    }
    
    @After
    public void tearDown() {
        tied.tyhjaennaNimet();
        File tiedosto1 = new File("Annika.txt");
        tiedosto1.delete();
        File tiedosto2 = new File("Pekka.txt");
        tiedosto2.delete();
        File tiedosto3 = new File("Anna.txt");
        tiedosto3.delete();
        File tiedosto4 = new File("Karri.txt");
        tiedosto4.delete();
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void nimenTallentaminenJaKayttoAste() {
        eka.asetaNimi("Miika");
        eka.asetaNimi("Marika");
        eka.asetaNimi("Aapeli");
        eka.asetaNimi("Marika");
        assertFalse(tied.onkoNimiKaytetty("Marika"));
    }
    @Test
    public void kohdanHakuJaTallennus () {
        eka.asetaNimi("Anna");
        eka.tallennaMuistiin("Anna",6);
        eka.asetaNimi("Karri");
        eka.tallennaMuistiin("Karri",16);
        int kohta = eka.haeNimellaKohta("Anna");
        assertEquals(kohta,6);
    }
    @Test
    public void kohdanHakuJaTallennus2 () {
        eka.asetaNimi("Pekka");
        eka.tallennaMuistiin("Pekka", 38);
        eka.asetaNimi("Annika");
        eka.tallennaMuistiin("Annika", 25);
        int kohta = eka.haeNimellaKohta("Annika");
        assertEquals(kohta,25);
    }
}
