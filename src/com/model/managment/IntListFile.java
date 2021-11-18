package com.model.managment;

import java.util.List;

public interface IntListFile<Type> {    
    abstract List<Type> openAndFitch();      // create output stream then get list of objects from it
    abstract boolean saveAndClose(List<Type> items);
}
