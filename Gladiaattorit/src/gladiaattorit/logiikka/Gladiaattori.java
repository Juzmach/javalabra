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

    /**
     *
     * @param nimi
     * @param peliNumero
     */
    public Gladiaattori(String nimi, int peliNumero) {
        this.nimi = nimi;
        this.voima = 3 + (int) (Math.random() * 6);
        this.energia = 15 + (int) (Math.random() * 21);
        this.elossa = true;
        this.ruutu = null;
        this.peliNumero = peliNumero;
    }

    /**
     *
     * @param ruutu
     */
    public void asetaRuutu(Ruutu ruutu) {
        this.ruutu = ruutu;
    }

    /**
     *
     * @return
     */
    public String getNimi() {
        return nimi;
    }

    /**
     *
     * @return
     */
    public boolean isElossa() {
        return elossa;
    }

    /**
     *
     * @return
     */
    public int getEnergia() {
        return energia;
    }

    /**
     *
     * @param energia
     */
    public void setEnergia(int energia) {
        this.energia = energia;
    }

    /**
     *
     * @return
     */
    public Ruutu getRuutu() {
        return ruutu;
    }

    @Override
    public String toString() {
        return nimi + " " + peliNumero + " [" + "voima: " + voima + ", " + "energia: " + energia + "]";
    }

    /**
     *
     * @return
     */
    public int getPeliNumero() {
        return peliNumero;
    }

    /**
     *
     * @param maara
     */
    public void vahennaEnergiaa(int maara) {
        if ((this.energia -= maara) <= 0) {
            this.energia = 0;
            this.elossa = false;
            this.ruutu.setKaytossa(false);

        } else {
            this.energia -= maara;
        }

    }

    /**
     *
     * @param uusiRuutu
     */
    public void liiku(Ruutu uusiRuutu) {
        if (!uusiRuutu.isKaytossa() && uusiRuutu != null && this.elossa) {
            ruutu.setKaytossa(false);
            uusiRuutu.asetaGladiaattori(this);
            this.ruutu = uusiRuutu;
        }
    }

    /**
     *
     * @param vastustaja
     */
    public void iske(Gladiaattori vastustaja) {
        int damage = (int) (Math.random() * voima);
        vastustaja.vahennaEnergiaa(damage);
    }
}
