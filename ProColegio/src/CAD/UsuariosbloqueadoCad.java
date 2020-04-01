/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAD;

import DTO.usuariosbloqueado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fer
 */
public class UsuariosbloqueadoCad extends CN{
    
    public usuariosbloqueado validausuariosbloqueado(String tusuarios) throws Exception {
        usuariosbloqueado miTipo = new usuariosbloqueado();
        try {
            this.Conectar();
            PreparedStatement ps = this.getCon().prepareStatement("select idusuario from usuariosbloqueado where idusuariosbloqueado=? ");
            ps.setString(1, tusuarios);
            //ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                miTipo.setUsername(rs.getString(1));
                //miUser.setPass(rs.getString(2));
            }

        } catch (Exception e) {

            throw e;
        } finally {
            this.Cerrar();
        }
        return miTipo;
    }

    public List<usuariosbloqueado> listarusuariosbloqueado() throws Exception {
        List<usuariosbloqueado> misTipos = new ArrayList<>();

        try {
            this.Conectar();
            Statement st = this.getCon().createStatement();
            ResultSet rs = st.executeQuery("select * from usuariosbloqueado");

            while (rs.next()) {
                usuariosbloqueado miTipo = new usuariosbloqueado();
                miTipo.setIdusuariosbloqueados(rs.getInt(1));
                miTipo.setIdusuario(rs.getInt(2));
                miTipo.setUsername(rs.getString(3));
                miTipo.setIdtipobloqueo(rs.getInt(4));
                misTipos.add(miTipo);
            }
        } catch (Exception e) {
            misTipos = null;
            throw e;
        } finally {
            this.Cerrar();
        }
        return misTipos;
    }

    public int insertausuariosbloqueado(usuariosbloqueado miTip) throws Exception {
        int res = 0;
        String query = "insert into usuariosbloqueado (idusuario,username,idtipobloqueo)"
                + " values(?,?,?)";
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement(query);
            st.setInt(1, miTip.getIdusuario());
            st.setString(2, miTip.getUsername());
            st.setInt(3, miTip.getIdtipobloqueo());
            st.executeUpdate();
            res = 1;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.Cerrar();
        }
        return res;
    }

    public int actualizasusuariosbloqueados(usuariosbloqueado miTipo) throws Exception {
        int res = 0;
        String query = "update usuariosbloqueado set idtipobloqueo=? where idusuariosbloqueados= '" + miTipo.getIdusuariosbloqueados() + "'";
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement(query);
            st.setInt(1, miTipo.getIdusuario());
            st.setString(2, miTipo.getUsername());
            st.setInt(3, miTipo.getIdtipobloqueo());
            st.executeUpdate();
            res = 1;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.Cerrar();
        }
        return res;
    }
    
    public usuariosbloqueado consultausuariosbloqueado(int id) throws Exception {
        usuariosbloqueado miTipo = new usuariosbloqueado();

        try {
            this.Conectar();
            Statement st = this.getCon().createStatement();
            ResultSet rs = st.executeQuery("select * from usuariosbloqueado where idusuariosbloqueados= '" + id + "'");
            if (rs.next()) {
                miTipo.setIdusuariosbloqueados(rs.getInt(1));
                miTipo.setIdusuario(rs.getInt(2));
                miTipo.setUsername(rs.getString(3));
                miTipo.setIdtipobloqueo(rs.getInt(4));
            }

        } catch (Exception e) {
            miTipo = null;
            throw e;
        } finally {
            this.Cerrar();
        }
        return miTipo;
    }
    
}
