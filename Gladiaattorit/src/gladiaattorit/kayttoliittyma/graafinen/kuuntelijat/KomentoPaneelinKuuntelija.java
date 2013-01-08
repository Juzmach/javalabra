/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gladiaattorit.kayttoliittyma.graafinen.kuuntelijat;

import gladiaattorit.kayttoliittyma.graafinen.grafiikka.AreenaPaneeli;
import gladiaattorit.kayttoliittyma.graafinen.grafiikka.KomentoPaneeli;
import gladiaattorit.logiikka.Taistelupeli;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author juusostr
 */
public class KomentoPaneelinKuuntelija implements ActionListener {

    private KomentoPaneeli komentopaneeli;
    private AreenaPaneeli areenapaneeli;
    private Taistelupeli taistelupeli;

    public KomentoPaneelinKuuntelija(KomentoPaneeli komentopaneeli, AreenaPaneeli areenapaneeli, Taistelupeli taistelupeli) {
        this.komentopaneeli = komentopaneeli;
        this.areenapaneeli = areenapaneeli;
        this.taistelupeli = taistelupeli;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

}
