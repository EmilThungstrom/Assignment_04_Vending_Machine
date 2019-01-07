package product;

public abstract class Product {
    private int price;
    public String name;

    public Product(int price, String name) throws IllegalAccessException {
        setPrice(price);
        this.name = name;
    }
    protected void checkNegative(int value) throws IllegalAccessException {
        if(value <= 0)
            throw new IllegalAccessException("volume can't be zero or negative");
    }

    public void setPrice(int price) throws IllegalAccessException {
        checkNegative(price);
        this.price = price;
    }
    public int getPrice(){
        return price;
    }

    @Override
    public String toString(){
        return "Name: " + name + " Price: " + price;
    }
    public abstract String eat();
}
