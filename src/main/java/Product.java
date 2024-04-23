import java.util.LinkedList;
import javafx.beans.property.*;

public class Product {
    private LinkedList<ProductObserver> observers = new LinkedList<ProductObserver>();

    private StringProperty name;
    private IntegerProperty stock;
    private DoubleProperty price;

    public final String getName() { return this.name.get(); }
    public final double getPrice() { return this.price.get(); }
    
    public ReadOnlyStringProperty nameProperty() {
        return this.name;
    }

    public ReadOnlyIntegerProperty stockProperty() {
        return this.stock;
    }

    public ReadOnlyDoubleProperty priceProperty() {
        return this.price;
    }

    public Product(String name, int stock, double price) {
        this.name = new SimpleStringProperty(name);
        this.stock = new SimpleIntegerProperty(stock);
        this.price = new SimpleDoubleProperty(price);
    }

    public void sell(int n) {
        this.stock.set(this.stock.get() - n);
        double money = n * this.price.get();
        for (ProductObserver observer : observers)
            observer.handleSale(money);
    }

    public void restock(int n) {
        this.stock.set(this.stock.get() + n);
    }

    public boolean has(int n) {
        return this.stock.get() >= n;
    }

    public void addProductObserver(ProductObserver observer) {
        observers.add(observer);
    }

    @Override
    public String toString() {
        return stock + " " + name + " at $" + price;
    }
}