package gladiaattorit.logiikka;

/**
 *
 * @author juzmach
 */
public class Gladiaattori {

    private String nimi;
    private int voima;
    private int energia;
    private boolean elossa;
    private Ruutu ruutu;
    private int peliNumero;

    public Gladiaattori(String nimi,int peliNumero) {
        this.nimi = nimi;
        this.voima = 5;
        this.energia = 10;
        this.elossa = true;
        this.ruutu = null;
        this.peliNumero = peliNumero;
    }

    public void asetaRuutu(Ruutu ruutu) {
        this.ruutu = ruutu;
    }

    public String getNimi() {
        return nimi;
    }

    public boolean isElossa() {
        return elossa;
    }

    public int getEnergia() {
        return energia;
    }

    public Ruutu getRuutu() {
        return ruutu;
    }

    @Override
    public String toString() {
        return nimi + "[" + "voima: " + voima + ", " + "energia: " + energia + "]";
    }

    public int getPeliNumero() {
        return peliNumero;
    }

    public void vahennaEnergiaa(int maara) {
        if ((this.energia -= maara) <= 0) {
            this.energia = 0;
            this.elossa = false;

        } else {
            this.energia -= maara;
        }

    }

    public void liiku(Ruutu uusiRuutu) {
        ruutu.setKaytossa(false);
        uusiRuutu.asetaGladiaattori(this);
        this.ruutu = uusiRuutu;
    }
}
