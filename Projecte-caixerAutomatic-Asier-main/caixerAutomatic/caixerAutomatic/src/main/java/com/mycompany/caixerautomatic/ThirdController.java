package com.mycompany.caixerautomatic;

//MENU LOGIN
import java.io.IOException;
import javafx.fxml.FXML;

    public class ThirdController {

    @FXML
    private void switchToThird() throws IOException {
        App.setRoot("third");
        
    }
    
    @FXML
    private void menuSaldo() throws IOException {
        App.setRoot("saldo");
    }
    
    @FXML
    private void menuTransferencia() throws IOException {
        App.setRoot("transferencia");
    }
    
    @FXML
    private void menuIngressar() throws IOException {
        App.setRoot("ingressar");
    }
    
    @FXML
    private void menuRetirar() throws IOException {
        App.setRoot("retirar");
    }
    
    @FXML
    private void menuClauAcces() throws IOException {
        App.setRoot("clau");
    }
    
    @FXML
    private void menuIniciSessio() throws IOException {
        App.setRoot("primary");
    }
    
    
}
