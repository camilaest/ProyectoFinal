package org.uniquindio.edu.co.poo.banco.viewController;
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
import org.uniquindio.edu.co.poo.banco.controller.AdministradorController;
import org.uniquindio.edu.co.poo.banco.controller.CajeroController;
import org.uniquindio.edu.co.poo.banco.model.Administrador;
import org.uniquindio.edu.co.poo.banco.model.Cajero;
import org.uniquindio.edu.co.poo.banco.model.Cliente;
import org.uniquindio.edu.co.poo.banco.model.Usuario;

public class AdministradorViewController {

    AdministradorController administradorController;
    ObservableList<Cajero> listCajeros = FXCollections.observableArrayList();
    Cajero selectedCajero;

        @FXML
        private TextField txtContraseña;

        @FXML
        private TextField txtApellidos;

        @FXML
        private TextField txtEmail;

        @FXML
        private Button btnRegistrarCajero;

        @FXML
        private TextField txtNombreUsuario;

        @FXML
        private TableColumn<Cajero, String> tbcCedula;

        @FXML
        private TextField txtCedula;

        @FXML
        private Button btnLimpiarCajero;

        @FXML
        private TableView<Cajero> tblListCajeros;

        @FXML
        private TextField txtNombre;

        @FXML
        private TableColumn<Cajero, String > tbcNombre;

        @FXML
        private TableColumn<Cajero, String> tbcApellidos;

        @FXML
        private Button btnEliminarCajero;

        @FXML
        private TableColumn<Cajero, String> tbcEmail;

        @FXML
        void onRegistrarCajero(ActionEvent event) {
            registrarCajero();
        }

        @FXML
        void butto(ActionEvent event) {

        }

        @FXML
        void onLimpiarCajero(ActionEvent event) {
            limpiarSeleccion();

        }

        @FXML
        void onEliminarCajero(ActionEvent event) {
            eliminarCajero();
        }

    App app;
    @FXML
    void initialize() {
        this.app=app;
        this.administradorController= new AdministradorController(app.banco);
        initView();
    }
    public void setApp(App app) {
        this.app = app;
    }
    private void initView() {
        // Traer los datos del cliente a la tabla
        initDataBinding();

        // Obtiene la lista
        obtenerCajero();

        // Limpiar la tabla
        tblListCajeros.getItems().clear();

        // Agregar los elementos a la tabla
        tblListCajeros.setItems(listCajeros);

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

    private void obtenerCajero() {
        listCajeros.addAll(administradorController.obtenerListaCajeros());
    }

    private void listenerSelection() {
        tblListCajeros.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedCajero = newSelection;
            mostrarInformacionCajero(selectedCajero);
        });
    }
    private void registrarCajero() {
        Cajero cajero = buildCajero();
        Usuario usuario = buildUsuario();
        if(administradorController.registrarCajero(cajero)){
            administradorController.registrarUsuario(usuario);
            listCajeros.add(cajero);
        }
    }
    private void eliminarCajero() {
        if (administradorController.eliminarCajero(txtCedula.getText())) {
            listCajeros.remove(selectedCajero);
            limpiarCamposCajero();
            limpiarSeleccion();
        }
    }
    private void actualizarCajero() {

        if (selectedCajero != null &&
                administradorController.actualizarCajero(selectedCajero.getCedula(), buildCajero())) {

            int index = listCajeros.indexOf(selectedCajero);
            if (index >= 0) {
                listCajeros.set(index, buildCajero());
            }

            tblListCajeros.refresh();
            limpiarSeleccion();
            limpiarCamposCajero();
        }
    }
    private Cajero buildCajero() {
        Cajero cajero = new Cajero(txtNombre.getText(), txtApellidos.getText(), txtCedula.getText(), txtEmail.getText());
        return cajero;
    }
    private Usuario buildUsuario() {
        Usuario usuario = new Usuario(txtNombreUsuario.getText(), txtContraseña.getText(), "Cajero");
        return usuario;
    }
    private void mostrarInformacionCajero(Cajero cajero) {
        if (cajero != null) {
            txtCedula.setText(cajero.getCedula());
            txtNombre.setText(cajero.getNombre());
            txtApellidos.setText(cajero.getApellidos());
            txtEmail.setText(cajero.getEmail());
        }
    }
    private void limpiarSeleccion() {
        tblListCajeros.getSelectionModel().clearSelection();
        limpiarCamposCajero();
    }
    private void limpiarCamposCajero() {
        txtCedula.clear();
        txtNombre.clear();
        txtApellidos.clear();
        txtEmail.clear();
        txtNombreUsuario.clear();
        txtContraseña.clear();
    }
}
