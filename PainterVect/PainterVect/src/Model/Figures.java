package Model;

import java.util.ArrayList;
import java.util.List;

public class Figures {
    public Figures()
    {
        super();
        figures = new ArrayList<Figure>();
    }

    private List<Figure> figures;

    public void setFigures(List<Figure> figures) {
        this.figures = figures;
    }

    public List<Figure> getFigures() {
        return figures;
    }


}
