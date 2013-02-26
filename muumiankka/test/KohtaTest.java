/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Sovelluslogiikka.Kohta;
import Sovelluslogiikka.Tiedostonkasittley;
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
        tiedostot= new Tiedostonkasittley();
        testi = new Kohta(0,tiedostot);
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
        assertEquals(seuraaja1,new Kohta(1*3+1,tiedostot));
    }
    @Test
    public void KonstruktoriLuoSeuraajanOikein2 () {
        Kohta seuraaja2 = testi.annaSeuraaja(0, 2);
        assertEquals(seuraaja2,new Kohta(0*3+2,tiedostot));
    }
    @Test
    public void KonstruktoriLuoSeuraajanOikein3 () {
        Kohta seuraaja3 = testi.annaSeuraaja(3,3);
        assertEquals(seuraaja3,new Kohta(3*3+3,tiedostot));
    }
    @Test
    public void TekstiEiOleTyhja () {
        boolean arvo = testi.annaTeksti().equals("");
        assertEquals(arvo,false);
    }
    @Test
    public void AntaaKohdanNronOikein() {
        int kohta = testi.annaKohtaNro();
        assertEquals(kohta,0);
    }
    

}
