package org.FaneFonseka.LearningGames2;

import org.junit.Before;
import org.junit.Test;

import java.util.Stack;


/**
 * Created by Fane on 09/12/2016.
 */
public class UserTest {

    private User user;
    private GameRunner gameRunner;
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
        gameRunner = new GameRunner(user, fixedPrimitivePicker);


    }


    @Test
    public void answersAreRecordedInAListTest(){

        assert user.getAnswersList().get(0).equals(true);

    }

    @Test
    public void scoreIsCalculatedByDividingTotalTrueAnswersDividedByNumberOfQuestionsTest(){

        

        double numberOfQuestions = 3;

        assert (user.getScore(numberOfQuestions)) == 0.33;

    }

    @Test
    public void whenPromptedNameIsSet() {

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
    public void whenEmptyStringIsGivenAsNameItAsksForItAgain() {
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

        final Stack<Integer> testIntInput = new Stack<Integer>();
        testIntInput.add(1);
        testIntInput.add(1);
        testIntInput.add(2);
        UserInput fakeUserInput = new UserInput() {
            @Override
            public int getUserInputInt() {

                System.out.println("int popped!");
                return testIntInput.pop();
            }

            @Override
            public String getUserInputString() {
                return null;
            }
        };

        gameRunner.askAllQuestions(fakeUserInput);
        assert user.getAnswersList().size()==3;


    }





}
