º1/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author RenzoHypeBeast
 */
public class RankingUsuarioTO {
    
    private String nombre;
    private int nivel;

    public RankingUsuarioTO(String nombre, int nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "RankingUsuarioTO{" + "nombre=" + nombre + ", nivel=" + nivel + '}';
    }
    
    
    
    
    
}
