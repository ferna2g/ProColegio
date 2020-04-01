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
public class PermisosUsuarios {
    private int id_PermisoUsuario;
    private int idusuario;
    private int idseccion;
    private int idAccionSeccion;
    private int i_permiso;
    private int idUsuarioAsignacion;
    private Date dt_FechaAsignacion;

    public int getId_PermisoUsuario() {
        return id_PermisoUsuario;
    }

    public void setId_PermisoUsuario(int id_PermisoUsuario) {
        this.id_PermisoUsuario = id_PermisoUsuario;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getIdseccion() {
        return idseccion;
    }

    public void setIdseccion(int idseccion) {
        this.idseccion = idseccion;
    }

    public int getIdAccionSeccion() {
        return idAccionSeccion;
    }

    public void setIdAccionSeccion(int idAccionSeccion) {
        this.idAccionSeccion = idAccionSeccion;
    }

    public int getI_permiso() {
        return i_permiso;
    }

    public void setI_permiso(int i_permiso) {
        this.i_permiso = i_permiso;
    }

    public int getIdUsuarioAsignacion() {
        return idUsuarioAsignacion;
    }

    public void setIdUsuarioAsignacion(int idUsuarioAsignacion) {
        this.idUsuarioAsignacion = idUsuarioAsignacion;
    }

    public Date getDt_FechaAsignacion() {
        return dt_FechaAsignacion;
    }

    public void setDt_FechaAsignacion(Date dt_FechaAsignacion) {
        this.dt_FechaAsignacion = dt_FechaAsignacion;
    }
    
    
}
