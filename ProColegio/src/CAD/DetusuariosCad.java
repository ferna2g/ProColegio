/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAD;

import DTO.detusuarios;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fer
 */
public class DetusuariosCad extends CN{
    
    public detusuarios validadetusuarios(String nombre, String password)throws  Exception{
          detusuarios miUser= new detusuarios();
        try {
          this.Conectar();
        PreparedStatement ps = this.getCon().prepareStatement("select username, pass from detusuarios where idusuarios=? ");
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
      public List<detusuarios> listardetusuarios() throws Exception {
      List<detusuarios> misUsuarios= new ArrayList<>();

        try {
            this.Conectar();
            Statement st = this.getCon().createStatement();
            ResultSet rs = st.executeQuery("select * from detusuarios");

            while (rs.next()) {
                detusuarios miUser = new detusuarios();
                miUser.setIdusuarios(rs.getInt(1));
                miUser.setNombre(rs.getString(2));
                miUser.setApellidos(rs.getString(3));
                miUser.setUsername(rs.getString(4));
                miUser.setPass(rs.getString(5));
                miUser.setCorreo(rs.getString(6));
                miUser.setFnacimiento(rs.getDate(7));
                miUser.setFregistro(rs.getDate(8));
                miUser.setDireccion(rs.getString(9));
                miUser.setTelefono(rs.getInt(10));
                miUser.setIdtipousuario(rs.getInt(11));
                misUsuarios.add(miUser);
            }
        } catch (Exception e) {
            misUsuarios = null;
            throw e;
        } finally {
            this.Cerrar();
        }
        return misUsuarios;
    }
     public int insertadetusuarios(detusuarios miUsuario) throws Exception {
        int res = 0;
        String query = "insert into detusuarios(nombre,apellidos,"
                + "username, pass,correo,fnacimiento,fregistro,direccion,telefono,"
                + "idtipousuario)"
                + " values(?,?,?,?,?,?,?,?,?,?)";
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement(query);
            st.setString(1, miUsuario.getNombre());
            st.setString(2, miUsuario.getApellidos());
            st.setString(3, miUsuario.getUsername());
            st.setString(4, miUsuario.getPass());
            st.setString(5, miUsuario.getCorreo());
            st.setDate(6, (Date) miUsuario.getFnacimiento());
            st.setDate(7, (Date) miUsuario.getFregistro());
            st.setString(8, miUsuario.getDireccion());
            st.setInt(9, miUsuario.getTelefono());
            st.setInt(10, miUsuario.getIdtipousuario());
            st.executeUpdate();
            res = 1;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.Cerrar();
        }
        return res;
    }
public int actualizadetusuario(detusuarios miUsuario) throws Exception {
        int res = 0;
        String query = "update usuarios set nombre=?, apellidos=?,"
                + " username = ?, pass = ?, correo = ?, fnacimiento = ?,"
                + " direccion = ?, telefono = ?, idtipousuario = ?"
                + " where idusuarios = '"+miUsuario.getIdusuarios()+"'";
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement(query);
            st.setString(1, miUsuario.getNombre());
            st.setString(2, miUsuario.getApellidos());
            st.setString(3, miUsuario.getUsername());
            st.setString(4, miUsuario.getPass());
            st.setString(5, miUsuario.getCorreo());
            st.setDate(6, (Date) miUsuario.getFnacimiento());
            st.setString(7, miUsuario.getDireccion());
            st.setInt(8, miUsuario.getTelefono());
            st.setInt(9, miUsuario.getIdtipousuario());
            st.executeUpdate();
            res = 1;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.Cerrar();
        }
        return res;
    }

    public detusuarios consultadetusuarios(int id) throws Exception {
        detusuarios miUser = new detusuarios();

        try {
            this.Conectar();
            Statement st = this.getCon().createStatement();
            ResultSet rs = st.executeQuery("select * from detusuarios where idusuarios= '"+id+"'");
         if (rs.next()) {
                miUser.setIdusuarios(rs.getInt(1));
                miUser.setNombre(rs.getString(2));
                miUser.setApellidos(rs.getString(3));
                miUser.setUsername(rs.getString(4));
                miUser.setPass(rs.getString(5));
                miUser.setCorreo(rs.getString(6));
                miUser.setFnacimiento(rs.getDate(7));
                miUser.setFregistro(rs.getDate(8));
                miUser.setDireccion(rs.getString(9));
                miUser.setTelefono(rs.getInt(10));
                miUser.setIdtipousuario(rs.getInt(11));
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
