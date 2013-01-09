/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gladiaattorit.kayttoliittyma.graafinen.grafiikka;

import gladiaattorit.pelilogiikka.Ruutu;
import gladiaattorit.pelilogiikka.Taistelupeli;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author juusostr
 */


public class AreenaPaneeli extends JPanel implements Paivitettava{
    
    /**
     * Peliareenaa kuvaava kaksiulotteinen taulukko
     */
    private Ruutu[][] areena;

    /**
     *
     * @param taistelupeli Taistelupeli-olio
     */
    public AreenaPaneeli(Taistelupeli taistelupeli) {
        this.areena = taistelupeli.getAreena().getAreena();
        super.setBackground(Color.WHITE);
        super.setSize(new Dimension(400,400));
    }
    
    /**
     * Päivittää paneelin graafisen esityksen.
     */
    @Override
    public void paivita(){
        repaint();
    }

    /**
     * Piirtää areenan rajat sekä gladiaattorit paneeliin.
     * @param g Graphics-olio 
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.piirraAreenanRajat(g);
        this.piirraGladiaattorit(g);
    }

    /**
     * Piirtää areenan rajat.
     * @param g Graphics-olio
     */
    private void piirraAreenanRajat(Graphics g) {
        g.setColor(Color.BLACK);
        for (int y = 0; y < areena.length; y++) {
            for (int x = 0; x < areena[y].length; x++) {
                g.drawRect(x * 50, y * 50, 50, 50);
            }
        }
    }
    
    /**
     * Piirtää gladiaattorit areenan ruutuihin.
     * @param g Graphics-olio
     */
    private void piirraGladiaattorit(Graphics g){
        g.setColor(Color.BLACK);
        for (int y = 0; y < areena.length; y++) {
            for (int x = 0; x < areena[y].length; x++) {
                if(areena[y][x].isKaytossa()){
                    g.fillRect(50*x, 50*y, 10, 10);
                }
            }
        }
    }
}
