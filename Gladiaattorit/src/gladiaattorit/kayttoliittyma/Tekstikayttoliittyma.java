
package gladiaattorit.kayttoliittyma;

import gladiaattorit.logiikka.Areena;
import gladiaattorit.logiikka.Gladiaattori;
import gladiaattorit.logiikka.Joukkue;
import java.util.Scanner;

/**
 *
 * @author juzmach
 */
public class Tekstikayttoliittyma {
    private Areena areena;
    private Scanner lukija;
    
    public Tekstikayttoliittyma(Scanner lukija) {
        this.lukija = lukija;
        this.areena = new Areena(this.luoJoukkue("Koti"),this.luoJoukkue("Vieras"));
        
    }
    
    public void kaynnista(){
        this.tulostaKomennot();
        
        while(true){
            String komento = lukija.nextLine();
            if(komento.toUpperCase().equals("X")){
                break;
            }
            if(komento.toUpperCase().equals("Y")){
                this.tulostaKomennot();
            }
            if(komento.equals("1")){
                this.tulostaAreena();
            }
            if(komento.equals("2")){
                this.tulostaJoukkue();
            }
        }
    }
    
    private Joukkue luoJoukkue(String nimi){
        Joukkue joukkue = new Joukkue(nimi);
        for (int i = 0; i < 8; i++) {
            joukkue.lisaaGladiaattori(new Gladiaattori("Unit " + i));
        }
        return joukkue;
    }
    
    private void tulostaKomennot(){
        System.out.println("X - Lopettaa pelin");
        System.out.println("Y - Tulostaa komennot");
        System.out.println("1 - Tulosta areena");
        System.out.println("2 - Tulosta joukkue");
    }
    
    private void tulostaJoukkue(){
        while(true){
        System.out.println("Mikä joukkue? (Koti: 1, Vieras: 2, Kaikki: X)");
        String vaihtoehto = lukija.nextLine();
        if(vaihtoehto.equals("1")){
            System.out.println(areena.getKotiJoukkue());
            break;
        }
        else if(vaihtoehto.equals("2")){
            System.out.println(areena.getVierasJoukkue());
            break;
        }
        else if(vaihtoehto.equals("X")){
            System.out.println(areena.getKotiJoukkue());
            System.out.println(areena.getVierasJoukkue());
            break;
        }
        else {
            System.out.println("Väärä komento!");
        }
        }
    }
    
    private void tulostaAreena(){
        for (int y = 0; y < areena.getAreena().length; y++) {
            for (int x = 0; x < areena.getAreena()[y].length; x++) {
                if(areena.getAreena()[y][x].isKaytossa()){
                    System.out.print("[X]");
                } else {
                    System.out.print("[ ]");
                }
            }
            System.out.println("");
        }
    }
    
}
