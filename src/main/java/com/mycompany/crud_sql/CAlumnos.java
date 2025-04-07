/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crud_sql;

import java.sql.CallableStatement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author sebit
 */
public class CAlumnos {

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombresAlumnos() {
        return nombresAlumnos;
    }

    public void setNombresAlumnos(String nombresAlumnos) {
        this.nombresAlumnos = nombresAlumnos;
    }

    public String getApellidosAlumnos() {
        return apellidosAlumnos;
    }

    public void setApellidosAlumnos(String apellidosAlumnos) {
        this.apellidosAlumnos = apellidosAlumnos;
    }
    int codigo;
    String nombresAlumnos;
    String apellidosAlumnos;
    public void InsertarAlumno(JTextField paraNombres, JTextField paraApellidos){
        setNombresAlumnos(paraNombres.getText());        
        setApellidosAlumnos(paraApellidos.getText());
        
        CConexion objetoConexion = new CConexion();
        
        String consulta = "insert into alumnos (nombres, apellidos) values (?,?);";
        try {
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            
            cs.setString(1,getNombresAlumnos());
            cs.setString(2, getApellidosAlumnos());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se inserto correctamente el alumno");
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "No se inserto correctamente el alumno. Error: "+e.toString());
        }
    };
}
