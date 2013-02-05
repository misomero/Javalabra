/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import muumiankka.Muisti;
import muumiankka.Tiedostonkasittley;
import org.junit.*;
import static org.junit.Assert.*;

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
        tied.nimet.clear();
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void nimenTallentaminenJaPoisto() {
        eka.asetaNimi("Miika");
        eka.asetaNimi("Marika");
        eka.asetaNimi("Aapeli");
        eka.asetaNimi("Marika");
        assertFalse(tied.nimet.contains("Marika"));
    }
    @Test
    public void onkoNimiVapaa () {
        eka.asetaNimi("Kari");
        eka.asetaNimi("Iivari");
        boolean arvo = eka.onkoNimiKaytetty("Iivari");
        assertTrue(arvo);
    }
    @Test
    public void onkoNimiVapaa2 () {
        eka.asetaNimi("Annika");
        eka.asetaNimi("Pekka");
        boolean arvo = eka.onkoNimiKaytetty("Anni");
        assertFalse(arvo);
    }
    @Test
    public void kohdanHakuJaTallennus () {
        eka.tallennaMuistiin("Anna",6);
        eka.tallennaMuistiin("Karri",16);
        int kohta = eka.haeNimellaKohta("Anna");
        assertEquals(kohta,6);
    }
    @Test
    public void kohdanHakuJaTallennus2 () {
        eka.tallennaMuistiin("Pekka", 38);
        eka.tallennaMuistiin("Annika", 25);
        int kohta = eka.haeNimellaKohta("Annika");
        assertEquals(kohta,25);
    }
}
