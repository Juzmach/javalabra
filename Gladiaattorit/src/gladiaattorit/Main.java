package gladiaattorit;

import gladiaattorit.kayttoliittyma.graafinen.grafiikka.Kayttoliittyma;
import gladiaattorit.kayttoliittyma.tekstikayttoliittyma.Tekstikayttoliittyma;
import java.util.Scanner;
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
//        Scanner lukija = new Scanner(System.in);
//        System.out.println("Teksti vai Graafinen?");
//        String valinta = lukija.nextLine();
//        
//        if(valinta.toUpperCase().equals("TEKSTI")){
//            Tekstikayttoliittyma teksti = new Tekstikayttoliittyma(lukija);
//            teksti.kaynnista();
//        } else if(valinta.toUpperCase().equals("GRAAFINEN")){
            Kayttoliittyma graafinen = new Kayttoliittyma();
            SwingUtilities.invokeLater(graafinen);
//        } else {
//            System.out.println("Väärä valinta! Lopetetaan..");
//        }

    }
}
