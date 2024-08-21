
package sistemadegestion;

import java.util.ArrayList;
import java.util.List;

public class Proveedor {
    private String nombre;
    private List<Producto> productos;

    public Proveedor(String nombre) {
        this.nombre = nombre;
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public String getNombre() {
        return nombre;
    }

    public List<Producto> getProductos() {
        return productos;
    }
}
