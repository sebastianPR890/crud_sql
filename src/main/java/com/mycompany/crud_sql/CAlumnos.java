/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crud_sql;

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
}
