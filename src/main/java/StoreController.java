import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.*;

public class StoreController {
    Store store;

    @FXML
    private Button sellBtn;
    @FXML
    private Text stockTxt;
    @FXML
    private Text priceTxt;
    @FXML
    private TextField amountTf;
    @FXML
    private Text cashTxt;

    public final Store getStore() {
        return this.store;
    }

    public StoreController() {
        this.store = new Store();
    }

    @FXML
    private void initialize() {
        Product product = this.store.getProduct();
        this.stockTxt.textProperty().bind(
                product
                        .stockProperty()
                        .asString()
                        .concat(" items"));
        this.priceTxt.textProperty().bind(Bindings.format("$%.2f", product.priceProperty()));
        this.cashTxt.textProperty().bind(Bindings.format("$%.2f", this.store.getCashRegister().cashProperty()));

        this.sellBtn.addEventHandler(javafx.event.ActionEvent.ACTION, event -> {
            int amount = Integer.parseInt(this.amountTf.getText());
            if (product.has(amount)) {
                product.sell(amount);
            }
        });
    }
}