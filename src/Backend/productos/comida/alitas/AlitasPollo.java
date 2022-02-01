package Backend.productos.comida.alitas;

import Backend.productos.Categoria;
import Backend.productos.comida.Comida;

public class AlitasPollo extends Comida {
    private Salsa salsa;
    private Guarnicion guarnicion;
    private final Categoria categoria = Categoria.ALITAS;


    public AlitasPollo(String nombre, double precio, int tiempoPreparacion, Salsa salsa, Guarnicion guarnicion) {
        super(nombre, precio, tiempoPreparacion);
        this.salsa = salsa;
        this.guarnicion = guarnicion;
    }

    public AlitasPollo(String nombre, double precio, String descripcion, int tiempoPreparacion, Salsa salsa, Guarnicion guarnicion) {
        super(nombre, precio, descripcion, tiempoPreparacion);
        this.salsa = salsa;
        this.guarnicion = guarnicion;
    }

    public Salsa getSalsa() {
        return salsa;
    }

    public void setSalsa(Salsa salsa) {
        this.salsa = salsa;
    }

    public Guarnicion getGuarnicion() {
        return guarnicion;
    }

    public void setGuarnicion(Guarnicion guarnicion) {
        this.guarnicion = guarnicion;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
