/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import muumiankka.Kohta;
import muumiankka.Tiedostonkasittley;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Vierailija
 */
import java.util.*;

public class KohtaTest {
    
    Kohta testi;
    Tiedostonkasittley tiedostot;
    ArrayList<Kohta> seurajat;
    public KohtaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        testi = new Kohta(0);
        tiedostot= new Tiedostonkasittley();
        tiedostot.tekstienLuku();
        seurajat = new ArrayList();
    }
    
    @After
    public void tearDown() {
        seurajat.clear();
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void KonstruktoriLuoSeuraajanOikein () {
        Kohta seuraaja1 = testi.annaSeuraaja(1,1);
        assertEquals(seuraaja1,new Kohta(1*3+1));
    }
    @Test
    public void KonstruktoriLuoSeuraajanOikein2 () {
        Kohta seuraaja2 = testi.annaSeuraaja(1, 2);
        assertEquals(seuraaja2,new Kohta(1*3+2));
    }
    @Test
    public void KonstruktoriLuoSeuraajanOikein3 () {
        Kohta seuraaja3 = testi.annaSeuraaja(1,3);
        assertEquals(seuraaja3,new Kohta(1*3+3));
    }
    @Test
    public void KonstruktoriLuoKohdanOikein4 () {
        String tekstit = testi.annaTeksti(2);
        assertEquals(tekstit, "\nHOTELLIHUONE\nKirjauduttuaan hotelliin Muumiankka\n");
    }
    

}
