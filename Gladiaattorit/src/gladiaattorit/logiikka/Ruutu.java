package gladiaattorit.logiikka;

/**
 *
 * @author juzmach
 */
public class Ruutu {

    private Gladiaattori gladiaattori;
    private boolean kaytossa;
    private int ruudunX;
    private int ruudunY;

    /**
     *
     * @param y
     * @param x
     */
    public Ruutu(int y, int x) {
        this.gladiaattori = null;
        this.kaytossa = false;
        this.ruudunY = y;
        this.ruudunX = x;
    }

    /**
     *
     * @return
     */
    public int getRuudunY() {
        return ruudunY;
    }

    /**
     *
     * @return
     */
    public int getRuudunX() {
        return ruudunX;
    }

    /**
     *
     * @param asetettava
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
     * @return
     */
    public Gladiaattori getGladiaattori() {
        return gladiaattori;
    }

    /**
     *
     * @return
     */
    public boolean isKaytossa() {
        return kaytossa;
    }

    /**
     *
     * @param kaytossa
     */
    public void setKaytossa(boolean kaytossa) {
        this.kaytossa = kaytossa;
    }
}
