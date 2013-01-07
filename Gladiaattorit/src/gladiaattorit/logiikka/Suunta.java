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

    KOTIETEEN(-1, 0),
    KOTITAAKSE(1, 0),
    KOTIVASEN(0, -1),
    KOTIOIKEA(0, 1),
    KOTIETUVASEN(-1, -1),
    KOTIETUOIKEA(-1, 1),
    KOTITAKAVASEN(1, -1),
    KOTITAKAOIKEA(1, 1),
    VIERASETEEN(1, 0),
    VIERASTAAKSE(-1, 0),
    VIERASVASEN(0, -1),
    VIERASOIKEA(0, 1),
    VIERASETUVASEN(1, -1),
    VIERASETUOIKEA(1, 1),
    VIERASTAKAVASEN(-1, -1),
    VIERASTAKAOIKEA(-1, 1);
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
