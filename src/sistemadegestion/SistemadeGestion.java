
package sistemadegestion;

import java.time.LocalDate;
import java.util.Arrays;

public class SistemadeGestion {

    public static void main(String[] args) {
        GestorDeInventario gestor = new GestorDeInventario();

        // Crear proveedores
        Proveedor sony = new Proveedor("Sony");
        Proveedor dell = new Proveedor("Dell");
        Proveedor alimentacion = new Proveedor("Alimentacion");

        // Crear categorías
        Categoria electronica = new Categoria("Electronica");
        Categoria alimentos = new Categoria("Alimentos");

        // Agregar proveedores y categorías al gestor
        gestor.agregarProveedor(sony);
        gestor.agregarProveedor(dell);
        gestor.agregarProveedor(alimentacion);
        gestor.agregarCategoría(electronica);
        gestor.agregarCategoría(alimentos);

        // Crear y agregar productos electrónicos
        Producto tv = new ProductoElectronico("TV", 500.0, 3, sony, 24);
        Producto laptop = new ProductoElectronico("Laptop", 1000.0, 2, dell, 12);
        Producto smartphone = new ProductoElectronico("Smartphone", 800.0, 5, sony, 12);

        gestor.agregarProducto(tv);
        gestor.agregarProducto(laptop);
        gestor.agregarProducto(smartphone);

        // Crear y agregar productos alimenticios
        Producto pan = new ProductoAlimenticio("Pan", 2.0, 50, alimentacion, LocalDate.now().plusDays(5).toString());
        Producto leche = new ProductoAlimenticio("Leche", 1.5, 30, alimentacion, LocalDate.now().plusDays(10).toString());
        Producto queso = new ProductoAlimenticio("Queso", 5.0, 20, alimentacion, LocalDate.now().plusDays(15).toString());

        gestor.agregarProducto(pan);
        gestor.agregarProducto(leche);
        gestor.agregarProducto(queso);

        // Calcular precios
        CalculadorDePrecio calculadorConDescuento = new CalculadorDePrecioConDescuento(0.1); // 10% de descuento
        CalculadorDePrecio calculadorSinDescuento = new CalculadorDePrecioSinDescuento();

        double totalConDescuento = gestor.calcularPrecioTotal(calculadorConDescuento);
        double totalSinDescuento = gestor.calcularPrecioTotal(calculadorSinDescuento);

        // Calcular precios por categoría
        CalculadorDePrecio calculadorPorElectronica = new CalculadorDePrecioPorCategoria(electronica);
        CalculadorDePrecio calculadorPorAlimentos = new CalculadorDePrecioPorCategoria(alimentos);
        System.out.println("--------------------------------------");
        double totalPorElectronica = calculadorPorElectronica.calcularPrecioTotal(Arrays.asList(tv, laptop, smartphone));
        double totalPorAlimentos = calculadorPorAlimentos.calcularPrecioTotal(Arrays.asList(pan, leche, queso));

        // Mostrar detalles
        mostrarDetallesDelInventario(gestor);
        System.out.println("--------------------------------------");
        System.out.println("Precio total sin descuento: " + totalSinDescuento);
        System.out.println("Precio total con descuento: " + totalConDescuento);
        System.out.println("Precio total por categoria Electronica: " + totalPorElectronica);
        System.out.println("Precio total por categoria Alimentos: " + totalPorAlimentos);
        System.out.println("--------------------------------------");
    }

    private static void mostrarDetallesDelInventario(GestorDeInventario gestor) {
        System.out.println("Detalles del Inventario:");
        System.out.println("--------------------------------------");
        for (Producto producto : gestor.getProductos()) {
            System.out.println("Producto: " + producto.getNombre() + 
                               ", Precio por unidad: " + producto.getPrecio() +
                               ", Cantidad: " + producto.getCantidad() + 
                               ", Proveedor: " + producto.getProveedor().getNombre() + 
                               ", Detalles: " + producto.getDetalles());
            System.out.println("-----------------------------------------------------------------------------------------------");
        }
    }
}
