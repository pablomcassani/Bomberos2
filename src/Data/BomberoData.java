/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Entidades.Bombero;
import Entidades.Brigada;
import java.sql.Connection;
import java.sql.Date;
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
public class BomberoData {
    private Connection con = null;
    private BrigadaData briData = new BrigadaData();
    
     public BomberoData(){
           con = miConexion.getConexion();
    }
    
    public void guardarBomero(Bombero bombero){
        String sql = "INSERT INTO bombero (dni, nombre_ape, grupoSanguineo, fecha_nac, celular, codBrigada) VALUES (?,?,?,?,?,?)";
        try{
           PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
           ps.setString(1, bombero.getDni());
           ps.setString(2, bombero.getNombrecompleto());
           ps.setString(3, bombero.getGrupoSangineo());
           ps.setDate(4, Date.valueOf(bombero.getFechaNac()));
           ps.setString(5, bombero.getCelular());
           ps.setInt(6, bombero.getBrigada().getcodBrigada());//codbrigada
           
           ps.executeUpdate();
           
          ResultSet rs = ps.getGeneratedKeys();
          if(rs.next()){
              bombero.setIdBombero(rs.getInt("idBombero"));
          }else{
              System.out.println("No se pudo obtener ID");
        }
        }catch(SQLException ex){
//            JOptionPane.showMessageDialog(null,ex.getMessage());
    }
 }
    public Bombero buscarBombero(int id){
        Bombero bombero = null;
        String sql = "SELECT id_bombero, dni, nombre_ape, fecha_nac, celular, codBrigada FROM bombero WHERE id_bombero = ?";
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
            bombero = new  Bombero();
            bombero.setIdBombero(id);
            bombero.setNombrecompleto(rs.getString("nombre_ape"));
            bombero.setFechaNac(rs.getDate("fecha_nac").toLocalDate());
            bombero.setCelular(rs.getString("celular"));
        //    bombero.setBrigada(rs.getObject("codBrigada", type)); //brigada
        JOptionPane.showMessageDialog(null, bombero.getNombrecompleto());
            
        }else {
                JOptionPane.showMessageDialog(null, "No existe el bombero");
                }
        ps.close();
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla bombero "+ex.getMessage());
        }
        return bombero;
    }
    public Bombero buscarBomberoPorDni(int dni){
        Bombero bombero = null;
        String sql = "SELECT id_bombero, dni, nombre_ape, fecha_nac, celular, codBrigada FROM bombero WHERE dni = ?";
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
               bombero = new Bombero();
               bombero.setIdBombero(rs.getInt("id_bombero"));
               bombero.setDni(rs.getString("dni"));
               bombero.setNombrecompleto(rs.getString("nombre_ape"));
               bombero.setFechaNac(rs.getDate("fecha_nac").toLocalDate());
               bombero.setCelular(rs.getString("celular"));
        //       bombero.setBrigada(rs.getObject("codBrigada", type));//brigada
               
            }else{
                JOptionPane.showMessageDialog(null, "No existe bombero con ese id");
            }
            
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla bombero "+ex.getMessage());
        }
        return bombero;
    }
    public List<Bombero> listarBomberos(){
        List<Bombero> bomberos = new ArrayList<>();
        try{
            String sql = "SELECT * FROM bombero where 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
               Bombero bombero = new Bombero();
               bombero.setIdBombero(rs.getInt("id_bombero"));
               bombero.setDni(rs.getString("dni"));
               bombero.setNombrecompleto(rs.getString("nombre_ape"));
               bombero.setFechaNac(rs.getDate("fecha_nac").toLocalDate());
               bombero.setCelular(rs.getString("celular"));
        //       bombero.setBrigada(rs.getObject("codBrigada", type));//brigada
                      JOptionPane.showMessageDialog(null, bombero.getNombrecompleto());        
            }
            ps.close();
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla bombero "+ex.getMessage());
        }
        return bomberos;
    }
    public void modificaBombero(Bombero bombero){
        String sql = "UPDATE bombero SET dni = ? , nombre_ape = ?, fecha_nac= ?, grupoSanguineo = ?, celular= ?, codBrigada= ? WHERE id_bombero =?";
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, bombero.getDni());
            ps.setString(2, bombero.getNombrecompleto());
            ps.setDate(3, Date.valueOf(bombero.getFechaNac()));
            ps.setString(4, bombero.getGrupoSangineo());
            ps.setString(5, bombero.getCelular());
            ps.setInt(6, bombero.getBrigada().getcodBrigada());// codBrigada
            ps.setInt(7,bombero.getIdBombero());
            int exito = ps.executeUpdate();
            
            if(exito == 1){
                JOptionPane.showMessageDialog(null, "Modificado exitosamente.");
            }else{
                JOptionPane.showMessageDialog(null,"El bombero no existe");
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla bombero "+ex.getMessage());
        }
    }
    public void eliminarBombero(int id){
        try{
            String sql = "DELETE FROM bombero WHERE id_bombero = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int fila = ps.executeUpdate();
            
            if(fila==1){
                JOptionPane.showMessageDialog(null," Se eliminó el bombero.");
            }
            ps.close();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error al acceder a bombero.");
        }
    }
}
