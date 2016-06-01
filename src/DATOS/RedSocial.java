/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATOS;

import java.util.ArrayList;

/**
 *
 * @author inteldemo
 */
public class RedSocial {
    protected ArrayList<Usuario> usuarios;
    protected ArrayList<Evento> eventos;

    
    public RedSocial() {
        this.usuarios =  new ArrayList<>();
        this.eventos = new ArrayList<>();
    }
    
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void agregarUsuario(Usuario u) {
        this.usuarios.add(u);
        
    }

    public ArrayList<Evento> getEventos() {
        return eventos;
    }

    public void agregarEvento(Evento e) {
        this.eventos.add(e);
    }
    
    
}
