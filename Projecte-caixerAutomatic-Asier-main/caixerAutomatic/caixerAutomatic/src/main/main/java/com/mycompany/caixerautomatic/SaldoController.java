/**
* La classe SaldoController és el controlador per a la vista de saldo del caixer automàtic.
*/
package com.mycompany.caixerautomatic;
import java.io.IOException;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.stage.Stage;

public class SaldoController {

Usuari usuariActual = App.sessio;
List<Comptes> comptes = usuariActual.getComptes();

@FXML
private ComboBox<Comptes> comboBoxComptes;

@FXML
private Label labelSaldo;

@FXML
private Label labelSaldoTotal;

/**
 * Inicialitza la vista de saldo. Crea el ComboBox de comptes i actualitza les etiquetes de saldo total i de saldo del compte seleccionat.
 */
@FXML
void initialize() {
    comboBoxComptes.getItems().addAll(comptes);
    comboBoxComptes.setCellFactory(param -> new ListCell<Comptes>() {
        @Override
        protected void updateItem(Comptes compte, boolean empty) {
            super.updateItem(compte, empty);
            if (empty || compte == null) {
                setText(null);
            } else {
                setText(String.format("Compte %s - %s", compte.getNumeroDeCuenta(), compte.getTipusCompte()));
            }
        }
    });
    comboBoxComptes.setOnAction(event -> {
        Comptes compteSeleccionat = comboBoxComptes.getSelectionModel().getSelectedItem();
        if (compteSeleccionat != null) {
            double saldo = compteSeleccionat.getSaldo();
            labelSaldo.setText("Saldo: " + saldo);
        }
    });
    double saldoTotal = 0;
    for (Comptes compte : comptes) {
        saldoTotal += compte.getSaldo();
    }
    labelSaldoTotal.setText(String.format("Saldo total entre totes les comptes: %.2f", saldoTotal));
}

/**
 * Torna a la vista anterior.
 * @throws IOException Si hi ha algun problema en carregar la vista anterior.
 */
@FXML
void tornarEnrere() throws IOException {
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
