/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import CAD.GradoacademicoCad;
import DTO.gradoacademico;
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
@Named(value = "gradoacademico")
@SessionScoped

public class gradoacademicoController implements Serializable {
    
    GradoacademicoCad micad = new GradoacademicoCad();
    private gradoacademico dto;
    private List<gradoacademico> milista;
    
    
    public gradoacademicoController(){
        try {
            listar("V");
        } catch (Exception e) {

        }
    }

    public gradoacademico getDto() {
        return dto;
    }

    public void setDto(gradoacademico dto) {
        this.dto = dto;
    }

    public List<gradoacademico> getMilista() {
        return milista;
    }

    public void setMilista(List<gradoacademico> milista) {
        this.milista = milista;
    }
    
    public void seleccionarfilas(SelectEvent event) throws Exception {
        try {
            dto = micad.consultaNivel(((gradoacademico) event.getObject()).getIdgrado());
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error al seleccionar el registro intente de nuevo"));
        }
    }
    
    public void listar(String ispst) throws Exception {

        try {
            if (ispst.equals("F")) {

                if (isPostBack() == false) {

                    milista = micad.listarNivel();
                }
            } else {
                milista = micad.listarNivel();
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
    
    public void seleccionar(gradoacademico user) throws Exception {
        try {

            dto = micad.consultaNivel(user.getIdgrado());
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error al seleccionar el registro intente de nuevo"));
        }
    }
    
    public void inserta() throws Exception {

        try {
            micad.insertaNivel(dto);
            this.listar("V");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "El Cliente no existe, debe crear uno nuevo."));

        }

    }
    
    public void actualiza() throws Exception {
        try {

            micad.actualizaNivel(dto);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Registro Actualizado Exitosamente."));

            this.listar("V");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error al Acualizar intente de nuevo"));

            throw e;
        }
    }
    
    public void busca() throws Exception {
        gradoacademico miDto = new gradoacademico();
        try {
            miDto = micad.consultaNivel(dto.getIdgrado());
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
        dto = new gradoacademico();
    }
    
}
