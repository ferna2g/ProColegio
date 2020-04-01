/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAD;

import DTO.maestro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fer
 */
public class MaestroCad extends CN{
    
    public maestro validamaestro(String nombre, String password)throws  Exception{
          maestro miUser= new maestro();
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
      public List<maestro> listarMaestros() throws Exception {
      List<maestro> misMaestros= new ArrayList<>();

        try {
            this.Conectar();
            Statement st = this.getCon().createStatement();
            ResultSet rs = st.executeQuery("select * from maestro");

            while (rs.next()) {
                maestro miUser = new maestro();
                
                miUser.setIdmaestro(rs.getInt(1));
                miUser.setNombre(rs.getString(2));
                miUser.setApellidos(rs.getString(3));
                miUser.setUsername(rs.getString(4));
                miUser.setPass(rs.getString(5));
                miUser.setCorreo(rs.getString(6));
                miUser.setFnacimiento(rs.getDate(7));
                miUser.setFregistro(rs.getDate(8));
                miUser.setCui(rs.getInt(9));
                miUser.setDireccion(rs.getString(10));
                miUser.setTelefono(rs.getInt(11));
                misMaestros.add(miUser);
            }
        } catch (Exception e) {
            misMaestros = null;
            throw e;
        } finally {
            this.Cerrar();
        }
        return misMaestros;
    }
     public int insertaMaestro(maestro miMaestro) throws Exception {
        int res = 0;
        String query = "insert into maestro(nombre, apellidos, username, pass, correo,"
                + "fnacimiento, fregistro, cui, direccion, telefono)"
                + " values(?,?,?,?,?,?,?,?,?,?)";
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement(query);
            st.setString(1, miMaestro.getNombre());
            st.setString(2, miMaestro.getApellidos());
            st.setString(3, miMaestro.getUsername());
            st.setString(4, miMaestro.getPass());
            st.setString(5, miMaestro.getCorreo());
            st.setDate(6, miMaestro.getFnacimiento());
            st.setDate(7, miMaestro.getFregistro());
            st.setInt(8, miMaestro.getCui());
            st.setString(9, miMaestro.getDireccion());
            st.setInt(10, miMaestro.getTelefono());
            st.executeUpdate();
            res = 1;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.Cerrar();
        }
        return res;
    }
public int actualizaMaestro(maestro miMaestro) throws Exception {
        int res = 0;
        String query = "update maestro set nombre = ?, apellidos = ?, "
                + "username = ?, pass = ?, correo = ?,fnacimiento = ?, cui=?,"
                + "direccion = ?, telefono = ? "
                + " where idmaestro = '"+miMaestro.getIdmaestro()+"'";
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement(query);
            st.setString(1, miMaestro.getNombre());
            st.setString(2, miMaestro.getApellidos());
            st.setString(3, miMaestro.getUsername());
            st.setString(4, miMaestro.getPass());
            st.setString(5, miMaestro.getCorreo());
            st.setDate(6, miMaestro.getFnacimiento());
            st.setInt(7, miMaestro.getCui());
            st.setString(8, miMaestro.getDireccion());
            st.setInt(9, miMaestro.getTelefono());
            st.executeUpdate();
            res = 1;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.Cerrar();
        }
        return res;
    }

    public maestro consultaMaestro(int id) throws Exception {
        maestro miUser = new maestro();

        try {
            this.Conectar();
            Statement st = this.getCon().createStatement();
            ResultSet rs = st.executeQuery("select * from maestro where idmaestro= '"+id+"'");
         if (rs.next()) {
                miUser.setIdmaestro(rs.getInt(1));
                miUser.setNombre(rs.getString(2));
                miUser.setApellidos(rs.getString(3));
                miUser.setUsername(rs.getString(4));
                miUser.setPass(rs.getString(5));
                miUser.setCorreo(rs.getString(6));
                miUser.setFnacimiento(rs.getDate(7));
                miUser.setFregistro(rs.getDate(8));
                miUser.setCui(rs.getInt(9));
                miUser.setDireccion(rs.getString(10));
                miUser.setTelefono(rs.getInt(11));
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
