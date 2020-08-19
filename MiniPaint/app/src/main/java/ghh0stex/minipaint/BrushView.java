package ghh0stex.minipaint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;


public class BrushView extends View
{
    private int maxPointerQuantity;
    private Paint canvasPaint;
    private Canvas drawCanvas;
    private Bitmap canvasBitmap;
    private SparseArray<Path> paths;
    private SparseArray<Paint> brushes;

    public BrushView(Context context)
    {
        super(context);

        paths = new SparseArray<>();
        brushes = new SparseArray<>();
        canvasPaint = new Paint(Paint.DITHER_FLAG);

        setBrushes(0, Color.BLACK);
        setBrushes(1, Color.RED);
        setBrushes(2, Color.GREEN);
        setBrushes(3, Color.BLUE);
        setBrushes(4, Color.YELLOW);
        setBrushes(5, Color.MAGENTA);
        setBrushes(6, Color.GRAY);
        setBrushes(7, Color.LTGRAY);
        setBrushes(8, Color.DKGRAY);
        setBrushes(9, Color.rgb(255, 80, 80));

        maxPointerQuantity = 10;
    }

    private void setBrushes(int id, int color)
    {
        Paint brush = new Paint();
        brush.setAntiAlias(true);
        brush.setColor(color);
        brush.setStyle(Paint.Style.STROKE);
        brush.setStrokeJoin(Paint.Join.ROUND);
        brush.setStrokeWidth(10f);

        brushes.put(id, brush);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        drawCanvas = new Canvas(canvasBitmap);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        canvas.drawBitmap(canvasBitmap, 0, 0, canvasPaint);
        for (int i = 0; i < paths.size(); i++)
        {
            canvas.drawPath(paths.valueAt(i), brushes.valueAt(i));
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int index = event.getActionIndex();
        int id = event.getPointerId(index);

        Path path;
        switch (event.getActionMasked())
        {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_POINTER_DOWN:
                path = new Path();
                path.moveTo(event.getX(index), event.getY(index));
                paths.put(id, path);
                break;

            case MotionEvent.ACTION_MOVE:
                for (int i = 0; i < event.getPointerCount() && i < maxPointerQuantity; i++)
                {
                    id = event.getPointerId(i);
                    path = paths.get(id);
                    if (path != null)
                    {
                        path.lineTo(event.getX(i), event.getY(i));
                    }
                }
                break;

            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
                path = paths.get(id);
                if (path != null)
                {
                    drawCanvas.drawPath(path, brushes.valueAt(id));
                    paths.remove(id);
                }
                break;

            default:
                return false;
        }

        invalidate();
        return true;
    }

}