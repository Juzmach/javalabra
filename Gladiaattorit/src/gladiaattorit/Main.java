package gladiaattorit;

import gladiaattorit.kayttoliittyma.graafinen.grafiikka.Kayttoliittyma;
import javax.swing.SwingUtilities;

/**
 *
 * @author juzmach
 */
public class Main {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
            Kayttoliittyma graafinen = new Kayttoliittyma();
            SwingUtilities.invokeLater(graafinen);
    }
}
