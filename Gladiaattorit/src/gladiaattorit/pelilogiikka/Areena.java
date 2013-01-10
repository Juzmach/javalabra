/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gladiaattorit.pelilogiikka;

import java.util.ArrayList;

/**
 *
 * @author juusostr
 */
public class Areena {

    /**
     * Kaksiulotteinen taulukko, jossa areenan Ruutu-oliot
     */
    private Ruutu[][] areena;
    /**
     * "Koti"-pelaajan joukkue
     */
    private Joukkue kotiJoukkue;
    /**
     * "Vieras"-pelaajan joukkue
     */
    private Joukkue vierasJoukkue;

    /**
     *
     * @param kotiJoukkue "Kotijoukkueena" pelaavan pelaajan joukkue
     * @param vierasJoukkue "Vierasjoukkueena" pelaavan pelaajan joukkue
     */
    public Areena(Joukkue kotiJoukkue,Joukkue vierasJoukkue) {
        this();
        this.asetaJoukkueet(kotiJoukkue, vierasJoukkue);
        
    }

    public Areena() {
       this.areena = new Ruutu[8][8];
       this.asetaRuudut();
    }
    
    

    /**
     * Asettaa molemmat joukkueet areenalle käyttäen asetaJoukkue(Joukkue, int)
     * metodia.
     */
    public void asetaJoukkueet(Joukkue kotiJoukkue,Joukkue vierasJoukkue) {
        this.kotiJoukkue = kotiJoukkue;
        this.vierasJoukkue = vierasJoukkue;
        this.asetaJoukkue(vierasJoukkue, 0, 2);
        this.asetaJoukkue(kotiJoukkue, 6, 2);
    }

    /**
     * Asettaa yhden joukkueen gladiaattorit oikeisiin ruutuihin. Jos kyseessä
     * on kotijoukkue, asettaa se gladiaattorit areenan alareunaan. Jos on
     * vierasjoukkue, asettaa se gladiaattorit yläreunaan.
     *
     * @param asetettavaJoukkue Asetettava joukkue
     * @param alkuY Joukkueen ensimmäisen rivin määrittävä apumetodi
     */
    private void asetaJoukkue(Joukkue asetettavaJoukkue, int alkuY, int alkuX) {
        int y = alkuY;
        int x = alkuX;
        for (Gladiaattori asetettava : asetettavaJoukkue.getGladiaattorit()) {
            if (y <= areena.length - 1 && x <= areena[y].length) {
                areena[y][x].asetaGladiaattori(asetettava);
                x++;
                if (x > areena[y].length - 3) {
                    x = alkuX;
                    y++;
                }
            }
        }

//        ArrayList<Gladiaattori> asetettavatGladiaattorit = new ArrayList<Gladiaattori>();
//        for (Gladiaattori asetettava : asetettavaJoukkue.getGladiaattorit()) {
//            asetettavatGladiaattorit.add(asetettava);
//        }

//        int gladiaattoreidenIteroija = 0;
//        int areenanRivit = areena.length;
//
//        if (alkuY == 0) {
//            areenanRivit = 2;
//        }
//
//        for (int y = alkuY; y < areenanRivit; y++) {
//            for (int x = 2; x < areena[y].length - 2; x++) {
//                areena[y][x].asetaGladiaattori(asetettavatGladiaattorit.get(gladiaattoreidenIteroija));
//                gladiaattoreidenIteroija++;
//            }
//        }
    }

    /**
     * Alustaa kaksiulotteisen Ruutu-taulukon Ruutu-oliot.
     */
    private void asetaRuudut() {
        for (int y = 0; y < areena.length; y++) {
            for (int x = 0; x < areena[y].length; x++) {
                areena[y][x] = new Ruutu(y, x);
            }
        }
    }

    /**
     *
     * @return Kaksiulotteisen taulukon, jossa Ruutu-olioita.
     */
    public Ruutu[][] getAreena() {
        return areena;
    }

    /**
     *
     * @return Kotijoukkueen Joukkue-olion.
     */
    public Joukkue getKotiJoukkue() {
        return kotiJoukkue;
    }

    /**
     *
     * @return Vierasjoukkueen Vieras-olion.
     */
    public Joukkue getVierasJoukkue() {
        return vierasJoukkue;
    }
}
