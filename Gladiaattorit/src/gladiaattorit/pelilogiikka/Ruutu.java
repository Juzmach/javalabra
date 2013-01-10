package gladiaattorit.pelilogiikka;

/**
 *
 * @author juzmach
 */
public class Ruutu {

    /**
     * Gladiaattori, joka on ruudussa
     */
    private Gladiaattori gladiaattori;
    /**
     * boolean-arvo, joka kertoo onko ruutu käytössä vai ei
     */
    private boolean kaytossa;
    /**
     * Ruudun X-koordinaatti areenalla
     */
    private int ruudunX;
    /**
     * Ruudun Y-koordinaatti areenalla
     */
    private int ruudunY;

    /**
     *
     * @param y Ruudun Y-koordinaatti
     * @param x Ruudun X-koordinaatti
     */
    public Ruutu(int y, int x) {
        this.gladiaattori = null;
        this.kaytossa = false;
        this.ruudunY = y;
        this.ruudunX = x;
    }

    /**
     *
     * @return Ruudun Y-koordinaatti
     */
    public int getRuudunY() {
        return ruudunY;
    }

    /**
     *
     * @return Ruudun X-koordinaatti
     */
    public int getRuudunX() {
        return ruudunX;
    }

    /**
     * Asettaa gladiaattorin ruudulle, jos ruutu ei ole käytössä
     *
     * @param asetettava Asetettava gladiaattori
     */
    public void asetaGladiaattori(Gladiaattori asetettava) {
        if (this.kaytossa == false) {
            this.gladiaattori = asetettava;
            this.kaytossa = true;
            this.gladiaattori.asetaRuutu(this);
        }
    }

    /**
     *
     * @return Ruudulla oleva gladiaattori
     */
    public Gladiaattori getGladiaattori() {
        return gladiaattori;
    }

    /**
     *
     * @return boolean-arvo, joka kertoo onko ruutu käytössä
     */
    public boolean isKaytossa() {
        return kaytossa;
    }

    /**
     *
     * @param kaytossa Asettaa ruudun käytössäolevaksi tai päinvastoin
     */
    public void setKaytossa(boolean kaytossa) {
        this.kaytossa = kaytossa;
    }

    @Override
    public String toString() {
        if (this.kaytossa) {
            return "" + this.gladiaattori.getPeliNumero();
        } else {
            return " ";
        }
    }
}
