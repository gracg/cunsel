package nl.capite.cunsel.models;

import nl.capite.cunsel.interfaces.GenericIdInterface;

import java.util.List;

public class syncGenericResult <T extends GenericIdInterface> {
    private final List<T> insertables;
    private final List<T> updateables;
    private final List<String> deleteables;

    public syncGenericResult(List<T> insertables, List<T> updateables, List<String> deleteables) {
        this.insertables = insertables;
        this.updateables = updateables;
        this.deleteables = deleteables;
    }

    public List<T> getInsertables() {
        return insertables;
    }

    public List<T> getUpdateables() {
        return updateables;
    }

    public List<String> getDeleteables() {
        return deleteables;
    }
}
