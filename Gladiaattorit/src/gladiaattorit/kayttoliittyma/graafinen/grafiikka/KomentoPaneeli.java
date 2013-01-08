/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gladiaattorit.kayttoliittyma.graafinen.grafiikka;

import gladiaattorit.kayttoliittyma.graafinen.kuuntelijat.KomentoPaneelinKuuntelija;
import gladiaattorit.logiikka.Taistelupeli;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author juusostr
 */
public class KomentoPaneeli extends JPanel implements Paivitettava {

    private Taistelupeli taistelupeli;
    private JTextArea komentoruutu;
    private JTextField komentorivi;
    private JButton suoritaNappi;
    private AreenaPaneeli areenapaneeli;

    public KomentoPaneeli(Taistelupeli taistelupeli, AreenaPaneeli areenapaneeli) {
        super.setLayout(new BorderLayout());
        super.setSize(200, 100);
        this.taistelupeli = taistelupeli;
        this.areenapaneeli = areenapaneeli;
        this.luoKomponentit();
    }

    private void luoKomponentit() {
        luoKomentoruutu();
        luoKomentorivi();
        luoSuoritaNappi();
    }

    private void luoSuoritaNappi() {
        suoritaNappi = new JButton("Suorita");
        suoritaNappi.addActionListener(new KomentoPaneelinKuuntelija(this, areenapaneeli, taistelupeli));
        add(suoritaNappi, BorderLayout.EAST);
    }

    private void luoKomentorivi() {
        komentorivi = new JTextField();
        komentorivi.setPreferredSize(new Dimension(200, 20));
        add(komentorivi);
    }

    private void luoKomentoruutu() {
        komentoruutu = new JTextArea();
        komentoruutu.setPreferredSize(new Dimension(200, 73));
        komentoruutu.setEditable(false);
        komentoruutu.setBackground(Color.WHITE);
        add(komentoruutu, BorderLayout.NORTH);
    }

    public JTextField getKomentorivi() {
        return komentorivi;
    }

    public JTextArea getKomentoruutu() {
        return komentoruutu;
    }

    public JButton getSuoritaNappi() {
        return suoritaNappi;
    }

    @Override
    public void paivita() {
        repaint();
    }
}
