/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Sovelluslogiikka.Kuvankasittely;
import java.awt.image.BufferedImage;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Vierailija
 */
public class KuvankasittelyTest {
    
    private Kuvankasittely kuvak;
    private BufferedImage kuva;
    public KuvankasittelyTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        kuvak= new Kuvankasittely();
    }
    
    @After
    public void tearDown() {
        
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void konstruktoriLuoKuvanOikein() {
        kuva = kuvak.annaKuva();
        assertEquals(kuva, null);
    }
    @Test
    public void latausKayOikein() {
        boolean arvo = !kuvak.annaLadattuKuva().equals(null);
        assertTrue(arvo);
        
    }
}
