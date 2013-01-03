/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gladiaattorit.logiikka;

import java.util.ArrayList;

/**
 *
 * @author juusostr
 */
public class Areena {

    private Ruutu[][] areena;
    private Joukkue kotiJoukkue;
    private Joukkue vierasJoukkue;

    public Areena(Joukkue kotiJoukkue, Joukkue vierasJoukkue) {
        this.areena = new Ruutu[8][8];
        this.kotiJoukkue = kotiJoukkue;
        this.vierasJoukkue = vierasJoukkue;
        this.asetaRuudut();
        this.asetaJoukkueet();
    }
    
    private void asetaJoukkueet(){
        this.asetaJoukkue(vierasJoukkue, 0);
        this.asetaJoukkue(kotiJoukkue, 6);
    }
    
     private void asetaJoukkue(Joukkue asetettavaJoukkue,int alkuY){
        ArrayList<Gladiaattori> asetettavatGladiaattorit = new ArrayList<Gladiaattori>();
        for(Gladiaattori asetettava : asetettavaJoukkue.getGladiaattorit()) {
            asetettavatGladiaattorit.add(asetettava);
        }
        
        int gladiaattoreidenIteroija = 0;
        int areenanRivit = areena.length;
        
        if(alkuY == 0){
            areenanRivit = 2;
        }
        
        for (int y = alkuY; y < areenanRivit; y++) {
            for (int x = 2; x < areena[y].length - 2; x++) {
                areena[y][x].asetaGladiaattori(asetettavatGladiaattorit.get(gladiaattoreidenIteroija));
                gladiaattoreidenIteroija++;
            }
        }
    }

    private void asetaRuudut() {
        for (int y = 0; y < areena.length; y++) {
            for (int x = 0; x < areena[y].length; x++) {
                areena[y][x] = new Ruutu(y, x);
            }
        }
    }
    
    public Ruutu[][] getAreena() {
        return areena;
    }

    public Joukkue getKotiJoukkue() {
        return kotiJoukkue;
    }

    public Joukkue getVierasJoukkue() {
        return vierasJoukkue;
    }
    
    
}
