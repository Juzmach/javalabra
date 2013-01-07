package gladiaattorit.logiikka;

/**
 *
 * @author juzmach
 */
public class Pelaaja {

    private String nimi;
    private Joukkue joukkue;

    /**
     *
     * @param nimi
     * @param joukkueenNimi
     */
    public Pelaaja(String nimi, String joukkueenNimi) {
        this.nimi = nimi;
        this.joukkue = this.luoJoukkue(joukkueenNimi);
    }

    /**
     *
     * @param liikutettava
     * @param uusiRuutu
     */
    public void liikuta(Gladiaattori liikutettava, Ruutu uusiRuutu) {
        if (uusiRuutu.isKaytossa() && !joukkue.getGladiaattorit().contains(uusiRuutu.getGladiaattori())) {
            liikutettava.iske(uusiRuutu.getGladiaattori());
            uusiRuutu.getGladiaattori().iske(liikutettava);
        } else {
            liikutettava.liiku(uusiRuutu);
        }
    }

    private Joukkue luoJoukkue(String nimi) {
        Joukkue joukkue = new Joukkue(nimi);
        for (int i = 1; i <= 8; i++) {
            joukkue.lisaaGladiaattori(new Gladiaattori("Taistelija", i));
        }
        return joukkue;
    }

    /**
     *
     * @return
     */
    public Joukkue getJoukkue() {
        return joukkue;
    }
}
