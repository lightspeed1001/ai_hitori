package app;

import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {

        for (int i = 0; i < HitoriTests.NUMBER_OF_TESTS; i++) 
        {
            Set<HitoriCell[][]> tests = HitoriTests.getTestCase(i);
            System.out.println("Test case " + i);
            for (HitoriCell[][] test : tests) {
                System.out.println("------");
                HitoriGame g = new HitoriGame(test.length, test);
                System.out.println("Solved? " + g.isValidSolution());
                g.print();
            }
            System.out.println("================================");
        }

        //TODO Test the solver on some unsolved puzzles
        /*
        Have some sort of main menu?

        Pseudocode:
        choice = ShowMainMenu
        if choice = play <shouldn't be too hard?>
            start hitoriplayer
                play a game of hitori

        if choice = solve <MAIN FOCUS>
            start hitorisolver
                solve a puzzle

        if choice = create <once solver is done>
            start hitorimaker
                create a puzzle
        */
    }
}