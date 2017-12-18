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

    String[] empleado;
    String departamento = null;

    String est_civil;
    String depto;

    
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
        
        switch ( Accion.valueOf( e.getActionCommand() ) )
        {
            case MenuAgregarEmpleados:
                this.addEmp.setLocationRelativeTo(null);
                this.addEmp.setTitle("Agregar Empleados");
                this.addEmp.setVisible(true);
                this.vistaPrincipal.setVisible(false);
                
                break;
                
            case MenuListarEmpleados:
                this.list.setLocationRelativeTo(null);
                this.list.setTitle("Listar Empleados");
                this.list.setVisible(true);
                this.vistaPrincipal.setVisible(false);
                this.list.tablaEmpleados.setModel(this.modelo.ListadoEmpleados(departamento));
                break;
                
            case MenuBuscarEmpleado:
                this.search.setLocationRelativeTo(null);
                this.search.setTitle("Buscar Empleado");
                this.search.setVisible(true);
                this.vistaPrincipal.setVisible(false);
                break;
                
            case MenuEliminarEmpleado:
                this.delete.setLocationRelativeTo(null);
                this.delete.setTitle("Eliminar Empleado");
                this.delete.setVisible(true);
                this.vistaPrincipal.setVisible(false);
                break;
                
            case menuSalir:
                System.exit(0);
                
            case btnAgregar:
                if(this.addEmp.radioCasado.isSelected()){
                    est_civil = "c";
                }
                if(this.addEmp.radioSoltero.isSelected()){
                    est_civil = "s";
                           
                }
                if(this.addEmp.radioViudo.isSelected()){
                    est_civil = "v";
                }
                depto = String.valueOf(this.addEmp.comboDepto.getSelectedItem());
                if(this.modelo.ingresoEmpleado(Integer.parseInt(this.addEmp.txtCodigo.getText()), this.addEmp.txtRut.getText(), this.addEmp.txtNombre.getText(),this.addEmp.txtApellido.getText(), Integer.parseInt(this.addEmp.txtCelular.getText()), this.addEmp.txtEmail.getText(), Integer.parseInt(this.addEmp.txtSueldo.getText()), est_civil, depto)){
                    
                    JOptionPane.showMessageDialog(null,"Empleado agregado correctamente");
                }else{
                    JOptionPane.showMessageDialog(null,"No se pudo agregar empleado");
                }
                break;    
                
            case btnLimpiar:
                this.addEmp.txtCodigo.setText("");
                this.addEmp.txtNombre.setText("");
                this.addEmp.txtApellido.setText("");
                this.addEmp.txtCelular.setText("");
                this.addEmp.txtRut.setText("");
                this.addEmp.txtEmail.setText("");
                this.addEmp.txtSueldo.setText("");
                this.addEmp.radioCasado.setSelected(false);
                this.addEmp.radioSoltero.setSelected(false);
                this.addEmp.radioViudo.setSelected(false);
                this.addEmp.comboDepto.setSelectedIndex(0);
                this.addEmp.txtCodigo.requestFocusInWindow();
                break;

            
                
            case btnEliminar:
                this.modelo.eliminaEmpleado(Integer.parseInt(this.delete.jTextField1.getText()));
                break;
            case btnBuscar:
                empleado= this.modelo.buscarEmpleado(Integer.parseInt(this.search.jTextField1.getText()));
                this.search.txtCodigo2.setText(empleado[0]);
                this.search.txtRut2.setText(empleado[1]);
                this.search.txtNombre2.setText(empleado[2]);
                this.search.txtApellido2.setText(empleado[3]);
                this.search.txtCelular2.setText(empleado[4]);
                this.search.txtEmail2.setText(empleado[5]);
                this.search.txtSueldo2.setText(empleado[6]);
                if(empleado[7]=="c"){
                    this.search.radioCasado2.setSelected(true);
                }
                if(empleado[7]=="s"){
                    this.search.radioSoltero2.setSelected(true);
                }
                if(empleado[7]=="v"){
                    this.search.radioViudo2.setSelected(true);
                }
                if(empleado[8]=="Informática"){
                    this.search.comboDepto2.setSelectedIndex(1);
                }
                if(empleado[8]=="Redes"){
                    this.search.comboDepto2.setSelectedIndex(2);
                }
                if(empleado[8]=="Administración"){
                    this.search.comboDepto2.setSelectedIndex(3);
                }
                if(empleado[8]=="Finanzas"){
                    this.search.comboDepto2.setSelectedIndex(4);
                }
                if(empleado[8]=="Bienestar"){
                    this.search.comboDepto2.setSelectedIndex(5);
                }
                break;

                
            case btnVolver:
                this.addEmp.setVisible(false);
                this.vistaPrincipal.setVisible(true);
                break;
                
            case btnVolver3:
                this.search.setVisible(false);
                this.vistaPrincipal.setVisible(true);
                break;
                
            case btnVolver4:
                this.delete.setVisible(false);
                this.vistaPrincipal.setVisible(true);
                break;
            
            case btnVolver2:
                this.list.setVisible(false);
                this.vistaPrincipal.setVisible(true);
                break;
                
            case btnModificar:
                if(this.search.radioCasado2.isSelected()){
                    est_civil = "c";
                }
                if(this.search.radioSoltero2.isSelected()){
                    est_civil = "s";
                           
                }
                if(this.search.radioViudo2.isSelected()){
                    est_civil = "v";
                }
                depto = String.valueOf(this.addEmp.comboDepto.getSelectedItem());
               if(this.modelo.modificaEmpleado(Integer.parseInt(this.search.txtCodigo2.getText()), this.search.txtRut2.getText(), this.search.txtNombre2.getText(),this.search.txtApellido2.getText(), Integer.parseInt(this.search.txtCelular2.getText()), this.search.txtEmail2.getText(), Integer.parseInt(this.search.txtSueldo2.getText()), est_civil, depto)){
                
                JOptionPane.showMessageDialog(null,"Empleado modificado correctamente");
                
            }else{
                   JOptionPane.showMessageDialog(null,"No se pudo modificar empleado");
               }

        }
    
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
