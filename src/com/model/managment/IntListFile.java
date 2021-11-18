package com.model.managment;

import java.util.List;

public interface IntListFile<Type> {
    abstract List<Type> openAndFitch();
    abstract boolean saveAndClose(List<Type> items);
}
