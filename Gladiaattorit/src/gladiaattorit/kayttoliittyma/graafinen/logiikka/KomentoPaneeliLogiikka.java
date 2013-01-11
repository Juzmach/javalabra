package gladiaattorit.kayttoliittyma.graafinen.logiikka;

import gladiaattorit.pelilogiikka.Gladiaattori;
import gladiaattorit.pelilogiikka.Joukkue;
import gladiaattorit.pelilogiikka.Pelaaja;
import gladiaattorit.pelilogiikka.Suunta;
import gladiaattorit.pelilogiikka.Taistelupeli;
import java.util.ArrayList;

/**
 *
 * @author juzmach
 */
public class KomentoPaneeliLogiikka {

    /**
     * Taistelupeli-olio.
     */
    private Taistelupeli taistelupeli;
    /**
     * Lista mahdollisista komennoista.
     */
    private ArrayList<String> mahdollisetKomennot;
    /**
     * Lista mahdollisista suunnista.
     */
    private ArrayList<String> mahdollisetSuunnat;
    /**
     * Lista mahdollisista Gladiaattorien nimistä.
     */
    private ArrayList<String> mahdollisetGladiaattorit;
    /**
     * Komento osiin pilkottuna.
     */
    private String[] komentoOsina;
    /**
     * Rivi, joka tulostuu komentoruudulle, kun komento on suoritettu.
     */
    private String komentopaneelinTuloste;
    private Joukkue vuoronSuorittanutJoukkue;

    /**
     *
     * @param taistelupeli Taistelupeli-olio
     */
    public KomentoPaneeliLogiikka(Taistelupeli taistelupeli) {
        this.taistelupeli = taistelupeli;
        this.mahdollisetGladiaattorit = new ArrayList<String>();
        this.mahdollisetKomennot = new ArrayList<String>();
        this.mahdollisetSuunnat = new ArrayList<String>();
        this.komentopaneelinTuloste = "";
        this.vuoronSuorittanutJoukkue = null;
    }

    /**
     * Palauttaa rivin, joka tulostetaan komentoruudulle komennon suorituksen
     * jälkeen.
     *
     * @param komento Käyttäjän antama komento
     * @return Rivi, joka tulostuu komentoruudulle komennon suorituksen jälkeen
     */
    public String haeKomennonTuloste(String komento) {
        komentoOsina = komento.toUpperCase().split("\\s+");
        luoMahdolliset();

        if (onkoLiikuKomentoToimiva(komentoOsina) && komentoOsina[0].equals("LIIKU")) {
            komentopaneelinTuloste = liikuKomennonTuloste(komentoOsina);
            if (vuoronSuorittanutJoukkue.haeGladiaattori(komentoOsina[1]).olikoIsku()) {
                haeViimeisimmanIskunTuloste(vuoronSuorittanutJoukkue.haeGladiaattori(komentoOsina[1]).getViimeisinTehtyDamage());
            }
        } else if (onkoSuunnatKomentoToimiva(komentoOsina) && komentoOsina[0].equals("SUUNNAT")) {
            komentopaneelinTuloste = suunnatKomennonTuloste();
        } else if (onkoLuoKomentoToimiva(komentoOsina) && komentoOsina[0].equals("LUO")) {
            komentopaneelinTuloste = luoKomennonTuloste(komentoOsina);
        } else if (komentoOsina[0].equals("ALOITA")) {
            komentopaneelinTuloste = aloitaKomennonTuloste(komentoOsina);
        } else if (komentoOsina[0].equals("APUA")) {
            komentopaneelinTuloste = apuaKomennonTuloste(komentoOsina);
        } else {
            komentopaneelinTuloste = "\nVirheellinen komento! Yritä uudestaan!";
        }
        return komentopaneelinTuloste;
    }

    /**
     * Palauttaa "LUO"-komennon tulosteen.
     *
     * @param komentoOsina Annettu komento pilkottuna
     * @return "LUO"-komennon tuloste
     */
    private String luoKomennonTuloste(String[] komentoOsina) {
        return "\nLuodaan pelaaja: " + komentoOsina[1];
    }

    /**
     * Palauttaa "APUA"-komennon tulosteen.
     *
     * @param komentoOsina Annettu komento pilkottuna
     * @return "APUA"-komennon tuloste
     */
    private String apuaKomennonTuloste(String[] komentoOsina) {
        String tuloste = "\nKOMENNOT:";
        if (!taistelupeli.isPeliAlkanut()) {
            tuloste += "\nLUO <KOTI/VIERAS> <PELAAJAN NIMI> <JOUKKUEEN NIMI> <JOUKKUEEN KOKO>";
            tuloste += "\nALOITA";
        } else {
            tuloste += "\nLIIKU <GLADIAATTORIN NIMI> <SUUNTA>";
            tuloste += "\nSUUNNAT";
        }
        tuloste += "\nAPUA";
        return tuloste;
    }

    /**
     * Palauttaa "SUUNNAT"-komennon tulosteen.
     *
     * @return Annettu komento pilkottuna
     */
    private String suunnatKomennonTuloste() {
        String tuloste = "\nSUUNNAT: ";
        for (String suunta : mahdollisetSuunnat) {
            tuloste += suunta + " ";
        }
        return tuloste;
    }

