package org.uniquindio.edu.co.poo.banco.viewController;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.uniquindio.edu.co.poo.banco.App;
import org.uniquindio.edu.co.poo.banco.controller.DepositoController;
import org.uniquindio.edu.co.poo.banco.controller.InicioSesionController;
import org.uniquindio.edu.co.poo.banco.model.Cliente;
import org.uniquindio.edu.co.poo.banco.model.Deposito;
import org.uniquindio.edu.co.poo.banco.model.Movimiento;
import org.uniquindio.edu.co.poo.banco.model.TipoMovimiento;

import java.time.LocalDateTime;

public class DepositoViewController {
    private App app;
    DepositoController depositoController ;
    ObservableList<Deposito> listDepositos = FXCollections.observableArrayList();
    Deposito selectedDeposito;



    @FXML
    private Button btnVolver;

    @FXML
    void volverCajero(ActionEvent event) {
        app.mostrarVentanaCajero();
    }
    @FXML
    private TableView<Deposito> tblListDepositos;



    @FXML
    private TableColumn<Deposito, String> tbcCuenta;

    @FXML
    private TableColumn<Deposito, String> tbcSaldo;

    @FXML
    private Button btnRealizarDeposito;

    @FXML
    private TextField txtSaldoADepositar;

    @FXML
    private TextField txtCodigoCuentaADepositar;

    @FXML
    void onRealizarDeposito(ActionEvent event) {
        realizarDeposito();
    }

    @FXML
    void initialize() {
        this.app=app;
        this.depositoController = new DepositoController(app.banco);
        initView();
    }

    public void setApp(App app) {
        this.app = app;

    }

    private void initView() {
        // Traer los datos del cliente a la tabla
        initDataBinding();

        // Obtiene la lista
        obtenerDepositos();

        // Limpiar la tabla
        tblListDepositos.getItems().clear();

        // Agregar los elementos a la tabla
        tblListDepositos.setItems(listDepositos);

        // Seleccionar elemento de la tabla
        listenerSelection();
    }
    private void initDataBinding() {
        tbcCuenta.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCodigoCuentaADepositar()));
        tbcSaldo.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getSaldoADepositar())));

        // Usamos SimpleObjectProperty para manejar Double y Integer correctamente
    }

    private void obtenerDepositos() {
        listDepositos.addAll(depositoController.obtenerListaDeposito());
    }


        public void realizarDeposito() {

            Deposito deposito= buildDeposito();
            System.out.println(deposito);
            System.out.println(txtSaldoADepositar.getText());
            if(depositoController.registrarDeposito(deposito)){
                listDepositos.add(deposito);

            }



        }

        public Deposito buildDeposito() {
        Deposito deposito= new Deposito(txtCodigoCuentaADepositar.getText(),Double.parseDouble(txtSaldoADepositar.getText()), LocalDateTime.now(), TipoMovimiento.DEPOSITO);
        System.out.println(Double.parseDouble(txtSaldoADepositar.getText()));
        return deposito;
    }

    private void mostrarInformacionDeposito(Deposito deposito) {
        if (deposito != null) {
            txtSaldoADepositar.setText(String.valueOf(deposito.getSaldoADepositar()));
            txtCodigoCuentaADepositar.setText(deposito.getCodigoCuentaADepositar());
        }
    }

    private void listenerSelection() {
        tblListDepositos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedDeposito = newSelection;
            mostrarInformacionDeposito(selectedDeposito);
        });
    }





    }





