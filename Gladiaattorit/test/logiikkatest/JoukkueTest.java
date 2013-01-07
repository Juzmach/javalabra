package logiikkatest;


import gladiaattorit.logiikka.Gladiaattori;
import gladiaattorit.logiikka.Joukkue;
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
public class JoukkueTest {

    public Joukkue joukkue;

    public JoukkueTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        joukkue = new Joukkue("Tepon Testaajat");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void joukkueellaOnNimiJokaEiOleTyhja() {
        assertFalse("Joukkueen nimi on tyhjä!", joukkue.getNimi().isEmpty());
    }

    @Test
    public void josJoukkueeseenLisaaYhdenGladiaattorinJoukkueessaOnYksiJasen() {
        joukkue.lisaaGladiaattori(new Gladiaattori("Taavi", 0));
        assertEquals(1, joukkue.getJoukkueenKoko());
    }

    @Test
    public void JosGladiaattoriLoytyyJoukkueestaHaeGladiaattoriEiPalautaNull() {
        joukkue.lisaaGladiaattori(new Gladiaattori("Taavi", 0));
        assertNotNull(joukkue.haeGladiaattori("Taavi"));
    }

    @Test
    public void josGladiaattoriaEiLoydyJoukkueestaHaeGladiaattoriPalauttaaNull() {
        joukkue.lisaaGladiaattori(new Gladiaattori("Taavi", 0));
        assertNull(joukkue.haeGladiaattori("Timo"));
    }

    @Test
    public void joukkueenKokoOnNollaJosEiYhtaanGladiaattoriaLisatty() {
        assertEquals(0, joukkue.getJoukkueenKoko());
    }
//    @Test
//    public void haeGladiaattoriMetodiHakeeOikeanGladiaattorinPelinumerolla(){
//        
//    }
}
