/**
 * Classe que representa una targeta de crèdit associada a una compte corrent.
 * Aquest apartat no trobarà una tarjeta associada als comptes corrents perquè primer l'usuari la té que demanar en físic.
 */
package com.mycompany.caixerautomatic;

public class Tarjeta {
    private String numeroTarjeta;
    private String fechaExpiracion;
    private String codigoSeguridad;
    private double limiteCredito;
    private double saldo;
    private Comptes cuentaAsociada;
    
    /**
     * Constructor de la classe Tarjeta.
     * @param numeroTarjeta El número de la targeta.
     * @param fechaExpiracion La data d'expiració de la targeta.
     * @param codigoSeguridad El codi de seguretat de la targeta.
     * @param limiteCredito El límit de crèdit de la targeta.
     * @param cuentaAsociada La compte corrent associada a la targeta.
     * @throws IllegalArgumentException Si la compte associada no és de tipus "Corriente".
     */
    public Tarjeta(String numeroTarjeta, String fechaExpiracion, String codigoSeguridad, double limiteCredito, Comptes cuentaAsociada) {
    this.numeroTarjeta = numeroTarjeta;
    this.fechaExpiracion = fechaExpiracion;
    this.codigoSeguridad = codigoSeguridad;
    this.limiteCredito = limiteCredito;
    this.saldo = 0;

    this.cuentaAsociada = cuentaAsociada;



    if (cuentaAsociada != null && cuentaAsociada.getTipusCompte().equals("Corriente")) {
    this.cuentaAsociada = cuentaAsociada;
    } else {
    throw new IllegalArgumentException("La tarjeta de crédito solo se puede asociar a cuentas corrientes.");
        }

    }
    
    /**
     * Mètode que realitza una compra amb la targeta de crèdit.
     * @param monto El muntant de la compra.
     * @return true si la compra s'ha realitzat amb èxit, false si no s'ha pogut realitzar per falta de crèdit disponible.
     */
    public boolean realizarCompra(double monto) {
        if (monto > 0 && monto <= (limiteCredito - saldo)) {
            saldo += monto;
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Mètode que realitza un pagament amb la targeta de crèdit.
     * @param monto El muntant del pagament.
     * @return true si el pagament s'ha realitzat amb èxit, false si no s'ha pogut realitzar per manca de fons disponibles a la compte corrent.
     */
    public boolean realizarPago(double monto) {
    if (cuentaAsociada != null && monto > 0 && monto <= saldo && cuentaAsociada.getSaldo() >= monto) {
        cuentaAsociada.retirar(monto);
        saldo -= monto;
        return true;
    } else {
        return false;
        }
    }

    
    /**
     * Obté el número de la tarjeta.
     * @return El número de la tarjeta.
     */
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }
    
    /**
     * Estableix el número de la tarjeta.
     * @param numeroTarjeta El número de la tarjeta.
     */
    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }
    
    /**
     * Obté la data d'expiració de la tarjeta.
     * @return La data d'expiració de la tarjeta.
     */
    public String getFechaExpiracion() {
        return fechaExpiracion;
    }
    
    /**
    * Setter de la data d'expiració de la targeta.
    * @param fechaExpiracion La data d'expiració de la targeta en format "MM/YY".
    */
    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }
    
    /**
    * Getter del codi de seguretat de la targeta.
    * @return El codi de seguretat de la targeta.
    */
    public String getCodigoSeguridad() {
        return codigoSeguridad;
    }
    
    /**
    * Setter del codi de seguretat de la targeta.
    * @param codigoSeguridad El nou codi de seguretat de la targeta.
    */
    public void setCodigoSeguridad(String codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }
    
    /**
    * Getter del límit de crèdit de la targeta.
    * @return El límit de crèdit de la targeta.
    */
    public double getLimiteCredito() {
        return limiteCredito;
    }
    
    /**
    * Setter del límit de crèdit de la targeta.
    * @param limiteCredito El nou límit de crèdit de la targeta.
    */
    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }
    
    /**
    * Getter del saldo de la targeta.
    * @return El saldo de la targeta.
    */
    public double getSaldo() {
        return saldo;
    }
    
    /**
    * Setter del saldo de la targeta.
    * @param saldo El nou saldo de la targeta.
    */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    /**
    * Getter del compte corrent associat a la targeta.
    * @return El compte corrent associat a la targeta.
    */
    public Comptes getCuentaAsociada() {
        return cuentaAsociada;
    }
    
    /**
    * Setter del compte corrent associat a la targeta.
    * @param cuentaAsociada El nou compte corrent associat a la targeta.
    */
    public void setCuentaAsociada(Comptes cuentaAsociada) {
        this.cuentaAsociada = cuentaAsociada;
    }
}
