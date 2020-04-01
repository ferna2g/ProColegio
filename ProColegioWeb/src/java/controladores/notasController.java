/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import CAD.NotasCad;
import DTO.notas;
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
@Named(value="notas")
@SessionScoped

public class notasController implements Serializable{
    
    NotasCad micad = new NotasCad();
    private notas dto;
    private List<notas> milista;

    public notasController() {
        try {
            listar("V");
        } catch (Exception e) {

        }
    }

    public notas getDto() {
        return dto;
    }

    public void setDto(notas dto) {
        this.dto = dto;
    }

    public List<notas> getMilista() {
        return milista;
    }

    public void setMilista(List<notas> milista) {
        this.milista = milista;
    }

    public void seleccionarfilas(SelectEvent event) throws Exception {
        try {
            dto = micad.consultaNotas(((notas) event.getObject()).getIdnotas());
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error al seleccionar el registro intente de nuevo"));
        }
    }
    
 public void listar(String ispst) throws Exception {

        try {
            if (ispst.equals("F")) {

                if (isPostBack() == false) {

                    milista = micad.listarNotas();
                }
            } else {
                milista = micad.listarNotas();
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

    public void seleccionar(notas user) throws Exception {
        try {

            dto = micad.consultaNotas(user.getIdnotas());
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error al seleccionar el registro intente de nuevo"));
        }
    }

    public void inserta() throws Exception {

        try {
            micad.insertaNotas(dto);
            this.listar("V");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "El Cliente no existe, debe crear uno nuevo."));

        }

    }
    
     public void actualiza() throws Exception {
        try {

            micad.actualizaNotas(dto);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Registro Actualizado Exitosamente."));

            this.listar("V");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error al Acualizar intente de nuevo"));

            throw e;
        }
    }
     
     public void busca() throws Exception {
        notas miDto = new notas();
        try {
            miDto = micad.consultaNotas(dto.getIdnotas());
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
        dto = new notas();
    }
}
