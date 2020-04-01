/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author arielgeronimo
 */
public class boleta {
    private int idboleta;
    private Date fimpresion;
    private int idestudiante;

    public int getIdboleta() {
        return idboleta;
    }

    public void setIdboleta(int idboleta) {
        this.idboleta = idboleta;
    }

    public Date getFimpresion() {
        return fimpresion;
    }

    public void setFimpresion(Date fimpresion) {
        this.fimpresion = fimpresion;
    }

    public int getIdestudiante() {
        return idestudiante;
    }

    public void setIdestudiante(int idestudiante) {
        this.idestudiante = idestudiante;
    }
    
}
