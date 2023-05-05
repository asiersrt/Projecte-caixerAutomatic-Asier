/**
*La classe TarjetaController és responsable de gestionar la pantalla de la targeta de crèdit, on es poden realitzar compres i pagaments.
* Es fa servir per visualitzar el saldo actual de la targeta i actualitzar-lo després de cada transacció.
*/
package com.mycompany.caixerautomatic;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TarjetaController {
    Usuari usuariActual = App.sessio;
    Comptes cuentaCorriente = buscarCuentaCorriente(usuariActual);
    Tarjeta tarjeta;

    @FXML
    private TextField txtMontoCompra;
    @FXML
    private TextField txtMontoPago;
    @FXML
    private Label lblResultadoCompra;
    @FXML
    private Label lblResultadoPago;
    
/**
* Mètode que cerca la compte corrent de l'usuari actual.
* @param usuario L'usuari actual de l'aplicació.
* @return La compte corrent de l'usuari actual.
*/
    private Comptes buscarCuentaCorriente(Usuari usuario) {
        for (Comptes cuenta : usuario.getComptes()) {
            if (cuenta.getTipusCompte().equals("Corriente")) {
                return cuenta;
            }
        }
        return null;
    }
    
/**
* Mètode que s'executa quan s'inicialitza la pantalla de la targeta.
* Configura el text que mostra el saldo actual de la targeta.
*/
    @FXML
    void initialize() {
        cuentaCorriente = buscarCuentaCorriente(usuariActual);
        if (cuentaCorriente != null) {
            tarjeta = new Tarjeta("1234567812345678", "12/25", "123", 5000, cuentaCorriente);
        }
    }
    
/**
* Mètode que s'executa quan es prem el botó "Realitzar compra".
* Obtenir el muntant de la compra introduït, intentar realitzar la compra amb la targeta
* i actualitzar el saldo de la targeta si la compra s'ha efectuat amb èxit.
* @param event L'event que ha trigat la crida a aquest mètode.
*/
@FXML
void realizarCompra(ActionEvent event) {
    double monto = Double.parseDouble(txtMontoCompra.getText());

    if (tarjeta == null) {
        cuentaCorriente = buscarCuentaCorriente(usuariActual);
        if (cuentaCorriente != null) {
            tarjeta = new Tarjeta("1234567812345678", "12/25", "123", 5000, cuentaCorriente);
        } else {
            lblResultadoCompra.setText("No se encontró una tarjeta asociada.");
            return;
        }
    }

    boolean resultado = tarjeta.realizarCompra(monto);
    if (resultado) {
        lblResultadoCompra.setText("Compra exitosa");
    }
}
    
    
/**
 * Mètode que s'executa quan es prem el botó "Realitzar pagament".
 * Obtenir el muntant del pagament introduït, intentar realitzar el pagament amb la targeta
 * i actualitzar el saldo de la targeta si el pagament s'ha efectuat amb èxit.
 * @param event L'event que ha trigat la crida a aquest mètode.
 */
    @FXML
void realizarPago(ActionEvent event) {
    double monto = Double.parseDouble(txtMontoPago.getText());
    if (tarjeta == null) {
        cuentaCorriente = buscarCuentaCorriente(usuariActual);
        if (cuentaCorriente != null) {
            tarjeta = new Tarjeta("1234567812345678", "12/25", "123", 5000, cuentaCorriente);
        } else {
            lblResultadoPago.setText("No se encontró una tarjeta asociada.");
            return;
        }
    }
    boolean resultado = tarjeta.realizarPago(monto);
    if (resultado) {
        lblResultadoPago.setText("Pago exitoso");
    }
}
    
/**
 * Mètode que s'executa quan es prem el botó "Tornar enrere".
 * Torna a la pantalla anterior.
 * @throws IOException si no es pot carregar la pantalla anterior.
 */
    @FXML
    void tornarEnrere() throws IOException {
        App.setRoot("secondary");
    }
    
/**
 * Mètode que s'executa quan es prem el botó "Sortir".
 * Tanca la finestra actual.
 * @param event L'event que ha trigat la crida a aquest mètode.
 */
    @FXML
    public void sortir(ActionEvent event) {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.close();
    }
}

