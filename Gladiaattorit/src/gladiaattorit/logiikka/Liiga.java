package gladiaattorit.logiikka;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juusostr
 */
// TÄMÄ LUOKKA EI OLE VIELÄ KÄYTÖSSÄ
public class Liiga {

    private List<Joukkue> joukkueet;

    public Liiga() {
        this.joukkueet = new ArrayList<Joukkue>();
    }

    public void lisaaJoukkue(Joukkue joukkue) {
        if (!this.joukkueet.contains(joukkue)) {
            joukkueet.add(joukkue);
        }
    }

    public Joukkue haeJoukkue(String joukkueenNimi) {
        if (!this.joukkueet.isEmpty()) {
            for (Joukkue joukkue : joukkueet) {
                if (joukkue.getNimi().equals(joukkueenNimi)) {
                    return joukkue;
                }
            }
        }
        return null;
    }
}
