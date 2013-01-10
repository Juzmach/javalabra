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

    private String luoKomentolistaanTulevaTeksti() {
        return "KOMENNOT\nLIIKU GLADIAATTORIN_NIMI SUUNTA\nSUUNNAT\n";
    }

    private String lisaaGladiaattorienNimetInfoPaneeliin() {
        return "\n" + taistelupeli.getKoti() + "\n" + taistelupeli.getVieras();
    }

    @Override
    public void paivita() {
        this.komentoLista.setText(luoKomentolistaanTulevaTeksti() + lisaaGladiaattorienNimetInfoPaneeliin());
    }
}
