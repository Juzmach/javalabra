/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gladiaattorit.kayttoliittyma.graafinen.logiikka;

import gladiaattorit.kayttoliittyma.graafinen.grafiikka.AreenaPaneeli;
import gladiaattorit.kayttoliittyma.graafinen.grafiikka.InfoPaneeli;
import gladiaattorit.kayttoliittyma.graafinen.grafiikka.KomentoPaneeli;
import gladiaattorit.pelilogiikka.Suunta;
import gladiaattorit.pelilogiikka.Taistelupeli;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author juusostr
 */
public class KomentoPaneelinKuuntelija implements ActionListener, KeyListener {

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
    private InfoPaneeli infopaneeli;
    private KomentoPaneeliLogiikka komentologiikka;

    /**
     *
     * @param komentologiikka Käyttöliittymän KomentoPaneeliLogiikka-olio
     * @param komentopaneeli Käyttöliittymän KomentoPaneeli-olio
     * @param areenapaneeli Käyttöliittymän AreenaPaneeli-olio
     * @param infopaneeli  Käyttöliittymän InfoPaneeli-olio
     */
    public KomentoPaneelinKuuntelija(KomentoPaneeliLogiikka komentologiikka, KomentoPaneeli komentopaneeli, AreenaPaneeli areenapaneeli, InfoPaneeli infopaneeli) {
        this.komentopaneeli = komentopaneeli;
        this.areenapaneeli = areenapaneeli;
        this.infopaneeli = infopaneeli;
        this.komentologiikka = komentologiikka;
    }

    /**
     * Suorittaa komennon ja päivittää paneelien graafisen esityksen.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        komentologiikka.komennonSuoritus(komentopaneeli.getKomentorivi().getText());
        paivitaPaneelit();
    }

    /**
     * päivittää AreenaPaneelin ja KomentoPaneelin graafiset esitykset.
     */
    private void paivitaPaneelit() {
        areenapaneeli.paivita();
        infopaneeli.paivita();
        komentopaneeli.paivita();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == e.VK_ENTER) {
            komentologiikka.komennonSuoritus(komentopaneeli.getKomentorivi().getText());
            paivitaPaneelit();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
