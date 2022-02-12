package com.company.gradingstudents;


import java.util.ArrayList;
import java.util.List;

class Result {

    /*
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */

    public static List<Integer> gradingStudents(List<Integer> grades) {

        List<Integer> response = new ArrayList<>();

        for (Integer grade : grades) {
            if (grade >= 38) {
                int nextMultiple = grade;
                while (nextMultiple % 5 != 0) {
                    nextMultiple++;
                }

                if ((nextMultiple - grade) < 3) {
                   grade = nextMultiple;
                }
            }
            response.add(grade);
        }

        return response;
    }

}
