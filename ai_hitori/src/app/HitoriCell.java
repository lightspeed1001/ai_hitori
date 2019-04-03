package app;

/**
 * HitoriCell
 */
public class HitoriCell {
    //The number and coordinates cannot be changed after creation, so we put final there just to make sure
    private final int x,y;
    private int number;
    //The colour of the cell                            and if it's been visited for a recursive function
    private Boolean black = false, mustBeWhite = false, visited = false;
    
    public HitoriCell(int x, int y, int number)
    {
        this(x, y, number, false);
    }

    public HitoriCell(int x, int y, int number, Boolean black)
    {
        this.x = x;
        this.y = y;
        this.number = number;
        this.black = black;
    }
    
    //Copy constructor
    public HitoriCell(HitoriCell other)
    {
        this.x = other.x;
        this.y = other.y;
        this.black = other.black;
        this.mustBeWhite = other.mustBeWhite;
        this.number = other.number;
    }

    //Getters
    public int getNumber() { return number; }
    public Boolean isBlack() { return black; }
    public Boolean mustBeWhite() { return mustBeWhite; }
    public Boolean beenVisited() { return visited; }
    public int getX() { return x; }
    public int getY() { return y; }

    //Setters
    public void setVisited(Boolean v) { this.visited = v; }
    public void setBlack(Boolean black) { this.black = black; }
    public void setWhite(Boolean mustBeWhite) { this.mustBeWhite = mustBeWhite; }
    public void setNumber(int number) { this.number = number; }
}