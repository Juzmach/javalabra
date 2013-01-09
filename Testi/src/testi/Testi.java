/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testi;

/**
 *
 * @author juzmach
 */
public class Testi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String komento = "LIIKU      ANSSI        TAKAVASEN";
        
        String[] osat = komento.split("\\s+");
        
        System.out.println(osat[0]);
        System.out.println(osat[1]);
        System.out.println(osat[2]);
    }
}
