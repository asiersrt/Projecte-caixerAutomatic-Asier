/**
 * Controlador de la vista per canviar la contrasenya de l'usuari.
 */
package com.mycompany.caixerautomatic;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class canviClauAcces {

    @FXML
    private TextField usuari;

    @FXML
    private PasswordField contrasenyaActual;

    @FXML
    private PasswordField novaContrasenya;

    @FXML
    private PasswordField confirmarNovaContrasenya;

    @FXML
    private Button canviarContrasenya;

    @FXML
    private Label missatge;

    /**
     * Canvia la contrasenya de l'usuari si es compleixen les condicions.
     * Verifica si les credencials introduïdes són correctes i si la nova contrasenya coincideix amb la confirmació.
     */
    @FXML
    public void canviarContrasenya() {
        String user = usuari.getText();
        String contrasenyaActualText = contrasenyaActual.getText();
        String novaContrasenyaText = novaContrasenya.getText();
        String confirmarNovaContrasenyaText = confirmarNovaContrasenya.getText();

        Usuari usuariActual = App.getBanc().obtenirUsuariPerCredencials(user, contrasenyaActualText);

        if (usuariActual
        != null) {
            if (novaContrasenyaText.equals(confirmarNovaContrasenyaText)) {
                usuariActual.setContrasenya(novaContrasenyaText);
                missatge.setText("La contrasenya s'ha canviat amb èxit.");
            } else {
                missatge.setText("La nova contrasenya i la confirmació de la contrasenya no coincideixen.");
            }
        } else {
            missatge.setText("El nom d'usuari o la contrasenya actual són incorrectes.");
        }
    }

    /**
     * Tanca la finestra actual.
     *
     * @param event L'event que provoca la sortida.
     */
    @FXML
    public void sortir(ActionEvent event) {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.close();
    }

    /**
     * Torna a la vista anterior.
     *
     * @throws IOException En cas d'error en carregar la vista.
     */
    @FXML
    private void tornarEnrere() throws IOException {
        App.setRoot("secondary");
    }
}
