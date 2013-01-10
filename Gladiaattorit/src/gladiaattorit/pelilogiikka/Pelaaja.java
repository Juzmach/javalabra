package gladiaattorit.pelilogiikka;

/**
 *
 * @author juzmach
 */
public class Pelaaja {

    /**
     * Pelaajan nimi
     */
    private String nimi;
    /**
     * Pelaajan joukkue
     */
    private Joukkue joukkue;

    /**
     *
     * @param nimi Pelaajan nimi
     * @param joukkueenNimi Pelaajan joukkueen nimi
     */
    public Pelaaja(String nimi, String joukkueenNimi) {
        this.nimi = nimi;
        this.joukkue = this.luoJoukkue(joukkueenNimi);
    }

    /**
     * Liikuttaa gladiaattoria käyttäen gladiaattorin liiku(Ruutu)-metodia. Jos
     * gladiaattorin edessä olevalla ruudulla on vastustajan gladiaattori,
     * metodi käyttää gladiaattorin iske(Gladiaattori)-metodia.
     *
     * @param liikutettava Liikutettava gladiaattori
     * @param uusiRuutu Ruutu, jolle gladiaattoria liikutetaan
     */
    public void liikuta(Gladiaattori liikutettava, Ruutu uusiRuutu) {
        if (uusiRuutu.isKaytossa() && !joukkue.getGladiaattorit().contains(uusiRuutu.getGladiaattori())) {
            liikutettava.iske(uusiRuutu.getGladiaattori());
            uusiRuutu.getGladiaattori().iske(liikutettava);
        } else {
            liikutettava.liiku(uusiRuutu);
        }
    }

    /**
     * Luo pelaajalle kahdeksanhenkisen joukkueen.
     *
     * @param nimi Joukkueen nimi
     * @return Kahdeksanhenkinen joukkue
     */
    public Joukkue luoJoukkue(String nimi) {
        Joukkue joukkue = new Joukkue(nimi);
        for (int i = 1; i <= 8; i++) {
            joukkue.lisaaGladiaattori(new Gladiaattori("Taistelija" + i, i));
        }
        return joukkue;
    }

    /**
     *
     * @return Pelaajan joukkue
     */
    public Joukkue getJoukkue() {
        return joukkue;
    }

    @Override
    public String toString() {
        return this.nimi + "\n" + this.joukkue.toString();
    }
}
