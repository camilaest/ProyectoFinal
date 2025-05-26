package org.uniquindio.edu.co.poo.banco;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.uniquindio.edu.co.poo.banco.model.*;
import org.uniquindio.edu.co.poo.banco.viewController.*;


import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class App extends Application {

    private Stage primaryStage;
    private Stage loginStage;
    //public static Empresa empresa = new Empresa("UQ");

    public static Banco banco = new Banco("Davivienda", "Armenia");



    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Banco");
        openViewPrincipal();
    }

    private void openViewPrincipal() {
        inicializarData();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("primary.fxml"));
            Parent rootLayout = loader.load();
            PrimaryViewController primaryViewController = loader.getController();
            primaryViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }

    public void openHome() {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("home.fxml"));
            Parent rootLayout = loader.load();
            HomeViewController homeViewController = loader.getController();
            homeViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



    }

    public void mostrarVentanaInicioSesion(String titulo) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("inicioSesion.fxml"));
            Parent rootLayout = loader.load();
            InicioSesionViewController inicioSesionViewController = loader.getController();
            inicioSesionViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarVentanaCajero() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("cajero.fxml"));
            Parent rootLayout = loader.load();
            CajeroViewController cajeroViewController = loader.getController();
            cajeroViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarVentanaAdministrador() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("administrador.fxml"));
            Parent rootLayout = loader.load();
            AdministradorViewController administradorViewController = loader.getController();
            administradorViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //servicios

    public void inicializarData(){

        Usuario u1= new Usuario("santiago", "1234", "Cajero");
        Usuario u2 = new Usuario("luis", "234", "Administrador");
        Usuario u3 = new Usuario("carolina", "345", "Cliente");
        Cliente cliente1 = new Cliente("Maria", "Diaz", "567", "maria@D");
        Cajero cajero1 = new Cajero("sofia", "bernan", "567", "sofia@");
        CuentaAhorros cuentaAhorros = new CuentaAhorros (2000, 4, LocalDate.now(), 50000);
        Deposito deposito = new Deposito(cuentaAhorros.getCodigo(), 5000, LocalDateTime.now(), TipoMovimiento.DEPOSITO);
        banco.registrarDeposito(deposito);
        System.out.println(banco.getListaDepositos());
        banco.registrarUsuario(u1);
        banco.registrarUsuario(u2);
        banco.registrarUsuario(u3);
        cliente1.agregarCuenta(cuentaAhorros);
        banco.registrarCliente(cliente1);
        banco.registrarCajero(cajero1);
        banco.registrarCuenta2(cuentaAhorros);


    }

    public void mostrarVentanaDeposito(String titulo) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("deposito.fxml"));
            Parent rootLayout = loader.load();
            DepositoViewController depositoViewController = loader.getController();
            depositoViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarVentanaRetirar(String titulo) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("retirar.fxml"));
            Parent rootLayout = loader.load();
            RetirarViewController retirarViewController = loader.getController();
            retirarViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}