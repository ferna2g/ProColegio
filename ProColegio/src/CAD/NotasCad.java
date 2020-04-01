/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAD;

import DTO.notas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fer
 */
public class NotasCad extends CN{
    
    public notas validacurso(String nota) throws Exception {
        notas miNota = new notas();
        try {
            this.Conectar();
            PreparedStatement ps = this.getCon().prepareStatement("select curso from curso where idcurso=? ");
            ps.setString(1, nota);
            //ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                miNota.setEstado(rs.getString(1));
                //miUser.setPass(rs.getString(2));
            }

        } catch (Exception e) {

            throw e;
        } finally {
            this.Cerrar();
        }
        return miNota;
    }

    public List<notas> listarNotas() throws Exception {
        List<notas> misNotas = new ArrayList<>();

        try {
            this.Conectar();
            Statement st = this.getCon().createStatement();
            ResultSet rs = st.executeQuery("select * from notas");

            while (rs.next()) {
                notas miNota = new notas();
                miNota.setIdnotas(rs.getInt(1));
                miNota.setNota1(rs.getInt(2));
                miNota.setNota2(rs.getInt(3));
                miNota.setNota3(rs.getInt(4));
                miNota.setNfinal(rs.getInt(5));
                miNota.setPromedio(rs.getInt(6));
                miNota.setRecuperacion(rs.getInt(7));
                miNota.setEstado(rs.getString(8));
                miNota.setIdestudiante(rs.getInt(9));
                miNota.setIdcurso(rs.getInt(10));
                misNotas.add(miNota);
            }
        } catch (Exception e) {
            misNotas = null;
            throw e;
        } finally {
            this.Cerrar();
        }
        return misNotas;
    }

    public int insertaNotas(notas miNota) throws Exception {
        int res = 0;
        String query = "insert into notas(nota1, nota2, nota3, nfinal,"
                + "promedio, recuperacion, estado, idestudiante, idcurso)"
                + " values(?,?,?,?,?,?,?,?,?)";
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement(query);
            st.setInt(1, miNota.getNota1());
            st.setInt(2, miNota.getNota2());
            st.setInt(3, miNota.getNota3());
            st.setInt(4, miNota.getNfinal());
            st.setInt(5, miNota.getPromedio());
            st.setInt(6, miNota.getRecuperacion());
            st.setString(7, miNota.getEstado());
            st.setInt(8, miNota.getIdestudiante());
            st.setInt(9, miNota.getIdcurso());
            st.executeUpdate();
            res = 1;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.Cerrar();
        }
        return res;
    }

    public int actualizaNotas(notas miNota) throws Exception {
        int res = 0;
        String query = "update notas set nota1=?, nota2=?, nota3=?, nfinal=?,"
                + "promedio=?, recuperacion=?, estado=?, idestudiante=?,"
                + "idcurso=? where idnotas= '" + miNota.getIdnotas() + "'";
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement(query);
            st.setInt(1, miNota.getNota1());
            st.setInt(2, miNota.getNota2());
            st.setInt(3, miNota.getNota3());
            st.setInt(4, miNota.getNfinal());
            st.setInt(5, miNota.getPromedio());
            st.setInt(6, miNota.getRecuperacion());
            st.setString(7, miNota.getEstado());
            st.setInt(8, miNota.getIdestudiante());
            st.setInt(9, miNota.getIdcurso());
            st.executeUpdate();
            res = 1;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.Cerrar();
        }
        return res;
    }

    public notas consultaNotas(int id) throws Exception {
        notas miNota = new notas();

        try {
            this.Conectar();
            Statement st = this.getCon().createStatement();
            ResultSet rs = st.executeQuery("select * from notas where idnotas= '" + id + "'");
            if (rs.next()) {
                miNota.setIdnotas(rs.getInt(1));
                miNota.setNota1(rs.getInt(2));
                miNota.setNota2(rs.getInt(3));
                miNota.setNota3(rs.getInt(4));
                miNota.setNfinal(rs.getInt(5));
                miNota.setPromedio(rs.getInt(6));
                miNota.setRecuperacion(rs.getInt(7));
                miNota.setEstado(rs.getString(8));
                miNota.setIdestudiante(rs.getInt(9));
                miNota.setIdcurso(rs.getInt(10));
            }

        } catch (Exception e) {
            miNota = null;
            throw e;
        } finally {
            this.Cerrar();
        }
        return miNota;
    }
}
