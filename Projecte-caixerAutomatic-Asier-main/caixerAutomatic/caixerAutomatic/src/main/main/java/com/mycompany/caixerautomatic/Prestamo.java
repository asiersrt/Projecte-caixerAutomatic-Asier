/**
 * La classe Prestamo representa un préstec amb un import, una taxa d'interès i un termini d'amortització.
 * Aquesta classe permet calcular el pagament mensual i realitzar pagaments al préstec.
 */
package com.mycompany.caixerautomatic;

public class Prestamo {
    private double monto;
    private double tasaInteres;
    private int plazoAmortizacion;
    private double cantidadAdeudada;
    
    /**
    * Constructor que crea una instància de Prestamo amb els paràmetres especificats.
    * @param monto El muntant total del préstec.
    * @param tasaInteres La taxa d'interès anual aplicada al préstec.
    * @param plazoAmortizacion El termini en mesos per pagar el préstec.
    */
    public Prestamo(double monto, double tasaInteres, int plazoAmortizacion) {
        this.monto = monto;
        this.tasaInteres = tasaInteres;
        this.plazoAmortizacion = plazoAmortizacion;
        this.cantidadAdeudada = monto;
    }
    /**
    * Mètode que retorna el muntant total del préstec.
    * @return El muntant total del préstec.
    */
    public double getMonto() {
        return monto;
    }
    
    /**
    * Mètode que retorna la taxa d'interès anual aplicada al préstec.
    * @return La taxa d'interès anual aplicada al préstec.
    */
    public double getTasaInteres() {
        return tasaInteres;
    }
    
    /**
    * Mètode que retorna el termini en mesos per pagar el préstec.
    * @return El termini en mesos per pagar el préstec.
    */
    public int getPlazoAmortizacion() {
        return plazoAmortizacion;
    }
    
    /**
    * Mètode que retorna la quantitat adeudada actualment del préstec.
    * @return La quantitat adeudada actualment del préstec.
    */
    public double getCantidadAdeudada() {
        return cantidadAdeudada;
    }
    
    /**
    * Mètode que estableix el muntant total del préstec.
    * @param monto El nou muntant total del préstec.
    */
    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    /**
    * Mètode que estableix la taxa d'interès anual aplicada al préstec.
    * @param tasaInteres La nova taxa d'interès anual aplicada al préstec.
    */
    public void setTasaInteres(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }
    
    /**
    * Mètode que estableix el termini en mesos per pagar el préstec.
    * @param plazoAmortizacion El nou termini en mesos per pagar el préstec.
    */
    public void setPlazoAmortizacion(int plazoAmortizacion) {
        this.plazoAmortizacion = plazoAmortizacion;
    }
    
    /**
    * Mètode que estableix la quantitat adeudada actualment del préstec.
    * @param cantidadAdeudada La nova quantitat adeudada actualment del préstec.
    */
    public void setCantidadAdeudada(double cantidadAdeudada) {
        this.cantidadAdeudada = cantidadAdeudada;
    }
    
    /**
    * Mètode que calcula el pagament mensual que ha de realitzar el deutor per pagar el préstec.
    * @return El pagament mensual que ha de realitzar el deutor per pagar el préstec.
    */
    public double calcularPagoMensual() {
        double tasaMensual = tasaInteres / 12.0 / 100.0;
        double denominador = Math.pow((1 + tasaMensual), plazoAmortizacion) - 1;
        return monto * tasaMensual * Math.pow((1 + tasaMensual), plazoAmortizacion) / denominador;
    }
    
    /**
    * Mètode que realitza el pagament especificat pel deutor al préstec.
    * @param pago La quantitat de diners que el deutor vol pagar.
    * @return True si el pagament es pot realitzar i s'ha actualitzat la quantitat adeudada; false si la quantitat de pagament és incorrecta.
    */
    public boolean realizarPago(double pago) {
        if (pago >= 0 && pago <= cantidadAdeudada) {
            cantidadAdeudada -= pago;
            return true;
        } else {
            return false;
        }
    }
}
