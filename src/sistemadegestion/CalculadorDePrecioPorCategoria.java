
package sistemadegestion;

import java.util.List;

public class CalculadorDePrecioPorCategoria implements CalculadorDePrecio {
    private Categoria categoria;

    public CalculadorDePrecioPorCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public double calcularPrecioTotal(List<Producto> productos) {
        double total = 0;
        for (Producto producto : categoria.getProductos()) {
            total += producto.getPrecio() * producto.getCantidad();
        }
        return total;
    }
}