import product.Product;

import java.util.LinkedList;
import java.util.List;

public class VendingMachine {
    private List<Product> products;
    private int money;

    public VendingMachine(Product ... products1){
        money = 0;
        this.products = new LinkedList<>();

        for (Product product: products1) {
            this.products.add(product);
        }
    }

    public void addProduct(Product product){
        products.add(product);
    }
    public Product buyProduct(int i){
        if(money < products.get(i).getPrice())
            throw new IllegalArgumentException("not enough money deposited to buy specified product");

        money -= products.get(i).getPrice();
        return products.get(i);
    }
    public int numOfProducts()
    {
        return products.size();
    }
    public String listProduct(int i) {
        return products.get(i).toString();
    }

    public void depositMoney(int money){
        if(money < 0)
            throw new IllegalArgumentException("Can't deposit negative amount of money");

        this.money += money;
    }
    public final int getDepositAmount() {
        return money;
    }
    public int cashOut(){
        int rtnMoney = money;
        money = 0;
        return rtnMoney;
    }
}
