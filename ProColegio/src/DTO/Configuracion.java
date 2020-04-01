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
public class Configuracion {
    private int idConfiguracion;
    private String ConfiguracionNombre;
    private String DescripcionConfiguracion;
    private int ConfiguracionValor;
    private String TipoValor;
    private int i_Activo;
    private Date FechaRegistro;

    public int getIdConfiguracion() {
        return idConfiguracion;
    }

    public void setIdConfiguracion(int idConfiguracion) {
        this.idConfiguracion = idConfiguracion;
    }

    public String getConfiguracionNombre() {
        return ConfiguracionNombre;
    }

    public void setConfiguracionNombre(String ConfiguracionNombre) {
        this.ConfiguracionNombre = ConfiguracionNombre;
    }

    public String getDescripcionConfiguracion() {
        return DescripcionConfiguracion;
    }

    public void setDescripcionConfiguracion(String DescripcionConfiguracion) {
        this.DescripcionConfiguracion = DescripcionConfiguracion;
    }

    public int getConfiguracionValor() {
        return ConfiguracionValor;
    }

    public void setConfiguracionValor(int ConfiguracionValor) {
        this.ConfiguracionValor = ConfiguracionValor;
    }

    public String getTipoValor() {
        return TipoValor;
    }

    public void setTipoValor(String TipoValor) {
        this.TipoValor = TipoValor;
    }

    public int getI_Activo() {
        return i_Activo;
    }

    public void setI_Activo(int i_Activo) {
        this.i_Activo = i_Activo;
    }

    public Date getFechaRegistro() {
        return FechaRegistro;
    }

    public void setFechaRegistro(Date FechaRegistro) {
        this.FechaRegistro = FechaRegistro;
    }
    
}
