/**
* La classe MovimentsController és el controlador per a la vista de moviments del caixer automàtic.
*/
package com.mycompany.caixerautomatic;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MovimentsController {
    
@FXML
private ListView<Moviment> movimientosListView;
    
/**
 * Actualitza la llista de moviments a la vista amb els moviments de l'usuari actual.
 */
public void actualizarMovimientosListView() {
    Usuari usuarioActual = App.sessio;
    if (usuarioActual != null) {
        ObservableList<Moviment> movimientos = FXCollections.observableArrayList(usuarioActual.getMoviments());
        movimientosListView.setItems(movimientos);
    }
}

/**
 * Inicialitza el controlador.
 */
@FXML
private void initialize() {
    Usuari usuario = App.sessio;
    if (usuario != null) {
        movimientosListView.getItems().addAll(usuario.getMoviments());
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

