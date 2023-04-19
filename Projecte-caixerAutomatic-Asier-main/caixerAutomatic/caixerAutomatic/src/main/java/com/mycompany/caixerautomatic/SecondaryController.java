package com.mycompany.caixerautomatic;

//MENU LOGIN
import java.io.IOException;
import javafx.fxml.FXML;

    public class SecondaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("third");
    } 
    
    @FXML
    private void menuOpcions() throws IOException {
        App.setRoot("third");
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

