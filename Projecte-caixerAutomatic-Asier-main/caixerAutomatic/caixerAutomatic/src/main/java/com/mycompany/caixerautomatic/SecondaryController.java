/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.caixerautomatic;

import java.io.IOException;
import javafx.fxml.FXML;

/**
 *
 * @author alumne
 */
public class SecondaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("third");
    }
}

