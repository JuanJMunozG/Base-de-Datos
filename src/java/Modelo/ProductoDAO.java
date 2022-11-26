/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

/*
 *
 * @author Juan
 */
public class ProductoDAO {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public Producto listarId(int id){
        String sql = "SELECT * FROM productos WHERE id="+id;
        Producto p = new Producto();
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(3));
                //p.setFoto(rs.getBinaryStream(3)); //para agregar foto
                p.setDescripcion(rs.getString(5));
                p.setPrecio(rs.getDouble(4)); 
                
            }
        }catch (Exception e){}
        return p; 
    }
    
    
    
    
    
    public List listar(){
        List<Producto> productos = new ArrayList();
        String sql = "SELECT * FROM productos";
        try{
            con = cn.getConnection();
            ps=con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Producto p = new Producto();
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(3));
                //p.setFoto(rs.getBinaryStream(3)); //para agregar foto
                p.setDescripcion(rs.getString(5));
                p.setPrecio(rs.getDouble(4)); 
                productos.add(p);
                
            }
        }catch (Exception e) {
        }
        return productos;
    }
    
    
    
    
    
    
    
    
}
