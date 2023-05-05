/**
 * Classe Usuari que representa un usuari del caixer automàtic.
 * Conté informació com l'usuari, la contrasenya i els comptes associats.
 */
package com.mycompany.caixerautomatic;

import java.util.ArrayList;
import java.util.List;

public class Usuari {
    private String usuari;
    private String contrasenya;
    private ArrayList<Comptes> comptes;
    private int idUsuari;
    
    /**
     * Constructor d'Usuari amb saldo principal i saldo d'estalvis.
     * @param usuari El nom d'usuari.
     * @param contrasenya La contrasenya de l'usuari.
     * @param saldoPrincipal El saldo del compte principal.
     * @param saldoEstalvis El saldo del compte d'estalvis.
     */
    public Usuari(String usuari, String contrasenya, double saldoPrincipal, double saldoEstalvis) {
        this.usuari = usuari;
        this.contrasenya = contrasenya;
        this.comptes = new ArrayList<>();
        this.comptes.add(new Comptes(String.valueOf(saldoPrincipal), "Principal", saldoPrincipal));
        this.comptes.add(new Comptes(String.valueOf(saldoEstalvis), "Estalvis", saldoEstalvis));
    }
    
    /**
     * Constructor d'Usuari sense saldos.
     * @param usuari El nom d'usuari.
     * @param contrasenya La contrasenya de l'usuari.
     */
    public Usuari(String usuari, String contrasenya) {
        this.usuari = usuari;
        this.contrasenya = contrasenya;
        this.comptes = new ArrayList<>();
    }
    
    /**
     * Afegeix un compte amb el tipus i saldo especificats.
     * @param tipusCompte El tipus de compte.
     * @param saldo El saldo inicial del compte.
     */
    public void agregarComptePerTipus(String tipusCompte, double saldo) {
        this.comptes.add(new Comptes(String.valueOf(saldo), tipusCompte, saldo));
    }

    /**
     * Getters i Setters
     * @return Getters i Setters
     */
    @Override
    public String toString() {
        return "Usuari{" + "usuari=" + usuari + ", contrasenya=" + contrasenya + ", comptes=" + comptes.toString() + ", idUsuari=" + idUsuari + '}';
    }

    public String getUsuari() {
        return usuari;
    }

    public void setUsuari(String usuari) {
        this.usuari = usuari;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public ArrayList<Comptes> getComptes() {
        return comptes;
    }

    public void setComptes(ArrayList<Comptes> comptes) {
        this.comptes = comptes;
    }

    public int getIdUsuari() {
        return idUsuari;
    }

    public void setIdUsuari(int idUsuari) {
        this.idUsuari = idUsuari;
    }

    public void agregarCompte(Comptes compte) {
        comptes.add(compte);
    }

    public List<Moviment> getMoviments() {
        List<Moviment> moviments = new ArrayList<>();
        for (Comptes compte : this.comptes) {
            moviments.addAll(compte.getMoviments());
        }
        return moviments;
    }
}
