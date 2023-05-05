/**
* La classe Moviment representa un moviment realitzat per un usuari del caixer automàtic.
*/
package com.mycompany.caixerautomatic;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Moviment {
    
/**
* Enumeració que representa els possibles tipus de moviment.
*/
public enum Tipus {
    INGRES,
    RETIRADA;
}

private LocalDateTime data;
private String tipus;
private double quantitat;
private String compte;

/**
 * Constructor per a la classe Moviment.
 * @param tipus El tipus de moviment realitzat.
 * @param quantitat La quantitat de diners involucrada en el moviment.
 * @param compte El compte en el que s'ha realitzat el moviment.
 */
public Moviment(Tipus tipus, double quantitat, String compte) {
    this.data = LocalDateTime.now();
    this.tipus = tipus.toString();
    this.quantitat = quantitat;
    this.compte = compte;
}

/**
 * Retorna una representació en forma de String del moviment.
 * @return Una cadena de caràcters que representa el moviment.
 */
@Override
public String toString() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    String dataFormateada = data.format(formatter);
    return "Moviment ==> {" + "Data = " + dataFormateada + "  |  Tipus =" + tipus + " |  Quantitat =" + quantitat + "€  |  Compte = "+ compte+ '}';
}

/**
 * Implementació dels Getters i Setters
 * @return Una cadena de Getters i Setters.
 */
public LocalDateTime getData() {
    return data;
}

public void setData(LocalDateTime data) {
    this.data = data;
}

public String getTipus() {
    return tipus;
}

public void setTipus(String tipus) {
    this.tipus = tipus;
}

public double getQuantitat() {
    return quantitat;
}

public void setQuantitat(double quantitat) {
    this.quantitat = quantitat;
}

public String getCompte() {
    return compte;
}

public void setCompte(String compte) {
    this.compte = compte;
    }
}
