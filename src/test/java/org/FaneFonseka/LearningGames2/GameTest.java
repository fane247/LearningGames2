package org.FaneFonseka.LearningGames2;

import com.sun.openpisces.Stroker;
import org.junit.Before;
import org.junit.Test;

import java.util.Stack;



/**
 * Created by Fane on 03/12/2016.
 */




public class GameTest {

    private Game game1;

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

        game1 = new Game();

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

        game1.setNumberOfQuestions(fakeUserInput);
        assert game1.getNumberOfQuestions()==1;

    }

    //todo move to Picker test
    @Test
    public void setFirstPickTest() {

        game1.setPicks(fixedPrimitivePicker);

        assert game1.getFirstPick().equals(primitive1);

    }

    //todo move to Picker test
    @Test
    public void setSecondPickTest() {

        game1.setPicks(fixedPrimitivePicker);
        assert game1.getSecondPick().equals(primitive3);
    }

    //todo move to Picker test
    @Test
    public void secondPickIsDifferentFromFirstPickTest() {

        game1.setPicks(fixedPrimitivePicker);
        assert !game1.getFirstPick().equals(game1.getSecondPick());

    }


    @Test
    public void whenUserIsAskedWhichDataTypeIsBiggerLargerDataTypeIsChosenReturnsTrueTest(){


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
        game1.askAllQuestions(fakeUserAnswers,fixedPrimitivePicker,user, userInputNumberOfQuestions);
        assert user.getAnswersList().get(0);

    }


    @Test
    public void whenUserIsAskedWhichDataTypeIsBiggerSmallerDataTypeIsChosenReturnsFalseTest(){



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
        game1.askAllQuestions(fakeuserInput1,fixedPrimitivePicker,user, userInputNumberOfQuestions);
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
//        game1.askAllQuestions(fakeUserInputAnswers,fixedPrimitivePicker,user, userInputNumberOfQuestions);
//
//        assert game1.getNumberOfQuestions()==1;
//
//
//
//    }



}