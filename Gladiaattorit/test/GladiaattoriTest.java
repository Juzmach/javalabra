/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import gladiaattorit.logiikka.Gladiaattori;
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

    public Gladiaattori taistelija;

    public GladiaattoriTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        taistelija = new Gladiaattori("Taavi");
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
    public void gladiaattorinNimiEiOleTyhja() {
        assertFalse("Gladiaattorin nimi on tyhjä!", taistelija.getNimi().isEmpty());
    }

    @Test
    public void vahennaEnergiaaEiVahennaAlleNollan() {
        taistelija.vahennaEnergiaa(11);
        assertEquals(0, taistelija.getEnergia());
    }
    
    @Test
    public void gladiaattoriKaatuuJosEnergiaOnNolla(){
        taistelija.vahennaEnergiaa(10);
        assertFalse("Gladiaattorin on vielä elossa!",taistelija.isElossa());
    }
}
