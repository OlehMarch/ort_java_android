package Utils;

import java.awt.Color;

public class xData {
	private int width;
	private EnumFigureType type;
	private Color color;

	public xData(xData dataToCopy)
	{
		this.color = dataToCopy.color;
		this.width = dataToCopy.width;
		this.type = dataToCopy.type;

		//this.xPoints = dataToCopy.xPoints;
		//this.yPoints = dataToCopy.yPoints;
		//this.nPoints = dataToCopy.nPoints;
	}
	public xData() {
		width = 2;
		color = Color.black;
		type = EnumFigureType.Line;
	}

	public xData(int width, Color color, EnumFigureType type) {
		this.type = type;
		this.width = width;
		this.color = color;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public EnumFigureType getType() {
		return type;
	}

	public void setType(EnumFigureType type) {
		this.type = type;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}

