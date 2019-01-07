package product;

public class Soda extends Product {

    private int volume;

    public Soda(int price, String name, int volume) throws IllegalAccessException {
        super(price, name);
        setVolume(volume);
    }

    public void setVolume(int volume) throws IllegalAccessException {
        checkNegative(volume);
        this.volume = volume;
    }
    public int getVolume(){
        return volume;
    }

    @Override
    public String eat() {
        return "You drink " + String.valueOf(volume) + " centiliters of " + name;
    }

    @Override
    public String toString() {
        return super.toString() + " Volume: " + volume;
    }
}
