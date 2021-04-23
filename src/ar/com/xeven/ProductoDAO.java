package ar.com.xeven;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    public static List<Producto> getProductos(){
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM productos";
        ConexionDB conexionDB = new ConexionDB();
        try{
            ResultSet rs = conexionDB.consultar(sql);
            if(rs!=null)
                while (rs.next()){
                    productos.add(new Producto(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("precioUnitario")
                    ));
                }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            conexionDB.cerrar();
        }
        return productos;
    }

    public static void guardar(Producto producto) {
        String sql = "INSERT INTO productos (`nombre`, `precioUnitario`) VALUES (?,?)";
        ConexionDB conexionDB = new ConexionDB(sql);
        PreparedStatement pstmt = conexionDB.getPstmt();
        try{
            pstmt.setString(1, producto.getNombre());
            pstmt.setInt(2, producto.getPrecioUnitario());
            pstmt.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            conexionDB.cerrar();
        }
    }
}
