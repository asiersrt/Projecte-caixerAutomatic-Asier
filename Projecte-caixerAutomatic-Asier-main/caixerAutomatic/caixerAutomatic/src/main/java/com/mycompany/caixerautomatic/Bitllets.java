/**
* Classe Bitllets que representa els bitllets amb denominació i quantitat.
*/
package com.mycompany.caixerautomatic;

/**
* Classe Bitllets que representa els bitllets amb denominació i quantitat.
*/
public class Bitllets {
private int denominacion;
private int cantidad;

/**
* Constructor de la classe Bitllets.
* @param denominacion la denominació del bitllet
* @param cantidad la quantitat de bitllets
*/
public Bitllets(int denominacion, int cantidad) {
this.denominacion = denominacion;
this.cantidad = cantidad;
}

/**
* Retorna la denominació del bitllet.
* @return la denominació del bitllet
*/
public int getDenominacion() {
return denominacion;
}

/**
* Estableix la denominació del bitllet.
* @param denominacion la denominació del bitllet
*/
public void setDenominacion(int denominacion) {
this.denominacion = denominacion;
}

/**
* Retorna la quantitat de bitllets.
* @return la quantitat de bitllets
*/
public int getCantidad() {
return cantidad;
}

/**
* Estableix la quantitat de bitllets.
* @param cantidad la quantitat de bitllets
*/
public void setCantidad(int cantidad) {
this.cantidad = cantidad;

    }
}