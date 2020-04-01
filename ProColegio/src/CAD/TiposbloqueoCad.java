/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAD;

import DTO.tiposbloqueo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fer
 */
public class TiposbloqueoCad extends CN{
    
    public tiposbloqueo validatiposbloqueo(String tbloqueos) throws Exception {
        tiposbloqueo miTipo = new tiposbloqueo();
        try {
            this.Conectar();
            PreparedStatement ps = this.getCon().prepareStatement("select tipobloqueo from tiposbloqueo where idtipobloqueo=? ");
            ps.setString(1, tbloqueos);
            //ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                miTipo.setTipobloqueo(rs.getString(1));
                //miUser.setPass(rs.getString(2));
            }

        } catch (Exception e) {

            throw e;
        } finally {
            this.Cerrar();
        }
        return miTipo;
    }

    public List<tiposbloqueo> listartiposbloqueo() throws Exception {
        List<tiposbloqueo> misTipos = new ArrayList<>();

        try {
            this.Conectar();
            Statement st = this.getCon().createStatement();
            ResultSet rs = st.executeQuery("select * from tiposbloqueo");

            while (rs.next()) {
                tiposbloqueo miTipo = new tiposbloqueo();
                miTipo.setIdtipobloqueo(rs.getInt(1));
                miTipo.setTipobloqueo(rs.getString(2));
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

    public int insertatiposbloqueo(tiposbloqueo miTip) throws Exception {
        int res = 0;
        String query = "insert into tiposbloqueo (tipobloqueo)"
                + " values(?)";
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement(query);
            st.setString(1, miTip.getTipobloqueo());
            st.executeUpdate();
            res = 1;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.Cerrar();
        }
        return res;
    }

    public int actualizaTiposbloqueo(tiposbloqueo miTipo) throws Exception {
        int res = 0;
        String query = "update tiposbloqueo set tipobloqueo=? where idtipobloqueo= '" + miTipo.getIdtipobloqueo() + "'";
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement(query);
            st.setString(1, miTipo.getTipobloqueo());
            st.executeUpdate();
            res = 1;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.Cerrar();
        }
        return res;
    }
    
    public tiposbloqueo consultaTiposbloqueo(int id) throws Exception {
        tiposbloqueo miTipo = new tiposbloqueo();

        try {
            this.Conectar();
            Statement st = this.getCon().createStatement();
            ResultSet rs = st.executeQuery("select * from tiposbloqueo where idtipobloqueo= '" + id + "'");
            if (rs.next()) {
                miTipo.setIdtipobloqueo(rs.getInt(1));
                miTipo.setTipobloqueo(rs.getString(2));
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
