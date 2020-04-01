/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAD;

import DTO.maestroxcurso;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fer
 */
public class MaestroxcursoCad extends CN {
    
    public maestroxcurso validamaestro(String maestro) throws Exception {
        maestroxcurso miMaestro = new maestroxcurso();
        try {
            this.Conectar();
            PreparedStatement ps = this.getCon().prepareStatement("select idmaestroxcurso from maestroxcurso where idmaestroxcurso=? ");
            ps.setString(1, maestro);
            //ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                miMaestro.setIdmaestroxcurso(rs.getInt(1));
                //miUser.setPass(rs.getString(2));
            }

        } catch (Exception e) {

            throw e;
        } finally {
            this.Cerrar();
        }
        return miMaestro;
    }

    public List<maestroxcurso> listarmaestroxcurso() throws Exception {
        List<maestroxcurso> misMaestros = new ArrayList<>();

        try {
            this.Conectar();
            Statement st = this.getCon().createStatement();
            ResultSet rs = st.executeQuery("select * from cursoxgrado");

            while (rs.next()) {
                maestroxcurso miMaestro = new maestroxcurso();
                miMaestro.setIdmaestroxcurso(rs.getInt(1));
                miMaestro.setIdmaestro(rs.getInt(2));
                miMaestro.setIdcurso(rs.getInt(3));
                miMaestro.setFregistro(rs.getDate(4));
                misMaestros.add(miMaestro);
            }
        } catch (Exception e) {
            misMaestros = null;
            throw e;
        } finally {
            this.Cerrar();
        }
        return misMaestros;
    }

    public int insertamaestroxcurso(maestroxcurso miMaes) throws Exception {
        int res = 0;
        String query = "insert into maestroxcurso(idmaestro,idcurso,fregistro)"
                + " values(?,?,?)";
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement(query);
            st.setInt(1, miMaes.getIdmaestro());
            st.setInt(2, miMaes.getIdcurso());
            st.setDate(3, miMaes.getFregistro());
            st.executeUpdate();
            res = 1;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.Cerrar();
        }
        return res;
    }

    public int actualizamaestroxcurso(maestroxcurso miMaes) throws Exception {
        int res = 0;
        String query = "update maestroxcurso set idmaestro=?, idcurso = ? where idmaestroxcurso= '" + miMaes.getIdmaestroxcurso()+ "'";
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement(query);
            st.setInt(1, miMaes.getIdmaestro());
            st.setInt(2, miMaes.getIdcurso());
            st.executeUpdate();
            res = 1;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.Cerrar();
        }
        return res;
    }

    public maestroxcurso consultamaestroxcurso(int id) throws Exception {
        maestroxcurso miMaestro = new maestroxcurso();

        try {
            this.Conectar();
            Statement st = this.getCon().createStatement();
            ResultSet rs = st.executeQuery("select * from maestroxcurso where idmaestroxcurso= '" + id + "'");
            if (rs.next()) {
                miMaestro.setIdmaestroxcurso(rs.getInt(1));
                miMaestro.setIdmaestro(rs.getInt(2));
                miMaestro.setIdcurso(rs.getInt(3));
                miMaestro.setFregistro(rs.getDate(4));
                }

        } catch (Exception e) {
            miMaestro = null;
            throw e;
        } finally {
            this.Cerrar();
        }
        return miMaestro;
    }
}
