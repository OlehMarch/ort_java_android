package Model;

import Utils.xData;

import java.awt.*;

public class Figure {
    private Rectangle rect;
    private xData data;

    public Figure() {
        super();
    }

    public Figure(Rectangle rect, xData data) {
        super();
        this.rect = rect;
        this.data = data;
    }

    public Rectangle getRect() {
        return rect;
    }

    public void setRect(Rectangle rect) {
        this.rect = rect;
    }

    public xData getData() {
        return data;
    }

    public void setData(xData data) {
        this.data = data;
    }

    public Figure getCopy(){return new Figure(rect, new xData(data));}


}