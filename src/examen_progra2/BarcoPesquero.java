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
public class BarcoPesquero extends Barco{
    private int pecesCapturados;
    private final TipoPesquero tipo;
    
    public BarcoPesquero(String name, Calendar fecha, TipoPesquero extra){
        super(name,fecha);
        pecesCapturados=0;
        tipo=extra;
    }
    
    @Override
    public void agregarElemento(){
        pecesCapturados++;
    }
    
    @Override
    public double vaciarCobrar(){
        double total = pecesCapturados*precioElemento();
        pecesCapturados=0;
        return total;
    }
    
    @Override
    public double precioElemento(){
        return tipo.PRECIO;
    }
    
    @Override
    public String toString(){
        return super.toString() + " | Tipo: Pesquero | Peces Capturados: " + pecesCapturados;
    }
}
