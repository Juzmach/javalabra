package gladiaattorit.logiikka;

/**
 *
 * @author juzmach
 */
public class Gladiaattori {

    private String nimi;
    private int voima;
    private int energia;
    private boolean elossa;

    public Gladiaattori(String nimi) {
        this.nimi = nimi;
        this.voima = 5;
        this.energia = 10;
        this.elossa = true;
    }

    public String getNimi() {
        return nimi;
    }

    public boolean isElossa() {
        return elossa;
    }

    public int getEnergia() {
        return energia;
    }

    @Override
    public String toString() {
        return nimi + "[" + "voima: " + voima + ", " + "energia: " + energia + "]";
    }

    public void vahennaEnergiaa(int maara) {
        if ((this.energia -= maara) <= 0) {
            this.energia = 0;
            this.elossa = false;

        } else {
            this.energia -= maara;
        }

    }
}
