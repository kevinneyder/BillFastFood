package Backend.productos.extra;

import Backend.productos.Categoria;
import Backend.productos.Producto;

public class ToppingExtra extends Producto {
    private String cantidad;

    public ToppingExtra(String nombre, double precio, String cantidad) {
        super(nombre, precio);
        this.cantidad = cantidad;
    }

    @Override
    public Categoria getCategoria() {
        return Categoria.TOPPING_EXTRAS;
    }
}
