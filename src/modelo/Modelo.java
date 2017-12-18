package modelo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import sql.conexion;


public class Modelo extends conexion {
     
    
    public DefaultTableModel ListadoEmpleados(String departamento){
    DefaultTableModel tablemodel = new DefaultTableModel();
      int registros = 0;
      String[] columNames = {"Codigo","Rut","Nombre","Apellido","Celular","Email","Sueldo Bruto","Estado Civil","Departamento"};
      try{
         PreparedStatement pstm = this.getConexion().prepareStatement( "SELECT count(*) as total FROM empleados");
         ResultSet res = pstm.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
      }catch(SQLException e){
         System.err.println( e.getMessage() );
      }
      Object[][] data = new String[registros][9];
      
      try{
          PreparedStatement pstm = this.getConexion().prepareStatement("SELECT codigo,rut,nombre,apellido,celular,email,sueldo_bruto,nom_depto FROM empleados;");
        if(!departamento.equals(null)){
        pstm = this.getConexion().prepareStatement("SELECT codigo,rut,nombre,apellido,celular,email,sueldo_bruto,nom_depto FROM empleados where nom_dept="+departamento+";");
        }
         ResultSet res = pstm.executeQuery();
         int i=0;
         while(res.next()){
                data[i][0] = res.getString( "codigo" );
                data[i][1] = res.getString( "rut" );
                data[i][2] = res.getString( "nombre" );
                data[i][3] = res.getString( "apellido" );
                data[i][4] = res.getString( "celular" );
                data[i][5] = res.getString( "email" );
                data[i][6] = res.getString( "sueldo_bruto" );
                data[i][7] = res.getString( "nom_depto" );
            i++;
         }
         res.close();
         tablemodel.setDataVector(data, columNames );
         }catch(SQLException e){
            System.err.println( e.getMessage() );
        }
        return tablemodel;
}
    
    public String[] buscarEmpleado(int codigo){
        String[] datos=new String[8];
        String query = "SELECT codigo,rut,nombre,apellido,celular,email,sueldo_bruto,est_civil, where codigo='"+codigo+"';";
        try{
        PreparedStatement pstm = this.getConexion().prepareStatement(query);
        ResultSet res = pstm.executeQuery();
        datos[0]=res.getString("codigo");
        datos[1]=res.getString("rut");
        datos[2]=res.getString("nombre");
        datos[3]=res.getString("apellido");
        datos[4]=res.getString("celular");
        datos[5]=res.getString("email");
        datos[6]=res.getString("sueldo_bruto");
        datos[7]=res.getString("est_civil");
        datos[8]=res.getString("nom_depto");
        res.close();        
        }
        catch(SQLException e){
        System.err.println( e.getMessage() );
        JOptionPane.showMessageDialog(null,"No se ha encontrado al empleado "+codigo+" ");
        }
        return datos;
    }
    
    public boolean ingresoEmpleado(int codigo, String rut, String nombre, String apellido, int celular, String email, int sueldo, String eCivil, String depto){
        if(valida_datos(codigo,rut,nombre,apellido,celular,email,sueldo,eCivil,depto)){
            String query = "INSERT INTO usuario01.empleados(codigo,rut,nombre,apellido,celular,email,sueldo_bruto,nom_depto) values ('"+codigo+"','"+rut+"','"+nombre+"','"+apellido+"','"+celular+"','"+email+"','"+sueldo+"','"+eCivil+"','"+depto+"');";
            try {
                PreparedStatement pstm = this.getConexion().prepareStatement(query);               
                pstm.execute();               
                pstm.close();
                return true;
            }catch(SQLException e){
                System.err.println( e.getMessage() );
            }
            return false;
        }
        else{
            return false;
        }
    }
    
    public boolean modificaEmpleado(int codigo, String rut, String nombre, String apellido, int celular, String email, int sueldo, String eCivil, String depto){
        if(valida_datos(codigo,rut,nombre,apellido,celular,email,sueldo,eCivil,depto)){
            String query = "UPDATE usuario01.empleados SET rut='"+rut+"',nombre='"+nombre+"',apellido='"+apellido+"',celular='"+celular+"',email='"+email+"',sueldo='"+sueldo+"',est_civil='"+eCivil+"',nom_depto='"+depto+"' where codigo='"+codigo+"';";
            try {
                PreparedStatement pstm = this.getConexion().prepareStatement(query);               
                pstm.execute();               
                pstm.close();
                return true;
            }catch(SQLException e){
                System.err.println( e.getMessage() );
            }
            return false;
        }
        else{
            return false;
        }
}
    
    public boolean eliminaEmpleado(int codigo){
        String query = "DELETE usuario01.empleado where codigo='"+codigo+"';";
        try {
                PreparedStatement pstm = this.getConexion().prepareStatement(query);               
                pstm.execute();               
                pstm.close();
                JOptionPane.showMessageDialog(null,"Empleado "+codigo+" ha sido eliminado de la base de datos");
                return true;
            }catch(SQLException e){
                System.err.println( e.getMessage() );
            }
            JOptionPane.showMessageDialog(null,"Empleado "+codigo+" no ha sido encontrado, no se puede eliminar");
            return false;
    }
    
    
    private boolean valida_datos(int codigo, String rut, String nombre, String apellido, int celular, String email, int sueldo, String eCivil, String depto){//enviar parametros a validar
        if(codigo<0 || codigo>100 ){
            JOptionPane.showMessageDialog(null,"Codigo invalido, favor ingresar codigo entre 0 y 100");
            return false;
        }
        if(rut.length()<9){
            JOptionPane.showMessageDialog(null,"Rut invalido, ingrese nuevamente");
            return false;
        }
        if(celular>999999999 || celular<10000000 ){
            JOptionPane.showMessageDialog(null,"el numero de celular debe contener 9 digitos");
            return false;}
        if(sueldo<120000){
            JOptionPane.showMessageDialog(null,"El sueldo minimo es de $120.000");
            return false;
        }
        
        else{
            return true;
        }
    }
    
    }