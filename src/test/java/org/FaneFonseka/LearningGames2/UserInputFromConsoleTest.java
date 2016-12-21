package org.FaneFonseka.LearningGames2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Fane on 14/12/2016.
 */
public class UserInputFromConsoleTest {

    @Test
    public void whenNonIntIsEnteredInvalidInputMessageIsShown(){

        UserInput userInput= new UserInputFromConsole();

        userInput.getUserInputInt();

    }




}