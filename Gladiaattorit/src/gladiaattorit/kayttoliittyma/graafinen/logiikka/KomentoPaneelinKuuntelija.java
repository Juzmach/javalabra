/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gladiaattorit.kayttoliittyma.graafinen.logiikka;

import gladiaattorit.kayttoliittyma.graafinen.grafiikka.AreenaPaneeli;
import gladiaattorit.kayttoliittyma.graafinen.grafiikka.KomentoPaneeli;
import gladiaattorit.pelilogiikka.Suunta;
import gladiaattorit.pelilogiikka.Taistelupeli;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author juusostr
 */
public class KomentoPaneelinKuuntelija implements ActionListener {

    /**
     * KomentoPaneeli-olio
     */
    private KomentoPaneeli komentopaneeli;
    /**
     * AreenaPaneeli-olio
     */
    private AreenaPaneeli areenapaneeli;
    /**
     * KomentoPaneeliLogiikka-olio
     */
    private KomentoPaneeliLogiikka komentologiikka;
    /**
     * Taistelupeli-olio
     */
    private Taistelupeli taistelupeli;

    /**
     *
     * @param komentopaneeli Käyttöliittymän KomentoPaneeli-olio
     * @param areenapaneeli Käyttöliittymän AreenaPaneeli-olio
     * @param taistelupeli Taistelupeli-olio
     */
    public KomentoPaneelinKuuntelija(KomentoPaneeli komentopaneeli, AreenaPaneeli areenapaneeli, Taistelupeli taistelupeli) {
        this.komentopaneeli = komentopaneeli;
        this.areenapaneeli = areenapaneeli;
        this.taistelupeli = taistelupeli;
        this.komentologiikka = new KomentoPaneeliLogiikka(taistelupeli);
    }

    /**
     * Suorittaa komennon ja päivittää paneelien graafisen esityksen.
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String komento = komentopaneeli.getKomentorivi().getText();
        komentopaneeli.getKomentoruutu().setText(komentologiikka.haeKomennonTuloste(komento));
        komentologiikka.komennonSuoritus(komento);
        paivitaPaneelit();
    }

    /**
     * päivittää AreenaPaneelin ja KomentoPaneelin graafiset esitykset.
     */
    private void paivitaPaneelit() {
        areenapaneeli.paivita();
        komentopaneeli.paivita();
    }
}
