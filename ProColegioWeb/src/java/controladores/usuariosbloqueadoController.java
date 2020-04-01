/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import CAD.UsuariosbloqueadoCad;
import DTO.usuariosbloqueado;
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
@Named(value="usuariosbloqueado")
@SessionScoped

public class usuariosbloqueadoController implements Serializable{
    
    UsuariosbloqueadoCad micad = new UsuariosbloqueadoCad();
    private usuariosbloqueado dto;
    private List<usuariosbloqueado> milista;
    
    public usuariosbloqueadoController() {
        try {
            listar("V");
        } catch (Exception e) {

        }
    }

    public usuariosbloqueado getDto() {
        return dto;
    }

    public void setDto(usuariosbloqueado dto) {
        this.dto = dto;
    }

    public List<usuariosbloqueado> getMilista() {
        return milista;
    }

    public void setMilista(List<usuariosbloqueado> milista) {
        this.milista = milista;
    }
    
     public void seleccionarfilas(SelectEvent event) throws Exception {
        try {
            dto = micad.consultausuariosbloqueado(((usuariosbloqueado) event.getObject()).getIdusuariosbloqueados());
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error al seleccionar el registro intente de nuevo"));
        }
    }

     public void listar(String ispst) throws Exception {

        try {
            if (ispst.equals("F")) {

                if (isPostBack() == false) {

                    milista = micad.listarusuariosbloqueado();
                }
            } else {
                milista = micad.listarusuariosbloqueado();
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

    public void seleccionar(usuariosbloqueado user) throws Exception {
        try {

            dto = micad.consultausuariosbloqueado(user.getIdusuariosbloqueados());
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error al seleccionar el registro intente de nuevo"));
        }
    }
    
    public void inserta() throws Exception {

        try {
            micad.insertausuariosbloqueado(dto);
            this.listar("V");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "El Cliente no existe, debe crear uno nuevo."));

        }

    }
    
    public void actualiza() throws Exception {
        try {

            micad.actualizasusuariosbloqueados(dto);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Registro Actualizado Exitosamente."));

            this.listar("V");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error al Acualizar intente de nuevo"));

            throw e;
        }
    }
     
public void busca() throws Exception {
        usuariosbloqueado miDto = new usuariosbloqueado();
        try {
            miDto = micad.consultausuariosbloqueado(dto.getIdusuariosbloqueados());
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
        dto = new usuariosbloqueado();
    }

}
