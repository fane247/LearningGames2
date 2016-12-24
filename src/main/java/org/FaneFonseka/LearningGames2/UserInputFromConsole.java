package org.FaneFonseka.LearningGames2;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Fane on 09/12/2016.
 */
public class UserInputFromConsole implements UserInput {

    private Scanner reader;

    UserInputFromConsole(InputStream in) {
        reader = new Scanner(in);

    }

    @Override
    public int getUserInputInt() throws InputMismatchException {
        //todo not sure how to test this
        return reader.nextInt();

    }


    @Override
    public String getUserInputString() {
        //todo not sure how to test this

        return reader.nextLine();
    }


}
