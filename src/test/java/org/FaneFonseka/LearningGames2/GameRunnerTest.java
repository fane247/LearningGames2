package org.FaneFonseka.LearningGames2;

import org.junit.Before;
import org.junit.Test;

import java.util.Stack;


/**
 * Created by Fane on 03/12/2016.
 */


public class GameRunnerTest {

    private GameRunner gameRunner;

    private Picker fixedPrimitivePicker;
    private PrimitiveDataType primitive1;
    private PrimitiveDataType primitive2;
    private PrimitiveDataType primitive3;
    private Stack<PrimitiveDataType> primitiveDataTypeStack;
    private PrimitiveDataType primitive5;
    private PrimitiveDataType primitive4;
    private PrimitiveDataType primitive6;
    private User user;

    @Before
    public void setup() {

        user = new User();


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
    public void setNumberOfQuestionsTest() {

        UserInput fakeUserInput = new UserInput() {
            @Override
            public int getUserInputInt() {
                return 1;
            }

            @Override
            public String getUserInputString() {
                return null;
            }
        };

        gameRunner.setNumberOfQuestions(fakeUserInput);
        assert gameRunner.getNumberOfQuestions() == 1;

    }


    @Test
    public void whenUserIsAskedWhichDataTypeIsBiggerLargerDataTypeIsChosenReturnsTrueTest() {


        UserInput fakeUserAnswers = new UserInput() {
            @Override
            public int getUserInputInt() {
                return 2;

            }

            @Override
            public String getUserInputString() {
                return null;
            }
        };


        UserInput userInputNumberOfQuestions = new UserInput() {
            @Override
            public int getUserInputInt() {
                return 1;
            }

            @Override
            public String getUserInputString() {
                return null;
            }
        };
        gameRunner.askAllQuestions(fakeUserAnswers);
        assert user.getAnswersList().get(0);

    }


    @Test
    public void whenUserIsAskedWhichDataTypeIsBiggerSmallerDataTypeIsChosenReturnsFalseTest() {


        UserInput fakeuserInput1 = new UserInput() {
            @Override
            public int getUserInputInt() {
                return 1;

            }

            @Override
            public String getUserInputString() {
                return null;
            }
        };

        UserInput userInputNumberOfQuestions = new UserInput() {
            @Override
            public int getUserInputInt() {
                return 1;
            }

            @Override
            public String getUserInputString() {
                return null;
            }
        };
        gameRunner.askAllQuestions(fakeuserInput1);
        assert !user.getAnswersList().get(0);

    }


    //todo move to user test


//    @Test
//
//    public void whenAnswerIsNonIntQuestionIsAskedAgain(){
//
//
//        UserInput fakeUserInputAnswers =new UserInput() {
//            @Override
//            public int getUserInputInt() {
//                return 1;
//            }
//
//            @Override
//            public String getUserInputString() {
//                return null;
//            }
//        };
//
//
//        UserInput userInputNumberOfQuestions = new UserInput() {
//
//            public Object getUserInputInt(){
//
//
//                return testNumberOfQuestionsInput.pop();
//            }
//
//            @Override
//            public int getUserInputInt() {
//                return Integer.parseInt(null);
//            }
//
//            @Override
//            public String getUserInputString() {
//                return null;
//            }
//        };
//        gameRunner.askAllQuestions(fakeUserInputAnswers,fixedPrimitivePicker,user, userInputNumberOfQuestions);
//
//        assert gameRunner.getNumberOfQuestions()==1;
//
//
//
//    }


}