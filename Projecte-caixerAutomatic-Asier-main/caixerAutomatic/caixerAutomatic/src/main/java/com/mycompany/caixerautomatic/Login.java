/**
* La classe Login és el controlador per a la vista de login del caixer automàtic.
*/
package com.mycompany.caixerautomatic;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Login {

@FXML
TextField usuari;

@FXML
private PasswordField contrasenya;

@FXML
private Button login;

@FXML
private Label missatge;

private int intents = 0;

/**
 * Inicia la sessió de l'usuari si les credencials són correctes i obre la vista secundària.
 * @throws IOException Si hi ha algun problema en carregar la vista secundària.
 */
@FXML
public void login() throws IOException {
    String user = usuari.getText();
    String password = contrasenya.getText();
    App.nom = user;

    if (user.equals("") || password.equals("")) {
        missatge.setText("Omple tots els camps.");
    } else {
        Usuari sessio = App.getBanc().obtenirUsuariPerCredencials(user, password);
        if (sessio != null) {
            App.setSessio(sessio);
            System.out.println("Sessió iniciada");
            App.setRoot("secondary");
        } else {
            intents++;
            if (intents == 3) {
                login.setDisable(true);
                missatge.setText("Usuari o contrasenya incorrectes. Has superat el número màxim d'intents.");
            } else {
                missatge.setText("Usuari o contrasenya incorrectes. Intent " + intents + " de 3.");
                }
            }
        }
    }
}
