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
import Vista.Agregar;
import Vista.Buscar;
import Vista.Consultas;
import Vista.Eliminar;
import Vista.Listar;
import javax.swing.*;
import modelo.Modelo;

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
        MenuAgregarEmpleados,//abre vista Agregar
        MenuListarEmpleados, //abre vista Listar
        MenuBuscarEmpleado, //abre vista Buscar
        MenuEliminarEmpleado,//abre vista Eliminar
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
        comboDepto3,
        MenuFunciones,
        menuFile
        
        
        
        
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
        
        
        this.vistaPrincipal.MenuAgregarEmpleados.addActionListener(this);
        this.vistaPrincipal.MenuAgregarEmpleados.setActionCommand("MenuAgregarEmpleados");
        
        this.vistaPrincipal.MenuBuscarEmpleado.setActionCommand("MenuBuscarEmpleado");
        this.vistaPrincipal.MenuBuscarEmpleado.addActionListener(this);
        
        this.vistaPrincipal.MenuEliminarEmpleado.setActionCommand("MenuEliminarEmpleado");
        this.vistaPrincipal.MenuEliminarEmpleado.addActionListener(this);
        
        this.vistaPrincipal.MenuListarEmpleados.setActionCommand("MenuListarEmpleados");
        this.vistaPrincipal.MenuListarEmpleados.addActionListener(this);
        
        this.vistaPrincipal.MenuFunciones.setActionCommand("MenuFunciones");
        this.vistaPrincipal.MenuFunciones.addActionListener(this);
        
        this.vistaPrincipal.menuFile.setActionCommand("menuFile");
        this.vistaPrincipal.menuFile.addActionListener(this);
        
        this.vistaPrincipal.menuSalir.setActionCommand("menuSalir");
        this.vistaPrincipal.menuSalir.addActionListener(this);
        
        this.addEmp.btnAgregar.setActionCommand("btnAgregar");
        this.addEmp.btnAgregar.addActionListener(this);
        
        this.addEmp.btnLimpiar.setActionCommand("btnLimpiar");
        this.addEmp.btnLimpiar.addActionListener(this);
        
        this.addEmp.btnVolver.setActionCommand("btnVolver");
        this.addEmp.btnVolver.addActionListener(this);
        
        this.addEmp.comboDepto.addActionListener(this);
        this.addEmp.comboDepto.setActionCommand("comboDepto");
        
        this.addEmp.radioCasado.setActionCommand("radioCasado");
        this.addEmp.radioCasado.addActionListener(this);
        
        this.addEmp.radioSoltero.setActionCommand("radioSoltero");
        this.addEmp.radioSoltero.addActionListener(this);
        
        this.addEmp.radioViudo.setActionCommand("radioViudo");
        this.addEmp.radioViudo.addActionListener(this);
        
        this.delete.btnEliminar.setActionCommand("btnEliminar");
        this.delete.btnEliminar.addActionListener(this);
        
        this.delete.btnVolver4.setActionCommand("btnVolver4");
        this.delete.btnVolver4.addActionListener(this);
        
        this.list.btnVolver2.setActionCommand("btnVolver2");
        this.list.btnVolver2.addActionListener(this);
       
        this.list.comboDepto3.setActionCommand("comboDepto3");
        this.list.comboDepto3.addActionListener(this);
        
        this.search.btnBuscar.setActionCommand("btnBuscar");
        this.search.btnBuscar.addActionListener(this);
        
        this.search.btnModificar.setActionCommand("btnModificar");
        this.search.btnModificar.addActionListener(this);
        
        this.search.btnVolver3.setActionCommand("btnVolver3");
        this.search.btnVolver3.addActionListener(this);
        
        this.search.comboDepto2.setActionCommand("comboDepto2");
        this.search.comboDepto2.addActionListener(this);
        
        this.search.radioCasado2.setActionCommand("radiocasado2");
        this.search.radioCasado2.addActionListener(this);
        
        this.search.radioSoltero2.setActionCommand("radioSoltero2");
        this.search.radioSoltero2.addActionListener(this);
        
        this.search.radioViudo2.setActionCommand("radioViudo2");
        this.search.radioViudo2.addActionListener(this);
        
        
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
