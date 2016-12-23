package org.FaneFonseka.LearningGames2;



/**
 * Created by Fane on 03/12/2016.
 */
class Game {


    private final Picks picks = new Picks();
    private int numberOfQuestions;
    private User user;

    Game(User user) {

        this.user = user;
    }


    void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions= numberOfQuestions;
    }

    void setNumberOfQuestions(UserInput userInput) {

        System.out.println("How many questions would you like?");
        this.numberOfQuestions = userInput.getUserInputInt();
        System.out.println("ok");

    }


    int getNumberOfQuestions() {

        return this.numberOfQuestions;
    }


    private void getAnswer(UserInput answerAsInt, Picker randomPrimitivePicker) {

        whichPickIsBiggerPrompt(randomPrimitivePicker);

        /*
        method might be getting too big. could possibly have it return and array of answers to allow for a swap in
        implementation?
        */
        switch (answerAsInt.getUserInputInt()) {

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

    private void whichPickIsBiggerPrompt(Picker randomPrimitivePicker) {
        picks.setPicks(randomPrimitivePicker);
        System.out.println("Which is bigger?");
        System.out.println("1. " + picks.getFirstPick().name + "?");
        System.out.println("2. " + picks.getSecondPick().name + "?");
        System.out.println("3. " + "Both the same?");
    }


    void askAllQuestions(UserInput userInput, Picker randomPrimitivePicker) {

        //todo long parameter list

        setNumberOfQuestions(userInput);
        System.out.println("Let's Begin!");
        System.out.println();
        System.out.println("Enter your answer as a number");

        //questionsAskedCount+=;
        for (int i = 0; i <= numberOfQuestions-1; i++) {
            getAnswer(userInput, randomPrimitivePicker);
        }
    }

    public static void main(String args[]){

        System.out.println("Welcome to the Java primitive data types quiz!");
        UserInput userInput = new UserInputFromConsole();
        User user = new User();
        user.setName(userInput);

        Game game1 = new Game(user);
        Picker randomPrimitivePicker = new RandomPrimitivePicker();

        game1.askAllQuestions(userInput, randomPrimitivePicker);
        System.out.println("Your score is " + user.getScore(game1.getNumberOfQuestions()));
        System.out.println("Thanks For playing!");


    }



 }

