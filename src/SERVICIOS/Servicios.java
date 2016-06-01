/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICIOS;
import Run.*;
import DATOS.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author inteldemo
 */
public class Servicios {
    RedSocial plapp;

    public Servicios() {
        this.plapp = new RedSocial();
    }
    
    public void crearEvento(String nombre, String tipo, Usuario creador, int year, int mes, int dia, int hora, int minuto,  String descripcion, int localidad){
        Evento e = new Evento(nombre, tipo,  creador, year, mes, dia, hora, minuto, descripcion, localidad);
        agregarEvento(e);
    }
    public String registrarUsuario(String nombre1, String nombre2, String apellido1, String apellido2, int edad, String correo, String nick, String password, String genero, int localidad){
        String bandera = "registro";
        for (Usuario us : plapp.getUsuarios()) {
            if (us.getNick().equals("nick")) {
                bandera = "nick";
                break;
            }else if (us.getCorreo().equals(correo)){
                bandera = "correo";
                break;
            }
            
        }
        if (bandera.equals("registro")) {
            Usuario u = new Usuario(nombre1, nombre2, apellido1, apellido2, edad, correo, nick, password, genero, localidad);
            agregarUsuario(u);
        }
        return bandera;
        
    }
    public ArrayList<Evento> buscarEventos(Usuario u){
        int localidad = 0;
        for (Usuario us : plapp.getUsuarios()) {
            if (us == u) {
                localidad = us.getLocalidad();
            }
        }
        ArrayList<Evento> eventosBuscados = new ArrayList<>();
        for (Evento e : plapp.getEventos()) {
            if (e.getLocalidad() == localidad) {
                eventosBuscados.add(e);
            }
        }
        return eventosBuscados;
    }
    public ArrayList<Evento> buscarEventos(Usuario u, String tipo){
        int localidad = 0;
        for (Usuario us : plapp.getUsuarios()) {
            if (us == u) {
                localidad = us.getLocalidad();
            }
        }
        ArrayList<Evento> eventosBuscados = new ArrayList<>();
        for (Evento e : plapp.getEventos()) {
            if (e.getLocalidad() == localidad && e.getTipo() == tipo) {
                eventosBuscados.add(e);
            }
        }
        return eventosBuscados;
    }
    public void agregarEvento (Evento e){
        this.plapp.agregarEvento(e);
    }
    public void agregarUsuario (Usuario u){
        this.plapp.agregarUsuario(u);
    }
    public void cargarUsuarios() throws FileNotFoundException{
        Scanner lectura = new Scanner(new File("Usuarios.txt"));
        String nombre1, nombre2, apellido1, apellido2, correo, nick, password, genero;
        int edad = 0, localidad = 0;
        while (lectura.hasNext()) { 
            nombre1 = lectura.next();
            nombre2 = lectura.next();
            apellido1 = lectura.next();
            apellido2 = lectura.next();
            while (lectura.hasNextInt()) {                
                edad = lectura.nextInt();
            }
            correo = lectura.next();
            nick = lectura.next();
            password = lectura.next();
            while (lectura.hasNextInt()) {                
                localidad = lectura.nextInt();
            }
            genero = lectura.next();
            Usuario u = new Usuario(nombre1, nombre2, apellido1, apellido2, edad, correo, nick, password, genero, localidad);
            plapp.getUsuarios().add(u);
        }
    }
    public void cargarEventos() throws FileNotFoundException{
        Scanner lectura = new Scanner(new File("Agenda.txt"));
        lectura.useDelimiter("/");
        String tipo, nombre, nickCreador, nickAsistente, descripcion = "";
        int year, mes, dia, hora, minuto, numComentarios = 0, numAsistentes = 0, localidad = 0;
        Usuario creador = new Usuario ();
        Fecha fecha = new Fecha (0, 0, 0, 0, 0);
        ArrayList<Comentario> comentariosFinales = new ArrayList<>();
        ArrayList<Usuario> asistentes = new ArrayList<>();
        ArrayList<Usuario> comentaristas = new ArrayList<>();
        ArrayList<String> comentarios= new ArrayList<>();
        while (lectura.hasNext()) { 
            tipo = lectura.next();
            while(lectura.hasNextInt()){
                localidad = lectura.nextInt();
            }
            nombre = lectura.next();
            nickCreador = lectura.next();
            for (Usuario u : plapp.getUsuarios()) {
                if(u.getNick().equals(nickCreador)){
                    creador = u;
                }
            }
            while (lectura.hasNextInt()) {                
                year = lectura.nextInt();
                mes = lectura.nextInt();
                dia = lectura.nextInt();
                hora = lectura.nextInt();
                minuto = lectura.nextInt();
                fecha = new Fecha(year, mes, dia, hora, minuto);
            }            
            while (lectura.hasNextInt()) {                
                numComentarios = lectura.nextInt();
            }
            for (int i = 1; i <= numComentarios; i++) {
                String nickComentarista = lectura.next();
                for (Usuario u : plapp.getUsuarios()) {
                    if(u.getNick().equals(nickComentarista)){
                        Usuario comentarista = u;
                        comentaristas.add(comentarista);
                    }
                }
            }
            for (int i = 0; i < numComentarios; i++) {
                while (lectura.hasNextLine()) {                    
                    String texto = lectura.nextLine();
                    comentarios.add(texto);
                    String a = comentarios.get(i);
                    Usuario u = comentaristas.get(i);
                    Comentario c = new Comentario (u, a);
                    comentariosFinales.add(c);
                }
            }
            while(lectura.hasNextInt()){
                numAsistentes = lectura.nextInt();
            }
            for (int i = 0; i < numAsistentes; i++) {
                nickAsistente = lectura.next();
                for (Usuario u : plapp.getUsuarios()) {
                    if (u.getNick().equals(nickAsistente)) {
                        asistentes.add(u);
                    }
                } 
            }
            while(lectura.hasNextLine()){
                descripcion = lectura.nextLine();
            }
            Evento e = new Evento(nombre, tipo, creador, fecha, descripcion , comentariosFinales, asistentes, localidad);
            plapp.getEventos().add(e);
        }
    }
    public void guardarUsuarios() throws FileNotFoundException{
        PrintStream salida = new PrintStream(new File("salidaUsuarios.txt"));
        for (Usuario u : plapp.getUsuarios()) {
            salida.println(u.getNombreCompleto().getNombre1()+"/"+u.getNombreCompleto().getNombre2()+"/"+u.getNombreCompleto().getApellido1()+"/"+u.getNombreCompleto().getApellido2()+"/"+u.getEdad()+"/"+u.getCorreo()+"/"+u.getNick()+"/"+u.getPassword()+"/"+u.getLocalidad());
        }
    }
    public void guardarEventos() throws FileNotFoundException{
        PrintStream salida = new PrintStream(new File("salidaEventos.txt"));
        for (Evento e : plapp.getEventos()) {
            salida.println(e.getLocalidad()+"/"+e.getTipo()+"/"+e.getNombre()+"/"+e.getCreador().getNick()+"/"+e.getFecha().getYear()+"/"+e.getFecha().getMes()+"/"+e.getFecha().getDia()+"/"+e.getFecha().getHora()+"/"+e.getFecha().getMinuto()+"/"+e.getComentarios().size());
            for (Comentario c : e.getComentarios()) {
                salida.print(c.getComentarista().getNick()+"/");
            }
            for (Comentario c : e.getComentarios()) {
                salida.print("\n"+c.getTexto());
            }
            int numAsistentes = e.getAsistentes().size();
            salida.print("\n"+numAsistentes+"/");
            for (Usuario u : plapp.getUsuarios()) {
                salida.print(u.getNick()+"/");
            }
            
            salida.print("\n");
            salida.print(e.getDescripcion());
        }
        
    }
    public boolean validarUsuario(String nick, String password){
        boolean bandera = false;
        for (Usuario u : plapp.getUsuarios()) {
            if(u.getNick().equals(nick) && u.getPassword().equals(password)){
                bandera = true;
            }
        }
        return bandera;
    }
    
    
    
    
}
