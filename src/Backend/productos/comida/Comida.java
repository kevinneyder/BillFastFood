package Backend.productos.comida;

import Backend.productos.Categoria;
import Backend.productos.Producto;

public abstract class Comida extends Producto {
    private int tiempoPreparacion;

    public Categoria getTipoComida() {
        return categoria;
    }

    private Categoria categoria;

    public Comida(String nombre, double precio, int tiempoPreparacion) {
        super(nombre, precio);
        this.tiempoPreparacion = tiempoPreparacion;
    }

    public Comida(String nombre, double precio) {
        super(nombre, precio);
    }

    public Comida(String nombre, double precio, String descripcion, int tiempoPreparacion) {
        super(nombre, precio, descripcion);
        this.tiempoPreparacion = tiempoPreparacion;
    }

    public int getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public void setTiempoPreparacion(int tiempoPreparacion) {
        this.tiempoPreparacion = tiempoPreparacion;
    }

    public void preparar(){}

}
