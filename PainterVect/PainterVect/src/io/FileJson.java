package io;

import Model.Figure;
import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;

public class FileJson implements IFileIO {

    private String filePath;

    public FileJson(String filePath){
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
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e) {
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
            FileReader fileReader = new FileReader(filePath);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String readLine = null;

            while((readLine = bufferedReader.readLine()) != null) {
                gsonLine = readLine;
            }
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + filePath + "'");
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + filePath + "'");
        }

        Gson parser = new Gson();
        Figure[] arrFigures = parser.fromJson(gsonLine, Figure[].class);

        for (Figure f : arrFigures){
            figures.add(f);
        }
        return figures;
    }
}
