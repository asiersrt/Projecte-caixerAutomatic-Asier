/**
* La classe BitlletsController és el controlador per a la vista dels bitllets del caixer automàtic.
*/
package com.mycompany.caixerautomatic;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class BitlletsController implements Initializable {

@FXML
private Label billetesLabel;

/**
 * Actualitza la informació dels bitllets en el label de la vista.
 */
@FXML
private void onBitlletsButtonClicked() {
    actualizarBilletesLabel();
}

private Caixer caixer;

/**
 * Estableix el caixer per a aquest controlador.
 * @param caixer El caixer a establir.
 */
public void setCaixer(Caixer caixer) {
    this.caixer = caixer;
}

/**
 * Actualitza el label de la vista amb la informació dels bitllets del caixer.
 */
public void actualizarBilletesLabel() {
    StringBuilder sb = new StringBuilder();
    sb.append("Billets en el caixer:\n");
    for (Caixer.Billete billete : caixer.getBilletes()) {
        sb.append("Billets de ").append(billete.getDenominacion()).append(": ").append(billete.getCantidad()).append("\n");
    }
    billetesLabel.setText(sb.toString());
}

/**
 * Inicialitza el controlador.
 * @param location La URL de la localització de l'arxiu FXML.
 * @param resources Els recursos utilitzats per a la vista.
 */
@Override
public void initialize(URL location, ResourceBundle resources) {
    actualizarBilletesLabel(); 
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
    
/**
 * Torna a la vista anterior.
 * @throws IOException Si hi ha algun problema en carregar la vista anterior.
 */
@FXML
private void tornarEnrere() throws IOException {
    App.setRoot("secondary");
    }

}
