package io;

import Model.Figure;

public class FileCsv implements  IFileIO{
    private String filePath;

    public FileCsv(String filePath){
        this.filePath = filePath;
    }

    @Override
    public void saveState(Iterable<Figure> figures) {}

    @Override
    public Iterable<Figure> loadState() {
        return null;
    }
}
