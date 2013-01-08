/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gladiaattorit.kayttoliittyma.graafinen.grafiikka;

import gladiaattorit.logiikka.Taistelupeli;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author juusostr
 */
public class KomentoPaneeli extends JPanel{
    private Taistelupeli taistelupeli;

    public KomentoPaneeli(Taistelupeli taistelupeli) {
        super.setLayout(new e);
        this.taistelupeli = taistelupeli;
        this.luoKomponentit();
    }
    
    private void luoKomponentit(){
        JTextArea komentolinja = new JTextArea("Komennot");
        komentolinja.setText("Komennot");
        add(komentolinja);
    }
     
}
