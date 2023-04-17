package com.mycompany.caixerautomatic;

//MENU LOGIN
import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("secondary");
    }
}

