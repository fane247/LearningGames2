package org.FaneFonseka.LearningGames2;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by Fane on 05/12/2016.
 */
public class RandomPrimitivePickerTest {
    @Test
    public void pickTest(){

        Random numberGenerator = new Random();
        RandomPrimitivePicker randomPrimitivePicker1 = new RandomPrimitivePicker();

        PrimitiveDataType firstPick = randomPrimitivePicker1.pick();
        assert firstPick != null;

    }





}