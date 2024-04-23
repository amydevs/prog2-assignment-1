import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class StoreApplication extends Application {
    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("store.fxml"));

        // Add code here to load the root node from the FXML file
        // and show it
    }
}
