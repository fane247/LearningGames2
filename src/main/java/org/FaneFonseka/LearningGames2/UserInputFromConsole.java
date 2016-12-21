package org.FaneFonseka.LearningGames2;

import javax.print.DocFlavor;
import java.util.Scanner;

/**
 * Created by Fane on 09/12/2016.
 */
public class UserInputFromConsole implements UserInput {

    private Scanner reader = new Scanner(System.in);

    @Override
    public int getUserInputInt() {

        while (true) {
            try {
                return reader.nextInt();


            } catch (Exception e) {

                System.out.println("not a valid number");

            }
        }


    }

    @Override
    public String getUserInputString() {

        return reader.nextLine();
    }


}
