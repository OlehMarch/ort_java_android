package mainSource;
import java.awt.Dimension;

import canvasLayer.CanvasLayer;

public class MainProgram {

	public static void main(String[] args)
	{
		CanvasLayer layer = new CanvasLayer("Calculator1.0", 100, 100, 285, 310);
		Dimension minimumSize = new Dimension(285, 310);
		layer.setMinimumSize(minimumSize);
	}

}
