package Assignment5;

import java.awt.*;

/**
 * <pre>
 *     Program : Star
 * @author : Taekyung.Kil
 * Date : 05/July/2019
 *
 * Purpose : Draw Stars , Set all Stars , Set eatStar method
 * </pre>
 */
public class Star {

    private int xCoor, yCoor, width, height;
    private int SC;

    public Star(int xCoor, int yCoor, int size){
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        width = size;
        height = size;

    }


    public void screenDraw(Graphics g) {

       g.setColor(Color.RED);
       g.fillRect(xCoor, yCoor, width, height);




    }

    /**
     * To destroy stars
     * When the aircraft touch the star, the star disappear(move outside of the screen)
     * star's x coordinate and y coordinate and the aircraft x and y coordinate should be same.
     */
    public void eatStar(){

            if(xCoor == SaveOurEarth.game.getX() && yCoor == SaveOurEarth.game.getY() ){
                this.xCoor = 500;
                SC += 1;
        }
    }

    // To get score
    public int getSC(){
        return SC;
    }

    public int getxCoor(){
        return xCoor;
    }

    public void setxCoor(int xCoor){
        this.xCoor = xCoor;
    }

    public int getyCoor(){
        return yCoor;
    }

    public void setyCoor(int yCoor){
        this.yCoor = yCoor;
    }
}
