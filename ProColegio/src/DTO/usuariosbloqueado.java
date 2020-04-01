/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author arielgeronimo
 */
public class usuariosbloqueado {
    private int idusuariosbloqueados;
    private int idusuario;
    private String username;
    private int idtipobloqueo;

    public int getIdusuariosbloqueados() {
        return idusuariosbloqueados;
    }

    public void setIdusuariosbloqueados(int idusuariosbloqueados) {
        this.idusuariosbloqueados = idusuariosbloqueados;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getIdtipobloqueo() {
        return idtipobloqueo;
    }

    public void setIdtipobloqueo(int idtipobloqueo) {
        this.idtipobloqueo = idtipobloqueo;
    }
    
}
