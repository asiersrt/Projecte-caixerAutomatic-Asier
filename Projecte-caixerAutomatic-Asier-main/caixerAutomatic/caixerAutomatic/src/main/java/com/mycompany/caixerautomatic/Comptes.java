/**
 * Aquesta classe representa un compte bancari amb un número de compte, tipus de compte, saldo i una llista de moviments.
 */
package com.mycompany.caixerautomatic;

import com.mycompany.caixerautomatic.Moviment.Tipus;
import java.util.ArrayList;
import java.util.List;

public class Comptes {
    private String numeroDeCuenta;
    private String tipusCompte;
    private double saldo;
    private ArrayList<Moviment> moviments;
    
    /**
     * Constructor per defecte.
     */    
    public Comptes() {
    }
    
    /**
     * Constructor que inicialitza el compte amb el número de compte, tipus de compte i saldo especificats.
     * @param numeroDeCuenta el número de compte.
     * @param tipusCompte el tipus de compte.
     * @param saldo el saldo inicial del compte.
     */
    public Comptes(String numeroDeCuenta, String tipusCompte, double saldo) {
        this.numeroDeCuenta = numeroDeCuenta;
        this.tipusCompte = tipusCompte;
        this.saldo = saldo;
        this.moviments = new ArrayList<>();
    }
    
    /**
     * Retorna una representació en cadena de caràcters del compte.
     * @return una cadena que representa el compte.
     */
    @Override
    public String toString() {
        return "{" + "Cuenta = " + numeroDeCuenta + " - " + tipusCompte + '}';
    }
    
    /**
     * Insercció de Getters and Setters.
     * @return cadena Getters and Setters.
     */
    public String getNumeroDeCuenta() {
        return numeroDeCuenta;
    }

    public void setNumeroDeCuenta(String numeroDeCuenta) {
        this.numeroDeCuenta = numeroDeCuenta;
    }

    public String getTipusCompte() {
        return tipusCompte;
    }

    public void setTipusCompte(String tipusCompte) {
        this.tipusCompte = tipusCompte;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public ArrayList<Moviment> getMoviments() {
        return moviments;
    }

    public void setMoviments(ArrayList<Moviment> moviments) {
        this.moviments = moviments;
    }

    public void agregarMovimiento(Moviment movimiento) {
        moviments.add(movimiento);
    }
    
    /**
     * Realitza un retir de fons del compte.
     * @param cantidad la quantitat a retirar.
     * @return true si la retirada ha estat exitosa, false en cas contrari.
     */
    public boolean retirar(double cantidad) {
    if (cantidad > 0 && cantidad <= saldo) {
        saldo -= cantidad;

        Tipus tipoRetiro = Tipus.RETIRADA; 
        Moviment movRetiro = new Moviment(tipoRetiro, cantidad, "Retiro");
        agregarMovimiento(movRetiro);

        return true; 
    } else {
        return false; 
    }
}

    /**
     * Realitza un ingrés de fons al compte.
     * @param cantidad la quantitat a ingressar.
     * @return true si l'ingrés ha estat exitós, false en cas contrari.
     */
    public boolean ingresar(double cantidad) {
    if (cantidad > 0) {
        saldo += cantidad;
        Tipus tipoIngreso = Tipus.INGRES; 
        Moviment movIngreso = new Moviment(tipoIngreso, cantidad, "Ingreso");
        agregarMovimiento(movIngreso);
        
        return true; 
    } else {
        return false;
    }
}

    /**
     * Obté la llista de moviments realitzats en aquest compte.
     * @return una llista de moviments realitzats en aquest compte.
     */
    public List<Moviment> getListaMovimientos() {
        List<Moviment> movimientos = new ArrayList<>();
        for (Moviment moviment : this.moviments) {
            movimientos.add(moviment);
        }
        return movimientos;
    }
}
