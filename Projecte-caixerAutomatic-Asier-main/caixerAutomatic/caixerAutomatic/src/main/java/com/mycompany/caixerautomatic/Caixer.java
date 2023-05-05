/**
 * Aquesta classe representa un caixer automàtic que gestiona billets de diferents denominacions.
 */
package com.mycompany.caixerautomatic;

import java.util.ArrayList;
import java.util.List;

public class Caixer {
    private List<Billete> billetes;
    private boolean operacion;
    
    /**
     * Constructor per defecte que inicialitza els billets en el caixer.
     */
    public Caixer() {
        billetes = new ArrayList<>();
        billetes.add(new Billete(500, 100));
        billetes.add(new Billete(200, 100));
        billetes.add(new Billete(100, 100));
        billetes.add(new Billete(50, 100));
        billetes.add(new Billete(20, 100));
        billetes.add(new Billete(10, 2));
        this.operacion = true;
    }
    
    /**
     * Obté la llista de billets disponibles en el caixer.
     * @return llista de billets disponibles.
     */
    public List<Billete> getBilletes() {
        return billetes;
    }
    
    /**
     * Obté el billet amb la denominació especificada.
     * @param denominacion la denominació del billet a obtenir.
     * @return el billet amb la denominació especificada, null si no està disponible.
     */
    public Billete getBillete(int denominacion) {
        for (Billete billete : billetes) {
            if (billete.getDenominacion() == denominacion) {
                return billete;
            }
        }
        return null;
    }
    
    /**
     * Comprova si el caixer està en funcionament.
     * @return true si el caixer està operatiu, false en cas contrari.
     */
    public boolean isOperacion() {
        return operacion;
    }
    
    /**
     * Estableix si el caixer està en funcionament.
     * @param operacion el nou estat operacional del caixer.
     */
    public void setOperacion(boolean operacion) {
        this.operacion = operacion;
    }
    
    /**
     * Calcula els billets a retirar segons la quantitat especificada.
     * @param cantidad la quantitat a retirar.
     * @return llista de billets a retirar.
     */
    public List<Billete> calcularBilletes(double cantidad) {
    List<Billete> billetesARetirar = new ArrayList<>();
    int[] denominaciones = {500, 200, 100, 50, 20, 10, 5};
    double cantidadRestante = cantidad;

    for (int i = 0; i < denominaciones.length; i++) {
        int billetesNecesarios = (int) (cantidadRestante / denominaciones[i]);
        cantidadRestante = cantidadRestante % denominaciones[i];
        if (billetesNecesarios > 0) {
            billetesARetirar.add(new Billete(denominaciones[i], billetesNecesarios));
        }
    }
    return billetesARetirar;
}

    /**
     * Afegeix billets al caixer amb la denominació i quantitat especificades.
     * @param denominacion la denominació dels billets a afegir.
     * @param cantidad la quantitat de billets a afegir.
     */
    public void ingresarBilletes(int denominacion, int cantidad) {
    Billete billete = getBillete(denominacion);
    if (billete != null) {
        int cantidadAnterior = billete.getCantidad();
        billete.setCantidad(cantidadAnterior + cantidad);
        if (billete.getCantidad() != cantidadAnterior) {
            System.out.println("Quantitat de billetes en el caixer després del ingrés: " + App.caixer.toString());
        }
    }
}

    /**
     * Retira els billets especificats de la llista.
     * @param billetesARetirar la llista de billets a retirar.
     * @return true si la retirada ha estat exitosa, false en cas contrari.
     */
    public boolean retirarBilletes(List<Billete> billetesARetirar) {
    for (Billete billeteARetirar : billetesARetirar) {
        int denominacion = billeteARetirar.getDenominacion();
        int cantidad = billeteARetirar.getCantidad();
        Billete billete = getBillete(denominacion);
        if (billete != null && billete.getCantidad() - cantidad >= 0) {
            billete.setCantidad(billete.getCantidad() - cantidad);
        } else {
            return false;
        }
    }
    return true;
}

    /**
     * Retorna una representació en cadena de caràcters del caixer.
     * @return una cadena que representa el caixer i els billets que conté.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Caixer{");
        for (Billete billete : billetes) {
            sb.append(billete.getDenominacion()).append("€=").append(billete.getCantidad()).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length()); // Eliminar la última coma y espacio
        sb.append("}");
        return sb.toString();
    }
    
    /**
     * Aquesta classe representa un billet amb una denominació i una quantitat específiques.
     */
    public class Billete {
        private int denominacion;
        private int cantidad;
        
        /**
         * Constructor que inicialitza el billet amb la denominació i la quantitat especificades.
         * @param denominacion la denominació del billet.
         * @param cantidad la quantitat d'aquest tipus de billet.
         */
        public Billete(int denominacion, int cantidad) {
            this.denominacion = denominacion;
            this.cantidad = cantidad;
        }
        
        /**
         * Obté la denominació del billet.
         * @return la denominació del billet.
         */
        public int getDenominacion() {
            return denominacion;
        }
        
        /**
         * Estableix la denominació del billet.
         * @param denominacion la nova denominació del billet.
         */
        public void setDenominacion(int denominacion) {
            this.denominacion = denominacion;
        }
        
        /**
         * Obté la quantitat d'aquest tipus de billet.
         * @return la quantitat d'aquest tipus de billet.
         */
        public int getCantidad() {
            return cantidad;
        }
        
        /**
         * Estableix la quantitat d'aquest tipus de billet.
         * @param cantidad la nova quantitat d'aquest tipus de billet.
         */
        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        } 
    }
}
