/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gladiaattorit.logiikka;

/**
 *
 * @author juusostr
 */
public class Areena {

    private Ruutu[][] areena;
    private Joukkue kotiJoukkue;
    private Joukkue vierasJoukkue;

    public Areena(Joukkue kotiJoukkue, Joukkue vierasJoukkue) {
        this.areena = new Ruutu[8][7];
        this.kotiJoukkue = kotiJoukkue;
        this.vierasJoukkue = vierasJoukkue;
        this.asetaRuudut();
    }

    private void asetaRuudut() {
        for (int y = 0; y < areena.length; y++) {
            for (int x = 0; x < areena[y].length; x++) {
                areena[y][x] = new Ruutu(areena,y,x);
            }
        }
    }

    public Ruutu[][] getAreena() {
        return areena;
    }
}
