package io;

import Model.Figure;

public class FileXml implements IFileIO {
    private String filePath;

    public FileXml(String filePath){
        this.filePath = filePath;
    }
    @Override
    public void saveState(Iterable<Figure> figures) {

    }

    @Override
    public Iterable<Figure> loadState() {
        return null;
    }
}
