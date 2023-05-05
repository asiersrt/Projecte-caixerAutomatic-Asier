/**
 * Classe PrimaryController que gestiona la interfície d'usuari principal de l'aplicació del caixer automàtic.
 * Aquesta classe proporciona un controlador per a la vista principal de l'aplicació, que permet a l'usuari
 * navegar a altres parts de l'aplicació mitjançant un menú al fer Login.
 * @author Asier Rodriguez
 * @version 1.0
 */

package com.mycompany.caixerautomatic;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void comptesUsuari() throws IOException {
        App.setRoot("secondary");
    }       
}

