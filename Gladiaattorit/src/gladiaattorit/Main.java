package gladiaattorit;

import gladiaattorit.logiikka.Gladiaattori;
import gladiaattorit.logiikka.Joukkue;
import java.util.Scanner;

/**
 *
 * @author juzmach
 */
public class Main {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        System.out.println("Anna joukkueellesi nimi:");
        String joukkueenNimi = lukija.nextLine();
        Joukkue joukkue = new Joukkue(joukkueenNimi);
        
        System.out.println("Monta gladiaattoria haluat?");
        int maara = Integer.parseInt(lukija.nextLine());
        
        for (int i = 0; i < maara; i++) {
            System.out.println("Anna gladiaattorin nimi:");
            String gladiaattorinNimi = lukija.nextLine();
            joukkue.lisaaGladiaattori(new Gladiaattori(gladiaattorinNimi));
        }
        
        System.out.println(joukkue.toString());
    }
}
