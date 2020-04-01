/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import CAD.CursoxgradoCad;
import DTO.cursoxgrado;
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
@Named(value="cursoxgrado")
@SessionScoped

public class cursoxgradoController implements Serializable {
    
    CursoxgradoCad micad = new CursoxgradoCad();
    private cursoxgrado dto;
    private List<cursoxgrado> milista;

    public cursoxgradoController() {
        try {
            listar("V");
        } catch (Exception e) {

        }
    }

    public cursoxgrado getDto() {
        return dto;
    }

    public void setDto(cursoxgrado dto) {
        this.dto = dto;
    }

    public List<cursoxgrado> getMilista() {
        return milista;
    }

    public void setMilista(List<cursoxgrado> milista) {
        this.milista = milista;
    }

    public void seleccionarfilas(SelectEvent event) throws Exception {
        try {
            dto = micad.consultacursoxgrado(((cursoxgrado) event.getObject()).getIdcursoxgrado());
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error al seleccionar el registro intente de nuevo"));
        }
    }
    
 public void listar(String ispst) throws Exception {

        try {
            if (ispst.equals("F")) {

                if (isPostBack() == false) {

                    milista = micad.listarcursosxgrado();
                }
            } else {
                milista = micad.listarcursosxgrado();
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

    public void seleccionar(cursoxgrado user) throws Exception {
        try {

            dto = micad.consultacursoxgrado(user.getIdcursoxgrado());
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error al seleccionar el registro intente de nuevo"));
        }
    }

    public void inserta() throws Exception {

        try {
            micad.insertacursoxgrado(dto);
            this.listar("V");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "El Cliente no existe, debe crear uno nuevo."));

        }

    }
    
     public void actualiza() throws Exception {
        try {

            micad.actualizacursoxgrado(dto);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Registro Actualizado Exitosamente."));

            this.listar("V");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error al Acualizar intente de nuevo"));

            throw e;
        }
    }
     
     public void busca() throws Exception {
        cursoxgrado miDto = new cursoxgrado();
        try {
            miDto = micad.consultacursoxgrado(dto.getIdcursoxgrado());
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
        dto = new cursoxgrado();
    }
    
}
