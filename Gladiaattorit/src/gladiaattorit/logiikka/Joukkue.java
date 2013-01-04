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

    public int getJoukkueenKoko() {
        if (gladiaattorit.isEmpty()) {
            return 0;
        }
        return gladiaattorit.size();
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
    
    public Gladiaattori haeGladiaattori(int peliNumero){
        if (!gladiaattorit.isEmpty()) {
            for (Gladiaattori gladiaattori : this.gladiaattorit) {
                if (gladiaattori.getPeliNumero() == peliNumero) {
                    return gladiaattori;
                }
            }
        }
        return null;
    }

    public List<Gladiaattori> getGladiaattorit() {
        return gladiaattorit;
    }

    @Override
    public String toString() {
        String tuloste = this.nimi + "\n";
        for (Gladiaattori gladiaattori : gladiaattorit) {
            tuloste += gladiaattori.toString() + "\n";
        }
        return tuloste;
    }
}
