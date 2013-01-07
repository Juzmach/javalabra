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

    public Ruutu(int y, int x) {
        this.gladiaattori = null;
        this.kaytossa = false;
        this.ruudunY = y;
        this.ruudunX = x;
    }

    public int getRuudunY() {
        return ruudunY;
    }

    public int getRuudunX() {
        return ruudunX;
    }

    public void asetaGladiaattori(Gladiaattori asetettava) {
        if (this.kaytossa == false) {
            this.gladiaattori = asetettava;
            this.kaytossa = true;
            this.gladiaattori.asetaRuutu(this);
        }
    }

    public Gladiaattori getGladiaattori() {
        return gladiaattori;
    }

    public boolean isKaytossa() {
        return kaytossa;
    }

    public void setKaytossa(boolean kaytossa) {
        this.kaytossa = kaytossa;
    }
}
