package org.uniquindio.edu.co.poo.banco.viewController;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.uniquindio.edu.co.poo.banco.controller.RetirarController;
import javafx.fxml.FXML;
import org.uniquindio.edu.co.poo.banco.App;
import org.uniquindio.edu.co.poo.banco.model.Deposito;
import org.uniquindio.edu.co.poo.banco.model.Retiro;
import org.uniquindio.edu.co.poo.banco.model.TipoMovimiento;

import java.time.LocalDateTime;

public class RetirarViewController {

    private App app;
    RetirarController retirarController ;
    ObservableList<Retiro> listRetiros = FXCollections.observableArrayList();
    Retiro selectedRetiro;

        @FXML
        private Button btnVolver;

    @FXML
    void onVolver(ActionEvent event) {
        app.mostrarVentanaCajero();
    }

        @FXML
        private Button btnRetirar;

        @FXML
        void onRealizarRetiro(ActionEvent event) {
            realizarRetiro();
        }


        @FXML
        private TextField txtCodigoCuentaRetirar;

        @FXML
        private TableColumn<Retiro, String> btcCodigoCuenta;

        @FXML
        private TextField txtSaldoRetirar;

        @FXML
        private TableView<Retiro> tblListaRetiros;

        @FXML
        private TableColumn<Retiro, String> btcSaldoRetirar;


    @FXML
    void initialize() {
        this.app=app;
        this.retirarController= new RetirarController(app.banco);
        initView();
    }

    private void initView() {
        // Traer los datos del cliente a la tabla
        initDataBinding();

        // Obtiene la lista
        obtenerRetiros();

        // Limpiar la tabla
        tblListaRetiros.getItems().clear();

        // Agregar los elementos a la tabla
        tblListaRetiros.setItems(listRetiros);

        // Seleccionar elemento de la tabla
        listenerSelection();
    }

    private void listenerSelection() {
        tblListaRetiros.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedRetiro= newSelection;
            mostrarInformacionRetiro(selectedRetiro);
        });
    }

    private void mostrarInformacionRetiro(Retiro retiro) {
        if (retiro != null) {
            txtCodigoCuentaRetirar.setText(String.valueOf(retiro.getCodigoCuenta()));
            txtSaldoRetirar.setText(String.valueOf(retiro.getSaldoRetiro()));
        }
    }

    private void obtenerRetiros() {
        listRetiros.addAll(retirarController.obtenerListaRetiro());
    }

    private void initDataBinding() {
        btcCodigoCuenta.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCodigoCuenta()));
        btcSaldoRetirar.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getSaldoRetiro())));
    }

    public void setApp(App app) {
        this.app = app;
        this.retirarController = new RetirarController(app.banco); // ok aquí
    }

    public Retiro buildRetiro() {
        Retiro retiro= new Retiro(txtCodigoCuentaRetirar.getText(), LocalDateTime.now(), TipoMovimiento.RETIRO,Double.parseDouble(txtSaldoRetirar.getText()) );
        return retiro;
    }

    public void realizarRetiro() {

        Retiro retiro= buildRetiro();
        System.out.println(retiro);
        System.out.println(txtSaldoRetirar.getText());
        if(retirarController.registrarRetiro(retiro)){
            listRetiros.add(retiro);

        }



    }
}
