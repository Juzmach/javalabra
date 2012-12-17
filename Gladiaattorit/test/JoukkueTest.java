/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void joukkueellaOnNimiJokaEiOleTyhja(){
        assertFalse("Joukkueen nimi on tyhjä!", joukkue.getNimi().isEmpty());
    }
    
    @Test
    public void josJoukkueeseenLisaaYhdenGladiaattorinJoukkueessaOnYksiJasen(){
        joukkue.lisaaGladiaattori(new Gladiaattori("Taavi"));
        assertEquals(1,joukkue.getJoukkueenKoko());
    }
    
    @Test
    public void JosGladiaattoriLoytyyJoukkueestaHaeGladiaattoriEiPalautaNull(){
        joukkue.lisaaGladiaattori(new Gladiaattori("Taavi"));
        assertNotNull(joukkue.haeGladiaattori("Taavi"));
    }
    
    @Test
    public void josGladiaattoriaEiLoydyJoukkueestaHaeGladiaattoriPalauttaaNul(){
        joukkue.lisaaGladiaattori(new Gladiaattori("Taavi"));
        assertNull(joukkue.haeGladiaattori("Timo"));
    }
    
    @Test
    public void joukkueenKokoOnNollaJosEiYhtaanGladiaattoriaLisatty(){
        assertEquals(0,joukkue.getJoukkueenKoko());
    }
    
}
