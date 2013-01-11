package gladiaattorit.pelilogiikka;

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
    /**
     * Gladiaattorin pelinumero
     */
    private int peliNumero;
    private int viimeisinTehtyDamage;
    private boolean olikoIsku;

    /**
     * Gladiaattorin voima ja energia arvotaan satunnaisesti.
     * 
     * @param nimi Gladiaattorin nimi
     * @param peliNumero Gladiaattorin pelinumero
     */
    public Gladiaattori(String nimi, int peliNumero) {
        this.nimi = nimi.toUpperCase();
        this.voima = 10;
        this.energia = 100;
        this.elossa = true;
        this.ruutu = null;
        this.peliNumero = peliNumero;
        this.viimeisinTehtyDamage = 0;
        this.olikoIsku = false;
    }

    /**
     * Asettaa Ruutu-olion, jossa gladiaattori on
     *
     * @param ruutu Asetettava ruutu
     */
    public void asetaRuutu(Ruutu ruutu) {
        this.ruutu = ruutu;
    }

    /**
     *
     * @return Gladiaattorin nimi
     */
    public String getNimi() {
        return nimi;
    }

    public int getViimeisinTehtyDamage() {
        return viimeisinTehtyDamage;
    }

    /**
     *
     * @return boolean-arvo, joka kertoo onko gladiaattori elossa
     */
    public boolean isElossa() {
        return elossa;
    }

    /**
     *
     * @return Gladiaattorin energia
     */
    public int getEnergia() {
        return energia;
    }

    /**
     * Asettaa gladiaattorin energian
     *
     * @param energia Asetettava energiamäärä
     */
    public void setEnergia(int energia) {
        this.energia = energia;
    }

    /**
     *
     * @return Ruutu-olio, jossa gladiaattori on
     */
    public Ruutu getRuutu() {
        return ruutu;
    }

    @Override
    public String toString() {
        return nimi + " [" + "voima: " + voima + " " + "energia: " + energia + "]";
    }

    /**
     *
     * @return Gladiaattorin pelinumero
     */
    public int getPeliNumero() {
        return peliNumero;
    }

    /**
     * Vähentää gladiaattorin energiaa toisen gladiaattorin aiheuttaman vahingon
     * verran.
     *
     * @param damage Toisen gladiaattorin aiheuttama vahinko
     */
    public void vahennaEnergiaa(int damage) {
        this.energia -= damage;
        if(this.energia <= 0){
            kaadu();
        }
    }
    
    private void kaadu(){
        this.energia = 0;
        this.elossa = false;
        this.ruutu.setKaytossa(false);
    }

    /**
     * Siirtää gladiaattorin seuraavalle ruudulle
     *
     * @param uusiRuutu Gladiaattorin uusi ruutu
     */
    public void liiku(Ruutu uusiRuutu) {
        if (!uusiRuutu.isKaytossa() && uusiRuutu != null && this.elossa) {
            ruutu.setKaytossa(false);
            uusiRuutu.asetaGladiaattori(this);
            this.ruutu = uusiRuutu;
            
        }
        this.olikoIsku = false;
    }

    /**
     * Aiheuttaa parametrin gladiaattorille satunnaisen määrän vahinkoa
     *
     * @param vastustaja Gladiaattori, jota lyödään
     */
    public void iske(Gladiaattori vastustaja) {
        int damage = 0;
        if (osuuko()) {
            damage = voima;
            vastustaja.vahennaEnergiaa(damage);
        }
        this.olikoIsku = true;
        this.viimeisinTehtyDamage = damage;
    }

    private boolean osuuko() {
        double osumisprosentti = Math.random();
        if (osumisprosentti >= 0.3) {
            return true;
        } else {
            return false;
        }
    }

    public boolean olikoIsku() {
        return olikoIsku;
    }
}
