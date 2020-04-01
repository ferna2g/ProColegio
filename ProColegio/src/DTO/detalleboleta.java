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
public class detalleboleta {
    private int iddetalle;
    private String trimestre1;
    private String trimestre2;
    private String trimestre3;
    private String promedio;
    private String recuperacion;
    private int idcurso;
    private int idboleta;

    public int getIddetalle() {
        return iddetalle;
    }

    public void setIddetalle(int iddetalle) {
        this.iddetalle = iddetalle;
    }

    public String getTrimestre1() {
        return trimestre1;
    }

    public void setTrimestre1(String trimestre1) {
        this.trimestre1 = trimestre1;
    }

    public String getTrimestre2() {
        return trimestre2;
    }

    public void setTrimestre2(String trimestre2) {
        this.trimestre2 = trimestre2;
    }

    public String getTrimestre3() {
        return trimestre3;
    }

    public void setTrimestre3(String trimestre3) {
        this.trimestre3 = trimestre3;
    }

    public String getPromedio() {
        return promedio;
    }

    public void setPromedio(String promedio) {
        this.promedio = promedio;
    }

    public String getRecuperacion() {
        return recuperacion;
    }

    public void setRecuperacion(String recuperacion) {
        this.recuperacion = recuperacion;
    }

    public int getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(int idcurso) {
        this.idcurso = idcurso;
    }

    public int getIdboleta() {
        return idboleta;
    }

    public void setIdboleta(int idboleta) {
        this.idboleta = idboleta;
    }
    
}
