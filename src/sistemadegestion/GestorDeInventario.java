
package sistemadegestion;

import java.util.ArrayList;
import java.util.List;

public class GestorDeInventario {
    private List<Producto> productos;
    private List<Proveedor> proveedores;
    private List<Categoria> categorias;

    public GestorDeInventario() {
        this.productos = new ArrayList<>();
        this.proveedores = new ArrayList<>();
        this.categorias = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void agregarProveedor(Proveedor proveedor) {
        proveedores.add(proveedor);
    }

    public void agregarCategoría(Categoria categoria) {
        categorias.add(categoria);
    }

    public double calcularPrecioTotal(CalculadorDePrecio calculador) {
        return calculador.calcularPrecioTotal(productos);
    }
    public List<Producto> getProductos() {
    return productos;
}

}
