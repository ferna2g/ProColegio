/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import CAD.CursoCad;
import DTO.curso;
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
@Named(value = "curso")
@SessionScoped

public class cursoController implements Serializable {

    CursoCad micad = new CursoCad();
    private curso dto;
    private List<curso> milista;

    public cursoController() {
        try {
            listar("V");
        } catch (Exception e) {

        }
    }

    public curso getDto() {
        return dto;
    }

    public void setDto(curso dto) {
        this.dto = dto;
    }

    public List<curso> getMilista() {
        return milista;
    }

    public void setMilista(List<curso> milista) {
        this.milista = milista;
    }

    public void seleccionarfilas(SelectEvent event) throws Exception {
        try {
            dto = micad.consultaCurso(((curso) event.getObject()).getIdcurso());
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error al seleccionar el registro intente de nuevo"));
        }
    }
    
 public void listar(String ispst) throws Exception {

        try {
            if (ispst.equals("F")) {

                if (isPostBack() == false) {

                    milista = micad.listarCursos();
                }
            } else {
                milista = micad.listarCursos();
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

    public void seleccionar(curso user) throws Exception {
        try {

            dto = micad.consultaCurso(user.getIdcurso());
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error al seleccionar el registro intente de nuevo"));
        }
    }

    public void inserta() throws Exception {

        try {
            micad.insertaCurso(dto);
            this.listar("V");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "El Cliente no existe, debe crear uno nuevo."));

        }

    }
    
     public void actualiza() throws Exception {
        try {

            micad.actualizaCurso(dto);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Registro Actualizado Exitosamente."));

            this.listar("V");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error al Acualizar intente de nuevo"));

            throw e;
        }
    }
     
     public void busca() throws Exception {
        curso miDto = new curso();
        try {
            miDto = micad.consultaCurso(dto.getIdcurso());
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
        dto = new curso();
    }
}
