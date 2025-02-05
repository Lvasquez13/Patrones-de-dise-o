package org.example.prototype;

public interface IPrototype <T extends IPrototype> extends Cloneable {

    // Clonal simple
     T clone();

    // Clonal profound
    T deepClone();
}