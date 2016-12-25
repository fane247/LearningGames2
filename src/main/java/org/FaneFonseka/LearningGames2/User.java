package org.FaneFonseka.LearningGames2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Created by Fane on 06/12/2016.
 */
class User {

    private String name;
    private List<Boolean> answersList = new ArrayList<Boolean>();

    void addAnswerToList(boolean answer) {

        getAnswersList().add(answer);
    }

    List<Boolean> getAnswersList() {

        return answersList;
    }


    double getScore(double numberOfQuestions) {

        int numberOfTrue = Collections.frequency(answersList, true);

        System.out.println("(score is calculated by dividing true answers by number of questions)");
        System.out.println(numberOfTrue + "/" + (int) numberOfQuestions);


        double score = numberOfTrue / numberOfQuestions;
        System.out.println(Math.round(score * 100) / 100);
        return Math.round(score * 100.0) / 100.0;
    }


    void setName(UserInput input) {

        boolean validName = true;
        while (validName) {

            System.out.println("What is your name?");
            this.name = input.getUserInputString();


            if (this.name.isEmpty()) {
                System.out.println("Please choose a valid name");
            } else {
                validName = false;
                System.out.println("hello " + this.name);
            }

        }
    }

    String getName() {

        return name;
    }


}

