package gladiaattorit.logiikka;

/**
 *
 * @author juzmach
 */
public class Gladiaattori {
    
    /**
     * Gladiaattorin nimi
     */
    private String nimi;
    /**
     * Gladiaattorin iskuvoima
     */
    private int voima;
    /**
     * Gladiaattorin energia
     */
    private int energia;
    /**
     * Kertoo, onko gladiaattori elossa vai ei
     */
    private boolean elossa;
    /**
     * Ruutu, missä gladiaattori on
     */
    private Ruutu ruutu;
    private int peliNumero;

    /**
     * 
     * @param nimi Gladiaattorin nimi
     * @param peliNumero Gladiaattorin pelinumero
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
     * Vähentää gladiaattorin energiaa toisen gladiaattorin aiheuttaman vahingon verran.
     * @param maara "Damage" eli toisen gladiaattorin aiheuttama vahinko
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
     * Siirtää gladiaattorin seuraavalle ruudulle
     * @param uusiRuutu Gladiaattorin uusi ruutu
     */
    public void liiku(Ruutu uusiRuutu) {
        if (!uusiRuutu.isKaytossa() && uusiRuutu != null && this.elossa) {
            ruutu.setKaytossa(false);
            uusiRuutu.asetaGladiaattori(this);
            this.ruutu = uusiRuutu;
        }
    }

    /**
     * Aiheuttaa parametrin gladiaattorille satunnaisen määrän vahinkoa
     * @param vastustaja Gladiaattori, jota lyödään
     */
    public void iske(Gladiaattori vastustaja) {
        int damage = (int) (Math.random() * voima);
        vastustaja.vahennaEnergiaa(damage);
    }
}
