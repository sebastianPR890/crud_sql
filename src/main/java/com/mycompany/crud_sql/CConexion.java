/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crud_sql;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author sebit
 */
public class CConexion {
    Connection conectar = null;
    String usuario = "root";
    String contrasenia = "12345";
    String db = "dbescuela";
    String ip = "127.0.0.1";
    String puerto = "3306";      
    String cadena = "jdbc:mysql://"+ip+":"+puerto+"/"+db;
    public Connection establecerConexion (){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection(cadena,usuario,contrasenia);
            JOptionPane.showMessageDialog(null, "Se ha conectado con exito");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la base de datos"+e.toString());
            
        }
        return conectar;
    }
}
