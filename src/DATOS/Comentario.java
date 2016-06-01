/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATOS;

import java.io.File;


public class Comentario {
    private Usuario comentarista; 
    private String texto; 

    public Comentario(Usuario comentarista, String texto) {
        this.comentarista=comentarista;
        this.texto = texto;
    }

    public Comentario() {
        
    }

    public Usuario getComentarista() {
        return comentarista;
    }

    public String getTexto() {
        return texto;
    }
    
}
