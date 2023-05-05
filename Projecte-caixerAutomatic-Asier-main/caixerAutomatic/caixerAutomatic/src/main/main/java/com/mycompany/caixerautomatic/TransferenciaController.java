/**
* La classe TransferenciaController és responsable de gestionar la pantalla de transferència de diners entre comptes d'usuari.
* Es fa servir per seleccionar la compte d'origen, la compte de destí i la quantitat de diners a transferir.
*/
package com.mycompany.caixerautomatic;

import java.io.IOException;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.stage.Stage;

public class TransferenciaController {

    Usuari usuariActual = App.sessio;
    List<Comptes> comptes = usuariActual.getComptes();

    @FXML
    private ComboBox<Comptes> comboBoxCuentaOrigen;
    @FXML
    private ComboBox<Comptes> comboBoxCuentaDestino;
    @FXML
    private ComboBox<Double> comboBoxMonto;
    
/**
* Mètode que s'executa quan s'inicialitza la pantalla de transferència.
* Configura els ComboBox per mostrar informació sobre les comptes.
*/
    @FXML
    void initialize() {
        comboBoxCuentaOrigen.getItems().addAll(comptes);
        comboBoxCuentaDestino.getItems().addAll(comptes);
        comboBoxMonto.getItems().addAll(10.0, 20.0, 50.0, 100.0, 200.0,500.0); // Puedes cambiar los montos disponibles aquí

        comboBoxCuentaOrigen.setCellFactory(param -> new ListCell<Comptes>() {
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

        comboBoxCuentaDestino.setCellFactory(param -> new ListCell<Comptes>() {
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
    }
    
/**
* Mètode que s'executa quan es prem el botó "Realitzar transferència".
* Obtenir la compte d'origen, la compte de destí i la quantitat de diners seleccionades
* i intenta realitzar la transferència.
*/
    @FXML
    void realizarTransferencia() {
        Comptes cuentaOrigen = comboBoxCuentaOrigen.getSelectionModel().getSelectedItem();
        Comptes cuentaDestino = comboBoxCuentaDestino.getSelectionModel().getSelectedItem();
        Double monto = comboBoxMonto.getSelectionModel().getSelectedItem();

                if (cuentaOrigen != null && cuentaDestino != null && monto != null) {
            boolean resultado = Transferencia.realizarTransferencia(cuentaOrigen, cuentaDestino, monto);
            if (resultado) {
                
                System.out.println("Transferencia realizada con éxito.");
            } else {
                
                System.out.println("La transferencia no se pudo completar.");
            }
        } else {
            
            System.out.println("Por favor, selecciona una cuenta de origen, una cuenta de destino y un monto.");
        }
    }
    
/**
 * Mètode que s'executa quan es prem el botó "Tornar enrere".
 * Torna a la pantalla anterior.
 *
 * @throws IOException si no es pot carregar la pantalla anterior.
 */
    @FXML
    void tornarEnrere() throws IOException {
        App.setRoot("secondary");
    }
    
/**
 * Mètode que s'executa quan es prem el botó "Sortir".
 * Tanca la finestra actual.
 *
 * @param event L'event que ha trigat la crida a aquest mètode.
 */
    @FXML
    public void sortir(ActionEvent event) {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.close();
    }
}


