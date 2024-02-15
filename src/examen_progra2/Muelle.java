/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen_progra2;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Tommy Lee Pon
 */
public class Muelle implements Serializable{
    private ArrayList<Barco> barcos;
    
    public Muelle(){
        barcos=new ArrayList();
        cargarSer();
        guardarSer();
    }
    
    private Barco buscarRecursive(String nombre, int cero){
        cargarSer();
        if(cero<barcos.size()){
            if (nombre.equals(barcos.get(cero).getNombre()))
                return barcos.get(cero);
            return buscarRecursive(nombre, cero+1);
        }
        return null;
    }
    
    public Barco buscar(String nombre){
        return buscarRecursive(nombre, 0);
    }
    
    public void AgregarBarco(String nombre, String tipo){
        Calendar hoy=Calendar.getInstance();
        if(buscar(nombre)==null)
            switch(tipo){
                case "PESQUERO" -> {
                    String pesca = JOptionPane.showInputDialog(null, "Tipo de pesca: \n (PEZ, CAMARON, LANGOSTA)");
                    barcos.add(new BarcoPesquero(nombre, hoy, TipoPesquero.valueOf(pesca)));
                }
                case "PASAJEROS" -> {
                    String capacidadStr = JOptionPane.showInputDialog(null, "Capacidad máxima:");
                    int capacidad = Integer.parseInt(capacidadStr);
                    String precioStr = JOptionPane.showInputDialog(null, "Precio de boleto: ");
                    double precio = Double.parseDouble(precioStr);
                    barcos.add(new BarcoPasajeros(nombre, hoy, capacidad, precio));
                }
            }
        else 
            JOptionPane.showMessageDialog(null, "Nombre de barco ya existe");
    }
    
    public void agregarElemento(String nombre){
        if(buscar(nombre)!=null){
            buscar(nombre).agregarElemento();
        }
        guardarSer();
    }
    
    public double vaciarBarco(String nombre){
        if(buscar(nombre)!=null)
            return buscar(nombre).vaciarCobrar();
        guardarSer();
        return 0;
    }
    
    public String barcosDesde(int year, int cero){
        Calendar filtro=Calendar.getInstance();
        filtro.set(Calendar.YEAR, year);
        if(cero<barcos.size()){
            if(barcos.get(cero).getFecha().after(filtro))
                return barcos.get(cero).toString() + "\n" + barcosDesde(year, cero+1);
            return barcosDesde(year, cero+1);
        }
        return("");
    }
    
    public void guardarSer(){
        try {
            FileOutputStream fileOut = new FileOutputStream("muelle.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(barcos);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void cargarSer(){
        try {
            File file = new File("muelle.ser");
            if (file.exists()) {
                FileInputStream fileIn = new FileInputStream(file);
                ObjectInputStream in = new ObjectInputStream(fileIn);
                barcos = (ArrayList<Barco>) in.readObject();
                in.close();
                fileIn.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
