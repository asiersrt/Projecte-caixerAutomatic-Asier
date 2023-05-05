/**
* La classe Retirar és un controlador que gestiona l'interfície gràfica per a la retirada de diners d'un compte bancari.
* Es comunica amb la classe App per obtenir l'usuari en sessió i amb la classe Comptes per accedir a les seves dades.
*/
package com.mycompany.caixerautomatic;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class Retirar {

    @FXML
    TextField dinerotxt;
    @FXML
    private ComboBox<Comptes> comboBoxCuentas;
    @FXML
    Label labelSaldo;
    @FXML
    Button retirarbtn;

    //Botons
    @FXML
    Button btn500;
    @FXML
    Button btn200;
    @FXML
    Button btn100;
    @FXML
    Button btn50;
    @FXML
    Button btn20;
    @FXML
    Button btn10;


    double totalRetiro = 0;
    int cnt500 = 0;
    int cnt200 = 0;
    int cnt100 = 0;
    int cnt50 = 0;
    int cnt20 = 0;
    int cnt10 = 0;
    
/**
* Maneja la acción del botón de retirar. Obtiene la cuenta seleccionada del combo box y la cantidad de dinero a retirar del campo de texto.
* Luego llama al método retirar de la clase Comptes para intentar realizar el retiro y muestra un mensaje de éxito o error dependiendo
* del resultado.
*/
@FXML
void handleRetirar() {
    Comptes cuentaSeleccionada = comboBoxCuentas.getSelectionModel().getSelectedItem();
    if (cuentaSeleccionada != null) {
        double cantidadRetirar = Double.parseDouble(dinerotxt.getText());
        boolean retiroExitoso = cuentaSeleccionada.retirar(cantidadRetirar); 

        if (retiroExitoso) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Retiro exitoso");
            alert.setHeaderText(null);
            alert.setContentText("El retiro se realizó con éxito");
            alert.showAndWait();
            
            labelSaldo.setText("Saldo: " + cuentaSeleccionada.getSaldo());
            dinerotxt.setText("");
            totalRetiro = 0;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error en el retiro");
            alert.setHeaderText(null);
            alert.setContentText("El retiro no pudo ser completado. Por favor, verifica el monto y el saldo disponible.");
            alert.showAndWait();
        }
    }
}

/**
* Inicialitza el controlador.
*/
    @FXML
    void initialize() {
    Usuari usuarioEnSesion = App.getSessio(); 
    List<Comptes> cuentas = usuarioEnSesion.getComptes(); 

    comboBoxCuentas.getItems().addAll(cuentas);
    comboBoxCuentas.setCellFactory(param -> new ListCell<Comptes>() {
        @Override
        protected void updateItem(Comptes cuenta, boolean empty) {
            super.updateItem(cuenta, empty);
            if (empty || cuenta == null) {
                setText(null);
            } else {
                setText(String.format("Cuenta %s", cuenta.getNumeroDeCuenta())); 
            }
        }
    });
    
/**
* Maneja el evento de selección de cuenta en el comboBoxCuentas. Actualiza el labelSaldo con el saldo actual de la cuenta seleccionada.
* Si no hay cuenta seleccionada, el labelSaldo se deja vacío.
*/
        comboBoxCuentas.setOnAction(event -> {
            Comptes cuentaSeleccionada = comboBoxCuentas.getSelectionModel().getSelectedItem();
            if (cuentaSeleccionada != null) {
                double saldo = cuentaSeleccionada.getSaldo(); 
                labelSaldo.setText("Saldo: " + saldo);
            }
        });
        
/**
* Deshabilita el botón de retirar si no hay cuenta seleccionada o si el campo de texto dinerotxt está vacío.
* Se habilita el botón si ambas condiciones son verdaderas.
*/
        retirarbtn.setDisable(true);
        comboBoxCuentas.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            retirarbtn.setDisable(newVal == null || dinerotxt.getText().isEmpty());
        });
        
/**
* Deshabilita el botón de retirar si no hay cuenta seleccionada o si el campo de texto dinerotxt está vacío.
* Se habilita el botón si ambas condiciones son verdaderas.
*/
        dinerotxt.textProperty().addListener((obs, oldVal, newVal) -> {
            retirarbtn.setDisable(comboBoxCuentas.getSelectionModel().isEmpty() || newVal.isEmpty());
        });
        
        /**
        * Maneja el evento del botón btn500 para agregar una cantidad de 500 a la cantidad total a retirar.
        * También incrementa el contador cnt500 y actualiza el campo de texto dinerotxt.
        */
        btn500.setOnAction(event -> {
            totalRetiro += 500;
            dinerotxt.setText(Double.toString(totalRetiro));
            cnt500++;
        });

        btn200.setOnAction(event -> {
            totalRetiro += 200;
            dinerotxt.setText(Double.toString(totalRetiro));
            cnt200++;
        });

        btn100.setOnAction(event -> {
            totalRetiro += 100;
            dinerotxt.setText(Double.toString(totalRetiro));
            cnt100++;
        });

        btn50.setOnAction(event -> {
            totalRetiro += 50;
            dinerotxt.setText(Double.toString(totalRetiro));
            cnt50++;
        });

        btn20.setOnAction(event -> {
            totalRetiro += 20;
            dinerotxt.setText(Double.toString(totalRetiro));
            cnt20++;
        });

        btn10.setOnAction(event -> {
            totalRetiro += 10;
            dinerotxt.setText(Double.toString(totalRetiro));
            cnt10++;
        });
    }
    
    /**
    * Torna a la vista anterior.
    * @param event IOException Si hi ha algun problema en carregar la vista anterior.
    */
    @FXML
    public void sortir(ActionEvent event) {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.close();
    }
    
    /**
    * Tanca la finestra actual.
    * @param event L'esdeveniment del botó clicat.
    */    
    @FXML
    private void tornarEnrere() throws IOException {
        App.setRoot("secondary");
    }
}
