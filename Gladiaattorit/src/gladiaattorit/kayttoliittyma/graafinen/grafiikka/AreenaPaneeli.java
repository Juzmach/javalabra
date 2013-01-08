/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gladiaattorit.kayttoliittyma.graafinen.grafiikka;

import gladiaattorit.logiikka.Ruutu;
import gladiaattorit.logiikka.Taistelupeli;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
;
import javax.swing.JPanel;
import javax.swing.JPanel;

/**
 *
 * @author juusostr
 */


public class AreenaPaneeli extends JPanel implements Paivitettava{
    
    private Ruutu[][] areena;

    public AreenaPaneeli(Taistelupeli taistelupeli) {
        this.areena = taistelupeli.getAreena().getAreena();
        super.setBackground(Color.WHITE);
        super.setSize(new Dimension(400,400));
    }
    
    @Override
    public void paivita(){
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.piirraAreenanRajat(g);
        this.piirraGladiaattorit(g);

    }

    private void piirraAreenanRajat(Graphics g) {
        g.setColor(Color.BLACK);
        for (int y = 0; y < areena.length; y++) {
            for (int x = 0; x < areena[y].length; x++) {
                g.drawRect(x * 50, y * 50, 50, 50);
            }
        }
    }
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
