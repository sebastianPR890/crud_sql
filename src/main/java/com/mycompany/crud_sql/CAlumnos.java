/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crud_sql;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

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
    public void MostrarAlumnos(JTable paramTotalAlumnos){
            
            CConexion objetoConexion = new CConexion();
            DefaultTableModel modelo = new DefaultTableModel();
            TableRowSorter<TableModel> ordenarTabla = new TableRowSorter<TableModel>(modelo);
            paramTotalAlumnos.setRowSorter(ordenarTabla);
            
            String sql="";
            modelo.addColumn("id");
            modelo.addColumn("nombres");
            modelo.addColumn("apellidos");
            sql = "select * from Alumnos";
            String[] datos = new String[3];
            Statement st;
            
            try {
                st = objetoConexion.establecerConexion().createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {                    
                    datos[0] = rs.getString(1);
                    datos[1] = rs.getString(2);
                    datos[2] = rs.getString(3);
                    
                    modelo.addRow(datos);
                }
            paramTotalAlumnos.setModel(modelo);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se pudo mostrar los registros Error: "+e.toString());
            }
    }
    public void modificarAlumnos (JTextField paracodigo, JTextField paraNombres, JTextField paraApellido){
        setCodigo(Integer.parseInt(paracodigo.getText()));
        setNombresAlumnos(paraNombres.getText());
        setApellidosAlumnos(paraApellido.getText());
        
        CConexion objetoConexion = new CConexion();
        
        String consulta = "UPDATE Alumnos SET alumnos.nombres = ?, alumnos.apellidos = ? where alumnos.id =?;";
        
        try {
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            
            cs.setString(1, getNombresAlumnos());
            cs.setString(2, getApellidosAlumnos());
            cs.setInt(3, getCodigo());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Modificacion exitosa");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo modificar el alumno Error: "+e.toString());
        }
    }
    public void eliminarAlumnos(JTextField paraCodigo){
        setCodigo(Integer.parseInt(paraCodigo.getText()));
        CConexion objetoConexion = new CConexion();
        
        String consulta = "delete from Alumnos where alumnos.id =?;";     
        try {
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setInt(1, codigo);
            cs.execute();
            JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar Error: "+e.toString());
        }
    }
    public void seleccionarAlumno(JTable paraTablaAlumnos,JTextField paraid, JTextField paraNombres, JTextField paraApellidos){
                        
        try {
            int fila = paraTablaAlumnos.getSelectedRow();
            
            if (fila>=0){
                                           
                paraid.setText((String)(paraTablaAlumnos.getValueAt(fila, 0)));
                paraNombres.setText((String)(paraTablaAlumnos.getValueAt(fila, 1)));
                paraApellidos.setText((String)(paraTablaAlumnos.getValueAt(fila, 2)));
                
            }
            else {
            
            JOptionPane.showMessageDialog(null, "No se selecciono ninguna columna");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.toString());
            
        }
    }
}
