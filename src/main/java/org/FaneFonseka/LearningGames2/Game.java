package org.FaneFonseka.LearningGames2;



/**
 * Created by Fane on 03/12/2016.
 */
class Game {


    private int numberOfQuestions;
    private PrimitiveDataType firstPick;
    private PrimitiveDataType secondPick;

    Game() {

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


    private void setFirstPick(Picker randomPrimitivePicker) {

        this.firstPick = randomPrimitivePicker.pick();
    }

    PrimitiveDataType getFirstPick() {

        return this.firstPick;
    }


    private void setSecondPick(Picker randomPrimitivePicker) {

        PrimitiveDataType pick;

        do {
            pick = randomPrimitivePicker.pick();
        }while(pick.equals(firstPick));

        this.secondPick = pick;

    }

    PrimitiveDataType getSecondPick() {

        return secondPick;
    }


    //todo could move picks into selectedPrimitives Class?
    void setPicks(Picker randomPrimitivePicker) {
        setFirstPick(randomPrimitivePicker);
        setSecondPick(randomPrimitivePicker);
    }

    private boolean firstPickGreaterThanSecondPick(){

        System.out.println(firstPick.getMemorySizeInBits() > secondPick.getMemorySizeInBits());
        return firstPick.getMemorySizeInBits() > secondPick.getMemorySizeInBits();
//todo add this test (Move to Picker class/interface?)
    }

    private boolean secondPickGreaterThanFirstPick(){

        System.out.println(firstPick.getMemorySizeInBits() < secondPick.getMemorySizeInBits());
        return firstPick.getMemorySizeInBits() < secondPick.getMemorySizeInBits();
//todo add this test (Move to Picker class/interface?)
    }

    private boolean firstPickIsSameSizeAsSecondPick(){
        System.out.println(firstPick.getMemorySizeInBits() == secondPick.getMemorySizeInBits());
        return firstPick.getMemorySizeInBits() == secondPick.getMemorySizeInBits();
//todo add this test (Move to Picker class/interface?)
    }



    void getAnswer(UserInput answerAsInt, Picker randomPrimitivePicker, User user) {

        whichPickIsBiggerPrompt(randomPrimitivePicker);

        /*
        method might be getting too big. could possibly have it return and array of answers to allow for a swap in
        implementation?
        */
        switch (answerAsInt.getUserInputInt()) {

            case 1:
                user.addAnswerToList(firstPickGreaterThanSecondPick());
                break;
            case 2:
                user.addAnswerToList(secondPickGreaterThanFirstPick());
                break;
            case 3:
                user.addAnswerToList(firstPickIsSameSizeAsSecondPick());
                break;
            default:
                System.out.println(false);
                user.addAnswerToList(false);
                break;
        }

    }

    private void whichPickIsBiggerPrompt(Picker randomPrimitivePicker) {
        setPicks(randomPrimitivePicker);
        System.out.println("Which is bigger?");
        System.out.println("1. " + firstPick.name+"?");
        System.out.println("2. " + secondPick.name+"?");
        System.out.println("3. " + "Both the same?");
    }


    void askAllQuestions(UserInput userInputAnswers, Picker randomPrimitivePicker, User user, UserInput userInputNumberOfQuestions) {

        //todo long parameter list

        setNumberOfQuestions(userInputNumberOfQuestions);
        System.out.println("Let's Begin!");
        System.out.println();
        System.out.println("Enter your answer as a number");

        //questionsAskedCount+=;
        for (int i = 0; i <= numberOfQuestions-1; i++) {
            getAnswer(userInputAnswers, randomPrimitivePicker, user);
        }
    }

    public static void main(String args[]){

        System.out.println("Welcome to the Java primitive data types quiz!");
        UserInput userInput = new UserInputFromConsole();
        User user = new User();
        user.setName(userInput);

        Game game1 = new Game();
        Picker randomPrimitivePicker = new RandomPrimitivePicker();

        game1.askAllQuestions(userInput,randomPrimitivePicker,user, userInput);
        System.out.println("Your score is " + user.getScore(game1.getNumberOfQuestions()));
        System.out.println("Thanks For playing!");


    }



 }

