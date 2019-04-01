package app;

/**
 * HitoriCell
 */
public class HitoriCell {

    int number;
    Boolean black;
    Boolean mustBeWhite;

    public HitoriCell(int number)
    {
        this.number = number;
        this.black = false;
        this.mustBeWhite = false;
    }

    public HitoriCell(int number, boolean black)
    {
        this.number = number;
        this.black = black;
        this.mustBeWhite = false;
    }
}