package gladiaattorit.logiikka;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juzmach
 */
public class Joukkue {

    private String nimi;
    private List<Gladiaattori> gladiaattorit;

    public Joukkue(String nimi) {
        this.nimi = nimi;
        this.gladiaattorit = new ArrayList<Gladiaattori>();
    }

    public String getNimi() {
        return nimi;
    }

    public void lisaaGladiaattori(Gladiaattori lisattava) {
        if (!this.gladiaattorit.contains(lisattava)) {
            this.gladiaattorit.add(lisattava);
        }
    }

    public Gladiaattori haeGladiaattori(String gladiaattorinNimi) {
        if (!gladiaattorit.isEmpty()) {
            for (Gladiaattori gladiaattori : this.gladiaattorit) {
                if (gladiaattori.getNimi().equals(gladiaattorinNimi)) {
                    return gladiaattori;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String tuloste = "";
        for (Gladiaattori gladiaattori : gladiaattorit) {
            tuloste += gladiaattori.toString() + "\n";
        }
        return tuloste;
    }
    
    
}
