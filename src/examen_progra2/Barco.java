/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen_progra2;

import java.util.Calendar;

/**
 *
 * @author Tommy Lee Pon
 */
public abstract class Barco {
    protected String nombre;
    protected Calendar fecha;
    
    public Barco(String name, Calendar fecha){
        nombre=name;
        this.fecha=fecha;
    }
    
    //getters
    public String getNombre(){
        return nombre;
    }
    public Calendar getFecha(){
        return fecha;
    }
    
    @Override
    public String toString(){
        return "Nombre: " + nombre;
    }
    
    //abstractas
    public abstract void agregarElemento();
    public abstract double vaciarCobrar();
    public abstract double precioElemento();
}
