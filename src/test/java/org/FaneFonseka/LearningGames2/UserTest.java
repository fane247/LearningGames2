package org.FaneFonseka.LearningGames2;

import org.junit.Before;
import org.junit.Test;

import java.util.Stack;


/**
 * Created by Fane on 09/12/2016.
 */
public class UserTest {

    private User user;
    private Game game;
    private Stack<PrimitiveDataType> primitiveDataTypeStack;
    private PrimitiveDataType primitive1;
    private PrimitiveDataType primitive2;
    private PrimitiveDataType primitive3;
    private PrimitiveDataType primitive4;
    private PrimitiveDataType primitive5;
    private PrimitiveDataType primitive6;
    private Picker fixedPrimitivePicker;

    @Before
    public void setUp(){


        user = new User();
        user.getAnswersList().add(true);

        game = new Game();

        primitiveDataTypeStack = new Stack<PrimitiveDataType>();
        primitiveDataTypeStack.push(primitive6 = new PrimitiveDataType("float", 64));
        primitiveDataTypeStack.push(primitive6 = new PrimitiveDataType("char", 8));
        primitiveDataTypeStack.push(primitive5 = new PrimitiveDataType("char", 8));
        primitiveDataTypeStack.push(primitive4 = new PrimitiveDataType("long", 64));
        primitiveDataTypeStack.push(primitive3 = new PrimitiveDataType("int", 32));
        primitiveDataTypeStack.push(primitive2 = new PrimitiveDataType("boolean", 1));
        primitiveDataTypeStack.push(primitive1 = new PrimitiveDataType("boolean", 1));

        fixedPrimitivePicker = new Picker() {

            public PrimitiveDataType pick() {

                return primitiveDataTypeStack.pop();

            }
        };


    }


    @Test
    public void answersAreRecordedInAListTest(){

        assert user.getAnswersList().get(0).equals(true);

    }

    @Test
    public void scoreIsCalculatedByDividingTotalTrueAnswersDividedByNumberOfQuestionsTest(){

        

        double numberOfQuestions = 3;

        assert (user.getScore(numberOfQuestions)) == 0.5;

    }

    @Test
    public void whenPromptedNameIsSet() throws IllegalUserInputException {

        UserInput userInput = new UserInput() {
            @Override
            public int getUserInputInt() {
                return 0;
            }

            @Override
            public String getUserInputString() {
                return "Fane";
            }
        };

        user.setName(userInput);

        assert user.getName().equals("Fane");
        
    }


    @Test
    public void whenEmptyStringIsGivenAsNameItAsksForItAgain() throws IllegalUserInputException {
                final Stack<String> userInputs = new Stack<String>();
                userInputs.push("Fane");
                userInputs.push("");
                userInputs.push("");

        UserInput FakeUserInput = new UserInput() {
            @Override
            public int getUserInputInt() {
                return 0;
            }

            @Override
            public String getUserInputString() {

                return userInputs.pop();
            }
        };

        user.setName(FakeUserInput);
        assert user.getName().equals("Fane");

    }

    @Test
    public void multipleAnswersAreRecordedInUsersAnswersList(){
        UserInput userInputNumberOfQuestions =new UserInput() {
            @Override
            public int getUserInputInt() {
                return 3;
            }

            @Override
            public String getUserInputString() {
                return null;
            }
        };

        final Stack<Integer> testIntInput = new Stack<Integer>();
        testIntInput.add(1);
        testIntInput.add(1);
        testIntInput.add(1);
        UserInput fakeUserInput = new UserInput() {
            @Override
            public int getUserInputInt() {
                return testIntInput.pop();
            }

            @Override
            public String getUserInputString() {
                return null;
            }
        };

        game.askAllQuestions(fakeUserInput,fixedPrimitivePicker,user, userInputNumberOfQuestions);
        assert user.getAnswersList().size()==3;

    }





}
