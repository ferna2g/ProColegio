/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAD;

import DTO.gradoacademico;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fer
 */
public class GradoacademicoCad extends CN{
    
    public gradoacademico validacurso(String nivel) throws Exception {
        gradoacademico miNivel = new gradoacademico();
        try {
            this.Conectar();
            PreparedStatement ps = this.getCon().prepareStatement("select nivel from gradoacademico where idgrado=? ");
            ps.setString(1, nivel);
            
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                miNivel.setNivel(rs.getString(1));
                
            }

        } catch (Exception e) {

            throw e;
        } finally {
            this.Cerrar();
        }
        return miNivel;
    }
    
    public List<gradoacademico> listarNivel() throws Exception {
        List<gradoacademico> misNiveles = new ArrayList<>();

        try {
            this.Conectar();
            Statement st = this.getCon().createStatement();
            ResultSet rs = st.executeQuery("select * from gradoacademico");

            while (rs.next()) {
                gradoacademico miNivel = new gradoacademico();
                miNivel.setIdgrado(rs.getInt(1));
                miNivel.setNivel(rs.getString(2));
                misNiveles.add(miNivel);
            }
        } catch (Exception e) {
            misNiveles = null;
            throw e;
        } finally {
            this.Cerrar();
        }
        return misNiveles;
    }
    
    public int insertaNivel(gradoacademico miNivel) throws Exception {
        int res = 0;
        String query = "insert into gradoacademico(nivel)"
                + " values(?)";
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement(query);
            st.setString(1, miNivel.getNivel());
            st.executeUpdate();
            res = 1;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.Cerrar();
        }
        return res;
    }

    public int actualizaNivel(gradoacademico miNivel) throws Exception {
        int res = 0;
        String query = "update gradoacademico set nivel=? where idgrado= '" + miNivel.getIdgrado() + "'";
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement(query);
            st.setString(1, miNivel.getNivel());
            st.executeUpdate();
            res = 1;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.Cerrar();
        }
        return res;
    }
    
    public gradoacademico consultaNivel(int id) throws Exception {
        gradoacademico miNivel = new gradoacademico();

        try {
            this.Conectar();
            Statement st = this.getCon().createStatement();
            ResultSet rs = st.executeQuery("select * from gradoacademico where idgrado= '" + id + "'");
            if (rs.next()) {
                miNivel.setIdgrado(rs.getInt(1));
                miNivel.setNivel(rs.getString(2));
            }

        } catch (Exception e) {
            miNivel = null;
            throw e;
        } finally {
            this.Cerrar();
        }
        return miNivel;
    }

}
