package product;

public class Snack extends Product {

    public final boolean peanuts;

    public Snack(int price, String name, boolean peanuts) throws IllegalAccessException {
        super(price, name);
        this.peanuts = peanuts;
    }

    @Override
    public String eat() {
        String rtnString = "You eat some " + name;

        if(peanuts)
            rtnString += ", it contains peanuts.";
        else
            rtnString += ", it does not contain peanuts.";

        return rtnString;
    }

    @Override
    public String toString() {
        return super.toString() + " Contains peanuts: " + peanuts;
    }
}
