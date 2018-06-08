/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Conexion;

/**
 *
 * @author Tatiana
 */
public class controlador {
    Conexion conexion;
    public controlador(){
        conexion =new Conexion();
    }
    public void consulta(String consulta){
        conexion.ejecutarConsulta(consulta);
    }
}
