package gladiaattorit;

import gladiaattorit.kayttoliittyma.Tekstikayttoliittyma;
import java.util.Scanner;



/**
 *
 * @author juzmach
 */
public class Main {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        Tekstikayttoliittyma teksti = new Tekstikayttoliittyma(lukija);
        teksti.kaynnista();
        
    }
}
