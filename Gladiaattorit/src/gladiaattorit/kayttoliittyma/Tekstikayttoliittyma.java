package gladiaattorit.kayttoliittyma;

import gladiaattorit.logiikka.Areena;
import gladiaattorit.logiikka.Gladiaattori;
import gladiaattorit.logiikka.Joukkue;
import gladiaattorit.logiikka.Pelaaja;
import gladiaattorit.logiikka.Taistelutoiminta;
import java.util.Scanner;

/**
 *
 * @author juzmach
 */
public class Tekstikayttoliittyma {

    private Taistelutoiminta taistelu;
    private Scanner lukija;
    private Pelaaja pelaaja;
    private Pelaaja vastustaja;

    public Tekstikayttoliittyma(Scanner lukija) {
        this.lukija = lukija;
        this.luoPelaajat();
        this.taistelu = new Taistelutoiminta(pelaaja, vastustaja);
    }

    private void luoPelaajat() {
        System.out.println("Anna nimesi: ");
        String pelaajanNimi = lukija.nextLine();
        System.out.println("Anna joukkueesi nimi: ");
        String pelaajanJoukkueenNimi = lukija.nextLine();
        this.pelaaja = new Pelaaja(pelaajanNimi, pelaajanJoukkueenNimi);
        this.vastustaja = new Pelaaja("Hodor", "Hodorin Hurjat");
    }

    public void kaynnista() {
        this.tulostaKomennot();

        while (true) {
            String komento = lukija.nextLine();
            if (komento.toUpperCase().equals("X")) {
                break;
            }
            if (komento.toUpperCase().equals("Y")) {
                this.tulostaKomennot();
            }
            if (komento.equals("1")) {
                this.tulostaAreena();
            }
            if (komento.equals("2")) {
                this.tulostaJoukkue();
            }
        }
    }

    private void tulostaKomennot() {
        System.out.println("X - Lopettaa pelin");
        System.out.println("Y - Tulostaa komennot");
        System.out.println("1 - Tulosta areena");
        System.out.println("2 - Tulosta joukkue");
    }

    private void tulostaJoukkue() {
        while (true) {
            System.out.println("Mikä joukkue? (Pelaaja: 1, Vastustaja: 2, Kaikki: X)");
            String vaihtoehto = lukija.nextLine();
            if (vaihtoehto.equals("1")) {
                System.out.println(pelaaja.getJoukkue());
                break;
            } else if (vaihtoehto.equals("2")) {
                System.out.println(vastustaja.getJoukkue());
                break;
            } else if (vaihtoehto.equals("X")) {
                System.out.println(pelaaja.getJoukkue());
                System.out.println(vastustaja.getJoukkue());
                break;
            } else {
                System.out.println("Väärä komento!");
            }
        }
    }

    private void tulostaAreena() {
        for (int y = 0; y < taistelu.getAreena().getAreena().length; y++) {
            for (int x = 0; x < taistelu.getAreena().getAreena()[y].length; x++) {
                if (taistelu.getAreena().getAreena()[y][x].isKaytossa()) {
                    System.out.print("[X]");
                } else {
                    System.out.print("[ ]");
                }
            }
            System.out.println("");
        }
    }
}
