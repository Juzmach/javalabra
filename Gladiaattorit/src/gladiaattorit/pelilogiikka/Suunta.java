/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gladiaattorit.pelilogiikka;

/**
 *
 * @author juzmach
 */
public enum Suunta {

    /**
     * "Koti"-pelaajan eteenpäin
     */
    KOTIETEEN(-1, 0),
    /**
     * "Koti"-pelaajan taaksepäin
     */
    KOTITAAKSE(1, 0),
    /**
     * "Koti"-pelaajan vasen
     */
    KOTIVASEN(0, -1),
    /**
     * "Koti"-pelaajan oikea
     */
    KOTIOIKEA(0, 1),
    /**
     * "Koti"-pelaajan etuvasen
     */
    KOTIETUVASEN(-1, -1),
    /**
     * "Koti"-pelaajan etuoikea
     */
    KOTIETUOIKEA(-1, 1),
    /**
     * "Koti"-pelaajan takavasen
     */
    KOTITAKAVASEN(1, -1),
    /**
     * "Koti"-pelaajan takaoikea
     */
    KOTITAKAOIKEA(1, 1),
    /**
     * "Vieras"-pelaajan eteenpäin
     */
    VIERASETEEN(1, 0),
    /**
     * "Vieras"-pelaajan taaksepäin
     */
    VIERASTAAKSE(-1, 0),
    /**
     * "Vieras"-pelaajan vasen
     */
    VIERASVASEN(0, -1),
    /**
     * "Vieras"-pelaajan oikea
     */
    VIERASOIKEA(0, 1),
    /**
     * "Vieras"-pelaajan etuvasen
     */
    VIERASETUVASEN(1, -1),
    /**
     * "Vieras"-pelaajan etuoikea
     */
    VIERASETUOIKEA(1, 1),
    /**
     * "Vieras"-pelaajan takavasen
     */
    VIERASTAKAVASEN(-1, -1),
    /**
     * "Vieras"-pelaajan takaoikea
     */
    VIERASTAKAOIKEA(-1, 1);
    
    /**
     * Suunnan Y-koordinaatin arvo, jolla määritetään gladiaattorin uusi ruutu
     * lisäämällä vanhan ruudun Y-koordinaatin arvoon
     */
    private final int y;
    /**
     * Suunnan X-koordinaatin arvo, jolla määritetään gladiaaattorin uusi ruutu
     * lisäämällä vanhan ruudun X-koordinaatin arvoon
     */
    private final int x;

    private Suunta(int y, int x) {
        this.y = y;
        this.x = x;
    }

    /**
     *
     * @return Suunnan X-koordinaatin arvo
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @return Suunnan Y-koordinaatin arvo
     */
    public int getY() {
        return y;
    }
}
