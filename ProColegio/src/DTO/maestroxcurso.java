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
public class maestroxcurso {
    private int idmaestroxcurso;
    private int idmaestro;
    private int idcurso;
    private Date fregistro;

    public int getIdmaestroxcurso() {
        return idmaestroxcurso;
    }

    public void setIdmaestroxcurso(int idmaestroxcurso) {
        this.idmaestroxcurso = idmaestroxcurso;
    }

    public int getIdmaestro() {
        return idmaestro;
    }

    public void setIdmaestro(int idmaestro) {
        this.idmaestro = idmaestro;
    }

    public int getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(int idcurso) {
        this.idcurso = idcurso;
    }

    public Date getFregistro() {
        return fregistro;
    }

    public void setFregistro(Date fregistro) {
        this.fregistro = fregistro;
    }

    
}
