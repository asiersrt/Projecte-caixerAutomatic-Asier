/**
* La classe PrestamoController és el controlador per a la vista de préstec del caixer automàtic.
*/
package com.mycompany.caixerautomatic;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PrestamoController {

Usuari usuariActual = App.sessio;

@FXML
private TextField txtMonto;

@FXML
private TextField txtTasaInteres;

@FXML
private TextField txtPlazoAmortizacion;

@FXML
private Label lblMontoPrestamo;

@FXML
private Label lblPagoMensual;

/**
 * Calcula el pagament mensual del préstec amb les dades proporcionades per l'usuari i actualitza les etiquetes de la vista.
 * @param event L'esdeveniment del botó clicat.
 */
@FXML
void calcularPrestamo(ActionEvent event) {
    double monto = Double.parseDouble(txtMonto.getText());
    double tasaInteres = Double.parseDouble(txtTasaInteres.getText());
    int plazoAmortizacion = Integer.parseInt(txtPlazoAmortizacion.getText());

    Prestamo prestamo = new Prestamo(monto, tasaInteres, plazoAmortizacion);
    double pagoMensual = prestamo.calcularPagoMensual();

    lblMontoPrestamo.setText("Monto del préstamo: " + monto);
    lblPagoMensual.setText(String.format("Pago mensual: %.2f", pagoMensual));
}

/**
 * Torna a la vista anterior.
 * @param event L'esdeveniment del botó clicat.
 * @throws IOException Si hi ha algun problema en carregar la vista anterior.
 */
@FXML
void tornarEnrere(ActionEvent event) throws IOException {
    App.setRoot("secondary");
}

/**
 * Tanca la finestra actual.
 * @param event L'esdeveniment del botó clicat.
 */
@FXML
public void sortir(ActionEvent event) {
    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    window.close();
    }
}
