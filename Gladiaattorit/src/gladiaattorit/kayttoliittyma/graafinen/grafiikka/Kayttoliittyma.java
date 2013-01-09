/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gladiaattorit.kayttoliittyma.graafinen.grafiikka;

import gladiaattorit.pelilogiikka.Taistelupeli;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author juusostr
 */
public class Kayttoliittyma implements Runnable {
    
    /**
     * JFrame-olio, jossa koko käyttöliittymä.
     */
    private JFrame frame;
    /**
     * Taistelupeli-olio, joka pyörittää pelilogiikkaa.
     */
    private Taistelupeli taistelupeli;
    /**
     * AreenaPaneeli-olio, joka kuvaa peliareenan tilannetta.
     */
    private AreenaPaneeli areenapaneeli;
    /**
     * Komentopaneeli-olio, joka kuvaa komentoriviä.
     */
    private KomentoPaneeli komentopaneeli;
    
    /**
     * Luo Taistelupeli-olion käyttäen "Koti","Kotijoukkue","Vieras","Vierasjoukkue" -parametrejä.
     */
    public Kayttoliittyma() {
        this.taistelupeli = new Taistelupeli("Koti", "Kotijoukkue", "Vieras", "Vierasjoukkue");
    }
    
    /**
     * Käynnistää käyttöliittymän suorituksen.
     */
    @Override
    public void run() {
        frame = new JFrame("Gladiaattorit");
        Dimension size = new Dimension(600, 600);
        frame.setPreferredSize(size);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    /**
     * Luo käyttöliittymän komponentit.
     * @param container JFramen ContentPane-olio
     */
    private void luoKomponentit(Container container) {
        container.setBackground(Color.WHITE);
        container.setLayout(new BorderLayout());
        luoPaneelit();
        container.add(areenapaneeli);
        container.add(komentopaneeli, BorderLayout.SOUTH);
    }
    
    /**
     * Alustaa AreenaPaneelin ja KomentoPaneelin.
     */
    private void luoPaneelit(){
        areenapaneeli = new AreenaPaneeli(taistelupeli);
        komentopaneeli = new KomentoPaneeli(taistelupeli,areenapaneeli);
    }
    
    /**
     *
     * @return Käyttöliittymän JFrame-olio
     */
    public JFrame getFrame() {
        return frame;
    }
}
