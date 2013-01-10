package gladiaattorit.kayttoliittyma.graafinen.grafiikka;

import gladiaattorit.pelilogiikka.Taistelupeli;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author juzmach
 */
public class InfoPaneeli extends JPanel implements Paivitettava {

    /**
     * Taistelupeli-olio
     */
    private Taistelupeli taistelupeli;
    private JTextArea komentoLista;

    /**
     *
     * @param taistelupeli Taistelupeli-olio
     */
    public InfoPaneeli(Taistelupeli taistelupeli) {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(240, 100));
        this.taistelupeli = taistelupeli;
        luoKomponentit();
    }

    /**
     * Luo infopaneelin komponentit.
     */
    private void luoKomponentit() {
        this.komentoLista = new JTextArea();
        komentoLista.setEditable(false);
        add(komentoLista);
        paivita();
    }

    /**
     * Luo tekstin ja voittajajoukkueen nimen, jotka tulostuvat infopaneeliin, kun peli päättyy.
     * @return 
     */
    private String luoVoittoTeksti() {
        if(taistelupeli.isKotijoukkueLuotu() && taistelupeli.isVierasjoukkueLuotu() && taistelupeli.onkoPeliPaattynyt()){
            return "\nPeli päättynyt!\nVoittaja: " + taistelupeli.getVoittajaJoukkue().getNimi();
        } else {
            return "";
        }
    }

    private String lisaaGladiaattorienNimetInfoPaneeliin() {
        if (taistelupeli.isPeliAlkanut()) {
            return "\n" + taistelupeli.getKoti() + "\n" + taistelupeli.getVieras();
        } else {
            return "";
        }
    }

    @Override
    public void paivita() {
        this.komentoLista.setText(lisaaGladiaattorienNimetInfoPaneeliin() + luoVoittoTeksti());
    }
}
