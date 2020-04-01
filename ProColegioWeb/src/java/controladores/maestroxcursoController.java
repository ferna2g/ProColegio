/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import CAD.MaestroxcursoCad;
import DTO.maestroxcurso;
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
@Named(value="maestroxcurso")
@SessionScoped

public class maestroxcursoController implements Serializable {
    
    MaestroxcursoCad micad = new MaestroxcursoCad();
    private maestroxcurso dto;
    private List<maestroxcurso> milista;

    public maestroxcursoController() {
        try {
            listar("V");
        } catch (Exception e) {

        }
    }

    public maestroxcurso getDto() {
        return dto;
    }

    public void setDto(maestroxcurso dto) {
        this.dto = dto;
    }

    public List<maestroxcurso> getMilista() {
        return milista;
    }

    public void setMilista(List<maestroxcurso> milista) {
        this.milista = milista;
    }

    public void seleccionarfilas(SelectEvent event) throws Exception {
        try {
            dto = micad.consultamaestroxcurso(((maestroxcurso) event.getObject()).getIdmaestroxcurso());
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error al seleccionar el registro intente de nuevo"));
        }
    }
    
 public void listar(String ispst) throws Exception {

        try {
            if (ispst.equals("F")) {

                if (isPostBack() == false) {

                    milista = micad.listarmaestroxcurso();
                }
            } else {
                milista = micad.listarmaestroxcurso();
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

    public void seleccionar(maestroxcurso user) throws Exception {
        try {

            dto = micad.consultamaestroxcurso(user.getIdmaestroxcurso());
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error al seleccionar el registro intente de nuevo"));
        }
    }

    public void inserta() throws Exception {

        try {
            micad.insertamaestroxcurso(dto);
            this.listar("V");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "El Cliente no existe, debe crear uno nuevo."));

        }

    }
    
     public void actualiza() throws Exception {
        try {

            micad.actualizamaestroxcurso(dto);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Registro Actualizado Exitosamente."));

            this.listar("V");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error al Acualizar intente de nuevo"));

            throw e;
        }
    }
     
     public void busca() throws Exception {
        maestroxcurso miDto = new maestroxcurso();
        try {
            miDto = micad.consultamaestroxcurso(dto.getIdmaestroxcurso());
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
        dto = new maestroxcurso();
    }
}