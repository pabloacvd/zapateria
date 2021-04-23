package ar.com.xeven;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FacturaDAO {

    public static Factura getFactura(int id){
        Factura factura = new Factura();
        String sql = "SELECT * FROM facturas WHERE id = ?";
        ConexionDB conexionDB = new ConexionDB(sql);
        PreparedStatement preparedStatement = conexionDB.getPstmt();
        try{
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs!=null){
                factura.setNombreCliente(rs.getString("nombreCliente"));
                factura.setPrecioTotal(rs.getInt("precioTotal"));
                factura.setCantidadItems(rs.getInt("cantidadItems"));
                factura.setId(rs.getInt("id"));
                factura.setItems(getItems(factura.getId()));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return factura;
    }

    private static List<Item> getItems(int idFactura) {
        return null;
    }
}
