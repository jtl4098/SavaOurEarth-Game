package Assignment5;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * <pre>
 *     Program : KeyListener
 * @author : Taekyung.Kil
 * Date : 05/July/2019
 *
 * Purpose : To use keyboard
 * </pre>
 */
public class KeyListener extends KeyAdapter {


    // when press a keyboard, can use the methods
    @Override
    public void keyPressed(KeyEvent e){
        if(SaveOurEarth.game == null)
            return;
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            SaveOurEarth.game.pressLeft();

        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            SaveOurEarth.game.pressRight();
        }

        else if(e.getKeyCode() == KeyEvent.VK_UP){
            SaveOurEarth.game.pressUp();

        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            SaveOurEarth.game.pressDown();

        }


    }


}
