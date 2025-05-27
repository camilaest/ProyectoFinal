package org.uniquindio.edu.co.poo.banco.viewController;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.uniquindio.edu.co.poo.banco.App;
import org.uniquindio.edu.co.poo.banco.controller.CajeroController;
import org.uniquindio.edu.co.poo.banco.controller.RetirarController;
import org.uniquindio.edu.co.poo.banco.controller.TransaccionController;
import org.uniquindio.edu.co.poo.banco.model.Deposito;
import org.uniquindio.edu.co.poo.banco.model.Retiro;
import org.uniquindio.edu.co.poo.banco.model.TipoMovimiento;
import org.uniquindio.edu.co.poo.banco.model.Transaccion;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TransaccionViewController {
    private App app;
    TransaccionController transaccionController ;
    ObservableList<Transaccion> listTransaccion = FXCollections.observableArrayList();
    Transaccion selectedTransaccion;

    @FXML
    private TextField txtCuentaOrigen;

    @FXML
    private Button btnRealizarTransferencia;

    @FXML
    private Button btnVolver;

    @FXML
    private TextField txtCuentaDestino;

    @FXML
    private TextField txtSaldoDepositar;

    @FXML
    private TableColumn<Transaccion, String> tbcCuentaOrigen;

    @FXML
    private TableView<Transaccion> tblListaTransferencias;

    @FXML
    private TableColumn<Transaccion, String> tbcCuentaDestino;

    @FXML
    private TableColumn<Transaccion, String> tbcSaldo;

    @FXML
    void initialize() {
        this.app=app;
        this.transaccionController= new TransaccionController(app.banco);
        initView();

    }

    @FXML
    void onRealizar(ActionEvent event) {
        realizarDeposito();

    }

    @FXML
    void onVolver(ActionEvent event) {
        app.mostrarVentanaCajero();
    }

    private void initView() {
        // Traer los datos del cliente a la tabla
        initDataBinding();

        // Obtiene la lista
        obtenerTransacciones();

        // Limpiar la tabla
        tblListaTransferencias.getItems().clear();

        // Agregar los elementos a la tabla
        tblListaTransferencias.setItems(listTransaccion);

        // Seleccionar elemento de la tabla
        listenerSelection();
    }

    private void listenerSelection() {
        tblListaTransferencias.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedTransaccion= newSelection;
            mostrarInformacionTransferencia(selectedTransaccion);
        });
    }

    private void mostrarInformacionTransferencia(Transaccion transaccion) {
        if (transaccion!= null) {
            txtCuentaOrigen.setText(String.valueOf(transaccion.getCuentaOrigen()));
            txtCuentaDestino.setText(String.valueOf(transaccion.getCuentaDestino()));
            txtSaldoDepositar.setText(String.valueOf(transaccion.getSaldoADepositar()));
        }
    }

    private void initDataBinding() {
        tbcCuentaDestino.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCuentaDestino()));
        tbcCuentaOrigen.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCuentaOrigen()));
        tbcSaldo.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getSaldoADepositar())));

        // Usamos SimpleObjectProperty para manejar Double y Integer correctamente
    }

    private void obtenerTransacciones() {

        listTransaccion.addAll(transaccionController.obtenerListaTransacciones());

    }

    public void realizarDeposito() {

        Transaccion transaccion= buildTransaccion();
        System.out.println(transaccion);
        System.out.println(txtCuentaOrigen.getText());
        if(transaccionController.registrarTransaccion(transaccion)){
            listTransaccion.add(transaccion);

        }
    }

    public Transaccion buildTransaccion() {
        Transaccion transaccion= new Transaccion(LocalDateTime.now(), txtCuentaOrigen.getText(), txtCuentaDestino.getText(), TipoMovimiento.TRANSACCION, Double.parseDouble(txtSaldoDepositar.getText()) );
        return transaccion;
    }
}
