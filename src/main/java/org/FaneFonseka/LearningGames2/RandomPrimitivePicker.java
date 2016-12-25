package org.FaneFonseka.LearningGames2;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Fane on 04/12/2016.
 */
public class RandomPrimitivePicker implements Picker {


    private static final PrimitiveDataType BOOLEAN_TYPE = new PrimitiveDataType("boolean", 0);
    private static final PrimitiveDataType BYTE_TYPE = new PrimitiveDataType("byte", 8);
    private static final PrimitiveDataType SHORT_TYPE = new PrimitiveDataType("short", 16);
    private static final PrimitiveDataType CHAR_TYPE = new PrimitiveDataType("char", 16);
    private static final PrimitiveDataType INT_TYPE = new PrimitiveDataType("int", 32);
    private static final PrimitiveDataType LONG_TYPE = new PrimitiveDataType("long", 64);
    private static final PrimitiveDataType FLOAT_TYPE = new PrimitiveDataType("float", 32);
    private static final PrimitiveDataType DOUBLE_TYPE = new PrimitiveDataType("double", 64);

    private static final List<PrimitiveDataType> PRIMITIVE_TYPES = Arrays.asList(
            BOOLEAN_TYPE, BYTE_TYPE, SHORT_TYPE, CHAR_TYPE, INT_TYPE,
            LONG_TYPE, FLOAT_TYPE, DOUBLE_TYPE);


    private Random randomNumberGenerator;

    RandomPrimitivePicker() {

        randomNumberGenerator = new Random();
    }


    public PrimitiveDataType pick() {


        return PRIMITIVE_TYPES.get(randomNumberGenerator.nextInt(PRIMITIVE_TYPES.size() - 1));
    }
}
