package pelilogiikkatest;


import gladiaattorit.pelilogiikka.Areena;
import gladiaattorit.pelilogiikka.Gladiaattori;
import gladiaattorit.pelilogiikka.Joukkue;
import gladiaattorit.pelilogiikka.Ruutu;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author juzmach
 */
public class AreenaTest {

    /**
     *
     */
    public Areena areena;

    /**
     *
     */
    public AreenaTest() {
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
        Joukkue teppo = new Joukkue("Tepon Testaajat");
        Joukkue taavi = new Joukkue("Taavin Tallaajat");

        for (int i = 0; i < 8; i++) {
            teppo.lisaaGladiaattori(new Gladiaattori("", i));
            taavi.lisaaGladiaattori(new Gladiaattori("", i));
        }

        areena = new Areena(teppo, taavi);
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
    public void areenaOikeanKokoinen() {
        int koko = 0;
        int oikeaKoko = 64;
        Ruutu[][] ruudut = areena.getAreena();
        for (int i = 0; i < ruudut.length; i++) {
            for (int j = 0; j < ruudut[i].length; j++) {
                koko++;
            }
        }
        assertEquals(oikeaKoko, koko);
    }

    /**
     *
     */
    @Test
    public void areenallaOnRuutujaJotkaEivätOleNull() {
        assertNotNull(areena.getAreena()[3][3]);
    }

    /**
     *
     */
    @Test
    public void metodiAsetaJoukkueetAsettaaKotijoukkueenAreenalle() {
        assertNotNull(areena.getAreena()[6][3].getGladiaattori());
    }

    /**
     *
     */
    @Test
    public void metodiAsetaJoukkueetAsettaaVierasjoukkueenAreenalle() {
        assertNotNull(areena.getAreena()[0][3].getGladiaattori());
    }
}
