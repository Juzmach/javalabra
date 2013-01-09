package pelilogiikkatest;


import gladiaattorit.pelilogiikka.Gladiaattori;
import gladiaattorit.pelilogiikka.Ruutu;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author juusostr
 */
public class GladiaattoriTest {

    private Gladiaattori taistelija;
    private Ruutu ruutu;
    private Ruutu ruutu2;

    /**
     *
     */
    public GladiaattoriTest() {
    }

    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }

    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     *
     */
    @Before
    public void setUp() {
        taistelija = new Gladiaattori("Taavi", 0);
        ruutu = new Ruutu(3, 3);
        ruutu2 = new Ruutu(3,4);
        ruutu.asetaGladiaattori(taistelija);
    }

    /**
     *
     */
    @After
    public void tearDown() {
    }

    /**
     *
     */
    @Test
    public void gladiaattorinNimiEiOleTyhja() {
        assertFalse("Gladiaattorin nimi on tyhjä!", taistelija.getNimi().isEmpty());
    }

    /**
     *
     */
    @Test
    public void vahennaEnergiaaEiVahennaAlleNollan() {
        taistelija.vahennaEnergiaa(taistelija.getEnergia() + 1);
        assertEquals(0, taistelija.getEnergia());
    }

    /**
     *
     */
    @Test
    public void gladiaattoriKaatuuJosEnergiaOnNolla() {
        taistelija.setEnergia(10);
        taistelija.vahennaEnergiaa(10);
        assertFalse("Gladiaattorin on vielä elossa!", taistelija.isElossa());
    }

    /**
     *
     */
    @Test
    public void gladiaattoriEiLiikuJosRuutuKaytossa() {
        ruutu2.setKaytossa(true);
        taistelija.liiku(ruutu2);
        assertEquals(ruutu, taistelija.getRuutu());

    }

    /**
     *
     */
    @Test
    public void gladiaattoriLiikkuuJosRuutuEiOleKaytossa() {
        ruutu.asetaGladiaattori(taistelija);
        taistelija.liiku(ruutu2);
        assertEquals(ruutu2, taistelija.getRuutu());
    }
    
    /**
     *
     */
    @Test
    public void gladiaattoriEiLiikuJosKaatunut(){
        taistelija.vahennaEnergiaa(taistelija.getEnergia());
        Ruutu vanhaRuutu = taistelija.getRuutu();
        taistelija.liiku(new Ruutu(4,4));
        assertEquals("Taistelija liikkui!",vanhaRuutu,taistelija.getRuutu());
    }
    
    /**
     *
     */
    @Test
    public void gladiaattoriLiikkuuYliJosVastustajaKaatunut(){
        Gladiaattori vastustaja = new Gladiaattori("Teppo",0);
        Ruutu vastustajanRuutu = new Ruutu(3,4);
        vastustajanRuutu.asetaGladiaattori(vastustaja);
        vastustaja.vahennaEnergiaa(vastustaja.getEnergia());
        taistelija.liiku(vastustajanRuutu);
        assertEquals(vastustajanRuutu,taistelija.getRuutu());
    }
}
