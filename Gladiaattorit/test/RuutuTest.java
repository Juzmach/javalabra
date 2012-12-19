
import gladiaattorit.logiikka.Areena;
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
 * @author juzmach
 */
public class RuutuTest {

    private Ruutu ruutu;

    public RuutuTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.ruutu = new Ruutu(3, 4);
    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void asetaGladiaattoriEiAsetaGladiaattoriaJosRuutuOnKaytossa(){
        Gladiaattori teppo = new Gladiaattori("Teppo");
        Gladiaattori taavi = new Gladiaattori("Taavi");
        
        ruutu.asetaGladiaattori(teppo);
        ruutu.asetaGladiaattori(taavi);
        
        assertEquals(teppo,ruutu.getGladiaattori());
    }
}
