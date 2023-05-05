/**
 * Controller de la classe extra: Depòsit.
 */
package com.mycompany.caixerautomatic;


import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DepositController {

    @FXML
    private TextField depositField;

    @FXML
    private Text resultText;

    private Deposit deposit;

    public DepositController() {
        deposit = new Deposit();
    }

    @FXML
    public void depositMoney(ActionEvent event) {
        try {
            double amount = Double.parseDouble(depositField.getText());
            deposit.depositar(amount);
            resultText.setText("Depósito realizado. Nuevo saldo: " + deposit.getSaldo());
        } catch (NumberFormatException e) {
            resultText.setText("Entrada inválida. Por favor, introduzca un número.");
        }
    }

/**
 * Torna a la vista anterior.
 * @throws IOException Si hi ha algun problema en carregar la vista anterior.
 */
@FXML
private void tornarEnrere() throws IOException {
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


