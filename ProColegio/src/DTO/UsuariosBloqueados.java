/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author fer
 */
public class UsuariosBloqueados {
    private int idUsuarioBloqueado;
    private int idusuario;
    private String username;
    private int idtipobloqueo;
    private int tiempo;
    private String TipoTiempo;
    private Date FechaRegistro;

    public int getIdUsuarioBloqueado() {
        return idUsuarioBloqueado;
    }

    public void setIdUsuarioBloqueado(int idUsuarioBloqueado) {
        this.idUsuarioBloqueado = idUsuarioBloqueado;
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

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public String getTipoTiempo() {
        return TipoTiempo;
    }

    public void setTipoTiempo(String TipoTiempo) {
        this.TipoTiempo = TipoTiempo;
    }

    public Date getFechaRegistro() {
        return FechaRegistro;
    }

    public void setFechaRegistro(Date FechaRegistro) {
        this.FechaRegistro = FechaRegistro;
    }
    
}
