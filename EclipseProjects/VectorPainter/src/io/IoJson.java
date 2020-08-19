package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

import com.google.gson.Gson;

import memento.Figure;

public class IoJson implements ISavable {

	private String filePath;
	
	public IoJson(String filePath){
		this.filePath = filePath;
	}
	
	@Override
	public void saveState(Iterable<Figure> figures) {
		
		Gson parser = new Gson();
		String gsonStr = parser.toJson(figures);
		
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(filePath, "UTF-8");
			writer.println(gsonStr);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally {
			 writer.close();
		}
	}

	@Override
	public Iterable<Figure> loadState() {
		
		ArrayList<Figure> figures = new ArrayList<Figure>();
		String gsonLine = null;
		  try {
	            FileReader fileReader = 
	                new FileReader(filePath);

	            BufferedReader bufferedReader = 
	                new BufferedReader(fileReader);
	            String readLine = null;
	            
	            while((readLine = bufferedReader.readLine()) != null) {
	            	
	            	gsonLine = readLine; 
	            }   

	            bufferedReader.close();         
	        }
	        catch(Exception ex) {
	        	ex.printStackTrace();
	        }
		  
		  Gson parser = new Gson();
		  Figure[] arrFigures = parser.fromJson(gsonLine, Figure[].class);
		  figures = (ArrayList<Figure>) Arrays.asList(arrFigures);

		  return figures;
	}

}
