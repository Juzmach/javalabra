package gladiaattorit.logiikka;

/**
 *
 * @author juzmach
 */
public class Gladiaattori {
    private String nimi;
    private int voima;
    private int nopeus;
    private int alykkyys;

    public Gladiaattori(String nimi) {
        this.nimi = nimi;
        this.voima = 5;
        this.nopeus = 5;
        this.alykkyys = 5;
    }

    public String getNimi() {
        return nimi;
    }

    @Override
    public String toString() {
        return nimi + "[" + voima + "," + nopeus + "," + alykkyys + "]";
    }
    
    
    
}
