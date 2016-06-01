/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATOS;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author LAURA
 */
public class Usuario {

    private FullName nombreCompleto;
    private int edad;
    private String correo;
    private String nick;
    private String password;
    private int localidad;
    private String genero;

    // ArrayList<Direccion>Ubicaciones= new ArrayList<Direccion>(); 
    public Usuario(){
    
    }
    public Usuario(String nombre1, String nombre2, String apellido1, String apellido2, int edad, String correo, String nick, String password, String genero, int localidad) {
        this.nombreCompleto = new FullName(nombre1, nombre2, apellido1, apellido2);
        this.edad = edad;
        this.correo = correo;
        this.nick = nick;
        this.password = password;
        this.localidad = localidad;
        this.genero = genero;
        
    }

    public FullName getNombreCompleto() {
        return nombreCompleto;
    }

    public int getEdad() {
        return edad;
    }

    public String getCorreo() {
        return correo;
    }

    public String getNick() {
        return nick;
    }

    public String getPassword() {
        return password;
    }

    public int getLocalidad() {
        return localidad;
    }

    public String getGenero() {
        return genero;
    }
    

}
