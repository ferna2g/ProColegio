/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAD;

import DTO.estados;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author arielgeronimo
 */
public class EstadoCad extends CN {

    public estados validacurso(String estado) throws Exception {
        estados miEstado = new estados();
        try {
            this.Conectar();
            PreparedStatement ps = this.getCon().prepareStatement("select estado from estados where idestado=? ");
            ps.setString(1, estado);
            //ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                miEstado.setEstado(rs.getString(1));
                //miUser.setPass(rs.getString(2));
            }

        } catch (Exception e) {

            throw e;
        } finally {
            this.Cerrar();
        }
        return miEstado;
    }

    public List<estados> listarEstados() throws Exception {
        List<estados> misEstados = new ArrayList<>();

        try {
            this.Conectar();
            Statement st = this.getCon().createStatement();
            ResultSet rs = st.executeQuery("select * from estados");

            while (rs.next()) {
                estados miEstado = new estados();
                miEstado.setIdestado(rs.getInt(1));
                miEstado.setEstado(rs.getString(2));
                misEstados.add(miEstado);
            }
        } catch (Exception e) {
            misEstados = null;
            throw e;
        } finally {
            this.Cerrar();
        }
        return misEstados;
    }

    public int insertaEstado(estados miEstado) throws Exception {
        int res = 0;
        String query = "insert into estados(estado)"
                + " values(?)";
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement(query);
            st.setString(1, miEstado.getEstado());
            st.executeUpdate();
            res = 1;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.Cerrar();
        }
        return res;
    }

    public int actualizaEstado(estados miEstado) throws Exception {
        int res = 0;
        String query = "update estados set estado=? where idestado= '" + miEstado.getIdestado()+ "'";
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement(query);
            st.setString(1, miEstado.getEstado());
            st.executeUpdate();
            res = 1;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.Cerrar();
        }
        return res;
    }

    public estados consultaEstado(int id) throws Exception {
        estados miEstado = new estados();

        try {
            this.Conectar();
            Statement st = this.getCon().createStatement();
            ResultSet rs = st.executeQuery("select * from estados where idestado= '" + id + "'");
            if (rs.next()) {
                miEstado.setIdestado(rs.getInt(1));
                miEstado.setEstado(rs.getString(2));
            }

        } catch (Exception e) {
            miEstado = null;
            throw e;
        } finally {
            this.Cerrar();
        }
        return miEstado;
    }

}
