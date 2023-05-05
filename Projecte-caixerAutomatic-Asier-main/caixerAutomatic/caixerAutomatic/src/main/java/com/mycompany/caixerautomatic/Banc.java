/**
* La classe Banc representa un banc que conté una llista de clients.
*/
package com.mycompany.caixerautomatic;

import java.util.ArrayList;

public class Banc {
    private String nom;
    private ArrayList<Usuari> clients;

/**
 * Constructor per a la classe Banc.
 * @param nom El nom del banc.
 */
public Banc(String nom) {
    this.nom = nom;
    this.clients = new ArrayList<>();
}

/**
 * Retorna l'usuari amb les credencials especificades o null si no existeix.
 * @param user El nom d'usuari a cercar.
 * @param password La contrasenya de l'usuari a cercar.
 * @return L'usuari amb les credencials especificades o null si no existeix.
 */
public Usuari obtenirUsuariPerCredencials(String user, String password) {
    for (Usuari usuari : clients) {
        if (usuari.getUsuari().equals(user) && usuari.getContrasenya().equals(password)) {
            return usuari;
        }
    }
    return null;
}

/**
 * Retorna una representació en cadena de caràcters del banc.
 * @return Una representació en cadena de caràcters del banc.
 */
@Override
public String toString() {
    return "Banc{" + "nom=" + nom + ", clients=" + clients.toString() + '}';
}

/**
 * Retorna el nom del banc.
 * @return El nom del banc.
 */
public String getNom() {
    return nom;
}

/**
 * Estableix el nom del banc.
 * @param nom El nou nom del banc.
 */
public void setNom(String nom) {
    this.nom = nom;
}

/**
 * Retorna la llista de clients del banc.
 * @return La llista de clients del banc.
 */
public ArrayList<Usuari> getClients() {
    return clients;
}

/**
 * Estableix la llista de clients del banc.
 * @param clients La nova llista de clients del banc.
 */
public void setClients(ArrayList<Usuari> clients) {
    this.clients = clients;
}

/**
 * Afegeix un client al banc.
 * @param client El client a afegir.
 */
public void afegirClient(Usuari client) {
    clients.add(client);
}

/**
 * Busca i retorna un client a partir del seu nom d'usuari i la contrasenya.
 * @param nomUsuari El nom d'usuari del client a cercar.
 * @param contrasenya La contrasenya del client a cercar.
 * @return El client amb el nom d'usuari i la contrasenya especificats o null si no existeix.
 */
public Usuari buscarClient(String nomUsuari, String contrasenya) {
    for (Usuari client : clients) {
        if (client.getUsuari().equals(nomUsuari) && client.getContrasenya().equals(contrasenya)) {
            System.out.println("Usuari trobat");
            return client;
        }
    }
    return null;
}

/**
 * Comprova si un usuari amb les credencials especificades existeix al banc.
 * @param usuari El nom d'usuari a cercar.
 * @param contrasenya La contrasenya de l'usuari a cercar.
 * @return Cert si l'usuari amb les credencials especificades existeix al banc, fals altrament.
 */
public boolean comprovarUsuari(String usuari, String contrasenya) {
    for (Usuari client : clients) {
        if (client.getUsuari().equals(usuari) && client.getContrasenya().equals(contrasenya)) {
            return true;
        }
    }
    return false;
    }
}
