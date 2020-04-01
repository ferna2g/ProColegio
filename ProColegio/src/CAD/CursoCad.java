package CAD;

import DTO.curso;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fer
 */
public class CursoCad extends CN {

    public curso validacurso(String curso) throws Exception {
        curso miCurso = new curso();
        try {
            this.Conectar();
            PreparedStatement ps = this.getCon().prepareStatement("select curso from curso where idcurso=? ");
            ps.setString(1, curso);
            //ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                miCurso.setCurso(rs.getString(1));
                //miUser.setPass(rs.getString(2));
            }

        } catch (Exception e) {

            throw e;
        } finally {
            this.Cerrar();
        }
        return miCurso;
    }

    public List<curso> listarCursos() throws Exception {
        List<curso> misCursos = new ArrayList<>();

        try {
            this.Conectar();
            Statement st = this.getCon().createStatement();
            ResultSet rs = st.executeQuery("select * from curso");

            while (rs.next()) {
                curso miCurso = new curso();
                miCurso.setIdcurso(rs.getInt(1));
                miCurso.setCurso(rs.getString(2));
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

    public int insertaCurso(curso miCur) throws Exception {
        int res = 0;
        String query = "insert into curso(curso)"
                + " values(?)";
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement(query);
            st.setString(1, miCur.getCurso());
            st.executeUpdate();
            res = 1;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.Cerrar();
        }
        return res;
    }

    public int actualizaCurso(curso miCur) throws Exception {
        int res = 0;
        String query = "update curso set curso=? where idcurso= '" + miCur.getIdcurso() + "'";
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement(query);
            st.setString(1, miCur.getCurso());
            st.executeUpdate();
            res = 1;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.Cerrar();
        }
        return res;
    }

    public curso consultaCurso(int id) throws Exception {
        curso miCurso = new curso();

        try {
            this.Conectar();
            Statement st = this.getCon().createStatement();
            ResultSet rs = st.executeQuery("select * from curso where idcurso= '" + id + "'");
            if (rs.next()) {
                miCurso.setIdcurso(rs.getInt(1));
                miCurso.setCurso(rs.getString(2));
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
