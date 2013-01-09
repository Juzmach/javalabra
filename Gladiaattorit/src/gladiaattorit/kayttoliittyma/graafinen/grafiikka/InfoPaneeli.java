
package gladiaattorit.kayttoliittyma.graafinen.grafiikka;

import gladiaattorit.pelilogiikka.Taistelupeli;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author juzmach
 */
public class InfoPaneeli extends JPanel{
    /**
     * Taistelupeli-olio
     */
    private Taistelupeli taistelupeli;

    /**
     * 
     * @param taistelupeli Taistelupeli-olio
     */
    public InfoPaneeli(Taistelupeli taistelupeli) {
        super.setLayout(new BorderLayout());
        super.setPreferredSize(new Dimension(200,100));
        this.taistelupeli = taistelupeli;
    }
    
    /**
     * Luo infopaneelin komponentit. EI VIELÄ IMPLEMENTOITU!
     */
    private void luoKomponentit(){
        
    }
    
    
}
