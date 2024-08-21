
package sistemadegestion;

import java.util.List;

public class CalculadorDePrecioSinDescuento implements CalculadorDePrecio {
    @Override
    public double calcularPrecioTotal(List<Producto> productos) {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio() * producto.getCantidad();
        }
        return total;
    }
}