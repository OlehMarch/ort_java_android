package mainSource;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import canvasLayer.CanvasLayer;

public class MainProgram {

	public static void main(String[] args) {
		
		CanvasLayer canvas = new CanvasLayer("Painter", 50, 50, 400, 500);
	}
}