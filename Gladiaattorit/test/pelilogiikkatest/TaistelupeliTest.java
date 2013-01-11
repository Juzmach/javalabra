package pelilogiikkatest;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import gladiaattorit.pelilogiikka.Gladiaattori;
import gladiaattorit.pelilogiikka.Joukkue;
import gladiaattorit.pelilogiikka.Pelaaja;
import gladiaattorit.pelilogiikka.Ruutu;
import gladiaattorit.pelilogiikka.Suunta;
import gladiaattorit.pelilogiikka.Taistelupeli;
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
public class TaistelupeliTest {

    private Taistelupeli taistelu;

    /**
     *
     */
    public TaistelupeliTest() {
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
        taistelu = new Taistelupeli(new Pelaaja("koti","kotijoukkue",8),new Pelaaja("vieras","vierasjoukkue",8));
        taistelu.asetaJoukkueetAreenalle();
        
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
    public void liikutaGladiaattoriaMetodiLiikuttaaKotijoukkueenGladiaattoria() {
        taistelu.setKenenVuoro("Koti");
        Ruutu vanhaRuutu = taistelu.getKoti().getJoukkue().haeGladiaattori(1).getRuutu();
        taistelu.liikuta(taistelu.getVuorossaOlevaJoukkue().haeGladiaattori(1), Suunta.KOTIETEEN);
        assertNotSame(vanhaRuutu, taistelu.getKoti().getJoukkue().haeGladiaattori(1).getRuutu());
    }

    /**
     *
     */
    @Test
    public void vuoroVaihtuuKunGladiaattoriLiikkuu() {
        taistelu.liikuta(taistelu.getKoti().getJoukkue().haeGladiaattori(1), Suunta.KOTIETEEN);
        assertEquals("Vieras", taistelu.getKenenVuoro());
    }
    
    /**
     *
     */
    @Test
    public void onkoPeliPaattynytPalauttaaTrueKunKotijoukkueKuollut(){
        for (Gladiaattori gladiaattori : taistelu.getKoti().getJoukkue().getGladiaattorit()) {
            gladiaattori.vahennaEnergiaa(gladiaattori.getEnergia());
        }
        assertTrue("onkoPeliPaattynyt() pitäisi palauttaa true!",taistelu.onkoPeliPaattynyt());
    }

    /**
     *
     */
    @Test
    public void getVoittajaJoukkuePalauttaaOikeanJoukkueenKunKotiVoittaa() {
        for (Gladiaattori gladiaattori : taistelu.getVieras().getJoukkue().getGladiaattorit()) {
            gladiaattori.vahennaEnergiaa(gladiaattori.getEnergia());
        }
        assertEquals(taistelu.getKoti().getJoukkue().getNimi(),taistelu.getVoittajaJoukkue().getNimi());
    }
    
    @Test
    public void onkoPeliPaattynytPalauttaaTrueJosVierasJoukkueKuollut(){
        tapaJoukkue(taistelu.getVieras().getJoukkue());
        assertTrue("Peli ei päättynyt!",taistelu.onkoPeliPaattynyt());
    }
    
    private void tapaJoukkue(Joukkue joukkue){
        for (Gladiaattori gladiaattori : joukkue.getGladiaattorit()) {
            gladiaattori.vahennaEnergiaa(gladiaattori.getEnergia());
        }
    }
    
    @Test
    public void onkoPeliPaattynytPalauttaaTrueJosKotiJoukkueKuollut(){
        tapaJoukkue(taistelu.getKoti().getJoukkue());
        assertTrue("Peli ei päättynyt",taistelu.onkoPeliPaattynyt());
    }
}
