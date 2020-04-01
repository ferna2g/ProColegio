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
public class LogSesiones {
    private int id_logsesiion;
    private String username;
    private String password;
    private String ClaveSesion;
    private String EstadoIntentos;
    private int IntentosFallidos;
    private Date FechaRegistro;

    public int getId_logsesiion() {
        return id_logsesiion;
    }

    public void setId_logsesiion(int id_logsesiion) {
        this.id_logsesiion = id_logsesiion;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClaveSesion() {
        return ClaveSesion;
    }

    public void setClaveSesion(String ClaveSesion) {
        this.ClaveSesion = ClaveSesion;
    }

    public String getEstadoIntentos() {
        return EstadoIntentos;
    }

    public void setEstadoIntentos(String EstadoIntentos) {
        this.EstadoIntentos = EstadoIntentos;
    }

    public int getIntentosFallidos() {
        return IntentosFallidos;
    }

    public void setIntentosFallidos(int IntentosFallidos) {
        this.IntentosFallidos = IntentosFallidos;
    }

    public Date getFechaRegistro() {
        return FechaRegistro;
    }

    public void setFechaRegistro(Date FechaRegistro) {
        this.FechaRegistro = FechaRegistro;
    }
    
}
