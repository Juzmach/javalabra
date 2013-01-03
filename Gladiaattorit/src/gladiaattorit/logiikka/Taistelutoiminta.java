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

    public Taistelutoiminta(Pelaaja pelaaja, Pelaaja vastustaja) {
        this.areena = new Areena(pelaaja.getJoukkue(), vastustaja.getJoukkue());
        this.vuoroNumero = 0;
        this.pelaaja = pelaaja;
        this.vastustaja = vastustaja;
        this.kenenVuoro = "Pelaaja";
    }

    public Areena getAreena() {
        return areena;
    }
    
    public void liikutaGladiaattoria(){
        
    }

    public String getKenenVuoro() {
        return kenenVuoro;
    }
    
    private void vaihdaVuoroa(){
        this.vuoroNumero++;
        if(this.vuoroNumero % 2 == 0){
            this.kenenVuoro = "Pelaaja";
        } else {
            this.kenenVuoro = "Vastustaja";
        }
    }
    
}
