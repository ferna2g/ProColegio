/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import CAD.DetusuariosCad;
import DTO.detusuarios;
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
@Named(value="detusuarios")
@SessionScoped

public class detusuariosController implements Serializable{
    
    DetusuariosCad micad = new DetusuariosCad();
    private detusuarios dto;
    private List<detusuarios> milista;

    public detusuariosController() {
        try {
            listar("V");
        } catch (Exception e) {
        }
    }

    public detusuarios getDto() {
        return dto;
    }

    public void setDto(detusuarios dto) {
        this.dto = dto;
    }

    public List<detusuarios> getMilista() {
        return milista;
    }

    public void setMilista(List<detusuarios> milista) {
        this.milista = milista;
    }

    public void seleccionarfilas(SelectEvent event) throws Exception {
        try {
            dto = micad.consultadetusuarios(((detusuarios) event.getObject()).getIdusuarios());
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error al seleccionar el registro intente de nuevo"));

        }

    }

    public void listar(String ispst) throws Exception {

        try {
            if (ispst.equals("F")) {

                if (isPostBack() == false) {

                    milista = micad.listardetusuarios();
                }
            } else {
                milista = micad.listardetusuarios();
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

    public void seleccionar(detusuarios user) throws Exception {
        try {

            dto = micad.consultadetusuarios(user.getIdusuarios());
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error al seleccionar el registro intente de nuevo"));
        }
    }

    public void inserta() throws Exception {

        try {
            micad.insertadetusuarios(dto);
            this.listar("V");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "El Cliente no existe, debe crear uno nuevo."));

        }

    }

    public void actualiza() throws Exception {
        try {

            micad.actualizadetusuario(dto);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Registro Actualizado Exitosamente."));

            this.listar("V");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error al Acualizar intente de nuevo"));

            throw e;
        }
    }

    public void busca() throws Exception {
        detusuarios miDto = new detusuarios();
        try {
            miDto = micad.consultadetusuarios(dto.getIdusuarios());
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
        dto = new detusuarios();
    }
}
