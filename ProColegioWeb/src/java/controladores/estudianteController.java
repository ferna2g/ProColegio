/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import CAD.EstudianteCad;
import DTO.estudiante;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author fer
 */
@ManagedBean
@Named(value = "estudiante")
@SessionScoped

public class estudianteController implements Serializable{
    
    EstudianteCad micad = new EstudianteCad();
    private estudiante dto;
    private List<estudiante> milista;

    public estudianteController() {
        try {
            listar("V");
        } catch (Exception e) {
        }
    }

    public estudiante getDto() {
        return dto;
    }

    public void setDto(estudiante dto) {
        this.dto = dto;
    }

    public List<estudiante> getMilista() {
        return milista;
    }

    public void setMilista(List<estudiante> milista) {
        this.milista = milista;
    }

    public void seleccionarfilas(SelectEvent event) throws Exception {
        try {
            dto = micad.consultaEstudiante(((estudiante) event.getObject()).getIdestudiante());
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error al seleccionar el registro intente de nuevo"));

        }

    }

    public void listar(String ispst) throws Exception {

        try {
            if (ispst.equals("F")) {

                if (isPostBack() == false) {

                    milista = micad.listarEstudiantes();
                }
            } else {
                milista = micad.listarEstudiantes();
            }

        } catch (Exception e) {
            throw e;
        }
    }

    public boolean isPostBack() {
        boolean rs;
        rs = FacesContext.getCurrentInstance().isPostback();
        return rs;
    }

    public void seleccionar(estudiante user) throws Exception {
        try {

            dto = micad.consultaEstudiante(user.getIdestudiante());
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error al seleccionar el registro intente de nuevo"));
        }
    }

    public void inserta() throws Exception {

        try {
            micad.insertaEstudiante(dto);
            this.listar("V");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "El Cliente no existe, debe crear uno nuevo."));

        }

    }

    public void actualiza() throws Exception {
        try {

            micad.actualizaEstudiante(dto);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Registro Actualizado Exitosamente."));

            this.listar("V");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error al Acualizar intente de nuevo"));

            throw e;
        }
    }

    public void busca() throws Exception {
        estudiante miDto = new estudiante();
        try {
            miDto = micad.consultaEstudiante(dto.getIdestudiante());
            if (miDto != null) {
                dto = miDto;
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Error al buscar el registro."));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!"));

            throw e;
        }
    }

    @PostConstruct
    public void init() {
        dto = new estudiante();
    }

    
}
