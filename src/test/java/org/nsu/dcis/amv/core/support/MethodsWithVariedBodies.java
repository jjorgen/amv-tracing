package org.nsu.dcis.amv.core.support;

/**
 * Created by John Jorgensen on 3/15/2017.
 */
public class MethodsWithVariedBodies {

    public String firstMethod(int count, String parameter) {
        String stringToAppend = "Appended string" + count;
        parameter += stringToAppend;
        return parameter;
    }

    public String secondMethodWithFlippedParameters(String parameter, int count) {
        String stringToAppend = "Appended string" + count;
        parameter += stringToAppend;
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

    // Used to compare for Before Advice Candidate
    public String fifthMethodWithBeforeAdviceComparedToFirstMethod(String parameter, int count) {
        String stringToAppend = "Appended string" + count;
        parameter += stringToAppend;
        String aString = "A string";
        aString += "A string";
        return aString;
    }

    // Used to compare for After Advice Candidate
    public String sixthMethodWithAfterAdviceComparedToFirstMethod(String parameter, int count) {
        String stringToAppend = "Appended different" + count;
        stringToAppend = "Appended different" + count;
        parameter += stringToAppend;
        return parameter;
    }

    // Used to compare for Around Advice Candidate
    public String seventhMethodWithAfterAdviceComparedToFirstMethod(String parameter, int count) {
        String stringToAppend = "Appended string" + count;
        parameter += stringToAppend + stringToAppend;
        return parameter;
    }

    public void eithEmptyBodyMethod(int count, String parameter) {
    }

    public void ninthEmptyBodyMethod(int count, String parameter) {
    }
}
