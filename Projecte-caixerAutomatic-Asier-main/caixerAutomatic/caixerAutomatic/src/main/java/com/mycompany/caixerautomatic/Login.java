package com.mycompany.caixerautomatic;

import java.io.IOException;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class Login {

    //Crearem les caixes, botons i textos necessaris
    
    @FXML
    TextField usuari;
    
    @FXML
    PasswordField contrasenya;
    
    @FXML
    Button login;
    
    @FXML
    Label missatge;
    
    int intents = 0;
    
    
    public void initialize(){
    }

    //Crearem el llistat de usuaris i un de les seves contrasenyes
    //Després demanarem a l'usuari que introdueixi l'usuari i contrasenya que ell vulgui

    public void login() throws IOException {
        
    String[] usuaris = {"asier","manel", "jon", "ismael"};
    String[] contrasenyes = {"asier", "manel", "jon", "ismael"};
    
    String user = usuari.getText();
    String password = contrasenya.getText();
    App.nom = user;
    
                
    //Validació en cas de introduïr bé les dades       
    //La validació diu: si quaalsevol usuari introduït coinsideix amb la seva contrasenya corresponent passarà a la següent pantalla
    
    for (int i = 0; i < usuaris.length; i++) {
                if (usuaris[i].equals(user) && contrasenyes[i].equals(password)) {
                    App.setRoot("secondary");   
                    
                }
            }
    
    
    //Validació en cas d'errors
    
            for (int i = 0; i< usuaris.length; i++){
                
                //Aquí comprova si: 1.El usuari i contrasenya no coincideixen. 2.La contrasenya no coincideix amb l'usuari. 3.L'Usuari no coincideix amb la contrasenya
                
                     if (!usuaris[i].equals(user) && !contrasenyes[i].equals(contrasenya) || 
                     usuaris[i].equals(user) && !contrasenyes[i].equals(contrasenya) || 
                     !usuaris[i].equals(user) && contrasenyes[i].equals(contrasenya)) {
                
                //Aquí comprova que no hi ha cap camp omplert i envia un missatge advertint a l'usuari
                
                     }else if (user.equals("") || contrasenya.equals("")) {
                     missatge.setText("Rellena todos los campos");
                  
                //Per cada vegada que l'usuari s'equivoqui és sumarà un 1 al int dels intents:
                
                    intents++;
                    missatge.setText("Els valors \n introduẗs són incorrectes "+intents+" vegada/es");
                    
                //Si s'acumulen 3 errors l'usuari deixarà de poder intentar entrar al sistema i el programa l'avisarà amb un missatge
                
                    if (intents == 3) {
                        usuari.setEditable(false);
                        contrasenya.setEditable(false);
                        missatge.setText("Error, has introduït els valors incorrectament moltes vegades");
                    }
                }
                break;
            }
    }
}