package Backend.productos.comida.hamburguesa;

import Backend.productos.comida.Comida;
import Backend.productos.Categoria;

import java.util.ArrayList;

public class Hamburguesa extends Comida {
    private TipoCarne tipoCarne;
    private Topping[] toppings;
    private final Categoria categoria = Categoria.HAMBURGUESAS;

    public Hamburguesa(String nombre, double precio, TipoCarne tipoCarne, Topping[] toppings) {
        super(nombre, precio);
        this.tipoCarne = tipoCarne;
        this.toppings = toppings;
    }
    public Hamburguesa(String nombre, double precio, TipoCarne tipoCarne) {
        super(nombre, precio);
        this.tipoCarne = tipoCarne;
    }

    public Hamburguesa(String nombre, double precio, String descripcion, int tiempoPreparacion, TipoCarne tipoCarne) {
        super(nombre, precio, descripcion, tiempoPreparacion);
        this.tipoCarne = tipoCarne;
    }

    public TipoCarne getTipoCarne() {
        return tipoCarne;
    }

    public void setTipoCarne(TipoCarne tipoCarne) {
        this.tipoCarne = tipoCarne;
    }

    public Topping[] getToppings() {
        return toppings;
    }

    public void setToppings(ArrayList<Topping> toppings) {
        this.toppings = toppings.toArray(new Topping[0]);
    }



    public Hamburguesa preparar(String nombre, double precio, int tiempoPreparacion, TipoCarne tipoCarne) {
        return new Hamburguesa(nombre, precio, tipoCarne);
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
