/**
 * La clase Transferencia se encarga de realizar transferencias entre cuentas bancarias.
 * 
 * @version 1.0
 */
package com.mycompany.caixerautomatic;

public class Transferencia {
    
    /**
     * Realiza una transferencia de una cuenta de origen a una cuenta de destino.
     * 
     * @param cuentaOrigen la cuenta bancaria de origen
     * @param cuentaDestino la cuenta bancaria de destino
     * @param monto el monto a transferir
     * @return verdadero si la transferencia fue exitosa, falso si no fue posible realizarla
     */
    public static boolean realizarTransferencia(Comptes cuentaOrigen, Comptes cuentaDestino, double monto) {
    if (cuentaOrigen == null || cuentaDestino == null || monto <= 0) {
        return false;
    }
    boolean retirarExitoso = cuentaOrigen.retirar(monto);
    if (retirarExitoso) {
        boolean ingresarExitoso = cuentaDestino.ingresar(monto);
        if (ingresarExitoso) {
            return true;
        } else {
            cuentaOrigen.ingresar(monto);
            }
        }
    return false;
    }
}
