/**
 * class Player:
 * Abstract for polymorphism
 */
public abstract class Player{
    /**
     * lets player make a move
     * @return
     */
    public abstract int makeMove ();

    /**
     * get's player's symbol
     * @return
     */
    public abstract String getPlayerSymbol();

    /**
     * sets player symbol
     * @param x
     */
    public abstract void setPlayerSymbol(String x);

}
