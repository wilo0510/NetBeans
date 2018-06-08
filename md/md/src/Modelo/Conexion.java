/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tatiana
 */
public class Conexion {
    /* DATOS PARA LA CONEXION */
  /** Nombre de la base de datos */
  private String db = "postgres";
  /** Usuario postgreSQL */
  private String user = "postgres";
  /** Contraseña postgreSQL */
  private String password = "tatiana1033";
  /** Cadena de conexión */
  private String url = "jdbc:postgresql://localhost:5432/"+db;
  /** Conexion a base de datos */
  private Connection conn = null;
  /** Para obtener los resultados de las consultas SQL de la base de datos */
  private ResultSet resultSet = null;
  /** Para enviar comandos SQL a la base de datos */
  private Statement statement = null;
  
  public Conexion(){
      this.url = "jdbc:postgresql://localhost:5432/"+db;
       try{
         //obtenemos el driver de para mysql
         Class.forName("org.postgresql.Driver");
         //obtenemos la conexión
         conn = DriverManager.getConnection(this.url, this.user , this.password );
           System.out.println("Conexion realizada on exito");
      }catch(SQLException e){
         System.err.println( e.getMessage() );
      }catch(ClassNotFoundException e){
         System.err.println( e.getMessage() );
      }
  }
  /**
 * Ejecuta la instruccion SQL para llamar a la función en postgreSQL
 */
public void ejecutarConsulta( String consulta )
{
    
    try {
      statement = conn.createStatement();
      resultSet = statement.executeQuery(consulta);
      while (resultSet.next())
      {
        System.out.println(resultSet.getString("cod") + " " + resultSet.getString("país") + " " +
        resultSet.getString("continente") + " " + resultSet.getString("grupo"));
      }
     }
   catch (SQLException ex) {
        System.err.println( ex.getMessage() );
   }
   
}
    
}
