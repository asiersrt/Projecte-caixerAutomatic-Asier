package com.mycompany.caixerautomatic;

import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Login extends Application {

    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";
    private static final int MAX_ATTEMPTS = 3;
    private int attempts = 0;
    private boolean locked = false;

    @Override
    public void start(Stage primaryStage) {

        // Create UI controls
        Label titleLabel = new Label("Bank ATM");
        titleLabel.setFont(new Font("Arial", 24));

        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();

        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();

        Button loginButton = new Button("Login");

        // Set button action
        loginButton.setOnAction(event -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            if (locked) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Account is locked!");
                alert.showAndWait();
                return;
            }

            if (username.equals(USERNAME) && password.equals(PASSWORD)) {

                attempts = 0;

            } else {
                attempts++;
                if (attempts == MAX_ATTEMPTS) {
                    // Lock the account after too many failed attempts
                    locked = true;
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Too many failed attempts! Account is now locked.");
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid username or password");
                    alert.showAndWait();
                }
            }
        });

        
    }

    public static void main(String[] args) {
        launch(args);
    }
}


