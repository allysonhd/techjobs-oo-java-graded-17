package org.launchcode.techjobs.oo;

import java.util.Objects;

public abstract class JobField {

    private int id;
    private static int nextId = 1;

    public JobField(String value) {
        id = nextId;
        nextId++;
    }

    public int getId() {
        return id;
    }

//    @Override
//    public String toString() {
//        return value;
//    }
//
//    public String getValue() {
//        return value;
//    }
//
//    public void setValue(String value) {
//        this.value = value;
    //}
}
