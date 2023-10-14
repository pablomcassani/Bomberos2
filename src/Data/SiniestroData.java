/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Entidades.Bombero;
import Entidades.Brigada;
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
        String sql = "INSERT INTO siniestro ( tipo, fecha_siniestro, coord_X, coord_Y, detalles, fecha_resol,puntuacion,codBrigada) VALUES (?,?,?,?,?,?,?,0)";
        try{
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, siniestro.getTipo());
            ps.setDate(2, Date.valueOf(siniestro.getFechaSiniestro()));
            ps.setInt(3, siniestro.getCoordX());
            ps.setInt(4, siniestro.getCoordY());
            ps.setString(5, siniestro.getDetalles());
            if(siniestro.getFechaResol() != null){    
                ps.setDate(6, Date.valueOf(siniestro.getFechaResol()));
            } else {
                ps.setDate(6, null);
            }    
            ps.setInt(7, siniestro.getPuntuacion());
            
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
            Brigada bri = briData.buscarBrigada(rs.getInt("codBrigada"));
            
            siniestro.setTipo(rs.getString("tipo"));
            siniestro.setFechaSiniestro(rs.getDate("fecha_siniestro").toLocalDate());
            siniestro.setCoordX(rs.getInt("coord_X"));
            siniestro.setCoordY(rs.getInt("coord_Y"));
            siniestro.setDetalles(rs.getString("detalles"));
            siniestro.setFechaResol(rs.getDate("fecha_resol").toLocalDate());
            siniestro.setPuntuacion(id);
            siniestro.setBrigada(bri);
      
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
    public Siniestro BuscarSiniestroPorFechaDeSiniestro(Date fechaSiniestro){
        Siniestro siniestro = null;
        String sql = "SELECT idSiniestro, tipo, fecha_siniestro, coord_X, coord_Y, detalles, fecha_resol, puntuacion, codBrigada FROM `siniestro` WHERE fecha_siniestro = ?";
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement(sql);
            ps.setDate(1, fechaSiniestro);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                
            siniestro = new Siniestro();
            Brigada bri = briData.buscarBrigada(rs.getInt("codBrigada"));
            
            siniestro.setIdSiniestro(rs.getInt("idSiniestro"));
            siniestro.setTipo(rs.getString("tipo"));
            siniestro.setFechaSiniestro(rs.getDate("fecha_siniestro").toLocalDate());
            siniestro.setCoordX(rs.getInt("coord_X"));
            siniestro.setCoordY(rs.getInt("coord_Y"));
            siniestro.setDetalles(rs.getString("detalles"));
            siniestro.setFechaResol(rs.getDate("fecha_resol").toLocalDate());
            siniestro.setPuntuacion(rs.getInt("puntuacion"));
            siniestro.setBrigada(bri);
                
                JOptionPane.showMessageDialog(null, "El incidente es: " + siniestro);
            }else{
                JOptionPane.showMessageDialog(null, "No existe siniestro con ese id");
            }
            
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla siniestro "+ex.getMessage());
        }
        return siniestro;
    }
    public List<Siniestro> listarSiniestros(){
        List<Siniestro> siniestros = new ArrayList<>();
        try{
            String sql = "SELECT * FROM siniestro where 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Siniestro siniestro = new Siniestro();
                Brigada bri = briData.buscarBrigada(rs.getInt("codBrigada"));
                
                siniestro.setIdSiniestro(rs.getInt("idSiniestro"));
                siniestro.setTipo(rs.getString("tipo"));
                siniestro.setFechaSiniestro(rs.getDate("fecha_siniestro").toLocalDate());
                siniestro.setCoordX(rs.getInt("coord_X"));
                siniestro.setCoordY(rs.getInt("coord_Y"));
                siniestro.setDetalles(rs.getString("detalles"));
                siniestro.setFechaResol(rs.getDate("fecha_resol").toLocalDate());
                siniestro.setPuntuacion(rs.getInt("puntuacion"));
                siniestro.setBrigada(bri); //?
             
                      JOptionPane.showMessageDialog(null, siniestro.getTipo());        
            }
            ps.close();
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla siniestro "+ex.getMessage());
        }
        return siniestros;
    }
    
    public List<Siniestro> listarSiniestrosLibres(){
        List<Siniestro> siniestros = new ArrayList<>();
        try{
            String sql = "SELECT * FROM siniestro where codBrigada =  0";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Siniestro siniestro = new Siniestro();
                siniestro.setIdSiniestro(rs.getInt("idSiniestro"));
                siniestro.setTipo(rs.getString("tipo"));
                siniestro.setFechaSiniestro(rs.getDate("fecha_siniestro").toLocalDate());
                siniestro.setCoordX(rs.getInt("coord_X"));
                siniestro.setCoordY(rs.getInt("coord_Y"));
                siniestro.setDetalles(rs.getString("detalles"));
                siniestro.setFechaResol(rs.getDate("fecha_resol").toLocalDate());
                siniestro.setPuntuacion(rs.getInt("puntuacion"));
             
                      JOptionPane.showMessageDialog(null, siniestro.getTipo());        
            }
            ps.close();
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla siniestro "+ex.getMessage());
        }
        return siniestros;
    }
    
    public void modificarSiniestro(Siniestro siniestro){
        String sql = "UPDATE siniestro SET idSiniestro = ?, tipo = ?, fecha_siniestro = ?, coord_X = ?, coord_Y = ?, detalles = ?, fecha_resol = ?, puntuacion = ? , codBrigada = ? WHERE idsiniestro ";
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, siniestro.getTipo());
            ps.setDate(2, Date.valueOf(siniestro.getFechaSiniestro()));
            ps.setInt(3, siniestro.getCoordX());
            ps.setInt(4, siniestro.getCoordY());
            ps.setString(5, siniestro.getDetalles());
            if(siniestro.getFechaResol() != null ){    
                ps.setDate(6, Date.valueOf(siniestro.getFechaResol()));
            }else {
                ps.setDate(6, null);
            }
            ps.setInt(7, siniestro.getPuntuacion());
    //        if(siniestro.getBrigada().getcodBrigada() > 0){
                ps.setInt(8, siniestro.getBrigada().getcodBrigada());   
   //         } else {
   //             ps.setInt(8, 0);
   //         }
            int exito = ps.executeUpdate();
            
            if(exito == 1){
                JOptionPane.showMessageDialog(null, "Modificado exitosamente.");
            }else{
                JOptionPane.showMessageDialog(null,"El siniestro no existe");
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla siniestro "+ex.getMessage());
        }
    }
    public void eliminarSiniestro(int id){
        try{
            String sql = "DELETE FROM siniestro WHERE idSiniestro = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int fila = ps.executeUpdate();
            
            if(fila==1){
                JOptionPane.showMessageDialog(null," Se eliminó el siniestro.");
            }
            ps.close();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error al acceder a siniestro.");
        }
    }
}
