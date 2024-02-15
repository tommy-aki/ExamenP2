/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package examen_progra2;

/**
 *
 * @author Tommy Lee Pon
 */
public enum TipoPesquero {
    PEZ(0.5), CAMARON(0.3), LANGOSTA(0.8);
    public double PRECIO;
    
    TipoPesquero(double precio){
        PRECIO=precio;
    }
}
