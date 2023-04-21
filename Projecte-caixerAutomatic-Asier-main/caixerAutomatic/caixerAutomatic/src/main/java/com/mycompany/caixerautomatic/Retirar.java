/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.caixerautomatic;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Retirar extends Application {
    private double saldo; // Saldo actual del cajero
    private Label saldoLabel; // Label para mostrar el saldo actual en la interfaz de usuario

    // Método para depositar dinero en el cajero
    private void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad; // Sumar la cantidad al saldo actual
            saldoLabel.setText("Saldo actual: $" + saldo); // Actualizar el label de saldo en la interfaz de usuario
            System.out.println("Se han depositado $" + cantidad + " en el cajero.");
        } else {
            System.out.println("Error: la cantidad debe ser mayor a 0.");
        }
    }

    // Método para retirar dinero del cajero
    private void retirar(double cantidad) {
        if (cantidad > 0 && saldo >= cantidad) {
            saldo -= cantidad; // Restar la cantidad del saldo actual
            saldoLabel.setText("Saldo actual: $" + saldo); // Actualizar el label de saldo en la interfaz de usuario
            System.out.println("Se han retirado $" + cantidad + " del cajero.");
        } else {
            System.out.println("Error: la cantidad debe ser mayor a 0 y no puede ser mayor al saldo actual.");
        }
    }

    // Método para inicializar la interfaz de usuario
    @Override
    public void start(Stage primaryStage) {
        saldo = 0.0; // Inicializar saldo en 0.0

        // Crear elementos de la interfaz de usuario
        Label tituloLabel = new Label("Cajero Automático");
        saldoLabel = new Label("Saldo actual: $" + saldo);
        TextField cantidadTextField = new TextField();
        cantidadTextField.setPromptText("Ingrese la cantidad a depositar/retirar");
        Button depositarButton = new Button("Depositar");
        Button retirarButton = new Button("Retirar");

        // Configurar acciones del botón de depósito
        depositarButton.setOnAction(e -> {
            try {
                double cantidad = Double.parseDouble(cantidadTextField.getText());
                depositar(cantidad);
                cantidadTextField.clear();
            } catch (NumberFormatException ex) {
                System.out.println("Error: la cantidad ingresada no es válida.");
            }
        });

        // Configurar acciones del botón de retiro
        retirarButton.setOnAction(e -> {
            try {
                double cantidad = Double.parseDouble(cantidadTextField.getText());
                retirar(cantidad);
                cantidadTextField.clear();
            } catch (NumberFormatException ex) {
                System.out.println("Error: la cantidad ingresada no es válida.");
            }
        });

        // Crear contenedor para los elementos de la interfaz de usuario
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));
        vbox.getChildren().addAll(tituloLabel, saldoLabel, cantidadTextField, depositarButton, retirarButton);

        // Crear la escena y mostrarla en la ventana
        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setTitle("Cajero Automático");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Método principal para ejecutar la aplicación
    public static void main(String[] args) {
launch(args);
}
}
