package gladiaattorit.pelilogiikka;

/**
 *
 * @author juzmach
 */
public class Taistelupeli {

    /**
     * Taistelupelin Areena-olio
     */
    private Areena areena;
    /**
     * Vuoronumero
     */
    private int vuoroNumero;
    /**
     * "Koti"-pelaajan olio
     */
    private Pelaaja koti;
    /**
     * "Vieras"-pelaajan olio
     */
    private Pelaaja vieras;
    /**
     * Kumman vuoro kyseessä. Joko "Koti" tai "Vieras"
     */
    private String kenenVuoro;
    private boolean peliAlkanut;
    private boolean kotijoukkueLuotu;
    private boolean vierasjoukkueLuotu;

    /**
     *
     * @param kotiNimi "Koti"-pelaajan nimi
     * @param kotiJoukkueenNimi kotijoukkueen nimi
     * @param vierasNimi "Vieras"-pelaajan nimi
     * @param vierasJoukkueenNimi vierasjoukkueen nimi
     */
    public Taistelupeli(Pelaaja koti, Pelaaja vieras) {
        this();
        this.koti = koti;
        this.vieras = vieras;
    }

    public Taistelupeli() {
        this.areena = new Areena();
        this.vuoroNumero = 0;
        this.kenenVuoro = "Koti";
        this.peliAlkanut = false;
        this.kotijoukkueLuotu = false;
        this.vierasjoukkueLuotu = false;
    }

    public void setKoti(Pelaaja koti) {
        this.koti = koti;
        this.kotijoukkueLuotu = true;
    }

    public void setVieras(Pelaaja vieras) {
        this.vieras = vieras;
        this.vierasjoukkueLuotu = true;
    }

    public boolean isPeliAlkanut() {
        return peliAlkanut;
    }

    public boolean isKotijoukkueLuotu() {
        return kotijoukkueLuotu;
    }

    public boolean isVierasjoukkueLuotu() {
        return vierasjoukkueLuotu;
    }

    public void setPeliAlkanut(boolean peliAlkanut) {
        if (kotijoukkueLuotu && vierasjoukkueLuotu) {
            this.peliAlkanut = peliAlkanut;
        }
    }

    /**
     *
     * @return Taistelupelin Areena-olio
     */
    public Areena getAreena() {
        return areena;
    }

    /**
     * Liikuttaa gladiaattoria käyttäen Pelaaja-luokan
     * liikuta(Gladiaattori,Ruutu)-metodia, jos peli ei ole päättynyt.
     * Gladiaattorin uusi ruutu saadaan lisäämällä oikean Suunta-olion
     * sisältämät muutosarvot vanhan ruudun koordinaatteihin.
     *
     * @param liikutettava Liikutettava gladiaattori
     * @param suunta Suunta-olio, jolla määritetään uuden ruudun sijainti
     */
    public void liikuta(Gladiaattori liikutettava, Suunta suunta) {
        int uudenRuudunY = liikutettava.getRuutu().getRuudunY() + suunta.getY();
        int uudenRuudunX = liikutettava.getRuutu().getRuudunX() + suunta.getX();
        this.liikuta(liikutettava, uudenRuudunY, uudenRuudunX);
    }

    /**
     * Liikuttaa gladiaattoria käyttäen Pelaaja-luokan liikuta(Gladiaattori
     * liikutettava, int y, int x)-metodia
     *
     * @param liikutettava Liikutettava gladiaattori
     * @param y Uuden ruudun y-koordinaatti
     * @param x Uuden ruudun x-koordinaatti
     */
    public void liikuta(Gladiaattori liikutettava, int y, int x) {
        if (!this.onkoPeliPaattynyt()) {

            if (this.onkoRuutuAreenalla(y, x)) {
                if (this.kenenVuoro.equals("Koti")) {
                    koti.liikuta(liikutettava, areena.getAreena()[y][x]);
                } else {
                    vieras.liikuta(liikutettava, areena.getAreena()[y][x]);
                }
                this.vaihdaVuoroa();
            }
        }
    }

    public void asetaJoukkueetAreenalle() {
        areena.asetaJoukkueet(koti.getJoukkue(), vieras.getJoukkue());
    }

    /**
     * Tarkistaa onko uusi ruutu areenan reunojen sisäpuolella
     *
     * @param uudenRuudunY Uuden ruudun Y-koordinaatti
     * @param uudenRuudunX Uuden ruudun X-koordinaatti
     * @return palauttaa true, jos on sisäpuolella. False, jos ei.
     */
    private boolean onkoRuutuAreenalla(int uudenRuudunY, int uudenRuudunX) {
        if (uudenRuudunY <= areena.getAreena().length - 1 && uudenRuudunY >= 0 && uudenRuudunX <= areena.getAreena()[uudenRuudunY].length - 1 && uudenRuudunX >= 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @return Kenen vuoro on kyseessä
     */
    public String getKenenVuoro() {
        return kenenVuoro;
    }

    /**
     *
     * @param kenenVuoro Asettaa suoraan vuoron jommalle kummalle
     */
    public void setKenenVuoro(String kenenVuoro) {
        if (kenenVuoro.equals("Koti") || kenenVuoro.equals("Vieras")) {
            this.kenenVuoro = kenenVuoro;
        }
    }

    /**
     *
     * @return Vuorossa olevan joukkueen olio
     */
    public Joukkue getVuorossaOlevaJoukkue() {
        if (kenenVuoro.equals("Koti")) {
            return koti.getJoukkue();
        } else {
            return vieras.getJoukkue();
        }
    }

    /**
     * Vaihtaa vuoroa käyttäen vuoronumeron jakojäännöstä
     */
    private void vaihdaVuoroa() {
        this.vuoroNumero++;
        if (this.vuoroNumero % 2 == 0) {
            this.kenenVuoro = "Koti";
        } else {
            this.kenenVuoro = "Vieras";
        }
    }

    /**
     *
     * @return Voittajajoukkueen Joukkue-olio
     */
    public Joukkue getVoittajaJoukkue() {
        if (this.onkoPeliPaattynyt()) {
            return this.getVuorossaOlevaJoukkue();
        } else {
            return null;
        }
    }

    /**
     *
     * @return boolean-arvo, joka kertoo onko peli päättynyt
     */
    public boolean onkoPeliPaattynyt() {
        if (koti.getJoukkue().onkoJoukkueKuollut() || vieras.getJoukkue().onkoJoukkueKuollut()) {
            return true;
        }
        return false;
    }

    /**
     *
     * @return "Koti"-pelaajan olio
     */
    public Pelaaja getKoti() {
        return koti;
    }

    /**
     *
     * @return "Vieras"-pelaajan olio
     */
    public Pelaaja getVieras() {
        return vieras;
    }

    /**
     *
     * @return Vuoronumero
     */
    public int getVuoroNumero() {
        return vuoroNumero;
    }
}
