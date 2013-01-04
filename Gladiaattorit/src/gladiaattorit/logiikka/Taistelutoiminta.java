package gladiaattorit.logiikka;

/**
 *
 * @author juzmach
 */
public class Taistelutoiminta {

    private Areena areena;
    private int vuoroNumero;
    private Pelaaja pelaaja;
    private Pelaaja vastustaja;
    private String kenenVuoro;

    public Taistelutoiminta(String pelaajanNimi,String pelaajanJoukkueenNimi) {
        this.pelaaja = new Pelaaja(pelaajanNimi,pelaajanJoukkueenNimi);
        this.vastustaja = new Pelaaja("Hodor", "Hodorin Hurjat");
        this.areena = new Areena(pelaaja.getJoukkue(), vastustaja.getJoukkue());
        this.vuoroNumero = 0;
        this.kenenVuoro = "Pelaaja";
    }

    public Areena getAreena() {
        return areena;
    }

    public void liikutaGladiaattoria(Gladiaattori liikutettava, Suunta suunta) {
        if (this.kenenVuoro.equals("Pelaaja")) {
            pelaaja.liikuta(liikutettava, areena.getAreena()[liikutettava.getRuutu().getRuudunY() + suunta.getY()][liikutettava.getRuutu().getRuudunX() + suunta.getX()]);
        } else {
            vastustaja.liikuta(liikutettava, areena.getAreena()[liikutettava.getRuutu().getRuudunY() + suunta.getY()][liikutettava.getRuutu().getRuudunX() + suunta.getX()]);
        }
    }

    public void vuoro() {
    }

    public String getKenenVuoro() {
        return kenenVuoro;
    }

    private void vaihdaVuoroa() {
        this.vuoroNumero++;
        if (this.vuoroNumero % 2 == 0) {
            this.kenenVuoro = "Pelaaja";
        } else {
            this.kenenVuoro = "Vastustaja";
        }
    }

    public Pelaaja getPelaaja() {
        return pelaaja;
    }

    public Pelaaja getVastustaja() {
        return vastustaja;
    }

    public int getVuoroNumero() {
        return vuoroNumero;
    }
    
    
}
