/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAD;

import DTO.cursoxgrado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fer
 */
public class CursoxgradoCad extends CN {
    public cursoxgrado validacurso(String curso) throws Exception {
        cursoxgrado miCurso = new cursoxgrado();
        try {
            this.Conectar();
            PreparedStatement ps = this.getCon().prepareStatement("select idcurso from cursoxgrado where idcurso=? ");
            ps.setString(1, curso);
            //ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                miCurso.setIdcurso(rs.getInt(1));
                //miUser.setPass(rs.getString(2));
            }

        } catch (Exception e) {

            throw e;
        } finally {
            this.Cerrar();
        }
        return miCurso;
    }

    public List<cursoxgrado> listarcursosxgrado() throws Exception {
        List<cursoxgrado> misCursos = new ArrayList<>();

        try {
            this.Conectar();
            Statement st = this.getCon().createStatement();
            ResultSet rs = st.executeQuery("select * from cursoxgrado");

            while (rs.next()) {
                cursoxgrado miCurso = new cursoxgrado();
                miCurso.setIdcursoxgrado(rs.getInt(1));
                miCurso.setIdcurso(rs.getInt(1));
                miCurso.setIdgrado(rs.getInt(2));
                misCursos.add(miCurso);
            }
        } catch (Exception e) {
            misCursos = null;
            throw e;
        } finally {
            this.Cerrar();
        }
        return misCursos;
    }

    public int insertacursoxgrado(cursoxgrado miCur) throws Exception {
        int res = 0;
        String query = "insert into cursoxgrado(idcurso,idgrado)"
                + " values(?,?)";
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement(query);
            st.setInt(1, miCur.getIdcurso());
            st.setInt(2, miCur.getIdgrado());
            st.executeUpdate();
            res = 1;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.Cerrar();
        }
        return res;
    }

    public int actualizacursoxgrado(cursoxgrado miCur) throws Exception {
        int res = 0;
        String query = "update cursoxgrado set idcurso=?, idgraoo = ? where idcursoxgrado= '" + miCur.getIdcursoxgrado() + "'";
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement(query);
            st.setInt(1, miCur.getIdcurso());
            st.setInt(2, miCur.getIdgrado());
            st.executeUpdate();
            res = 1;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.Cerrar();
        }
        return res;
    }

    public cursoxgrado consultacursoxgrado(int id) throws Exception {
        cursoxgrado miCurso = new cursoxgrado();

        try {
            this.Conectar();
            Statement st = this.getCon().createStatement();
            ResultSet rs = st.executeQuery("select * from cursoxgrado where idcursoxgrado= '" + id + "'");
            if (rs.next()) {
                miCurso.setIdcurso(rs.getInt(1));
                miCurso.setIdgrado(rs.getInt(2));
                }

        } catch (Exception e) {
            miCurso = null;
            throw e;
        } finally {
            this.Cerrar();
        }
        return miCurso;
    }
    
}
