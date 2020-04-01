/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAD;

import DTO.tiposusuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author arielgeronimo
 */
public class TiposusuarioCad extends CN {

    public tiposusuario validatiposusuario(String tusuarios) throws Exception {
        tiposusuario miTipo = new tiposusuario();
        try {
            this.Conectar();
            PreparedStatement ps = this.getCon().prepareStatement("select tipousuario from tiposusuario where idtipousuario=? ");
            ps.setString(1, tusuarios);
            //ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                miTipo.setTipousuario(rs.getString(1));
                //miUser.setPass(rs.getString(2));
            }

        } catch (Exception e) {

            throw e;
        } finally {
            this.Cerrar();
        }
        return miTipo;
    }

    public List<tiposusuario> listartiposusuario() throws Exception {
        List<tiposusuario> misTipos = new ArrayList<>();

        try {
            this.Conectar();
            Statement st = this.getCon().createStatement();
            ResultSet rs = st.executeQuery("select * from tiposusuario");

            while (rs.next()) {
                tiposusuario miTipo = new tiposusuario();
                miTipo.setIdtipousuario(rs.getInt(1));
                miTipo.setTipousuario(rs.getString(2));
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

    public int insertatiposusuario(tiposusuario miTip) throws Exception {
        int res = 0;
        String query = "insert into tiposusuario (tipousuario)"
                + " values(?)";
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement(query);
            st.setString(1, miTip.getTipousuario());
            st.executeUpdate();
            res = 1;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.Cerrar();
        }
        return res;
    }

    public int actualizaTiposusuario(tiposusuario miTipo) throws Exception {
        int res = 0;
        String query = "update tiposusuario set tipousuario=? where idtipousuario= '" + miTipo.getIdtipousuario() + "'";
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement(query);
            st.setString(1, miTipo.getTipousuario());
            st.executeUpdate();
            res = 1;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.Cerrar();
        }
        return res;
    }
    
    public tiposusuario consultaTiposusuario(int id) throws Exception {
        tiposusuario miTipo = new tiposusuario();

        try {
            this.Conectar();
            Statement st = this.getCon().createStatement();
            ResultSet rs = st.executeQuery("select * from tiposusuario where idtipousuario= '" + id + "'");
            if (rs.next()) {
                miTipo.setIdtipousuario(rs.getInt(1));
                miTipo.setTipousuario(rs.getString(2));
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
