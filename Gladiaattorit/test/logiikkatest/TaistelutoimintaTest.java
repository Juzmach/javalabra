package logiikkatest;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import gladiaattorit.logiikka.Ruutu;
import gladiaattorit.logiikka.Suunta;
import gladiaattorit.logiikka.Taistelutoiminta;
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
public class TaistelutoimintaTest {

    private Taistelutoiminta taistelu;

    /**
     *
     */
    public TaistelutoimintaTest() {
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
        taistelu = new Taistelutoiminta("koti", "kotijoukkue", "vieras", "vierasjoukkue");
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
    public void liikutaGladiaattoriaMetodiLiikuttaaKotijoukkueenGladiaattoria(){
        taistelu.setKenenVuoro("Koti");
        Ruutu vanhaRuutu = taistelu.getKoti().getJoukkue().haeGladiaattori(1).getRuutu();
        taistelu.liikuta(taistelu.getVuorossaOlevaJoukkue().haeGladiaattori(1), Suunta.KOTIETEEN);
        assertNotSame(vanhaRuutu,taistelu.getKoti().getJoukkue().haeGladiaattori(1).getRuutu());
    }
    
    /**
     *
     */
    @Test
    public void vuoroVaihtuuKunGladiaattoriLiikkuu(){
        taistelu.liikuta(taistelu.getKoti().getJoukkue().haeGladiaattori(1), Suunta.KOTIETEEN);
        assertEquals("Vieras",taistelu.getKenenVuoro());
    }
}
