package ghh0stex.bubblepainter;

/**
 * Created by GHhos on 13.12.2016.
 */

public class Ball
{
    public int width;
    public float posX;
    public float posY;
    public float dx;
    public float dy;
    public int speed;


    public Ball()
    {
        width = 30;
        posX = 0;
        posY = 0;
        dx = 10;
        dy = 10;
        speed = 10;
    }

    public Ball(float x, float y)
    {
        width = 30;
        posX = x;
        posY = y;
        dx = 10;
        dy = 10;
        speed = 10;
    }

    public void SetDirectionVector(float x, float y)
    {
        dx = (x - posX) / speed;
        dy = (y - posY) / speed;
    }
}
