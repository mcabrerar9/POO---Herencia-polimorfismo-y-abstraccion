
package sistemadegestion;

import java.util.List;

public class Descuento {
    private CalculadorDePrecio calculadorDePrecio;

    public Descuento(CalculadorDePrecio calculadorDePrecio) {
        this.calculadorDePrecio = calculadorDePrecio;
    }

    public double aplicarDescuento(List<Producto> productos) {
        return calculadorDePrecio.calcularPrecioTotal(productos);
    }
}
