package Backend.productos.comida.pizza;

import Backend.productos.Categoria;
import Backend.productos.comida.Comida;

public class Pizza extends Comida {

    private Tamanio tamanio;
    private Tipo tipo;
    private final Categoria categoria = Categoria.PIZZAS;


    public Pizza(String nombre, double precio, int tiempoPreparacion, Tamanio tamanio, Tipo tipo) {
        super(nombre, precio, tiempoPreparacion);
        this.tamanio = tamanio;
        this.tipo = tipo;
    }

    public Pizza(String nombre, double precio, String descripcion, int tiempoPreparacion, Tamanio tamanio, Tipo tipo) {
        super(nombre, precio, descripcion, tiempoPreparacion);
        this.tamanio = tamanio;
        this.tipo = tipo;
    }


    public Tamanio getTamanio() {
        return tamanio;
    }

    public void setTamanio(Tamanio tamanio) {
        this.tamanio = tamanio;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
