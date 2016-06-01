/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATOS;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;


public class Evento {
    private String nombre; 
    private String tipo; 
    private Usuario creador; 
    private Fecha fecha; 
    private String descripcion;
    private int Localidad;
    private ArrayList<Comentario> comentarios;
    private ArrayList<Usuario> asistentes; 

    public Evento(String nombre, String tipo, Usuario creador, int year, int mes, int dia, int hora, int minuto,  String descripcion, int localidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.creador = creador;
        this.fecha = new Fecha(year, mes, dia, hora, minuto);
        this.Localidad = localidad;
        this.descripcion = descripcion;
        this.comentarios = new ArrayList<>();
        this.asistentes = new ArrayList<>();
    }

    public Evento(String nombre, String tipo, Usuario creador, Fecha fecha,  String descripcion, ArrayList<Comentario> comentarios, ArrayList<Usuario> asistentes, int localidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.creador = creador;
        this.fecha = fecha;
        this.Localidad = localidad;
        this.descripcion = descripcion;
        this.comentarios = comentarios;
        this.asistentes = asistentes;
    }
    
    public void agregarComentario(Comentario c){
        this.comentarios.add(c);
    }
    public void agregarAsistente(Usuario a){
        this.asistentes.add(a);
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public Usuario getCreador() {
        return creador;
    }

    public Fecha getFecha() {
        return fecha;
    }

    
    

    public String getDescripcion() {
        return descripcion;
    }

    public int getLocalidad() {
        return Localidad;
    }

    public ArrayList<Comentario> getComentarios() {
        return comentarios;
    }

    public ArrayList<Usuario> getAsistentes() {
        return asistentes;
    }
    
}
