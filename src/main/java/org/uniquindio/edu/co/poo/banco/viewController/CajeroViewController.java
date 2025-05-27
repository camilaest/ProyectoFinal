package org.uniquindio.edu.co.poo.banco.viewController;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.uniquindio.edu.co.poo.banco.App;
import org.uniquindio.edu.co.poo.banco.controller.CajeroController;
import org.uniquindio.edu.co.poo.banco.model.*;

public class CajeroViewController {

        CajeroController cajeroController;
        ObservableList<Cliente> listClientes = FXCollections.observableArrayList();
        ObservableList<Deposito> listDepositos = FXCollections.observableArrayList();
        ObservableList<Retiro> listRetiros = FXCollections.observableArrayList();

        Cliente selectedCliente;




        @FXML
        private TableColumn<Retiro, String> tbcSaldoRetiro;

        @FXML
        private TableColumn<Transaccion, String> tbcCodigoDestino;

        @FXML
        private TableColumn<Transaccion, String> tbcCodigoOrigen;

        @FXML
        private TableView<Retiro> tblListaRetiros;

        @FXML
        private TableColumn<Transaccion, String> tbcSaldoTransferencia;

        @FXML
        private TableColumn<Retiro, String> tbcCodigoCuentaRetiro;

        @FXML
        private TableView<Transaccion> tblListaTransferencias;



        @FXML
        private TableColumn<Deposito, TipoMovimiento> tbcTipoTransaccion;

        @FXML
        private TableColumn<Deposito, String> tbcSaldo;
        @FXML
        private TableView<Deposito> tblListaDepositos;

        @FXML
        private TableColumn<Deposito, String> tbcCodigoCuenta;


        @FXML
        private RadioButton cuentaCorriente;

        @FXML
        private RadioButton cuentaAhorros;

        @FXML
        private RadioButton cuentaEmpresarial;

        private ToggleGroup tipoCuentas;

        @FXML
        private Button btnRealizarDeposito;

        @FXML
        private Button btnRealizarRetiros;

        @FXML
        void onRealizarDeposito(ActionEvent event) {
                mostrarVentanaDeposito();
        }

        @FXML
        void onRealizarRetiros(ActionEvent event) {

        }


        @FXML
        private TextField txtContraseña;

        @FXML
        private TextField txtNombre;


        @FXML
        private TextField txtApellidos;

        @FXML
        private Button btnRegistrarCliente;

        @FXML
        private TextField txtEmail;

        @FXML
        private TextField txtNombreUsuario;

        @FXML
        private TextField txtCedula;

        @FXML
        void onRegistrarCliente(ActionEvent event) {
                registrarCliente();
        }

        @FXML
        private TableView<Cliente> tblListClientes;

        @FXML
        private TableColumn<Cliente, String> tbcCedula;

        @FXML
        private TableColumn<Cliente, String> tbcNombre;

        @FXML
        private TableColumn<Cliente, String> tbcApellidos;

        @FXML
        private TableColumn<Cliente, String> tbcEmail;


        @FXML
        void onActualizarCliente() {
                actualizarCliente();
        }

        @FXML
        void onLimpiar() {
                limpiarSeleccion();
        }

        @FXML
        void onEliminar() {
                eliminarCliente();
        }




        App app;

        @FXML
        void initialize() {
                this.app=app;
                this.cajeroController= new CajeroController(app.banco);
                initView();
                tipoCuentas = new ToggleGroup();

                cuentaCorriente.setToggleGroup(tipoCuentas);
                cuentaAhorros.setToggleGroup(tipoCuentas);
                cuentaEmpresarial.setToggleGroup(tipoCuentas);
        }

        public void setApp(App app) {
                this.app = app;

        }


        private void initView() {
                // Traer los datos del cliente a la tabla
                initDataBinding();
                // Obtiene la lista
                obtenerClientes();
                // Limpiar la tabla
                tblListClientes.getItems().clear();
                // Agregar los elementos a la tabla
                tblListClientes.setItems(listClientes);
                // Seleccionar elemento de la tabla
                listenerSelection();

                //deposito
                initDataBindingDeposito();
                obtenerDepositos();
                tblListaDepositos.getItems().clear();
                // Agregar los elementos a la tabla
                tblListaDepositos.setItems(listDepositos);

                // retiro
                initDataBindingRetiro();
                obtenerRetiros();
                tblListaRetiros.getItems().clear();
                // Agregar los elementos a la tabla
                tblListaRetiros.setItems(listRetiros);




        }


