package nl.capite.cunsel.exceptions;

public class UncompatibleClasses extends  Exception{
    public UncompatibleClasses(String className1,String className2) {
        super("class " + className1 + " is uncompatible with class " + className2);
    }
}
