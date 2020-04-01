/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAD;

import DTO.estudiante;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fer
 */
public class EstudianteCad extends CN{
    
    public estudiante validaestudiante(String nombre, String password)throws  Exception{
          estudiante miUser= new estudiante();
        try {
          this.Conectar();
        PreparedStatement ps = this.getCon().prepareStatement("select nombre,nit apellido from usuario where usuario=? ");
            ps. setString(1, nombre);
            ps.setString(2, password);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                miUser.setUsername(rs.getString(1));
                miUser.setPass(rs.getString(2));
             
            }
      
        } catch (Exception e) {
         
            throw e;
        }
       finally{
            this.Cerrar();
        }
        return miUser;
    }
      public List<estudiante> listarEstudiantes() throws Exception {
      List<estudiante> misEstudiantes= new ArrayList<>();

        try {
            this.Conectar();
            Statement st = this.getCon().createStatement();
            ResultSet rs = st.executeQuery("select * from estudiante");

            while (rs.next()) {
                estudiante miUser = new estudiante();
                
                miUser.setIdestudiante(rs.getInt(1));
                miUser.setNombre(rs.getString(2));
                miUser.setApellidos(rs.getString(3));
                miUser.setUsername(rs.getString(4));
                miUser.setPass(rs.getString(5));
                miUser.setCorreo(rs.getString(6));
                miUser.setFnacimiento(rs.getDate(7));
                miUser.setFregistro(rs.getDate(8));
                miUser.setDireccion(rs.getString(9));
                miUser.setTelefono(rs.getInt(10));
                miUser.setIdgrado(rs.getInt(11));
                misEstudiantes.add(miUser);
            }
        } catch (Exception e) {
            misEstudiantes = null;
            throw e;
        } finally {
            this.Cerrar();
        }
        return misEstudiantes;
    }
     public int insertaEstudiante(estudiante miEstudiante) throws Exception {
        int res = 0;
        String query = "insert into estudiante(nombre, apellidos, username, pass, correo,"
                + "fnacimiento, fregistro, direccion, telefono, idgrado)"
                + " values(?,?,?,?,?,?,?,?,?,?)";
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement(query);
            st.setString(1, miEstudiante.getNombre());
            st.setString(2, miEstudiante.getApellidos());
            st.setString(3, miEstudiante.getUsername());
            st.setString(4, miEstudiante.getPass());
            st.setString(5, miEstudiante.getCorreo());
            st.setDate(6, miEstudiante.getFnacimiento());
            st.setDate(7, miEstudiante.getFregistro());
            st.setString(8, miEstudiante.getDireccion());
            st.setInt(9, miEstudiante.getTelefono());
            st.setInt(10, miEstudiante.getIdgrado());            
            st.executeUpdate();
            res = 1;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.Cerrar();
        }
        return res;
    }
public int actualizaEstudiante(estudiante miEstudiante) throws Exception {
        int res = 0;
        String query = "update estudiante set nombre = ?, apellidos = ?, "
                + "username = ?, pass = ?, correo = ?, fnacimiento=?,"
                + "direccion = ?, telefono = ?, idgrado = ? "
                + " where idestudiante = '"+miEstudiante.getIdestudiante()+"'";
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement(query);
            st.setString(1, miEstudiante.getNombre());
            st.setString(2, miEstudiante.getApellidos());
            st.setString(3, miEstudiante.getUsername());
            st.setString(4, miEstudiante.getPass());
            st.setString(5, miEstudiante.getCorreo());
            st.setDate(6, miEstudiante.getFnacimiento());
            st.setString(7, miEstudiante.getDireccion());
            st.setInt(8, miEstudiante.getTelefono());
            st.setInt(9, miEstudiante.getIdgrado());
            st.executeUpdate();
            res = 1;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.Cerrar();
        }
        return res;
    }

    public estudiante consultaEstudiante(int id) throws Exception {
        estudiante miUser = new estudiante();

        try {
            this.Conectar();
            Statement st = this.getCon().createStatement();
            ResultSet rs = st.executeQuery("select * from estudiante where idestudiante= '"+id+"'");
         if (rs.next()) {
                miUser.setIdestudiante(rs.getInt(1));
                miUser.setNombre(rs.getString(2));
                miUser.setApellidos(rs.getString(3));
                miUser.setUsername(rs.getString(4));
                miUser.setPass(rs.getString(5));
                miUser.setCorreo(rs.getString(6));
                miUser.setFnacimiento(rs.getDate(7));
                miUser.setFregistro(rs.getDate(8));
                miUser.setDireccion(rs.getString(9));
                miUser.setTelefono(rs.getInt(10));
                miUser.setIdgrado(rs.getInt(11));
            }

        } catch (Exception e) {
            miUser = null;
            throw e;
        } finally {
            this.Cerrar();
        }
        return miUser;
    }
    
}
