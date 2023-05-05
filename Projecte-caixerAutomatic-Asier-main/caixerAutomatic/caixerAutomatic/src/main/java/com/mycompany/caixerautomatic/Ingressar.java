/**
 * La classe Ingressar controla la funcionalitat d'ingrés de diners en efectiu en un caixer automàtic.
 * Aquesta classe defineix la interacció amb elements d'interfície d'usuari i les accions
 * d'ingrés de diners en efectiu al compte seleccionat.
 */
package com.mycompany.caixerautomatic;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.Node;

public class Ingressar {

    private MovimentsController movimentsController;

    public void setMovimentsController(MovimentsController movimentsController) {
        this.movimentsController = movimentsController;
    }

    @FXML
    TextField dinerotxt;
    @FXML
    private ComboBox<Comptes> comboBoxCuentas;
    @FXML
    Label labelSaldo;
    @FXML
    Button ingresarbtn;

    double totalIngreso = 0;
    int cnt500 = 0;
    int cnt200 = 0;
    int cnt100 = 0;
    int cnt50 = 0;
    int cnt20 = 0;
    int cnt10 = 0;

    /**
    * Funció que s'executa quan es fa clic al botó "Ingressar". 
    * Ingresa els diners en efectiu en el compte seleccionat i actualitza la informació del compte.
    */
    @FXML
    void ingressar() {
        double dinero = totalIngreso;
        Comptes cuentaSeleccionada = comboBoxCuentas.getSelectionModel().getSelectedItem();
        if (cuentaSeleccionada != null) {
            double saldoActual = cuentaSeleccionada.getSaldo();
            double saldoNuevo = saldoActual + dinero;
            cuentaSeleccionada.setSaldo(saldoNuevo);
            System.out.println(cuentaSeleccionada.getSaldo());
            labelSaldo.setText("Saldo: " + saldoNuevo);

            App.caixer.ingresarBilletes(500, cnt500);
            App.caixer.ingresarBilletes(200, cnt200);
            App.caixer.ingresarBilletes(100, cnt100);
            App.caixer.ingresarBilletes(50, cnt50);
            App.caixer.ingresarBilletes(20, cnt20);
            App.caixer.ingresarBilletes(10, cnt10);

            cnt500 = 0;
            cnt200 = 0;
            cnt100 = 0;
            cnt50 = 0;
            cnt20 = 0;
            cnt10 = 0;

            String numeroDeCuenta = cuentaSeleccionada.getNumeroDeCuenta();
            Moviment moviment = new Moviment(Moviment.Tipus.INGRES, totalIngreso, numeroDeCuenta);
            cuentaSeleccionada.agregarMovimiento(moviment);

            if (movimentsController != null) {
                movimentsController.actualizarMovimientosListView();
            }

            Alert alert = new Alert(Alert.AlertType.INFORMATION, "El ingreso se realizó exitosamente");
            totalIngreso = 0;
            alert.showAndWait();
        }
        dinerotxt.clear();
    }

    /**
    * Inicialitza el controlador de la classe Ingressar. Aquest mètode s'executa després que es carregui el fxml.
    * Configura els elements d'interfície d'usuari, com ara el ComboBox amb els comptes del client i els botons per afegir
    * diners al total d'ingrés. També estableix els listeners per a aquests elements per a habilitar o deshabilitar el botó d'ingrés segons correspongui.
    */
    @FXML
    void initialize() {
        ArrayList<Comptes> comptesList = new ArrayList<>(App.sessio.getComptes());
        comboBoxCuentas.getItems().addAll(comptesList);
        comboBoxCuentas.setCellFactory(param -> new ListCell<Comptes>() {
            @Override
            protected void updateItem(Comptes compte, boolean empty) {
                super.updateItem(compte, empty);

                if (empty || compte == null) {
                    setText(null);
                } else {
                    setText(String.format("Compte %s", compte.getTipusCompte()));
                }
            }
        });
        comboBoxCuentas.setOnAction(event -> {
            Comptes compteSeleccionat = comboBoxCuentas.getSelectionModel().getSelectedItem();
            if (compteSeleccionat != null) {
                double saldo = compteSeleccionat.getSaldo();
                labelSaldo.setText("Saldo: " + saldo);
            }
        });

        ingresarbtn.setDisable(true);
        comboBoxCuentas.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            ingresarbtn.setDisable(newVal == null || dinerotxt.getText().isEmpty());
        });

        dinerotxt.textProperty().addListener((obs, oldVal, newVal) -> {
            ingresarbtn.setDisable(comboBoxCuentas.getSelectionModel().isEmpty() || newVal.isEmpty());
        });
    }
    
    /**
    * Gestiona l'esdeveniment de retornar a la pantalla anterior.
    * Aquest mètode s'executa quan l'usuari prem el botó "Volver".
    * @throws IOException Si hi ha algun problema al carregar la pantalla anterior.
     */
    @FXML
    void volver() throws IOException {
        App.setRoot("secondary");
    }

    /**
    * Afegeix la quantitat especificada de bitllets de 500,200,100,50,20 i 10 euros al total d'ingrés.
    */
    @FXML
    void s500() {
        totalIngreso += 500;
        dinerotxt.setText(Double.toString(totalIngreso));
        cnt500++;
    }

    @FXML
    void s200() {
        totalIngreso += 200;
        dinerotxt.setText(Double.toString(totalIngreso));
        cnt200++;
    }

    @FXML
    void s100() {
        totalIngreso += 100;
        dinerotxt.setText(Double.toString(totalIngreso));
        cnt100++;
    }

    @FXML
    void s50() {
        totalIngreso += 50;
        dinerotxt.setText(Double.toString(totalIngreso));
        cnt50++;
    }

    @FXML
    void s20() {
        totalIngreso += 20;
        dinerotxt.setText(Double.toString(totalIngreso));
        cnt20++;
    }

    @FXML
    void s10() {
        totalIngreso += 10;
        dinerotxt.setText(Double.toString(totalIngreso));
        cnt10++;
    }
    
    /**
    * Torna a la vista anterior.
    * @throws IOException Si hi ha algun problema en carregar la vista anterior.
    */
    @FXML
    void tornarEnrere() throws IOException {
        if (movimentsController != null) {
            movimentsController.actualizarMovimientosListView();
        }
        App.setRoot("secondary");
    }
    
    /**
    * Tanca la finestra actual.
    * @param event L'esdeveniment del botó clicat.
    */
    @FXML
    public void sortir(ActionEvent event) {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.close();
    }
}
