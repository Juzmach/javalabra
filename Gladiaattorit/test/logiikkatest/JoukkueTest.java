package logiikkatest;


import gladiaattorit.logiikka.Gladiaattori;
import gladiaattorit.logiikka.Joukkue;
import gladiaattorit.logiikka.Ruutu;
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

    /**
     *
     */
    public Joukkue joukkue;

    /**
     *
     */
    public JoukkueTest() {
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
        joukkue = new Joukkue("Tepon Testaajat");
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
    public void joukkueellaOnNimiJokaEiOleTyhja() {
        assertFalse("Joukkueen nimi on tyhjä!", joukkue.getNimi().isEmpty());
    }

    /**
     *
     */
    @Test
    public void josJoukkueeseenLisaaYhdenGladiaattorinJoukkueessaOnYksiJasen() {
        joukkue.lisaaGladiaattori(new Gladiaattori("Taavi", 0));
        assertEquals(1, joukkue.getJoukkueenKoko());
    }

    /**
     *
     */
    @Test
    public void JosGladiaattoriLoytyyJoukkueestaHaeGladiaattoriEiPalautaNull() {
        joukkue.lisaaGladiaattori(new Gladiaattori("Taavi", 0));
        assertNotNull(joukkue.haeGladiaattori("Taavi"));
    }

    /**
     *
     */
    @Test
    public void josGladiaattoriaEiLoydyJoukkueestaHaeGladiaattoriPalauttaaNull() {
        joukkue.lisaaGladiaattori(new Gladiaattori("Taavi", 0));
        assertNull(joukkue.haeGladiaattori("Timo"));
    }

    /**
     *
     */
    @Test
    public void joukkueenKokoOnNollaJosEiYhtaanGladiaattoriaLisatty() {
        assertEquals(0, joukkue.getJoukkueenKoko());
    }
    
    private void luoHalutunKokoinenJoukkue(int koko){
        for (int i = 0; i < koko; i++) {
            Gladiaattori lisattava = new Gladiaattori("Testi",i);
            lisattava.asetaRuutu(new Ruutu(i,i));
            joukkue.lisaaGladiaattori(lisattava);
        }
    }
    
    @Test
    public void onkoJoukkueElossaMetodiPalauttaaTrueJosKaikkiOvatKuolleet(){
        this.luoHalutunKokoinenJoukkue(8);
        for (Gladiaattori gladiaattori : joukkue.getGladiaattorit()) {
            gladiaattori.vahennaEnergiaa(gladiaattori.getEnergia());
        }
        assertTrue("onkoJoukkueElossa()-metodin pitäisi palauttaa true!",joukkue.onkoJoukkueKuollut());
    }
    
//    @Test
//    public void haeGladiaattoriMetodiHakeeOikeanGladiaattorinPelinumerolla(){
//        
//    }
}
