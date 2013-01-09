package gladiaattorit.kayttoliittyma.graafinen.logiikka;

import gladiaattorit.pelilogiikka.Gladiaattori;
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

    /**
     *
     * @param taistelupeli
     */
    public KomentoPaneeliLogiikka(Taistelupeli taistelupeli) {
        this.taistelupeli = taistelupeli;
        this.mahdollisetGladiaattorit = new ArrayList<String>();
        this.mahdollisetKomennot = new ArrayList<String>();
        this.mahdollisetSuunnat = new ArrayList<String>();
        this.komentopaneelinTuloste = "";
    }

    /**
     * Palauttaa rivin, joka tulostetaan komentoruudulle komennon suorituksen jälkeen.
     * @param komento Käyttäjän antama komento
     * @return Rivi, joka tulostuu komentoruudulle komennon suorituksen jälkeen
     */
    public String haeKomennonTuloste(String komento) {
        komentoOsina = komento.toUpperCase().split("\\s+");
        luoMahdolliset();
        if (!onkoKomentoToimiva(komentoOsina)) {
            komentopaneelinTuloste += "\nKomento ei ole toimiva! Yritä uudestaan.";
            return komentopaneelinTuloste;
        } else if (komentoOsina[0].equals("LIIKU")) {
            komentopaneelinTuloste += "\nLiikutetaan: " + komentoOsina[1] + " " + komentoOsina[2];
        }
        return komentopaneelinTuloste;
    }

    /**
     * Pilkkoo komennon osiin ja suorittaa komennon osien perusteella.
     * @param komento Käyttäjän antama komento.
     */
    public void komennonSuoritus(String komento) {
        komentoOsina = komento.toUpperCase().split("\\s+");
        luoMahdolliset();
        if (onkoKomentoToimiva(komentoOsina) && komentoOsina[0].equals("LIIKU")) {
            liikuKomento(komentoOsina);
        } else if (komentoOsina[0].equals("TULOSTA")) {
        }
    }

    /**
     * Tarkastaa onko komento toimiva.
     * @param komentoOsina Komento pilkottuna osiin
     * @return true, jos komento toimii, false jos ei
     */
    public boolean onkoKomentoToimiva(String[] komentoOsina) {
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
     * Luo listat mahdollisista komennoista, suunnista ja gladiaattorien nimistä käyttäen näiden apumetodeja.
     */
    private void luoMahdolliset() {
        luoMahdollisetKomennotLista();
        luoMahdollisetSuunnatLista();
        luoMahdollisetGladiaattoritLista();
    }

    /**
     * Apumetodi, joka luo listan gladiaattorien nimistä.
     */
    private void luoMahdollisetGladiaattoritLista() {
        for (Gladiaattori gladiaattori : taistelupeli.getVuorossaOlevaJoukkue().getGladiaattorit()) {
            mahdollisetGladiaattorit.add(gladiaattori.getNimi().toUpperCase());
        }
    }

    /**
     * Apumetodi, joka luo listan mahdollisista suunnista.
     */
    private void luoMahdollisetSuunnatLista() {
        String[] kaikkiSuunnat = "ETEEN TAAKSE VASEN OIKEA ETUVASEN ETUOIKEA TAKAVASEN TAKAOIKEA".split("\\s+");
        for (int i = 0; i < kaikkiSuunnat.length; i++) {
            mahdollisetSuunnat.add(kaikkiSuunnat[i]);
        }
    }

    /**
     * Apumetodi, joka luo listan mahdollisista komennoista.
     */
    private void luoMahdollisetKomennotLista() {
        mahdollisetKomennot.add("LIIKU");
        mahdollisetKomennot.add("TULOSTA");
    }

    /**
     * Apumetodi, joka suorittaa varsinaisen liikkumistoiminnon käyttäen Taistelupeli-luokan liikuta(Gladiaattori,Suunta)-metodia.
     * @param komennonOsat 
     */
    private void liikuKomento(String[] komennonOsat) {
        taistelupeli.liikuta(taistelupeli.getVuorossaOlevaJoukkue().haeGladiaattori(komennonOsat[1]), suunnanValinta(komennonOsat[2]));
    }

    /**
     * Valitsee oikean Suunta-olion.
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
