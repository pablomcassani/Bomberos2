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
import java.time.LocalDate;
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
              siniestro.setIdSiniestro(rs.getInt("codigo"));
          }else{
              System.out.println("No se pudo obtener ID");
        }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
    }
 }
}
