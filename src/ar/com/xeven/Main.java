package ar.com.xeven;

public class Main {

    public static void main(String[] args) {

        //Producto nuevoProducto = new Producto("zapatos rojos", 15);
        //ProductoDAO.guardar(nuevoProducto);

        for(Producto p: ProductoDAO.getProductos())
            System.out.println(p);


    }
}
