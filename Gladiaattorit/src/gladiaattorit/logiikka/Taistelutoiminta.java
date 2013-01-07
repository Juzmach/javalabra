package gladiaattorit.logiikka;

/**
 *
 * @author juzmach
 */
public class Taistelutoiminta {

    private Areena areena;
    private int vuoroNumero;
    private Pelaaja koti;
    private Pelaaja vieras;
    private String kenenVuoro;

    public Taistelutoiminta(String kotiNimi, String kotiJoukkueenNimi, String vierasNimi, String vierasJoukkueenNimi) {
        this.koti = new Pelaaja(kotiNimi, kotiJoukkueenNimi);
        this.vieras = new Pelaaja(vierasNimi, vierasJoukkueenNimi);
        this.areena = new Areena(koti.getJoukkue(), vieras.getJoukkue());
        this.vuoroNumero = 0;
        this.kenenVuoro = "Koti";
    }

    public Areena getAreena() {
        return areena;
    }

    public void liikutaGladiaattoria(Gladiaattori liikutettava, Suunta suunta) {
        int uudenRuudunY = liikutettava.getRuutu().getRuudunY() + suunta.getY();
        int uudenRuudunX = liikutettava.getRuutu().getRuudunX() + suunta.getX();
        if (this.onkoRuutuAreenalla(uudenRuudunY,uudenRuudunX)) {
            if (this.kenenVuoro.equals("Koti")) {
                koti.liikuta(liikutettava, areena.getAreena()[uudenRuudunY][uudenRuudunX]);
            } else {
                vieras.liikuta(liikutettava, areena.getAreena()[uudenRuudunY][uudenRuudunX]);
            }
            this.vaihdaVuoroa();
        }
    }

    private boolean onkoRuutuAreenalla(int uudenRuudunY,int uudenRuudunX) {
        if (uudenRuudunY <= areena.getAreena().length -1 && uudenRuudunY >= 0 && uudenRuudunX <= areena.getAreena()[uudenRuudunY].length -1 && uudenRuudunX >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public String getKenenVuoro() {
        return kenenVuoro;
    }

    public void setKenenVuoro(String kenenVuoro) {
        this.kenenVuoro = kenenVuoro;
    }

    public Joukkue getVuorossaOlevaJoukkue() {
        if (kenenVuoro.equals("Koti")) {
            return koti.getJoukkue();
        } else {
            return vieras.getJoukkue();
        }
    }

    private void vaihdaVuoroa() {
        this.vuoroNumero++;
        if (this.vuoroNumero % 2 == 0) {
            this.kenenVuoro = "Koti";
        } else {
            this.kenenVuoro = "Vieras";
        }
    }

    public Pelaaja getKoti() {
        return koti;
    }

    public Pelaaja getVieras() {
        return vieras;
    }

    public int getVuoroNumero() {
        return vuoroNumero;
    }
}