    /**
     * Palauttaa "LIIKU"-komennon tulosteen.
     *
     * @param komentoOsina Annettu komento pilkottuna
     * @return "LIIKU"-komennon tuloste
     */
    private String liikuKomennonTuloste(String[] komentoOsina) {
        String tuloste = "\nLiikutetaan: " + komentoOsina[1] + " " + komentoOsina[2];
        if (taistelupeli.onkoPeliPaattynyt()) {
            tuloste += "\nPeli on päättynyt! Voittaja: " + taistelupeli.getVoittajaJoukkue().getNimi();
        }
        return tuloste;
    }

    /**
     * Palauttaa "ALOITA"-komennon tulosteen.
     *
     * @param komentoOsina Annettu komento osina
     * @return "ALOITA"-komennon tuloste
     */
    private String aloitaKomennonTuloste(String[] komentoOsina) {
        if (!taistelupeli.isKotijoukkueLuotu()) {
            return "\nEt voi aloittaa peliä, koska kotijoukkuetta ei ole luotu!";
        } else if (!taistelupeli.isVierasjoukkueLuotu()) {
            return "\nEt voi aloittaa peliä, koska vierasjoukkuetta ei ole luotu!";
        } else {
            return "\nAloitetaan peli!";
        }
    }

    /**
     * Pilkkoo komennon osiin ja suorittaa komennon osien perusteella. Suorittaa
     * VAIN Liiku-, Luo- ja Aloita-komennot. Tulostuskomennot suoriutuu
     * haeKomennonTuloste()-metodilla.
     *
     * @param komento Käyttäjän antama komento.
     */
    public void toimintaKomennonSuoritus(String komento) {
        komentoOsina = komento.toUpperCase().split("\\s+");
        if (taistelupeli.isPeliAlkanut()) {
            luoMahdolliset();
            if (komentoOsina[0].equals("LIIKU") && onkoLiikuKomentoToimiva(komentoOsina)) {
                liikuKomento(komentoOsina);
            }
        } else {
            if (komentoOsina[0].equals("LUO") && onkoLuoKomentoToimiva(komentoOsina)) {
                luoPelaaja(komentoOsina);
            } else if (komentoOsina[0].equals("ALOITA")) {
                aloitaPeli();
            }
        }
    }

    /**
     * Aloittaa pelin.
     */
    private void aloitaPeli() {
        if (taistelupeli.isKotijoukkueLuotu() && taistelupeli.isVierasjoukkueLuotu()) {
            taistelupeli.asetaJoukkueetAreenalle();
            taistelupeli.setPeliAlkanut(true);
        }
    }

    /**
     * Luo pelaajat komennon parametrien mukaan. komentoOsina[1] = Koti/Vieras,
     * komentoOsina[2] = Pelaajan nimi komentoOsina[3] = Joukkueen nimi
     * komentoOsina[4] = Joukkueen koko
     *
     * @param komentoOsina Komento pilkottuna osiin
     */
    public void luoPelaaja(String[] komentoOsina) {
        if (komentoOsina[1].equalsIgnoreCase("koti")) {
            taistelupeli.setKoti(new Pelaaja(komentoOsina[2], komentoOsina[3], Integer.parseInt(komentoOsina[4])));
        } else {
            taistelupeli.setVieras(new Pelaaja(komentoOsina[2], komentoOsina[3], Integer.parseInt(komentoOsina[4])));
        }
    }

    /**
     * Tarkistaa onko annettu Luo-komento toimiva.
     *
     * @param komentoOsina Annettu komento pilkottuna
     * @return true jos on, false jos ei
     */
    private boolean onkoLuoKomentoToimiva(String[] komentoOsina) {
        if (komentoOsina.length == 5 && (komentoOsina[1].equalsIgnoreCase("koti") || komentoOsina[1].equalsIgnoreCase("vieras"))
                && onkoKomennonParametriNumeerinen(komentoOsina[4])
                && Integer.parseInt(komentoOsina[4]) >= 1 && Integer.parseInt(komentoOsina[4]) <= 8) {
            return true;
        } else {
            return false;
        }
    }

    private boolean onkoKomennonParametriNumeerinen(String komennonParametri) {
        try {
            int kokeiltava = Integer.parseInt(komennonParametri);
        } catch (NumberFormatException Exception) {
            return false;
        }
        return true;
    }

