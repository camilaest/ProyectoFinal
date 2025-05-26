package org.uniquindio.edu.co.poo.banco.viewController;
import org.uniquindio.edu.co.poo.banco.controller.RetirarController;
import javafx.fxml.FXML;
import org.uniquindio.edu.co.poo.banco.App;
import org.uniquindio.edu.co.poo.banco.controller.DepositoController;

public class RetirarViewController {

    private App app;
    RetirarController retirarController ;

    @FXML
    void initialize() {
        this.app=app;
    }

    public void setApp(App app) {
        this.app = app;
        this.retirarController = new RetirarController(app.banco); // ok aquí
    }
}
