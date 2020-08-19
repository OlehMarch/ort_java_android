package io;

import Model.Figure;

    public interface IFileIO {
    void saveState(Iterable<Figure> figures);
    Iterable<Figure> loadState();
}
