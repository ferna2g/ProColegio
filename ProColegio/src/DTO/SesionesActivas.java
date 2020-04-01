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
public class SesionesActivas {
    private int id_sesion;
    private int idusuario;
    private String ClaveSesion;
    private Date FechaRegistro;
    private Date dt_UltimaActividad;

    public int getId_sesion() {
        return id_sesion;
    }

    public void setId_sesion(int id_sesion) {
        this.id_sesion = id_sesion;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getClaveSesion() {
        return ClaveSesion;
    }

    public void setClaveSesion(String ClaveSesion) {
        this.ClaveSesion = ClaveSesion;
    }

    public Date getFechaRegistro() {
        return FechaRegistro;
    }

    public void setFechaRegistro(Date FechaRegistro) {
        this.FechaRegistro = FechaRegistro;
    }

    public Date getDt_UltimaActividad() {
        return dt_UltimaActividad;
    }

    public void setDt_UltimaActividad(Date dt_UltimaActividad) {
        this.dt_UltimaActividad = dt_UltimaActividad;
    }
    
}
