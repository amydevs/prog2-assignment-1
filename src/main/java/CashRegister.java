import javafx.beans.property.*;

public class CashRegister implements ProductObserver {
    private DoubleProperty cash;

    public final double getCash() {
        return this.cash.get();
    }

    public final void setCash(double cash) {
        this.cash.set(cash);
    }

    public ReadOnlyDoubleProperty cashProperty() {
        return this.cash;
    }

    public CashRegister() {
        this.cash = new SimpleDoubleProperty(0.0);
    }

    public void add(double money) {
        this.cash.set(this.cash.get() + money);
    }

    @Override
    public void handleSale(double amount) {
        add(amount);
    }
}   