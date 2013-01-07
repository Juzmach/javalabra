/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gladiaattorit.logiikka;

/**
 *
 * @author juzmach
 */
public enum Suunta {

    PELAAJANYLOS(-1, 0),
    PELAAJANALAS(1, 0),
    PELAAJANVASEN(0, -1),
    PELAAJANOIKEA(0, 1),
    VASTUSTAJANYLOS(1, 0),
    VASTUSTAJANALAS(-1, 0),
    VASTUSTAJANVASEN(0, -1),
    VASTUSTAJANOIKEA(0, 1);
    
    private final int y;
    private final int x;

    private Suunta(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
