/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Entidades.Cuartel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author nacho
 */
public class CuartelData {
     private Connection con = null;
     
     public CuartelData(){
           con = miConexion.getConexion();
    }
     
     public void guardarCuartel(Cuartel cuartel)throws SQLException{
        String sql = "INSERT INTO `cuartel`(nombre_cuartel, direccion, coord_X, coord_Y, teléfono, correo) VALUES (?,?,?,?,?,?)";
        try{
           PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
           ps.setString(1, cuartel.getNombre_cuartel());
           ps.setString(2, cuartel.getDireccion());
           ps.setInt(3, cuartel.getCoord_X());
           ps.setInt(4, cuartel.getCoord_Y());
           ps.setString(5, cuartel.getTelefono());
           ps.setString(6, cuartel.getCorreo());
           
           ps.executeUpdate();
           
          ResultSet rs = ps.getGeneratedKeys();
          if(rs.next()){
                cuartel.setcodCuartel(rs.getInt("codCuartel"));
          }else{
              System.out.println("No se pudo obtener ID");
        }
        }catch(Exception ex){
            System.out.println("Problemas al acceder a Cuartel"+ex.getMessage());
         
    }
 }
     public Cuartel buscarCuartel(int id){
         Cuartel cuartel = null;
        String sql = "SELECT nombre_cuartel,direccion,coord_X,coord_Y,teléfono,correo FROM cuartel";
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
            cuartel = new  Cuartel();
            cuartel.setcodCuartel(id);
            cuartel.setNombre_cuartel(rs.getString("nombre_cuartel"));
            cuartel.setDireccion(rs.getString("direccion"));
            cuartel.setCoord_X(rs.getInt("coord_X"));
            cuartel.setCoord_Y(rs.getInt("coord_Y"));
            cuartel.setTelefono(rs.getString("teléfono"));
     
                JOptionPane.showMessageDialog(null, cuartel.getNombre_cuartel());
        }else {
                JOptionPane.showMessageDialog(null, "No existe el cuartel");
                }
        ps.close();
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Cuartel "+ex.getMessage());
        }
        return cuartel;
}    
     public List<Cuartel> listarCuartel() throws SQLException{
         ArrayList<Cuartel> cuarteles = new ArrayList<>();
         String sql = "SELECT * FROM cuartel";
         try{
             PreparedStatement ps = con.prepareStatement(sql);
               
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Cuartel cuartel = new Cuartel();
                cuartel.setcodCuartel(rs.getInt("codCuartel"));
                cuartel.setNombre_cuartel(rs.getString("nombre_cuartel"));
                cuartel.setDireccion(rs.getString("direccion"));
                cuartel.setCoord_X(rs.getInt("coord_X"));
                cuartel.setCoord_Y(rs.getInt("coord_Y"));
                cuartel.setTelefono(rs.getString("teléfono"));
                cuartel.setCorreo(rs.getString("correo"));
                
                cuarteles.add(cuartel);
                 JOptionPane.showMessageDialog(null,cuartel.getNombre_cuartel());              
            }
            ps.close();
         }catch(Exception ex){
             System.out.println(ex.getMessage());
     }
         return cuarteles;
     }
     
          public void modificarCuartel(Cuartel cuartel){
        String sql = "UPDATE cuartel SET  nombre_cuartel = ?, direccion = ?, coord_X = ?, coord_Y = ?, teléfono = ?, correo = ?  WHERE  codCuartel = ?";
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement(sql);
           
            ps.setString(1, cuartel.getNombre_cuartel());
            ps.setString(2, cuartel.getDireccion());
            ps.setInt(3, cuartel.getCoord_X());
            ps.setInt(4, cuartel.getCoord_Y());
            ps.setString(5, cuartel.getTelefono());
            ps.setString(6, cuartel.getCorreo());
             ps.setInt(7, cuartel.getcodCuartel());

            int exito = ps.executeUpdate();
            
            if(exito == 1){
                JOptionPane.showMessageDialog(null, "Modificado exitosamente.");
            }else{
                JOptionPane.showMessageDialog(null,"El cuartel no existe");
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla cuartel "+ex.getMessage());
        }
    }
                   public void eliminarCuartel(int codCuartel){
        String sql = "DELETE FROM cuartel WHERE codCuartel = ?";
        Cuartel cuartel = null;
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codCuartel);
            
            int filas = ps.executeUpdate();
            if(filas>0){
                JOptionPane.showMessageDialog(null, "cuartel borrado.");
            }
            ps.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cuartel");
       }
    }
}
