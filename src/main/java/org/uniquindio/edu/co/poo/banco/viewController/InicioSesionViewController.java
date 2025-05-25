package org.uniquindio.edu.co.poo.banco.viewController;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.uniquindio.edu.co.poo.banco.App;
import org.uniquindio.edu.co.poo.banco.controller.CajeroController;
import org.uniquindio.edu.co.poo.banco.controller.InicioSesionController;

public class InicioSesionViewController {
    @FXML private TextField correoField;
    @FXML private PasswordField contrasenaField;
    private App app;
    InicioSesionController inicioSesionController;

    @FXML
    void initialize() {
        this.app=app;
    }

    public void setApp(App app) {
        this.app = app;
        this.inicioSesionController = new InicioSesionController(app.banco); // ok aquí

    }

    @FXML
    private void handleLogin() {
        String usuario = correoField.getText();
        String contrasena = contrasenaField.getText();
        String role= "";

        if(inicioSesionController.iniciarSesion(usuario, contrasena)) {
            role=inicioSesionController.buscarRoleUsuario(usuario);
            if(role.equals("Cajero")){

                app.mostrarVentanaCajero();
            } else if (role.equals("Administrador")) {
                app.mostrarVentanaAdministrador();
            }else{
            }
        }
        // Aquí puedes agregar lógica para validar el login
    }
}
