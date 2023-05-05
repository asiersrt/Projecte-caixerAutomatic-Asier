/*
 * La classe Deposit representa un dipòsit bancari amb un saldo determinat
 * Es pot depositar una quantitat de diners per augmentar el saldo.
 * També es pot consultar el saldo actual. Aquest depòsit serveix al usuari per veure quina quantitat li pot anar bé depositar.
 */
package com.mycompany.caixerautomatic;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

public class Deposit {
    private double saldo;
    private Comptes cuentaUsuario;
    
    /**
    * Crea un dipòsit amb saldo inicial 0.
    */
    public Deposit() {
        saldo = 0;
    }
    
    /**
    * Obté el saldo actual del dipòsit.
    * @return el saldo actual
    */
    public double getSaldo() {
        return saldo;
    }
    
    /**
    * Realitza un dipòsit de la quantitat especificada i actualitza el saldo del dipòsit.
    * @param cantidad la quantitat a dipositar
    */
    public void depositar(double cantidad) {
        saldo += cantidad;
        System.out.println("Depósito realizado. Nuevo saldo: " + saldo);
    }
    
    /**
    * Mètode main que demostra l'ús de la classe Deposit.
    * Deposita una quantitat de 1000 al dipòsit i mostra el saldo actual.
    * @param args arguments de la línia de comandes (no s'utilitzen)
    */
    public static void main(String[] args) {
        Deposit miDeposito = new Deposit();
        double cantidad = 1000;
        miDeposito.depositar(cantidad);
    }
    
    /**
    * Torna a la vista anterior.
    * @throws IOException Si hi ha algun problema en carregar la vista anterior.
    */
    @FXML
    void tornarEnerere() throws IOException {
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

