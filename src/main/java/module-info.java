module org.uniquindio.edu.co.poo.banco {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens org.uniquindio.edu.co.poo.banco to javafx.fxml;
    exports org.uniquindio.edu.co.poo.banco;
    exports org.uniquindio.edu.co.poo.banco.viewController;
    opens org.uniquindio.edu.co.poo.banco.viewController to javafx.fxml;

}