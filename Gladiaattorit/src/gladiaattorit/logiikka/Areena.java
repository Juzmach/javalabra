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
    private Gladiaattori[][] areena;

    public Areena() {
        this.areena = new Gladiaattori[16][8];
    }

    public Gladiaattori[][] getAreena() {
        return areena;
    }
    
}
