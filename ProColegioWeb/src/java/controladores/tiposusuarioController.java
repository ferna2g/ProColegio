/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import CAD.TiposusuarioCad;
import DTO.tiposusuario;
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
@Named(value = "tiposusuario")
@SessionScoped

public class tiposusuarioController implements Serializable {

    TiposusuarioCad micad = new TiposusuarioCad();
    private tiposusuario dto;
    private List<tiposusuario> milista;
    
    public tiposusuarioController() {
        try {
            listar("V");
        } catch (Exception e) {

        }
    }

    public tiposusuario getDto() {
        return dto;
    }

    public void setDto(tiposusuario dto) {
        this.dto = dto;
    }

    public List<tiposusuario> getMilista() {
        return milista;
    }

    public void setMilista(List<tiposusuario> milista) {
        this.milista = milista;
    }
    
     public void seleccionarfilas(SelectEvent event) throws Exception {
        try {
            dto = micad.consultaTiposusuario(((tiposusuario) event.getObject()).getIdtipousuario());
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error al seleccionar el registro intente de nuevo"));
        }
    }

     public void listar(String ispst) throws Exception {

        try {
            if (ispst.equals("F")) {

                if (isPostBack() == false) {

                    milista = micad.listartiposusuario();
                }
            } else {
                milista = micad.listartiposusuario();
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

    public void seleccionar(tiposusuario user) throws Exception {
        try {

            dto = micad.consultaTiposusuario(user.getIdtipousuario());
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error al seleccionar el registro intente de nuevo"));
        }
    }
    
    public void inserta() throws Exception {

        try {
            micad.insertatiposusuario(dto);
            this.listar("V");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "El Cliente no existe, debe crear uno nuevo."));

        }

    }
    
    public void actualiza() throws Exception {
        try {

            micad.actualizaTiposusuario(dto);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Registro Actualizado Exitosamente."));

            this.listar("V");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error al Acualizar intente de nuevo"));

            throw e;
        }
    }
     
public void busca() throws Exception {
        tiposusuario miDto = new tiposusuario();
        try {
            miDto = micad.consultaTiposusuario(dto.getIdtipousuario());
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
        dto = new tiposusuario();
    }

}
