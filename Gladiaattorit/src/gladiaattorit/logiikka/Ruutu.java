package gladiaattorit.logiikka;

/**
 *
 * @author juzmach
 */
public class Ruutu {

    private Gladiaattori gladiaattori;
    private boolean kaytossa;
    private final Ruutu[] naapurit;
    private int ruudunX;
    private int ruudunY;

    public Ruutu(Ruutu[][] areena, int y, int x) {
        this.gladiaattori = null;
        this.kaytossa = false;
        this.ruudunX = x;
        this.ruudunY = y;
        this.naapurit = asetaNaapurit(areena);
    }

    private Ruutu[] asetaNaapurit(Ruutu[][] areena) {
        Ruutu[] haetutNaapurit = new Ruutu[this.naapureidenLukumaara()];
        for (int y = 0; y < areena.length; y++) {
            for (int x = 0; x < areena[y].length; x++) {
            }
        }
        return haetutNaapurit;
    }

    private int naapureidenLukumaara() {
        if ((ruudunX == 0 && ruudunY == 0) || (ruudunX == 6 && ruudunY == 0)
                || (ruudunX == 0 && ruudunY == 7) || (ruudunX == 6 && ruudunY == 7)) {
            return 3;
        }
        return 0;
    }

    private boolean onkoVieressa(int verrattavanX, int verrattavanY) {
        if ((this.ruudunX + 1) == verrattavanX && this.ruudunY == verrattavanY) {
        }
        return false;
    }

    public void asetaGladiaattori(Gladiaattori asetettava) {
        if (this.kaytossa == false) {
            this.gladiaattori = asetettava;
            this.kaytossa = true;
        }
    }

    public Gladiaattori getGladiaattori() {
        return gladiaattori;
    }

    public boolean isKaytossa() {
        return kaytossa;
    }
}
