package app;

public class App {
    public static void main(String[] args) throws Exception {
        HitoriCell[][] penis = new HitoriCell[][] {
            {new HitoriCell(1),new HitoriCell(4),new HitoriCell(2),new HitoriCell(4, true),new HitoriCell(3)},
            {new HitoriCell(1, true),new HitoriCell(1),new HitoriCell(3),new HitoriCell(4),new HitoriCell(5)},
            {new HitoriCell(3),new HitoriCell(4, true),new HitoriCell(4),new HitoriCell(5),new HitoriCell(5, true)},
            {new HitoriCell(4),new HitoriCell(5),new HitoriCell(1),new HitoriCell(3),new HitoriCell(2)},
            {new HitoriCell(1, true),new HitoriCell(3),new HitoriCell(3, true),new HitoriCell(1),new HitoriCell(2, true)}};
        HitoriGame game = new HitoriGame(5, penis);
        System.out.println(game.isValidSolution());
        game.print();
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