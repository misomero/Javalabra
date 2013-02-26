/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Sovelluslogiikka.Ohjaus;
import java.io.File;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Vierailija
 */
public class OhjausTest {
    
    
    Ohjaus ohjaus;
    public OhjausTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        ohjaus=new Ohjaus();
    }
    
    @After
    public void tearDown() {
        ohjaus.siirtyminenAlkuun();
        ohjaus.asetaNimi("");
        File tiedosto= new File("Maija.txt");
        tiedosto.delete();
        File tiedosto2 = new File("Kalle.txt");
        tiedosto2.delete();
        File tiedosto3 = new File("Leena.txt");
        tiedosto3.delete();
        File tiedosto4 = new File("Minttu.txt");
        tiedosto4.delete();
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void KonstruktoriAsetaaKohdanOikein() {
        int eka = ohjaus.annaKohtaNumero();
        assertEquals(eka,0);
    }
    @Test 
    public void tavallinenSiirtoToimii () {
        ohjaus.asetaSiirto(2);
        ohjaus.siirtyminen();
        ohjaus.asetaSiirto(2);
        ohjaus.siirtyminen();
        int kohta=ohjaus.annaKohta().annaKohtaNro();
        assertEquals(kohta, 8);
    }
    @Test
    public void siirtyminenAlkuunToimii() {
        ohjaus.siirtyminenAlkuun();
        int kohta=ohjaus.annaKohta().annaKohtaNro();
        assertEquals(kohta,0);
    }
    @Test
    public void siirtyminen1Toimii () {
        ohjaus.asetaKohta(20);
        ohjaus.asetaSiirto(1);
        ohjaus.siirtyminen();
        int kohta=ohjaus.annaKohta().annaKohtaNro();
        assertEquals(kohta,16);
    }
    @Test
    public void siirtyminen2Toimii () {
        ohjaus.asetaKohta(17);
        ohjaus.asetaSiirto(2);
        ohjaus.siirtyminen();
        int kohta=ohjaus.annaKohta().annaKohtaNro();
        assertEquals(kohta,29);
    }
    @Test
    public void siirtyminen3Toimii () {
        ohjaus.asetaKohta(29);
        ohjaus.asetaSiirto(3);
        ohjaus.siirtyminen();
        int kohta=ohjaus.annaKohta().annaKohtaNro();
        assertEquals(kohta,33);
    }
    @Test
    public void asetaJaAnnaKohtaToimii() {
        ohjaus.siirtyminenAlkuun();
        ohjaus.asetaKohta(17);
        int kohta = ohjaus.annaKohtaNumero();
        assertEquals(kohta,17);       
    }
    @Test
    public void asetaJaAnnaSiirtoToimii() {
        ohjaus.siirtyminenAlkuun();
        ohjaus.asetaSiirto(2);
        int siirto = ohjaus.annaSiirto();
        assertEquals(siirto, 2);
    }
    @Test
    public void tallennaJaOnkoNimiKäytetty() {
        ohjaus.asetaKohta(13);
        ohjaus.asetaNimi("Kalle");
        ohjaus.tallenna();
        boolean arvo = ohjaus.onkoNimiKaytetty("Kalle");
        assertTrue(arvo);
    }
    @Test
    public void tallennaJaOnkoNimiKäytetty2() {
        ohjaus.asetaNimi("Lena");
        ohjaus.tallenna();
        boolean arvo = ohjaus.onkoNimiKaytetty("Minttu");
        assertFalse(arvo);
    }
    @Test
    public void tallennaJaHae() {
        ohjaus.asetaKohta(23);
        ohjaus.asetaNimi("Maija");
        ohjaus.tallenna();
        int kohta = ohjaus.siirtyminenTiettyynKohtaan("Maija");
        assertEquals(kohta,23);
    }
    @Test
    public void annaJaAsetaNimiToimii() {
        ohjaus.asetaNimi("Pekko");
        String nimi = ohjaus.annaNimi();
        assertEquals(nimi, "Pekko");
    }
}
