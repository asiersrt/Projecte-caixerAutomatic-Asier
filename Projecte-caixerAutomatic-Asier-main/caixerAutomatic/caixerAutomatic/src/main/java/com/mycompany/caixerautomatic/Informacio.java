/**
 * Classe per mostrar informació extra del Caixer automàtic.
 */
package com.mycompany.caixerautomatic;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

public class Informacio {
    
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

