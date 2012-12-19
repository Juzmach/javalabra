/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import gladiaattorit.logiikka.Areena;
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
 * @author juzmach
 */
public class AreenaTest {

    public Areena areena;

    public AreenaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        areena = new Areena(new Joukkue("Tepon Testaajat"), new Joukkue("Taavin Tallaajat"));
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
    public void areenaOikeanKokoinen() {
        int koko = 0;
        int oikeaKoko = 56;
        Ruutu[][] ruudut = areena.getAreena();
        for (int i = 0; i < ruudut.length; i++) {
            for (int j = 0; j < ruudut[i].length; j++) {
                koko++;
            }
        }
        assertEquals(oikeaKoko, koko);
    }
    
   
}
