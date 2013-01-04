package gladiaattorit.logiikka;

/**
 *
 * @author juzmach
 */
public class Pelaaja {

    private String nimi;
    private Joukkue joukkue;

    public Pelaaja(String nimi, String joukkueenNimi) {
        this.nimi = nimi;
        this.joukkue = this.luoJoukkue(joukkueenNimi);
    }

    public void liikuta(Gladiaattori liikutettava, Ruutu uusiRuutu) {
        liikutettava.liiku(uusiRuutu);
    }
    
    private Joukkue luoJoukkue(String nimi) {
        Joukkue joukkue = new Joukkue(nimi);
        for (int i = 0; i < 8; i++) {
            joukkue.lisaaGladiaattori(new Gladiaattori("Taistelija",i));
        }
        return joukkue;
    }

    public Joukkue getJoukkue() {
        return joukkue;
    }
}
