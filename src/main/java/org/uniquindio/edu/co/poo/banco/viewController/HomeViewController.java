package org.uniquindio.edu.co.poo.banco.viewController;


import javafx.fxml.FXML;
import org.uniquindio.edu.co.poo.banco.App;

public class HomeViewController {

    App app;

    @FXML
    void initialize() {
        this.app=app;

    }
    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    private void handleClientes() {
        app.mostrarVentanaInicioSesion(" Cliente");
        System.out.println("Botón Clientes presionado.");
    }

    @FXML
    private void handleAdmin() {
        app.mostrarVentanaInicioSesion(" Administrador");
        System.out.println("Botón Admin presionado.");
    }

    @FXML
    private void handleCajeros() {
        app.mostrarVentanaInicioSesion(" Cajero");
        System.out.println("Botón Cajeros presionado.");
    }
}

