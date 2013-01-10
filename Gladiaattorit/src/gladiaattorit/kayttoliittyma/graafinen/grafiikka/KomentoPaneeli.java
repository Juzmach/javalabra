/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gladiaattorit.kayttoliittyma.graafinen.grafiikka;

import gladiaattorit.kayttoliittyma.graafinen.logiikka.KomentoPaneeliLogiikka;
import gladiaattorit.kayttoliittyma.graafinen.logiikka.KomentoPaneelinKuuntelija;
import gladiaattorit.pelilogiikka.Taistelupeli;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author juusostr
 */
public class KomentoPaneeli extends JPanel implements Paivitettava {

    /**
     * Taistelupeli-olio
     */
    private Taistelupeli taistelupeli;
    /**
     * JTextArea-olio, johon tulee suoritetut komennot.
     */
    private JTextArea komentoruutu;
    /**
     * JTextField-olio, johon käyttäjä kirjoittaa komennot.
     */
    private JTextField komentorivi;
    /**
     * JScrollPane-olio, joka säilyttää vanhojen komentojen JTextArea-oliota
     * rullattavassa muodossa.
     */
    private JScrollPane rullattavaKomentoruutu;
    /**
     * JButton-olio, joka kuvaa suoritusnappia.
     */
    private JButton suoritaNappi;
    /**
     * AreenaPaneeli-olio, joka kuvaa peliareenaa.
     */
    private AreenaPaneeli areenapaneeli;
    private InfoPaneeli infopaneeli;
    private KomentoPaneeliLogiikka komentologiikka;
    private KomentoPaneelinKuuntelija komentokuuntelija;

    /**
     * Asettaa KomentoPaneelin LayoutManageriksi BorderLayoutin, asettaa kooksi
     * 200x100px ja luo komponentit luoKomponentit()-metodilla.
     *
     * @param taistelupeli Taistelupeli-olio
     * @param areenapaneeli AreenaPaneeli-olio
     * @param infopaneeli InfoPaneeli-olio
     */
    public KomentoPaneeli(Taistelupeli taistelupeli, AreenaPaneeli areenapaneeli, InfoPaneeli infopaneeli) {
        super.setLayout(new BorderLayout());
        super.setSize(200, 100);
        this.taistelupeli = taistelupeli;
        this.areenapaneeli = areenapaneeli;
        this.infopaneeli = infopaneeli;
        this.komentologiikka = new KomentoPaneeliLogiikka(taistelupeli);
        this.komentokuuntelija = new KomentoPaneelinKuuntelija(komentologiikka, this, areenapaneeli, infopaneeli);
        this.luoKomponentit();
    }

    /**
     * luo KomentoPaneelin komponentit.
     */
    private void luoKomponentit() {
        luoKomentoruutu();
        luoKomentorivi();
        luoSuoritaNappi();
    }

    /**
     * Luo Suoritusnapin.
     */
    private void luoSuoritaNappi() {
        suoritaNappi = new JButton("Suorita");
        suoritaNappi.addActionListener(komentokuuntelija);
        add(suoritaNappi, BorderLayout.EAST);
    }

    /**
     * Luo komentorivin.
     */
    private void luoKomentorivi() {
        komentorivi = new JTextField();
        komentorivi.setPreferredSize(new Dimension(200, 20));
        komentorivi.addKeyListener(komentokuuntelija);
        add(komentorivi);
    }

    /**
     * Luo komentoruudun.
     */
    private void luoKomentoruutu() {

        komentoruutu = new JTextArea("Peli alkaa!\n" + "Vuorossa: " + taistelupeli.getKenenVuoro());
        komentoruutu.setEditable(false);
        komentoruutu.setBackground(Color.WHITE);
        rullattavaKomentoruutu = new JScrollPane(komentoruutu, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        rullattavaKomentoruutu.setPreferredSize(new Dimension(200, 125));
        rullattavaKomentoruutu.setBackground(Color.WHITE);
        add(rullattavaKomentoruutu, BorderLayout.NORTH);
    }

    /**
     *
     * @return JTextField-olio, joka kuvaa komentoriviä
     */
    public JTextField getKomentorivi() {
        return komentorivi;
    }

    /**
     *
     * @return JTextArea-olio, joka kuvaa komentoruutua
     */
    public JTextArea getKomentoruutu() {
        return komentoruutu;
    }

    /**
     *
     * @return JButton-olio, joka kuvaa suoritusnappia
     */
    public JButton getSuoritaNappi() {
        return suoritaNappi;
    }

    /**
     * Päivittää KomentoPaneelin graafisen esityksen.
     */
    @Override
    public void paivita() {
        komentoruutu.append(komentologiikka.haeKomennonTuloste(komentorivi.getText()) + "\nVuorossa: " + taistelupeli.getKenenVuoro());
    }
}
