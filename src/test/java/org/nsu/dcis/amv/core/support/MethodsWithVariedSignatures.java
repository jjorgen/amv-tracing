package org.nsu.dcis.amv.core.support;

/**
 * Created by John Jorgensen on 3/15/2017.
 */
public class MethodsWithVariedSignatures {

    public String firstMethod(int count, String parameter) {
        String stringToAppend = "Appended string" + count;
        parameter += stringToAppend;
        return parameter;
    }

    public String secondMethodWithFlippedParameters(String parameter, int count) {
        String stringToAppend = "Appended string" + count;
        parameter += stringToAppend;
        return parameter;
    }
	
    public String thirdMethodWithMoreParameters(String parameter, int count, int count2) {
        String stringToAppend = "Appended string" + count + count2;
        parameter += stringToAppend;
        return parameter;
    }

    public String fourthMethodSameAsFirstMethod(int count, String parameter) {
        String stringToAppend = "Appended string" + count;
        parameter += stringToAppend;
        return parameter;
    }
}
