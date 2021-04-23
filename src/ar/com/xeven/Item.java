package ar.com.xeven;

public class Item {
    private int id;
    private int idFactura;
    private Producto producto;
    private int cantidad;
    private int precioSubtotal;

    public Item() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecioSubtotal() {
        return precioSubtotal;
    }

    public void setPrecioSubtotal(int precioSubtotal) {
        this.precioSubtotal = precioSubtotal;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", idFactura=" + idFactura +
                ", producto=" + producto +
                ", cantidad=" + cantidad +
                ", precioSubtotal=" + precioSubtotal +
                '}';
    }
}
