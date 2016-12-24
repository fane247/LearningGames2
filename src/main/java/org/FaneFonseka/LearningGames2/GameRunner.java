package org.FaneFonseka.LearningGames2;


import java.io.InputStream;
import java.util.InputMismatchException;

/**
 * Created by Fane on 03/12/2016.
 */
class GameRunner {


    private final Picks picks;
    private int numberOfQuestions;
    private User user;

    GameRunner(User user, Picker randomPrimitivePicker) {

        this.user = user;
        picks = new Picks(randomPrimitivePicker);
    }




    void setNumberOfQuestions(UserInput userInput) {

        System.out.println("How many questions would you like?");
        this.numberOfQuestions = userInput.getUserInputInt();
        System.out.println("ok");

    }


    int getNumberOfQuestions() {

        return this.numberOfQuestions;
    }


    private void getAnswer(UserInput answerAsInt) {
        picks.setPicks();

        int answerNumber = 0;

        boolean isValidNumber = true;

        while (isValidNumber) {
            whichPickIsBiggerPrompt();
            try {
                answerNumber = answerAsInt.getUserInputInt();
                isValidNumber = false;
            } catch (InputMismatchException e) {

                System.out.println("Not valid number");
            }
        }

        switch (answerNumber) {

            case 1:
                user.addAnswerToList(picks.firstPickGreaterThanSecondPick());
                break;
            case 2:
                user.addAnswerToList(picks.secondPickGreaterThanFirstPick());
                break;
            case 3:
                user.addAnswerToList(picks.firstPickIsSameSizeAsSecondPick());
                break;
            default:
                System.out.println(false);
                user.addAnswerToList(false);
                break;
        }

    }

    private void whichPickIsBiggerPrompt() {
        System.out.println("Which is bigger?");
        System.out.println("1. " + picks.getFirstPick().name + "?");
        System.out.println("2. " + picks.getSecondPick().name + "?");
        System.out.println("3. " + "Both the same?");
    }


    void askAllQuestions(UserInput userInput) {


        setNumberOfQuestions(userInput);
        System.out.println("Let's Begin!");
        System.out.println();
        System.out.println("Enter your answer as a number");

        //questionsAskedCount+=;
        for (int i = 0; i <= numberOfQuestions-1; i++) {
            getAnswer(userInput);
        }
    }

    public static void main(String args[]){

        System.out.println("Welcome to the Java primitive data types quiz!");
        InputStream in = System.in;
        UserInput userInput = new UserInputFromConsole(in);
        User user = new User();


        user.setName(userInput);
        Picker randomPrimitivePicker = new RandomPrimitivePicker();
        GameRunner game1 = new GameRunner(user, randomPrimitivePicker);

        game1.askAllQuestions(userInput);
        System.out.println("Your score is " + user.getScore(game1.getNumberOfQuestions()));
        System.out.println("Thanks For playing!");


    }



 }

