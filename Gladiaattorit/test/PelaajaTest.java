/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import gladiaattorit.logiikka.Gladiaattori;
import gladiaattorit.logiikka.Pelaaja;
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
public class PelaajaTest {
    private Pelaaja pelaaja;
    
    public PelaajaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pelaaja = new Pelaaja("Pelaaja","pelaajanJoukkue");
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
    public void josGladiaattorinEdessaOnToinenGladiaattoriSeIskeeLiikkumisenSijaan(){
        Gladiaattori taistelija = new Gladiaattori("Taavi",1);
        Gladiaattori vastustaja = new Gladiaattori("Teppo",2);
        Ruutu taistelijanRuutu = new Ruutu(3,3);
        Ruutu vastustajanRuutu = new Ruutu(3,4);
        taistelijanRuutu.asetaGladiaattori(taistelija);
        vastustajanRuutu.asetaGladiaattori(vastustaja);
        int vastustajanEnergiaAlussa = vastustaja.getEnergia();
        
        pelaaja.liikuta(taistelija, vastustajanRuutu);
        
        assertFalse("Taistelija ei iskenyt!",(vastustaja.getEnergia() == vastustajanEnergiaAlussa));
    }
}
