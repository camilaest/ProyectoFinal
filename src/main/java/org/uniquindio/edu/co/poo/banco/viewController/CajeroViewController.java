package org.uniquindio.edu.co.poo.banco.viewController;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.uniquindio.edu.co.poo.banco.App;
import org.uniquindio.edu.co.poo.banco.controller.CajeroController;
import org.uniquindio.edu.co.poo.banco.model.Cajero;
import org.uniquindio.edu.co.poo.banco.model.Cliente;
import org.uniquindio.edu.co.poo.banco.model.Usuario;

public class CajeroViewController {

        CajeroController cajeroController;
        ObservableList<Cliente> listClientes = FXCollections.observableArrayList();
        Cliente selectedCliente;


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
}




