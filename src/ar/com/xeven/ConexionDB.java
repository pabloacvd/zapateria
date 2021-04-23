package ar.com.xeven;

import java.sql.*;

public class ConexionDB {
    private Connection conexion = null;
    private Statement st = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    private String dbURL = "jdbc:mysql://localhost/zapateria";
    private String dbUSER = "root";
    private String dbPWD = "unafacil";

    public ConexionDB() {
        iniciarConexion();
    }
    public ConexionDB(String sql) {
        iniciarConexionConPSTMT(sql, true);
    }

    public int ejecutarRetornarKey() throws SQLException {
        int idGenerado = 0;
        if (pstmt.executeUpdate() > 0) {
            ResultSet keysGeneradas = pstmt.getGeneratedKeys();
            if (keysGeneradas.next())
                idGenerado = keysGeneradas.getInt(1);
        }
        return idGenerado;
    }
    public void ejecutar() throws SQLException {
        if(pstmt!=null && !pstmt.isClosed())
            pstmt.executeUpdate();
    }

    private void iniciarConexionConPSTMT(String sql, boolean retornarKeys){
        try {
            conexion = DriverManager.getConnection(dbURL,dbUSER,dbPWD);
            if(retornarKeys)
                pstmt = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            else
                pstmt = conexion.prepareStatement(sql);
        } catch (SQLException e) {
            System.out.println("No se ha podido conectar con la base de datos.");
        }
    }

    private void iniciarConexion() {
        try {
            conexion = DriverManager.getConnection(dbURL,dbUSER,dbPWD);
            st = conexion.createStatement();
        } catch (SQLException e) {
            System.out.println("No se ha podido conectar con la base de datos.");
        }
    }

    public ResultSet consultar(String sql){
        try {
            if(st!=null && !st.isClosed())
                rs = st.executeQuery(sql);
        } catch (SQLException | NullPointerException e) {
            System.out.println("No se ha podido realizar su búsqueda.");
        }
        return rs;
    }

    public void cerrar() {
        try {
            if(pstmt!=null && !pstmt.isClosed())
                pstmt.close();
            if(st != null && !st.isClosed())
                st.close();
            if(conexion != null && !conexion.isClosed())
                conexion.close();
        } catch (SQLException throwables) {
            System.out.println("Conexión con base de datos cerrada.");
        }
    }

    public int actualizar(String sql) throws SQLException{
        return st.executeUpdate(sql);
    }

    public PreparedStatement getPstmt(){ return this.pstmt;}
}
