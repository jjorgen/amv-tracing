package org.nsu.dcis.amv.core.support;

/**
 * Created by John Jorgensen on 3/15/2017.
 */
public class TwoIdenticalSmallMethods {

    public String firstMethod(String parameter) {
        String stringToAppend = "Appended string";
        parameter += stringToAppend;
        return parameter;
    }

    public String secondMethod(String parameter) {
        String stringToAppend = "Appended string";
        parameter += stringToAppend;
        return parameter;
    }
}
