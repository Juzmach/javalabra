package pelilogiikkatest;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import gladiaattorit.pelilogiikka.Areena;
import gladiaattorit.pelilogiikka.Gladiaattori;
import gladiaattorit.pelilogiikka.Pelaaja;
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
public class PelaajaTest {

    private Pelaaja koti;
    private Pelaaja vieras;
    private Areena areena;

    /**
     *
     */
    public PelaajaTest() {
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
        koti = new Pelaaja("Pelaaja", "pelaajanJoukkue");
        vieras = new Pelaaja("Vastustaja", "vastustajanJoukkue");
        areena = new Areena(koti.getJoukkue(), vieras.getJoukkue());
    }

    /**
     *
     */
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    /**
     *
     */
    @Test
    public void josGladiaattorinEdessaOnToinenGladiaattoriSeIskeeLiikkumisenSijaan() {
        int vastustajanEnergiaAlussa = vieras.getJoukkue().haeGladiaattori(1).getEnergia();
        koti.liikuta(koti.getJoukkue().haeGladiaattori(1), areena.getAreena()[3][3]);
        vieras.liikuta(vieras.getJoukkue().haeGladiaattori(1), areena.getAreena()[3][4]);
        koti.liikuta(koti.getJoukkue().haeGladiaattori(1), vieras.getJoukkue().haeGladiaattori(1).getRuutu());
        
        assertFalse("Taistelija ei iskenyt!", (vieras.getJoukkue().haeGladiaattori(1).getEnergia() == vastustajanEnergiaAlussa));
    }

    /**
     *
     */
    @Test
    public void gladiaattoriEiIskeOmaaJoukkuekaveriaan() {
        int joukkuekaverinEnergiaAlussa = koti.getJoukkue().haeGladiaattori(1).getEnergia();
        koti.liikuta(koti.getJoukkue().haeGladiaattori(1), koti.getJoukkue().haeGladiaattori(2).getRuutu());
        assertEquals(joukkuekaverinEnergiaAlussa, koti.getJoukkue().haeGladiaattori(1).getEnergia());
    }
}
