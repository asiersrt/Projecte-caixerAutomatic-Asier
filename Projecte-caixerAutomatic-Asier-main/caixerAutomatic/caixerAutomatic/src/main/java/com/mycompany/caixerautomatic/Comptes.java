
package com.mycompany.caixerautomatic;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class Comptes {

    @FXML
    Button comptecorrent;
    
    @FXML
    Button compteestalvis;
    
    private boolean compte;
    
      public void initialize(){
    }

public void comptes(ActionEvent event) throws IOException {

    if(event.getSource().equals(comptecorrent)){
        compte = true;
        App.comptes=compte;
        App.setRoot("comptecorrent");
    }
    
    else{
        
        compte=false;
        App.comptes=compte;
        App.setRoot("compteestalvis");
    }
    

    }
    
} 
