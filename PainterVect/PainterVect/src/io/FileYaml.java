package io;

import Model.Figure;

public class FileYaml implements IFileIO {
    private String filePath;

    public FileYaml(String filePath){
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
