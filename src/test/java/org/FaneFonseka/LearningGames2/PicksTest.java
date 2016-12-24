package org.FaneFonseka.LearningGames2;

import org.junit.Before;
import org.junit.Test;

import java.util.Stack;


/**
 * Created by Fane on 23/12/2016.
 */
public class PicksTest {


    private Picks picks;
    private Picker fixedPrimitivePicker;
    private Stack<PrimitiveDataType> primitiveDataTypeStack;
    private PrimitiveDataType primitive1;
    private PrimitiveDataType primitive2;
    private PrimitiveDataType primitive3;

    @Before
    public void setup() {


        primitiveDataTypeStack = new Stack<PrimitiveDataType>();
        primitiveDataTypeStack.push(primitive3 = new PrimitiveDataType("int", 32));
        primitiveDataTypeStack.push(primitive2 = new PrimitiveDataType("boolean", 1));
        primitiveDataTypeStack.push(primitive1 = new PrimitiveDataType("boolean", 1));

        fixedPrimitivePicker = new Picker() {

            public PrimitiveDataType pick() {

                return primitiveDataTypeStack.pop();

            }
        };
        picks = new Picks(fixedPrimitivePicker);

    }

    @Test
    public void setFirstPickTest() {

        picks.setPicks();

        assert picks.getFirstPick().equals(primitive1);


    }

    @Test
    public void setSecondPickTest() {

        picks.setPicks();
        assert picks.getSecondPick().equals(primitive3);
    }

    @Test
    public void secondPickIsDifferentFromFirstPickTest() {

        picks.setPicks();
        assert !picks.getFirstPick().equals(picks.getSecondPick());

    }


}