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
    YLOS (1,0),
    ALAS (-1,0),
    VASEN(0,-1),
    OIKEA(0,1);
    
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
