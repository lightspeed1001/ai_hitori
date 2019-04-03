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

<<<<<<< HEAD
        HitoriCell[][] solution = new HitoriCell[][] {
            {new HitoriCell(0,0,1),         new HitoriCell(0,1,4),       new HitoriCell(0,2,2),       new HitoriCell(0,3,4, true),  new HitoriCell(0,4,3)},
            {new HitoriCell(1,0,1, true),   new HitoriCell(1,1,1),       new HitoriCell(1,2,3),       new HitoriCell(1,3,4),        new HitoriCell(1,4,5)},
            {new HitoriCell(2,0,3),         new HitoriCell(2,1,4, true), new HitoriCell(2,2,4),       new HitoriCell(2,3,5),        new HitoriCell(2,4,5, true)},
            {new HitoriCell(3,0,4),         new HitoriCell(3,1,5),       new HitoriCell(3,2,1),       new HitoriCell(3,3,3),        new HitoriCell(3,4,2)},
            {new HitoriCell(4,0,1, true),   new HitoriCell(4,1,3),       new HitoriCell(4,2,3, true), new HitoriCell(4,3,1),        new HitoriCell(4,4,2, true)}};
        
        HitoriCell[][] unreachableWhites = new HitoriCell[][] {
            {new HitoriCell(0,0,1),         new HitoriCell(0,1,4),       new HitoriCell(0,2,2),       new HitoriCell(0,3,4, true),  new HitoriCell(0,4,3)},
            {new HitoriCell(1,0,1, true),   new HitoriCell(1,1,1),       new HitoriCell(1,2,3,true),  new HitoriCell(1,3,4),        new HitoriCell(1,4,5)},
            {new HitoriCell(2,0,3),         new HitoriCell(2,1,4, true), new HitoriCell(2,2,4),       new HitoriCell(2,3,5),        new HitoriCell(2,4,5, true)},
            {new HitoriCell(3,0,4),         new HitoriCell(3,1,5),       new HitoriCell(3,2,1),       new HitoriCell(3,3,3),        new HitoriCell(3,4,2)},
            {new HitoriCell(4,0,1, true),   new HitoriCell(4,1,3),       new HitoriCell(4,2,3, true), new HitoriCell(4,3,1),        new HitoriCell(4,4,2, true)}};
        
        HitoriCell[][] tooManyBlacks = new HitoriCell[][] {
            {new HitoriCell(0,0,1, true),   new HitoriCell(0,1,4),       new HitoriCell(0,2,2),       new HitoriCell(0,3,4, true),  new HitoriCell(0,4,3)},
            {new HitoriCell(1,0,1, true),   new HitoriCell(1,1,1),       new HitoriCell(1,2,3,true),  new HitoriCell(1,3,4),        new HitoriCell(1,4,5)},
            {new HitoriCell(2,0,3),         new HitoriCell(2,1,4, true), new HitoriCell(2,2,4),       new HitoriCell(2,3,5),        new HitoriCell(2,4,5, true)},
            {new HitoriCell(3,0,4),         new HitoriCell(3,1,5),       new HitoriCell(3,2,1),       new HitoriCell(3,3,3),        new HitoriCell(3,4,2)},
            {new HitoriCell(4,0,1, true),   new HitoriCell(4,1,3),       new HitoriCell(4,2,3, true), new HitoriCell(4,3,1),        new HitoriCell(4,4,2, true)}};
        HitoriCell[][] threeInARow = new HitoriCell[][] {
            {new HitoriCell(0,0,1),   new HitoriCell(0,1,4),    new HitoriCell(0,2,2),	new HitoriCell(0,3,4),  new HitoriCell(0,4,3)},
            {new HitoriCell(1,0,1),   new HitoriCell(1,1,1),    new HitoriCell(1,2,3),  new HitoriCell(1,3,4),  new HitoriCell(1,4,5)},
            {new HitoriCell(2,0,3),   new HitoriCell(2,1,4),	new HitoriCell(2,2,4),  new HitoriCell(2,3,4),  new HitoriCell(2,4,1)},
            {new HitoriCell(3,0,4),   new HitoriCell(3,1,5),    new HitoriCell(3,2,1),  new HitoriCell(3,3,3),  new HitoriCell(3,4,4)},
            {new HitoriCell(4,0,3),   new HitoriCell(4,1,3),    new HitoriCell(4,2,3),	new HitoriCell(4,3,2),  new HitoriCell(4,4,2)}};
        HitoriCell[][] checkCorners = new HitoriCell[][] {
            {new HitoriCell(0,0,1),   new HitoriCell(0,1,1),    new HitoriCell(0,2,2),	new HitoriCell(0,3,5),  new HitoriCell(0,4,5)},
            {new HitoriCell(1,0,1),   new HitoriCell(1,1,0),    new HitoriCell(1,2,3),  new HitoriCell(1,3,4),  new HitoriCell(1,4,5)},
            {new HitoriCell(2,0,2),   new HitoriCell(2,1,4),	new HitoriCell(2,2,4),  new HitoriCell(2,3,2),  new HitoriCell(2,4,1)},
            {new HitoriCell(3,0,3),   new HitoriCell(3,1,5),    new HitoriCell(3,2,1),  new HitoriCell(3,3,3),  new HitoriCell(3,4,2)},
            {new HitoriCell(4,0,3),   new HitoriCell(4,1,3),    new HitoriCell(4,2,3),	new HitoriCell(4,3,2),  new HitoriCell(4,4,2)}};
        
        HitoriGame game = new HitoriGame(5, original);
        HitoriGame game2 = new HitoriGame(5, solution);
        HitoriGame game3 = new HitoriGame(5, unreachableWhites);
        HitoriGame game4 = new HitoriGame(5, tooManyBlacks);
        HitoriGame game5 = new HitoriGame(5, threeInARow);
        HitoriGame game6 = new HitoriGame(5, checkCorners);
        
        
        HitoriSolver solver = new HitoriSolver(game6);
        //game5 = solver.getBoard();
        
        
        game6.print();

        System.out.println("Original puzzle");
        System.out.println("Solved? " + game.isValidSolution());
        game.print();
        System.out.println("===============");
        System.out.println("Solved");
        System.out.println("Solved? " + game2.isValidSolution());
        game2.print();
        System.out.println("===============");
        System.out.println("Unreachable white area");
        System.out.println("Solved? " + game3.isValidSolution());
        game3.print();
        System.out.println("===============");
        System.out.println("Too many blacks");
        System.out.println("Solved? " + game4.isValidSolution());
        game4.print();
        System.out.println("===============");
        System.out.println("Three in a row");
        System.out.println("Solved? " + game5.isValidSolution());
=======
        Set<HitoriCell[][]> tests = HitoriTests.getTestCase(99);
        System.out.println("Testing getPossibleBlackSquares ");
        for (HitoriCell[][] test : tests) {
            System.out.println("------");
            HitoriGame g = new HitoriGame(test.length, test);
            System.out.println("Solved? " + g.isValidSolution());
            g.print();
            Set<HitoriCell> possibleBlacks = g.getPossibleBlackCells();
            
            System.out.println("===Possible black cells===");
            for (HitoriCell cell : possibleBlacks) {
                System.out.println("value: " + cell.getNumber() + "; (" + cell.getX() + ", " + cell.getY() + ");");
            }
        }
        System.out.println("================================");

        //TODO Test the solver on some unsolved puzzles
>>>>>>> 46b278a7ccefd08bd4282410b76a4abd826473d7
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