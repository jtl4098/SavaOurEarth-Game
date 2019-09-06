package Assignment5;

import javax.swing.*;
import java.awt.*;

/**
 * <pre>
 *     Program : Game
 * @author : Taekyung.Kil
 * Date : 05/July/2019
 *
 * Purpose : Set aircraft, key methods
 * </pre>
 */
public class Game extends  Thread{

  //set aircraft
  private Image aircraft = new ImageIcon(Main.class.getResource("fighter.png")).getImage();

  private int x = 220;
  private int y = 550;

  public Game() {
  }
  // get x value
  public int getX(){
    return x;
  }
  // get y value
  public int getY(){
    return y;
  }

  /**
   * set key methods
   */
  public void pressLeft(){

    x = x - 5;

  }
  public void pressRight(){

    x = x + 5;

  }

  public void pressUp(){
    y = y - 5;
  }
  public void pressDown(){
    y = y + 5;
  }

  // draw aircraft
  public void screenDraw(Graphics2D g) {

    g.drawImage(aircraft, x, y, null);

  }

}



