/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import CAD.TiposbloqueoCad;
import DTO.tiposbloqueo;
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
@Named(value = "tiposbloqueo")
@SessionScoped

public class tiposbloqueoController implements Serializable {
    
    TiposbloqueoCad micad = new TiposbloqueoCad();
    private tiposbloqueo dto;
    private List<tiposbloqueo> milista;
    
    public tiposbloqueoController() {
        try {
            listar("V");
        } catch (Exception e) {

        }
    }

    public tiposbloqueo getDto() {
        return dto;
    }

    public void setDto(tiposbloqueo dto) {
        this.dto = dto;
    }

    public List<tiposbloqueo> getMilista() {
        return milista;
    }

    public void setMilista(List<tiposbloqueo> milista) {
        this.milista = milista;
    }
    
     public void seleccionarfilas(SelectEvent event) throws Exception {
        try {
            dto = micad.consultaTiposbloqueo(((tiposbloqueo) event.getObject()).getIdtipobloqueo());
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error al seleccionar el registro intente de nuevo"));
        }
    }

     public void listar(String ispst) throws Exception {

        try {
            if (ispst.equals("F")) {

                if (isPostBack() == false) {

                    milista = micad.listartiposbloqueo();
                }
            } else {
                milista = micad.listartiposbloqueo();
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

    public void seleccionar(tiposbloqueo user) throws Exception {
        try {

            dto = micad.consultaTiposbloqueo(user.getIdtipobloqueo());
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error al seleccionar el registro intente de nuevo"));
        }
    }
    
    public void inserta() throws Exception {

        try {
            micad.insertatiposbloqueo(dto);
            this.listar("V");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "El Cliente no existe, debe crear uno nuevo."));

        }

    }
    
    public void actualiza() throws Exception {
        try {

            micad.actualizaTiposbloqueo(dto);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Registro Actualizado Exitosamente."));

            this.listar("V");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error al Acualizar intente de nuevo"));

            throw e;
        }
    }
     
public void busca() throws Exception {
        tiposbloqueo miDto = new tiposbloqueo();
        try {
            miDto = micad.consultaTiposbloqueo(dto.getIdtipobloqueo());
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
        dto = new tiposbloqueo();
    }

}
