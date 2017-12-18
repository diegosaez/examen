/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import vista.Agregar;
import vista.Buscar;
import vista.Consultas;
import vista.Eliminar;
import vista.Listar;
import javax.swing.*;

/**
 *
 * @author diego
 */
public class Controlador implements ActionListener, MouseListener{
    
    
    private Consultas vistaPrincipal;
    private Agregar addEmp = new Agregar();
    private Buscar search = new Buscar();
    private Eliminar delete = new Eliminar();
    private Listar list = new Listar();
    
    private Modelo modelo = new Modelo();
    
    public enum Accion{
        
        menuSalir, //cierra el programa
        menuAgregarEmpleados,//abre vista Agregar
        menuListarEmpleados, //abre vista Listar
        menuBuscarEmpleado, //abre vista Buscar
        menuEliminarEmpleado,//abre vista Eliminar
        btnAgregar, //agrega empleado
        btnLimpiar,//limpia pantalla agregar
        btnVolver, //regresa a vista consultas
        radioSoltero,
        radioCasado,
        RadioViudo,
        comboDepto,
        btnBuscar,
        radioSoltero2,
        radioCasado2,
        radioViudo2,
        comboDepto2,
        btnModificar,
        btnVolver2,
        btnVolver3,
        btnVolver4,
        btnEliminar,
        comboDepto3
        
        
        
        
    }
    
    
    public Controlador (JFrame padre){
        
        this.vistaPrincipal = (Consultas) padre;
    }
    
    public void iniciar(){
        
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(vistaPrincipal);
            SwingUtilities.updateComponentTreeUI( this.addEmp );
            SwingUtilities.updateComponentTreeUI( this.delete);
            SwingUtilities.updateComponentTreeUI( this.list);
            SwingUtilities.updateComponentTreeUI( this.search);
            //SwingUtilities.updateComponentTreeUI( this.modProd );
            this.vistaPrincipal.setLocationRelativeTo(null);
            this.vistaPrincipal.setTitle("Examen");
            this.vistaPrincipal.setVisible(true);
        } catch (UnsupportedLookAndFeelException ex) {}
          catch (ClassNotFoundException ex) {}
          catch (InstantiationException ex) {}
          catch (IllegalAccessException ex) {}
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
