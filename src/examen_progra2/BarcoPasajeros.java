/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen_progra2;

import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Tommy Lee Pon
 */
public class BarcoPasajeros extends Barco{
    private String[] pasajeros;
    private final int capacidad;
    private final double precioBoleto;
    private int totPasajeros;
    
    public BarcoPasajeros(String name, Calendar fecha, int capacidad, double precio){
        super(name, fecha);
        this.capacidad=capacidad;
        pasajeros=new String[this.capacidad];
        precioBoleto=precio;
        totPasajeros=0;
    }
    
    private String listarPasajerosRecursive(int cero){
        if(cero<capacidad){
            if(pasajeros[cero]!=null){
                return pasajeros[cero] + "\n" + listarPasajerosRecursive(cero+1);
            }
            return listarPasajerosRecursive(cero+1);
        }
        return "";
    }
    
    private int firstNullIndex(int cero){
        if(cero<capacidad){
            if (pasajeros[cero] == null)
                return cero;
            return firstNullIndex(cero+1);
        }
        return cero;
    }
    
    @Override
    public void agregarElemento(){
        if(firstNullIndex(0)<capacidad){
            String pasajero = JOptionPane.showInputDialog(null,"Nombre del pasajero:");
            pasajeros[firstNullIndex(0)]=pasajero;
            totPasajeros++;
        } else {
            JOptionPane.showMessageDialog(null, "Barco lleno");
        }
    }

    @Override
    public double vaciarCobrar() {
        double ingreso = totPasajeros*precioElemento();
        totPasajeros = 0;
        return ingreso;
    }

    @Override
    public double precioElemento() {
        return precioBoleto;
    }
    
    public String listarPasajeros(){
        return listarPasajerosRecursive(0);
    }
    
    @Override
    public String toString(){
        return super.toString() + " | Tipo: Pasajeros | Cantidad de boletos vendidos : " + totPasajeros;
    }
}
