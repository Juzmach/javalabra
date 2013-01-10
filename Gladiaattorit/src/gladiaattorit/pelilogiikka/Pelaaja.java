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
     * @param joukkueenKoko Joukkueen koko (1-8)
     */
    public Pelaaja(String nimi, String joukkueenNimi,int joukkueenKoko) {
        this.nimi = nimi;
        this.joukkue = this.luoJoukkue(joukkueenNimi,joukkueenKoko);
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
        } else {
            liikutettava.liiku(uusiRuutu);
        }
    }

    /**
     * Luo pelaajalle kahdeksanhenkisen joukkueen.
     *
     * @param nimi Joukkueen nimi
     * @param joukkueenKoko Joukkueen koko (1-8)
     * @return Kahdeksanhenkinen joukkue
     */
    public Joukkue luoJoukkue(String nimi,int joukkueenKoko) {
        Joukkue joukkue = new Joukkue(nimi);
        for (int i = 1; i <= joukkueenKoko; i++) {
            joukkue.lisaaGladiaattori(new Gladiaattori("Unit" + i, i));
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
