module com.mycompany.caixerautomatic {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.caixerautomatic to javafx.fxml;
    exports com.mycompany.caixerautomatic;
}
