/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import DTO.usuario;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
/**
 *
 * @author JuaNFeR
 */
public class UsuarioCad extends CN{
    public usuario validausuario(String nombre, String password)throws  Exception{
          usuario miUser= new usuario();
        try {
          this.Conectar();
        PreparedStatement ps = this.getCon().prepareStatement("select username, pass from usuarios where idusuario=? ");
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
      public List<usuario> listarUsuarios() throws Exception {
      List<usuario> misUsuarios= new ArrayList<>();

        try {
            this.Conectar();
            Statement st = this.getCon().createStatement();
            ResultSet rs = st.executeQuery("select * from usuarios");

            while (rs.next()) {
                usuario miUser = new usuario();
                miUser.setIdusuario(rs.getInt(1));
                miUser.setUsername(rs.getString(2));
                miUser.setPass(rs.getString(3));
                miUser.setIdestado(rs.getInt(4));
                miUser.setIdtipousuario(rs.getInt(5));
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
     public int insertaUsuario(usuario miUsuario) throws Exception {
        int res = 0;
        String query = "insert into usuarios(username, pass, idestado, idtipousuario)"
                + " values(?,?,?,?)";
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement(query);
            st.setString(1, miUsuario.getUsername());
            st.setString(2, miUsuario.getPass());
            st.setInt(3, miUsuario.getIdestado());
            st.setInt(4, miUsuario.getIdtipousuario());
            st.executeUpdate();
            res = 1;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.Cerrar();
        }
        return res;
    }
public int actualizaUsuario(usuario miUsuario) throws Exception {
        int res = 0;
        String query = "update usuarios set username = ?, pass = ?, idestado = ?, idtipousuario = ?"
                + " where idusuario = '"+miUsuario.getIdusuario()+"'";
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement(query);
            st.setString(1, miUsuario.getUsername());
            st.setString(2, miUsuario.getPass());
            st.setInt(3, miUsuario.getIdestado());
            st.setInt(4, miUsuario.getIdtipousuario());
            st.executeUpdate();
            res = 1;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.Cerrar();
        }
        return res;
    }

    public usuario consultaUsuario(int id) throws Exception {
        usuario miUser = new usuario();

        try {
            this.Conectar();
            Statement st = this.getCon().createStatement();
            ResultSet rs = st.executeQuery("select * from usuarios where idusuario= '"+id+"'");
         if (rs.next()) {
                miUser.setIdusuario(rs.getInt(1));
                miUser.setUsername(rs.getString(2));
                miUser.setPass(rs.getString(3));
                miUser.setIdestado(rs.getInt(4));
                miUser.setIdtipousuario(rs.getInt(5));
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
