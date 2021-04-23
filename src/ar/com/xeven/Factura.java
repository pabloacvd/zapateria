package ar.com.xeven;

import java.util.ArrayList;
import java.util.List;

public class Factura {
    private int id;
    private String nombreCliente;
    private int precioTotal;
    private int cantidadItems;
    private List<Item> items = new ArrayList<>();

    public Factura() {
    }

    public Factura(String nombreCliente, int precioTotal, int cantidadItems) {
        this.nombreCliente = nombreCliente;
        this.precioTotal = precioTotal;
        this.cantidadItems = cantidadItems;
    }

    public Factura(int id, String nombreCliente, int precioTotal, int cantidadItems, List<Item> items) {
        this.id = id;
        this.nombreCliente = nombreCliente;
        this.precioTotal = precioTotal;
        this.cantidadItems = cantidadItems;
        this.items = items;
    }

    public Factura(int id, String nombreCliente, int precioTotal, int cantidadItems) {
        this.id = id;
        this.nombreCliente = nombreCliente;
        this.precioTotal = precioTotal;
        this.cantidadItems = cantidadItems;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(int precioTotal) {
        this.precioTotal = precioTotal;
    }

    public int getCantidadItems() {
        return cantidadItems;
    }

    public void setCantidadItems(int cantidadItems) {
        this.cantidadItems = cantidadItems;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "id=" + id +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", precioTotal=" + precioTotal +
                ", cantidadItems=" + cantidadItems +
                '}';
    }
}
