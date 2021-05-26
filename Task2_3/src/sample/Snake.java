package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

class Snake
{
    private int posX;
    private int posY;
    private int posPrevX;
    private int posPrevY;
    public  Rectangle snakeBody = new Rectangle(24,24,Color.rgb(170, 255, 166));
    public  Rectangle snakeHead = new Rectangle(24,24,Color.rgb(176, 237, 145));

    Snake(int X, int Y)
    {
        posX = X;
        posY = Y;
        posPrevX = X;
        posPrevY = Y;
    }

    public void setPos(int X, int Y)
    {
        posPrevX =posX;
        posX = X;
        posPrevY =posY;
        posY =Y;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getPosPrevX() {
        return posPrevX;
    }

    public int getPosPrevY() {
        return posPrevY;
     }

}
