package testi;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 *
 * @author juzmach
 */
public class KuuntelijanTestaus implements KeyListener{

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
   
}
