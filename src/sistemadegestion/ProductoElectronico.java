package sistemadegestion;

public class ProductoElectronico extends Producto {
    private int garantia; // en meses

    public ProductoElectronico(String nombre, double precio, int cantidad, Proveedor proveedor, int garantia) {
        super(nombre, precio, cantidad, proveedor);
        this.garantia = garantia;
    }

    @Override
    public String getDetalles() {
        return nombre + " (Electronico) - Precio: " + precio + ", Cantidad: " + cantidad + ", Garantia: " + garantia + " meses";
    }
}
