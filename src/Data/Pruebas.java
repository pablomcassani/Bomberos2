/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Entidades.Bombero;
import Entidades.Brigada;
import Entidades.Cuartel;
import Entidades.Siniestro;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author gassani
 */
public class Pruebas {
      public static void main(String[] args) throws SQLException {
          
//       ********   CRUD DE BOMBEROS ************
 BomberoData bombData = new BomberoData();
          
          //guardarBombero();
          /*Toma un objeto "Bombero" y lo guarda en la tabla "bombero" de la base de datos.
          Es necesario iniciar "BrigadaData" primero e iniciar un objeto "Brigada" 
          para usar el método "buscarBrigada()" para poder darle al objeto "Bombero" el codCuartel que requiere.
          "buscarBrigada()" usa como parámetro el número de brigada con el que se quiere agregar el objeto "Bombero".
          */
//          BrigadaData brig = new BrigadaData();        
//          Brigada bri = brig.buscarBrigada(1);        
//          Bombero belen = new Bombero("39.787.027","Belen Lopez","O-",LocalDate.of(1998, Month.MAY, 28),"1150396514",bri);
//          bombData.guardarBomero(belen);

        //buscarBombero();
//        bombData.buscarBombero(10);
/*Toma un integer "id_Bombero" y devuelve el objeto "Bombero" que corresponde.*/

//        listarBomberos();
/* Recorre un ArrayList con todos los bomberos en la base de datos.*/
//    bombData.listarBomberos();

//        modificarBombero();
/*Usa el constructor de "Bombero" que requiere "id_bombero" y modifica al objeto con ese id con los datos que le pases.*/ 
//        Bombero mauricio = new Bombero(12,"39.550.789","Mauricio Galarza","A-",LocalDate.of(1991, Month.OCTOBER, 8),"1171626610",bri);
//        bombData.modificaBombero(mauricio);

//        eliminarBombero();
/*        Toma el "id_bombero" y elimina de la base de datos la tabla a la que corresponda*/ 
//        bombData.eliminarBombero(8);


//       ********   CRUD DE BRIGADA ************
        BrigadaData brigData = new BrigadaData();

//      guardarBrigada();
       /*Toma un objeto "Brigada" y lo guarda en la tabla "brigada" de la base de datos.
          Es necesario iniciar "CuartelData" primero e iniciar un objeto "Cuartel" 
          para usar el método "buscarCuartel()" para poder darle al objeto "Brigada" el codCuartel que requiere.
          "buscarCuatel()" usa como parámetro el número de cuartel con el que se quiere agregar el objeto "Brigada".
          */
//        CuartelData cuart = new CuartelData();
//        Cuartel cuartel = cuart.buscarCuartel(2);
//        Brigada soporte = new Brigada("Brigada naranja","soporte de vida",true,cuartel);
//        brigData.guardarBrigada(soporte);



//         buscarBrigada();
        /*Toma un integer "codBrigada" y devuelve el objeto "Brigada" que corresponde.*/
//        brigData.buscarBrigada(2);
            
//          listarBrigada();
/* Recorre un ArrayList con todos las brigadas en la base de datos.*/
//        brigData.listarBrigada();

//            modificarBrigada();
            /*Usa el constructor de "Brigada" que requiere "codBrigada" y modifica al objeto con ese id con los datos distintos que le pases.
              Tambien requiere un "codCuartel" así que hay que crear un objeto "Cuartel" que lo contenga.*/
            //CuartelData cuart = new CuartelData();
//            Cuartel cuartel = cuart.buscarCuartel(2);
            // Brigada soporte = new Brigada(5, "Brigada naranja","soporte de vida",false,cuartel);
//          brigData.modificarBrigada(soporte);

//              eliminarBrigada();
/*             Toma el "codBrigada" y elimina de la base de datos la tabla a la que corresponda*/ 
//            brigData.eliminarBrigada(5);
        
//        ********   CRUD DE BOMBEROS ************
        CuartelData cuarData = new CuartelData();
        
//        guardarCuartel();
//      CuartelData cuaDat = new CuartelData();
//      Cuartel cuartelverde = new Cuartel("Cuartel Rosa","Las Heras 1029",8,50,"47898721","cuartelazul@hotmi.com");
//      cuarData.guardarCuartel(cuartelverde);

//        buscarCuartel();
//        cuarData.buscarCuartel(3);

//        listarCuartel();
//        cuarData.listarCuartel();

//        modificarCuartel();
//        Cuartel cuartelverde = new Cuartel(2,"Cuartel Rosa","Viamonte 333",55,22,"4544548","cuartelverde96@hotmi.com");
//        cuarData.modificarCuartel(cuartelverde);

//          eliminarCuartel(0);
//         cuarData.eliminarCuartel(4);

//        ********   CRUD DE SINIESTRO ************
        SiniestroData sinData = new SiniestroData();
        
//        guardarSiniestro();
    //      BrigadaData brig = new BrigadaData();        
    //      Brigada bri = brig.buscarBrigada(1);    
    //    Siniestro terremoto = new Siniestro("desastre natural", LocalDate.of(2023, Month.SEPTEMBER, 29), 9,119,"Terremoto de pequeño nivel causa derrumbe de hogares en barrio en las afueras de BS AS",LocalDate.of(2023, Month.OCTOBER, 9),5, bri );
    //    sinData.guardarSiniestro(terremoto);
                
                BrigadaData brigDat = new BrigadaData();
                Brigada bri = brigDat.buscarBrigada(1);
                Siniestro accidente = new Siniestro("accidente de trafico", LocalDate.of(2023, Month.OCTOBER, 10),90,112,"Accidente de trancito en Alsina y San Martin", LocalDate.of(2023, Month.OCTOBER, 11),5, null);
                sinData.guardarSiniestro(accidente);
            
    //          sinData.buscarSiniestro(1);
      
        //        Date fechaSiniestro = new Date(2023,10,9);
        //        sinData.BuscarSiniestroPorFechaDeSiniestro(fechaSiniestro);
        
       //            sinData.listarSiniestros();
       
     
                     sinData.listarSiniestrosLibres();
      }
}