        private void mostrarVentanaDeposito() {
                app.mostrarVentanaDeposito("Realizar Deposito");
                System.out.println("Botón Deposito presionado.");
        }

        @FXML
        private void mostrarVentanaRetirar() {
                app.mostrarVentanaRetirar("Realizar Retiro");
                System.out.println("Botón Retiro presionado.");
        }

        private void initDataBinding() {
                tbcCedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
                tbcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
                tbcApellidos.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellidos()));
                tbcEmail.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));
                // Usamos SimpleObjectProperty para manejar Double y Integer correctamente
        }

        private void obtenerClientes() {
                listClientes.addAll(cajeroController.obtenerListaClientes());
        }

        private void listenerSelection() {
                tblListClientes.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
                        selectedCliente = newSelection;
                        mostrarInformacionCliente(selectedCliente);
                });
        }



        private void registrarCliente() {
                Cliente cliente = buildCliente();
                Usuario usuario = buildUsuario();
                if(cajeroController.registrarCliente(cliente)){
                        cajeroController.registrarUsuario(usuario);
                        // registrar cuenta
                        String tipoCuenta = obtenerTipoCuenta();
                        cajeroController.registrarCuenta(tipoCuenta);

                        listClientes.add(cliente);
                }
        }


        private void eliminarCliente() {
                if (cajeroController.eliminarCliente(txtCedula.getText())) {
                        listClientes.remove(selectedCliente);
                        limpiarCamposCliente();
                        limpiarSeleccion();
                }
        }



        private void actualizarCliente() {

                if (selectedCliente != null &&
                        cajeroController.actualizarCliente(selectedCliente.getCedula(), buildCliente())) {

                        int index = listClientes.indexOf(selectedCliente);
                        if (index >= 0) {
                                listClientes.set(index, buildCliente());
                        }

                        tblListClientes.refresh();
                        limpiarSeleccion();
                        limpiarCamposCliente();
                }
        }

        private Cliente buildCliente() {
                Cliente cliente = new Cliente(txtNombre.getText(), txtApellidos.getText(), txtCedula.getText(), txtEmail.getText());
                return cliente;
        }

        private Usuario buildUsuario() {
                Usuario usuario = new Usuario(txtNombreUsuario.getText(), txtContraseña.getText(), "Cliente");
                return usuario;
        }

        private void mostrarInformacionCliente(Cliente cliente) {
                if (cliente != null) {
                        txtCedula.setText(cliente.getCedula());
                        txtNombre.setText(cliente.getNombre());
                        txtApellidos.setText(cliente.getApellidos());
                        txtEmail.setText(cliente.getEmail());
                }
        }


        private void limpiarSeleccion() {
                tblListClientes.getSelectionModel().clearSelection();
                limpiarCamposCliente();
        }

        private void limpiarCamposCliente() {
                txtCedula.clear();
                txtNombre.clear();
                txtApellidos.clear();
                txtEmail.clear();
                txtNombreUsuario.clear();
                txtContraseña.clear();
        }

        public String obtenerTipoCuenta () {
                Toggle selectedToggle = tipoCuentas.getSelectedToggle();
                String tipoCuenta = "";
                if (selectedToggle != null) {
                        RadioButton selectedRadioButton = (RadioButton) selectedToggle;
                        tipoCuenta = selectedRadioButton.getText();
                        System.out.println("Cuenta seleccionada: " + tipoCuenta);
                } else {
                        System.out.println("Debe seleccionar un tipo de cuenta.");
                }
                return tipoCuenta;
        }


        private void initDataBindingDeposito() {
                tbcCodigoCuenta.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCodigoCuentaADepositar()));
                tbcSaldo.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getSaldoADepositar())));
                //tbcTipoTransaccion.setCellValueFactory(cellData -> new SimpleObjectProperty<>(((Deposito) cellData.getValue() ).getTipoTransaccion()));

        }

        private void obtenerDepositos() {
                listDepositos.addAll(cajeroController.obtenerListaDeposito());
        }

        private void initDataBindingRetiro() {
                tbcCodigoCuentaRetiro.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCodigoCuenta()));
                tbcSaldoRetiro.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getSaldoRetiro())));
                //tbcTipoTransaccion.setCellValueFactory(cellData -> new SimpleObjectProperty<>(((Deposito) cellData.getValue() ).getTipoTransaccion()));

        }

        private void obtenerRetiros() {
                listRetiros.addAll(cajeroController.obtenerListaRetiros());
        }

}




