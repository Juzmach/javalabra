package gladiaattorit.kayttoliittyma;

import gladiaattorit.logiikka.Areena;
import gladiaattorit.logiikka.Gladiaattori;
import gladiaattorit.logiikka.Joukkue;
import gladiaattorit.logiikka.Pelaaja;
import gladiaattorit.logiikka.Suunta;
import gladiaattorit.logiikka.Taistelutoiminta;
import java.util.Scanner;

/**
 *
 * @author juzmach
 */
public class Tekstikayttoliittyma {

    private Taistelutoiminta taistelu;
    private Scanner lukija;

    /**
     *
     * @param lukija
     */
    public Tekstikayttoliittyma(Scanner lukija) {
        this.lukija = lukija;
        this.alustus();
    }

    private void alustus() {
        System.out.println("- Koti -");
        System.out.println("Anna nimesi: ");
        String kotiNimi = lukija.nextLine();
        System.out.println("Anna joukkueesi nimi: ");
        String kotiJoukkueenNimi = lukija.nextLine();
        System.out.println("- Vieras - ");
        System.out.println("Anna nimesi: ");
        String vierasNimi = lukija.nextLine();
        System.out.println("Anna joukkueesi nimi: ");
        String vierasJoukkueenNimi = lukija.nextLine();
        this.taistelu = new Taistelutoiminta(kotiNimi, kotiJoukkueenNimi, vierasNimi, vierasJoukkueenNimi);
    }

    /**
     *
     */
    public void kaynnista() {
        System.out.println("Taistelu alkaa!");
        System.out.println("Koti: " + taistelu.getKoti().getJoukkue().getNimi() + " Vieras: " + taistelu.getVieras().getJoukkue().getNimi());
        while (true) {
            System.out.println("Vuorossa: " + taistelu.getKenenVuoro());
            this.tulostaKomennot();
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
            if (komento.equals("3")) {
                this.liikuta();
                this.tulostaAreena();
            }
        }
    }

    private void tulostaKomennot() {
        System.out.println("X - Lopettaa pelin");
        System.out.println("Y - Tulostaa komennot");
        System.out.println("1 - Tulosta areena");
        System.out.println("2 - Tulosta joukkue");
        System.out.println("3 - Liikuta");
    }

    private void liikuta() {
        System.out.println("Valitse gladiaattori: (1-8)");
        int gladiaattorinNumero = Integer.parseInt(lukija.nextLine());
        System.out.println("Valitse suunta: (Vasen, Oikea, Eteen, Taakse, Etuvasen, Etuoikea, Takavasen, Takaoikea)");
        String suunta = lukija.nextLine();

        taistelu.liikuta(taistelu.getVuorossaOlevaJoukkue().haeGladiaattori(gladiaattorinNumero), this.suunnanValinta(suunta));

    }

    private Suunta suunnanValinta(String suunta) {
        if (suunta.toUpperCase().equals("VASEN")) {
            if (taistelu.getKenenVuoro().equals("Koti")) {
                return Suunta.KOTIVASEN;
            } else {
                return Suunta.VIERASVASEN;
            }
        } else if (suunta.toUpperCase().equals("OIKEA")) {
            if (taistelu.getKenenVuoro().equals("Koti")) {
                return Suunta.KOTIOIKEA;
            } else {
                return Suunta.VIERASOIKEA;
            }
        } else if (suunta.toUpperCase().equals("ETEEN")) {
            if (taistelu.getKenenVuoro().equals("Koti")) {
                return Suunta.KOTIETEEN;
            } else {
                return Suunta.VIERASETEEN;
            }
        } else if (suunta.toUpperCase().equals("TAAKSE")) {
            if (taistelu.getKenenVuoro().equals("Koti")) {
                return Suunta.KOTITAAKSE;
            } else {
                return Suunta.VIERASTAAKSE;
            }
        } else if (suunta.toUpperCase().equals("ETUVASEN")) {
            if (taistelu.getKenenVuoro().equals("Koti")) {
                return Suunta.KOTIETUVASEN;
            } else {
                return Suunta.VIERASETUVASEN;
            }
        } else if (suunta.toUpperCase().equals("ETUOIKEA")) {
            if (taistelu.getKenenVuoro().equals("Koti")) {
                return Suunta.KOTIETUOIKEA;
            } else {
                return Suunta.VIERASETUOIKEA;
            }
        } else if (suunta.toUpperCase().equals("TAKAVASEN")) {
            if (taistelu.getKenenVuoro().equals("Koti")) {
                return Suunta.KOTITAKAVASEN;
            } else {
                return Suunta.VIERASTAKAVASEN;
            }
        } else if (suunta.toUpperCase().equals("TAKAOIKEA")) {
            if (taistelu.getKenenVuoro().equals("Koti")) {
                return Suunta.KOTITAKAOIKEA;
            } else {
                return Suunta.VIERASTAKAOIKEA;
            }
        } else {
            return null;
        }
    }

    private void tulostaJoukkue() {
        while (true) {
            System.out.println("Mikä joukkue? (Koti: 1, Vieras: 2, Kaikki: X)");
            String vaihtoehto = lukija.nextLine();
            if (vaihtoehto.toUpperCase().equals("1")) {
                System.out.println(taistelu.getKoti().getJoukkue());
                break;
            } else if (vaihtoehto.toUpperCase().equals("2")) {
                System.out.println(taistelu.getVieras().getJoukkue());
                break;
            } else if (vaihtoehto.toUpperCase().equals("X")) {
                System.out.println(taistelu.getKoti().getJoukkue());
                System.out.println(taistelu.getVieras().getJoukkue());
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
                    System.out.print("[" + taistelu.getAreena().getAreena()[y][x].getGladiaattori().getPeliNumero() + "]");
                } else {
                    System.out.print("[ ]");
                }
            }
            System.out.println("");
        }
    }
}
