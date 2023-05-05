/**
* La classe SecondaryController és responsable de gestionar les interaccions de l'usuari amb la vista secundària
* de l'aplicació CaixerAutomàtic. Defineix mètodes per canviar entre diferents vistes i tancar l'aplicació.
@author Asier Rodriguez
@version 1.0
*/
package com.mycompany.caixerautomatic;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.io.IOException;

public class SecondaryController {
    
    @FXML
    void tornarEnrere() throws IOException {
        App.setRoot("secondary");
    }
    
    @FXML
    void tarjeta() throws IOException {
        App.setRoot("tarjeta");
    }
    
    @FXML
    void informacio() throws IOException {
        App.setRoot("informacio");
    }
    
    @FXML
    void ingressar() throws IOException {
        App.setRoot("ingressar");
    }
    
    @FXML
    void deposit() throws IOException {
        App.setRoot("deposit");
    }
    
    @FXML
    void retirar() throws IOException {
        App.setRoot("retirar");
    }
    
    @FXML
    void transferencia() throws IOException {
        App.setRoot("transferencia");
    }
    
    @FXML
    void prestamo() throws IOException {
        App.setRoot("prestamo");
    }
    
    @FXML
    void moviment() throws IOException {
        App.setRoot("moviment");
    }
    
    @FXML
    void saldo() throws IOException {
        App.setRoot("saldo");
    }
    
    @FXML
    void bitlletsCaixer() throws IOException {
        App.setRoot("bitllets");
    }
    
    @FXML
    void canviClauAcces() throws IOException {
        App.setRoot("clau");
    }
    
    @FXML
    void canviCompte() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    public void sortir(ActionEvent event) {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.close();
    }
}

    


