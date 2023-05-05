/**
 * App del Caixer Automàtic M03 per Asier Rodriguez Simona
 */
package com.mycompany.caixerautomatic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Començo obrint una classe d'App on creo una Escena i un Banc
 */
public class App extends Application {

private static Scene scene;
static Banc banc;

/**
 * Sessió actual del usuari on definim: la sessió del usuari, 2 clients, 
 * un nou caixer, el nom i els comptes
 */
static Usuari sessio;
static Usuari client1;
static Usuari client2;
public static Caixer caixer = new Caixer();
static String nom;
static boolean comptes;

/**
* Retorna l'objecte Banc de l'aplicació.
* @return l'objecte Banc de l'aplicació
*/
public static Banc getBanc() {
return banc;
}

/**
* Retorna l'usuari de la sessió actual.
* @return l'usuari de la sessió actual
*/
public static Usuari getSessio() {
return sessio;
}

/**
* Estableix l'usuari de la sessió actual.
* @param usuari l'usuari de la sessió
*/
public static void setSessio(Usuari usuari) {
sessio = usuari;
}

/**
* Inicia l'aplicació amb l'escenari proporcionat.
* @param stage l'escenari on es carregarà l'aplicació
* @throws IOException si no es pot carregar l'arxiu FXML
*/
@Override
public void start(Stage stage) throws IOException {

    caixer = new Caixer();

    banc = new Banc("SRT BANK");
    client1 = new Usuari("Asier", "Asier", 2400, 4200);
    client2 = new Usuari("Ismael", "2004", 1500, 3000);
    banc.afegirClient(client1);
    banc.afegirClient(client2);

    scene = new Scene(loadFXML("primary"), 700, 600);
    stage.setScene(scene);
    stage.show();
}


/**
* Estableix la vista arrel de la finestra.
* @param fxml nom de l'arxiu FXML a carregar
* @throws IOException si no es pot carregar l'arxiu FXML
*/
static void setRoot(String fxml) throws IOException {
scene.setRoot(loadFXML(fxml));
}

/**
* Carrega l'arxiu FXML especificat.
* @param fxml nom de l'arxiu FXML a carregar
* @return un objecte Parent que conté la vista FXML carregada
* @throws IOException si no es pot carregar l'arxiu FXML
*/
private static Parent loadFXML(String fxml) throws IOException {
FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
return fxmlLoader.load();
}

/**
* Mètode principal per iniciar l'aplicació.
* @param args arguments de la línia de comandes
*/
public static void main(String[] args) {
launch();
    }
}
