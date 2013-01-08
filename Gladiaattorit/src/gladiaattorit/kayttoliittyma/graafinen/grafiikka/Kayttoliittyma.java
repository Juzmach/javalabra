/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gladiaattorit.kayttoliittyma.graafinen.grafiikka;

import gladiaattorit.logiikka.Taistelupeli;
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
    
    private JFrame frame;
    private Taistelupeli taistelupeli;
    private AreenaPaneeli areenapaneeli;
    private KomentoPaneeli komentopaneeli;
    
    public Kayttoliittyma() {
        this.taistelupeli = new Taistelupeli("Koti", "Kotijoukkue", "Vieras", "Vierasjoukkue");
    }
    
    @Override
    public void run() {
        frame = new JFrame("Gladiaattorit");
        Dimension size = new Dimension(600, 500);
        frame.setPreferredSize(size);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    private void luoKomponentit(Container container) {
        container.setBackground(Color.WHITE);
        container.setLayout(new BorderLayout());
        luoPaneelit();
        container.add(areenapaneeli);
        container.add(komentopaneeli, BorderLayout.SOUTH);
    }
    
    private void luoPaneelit(){
        areenapaneeli = new AreenaPaneeli(taistelupeli);
        komentopaneeli = new KomentoPaneeli(taistelupeli,areenapaneeli);
    }
    
    public JFrame getFrame() {
        return frame;
    }
}
