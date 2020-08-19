package ghh0stex.bubblepainter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.LinkedList;

public class MovementView extends SurfaceView implements SurfaceHolder.Callback
{
    LinkedList<Ball> balls = new LinkedList<Ball>();
    private int width;
    private int height;
    private Paint circlePaint;
    private UpdateThread updateThread;
    private boolean _ballAdded = false;


    public MovementView(Context context)
    {

        super(context);
        getHolder().addCallback(this);

        circlePaint = new Paint();
        circlePaint.setColor(Color.BLUE);

        balls.add(new Ball(100, 100));
    }

    protected void ondraw(Canvas canvas)
    {
        canvas.drawColor(Color.WHITE);

        int size = balls.size();
        if (!_ballAdded)
        {
            size--;
        }

        for (int i = 0; i < size; ++i)
        {
            canvas.drawCircle(balls.get(i).posX, balls.get(i).posY, balls.get(i).width, circlePaint);
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                _ballAdded = false;
                balls.add(new Ball(event.getX(), event.getY()));
                break;
            case MotionEvent.ACTION_UP:
                balls.get(balls.size() - 1).SetDirectionVector(event.getX(), event.getY());
                _ballAdded = true;
                break;

            default:
                return false;
        }

        invalidate();
        return true;
    }

    public void updatePhysics()
    {
        for (int i = 0; i < balls.size(); ++i)
        {
            balls.get(i).posX += balls.get(i).dx;
            balls.get(i).posY += balls.get(i).dy;

            float posX = balls.get(i).posX;
            float posY = balls.get(i).posY;
            int w = balls.get(i).width;

            if (posX - w <= 0 || posX + w >= width)
            {
                balls.get(i).dx = -balls.get(i).dx;
            }
            if (posY - w <= 0 || posY + w >= height)
            {
                balls.get(i).dy = -balls.get(i).dy;
            }
        }
    }

    public void surfaceCreated(SurfaceHolder holder) {

        Rect surfaceFrame = holder.getSurfaceFrame();
        width = surfaceFrame.width();
        height = surfaceFrame.height();

        updateThread = new UpdateThread(this);
        updateThread.setRunning(true);
        updateThread.start();
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) { }

    public void surfaceDestroyed(SurfaceHolder holder)
    {
        boolean retry = true;
        updateThread.setRunning(false);
        while (retry)
        {
            try
            {
                updateThread.join();
                retry = false;
            }
            catch (InterruptedException e) { }
        }
    }

}