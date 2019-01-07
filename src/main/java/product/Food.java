package product;

public class Food extends Product {

    private Size size;

    public Food(int price, String name, Size size) throws IllegalAccessException {
        super(price, name);
        this.size = size;
    }

    @Override
    public String eat() {
        return "you eat a " + size.name() + " serving of " + name;
    }

    @Override
    public String toString() {
        return super.toString() + " Meal size: " + size.name();
    }
}
