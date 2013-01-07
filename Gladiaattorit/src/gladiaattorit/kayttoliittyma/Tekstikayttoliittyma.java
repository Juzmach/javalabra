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

    public Tekstikayttoliittyma(Scanner lukija) {
        this.lukija = lukija;
        this.alustus();
    }

    private void alustus() {
        System.out.println("Anna nimesi: ");
        String pelaajanNimi = lukija.nextLine();
        System.out.println("Anna joukkueesi nimi: ");
        String pelaajanJoukkueenNimi = lukija.nextLine();
        this.taistelu = new Taistelutoiminta(pelaajanNimi,pelaajanJoukkueenNimi);
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
            if (komento.equals("3")){
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
    
    private void liikuta(){
        System.out.println("Valitse gladiaattori: (0-7)");
        int gladiaattorinNumero = Integer.parseInt(lukija.nextLine());
        System.out.println("Valitse suunta: (Vasen, Oikea, Ylos, Alas)");
        String suunta = lukija.nextLine();
        taistelu.liikutaGladiaattoria(taistelu.getPelaaja().getJoukkue().haeGladiaattori(gladiaattorinNumero), this.suunnanValinta(suunta));
    }
    
    private Suunta suunnanValinta(String suunta){
        if(suunta.toUpperCase().equals("VASEN")){
            return Suunta.PELAAJANVASEN;
        } else if(suunta.toUpperCase().equals("OIKEA")){
            return Suunta.PELAAJANOIKEA;
        } else if(suunta.toUpperCase().equals("YLOS")){
            return Suunta.PELAAJANYLOS;
        } else if(suunta.toUpperCase().equals("ALAS")){
            return Suunta.PELAAJANALAS;
        } else {
            return null;
        }
    }

    private void tulostaJoukkue() {
        while (true) {
            System.out.println("Mikä joukkue? (Pelaaja: 1, Vastustaja: 2, Kaikki: X)");
            String vaihtoehto = lukija.nextLine();
            if (vaihtoehto.toUpperCase().equals("1")) {
                System.out.println(taistelu.getPelaaja().getJoukkue());
                break;
            } else if (vaihtoehto.toUpperCase().equals("2")) {
                System.out.println(taistelu.getVastustaja().getJoukkue());
                break;
            } else if (vaihtoehto.toUpperCase().equals("X")) {
                System.out.println(taistelu.getPelaaja().getJoukkue());
                System.out.println(taistelu.getVastustaja().getJoukkue());
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
                    System.out.print("["+ taistelu.getAreena().getAreena()[y][x].getGladiaattori().getPeliNumero() +"]");
                } else {
                    System.out.print("[ ]");
                }
            }
            System.out.println("");
        }
    }
}
