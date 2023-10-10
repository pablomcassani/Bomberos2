/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Entidades.Bombero;
import Entidades.Siniestro;
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
public class SiniestroData {
        private Connection con = null;
    private BrigadaData briData = new BrigadaData();
    
     public SiniestroData(){
           con = miConexion.getConexion();
    }
         public void guardarSiniestro(Siniestro siniestro){
        String sql = "INSERT INTO siniestro ( tipo, fecha_siniestro, coord_X, coord_Y, detalles, fecha_resol,puntuacion,codBrigada) VALUES (?,?,?,?,?,?,?,?)";
        try{
           PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
           ps.setString(1, siniestro.getTipo());
           ps.setDate(2, Date.valueOf(siniestro.getFechaSiniestro()));
           ps.setInt(3, siniestro.getCoordX());
           ps.setInt(4, siniestro.getCoordY());
           ps.setString(5, siniestro.getDetalles());
           ps.setDate(6, Date.valueOf(siniestro.getFechaResol()));
           ps.setInt(7, siniestro.getPuntuacion());
           ps.setInt(8, siniestro.getBrigada().getcodBrigada());
          
           ps.executeUpdate();
           
          ResultSet rs = ps.getGeneratedKeys();
          if(rs.next()){
              siniestro.setIdSiniestro(rs.getInt("idSiniestro"));
          }else{
              System.out.println("No se pudo obtener ID");
        }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
    }
 }
         
         public Siniestro buscarSiniestro(int id){
        Siniestro siniestro = null; 
        String sql = "SELECT idSiniestro, tipo, fecha_siniestro, coord_X, coord_Y, detalles, fecha_resol, puntuacion, codBrigada FROM siniestro WHERE idSiniestro = ?";
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
            siniestro = new Siniestro();
            siniestro.setIdSiniestro(id);
            siniestro.setTipo(rs.getString("tipo"));
            siniestro.setFechaSiniestro(rs.getDate("fecha_siniestro").toLocalDate());
            siniestro.setCoordX(rs.getInt("coord_X"));
            siniestro.setCoordY(rs.getInt("coord_Y"));
            siniestro.setDetalles(rs.getString("detallaes"));
            siniestro.setFechaResol(rs.getDate("fecha_resol").toLocalDate());
            siniestro.setPuntuacion(id);
            siniestro.setBrigada(rs.getObject("codBrigada", type));
      
        JOptionPane.showMessageDialog(null, siniestro.getTipo());
            
        }else {
                JOptionPane.showMessageDialog(null, "No exixte el siniestro");
                }
        ps.close();
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla siniestro "+ex.getMessage());
        }
        return siniestro;
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
        List<Bombero> alumnos = new ArrayList<>();
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
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno "+ex.getMessage());
        }
        return alumnos;
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