    /**
     * Tarkistaa onko annettu Suunnat-komento toimiva.
     *
     * @param komentoOsina Annettu komento pilkottuna
     * @return true jos on, false jos ei
     */
    private boolean onkoSuunnatKomentoToimiva(String[] komentoOsina) {
        if (komentoOsina.length == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Tarkistaa onko annettu Liiku-komento toimiva.
     *
     * @param komentoOsina Annettu komento pilkottuna
     * @return true jos on, false jos ei
     */
    private boolean onkoLiikuKomentoToimiva(String[] komentoOsina) {
        if (komentoOsina.length == 3
                && mahdollisetKomennot.contains(komentoOsina[0])
                && mahdollisetGladiaattorit.contains(komentoOsina[1])
                && mahdollisetSuunnat.contains(komentoOsina[2])) {
            return true;
        } else if (komentoOsina.length < 3 || komentoOsina.length > 3) {
            return false;
        } else {
            return false;
        }
    }

    /**
     * Luo listat mahdollisista komennoista, suunnista ja gladiaattorien nimistä
     * käyttäen näiden apumetodeja.
     */
    private void luoMahdolliset() {
        luoMahdollisetToimintakomennotLista();
        luoMahdollisetSuunnatLista();
        luoMahdollisetGladiaattoritLista();

    }

    /**
     * Apumetodi, joka luo listan gladiaattorien nimistä.
     */
    private void luoMahdollisetGladiaattoritLista() {
        if (taistelupeli.isKotijoukkueLuotu() && taistelupeli.isVierasjoukkueLuotu()) {
            for (Gladiaattori gladiaattori : taistelupeli.getVuorossaOlevaJoukkue().getGladiaattorit()) {
                mahdollisetGladiaattorit.add(gladiaattori.getNimi().toUpperCase());
            }
        }
    }

    /**
     * Apumetodi, joka luo listan mahdollisista suunnista.
     */
    private void luoMahdollisetSuunnatLista() {
        mahdollisetSuunnat.clear();
        String[] kaikkiSuunnat = "ETEEN TAAKSE VASEN OIKEA ETUVASEN ETUOIKEA TAKAVASEN TAKAOIKEA".split("\\s+");
        for (int i = 0; i < kaikkiSuunnat.length; i++) {
            mahdollisetSuunnat.add(kaikkiSuunnat[i]);
        }
    }

    /**
     * Apumetodi, joka luo listan mahdollisista komennoista.
     */
    private void luoMahdollisetToimintakomennotLista() {
        mahdollisetKomennot.add("LIIKU");
        mahdollisetKomennot.add("SUUNNAT");
    }

    /**
     * Apumetodi, joka suorittaa varsinaisen liikkumistoiminnon käyttäen
     * Taistelupeli-luokan liikuta(Gladiaattori,Suunta)-metodia.
     *
     * @param komennonOsat
     */
    private void liikuKomento(String[] komennonOsat) {
        if (!taistelupeli.onkoPeliPaattynyt()) {
            this.vuoronSuorittanutJoukkue = taistelupeli.getVuorossaOlevaJoukkue();
            taistelupeli.liikuta(vuoronSuorittanutJoukkue.haeGladiaattori(komennonOsat[1]), suunnanValinta(komennonOsat[2]));
        }
    }

    private void haeViimeisimmanIskunTuloste(int iskunDamage) {
        if (iskunDamage == 0) {
            komentopaneelinTuloste += "\nEi osunut!";
        } else {
            komentopaneelinTuloste += "\nDamage: " + iskunDamage;
        }
    }

    /**
     * Valitsee oikean Suunta-olion.
     *
     * @param suunta Komennosta otettu suunnan nimi.
     * @return Parametria vastaava Suunta-olio. Palauttaa null, jos ei löydy.
     */
    private Suunta suunnanValinta(String suunta) {
        switch (suunta.toUpperCase()) {
            case "VASEN":
                if (taistelupeli.getKenenVuoro().equals("Koti")) {
                    return Suunta.KOTIVASEN;
                } else {
                    return Suunta.VIERASVASEN;
                }
            case "OIKEA":
                if (taistelupeli.getKenenVuoro().equals("Koti")) {
                    return Suunta.KOTIOIKEA;
                } else {
                    return Suunta.VIERASOIKEA;
                }
            case "ETEEN":
                if (taistelupeli.getKenenVuoro().equals("Koti")) {
                    return Suunta.KOTIETEEN;
                } else {
                    return Suunta.VIERASETEEN;
                }
            case "TAAKSE":
                if (taistelupeli.getKenenVuoro().equals("Koti")) {
                    return Suunta.KOTITAAKSE;
                } else {
                    return Suunta.VIERASTAAKSE;
                }
            case "ETUVASEN":
                if (taistelupeli.getKenenVuoro().equals("Koti")) {
                    return Suunta.KOTIETUVASEN;
                } else {
                    return Suunta.VIERASETUVASEN;
                }
            case "ETUOIKEA":
                if (taistelupeli.getKenenVuoro().equals("Koti")) {
                    return Suunta.KOTIETUOIKEA;
                } else {
                    return Suunta.VIERASETUOIKEA;
                }
            case "TAKAVASEN":
                if (taistelupeli.getKenenVuoro().equals("Koti")) {
                    return Suunta.KOTITAKAVASEN;
                } else {
                    return Suunta.VIERASTAKAVASEN;
                }
            case "TAKAOIKEA":
                if (taistelupeli.getKenenVuoro().equals("Koti")) {
                    return Suunta.KOTITAKAOIKEA;
                } else {
                    return Suunta.VIERASTAKAOIKEA;
                }
            default:
                return null;
        }
    }
}
