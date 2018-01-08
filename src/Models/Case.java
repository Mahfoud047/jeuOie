package Models;

public abstract class Case {
    private int position;
    public int getPosition()
    {
        return position;
    }

    public void setPosition(int position)
    {
        this.position = position;
    }

    public abstract void jouerCase();
    public abstract Boolean isDeplacing();
    public abstract int getDeplacement();

}
