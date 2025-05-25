package org.uniquindio.edu.co.poo.banco.viewController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.uniquindio.edu.co.poo.banco.App;

import java.net.URL;
import java.util.ResourceBundle;

public class PrimaryViewController {
    @FXML
    private ResourceBundle resources;

    App app;
    @FXML
    private URL location;

    @FXML
    private Button primaryButton;

    @FXML
    void onOpenCrudCliente() {
        app.openHome();

    }

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    void initialize() {

    }
}
